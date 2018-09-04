/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yanzh
 */
public class CertificateNumberAction extends ActionSupport implements SessionAware {
    private static final String path = "/product/jsp/certNumber/";
    private Map<String, Object> session; 
   private String currentPath;
    private String prompt;
    private String message;
    private String title;
    private Integer index;
    private Boolean flag;
    private Boolean again;
    private String source;
    private TJgdm jgdm;
    private Page page;
    private String checkCfjl;
    private User user;
    private Date startDate;
    private Date endDate;
    List<TZsbhb> zsbhbs;
    List<TZs> zses;
    TZsbhb zsbhb;
    TZsbhb bh;
    TZs zs;

    Map<String, String> zrxzqhMap;

    public String certNumberPre() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                em.clear();
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 设置编号前缀");
                setMessage(null);
                currentPath = path + "certNumberPre.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 打印证书 输入编号
     *
     * @return
     */
    public String certNumberPreForPrint() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                em.clear();
                currentPath = path + "certNumberDialog.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 打印证书 输入编号
     *
     * @return
     */
    public synchronized String saveCertNumber() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                bh = em.find(TZsbhb.class, zsbhb.getId());
                em.clear();
                if (bh == null || "1".equals(bh.getFlag()) || bh.getSsbzjg() == null || !bh.getSsbzjg().trim().equals(user.getBzjgdm().trim())) {
                    source = "0";
                } else {
                    String djh = "组代管" + user.getBzjgdm() + "-" + zsbhb.getDjh() + ("1".equals(zsbhb.getId().getZslx()) ? index : "");
                    em.createQuery("update TZs set zsbh='" + zsbhb.getId().getZsbh() + "' where  djh='" + djh + "' and jgdm='" + zs.getJgdm() + "'").executeUpdate();
                    bh.setFlag("1");
                    bh.setDysj(new Date());
                    bh.setCzy(user.getUserName());
                    bh.setDjh(djh);
                    em.merge(bh);
                    em.flush();
                    source = "1";
                }
                currentPath = path + "certNumberDialog.jsp";
            }
        }.template();
    }

    public String certNumberPreSave() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                em.createQuery("update User set zsbhpre=:pre ,zsbhpreFb=:pre_fb where userId=:id")
                        .setParameter("pre", user.getZsbhpre()).setParameter("pre_fb", user.getZsbhpreFb())
                        .setParameter("id", user.getUserId()).executeUpdate();
                em.flush();
                user = em.find(User.class, user.getUserId());
                em.clear();
                session.put("sysUser", user);

                setMessage("证书编号前缀设置成功！");
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 设置编号前缀");
                currentPath = path + "certNumberPre.jsp";
            }
        }.template();
    }

    public String certNumber() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                zsbhbs = em.createQuery("select model from TZsbhb model where  model.id.zsbh='" + zsbhb.getId().getZsbh() + "'").getResultList();
                if (zsbhbs == null || zsbhbs.isEmpty())
                    throw new Exception("查询的数据不存在！");
                zsbhb = zsbhbs.get(0);
                currentPath = path + "certNumberShow.jsp";
            }
        }.nSyTemplate();
    }

    public String listCertNumbers() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                zrxzqhMap = new TreeMap<String, String>(
                        new Comparator<String>() {
                            public int compare(String obj1, String obj2) {
                                if (obj1 == null)
                                    return -1;
                                return obj1.compareTo(obj2);
                            }
                        }
                );
                Pattern p = Pattern.compile("(.*[1-9]+)");
                Matcher m = p.matcher(user.getBzjgdm());
                String filter = m.find() ? m.group() : user.getBzjgdm();
                for (Map.Entry<String, String> entry : InitSysParams.zrxzqhMap.entrySet()) {
                    if (entry.getKey().startsWith(filter)) {
                        zrxzqhMap.put(entry.getKey(), entry.getValue());
                    }
                }

                if (zsbhb == null) {
                    zsbhb = new TZsbhb();
                    zsbhb.setId(new TZsbhbId());
                    // zsbhb.setSsbzjg(user.getBzjgdm());

                }

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("fpsj");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "from TZsbhb model where 1=1 " +
                        (("*".equals(zsbhb.getFlag()) || zsbhb.getFlag() == null) ? "" : "and model.flag='" + zsbhb.getFlag() + "'");
                if (zsbhb.getId().getZsbh() != null) {
                    sql += "  and model.id.zsbh like  '%" + zsbhb.getId().getZsbh() + "%'";
                }
                if (zsbhb.getId().getZslx() != null && !"".equals(zsbhb.getId().getZslx())) {
                    sql += "  and model.id.zslx='" + zsbhb.getId().getZslx().trim() + "' ";
                }
                if (zsbhb.getSsbzjg() != null && !"".equals(zsbhb.getSsbzjg())) {
                    sql += "  and model.ssbzjg ='" + zsbhb.getSsbzjg().trim() + "' ";
                } else {
                    sql += "  and model.ssbzjg like '" + filter + "%'";
                }
                if (startDate != null) {
                    sql += " and model.fpsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.fpsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                zsbhbs = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model.id.zsbh) " + sql)

                        .getResultList().get(0)).intValue());
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书编号查询");
                currentPath = path + "certNumberSearch.jsp";
            }
        }.nSyTemplate();
    }

    public String listCertBook() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                zrxzqhMap = new TreeMap<String, String>(
                        new Comparator<String>() {
                            public int compare(String obj1, String obj2) {
                                if (obj1 == null)
                                    return -1;
                                return obj1.compareTo(obj2);
                            }
                        }
                );
                Pattern p = Pattern.compile("(.*[1-9]+)");
                Matcher m = p.matcher(user.getBzjgdm());
                String filter = m.find() ? m.group() : user.getBzjgdm();
                for (Map.Entry<String, String> entry : InitSysParams.zrxzqhMap.entrySet()) {
                    if (entry.getKey().startsWith(filter)) {
                        zrxzqhMap.put(entry.getKey(), entry.getValue());
                    }
                }

                if (zsbhb == null) {
                    zsbhb = new TZsbhb();
                    zsbhb.setId(new TZsbhbId());
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = " from TZs model where 1=1 ";
                if (zs != null && zs.getJgdm() != null && !"".equals(zs.getJgdm().trim())) {
                    sql += " and model.jgdm like '%" + zs.getJgdm().trim() + "%'";
                }
                if (zs != null && zs.getBzjgdm() != null && !"".equals(zs.getBzjgdm().trim())) {
                    sql += " and model.bzjgdm = '" + zs.getBzjgdm().trim() + "'";
                } else {
                    sql += " and model.bzjgdm like '" + filter + "%'";
                }


                if (zs != null && zs.getDjh() != null && !"".equals(zs.getDjh().trim())) {
                    sql += "  and model.djh like  '%" + zs.getDjh().trim() + "%'";
                }
                if (zsbhb.getId().getZsbh() != null) {
                    sql += "  and model.id.zsbh like  '%" + zsbhb.getId().getZsbh() + "%'";
                }
                if (startDate != null) {
                    sql += " and model.fzsj >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.fzsj < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                zses = em.createQuery("select model " + sql + orderBy)

                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model.lsh)  " + sql)
                        .getResultList().get(0)).intValue());
                if (zsbhbs == null || zsbhbs.isEmpty())
                    setMessage("根据当前查询条件查询不到结果，请重新输入！");
                else {
                }
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书编号修改");
                currentPath = path + "certNumberModify.jsp";
            }
        }.nSyTemplate();
    }

    public String certBook() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                zs = em.find(TZs.class, zs.getLsh());
                em.clear();
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 修改证书编号");
                currentPath = path + "certNumberEdit.jsp";
            }
        }.nSyTemplate();
    }

    public String saveCertBook() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TZs zs1 = em.find(TZs.class, zs.getLsh());
                String oldzsbh = zs1.getZsbh();
                if (zs.getZsbh() == null || zs.getZsbh().equals("")) {
                    zs1.setZsbh(null);
                    zs1.setLastdate(new Date());
                    em.merge(zs1);
                    zsbhbs = em.createQuery("select model from TZsbhb model where model.id.zsbh=:zsbh")
                            .setParameter("zsbh", oldzsbh).getResultList();

                    if (zsbhbs != null && !zsbhbs.isEmpty()) {
                        for (TZsbhb zsbhb1 : zsbhbs) {
                            zsbhb1.setFlag("0");
                            zsbhb1.setDjh(null);
                            zsbhb1.setDysj(null);
                            zsbhb1.setCzy(null);
                            em.merge(zsbhb1);
                        }
                    }
                    TCzjl czjl = new TCzjl();
                    czjl.setName(user.getUserName());
                    czjl.setType("W");
                    czjl.setDate(new Date());
                    czjl.setJgdm(zs.getJgdm());
                    czjl.setXzqh(user.getBzjgdm());
                    czjl.setMemo("已把旧编号" + (zs1.getZsbh() == null ? "" : ("(" + zs1.getZsbh() + ")")) + "置为“闲置”状态！");
                    setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书编号修改成功");
                    setMessage("修改成功，旧编号" + (zs1.getZsbh() == null ? "" : ("(" + zs1.getZsbh() + ")")) + "已被置为“闲置”状态！");
                    setSource("/bsweb/certificateNumber_listCertBook");
                    currentPath = path + "success.jsp";
                    return;
                } else {
                    zsbhbs = em.createQuery("select model from TZsbhb model where model.id.zsbh=:zsbh  and model.flag ='0' and model.id.zslx=:zslx and model.ssbzjg=:ssbzjg")
                    .setParameter("zsbh", zs.getZsbh()).setParameter("zslx", zs.getZstype()).setParameter("ssbzjg", user.getBzjgdm()).getResultList();
           if (zsbhbs != null && !zsbhbs.isEmpty() && zsbhbs.size() == 1) {
                        zsbhb = zsbhbs.get(0);
                        if (user.getBzjgdm().equals(zsbhb.getSsbzjg())) {
                            if (zs.getZsbh().equals(oldzsbh)) {
                                setMessage("不需要修改，新编号与原来的编号相同！");
                            } else if (!zs.getZstype().equals(zsbhb.getId().getZslx())) {
                                setMessage("不能完成修改，证书类型与编号类型不匹配，请核对后重新输入！");
                            } else {
                                if (oldzsbh == null || oldzsbh.equals("")) {
                                    TCzjl czjl = new TCzjl();
                                    czjl.setName(user.getUserName());
                                    czjl.setType("W");
                                    czjl.setDate(new Date());
                                    czjl.setJgdm(zs.getJgdm());
                                    czjl.setXzqh(user.getBzjgdm());
                                    czjl.setMemo("证书已设置新编号(" + zs.getZsbh() + ")！");
                                    setMessage("机构代码（" + zs1.getJgdm() + "）已设置新证书编号（" + zs.getZsbh() + "）！");

                                } else {
                                    List<TZsbhb> zsbhbList = em.createQuery("select model from TZsbhb model where model.id.zsbh=:zsbh and model.id.zslx=:zslx")
                                            .setParameter("zsbh", oldzsbh).setParameter("zslx", zs.getZstype()).getResultList();
                                    if (zsbhbList != null && !zsbhbList.isEmpty()) {
                                        for (TZsbhb zsbhb1 : zsbhbList) {
                                            zsbhb1.setFlag("0");
                                            zsbhb1.setDjh(null);
                                            zsbhb1.setDysj(null);
                                            zsbhb1.setCzy(null);
                                            em.merge(zsbhb1);
                                        }
                                    }
                                    TCzjl czjl = new TCzjl();
                                    czjl.setName(user.getUserName());
                                    czjl.setType("W");
                                    czjl.setDate(new Date());
                                    czjl.setJgdm(zs.getJgdm());
                                    czjl.setXzqh(user.getBzjgdm());
                                    czjl.setMemo("已把旧编号(" + oldzsbh + ")改为新编号(" + zs.getZsbh() + ")！");
                                    setMessage("机构代码（" + zs1.getJgdm() + "）已设置新证书编号（" + zs.getZsbh() + "），旧编号（" + oldzsbh + "）已被置为“闲置”状态！");
                                }
                                zsbhb.setFlag("1");
                                zsbhb.setDjh(zs1.getDjh());
                                zsbhb.setDysj(new Date());
                                zsbhb.setCzy(user.getUserName());
                                em.merge(zsbhb);
                                zs1.setZsbh(zs.getZsbh());
                                zs1.setFlag("1");
                                zs1.setLastdate(new Date());
                                em.merge(zs1);
                                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书编号修改成功");
                                setSource("/bsweb/certificateNumber_listCertBook");
                                currentPath = path + "success.jsp";
                                return;
                            }
                        } else {
                            setMessage("不能完成修改，您输入的新编号不属于当前办证机构，请到“证书编号查询”中查看详情！");
                        }
                    } else {
                        setMessage("不能完成修改，您输入的新编号已被占用或者不存在，请到“证书编号查询”中查看详情！");
                    }

                }
                em.flush();
                zs = em.find(TZs.class, zs.getLsh());
                em.clear();
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 修改证书编号");
                currentPath = path + "certNumberEdit.jsp";
            }
        }.template();
    }
    
    
    
    /**
     * @return
     * 证书损耗
     */
    public String ListSh(){
    	return new ActionUtils() {
			@Override
			protected void excute() throws Exception {
				 currentPath = path + "certNumberListSh.jsp";
				 User user = (User) session.get("sysUser");
	             zsbhbs = em.createQuery("select model from TZsbhb model where model.id.zsbh=:zsbh and model.id.zslx=:zslx")
                 .setParameter("zsbh", zs.getZsbh()).setParameter("zslx", zs.getZstype()).getResultList();
	             if (zsbhbs != null && !zsbhbs.isEmpty() && zsbhbs.size() == 1) {
	            	 zsbhb = zsbhbs.get(0);
	            	 if( "2".equals(zsbhb.getFlag())){
	            		 setMessage("此证书编号已被损耗，无需再次损耗！");
	            		// currentPath = path + "certNumberListSh.jsp";
	            		 return;
	            	 }else if(user.getBzjgdm().equals(zsbhb.getSsbzjg())) {
		            	 zsbhb.setFlag("2");
		            	 em.merge(zsbhb);
		            	 em.flush();
		            	 TCzjl czjl = new TCzjl();
		            	 czjl.setName(user.getUserName());
		            	 czjl.setType("W");
		            	 czjl.setDate(new Date());
		            	 czjl.setJgdm(zs.getJgdm());
		            	 czjl.setXzqh(user.getBzjgdm());
		                 setMessage("证书编号已损耗成功！");
		                 zs.setZsbh("");
		            	// currentPath = path + "certNumberListSh.jsp";
		            	 return;
	            	 }else{
		            	 setMessage("不能完成损耗，您输入的编号不属于当前办证机构，请到“证书编号查询”中查看详情！");
		             }
	             }else{
	            	 setMessage("您输入的编号不存在！");
	             }
			}
    	}.template();
    }
    

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getCheckCfjl() {
        return checkCfjl;
    }

    public void setCheckCfjl(String checkCfjl) {
        this.checkCfjl = checkCfjl;
    }


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
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

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public List<TZsbhb> getZsbhbs() {
        return zsbhbs;
    }

    public void setZsbhbs(List<TZsbhb> zsbhbs) {
        this.zsbhbs = zsbhbs;
    }

    public TZsbhb getZsbhb() {
        return zsbhb;
    }

    public void setZsbhb(TZsbhb zsbhb) {
        this.zsbhb = zsbhb;
    }

    public TZs getZs() {
        return zs;
    }

    public void setZs(TZs zs) {
        this.zs = zs;
    }

    public List<TZs> getZses() {
        return zses;
    }

    public void setZses(List<TZs> zses) {
        this.zses = zses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TZsbhb getBh() {
        return bh;
    }

    public void setBh(TZsbhb bh) {
        this.bh = bh;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getAgain() {
        return again;
    }

    public void setAgain(Boolean again) {
        this.again = again;
    }

    public Map<String, String> getZrxzqhMap() {
        return zrxzqhMap;
    }

    public void setZrxzqhMap(Map<String, String> zrxzqhMap) {
        this.zrxzqhMap = zrxzqhMap;
    }


}
