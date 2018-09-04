/**
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jdbc.business.system.NumberToCN;
import com.ninemax.jpa.code.bus.TCflxBus;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.nacao.util.clsStringTool;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yanzh
 */
public class CertificatePrintAction extends CommonJgdmAction {
    private static final String path = "/product/jsp/certPrint/";
    private String prompt;
    private String checkCfjl;
    private Date startDate;
    private Date endDate;
    private Certi certi;
    //处罚记录
    private Map<String, String> cflxs;
    protected List<TCfjlb> cfjlbList = null;
    private TCfjlb cfjl;
    private String sqlwhere;
    private String order;
    private User user;

    private Map<String,String> orgs;
    private String orgMes;
    private List<NoticeLog>  notList;
    private String opJglx;
    private List<TFzr> listFzr;
    private String isdy;
    private String jglx;
    TJgdmSaveBus saveBus;
    public CertificatePrintAction() {
    	saveBus=new TJgdmSaveBus();
    }

    public String search() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                excutec();
            }
        }.template();
    }

    private void excutec() {
        certi = new Certi();
        if ("1".equals(source)) {
            title = "发证 &gt;&gt; 证书打印 &gt;&gt; 代码证书打印查询";
            currentPath = "/bsweb/certificatePrint_list_no_print";
            setSource("zb_info");
            certi.setType("0");
        } else if ("2".equals(source)) {
            title = "发证 &gt;&gt; 证书打印 &gt;&gt; 校对单打印";
            currentPath = path + "search.jsp";
            setSource("verify_invoice");
        } else if ("3".equals(source)) {
            title = "发证 &gt;&gt; 证书打印 &gt;&gt; 打印证书副本";
            setPrompt("注：当证书挂失后，需要补发时，不可由此打印，可以用“代码证书打印”菜单打印。");
            currentPath = path + "search.jsp";
            certi.setType("3");
            setSource("fb_info");
        } else if ("4".equals(source)) {
            title = "发证 &gt;&gt; 证书打印 &gt;&gt; 打印证书副本";
            currentPath = path + "search.jsp";
            setSource("simple_verify_invoice");
            //_url = "fb_info.jsp";
        } else if ("5".equals(source)) {
            title = "发证 &gt;&gt; 证书打印 &gt;&gt; 特殊证书打印";
            currentPath = path + "search.jsp";
            setPrompt("该功能仅用于正常打印证书时没有打印出证书时使用，信息保持跟原来一致！");
            setSource("special_info");
            certi.setType("5");
        } else if ("6".equals(source)) {
            title = "发证 &gt;&gt; 证书打印 &gt;&gt; 申报表打印";
            currentPath = path + "search.jsp";
            setSource("apply_info");
            certi.setType("6");
        }
    }

    public String verify_invoice() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TJgdm dm = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();
                jgdm = dm;
                title = "发证 &gt;&gt; 证书打印 &gt;&gt; 校对单打印";
                currentPath = path + "verify_invoice.jsp";
            }
        }.template();
    }

    /**
     * 校对表简表
     *
     * @return
     */
    public String simple_verify_invoice() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TJgdm dm = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();
                jgdm = dm;
                title = "发证 &gt;&gt; 证书打印 &gt;&gt; 校对单简表打印";
                currentPath = path + "simple_verify_invoice.jsp";
            }
        }.template();
    }



    /**
     * 申报表打印
     *
     * @return
     */
    public String apply_info() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TJgdm dm = null;
                if (jgdm != null && jgdm.getJgdm() != null && jgdm.getJgdm().trim().length() == 9)
                    dm = em.find(TJgdm.class, jgdm.getJgdm());
                else if (jgdm != null && jgdm.getJgdm() != null && jgdm.getJgdm().trim().length() > 0) {
                    TJgdmSave save = em.find(TJgdmSave.class, Integer.valueOf(jgdm.getJgdm().trim()));
                    dm = new TJgdm();
                    BeanUtilsEx.copyProperties(dm, save);
                    dm.setLastdate(save.getBzrq());
                }
                em.clear();
                //机构代码表
                if (dm == null) {
                    setSource("6");
                    excutec();
                    return;
                } else {
                    jgdm = dm;
                    if (!user.getUserName().contains("admin") && !jgdm.getBzjgdm().equals(user.getBzjgdm())) {
                        setMessage("机构代码(" + jgdm.getJgdm() + ")不属于本办证机构管辖，请到（" + InitSysParams.zrxzqhMap.get(jgdm.getBzjgdm()) + "）处办理业务!");
                        setSource("6");
                        excutec();
                        return;
                    }
                }
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 申报表打印");
                currentPath = path + "apply_info.jsp";
            }
        }.nSyTemplate();
    }

    public String zb_info() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());

                if (dm == null) {
                    setSource("1");
                    message="不存在此数据！";
                    String jglx=jgdm.getTyshxydm().substring(1,2);
                    currentPath = path + ("1".equals(jglx)?"shetuan":"2".equals(jglx)?"minfei":"jijinhui")+"_search_dm.jsp";
                    return;
                }
                if("1".equals(isdy)){
                	if(!"1".equals(dm.getDybz())){
                    	setSource("1");
                        message="证书未打印不能进行该操作！";
                        String jglx=jgdm.getTyshxydm().substring(1,2);
                        currentPath = path + ("1".equals(jglx)?"shetuan":"2".equals(jglx)?"minfei":"jijinhui")+"_search_dm.jsp";
                        return;
                    }
                }
                
                listFzr=saveBus.fzrList(em,jgdm.getTyshxydm());		
                jgdm=dm;
                jglx=dm.getJglx();
                jgdm.setJyfw(jgdm.getJyfw().replaceAll("\r|\n", "").trim());
                NumberToCN cn=new NumberToCN();
                BigDecimal numberOfMoney = new BigDecimal(jgdm.getZczj()*10000);
                String jglx="1".equals(dm.getJglx())?"社会团体业务":"2".equals(dm.getJglx())?"民办非企业单位业务":"基金会业务";
                jgdm.setMemo5( cn.number2CNMontrayUnit(numberOfMoney));
                setTitle("登记 &gt;&gt; 证书打印 &gt;&gt; 代码证书打印信息");
                currentPath = path + "zb_info.jsp";
            }
        }.template();
    }
    
   
    public String zb_print() {
        return new ActionUtils(session) {
            @Override
            protected synchronized void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());
                if (dm == null){
                    throw new Exception("统一代码（" + jgdm.getTyshxydm()+ ")有误，请联系管理员");
                }
                dm.setDybz("1");
                em.merge(dm);
                TCzjl  czjl = new TCzjl();
                czjl.setTyshxydm(dm.getTyshxydm());
                String jglx="1".equals(dm.getJglx())?"社团":"2".equals(dm.getJglx())?"民非":"基金会";
                czjl.setMemo(jglx+"打印证书");
                czjl.setName(user.getUserName());
                czjl.setType("M");
                czjl.setDate(new Date());
                czjl.setXzqh(user.getBzjgdm());
                em.persist(czjl);
                
                HttpServletResponse response = ServletActionContext.getResponse();
                PrintWriter writer = response.getWriter();
                writer.print("ok");
    			writer.flush();
    			writer.close();
                //currentPath = path + "zb_print.jsp";
            }
        }.template();
    }
    

    /**
     * 证书打印测试
     *
     * @return
     */
    public String print_test() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (certi == null) {
                    certi = new Certi();
                }
                certi.setFrdbMc(frmc("1"));
                certi.setFrdbValue("张法人");
                certi.setJgdm("00000000");
                certi.setJgmc("测试数据机构名称");
                certi.setJglx("1");
                certi.setBzjgdm(user.getBzjgdm());
                certi.setJgdz("测试数据机构地址");
                certi.setYxq("自" + DateUtil.dateToStr(new Date(), "yyyy年MM月dd日") + "至" + DateUtil.dateToStr(new Date(), "yyyy年MM月dd日"));
                certi.setDjh("组代管" + user.getBzjgdm() + "-0000000");
                certi.setQRCode("00000000;测试数据机构名称;测试数据机构地址");
                certi.setTsxx1("测试数据证书提示信息一");
                certi.setTsxx2("测试数据证书提示信息二");
                certi.setTsxx3("测试数据证书提示信息三");
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书打印测试");
                currentPath = path + "print_test.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 证书特殊打印
     *
     * @return
     */
    public String print_set() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (user == null) {
                    user = (User) session.get("sysUser");
                    user = em.find(User.class, user.getUserId());
                    em.clear();
                } else {
                    User user1 = em.find(User.class, user.getUserId());
                    user1.setOffsetx(user.getOffsetx());
                    user1.setOffsety(user.getOffsety());
                    user1.setPrintName(user.getPrintName());
                    em.merge(user1);
                    em.flush();
                    user = user1;
                    session.put("sysUser", user);
                    setMessage("证书打印设置成功！");
                }
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书打印设置");
                currentPath = path + "print_set.jsp";
            }
        }.template();
    }

  
   
  

    public String list_prints() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm());
                if (jgdm == null) {
                    jgdm = new TJgdm();
                }

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                if (zrxzqh != null && "1".equals(zrxzqh.getFzflag())) {
                    String sql = " from TJgdm model where  " + sql() + "  and model.dybz <> '1' and model.jgdm not in (select model.jgdm from TSp model where  model.flag <> '2')";
                    if (jgdm.getJgdm() == null || "".equals(jgdm.getJgdm())) {
                        if (startDate != null) {
                            sql += " and model.lastdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                        }
                        if (endDate != null) {
                            sql += " and model.lastdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                        }
                    }
                    else {
                        sql += " and model.jgdm like '" + jgdm.getJgdm() + "%' ";
                    }

                    jgdms = em.createQuery("select model " + sql + orderBy)
                            .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
                    page.setTotalRecord(((Long) em.createQuery("select count(model)  " + sql)
                            .getResultList().get(0)).intValue());
                    if (jgdms == null || jgdms.isEmpty())
                        setMessage("当前办证区间内，不存在需要打证的机构！");

                } else {
                    setMessage("当前登录用户没有打证权限！");
                }
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 批量打印证书");
                currentPath = path + "list_prints.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 未打印数据检索
     *
     * @return String
     */
    public String list_no_print() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                //TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm());
                if (jgdm == null) {
                    jgdm = new TJgdm();
                }

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                    String sql = " from TJgdm model where  " + sql() + "  and model.dybz = '0' and model.jglx='"+opJglx+"'";
                    if (jgdm.getJgdm() == null || "".equals(jgdm.getJgdm())) {
                        if (startDate != null) {
                            sql += " and model.lastdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                        }
                        if (endDate != null) {
                            sql += " and model.lastdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                        }
                    } else {
                        sql += " and model.tyshxydm like '%" + jgdm.getTyshxydm() + "%' ";
                    }
                    
                    if (jgdm.getTyshxydm() != null && !"".equals(jgdm.getTyshxydm())) {
                  	  sql += " and model.tyshxydm like '%" + jgdm.getTyshxydm() + "%' ";
                     }
                    jgdms = em.createQuery("select model " + sql + orderBy)
                            .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
                    page.setTotalRecord(((Long) em.createQuery("select count(model)  " + sql)
                            .getResultList().get(0)).intValue());
                    if (jgdms == null || jgdms.isEmpty())
                        setMessage("当前办证区间内，不存在需要打证的机构！");

                setTitle("登记 &gt;&gt; "+("1".equals(opJglx)?"社会团体业务":"2".equals(opJglx)?"民办非企业单位业务":"基金会业务")+" &gt;&gt; 证书打印");
                currentPath = path + "list_no_print.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 未打印数据检索
     */
    public String list_has_print() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm == null) {
                    jgdm = new TJgdm();
                }

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TJgdm model where  " + sql() + "  and model.dybz='1'";
                if (jgdm.getJgdm() == null || "".equals(jgdm.getJgdm())) {
                    if (startDate != null) {
                        sql += " and model.lastdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                    }
                    if (endDate != null) {
                        sql += " and model.lastdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                    }
                } else {
                    sql += " and model.jgdm like '%" + jgdm.getJgdm() + "%' ";
                }

                jgdms = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model)  " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 已打印证书查询");
                currentPath = path + "list_has_print.jsp";
            }
        }.nSyTemplate();
    }
    
    
   /**
    * 证书打印查询
    * @return
    */
    public String list_zscx_print(){
    	return new ActionUtils(session) {
    		@Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (tzs == null) {
                	tzs = new TZs();
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("yxq");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TZs model where  " + sql() + "";
                if (tzs.getJgdm() != null || "".equals(tzs.getJgdm())) {
                	sql += " and model.jgdm like '%" + tzs.getJgdm() + "%' ";
                } 
                if (tzs.getJgmc() != null || "".equals(tzs.getJgmc())){
                	sql += " and model.jgmc like '%" + tzs.getJgmc() + "%' ";
                }
                tzss = em.createQuery("select model " + sql + orderBy)
                .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                .getResultList();
		        page.setTotalRecord(((Long) em.createQuery("select count(model)" + sql)
		                .getResultList().get(0)).intValue());
		        setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 打印证书查询");
		        currentPath = path + "list_zscx_print.jsp";
		        em.clear();
    		}
    	}.nSyTemplate();
    }
    
    /**
     * 证书统计查询
     * @return
     */
    public String list_zstj_print(){
    	return new ActionUtils(session) {
    		@Override
            protected void excute() throws Exception {
    			User user = (User) session.get("sysUser");
    			if (tcjl == null) {
    				tcjl = new TCzjl();
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("date");
                    page.setOrderByType("desc");
                }
                String sql = " from t_czjl model where model.type in('M','M1','M2','M3','M4') and " +sqlse()+ "";
                if (tcjl.getJgdm() == null || "".equals(tcjl.getJgdm())) {
                	 if (startDate != null) {
                         sql += " and model.date >= '" + DateUtil.dateToStr(startDate) + "'  ";
                     }
                     if (endDate != null) {
                         sql += " and model.date < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                     }
                }
                
                List<Object []> czjls=   em.createNativeQuery ("select model.xzqh, " +
	                 		"sum(case model.type when'M' then 1 else 0 end) M," +
	                 		"sum(case model.type when'M1' then 1 else 0 end) M1," +
	                 		"sum(case model.type when'M2' then 1 else 0 end) M2," +
	                 		"sum(case model.type when'M3' then 1 else 0 end) M3," +
	                 		"sum(case model.type when'M4' then 1 else 0 end) M4 " + sql+" group by model.xzqh")
                .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                .getResultList();
                tCzjls = new ArrayList<TCzjl>();
                for(Object [] objs:czjls){
                	TCzjl czjl=new TCzjl();
            	   tCzjls.add(czjl);
            	   czjl.setKlsh(Long.parseLong(objs[0]+""));
            	   czjl.setJgdm(objs[1].toString());
            	   czjl.setType(objs[2].toString());
            	   czjl.setMemo(objs[3].toString());
            	   czjl.setName(objs[4].toString());
            	   czjl.setXzqh(objs[5].toString());
            	   
                }
		        page.setTotalRecord(((Integer) em.createNativeQuery("select count(1) from(select 1 as b" + sql +"group by model.xzqh"+")"+"as a")
		                .getResultList().get(0)).intValue());
		        setTitle("发证 &gt;&gt; 证书打印 &gt;&gt; 证书打印数量");
		        currentPath = path + "list_zstj_print.jsp";
		        em.clear();
    		}
    	}.nSyTemplate();
    }
    
    public String getSqlwhere() {
        return sqlwhere;
    }

    public void setSqlwhere(String sqlwhere) {
        this.sqlwhere = sqlwhere;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCheckCfjl() {
        return checkCfjl;
    }

    public void setCheckCfjl(String checkCfjl) {
        this.checkCfjl = checkCfjl;
    }

    public List<TCfjlb> getCfjlbList() {
        return cfjlbList;
    }

    public void setCfjlbList(List<TCfjlb> cfjlbList) {
        this.cfjlbList = cfjlbList;
    }

    private String frmc(String jglx) {
    	if(opJglx!=null&&!"".equals(opJglx)){
    		return opJglx;
    	}
        if ("1357C".contains(jglx)){
        	
        	return "法定代表人";
        }
        return "负责人";
    }

    protected boolean chufa(EntityManager em) {
        if (checkCfjl == null || !"no".equals(checkCfjl)) {
            cfjlbList = em.createQuery("select model from TCfjlb model where model.jgdm='" + jgdm.getJgdm() + "' and model.cfbz=false").getResultList();
            if (cfjlbList != null && !cfjlbList.isEmpty()) {
                source = "change_" + source;
                currentPath = path + "../common/cflb.jsp";
                return true;
            }
        }
        return false;
    }

    //新办处罚跳到处罚页面
    protected boolean newChuFa(EntityManager em) {
        cfjlbList = em.createQuery("select model from TCfjlb model where model.jgdm='" + jgdm.getJgdm() + "' and model.cfbz=false").getResultList();
        if (cfjlbList != null && !cfjlbList.isEmpty()) {
            cfjl = cfjlbList.get(0);
            cflxs = new TCflxBus().getMap();
            setTitle("处罚 &gt;&gt; 违规处罚管理 &gt;&gt; 违规处罚");
            currentPath = path + "../punish/punish.jsp";
            return true;
        }
        return false;
    }


    //添加机构类型打印控制
	public String add(){
		 return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				orgType.setId(1);
				//em.persist(orgType);
				em.merge(orgType);
				em.close();
				title="ok";
				InitSysParams.getInstance().orgs.clear();
				Map<String, String> map = new HashMap<String, String>();
				
				map.put("1", orgType.getOrg1());
	            map.put("2", orgType.getOrg2());
	            map.put("3", orgType.getOrg3());
	            map.put("4", orgType.getOrg4());
	            map.put("5", orgType.getOrg5());
	            map.put("6", orgType.getOrg6());
	            map.put("7", orgType.getOrg7());
	            map.put("8", orgType.getOrg8());
	            map.put("9", orgType.getOrg9());
	            map.put("A", orgType.getOrg10());
	            map.put("B", orgType.getOrg11());
	            map.put("C", orgType.getOrg12());
				InitSysParams.getInstance().orgs=map;
				
				currentPath =  "/product/jsp/certPrint/orgType.jsp";
				
			}
			 
		 }.nSyTemplate();
		
		
		
	}
	
	
	/**
	 * 通知结果显示
	 * @return
	 */
	public String notice(){
		
		 return new ActionUtils() {

			@Override
			protected void excute() throws Exception {
				String sql = " select model from TJgdm model   where 1=1" ;
				 if (selJgdm != null && !"".equals(selJgdm)) {
	                    sql += " and model.jgdm ='" + selJgdm + "'";
	                }
	                if (mc != null && !"".equals(mc)){
	                    sql += " and model.jgmc like '%" + mc + "%'";
	                }
				jgdms = em.createQuery(sql).getResultList();
		         
				orgMes="ok";
				if (jgdms != null && !jgdms.isEmpty()) {
		            jgdm = jgdms.get(0);
		       
		        	
		        List<NoticeLog> list = em.createQuery("select model from NoticeLog model  order by nid desc").getResultList();
		        
		    	if (list != null && !list.isEmpty()) {
		    		title = list.get(0).getId().toString();
		            
		    		title=clsStringTool.getLsh(title, "0", 7);
		        }else{
		        	title="0";
		        }
		        java.text.SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String date = sd.format(new Date());
		        //记录日志
		        User user = (User) session.get("sysUser");
		        Date newDate = new Date();
		        NoticeLog notLog=new NoticeLog();
		        notLog.setSelDw(jgdm.getJgmc());
		        notLog.setSelSer(title);
		        notLog.setSelPeople(user.getBzjgdm());
		        notLog.setSelTime(date);
		        em.merge(notLog);
		        em.close();	
		        }else{
		        	orgMes="no";
		        }
		    
		        
		        
		        currentPath = "/product/jsp/requisition/noticeSel.jsp";
			}
			
			 
		 }.template();
		 }
	/**
	 * 查询机构类型打印控制
	 */
	private OrgTypeMes orgType;
	public String sel(){
		 return new ActionUtils() {

				@Override
				protected void excute() throws Exception {
					//String nameQuery = "select model from TSp model where id='1'";

					//List<OrgTypeMes> list =  em.createQuery(nameQuery).getResultList();
					//orgType=list.get(0);
					orgType=em.find(OrgTypeMes.class, 1);
					currentPath =  "/product/jsp/certPrint/orgType.jsp";
				}
				 
			 }.template();
	}
	
	/**
	 * 通知日志查询
	 * @return
	 */
	public String notList() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
            
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("id");
                    page.setOrderByType("desc");

                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from  NoticeLog model where 1=1" ;
                if (selJgdm != null && !"".equals(selJgdm)) {
                    sql += " and model.selPeople ='" + selJgdm + "'";
                }
                if (mc != null && !"".equals(mc)){
                    sql += " and model.selDw like '%" + mc + "%'";
                }
                
              /*      if (qzsm.getJgmc() != null && !"".equals(qzsm.getJgmc())) {
                        sql += " and model.jgmc like '%" + qzsm.getJgmc() + "%'";
                    }
                    if (qzsm.getType() != null && !"".equals(qzsm.getType())) {
                        sql += " and model.type ='" + qzsm.getType().trim() + "'";
                    }
                    if (startDate != null) {
                        sql += " and model.createTime >= '" + DateUtil.dateToStr(startDate) + "'";
                    }
                    if (qzsm.getCreateTime() != null) {
                        Date end = DateUtil.dayAfter(qzsm.getCreateTime(), 1);
                        sql += " and model.createTime < '" + DateUtil.dateToStr(end) + "'";
                    }
                    if (qzsm.getCompleTime() != null) {
                        sql += " and model.compleTime >= '" + DateUtil.dateToStr(qzsm.getCompleTime()) + "'";
                    }
                    if (endDate != null) {
                        Date end = DateUtil.dayAfter(endDate, 1);
                        sql += " and model.compleTime < '" + DateUtil.dateToStr(end) + "'";
                    }*/
                
                notList = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                em.clear();
                currentPath ="/product/jsp/requisition/noteList.jsp";
            }
        }.nSyTemplate();
    }

	
	private String selJgdm;
	
	

    

	public String getSelJgdm() {
		return selJgdm;
	}

	public void setSelJgdm(String selJgdm) {
		this.selJgdm = selJgdm;
	}

	public List<NoticeLog> getNotList() {
		return notList;
	}

	public void setNotList(List<NoticeLog> notList) {
		this.notList = notList;
	}

	public OrgTypeMes getOrgType() {
		return orgType;
	}

	public void setOrgType(OrgTypeMes orgType) {
		this.orgType = orgType;
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

    public Certi getCerti() {
        return certi;
    }

    public void setCerti(Certi certi) {
        this.certi = certi;
    }

    public TCfjlb getCfjl() {
        return cfjl;
    }

    public void setCfjl(TCfjlb cfjl) {
        this.cfjl = cfjl;
    }

    public Map<String, String> getCflxs() {
        return cflxs;
    }

    public void setCflxs(Map<String, String> cflxs) {
        this.cflxs = cflxs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

	public Map<String, String> getOrgs() {
		return orgs;
	}

	public void setOrgs(Map<String, String> orgs) {
		this.orgs = orgs;
	}

	public String getOrgMes() {
		return orgMes;
	}

	public void setOrgMes(String orgMes) {
		this.orgMes = orgMes;
	}

	public String getOpJglx() {
		return opJglx;
	}

	public void setOpJglx(String opJglx) {
		this.opJglx = opJglx;
	}

	public List<TFzr> getListFzr() {
		return listFzr;
	}

	public void setListFzr(List<TFzr> listFzr) {
		this.listFzr = listFzr;
	}

	public String getIsdy() {
		return isdy;
	}

	public void setIsdy(String isdy) {
		this.isdy = isdy;
	}

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}
	
    
}