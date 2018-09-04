/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jdbc.business.system.clsProvinceBus;
import com.ninemax.jdbc.to.system.clsProvinceTO;
import com.ninemax.jpa.code.bus.NumberBus;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.OnLineVO;
import com.ninemax.jpa.code.model.vo.ZsbhsourceVO;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import java.util.*;

/**
 * @author Liuzy
 */
public class NumberAction extends ActionSupport implements SessionAware {
    private static final String path = "/product/jsp/codenumber/";
    private Map<String, Object> session;
    private clsProvinceBus provinceBus;
    private NumberBus numberBus;
    private String resultMsg = "";
    private String currentPath = "";
    private Integer flg = 0;

    private List<clsProvinceTO> pros;
    private List<TZsbhb> zsbhbs;
    private TZsbhsource zsSource;
    private List<TZsbhsource> zsSources;
    private ZsbhsourceVO zsVO;
    private clsPageComponent pages;

    private Page page;
    private Map<String, List<Model>> modelMaps;
    private List<Model> models;
    private Date startDate;
    private Date endDate;
    private TZsbhb zsbhb;
    private String message;
    private String source;
    private String xh;

    public NumberAction() {
        if (provinceBus == null)
            provinceBus = new clsProvinceBus();
        if (numberBus == null)
            numberBus = new NumberBus();
    }

    //直接分配编号
    public String preAddNum() {
        /*举例当前页面得到的 city ID*/
        User user = (User) session.get("sysUser");
        String bzjgdm = user.getBzjgdm();
        if (!clsStringTool.isEmpty(bzjgdm)) {
            //true为市级办证机构
            if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                pros = provinceBus.ListTwoAll(bzjgdm.substring(0, 4) + "00");
            } else
                pros = provinceBus.ListTwoAll(bzjgdm.substring(0, 2) + "0000");
        }
        currentPath = path + "number001.jsp";
        return this.SUCCESS;
    }

    //分配地市编号
    public String preAddDsNum() {
        /*举例当前页面得到的 city     ID*/

        User user = (User) session.get("sysUser");
        String bzjgdm = user.getBzjgdm();
        if (!clsStringTool.isEmpty(bzjgdm)) {
            //true为市级办证机构
            if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                pros = provinceBus.listSAll(bzjgdm.substring(0, 2) + "0000");

            } else
                pros = provinceBus.listSAll(bzjgdm.substring(0, 4) + "00");
        }
        currentPath = path + "number002.jsp";
        return this.SUCCESS;
    }

    //分配区县编号
    public String preAddQxNum() {
        User user = (User) session.get("sysUser");
        String bzjgdm = user.getBzjgdm();
        if (!clsStringTool.isEmpty(bzjgdm)) {
            if (provinceBus.isSjFlag(bzjgdm.substring(0, 4) + "00")) {
                pros = provinceBus.listQxAll(bzjgdm.substring(0, 2) + "0000");
            } else
                pros = provinceBus.listQxAll(bzjgdm.substring(0, 4) + "00");
        }
        currentPath = path + "number003.jsp";
        return this.SUCCESS;
    }

    public String addNum() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                resultMsg = "数据已成功保存！";
                String qsbh = zsSource.getQsbh();
                String jzbh = zsSource.getJzbh();
                String zsType = zsSource.getZstype();
                String ffBzjg = zsSource.getFpbzjg();

                List<TZsbhsource> datas = null;
                String strCxjg = "";
                String jql = "select md from TZsbhsource md where (('" + qsbh
                        + "' >= md.qsbh and '" + qsbh + "' <= md.jzbh) or ('"
                        + jzbh + "' >= md.qsbh and '" + jzbh
                        + "' <= md.jzbh) or ('" + qsbh + "' < md.qsbh and '" + jzbh
                        + "' > md.jzbh)) and md.zstype='" + zsType + "'";

                datas = em.createQuery(jql).getResultList();
                if (datas != null && datas.size() > 0) {
                    for (TZsbhsource zs : datas) {
                        String qsbh1 = zs.getQsbh();
                        String jzbh1 = zs.getJzbh();
                        strCxjg = strCxjg + "(" + qsbh1 + "--" + jzbh1 + ")、";
                    }

                    resultMsg = "输入新证书编号失败，原因：该编号(" + qsbh + "--" + jzbh + ")和证书编号源表中的编号" + strCxjg.substring(0, strCxjg.length() - 1) + "冲突！";
                    return;
                }
                zsSource.setLrsj(new Date());
                int zssl = CodePart.getZssl(qsbh, jzbh);
                zsSource.setZssl(zssl);
                zsSource.setFlag(false);
                em.persist(zsSource);
                String strQsbh = zsSource.getQsbh();
                int intMdsl = zsSource.getZssl();
                String strzsType = zsSource.getZstype();
                for (int j = 0; j < intMdsl; j++) {
                    String strFcMd = CodePart.bhAddOne(strQsbh, j);
                     TZsbhb _zsbh = new TZsbhb();
                    TZsbhbId id = new TZsbhbId();
                    id.setZsbh(strFcMd);
                    id.setZslx(strzsType);
                    _zsbh.setId(id);
                    _zsbh.setFlag("0");
                    if (flg == 1) {
                        _zsbh.setSsds(ffBzjg);
                    } else {
                        _zsbh.setSsbzjg(ffBzjg);
                        _zsbh.setSsds(ffBzjg.substring(0, 4) + "00");
                    }
                    _zsbh.setFpsj(new Date());
                     em.persist(_zsbh);
                }
                if (flg != 1) {
                    exe_zssl(zssl, ffBzjg, zsType);
                    exe_zssl(zssl, ffBzjg, "2");
                }
                em.flush();
                zsSource.setFlag(true);
                em.merge(zsSource);
            }

            private void exe_zssl(int zssl, String xzqh, String type) {
                List<TZssl> zssls = em.createQuery("select model from TZssl model where model.xzqh=:xzqh and model.type=:ztype")
                        .setParameter("xzqh", xzqh).setParameter("ztype", type).getResultList();
                if (zssls == null || zssls.isEmpty()) {
                    TZssl tZssl = new TZssl();
                    tZssl.setKcxx(1);
                    tZssl.setKcsx(9999);
                    tZssl.setKcsl(zssl);
                    tZssl.setXzqh(xzqh);
                    tZssl.setType(type);
                    em.persist(tZssl);
                } else {
                    TZssl tZssl = zssls.get(0);
                    tZssl.setKcsl(tZssl.getKcsl() + zssl);
                    em.merge(tZssl);
                }
            }
        }.template();
    }

    public String addQxNum() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                resultMsg = "数据已成功保存！";
                zsSource.setZssl(CodePart.getZssl(zsSource.getQsbh(), zsSource.getJzbh()));
                String xzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getXzqh();
                List<TZsbhb> zsbhbs = em.createQuery("select model from TZsbhb model where model.flag=:flag and  model.id.zsbh between :qsbh and :jzbh and model.id.zslx=:zslx and model.ssbzjg is null and model.ssds=:ssds order by model.id.zsbh ")
                        .setParameter("flag", "0").setParameter("ssds", xzqh).setParameter("zslx", zsSource.getZstype()).setParameter("qsbh", zsSource.getQsbh()).setParameter("jzbh", zsSource.getJzbh()).getResultList();
                if (zsbhbs == null || zsbhbs.isEmpty()) {
                    resultMsg = "分配证书编号错误，您输入的证书编号段(" + zsSource.getQsbh() + "-" + zsSource.getJzbh() + ")不在省中心分给您的可用证书编号中！";
                    return;
                }
                if (zsSource.getZssl() > zsbhbs.size()) {
                    resultMsg = "分配证书编号失败，您输入的证书编号段(" + zsSource.getQsbh() + "-" + zsSource.getJzbh() + ")中的部分数据已被占用或没有足够可用证书编号！";
                    return;
                }
                em.createQuery("update TZsbhb model set model.ssbzjg=:bzjg,model.fpsj=:fpsj where model.ssds =:ssds and model.ssbzjg is null and model.id.zslx=:zslx and model.id.zsbh between :qsbh and :jzbh")
                        .setParameter("bzjg", zsSource.getFpbzjg()).setParameter("fpsj", new Date()).setParameter("ssds", xzqh).setParameter("zslx", zsSource.getZstype()).setParameter("qsbh", zsSource.getQsbh())
                        .setParameter("jzbh", zsSource.getJzbh()).executeUpdate();
                exe_zssl(em, zsSource.getZssl(), zsSource.getFpbzjg(), zsSource.getZstype());
                exe_zssl(em, zsSource.getZssl(), zsSource.getFpbzjg(), "2");

            }
        }.template();
    }

    private void exe_zssl(EntityManager em, int zssl, String xzqh, String type) {
        List<TZssl> zssls = em.createQuery("select model from TZssl model where model.xzqh=:xzqh and model.type=:ztype")
                .setParameter("xzqh", xzqh).setParameter("ztype", type).getResultList();
        if (zssls == null || zssls.isEmpty()) {
            TZssl tZssl = new TZssl();
            tZssl.setKcxx(1);
            tZssl.setKcsx(9999);
            tZssl.setKcsl(zssl);
            tZssl.setXzqh(xzqh);
            tZssl.setType(type);
            em.persist(tZssl);
        } else {
            TZssl tZssl = zssls.get(0);
            tZssl.setKcsl(tZssl.getKcsl() + zssl);
            em.merge(tZssl);
        }
    }

    //区县证书编号列表
    public String qxList() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (zsbhb == null) {
                    zsbhb = new TZsbhb();
                    zsbhb.setId(new TZsbhbId());
                } else if (zsbhb.getId() == null) {
                    zsbhb.setId(new TZsbhbId());
                }
                if (zsSource == null) {
                    zsSource = new TZsbhsource();
                }

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("fpsj");
                    page.setOrderByType("desc");
                }
                User user = (User) session.get("sysUser");
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by zs." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TZsbhb zs where  zs.flag='0' and " + sql("zs.ssds") + " and  zs.ssbzjg is not null  ";
                if (!(zsSource.getFpbzjg() == null || "".equals(zsSource.getFpbzjg()))) {
                    sql += "  and zs.ssbzjg='" + zsSource.getFpbzjg() + "'";
                }

                if (!(zsSource.getQsbh() == null || "".equals(zsSource.getQsbh()))) {
                    sql += " and zs.id.zsbh>='" + zsSource.getQsbh() + "'";
                }
                if (!(zsSource.getJzbh() == null || "".equals(zsSource.getJzbh()))) {
                    sql += " and zs.id.zsbh<='" + zsSource.getJzbh() + "'";
                }
                if (startDate != null) {
                    sql += " and zs.fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and zs.fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                zsbhbs = em.createQuery("select zs " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(zs.id.zsbh) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath = path + "cancel.jsp";
            }

        }.nSyTemplate();

    }

    public String _cancel() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {

                TZsbhbId id;
                if (zsbhb == null || zsbhb.getId() == null)
                    throw new NullPointerException("证书编号输入为空！");
                zsbhb = em.find(TZsbhb.class, zsbhb.getId());
                zsbhb.setSsbzjg(null);
                zsbhb.setFpsj(null);
                em.merge(zsbhb);
                em.flush();
                message = "取消证书编号分配完成，您要取消的" + ("0".equals(zsbhb.getId().getZslx()) ? "正本" : "副本") + "证书编号(" + zsbhb.getId().getZsbh() + ")可以重新分配后再使用！";
                source = "qxList";
                currentPath = path + "success.jsp";
            }
        }.template();

    }

    //证书分配查询
    public String findNum() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (zsbhb == null) {
                    zsbhb = new TZsbhb();
                    zsbhb.setId(new TZsbhbId());
                } else if (zsbhb.getId() == null) {
                    zsbhb.setId(new TZsbhbId());
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("fpsj");
                    page.setOrderByType("desc");
                }
                String xzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getXzqh();
                String ds = InitSysParams.scCenterMap.get(xzqh);
                if (ds != null) {
                    ds = xzqh.substring(0, 2);
                } else {
                    ds = xzqh.substring(0, 4);
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by zs." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TZsbhb zs where  zs.ssds like '" + ds + "%' and  zs.ssbzjg is not null ";
                if (!(zsbhb.getId().getZsbh() == null || "".equals(zsbhb.getId().getZsbh()))) {
                    sql += "  and zs.id.zsbh like '%" + zsbhb.getId().getZsbh() + "%'";
                }
                if (!(zsbhb.getSsbzjg() == null || "".equals(zsbhb.getSsbzjg()))) {
                    sql += "  and zs.ssbzjg='" + zsbhb.getSsbzjg() + "'";
                }
                if (!(zsbhb.getFlag()== null || "".equals(zsbhb.getFlag()))) {
                    sql += "  and zs.flag='" + zsbhb.getFlag() + "'";
                }
                if (startDate != null) {
                    sql += " and zs.fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and zs.fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                zsbhbs = em.createQuery("select zs " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(zs.id.zsbh) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath = path + "findnumber.jsp";
            }

        }.nSyTemplate();
    }

    public String find_no_assign() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                if (zsbhb == null) {
                    zsbhb = new TZsbhb();
                    zsbhb.setId(new TZsbhbId());
                } else if (zsbhb.getId() == null) {
                    zsbhb.setId(new TZsbhbId());
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("fpsj");
                    page.setOrderByType("desc");
                }

                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by zs." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TZsbhb zs where  " + sql("zs.ssds") + " and  zs.ssbzjg is null ";
                if (!(zsbhb.getId().getZsbh() == null || "".equals(zsbhb.getId().getZsbh()))) {
                    sql += "  and zs.id.zsbh like '%" + zsbhb.getId().getZsbh() + "%'";
                }
                if (startDate != null) {
                    sql += " and zs.fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and zs.fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                zsbhbs = em.createQuery("select zs " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(zs.id.zsbh) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath = path + "find_no_assign.jsp";
            }

        }.nSyTemplate();
    }

    /**
     * 统计时间段内行政区划每个业务的业务量
     *
     * @return
     */
    public String countNumber() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                //TODO
                User user = (User) session.get("sysUser");

                String xzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getXzqh();
                String ds = InitSysParams.scCenterMap.get(xzqh);
                if (ds != null) {
                    ds = xzqh.substring(0, 2);
                } else {
                    ds = xzqh.substring(0, 4);
                }
                modelMaps = new HashMap<String, List<Model>>();
                models = new ArrayList<Model>();
                String sql = "select ssds,ssbzjg,zslx,count(1) as num from t_zsbhb where ssds like '" + ds + "%'";
                if (startDate != null) {
                    sql += " and fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                List<Object[]> cs = em.createNativeQuery(sql + " group by ssds,ssbzjg,zslx order by ssbzjg,ssds")
                        .getResultList();
                String bzjg;
                for (Object[] objects : cs) {
                    if (objects[0] == null) {
                        continue;
                    }
                    Model model = new Model();
                    bzjg = objects[0].toString();
                    model.setColumn1(objects[1] == null ? "xxxx" : objects[1].toString());
                    model.setColumn2(objects[2] == null ? "xxxx" : objects[2].toString());
                    model.setCount1(objects[3] == null ? 0 : Integer.valueOf(objects[3].toString()));
                    if (modelMaps.containsKey(bzjg + "")) {
                        models = modelMaps.get(bzjg + "");
                    } else {
                        models = new ArrayList<Model>();
                    }
                    models.add(model);
                    modelMaps.put(bzjg + "", models);
                }

                currentPath = path + "count.jsp";
            }
        }.nSyTemplate();
    }
    
    /**
     * 证书-->分配编号统计
     * @author Tengwuchao 2014-05-06
     * @return 
     */
    public String listNumberTj() {
    	return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
            	if(zsSource==null){
            	zsSource=new TZsbhsource();
            	}
            	if(page==null){
            		page=new Page();
            	}
            	if(zsSources==null){
            		zsSources=new ArrayList<TZsbhsource>();
            	}
            	
                String orderBy = " Order By lrsj";
                String sql = " from  t_zsbhsource zs where  zs.flag='1' ";
				if (!(zsSource.getFpbzjg() == null || "".equals(zsSource.getFpbzjg()))) {
                    sql += "  and zs.fpbzjg like '%" + zsSource.getFpbzjg() + "%'";
                }
				if (!(zsSource.getZstype() == null || "".equals(zsSource.getZstype()))) {
					sql += "  and zs.zstype = '" + zsSource.getZstype() + "'";
				}
                if (startDate != null) {
                    sql += " and zs.lrsj >= '"+ DateUtil.dateToStr(startDate) + "'  ";
               }
                if (endDate != null) {
                   sql += " and zs.lrsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1))+ "'  ";
               }
				List<Object[]> gsList = em.createNativeQuery("select * " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
				
				if (gsList != null && gsList.size() > 0) {
	                for(Object[] objects: gsList){
	                	TZsbhsource zs=new TZsbhsource();
	                	zs.setQsbh(objects[1] == null ? "" : objects[1].toString());
	                	zs.setJzbh(objects[2] == null ? "" : objects[2].toString());
	                	zs.setZssl(Integer.parseInt(objects[3].toString()));
	                	zs.setZstype(objects[4]==null?"":objects[4].toString());
	                	zs.setFpbzjg(objects[5]==null?"":objects[5].toString());
	                	zs.setLrsj(DateUtil.getFormatedDate(objects[7].toString()));
	                    zsSources.add(zs);
	                }
	            }
				
                page.setTotalRecord((Integer)em.createNativeQuery("select count(xh) " + sql).getResultList().get(0));
                currentPath = path + "listNumberTj.jsp";
            }

        }.nSyTemplate();
    }
    /**
     * 证书-->编号删除列表
     * @author Tengwuchao 2014-05-06
     * @return 
     */
    public String listDel() {
    	return new ActionUtils() {
    		@Override
    		protected void excute() throws Exception {
    			if(zsSource==null){
    				zsSource=new TZsbhsource();
    			}
    			if(page==null){
    				page=new Page();
    			}
    			if(zsSources==null){
    				zsSources=new ArrayList<TZsbhsource>();
    			}
    			
    			String orderBy = " Order By lrsj";
    			String sql = " from  t_zsbhsource zs where  zs.flag='1' ";
    			if (!(zsSource.getFpbzjg() == null || "".equals(zsSource.getFpbzjg()))) {
    				sql += "  and zs.fpbzjg like '%" + zsSource.getFpbzjg() + "%'";
    			}
    			if (!(zsSource.getZstype() == null || "".equals(zsSource.getZstype()))) {
    				sql += "  and zs.zstype = '" + zsSource.getZstype() + "'";
    			}
    			if (startDate != null) {
    				sql += " and zs.lrsj >= '"+ DateUtil.dateToStr(startDate) + "'  ";
    			}
    			if (endDate != null) {
    				sql += " and zs.lrsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1))+ "'  ";
    			}
    			List<Object[]> gsList = em.createNativeQuery("select * " + sql + orderBy)
    			.setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
    			.getResultList();
    			
    			if (gsList != null && gsList.size() > 0) {
    				for(Object[] objects: gsList){
    					TZsbhsource zs=new TZsbhsource();
    					zs.setXh((Integer)objects[0]);
    					zs.setQsbh(objects[1] == null ? "" : objects[1].toString());
    					zs.setJzbh(objects[2] == null ? "" : objects[2].toString());
    					zs.setZssl((Integer)objects[3]);
    					zs.setZstype(objects[4]==null?"":objects[4].toString());
    					zs.setFpbzjg(objects[5]==null?"":objects[5].toString());
    					zs.setLrsj(DateUtil.getFormatedDate(objects[7].toString()));
    					zsSources.add(zs);
    				}
    			}
    			
    			page.setTotalRecord((Integer)em.createNativeQuery("select count(xh) " + sql).getResultList().get(0));
    			currentPath = path + "listDel.jsp";
    		}
    		
    	}.nSyTemplate();
    }
    //证书删除
    public String numberDel() {
    	return new ActionUtils() {
    		@Override
    		protected void excute() throws Exception {
    			
    			TZsbhsource zs = em.find(TZsbhsource.class, Integer.valueOf(xh));
    			em.remove(zs);
    			String sql = "delete  from  t_zsbhb where  zsbh>= '"+zs.getQsbh() +"' and zsbh<= '"+zs.getJzbh()+"' and zslx='"+zs.getZstype()+"' and flag ='0'";
    			em.createNativeQuery(sql).executeUpdate();
    			resultMsg="删除证书编号"+zs.getQsbh()+"~"+zs.getJzbh()+"成功";
    			currentPath = "/bsweb/numberlistDel";
    		}
    		
    	}.template();
    }

    public String editNum() {
        if (zsVO != null)
            resultMsg = numberBus.editNumber(zsVO);

        return this.SUCCESS;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public List<clsProvinceTO> getPros() {
        return pros;
    }

    public void setPros(List<clsProvinceTO> pros) {
        this.pros = pros;
    }

    public TZsbhsource getZsSource() {
        return zsSource;
    }

    public void setZsSource(TZsbhsource zsSource) {
        this.zsSource = zsSource;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public List<TZsbhb> getZsbhbs() {
        return zsbhbs;
    }

    public void setZsbhbs(List<TZsbhb> zsbhbs) {
        this.zsbhbs = zsbhbs;
    }

    public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
    }

    public ZsbhsourceVO getZsVO() {
        return zsVO;
    }

    public void setZsVO(ZsbhsourceVO zsVO) {
        this.zsVO = zsVO;
    }

    public Map<String, List<Model>> getModelMaps() {
        return modelMaps;
    }

    public void setModelMaps(Map<String, List<Model>> modelMaps) {
        this.modelMaps = modelMaps;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TZsbhb getZsbhb() {
        return zsbhb;
    }

    public void setZsbhb(TZsbhb zsbhb) {
        this.zsbhb = zsbhb;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

	public List<TZsbhsource> getZsSources() {
		return zsSources;
	}

	public void setZsSources(List<TZsbhsource> zsSources) {
		this.zsSources = zsSources;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}
    
}
