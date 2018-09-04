/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.SerialBus;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.CommonPropertiesUtil;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.StringUtils;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author yanzh
 */
public class ChangeBZAddressAction extends CommonJgdmAction {
    private static final String path = "/product/jsp/changeBZAddress/";
    private static Logger log = Logger.getLogger(ChangeBZAddressAction.class);

    private List<TQzjgdmSj> qzjgdmSjs;
    private List<TQzjgdm> qzjgdms;
    private List<TJgdmSave> jgdmSaves;
    private String qrdbzjgdm;


    private String dzch;

    public ChangeBZAddressAction() {
        serialBus = new SerialBus();
    }

    //xiaruibo 20180531 机构迁址搜索
    public String searchBy(){
   	 return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
           	 String tydm = jgdm.getTyshxydm();
           	 System.out.println("统一社会代码："+jgdm.getTyshxydm());
           	 
           	 String jglx="";
           	 if(!"".equals(tydm)&&tydm!=null){
           		 if("1".equals(tydm.substring(1, 2))){
           			jglx="shetuan";
           		 }else if("2".equals(tydm.substring(1, 2))){
           			jglx="minfei";
           		 }else if("3".equals(tydm.substring(1, 2))){
           			jglx="jijinhui";
           		 }
           	 }
           	 
           	 if(tydm==null||"".equals(tydm)){
           		 setMessage("请输入正确的机构代码！");
           		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
           		 return;    
           	 }

           	 List<Object[]> jgdmList = em.createQuery(" select model.jgmc,model.bzjgdm,model.jglx from TJgdm model where model.tyshxydm = '"+tydm+"'").getResultList();
           	 if(jgdmList.size() == 0){
           		 setMessage("查询的数据不存在，没有存在相应的机构代码数据！");
           		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
           		 return; 
           	 }else if(jgdmList.size()>1){
           		 setMessage("存在不止一条的迁址数据信息，属问题数据，请联系系统管理员！");
           		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
           		 return; 
           	 }
//lvwei 2018-01-16 机构迁址增加数据权限    
           	 HttpServletRequest request = ServletActionContext.getRequest(); 
           	 User user = (User)request.getSession().getAttribute("sysUser");
           	 String user_bzjgdm = user.getBzjgdm();          		
           	//全总账号		        	 
           	if(user_bzjgdm.substring(1).equals("00000")){
           		 for(Object[] obj : jgdmList){	 
           			 jgdm.setJgmc((String)obj[0]);
       				 jgdm.setBzjgdm((String)obj[1]);
       				 jgdm.setJglx((String)obj[2]);
       			 }
           		 	currentPath = path + "updateBzjgdm.jsp";
           	//省级账号
           	}else if(user_bzjgdm.substring(2).equals("0000")){
           		for(Object[] obj : jgdmList){	 
      				 	if(!user_bzjgdm.substring(0,2).equals((String)obj[1].toString().substring(0,2))){
      					 setMessage("当前账号无权进行此机构的迁址");
                  		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
                  		 return; 
      				 	}
      				 jgdm.setJgmc((String)obj[0]);
      				 jgdm.setBzjgdm((String)obj[1]);
      				 jgdm.setJglx((String)obj[2]);
      			 	}
           		currentPath = path + "updateBzjgdm.jsp";
           	//市级账号
           	}else if(user_bzjgdm.substring(4).equals("00")){
           		for(Object[] obj : jgdmList){	 
      				 	if(!user_bzjgdm.substring(0,4).equals((String)obj[1].toString().substring(0,4))){
      					 setMessage("当前账号无权进行此机构的迁址");
                  		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
                  		 return; 
      				 	}
      				 jgdm.setJgmc((String)obj[0]);
      				 jgdm.setBzjgdm((String)obj[1]);
      				 jgdm.setJglx((String)obj[2]);
      			 	}
           		currentPath = path + "updateBzjgdm.jsp";
           	//区县账号
           	}else{
           		for(Object[] obj : jgdmList){	 
      				 	if(!user_bzjgdm.equals((String)obj[1])){
      					 setMessage("当前账号无权进行此机构的迁址");
                  		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
                  		 return; 
      				 	}
      				 jgdm.setJgmc((String)obj[0]);
      				 jgdm.setBzjgdm((String)obj[1]);
      				 jgdm.setJglx((String)obj[2]);
      			 	}
           		currentPath = path + "updateBzjgdm.jsp";
           	
           	}           	 
            }
        }.template();
   }
    //xiaruibo 20180531 机构迁址修改
    public String upBzjgdm(){

    	return new ActionUtils() {
    		@Override
    		protected void excute() throws Exception {

    			System.out.println("办证机构代码："+jgdm.getBzjgdm());
    			Object bzjgdm_mc = em.createQuery(" select model.mc from Bzjgdm model where model.dm = '"+jgdm.getBzjgdm()+"'").getSingleResult();
    			
    			String sql = "update TJgdm model set model.bzjgdm = '"+jgdm.getBzjgdm()+"',model.pzjgmc = '"+bzjgdm_mc.toString()+"',model.savetype = '0',model.lastdate='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"'  where tyshxydm ='"+jgdm.getTyshxydm()+"'" ;
    			em.createQuery(sql).executeUpdate();
    			setMessage("统一代码："+jgdm.getTyshxydm()+" 发证机关修改成功");
    			currentPath = path + "success.jsp";

    		}
    	}.template();
    }

    
    public String index() {

        isYwlc = InitSysParams.system.getIsYwlc();
        if (isYwlc&&!"yfmIn".equals(source)&&!"yfmOut".equals(source)&&!"yfmRedo".equals(source)) {
            return new ActionUtils(session) {
                protected String getYwlcSQL(TYwlc ywlc) {
                    int lcsx = getLcsx(ywlc);
                    String sql = "from TYwlc model where " + sql() + " and  model.isend<> '2' and model.ywlclx=" + ywlc.getYwlclx() +
                            " and model.type  in (select ywdy.type from TYwlcDy ywdy where ywdy.ywlclx=" + ywlc.getYwlclx() + " and ywdy.lcsx = " + (lcsx - 1) +
                            ")  and model.ywlsh like '%" + (ywlc.getYwlsh() == null ? "" : ywlc.getYwlsh())
                            + "%'   and model.jgdm like '" + "%" + (ywlc.getJgdm() == null ? "" : ywlc.getJgdm()) + "%" +
                            "'";
                    return sql;
                }

                protected int getLcsx(TYwlc ywlc) {
                    log.info("change-index:" + ywlc.getYwlclx() + ":" + ywlc.getType());
                    return (Integer) em.createQuery("select dy.lcsx from TYwlcDy  dy where dy.ywlclx=" + ywlc.getYwlclx() + " and dy.type='" + ywlc.getType() + "')").getSingleResult();
                }

                @Override
                protected void excute() throws Exception {
                    User user = (User) session.get("sysUser");
                    if (ywlc == null) {
                        ywlc = new TYwlc();
                    }
                    ywlc.setBzjgdm(user.getBzjgdm());
                    if ("innerIn".equals(source)) {
                        ywlc.setYwlclx(19);
                        title = "迁入";
                        ywlc.setType(title);

                    } else if ("outerIn".equals(source)) {
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    } else if ("innerOut".equals(source)) {
                        ywlc.setYwlclx(14);
                        title = "迁址";
                        ywlc.setType(title);

                    } else if ("outerOut".equals(source)) {
                        ywlc.setYwlclx(15);
                        title = "迁址";
                        ywlc.setType(title);

                    } else if ("innerRedo".equals(source)) {
                        ywlc.setYwlclx(20);
                        title = "省内迁址恢复";
                        ywlc.setType(title);

                    } else if ("outerRedo".equals(source)) {
                        ywlc.setYwlclx(21);
                        title = "省间迁址恢复";
                        ywlc.setType(title);

                    } else if ("yfmIn".equals(source)) {
                        ywlc.setYwlclx(18);
                        title = "迁入";
                        ywlc.setType(title);

                    } else if ("yfmOut".equals(source)) {
                        ywlc.setYwlclx(17);
                        title = "迁址";
                        ywlc.setType(title);

                    } else if ("yfmRedo".equals(source)) {
                        ywlc.setYwlclx(17);
                        title = "预赋码恢复";
                        ywlc.setType(title);

                    }
                    String sql = getYwlcSQL(ywlc);
                    if (page == null) {
                        page = new Page();
                        page.setOrderByField("clsj");
                        page.setOrderByType("desc");
                    }
                    String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                    ywlcs = em.createQuery("select model " + sql + orderBy)
                            .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
                    page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                            .getResultList().get(0)).intValue());
                    currentPath = path + "list.jsp";
                }
            }.nSyTemplate();
        } else {
            return new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    if ("yfmOut".equals(source)) {
                        if (jgdm == null)
                            jgdm = new TJgdm();
                        if (page == null) {
                            page = new Page();
                            page.setOrderByField("bzrq");
                            page.setOrderByType("desc");
                        }
                        String sql = " from TJgdmSave model where " + sql() + " and model.djblx='2'";
                        if (jgdm.getJgdm() != null && !"".equals(jgdm.getJgdm())) {
                            sql += " and  model.jgdm like '%" + (jgdm.getJgdm()) + "%' ";
                        }
                        if (jgdm.getJgmc() != null && !"".equals(jgdm.getJgmc())) {
                            sql += " and model.jgmc like '%" + (jgdm.getJgmc()) + "%' ";
                        }
                        String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                        jgdmSaves = em.createQuery("select model " + sql + orderBy)
                                .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                                .getResultList();
                        page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                                .getResultList().get(0)).intValue());
                        currentPath = path + "list_yfm.jsp";
                        return;
                    }
                    currentPath = path + "search.jsp?source=" + source;
                }
            }.nSyTemplate();
        }
    }

    public String search() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (mc == null || "".equals(mc)) {
                    setMessage("输入错误,找不到提交审核的数据");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
                if (source == null) {
                    setMessage("服务器错误,系统路径错误");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
                jgdm = new TJgdm();

                if ("yfmIn".equals(source)) {
                    TSpdmtemp spdm = getSpdm(em, mc, "14");
                    if (spdm != null) {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        List<TQzjgdm> qzjgdms = em.createQuery("select model from TQzjgdm model where model.qzbz='2' and model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                        if (qzjgdms != null && !qzjgdms.isEmpty()) {
                            qzjgId = qzjgdms.get(0).getId();
                            qcdjgdm = qzjgdms.get(0).getQzxzqh();
                            BeanUtilsEx.copyProperties(jgdm, qzjgdms.get(0));
                        }
                    }

                    jgdm.setJgdm(mc);
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }

                    currentPath = path + source + ".jsp";
                    return;
                } else if ("outerIn".equals(source)) {
                    TSpdmtemp spdm = getSpdm(em, mc, "13");
                    if (spdm != null) {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        List<TQzjgdmSj> qzjgdmSjs = em.createQuery("select model from TQzjgdmSj model where model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                        if (qzjgdmSjs != null && !qzjgdmSjs.isEmpty()) {
                            qzjgId = qzjgdmSjs.get(0).getId();
                            BeanUtilsEx.copyProperties(jgdm, qzjgdmSjs.get(0));
                        }
                        jgdm.setJgdm(mc);
                        jgdm.setBzrq(new Date());
                        Date njqx = DateUtil.yearAfter(new Date(), 1);
                        TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
                        //1是定期年检 0是办证日期加一年
                        if (zrxzqh != null) {
                            if ("0".equals(zrxzqh.getNjfs())) {
                                njqx = DateUtil.yearAfter(new Date(), 1);
                            } else {
                                njqx = DateUtil.yearAfter((DateUtil.strToDate(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2))), 1);
                            }
                        }

                        jgdm.setNjqx(njqx);
                        jgdm.setZfrq(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 4), 1));
                        jgdm.setXzqh(null);
                        jgdm.setJgdz(null);
                        jgdm.setJydz(null);
                    }
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    currentPath = path + source + ".jsp";
                    return;
                } else if (source.equals("innerIn")) {

                    List<TQzjgdm> qzjgdms = em.createQuery("select  model from  TQzjgdm model where model.qzbz='1' and model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        setMessage("查询的数据不存在,没有存在相应的迁址数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    jgdm = new TJgdm();
                    qzjgId = qzjgdm.getId();
                    TSpdmtemp spdm = getSpdm(em, mc, "06");
                    if (spdm != null) {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                        jgdm.setBzjgdm(qzjgdm.getQrdbzjgdm());
                        jgdm.setFbsl((1));
                        jgdm.setZbsl((1));
                        jgdm.setFkbz("0");
                        jgdm.setFksl(0);
                        jgdm.setDybz("0");
                        jgdm.setBzjgdm(qzjgdm.getQrdbzjgdm());
                        jgdm.setXzqh(null);
                        jgdm.setJgdz(null);
                        jgdm.setJydz(null);
                        Date njqx = DateUtil.yearAfter(new Date(), 1);
                        TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(user.getBzjgdm().trim());
                        //1是定期年检 0是办证日期加一年
                        if (zrxzqh != null) {
                            if ("0".equals(zrxzqh.getNjfs())) {
                                njqx = DateUtil.yearAfter(new Date(), 1);
                            } else {
                                njqx = DateUtil.yearAfter((DateUtil.strToDate(DateUtil.getCurrentDateTime().substring(0, 4) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2))), 1);
                            }
                        }

                        jgdm.setBzrq(new Date());
                        jgdm.setNjqx(njqx);
                        jgdm.setZfrq(DateUtil.dayBefore(DateUtil.yearAfter(new Date(), 4), 1));
                    }
                    //--------------工商数据处理--------------------
                    if (dzch != null && !"".equals(dzch)) {
                        dzch = dzch.trim();
                        if (jgdm.getJglx().trim().matches("[bB]")) {
                            List<Gtgsh> gtList = em.createQuery("select model from Gtgsh model where model.czch =?1").setParameter(1, dzch).getResultList();
                            if (gtList != null && gtList.size() > 0) {
                                Gtgsh gt = gtList.get(0);
                                jgdm.setJgmc(gt.getVqymc());
                                jgdm.setJgdz(gt.getVzs());
                                jgdm.setJyfw(gt.getVchrJyfw());
                                jgdm.setZcrq(gt.getDclrq());
                                jgdm.setGsfzrq(gt.getDjyqxz());
                                jgdm.setZczj(gt.getNumZczb());
                                jgdm.setYzbm(gt.getCyzbm());
                                jgdm.setDhhm(gt.getVlxdh());
                                jgdm.setNjjhy(gt.getChydm());
                                jgdm.setFddbr(gt.getVchrXm());
                                jgdm.setZjlx("0");
                                jgdm.setZjhm(gt.getChrZjhm());
                            }
                        } else {
                            List<Qiye> qyList = em.createQuery("select model from Qiye model where  model.czch =?1").setParameter(1, dzch).getResultList();
                            if (qyList != null && qyList.size() > 0) {
                                Qiye qiye = qyList.get(0);
                                jgdm.setJgmc(qiye.getVqymc());
                                jgdm.setJgdz(qiye.getVzs());
                                jgdm.setJyfw(qiye.getVchrJyfw());
                                jgdm.setZcrq(qiye.getDclrq());
                                jgdm.setGsfzrq(qiye.getDjyqxz());
                                jgdm.setZczj(qiye.getNumZczb());
                                jgdm.setYzbm(qiye.getCyzbm());
                                jgdm.setDhhm(qiye.getVlxdh());
                                jgdm.setNjjhy(qiye.getChydm());
                                jgdm.setFddbr(qiye.getVchrXm());
                                jgdm.setZjlx("0");
                                jgdm.setZjhm(qiye.getChrZjhm());
                            }
                        }
                    }

                    qcdjgdm = qzjgdm.getBzjgdm();
                    sccenter = qcdjgdm.substring(0, 2) + "0000";
                    currentPath = path + source + ".jsp";
                } else if (source.equals("innerRedo")) {
                    List<TQzjgdm> qzjgdms = em.createQuery("select  model from  TQzjgdm model where model.qzbz='1' and model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        setMessage("查询的数据不存在,没有存在相应的迁址数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    jgdm = new TJgdm();
                    qzjgId = qzjgdm.getId();

                    qcdjgdm = qzjgdm.getBzjgdm();
                    // jgdm.setBzjgdm(qcdjgdm);
                    sccenter = qcdjgdm.substring(0, 2) + "0000";
                    TSpdmtemp spdm = getSpdm(em, mc, "05");
                    if (spdm != null) {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                    }
                    currentPath = path + source + ".jsp";
                } else if (source.equals("outerRedo")) {
                    List<TQzjgdm> qzjgdms = em.createQuery("select  model from  TQzjgdm model where  model.qzbz='3' and model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        setMessage("查询的数据不存在,没有存在相应的迁址数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    jgdm = new TJgdm();
                    qzjgId = qzjgdm.getId();
                    TSpdmtemp spdm = getSpdm(em, mc, "05");
                    if (spdm != null) {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                    }
                    jgdm.setBzjgdm(user.getBzjgdm());
                    qcdjgdm = qzjgdm.getBzjgdm();
                    sccenter = qcdjgdm.substring(0, 2) + "0000";
                    currentPath = path + source + ".jsp";
                }
                if ("innerOut".equals(source)) {
                    jgdm = em.find(TJgdm.class, mc);
                    if (jgdm == null) {
                        setMessage("查询的数据不存在,没有存在相应的机构代码数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    em.clear();
                    
                    String value = CommonPropertiesUtil.getValue("common.properties", "snqc");
                    //0是不需要修改从库里取值,1是需要修改从页面获取值
                    if(value.equals("0")){
                    	 currentPath = path +"innerOut2.jsp";
                    }else if(value.equals("1")){
                    	 currentPath = path + "innerOut.jsp";
                    }
                    
                   
                }
                if ("outerOut".equals(source)) {
                    jgdm = em.find(TJgdm.class, mc);
                    if (jgdm == null) {
                        setMessage("查询的数据不存在,没有存在相应的机构代码数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }

                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    em.clear();
                    String value = CommonPropertiesUtil.getValue("common.properties", "sjqc");
                    //0是不需要修改从库里取值,1是需要修改从页面获取值
                    if(value.equals("0")){
                    	 currentPath = path + "outerOut2.jsp";
                    }else if(value.equals("1")){
                    	 currentPath = path + "outerOut.jsp";
                    }
                }
                if ("yfmOut".equals(source)) {
                    List<TJgdmSave> jgdmSaves = em.createQuery("select model from TJgdmSave model where model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                    if (jgdmSaves == null || jgdmSaves.isEmpty() || jgdmSaves.size() < 1) {
                        setMessage("查询的数据不存在,没有存在相应的机构代码数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    BeanUtilsEx.copyProperties(jgdm, jgdmSaves.get(0));
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }

                    em.clear();
                    currentPath = path + source + ".jsp";
                } else if (source.equals("yfmRedo")) {
                    List<TQzjgdm> qzjgdms = em.createQuery("select  model from  TQzjgdm model where  model.qzbz='2' and model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        setMessage("查询的数据不存在,没有存在相应的迁址数据");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    jgdm = new TJgdm();
                    qzjgId = qzjgdm.getId();
                    TQzjgdm spdm = getYfm(em, mc);
                    if (spdm != null) {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                    }
                    jgdm.setBzjgdm(user.getBzjgdm());
                    qcdjgdm = qzjgdm.getBzjgdm();
                    sccenter = qcdjgdm.substring(0, 2) + "0000";
                    currentPath = path + source + ".jsp";
                }
                em.clear();
            }
        }.template();
    }

    /**
     * 省内迁出
     *
     * @return
     */
    public String innerOut() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {

                String sql;
                Query query;
                User user = (User) session.get("sysUser");
                TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getJgdm());
                TJgdm jgdm1 = null;
                //获取配置文件
                String value = CommonPropertiesUtil.getValue("common.properties", "snqc");
                //0是不需要修改从库里取值,1是需要修改从页面获取值
                if(value.equals("0")){
                	jgdm1=jgdm2;	
                }else if(value.equals("1")){
                	jgdm1 = jgdm;
                }
                em.clear();
                TQzjgdm qzjgdm = new TQzjgdm();
                BeanUtilsEx.copyProperties(qzjgdm, jgdm1);
                //当前办证
                TZrxzqh xzqh = InitSysParams.zrxzqhMap2.get(jgdm.getBzjgdm());
                if (xzqh != null)
                    qzjgdm.setQzxzqh(xzqh.getXzqh());
                qzjgdm.setBzrq(new Date());
                qzjgdm.setLry(user.getUserName());
                qzjgdm.setQzbz("1");
                qzjgdm.setLastdate(new Date());
                qzjgdm.setQzrq(new Date());
                qzjgdm.setQrdbzjgdm(qrdbzjgdm);
                TBgk bgk = new TBgk();
                BeanUtilsEx.copyProperties(bgk, jgdm1);
                bgk.setBgsj(new Date());
                em.persist(bgk);
                em.persist(qzjgdm);
                sql = "delete from TJgdm model where model.jgdm=:jgdm";
                query = em.createQuery(sql);
                query.setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                sql = "UPDATE TZs model SET model.flag='0' WHERE  model.jgdm =:jgdm and model.flag='1'";
                query = em.createQuery(sql);
                query.setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                sql = " SELECT model FROM TkFkk model WHERE model.jgdm =:jgdm and model.flag='1'";
                List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                for (TkFkk fkk : fkks) {
                    TkFzk fzk = new TkFzk();
                    fzk.setFzsj(new Date());
                    fzk.setKxlh(fkk.getKxlh());
                    fzk.setJgdm(fkk.getJgdm());
                    fzk.setOperater(user.getBzjgdm());
                    em.persist(fzk);
                }
                sql = "UPDATE TkFkk SET flag='0' WHERE flag='1' and jgdm ='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                sql = "DELETE FROM TkKxxk WHERE jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                sql = " SELECT model FROM TkKxxk model WHERE model.jgdm =:jgdm";
                List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                //   em.createQuery("delete  from TSmrw  model where model.jgdm=:jgdm and model.status=false").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                for (TkKxxk kxxk : kxxks)
                    addCzjl(em, jgdm, "省内迁出,销卡", "B", kxxk.getLsh().longValue());
                setMessage("机构代码（" + jgdm.getJgdm() + "）省内办证地址迁出成功，如果需要恢复，请到“省内迁址恢复”页面进行操作！");
                jgdm = jgdm1;
                ywlclx = 14;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("迁址");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.省内迁出);
                type = "迁址";
                deleteSp(em, jgdm.getJgdm());
                setSource("innerOut");
                addCzjl(em, jgdm, "省内迁出", "G", null);
                setTitle("省内迁出");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * 省内迁入
     *
     * @return java.lang.String
     */
    public String innerIn() {
        if (submitType != 0) {
            return auditIn("innerIn");
        }
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "06");
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                    audit = false;
                }
                jgdm.setLastdate(new Date());
                jgdm.setQzbz("1");
                jgdm.setCzflag("9");
                jgdm.setYjflag("0");
                jgdm.setSjzt("0");
                jgdm.setDybz("4");
                jgdm.setBgrq(new Date());
                //      jgdm.setBzjgdm(user.getBzjgdm());
                if (!InitSysParams.njjhyMap.containsKey(jgdm.getNjjhy())) {
                    log.error("经济行业对照出错！");
                    message = "输入的经济行业不存在与码表中，请更正！";
                    currentPath = path + "innerIn.jsp";
                    return;
                }
                em.persist(jgdm);
                TBgk bgk = new TBgk();
                BeanUtilsEx.copyProperties(bgk, jgdm);
                bgk.setBgsj(new Date());
                em.persist(bgk);
                if ("1".equals(jgdm.getFkbz())) {
                    for (int i = 0; i < jgdm.getFksl(); ++i) {
                        TkKxxk kxxk = new TkKxxk();
                        kxxk.setHaveDown("0");
                        kxxk.setCzy(user.getUserName());
                        kxxk.setJgdm(jgdm.getJgdm());
                        kxxk.setBkbz("0");
                        kxxk.setCzsj(new Date());
                        kxxk.setSqsj(new Date());
                        kxxk.setFkbz("1");
                        kxxk.setFlag("0");
                        kxxk.setGsbz("0");
                        kxxk.setSbbz("0");
                        kxxk.setXzqh(user.getBzjgdm());
                        kxxk.setXgbz("0");
                        kxxk.setHaveDown("0");
                        em.persist(kxxk);
                        addCzjl(em, jgdm, "补卡信息", "Q", kxxk.getLsh().longValue());
                    }
                }
                addCzjl(em, jgdm, "补卡信息", "Q", null);
                em.createQuery("delete from TQzjgdm   where id=" + qzjgId).executeUpdate();
                ywlclx = 16;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("迁入");
                		yw.setIsend("1");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.省内迁入);
                type = "迁入";
                setMessage("机构代码（" + jgdm.getJgdm() + "）省内办证机构地址迁入成功！");
                setTitle("省内迁入");
                deleteSp(em, jgdm.getJgdm(), "06");
                addCzjl(em, jgdm, "省内迁入", "9", null);
                source = "innerIn";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * 预付码迁出
     *
     * @return @
     */
    public String yfmOut() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                try {
                    User user = (User) session.get("sysUser");
                    List<TJgdmSave> jgdmSaves = em.createQuery("select model from TJgdmSave model where model.jgdm=:jgdm").setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    TJgdmSave jgdmSave = jgdmSaves.get(0);
                    em.clear();
                    jgdmSave.setBzjgdm(jgdm.getBzjgdm());
                    em.merge(jgdmSave);
                    /*
                    TQzjgdm qzjgdm = new TQzjgdm();
                    BeanUtilsEx.copyProperties(qzjgdm, jgdmSave);
                    //当前办证
                    qzjgdm.setBzjgdm(user.getBzjgdm());
                    TZrxzqh xzqh = InitSysParams.zrxzqhMap2.get(jgdm.getBzjgdm());
                    if (xzqh != null)
                        qzjgdm.setQzxzqh(xzqh.getXzqh());
                    qzjgdm.setBzrq(new Date());
                    qzjgdm.setLry(user.getUserName());
                    qzjgdm.setQzbz("2");
                    qzjgdm.setLastdate(new Date());
                    qzjgdm.setQzrq(new Date());
                    qzjgdm.setQrdbzjgdm(jgdm.getBzjgdm());
                    TBgk bgk = new TBgk();
                    BeanUtilsEx.copyProperties(bgk, jgdmSave);
                    bgk.setBgsj(new Date());
                    qzjgdm.setId(null);
                    em.persist(bgk);
                    em.persist(qzjgdm);
                    em.createQuery("delete from TJgdmSave model where model.jgdm=:jgdm")
                            .setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                    //   em.createQuery("delete  from TSmrw  model where model.jgdm=:jgdm and model.status=false").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                     * 
                     */
                    em.flush();
                    setMessage("机构代码（" + jgdm.getJgdm() + "）预赋码迁址成功！");
                    BeanUtilsEx.copyProperties(jgdm, jgdmSave);
                    ywlclx = 17;
                  
                    deleteSp(em, jgdm.getJgdm());
                    //   addTSmrw(em, SmTaskType.预赋码);
                    type = "迁址";
                    setSource("yfmOut");
                } catch (NumberFormatException e) {
                    log.error(ChangeBZAddressAction.class, e);
                }
                addCzjl(em, jgdm, "预赋码迁出", "G", null);
                setTitle("预赋码迁出");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * 预付码迁入
     *
     * @return String
     */
    public String yfmIn() {
        if (submitType != 0) {
            return auditYfmIn();
        }
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "14");
                    audit = false;
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                }
                jgdm.setLastdate(new Date());
                jgdm.setZbsl(1);
                jgdm.setFbsl(1);
                jgdm.setFkbz("0");
                jgdm.setFksl(0);
                jgdm.setQzbz("2");
                jgdm.setCzflag("9");
                jgdm.setYjflag("0");
                jgdm.setSjzt("0");
                jgdm.setDybz("4");
                jgdm.setDjblx("2");
                jgdm.setBzjgdm(user.getBzjgdm());
                TJgdmSave jgdmSave = new TJgdmSave();
                BeanUtilsEx.copyProperties(jgdmSave, jgdm);
                em.persist(jgdmSave);
                TBgk bgk = new TBgk();
                List<TQzjgdm> qzjgdms = em.createQuery("select model from TQzjgdm model where model.qzbz='2' and model.jgdm=:jgdm").setParameter("jgdm", jgdm.getJgdm()).getResultList();
                if (qzjgdms != null && !qzjgdms.isEmpty()) {
                    qzjgId = qzjgdms.get(0).getId();
                    qcdjgdm = qzjgdms.get(0).getQzxzqh();
                    BeanUtilsEx.copyProperties(bgk, qzjgdms.get(0));
                    bgk.setBgsj(new Date());
                    em.persist(bgk);

                }
                em.createQuery("delete from TQzjgdm   where id=" + qzjgId).executeUpdate();
                ywlclx = 18;
             
                type = "迁入";
                setMessage("机构代码（" + jgdm.getJgdm() + "）预赋码地址迁入成功！");
                setTitle("预赋码迁入");
                deleteSp(em, jgdm.getJgdm(), "14");
                addCzjl(em, jgdm, "预赋码迁入", "9", null);
                source = "yfmIn";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * 预赋码迁入申请
     */
    public String auditYfmIn() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm.setLastdate(new Date());
                jgdm.setQzbz("2");
                jgdm.setCzflag("9");
                jgdm.setYjflag("0");
                jgdm.setSjzt("0");
                jgdm.setDybz("4");
                jgdm.setDjblx("2");
                jgdm.setBzjgdm(user.getBzjgdm());
                deleteSp(em, jgdm.getJgdm(), "14");
                TSpdmtemp spdm = new TSpdmtemp();
                BeanUtilsEx.copyProperties(spdm, jgdm);
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setFlag("0");
                sp.setYwlx("14");
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setShflag("0");
                sp.setSendxzqh(user.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                sp.setGllsh(spdm.getLsh());
                em.persist(sp);
                setMessage((submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "迁入机构代码(" + jgdm.getJgdm() + ")的请求已经发送给省中心。一旦省中心审核后，就可以迁入此代码！");
                source = "yfmIn";
                audit = true;
                setTitle("预赋码迁入申请");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String auditIn(final String sc) {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");

                TSpdmtemp spdm = new TSpdmtemp();
                BeanUtilsEx.copyProperties(spdm, jgdm);
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setFlag("0");
                if ("innerIn".equals(sc)) {
                    deleteSp(em, jgdm.getJgdm(), "06");
                    sp.setYwlx("06");
                }
                if ("outerIn".equals(sc)) {
                    deleteSp(em, jgdm.getJgdm(), "13");
                    sp.setYwlx("13");
                }
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setShflag("0");
                sp.setSendxzqh(user.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                sp.setGllsh(spdm.getLsh());
                em.persist(sp);
                setMessage((submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "迁入机构代码(" + jgdm.getJgdm() + ")的请求已经发送给省中心。一旦省中心审核后，就可以迁入此代码！");
                source = sc;
                audit = true;
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * *
     * *预赋码迁出恢复
     *
     * @return
     */
    public String yfmRedo() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='2'";
                TJgdmSave savse = new TJgdmSave();
                TQzjgdm qzjg = getYfm(em, jgdm.getJgdm());
                BeanUtilsEx.copyProperties(savse, qzjg);
                Query query = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm());
                List<TQzjgdm> qzjgdms = query.getResultList();
                TQzjgdm qzjgdm = qzjgdms.get(0);
                BeanUtilsEx.copyProperties(savse, qzjgdm);
                savse.setXzqh(qzjgdm.getQzbz());
                savse.setLry(user.getUserName());
                savse.setQzbz("0");
                savse.setId(null);
                em.clear();
                em.persist(savse);
                em.flush();
                sql = " delete from TQzjgdm where jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                addCzjl(em, jgdm, "迁址恢复", "V", null);
                ywlclx = 20;
              
                type = "预赋码恢复";
                setMessage("恢复预赋码(" + jgdm.getJgdm() + ")操作成功");
                setSource("yfmRedo");
                setTitle("预赋码恢复成功");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String auditInnerRedo() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                String sql;
                Query query;
                User user = (User) session.get("sysUser");
                sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='1'";
                query = em.createQuery(sql);
                List<TQzjgdm> qzjgdms = query.setParameter("jgdm", jgdm.getJgdm()).getResultList();
                if (qzjgdms == null || qzjgdms.isEmpty()) {
                    throw new Exception("迁址的数据不存在");
                } else if (qzjgdms.size() > 1) {
                    throw new Exception("存在不止一条的迁址数据信息");
                }
                TQzjgdm qzjgdm = qzjgdms.get(0);
                deleteSp(em, jgdm.getJgdm(), "05");
                TSpdmtemp spdm = new TSpdmtemp();
                BeanUtilsEx.copyProperties(spdm, qzjgdm);
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setFlag("0");
                sp.setYwlx("05");
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setShflag("0");
                sp.setSendxzqh(user.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                sp.setGllsh(spdm.getLsh());
                em.persist(sp);
                setMessage((submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "恢复机构代码(" + jgdm.getJgdm() + ")的请求已经发送给省中心。一旦省中心审核后，就可以恢复此代码！");
                source = "innerRedo";
                audit = true;
                setTitle("省内迁址恢复申请");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * 迁移恢复--只能做省内的
     *
     * @return String
     */
    public String innerRedo() {
        if (submitType != 0) {
            return auditInnerRedo();
        }
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql;
                String sql2;
                Query query;
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "05");
                    if (spdm == null) {
                        throw new Exception("迁址的审核数据不存在");
                    }
                    BeanUtilsEx.copyProperties(jgdm, spdm);

                } else {
                    sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='1'";
                    query = em.createQuery(sql);
                    List<TQzjgdm> qzjgdms = query.setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        throw new Exception("迁址的数据不存在");
                    } else if (qzjgdms.size() > 1) {
                        throw new Exception("存在不止一条的迁址数据信息");
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                    jgdm.setXzqh(qzjgdm.getQzxzqh());
                }
                jgdm.setLry(user.getUserName());
                jgdm.setLastdate(new Date());
                jgdm.setQzbz("0");
                //修改打印标志 1
                jgdm.setDybz("1");
                em.persist(jgdm);
                sql = " delete from TQzjgdm where jgdm='" + jgdm.getJgdm() + "'";
                //TSmrwsc smrwsc = qzjgdms.get(0);
                //BeanUtilsEx.copyProperties(jgdm, smrwsc);
                //sql2 = " delete from TSmrw where jgdm='" + jgdm.getJgdm() + "'";
                //em.createQuery(sql2).executeUpdate();
               
                em.createQuery(sql).executeUpdate();
                addCzjl(em, jgdm, "迁址恢复", "V", null);
                
                sql = "select model from TZs  model where model.jgdm=:jgdm order by fzsj desc";
                List<TZs> list = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                if (list != null && list.size() > 0) {
                    String lsh1 = (list == null ? "" : list.get(0).getLsh() + "");
                    String lsh2 = "";
                    if (list.size() > 1) {
                        lsh2 = list.get(1).getLsh() + "";
                    }
                    sql = "update TZs model set model.flag='1' where model.lsh in ('" + lsh1 + "','" + lsh2 + "')";
                    // sql="update Tzs model set model.flag='1' where model.lsh=:lsh1 or model.lsh=:lsh2";

                    em.createQuery(sql).executeUpdate();
                    em.flush();
                    em.clear();
                }
                if ("1".equals(jgdm.getFkbz())) {
                    for (int i = 0; i < jgdm.getFksl(); ++i) {
                        TkKxxk kxxk = new TkKxxk();
                        kxxk.setHaveDown("0");
                        kxxk.setCzy(user.getUserName());
                        kxxk.setJgdm(jgdm.getJgdm());
                        kxxk.setBkbz("0");
                        kxxk.setCzsj(new Date());
                        kxxk.setSqsj(new Date());
                        kxxk.setFkbz("1");
                        kxxk.setFlag("0");
                        kxxk.setGsbz("0");
                        kxxk.setSbbz("0");
                        kxxk.setXzqh(user.getBzjgdm());
                        kxxk.setXgbz("0");
                        em.persist(kxxk);
                        addCzjl(em, jgdm, "补卡信息", "Q", kxxk.getLsh().longValue());
                    }
                }
                if (audit) {
                    clearSp(em, jgdm, "05");
                }
                audit = false;
                ywlclx = 20;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("打印证书");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "省内迁址恢复";
                setMessage("恢复机构代码(" + jgdm.getJgdm() + ")操作成功");
                setSource("innerRedo");
                setTitle("省内迁址恢复成功");
                currentPath = path + "success.jsp";

            }
        }.template();

    }

    /**
     * 省间迁址恢复审核
     *
     * @return String
     */
    public String auditOuterRedo() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                String sql;
                Query query;
                User user = (User) session.get("sysUser");
                sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='3'";
                query = em.createQuery(sql);
                List<TQzjgdm> qzjgdms = query.setParameter("jgdm", jgdm.getJgdm()).getResultList();
                if (qzjgdms == null || qzjgdms.isEmpty()) {
                    throw new Exception("迁址的数据不存在");
                } else if (qzjgdms.size() > 1) {
                    throw new Exception("存在不止一条的迁址数据信息");
                }
                TQzjgdm qzjgdm = qzjgdms.get(0);
                deleteSp(em, jgdm.getJgdm(), "05");
                TSpdmtemp spdm = new TSpdmtemp();
                BeanUtilsEx.copyProperties(spdm, qzjgdm);
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setFlag("0");
                sp.setYwlx("05");
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setShflag("0");
                sp.setSendxzqh(user.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                sp.setGllsh(spdm.getLsh());
                em.persist(sp);
                setMessage((submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "恢复机构代码(" + jgdm.getJgdm() + ")的请求已经发送给省中心。一旦省中心审核后，就可以恢复此代码！");
                audit = true;
                source = "outerRedo";
                setTitle("省间迁址恢复申请成功");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * 省间迁移恢复--只能做省内的
     *
     * @return String
     */
    public String outerRedo() {
        if (submitType != 0) {
            return auditOuterRedo();
        }
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                String sql;
                Query query;
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "05");
                    if (spdm == null) {
                        throw new Exception("迁址的审核数据不存在");
                    }
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                } else {
                    sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='3'";
                    query = em.createQuery(sql);
                    List<TQzjgdm> qzjgdms = query.setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        throw new Exception("迁址的数据不存在");
                    } else if (qzjgdms.size() > 1) {
                        throw new Exception("存在不止一条的迁址数据信息");
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                }
                jgdm.setLry(user.getUserName());
                jgdm.setLastdate(new Date());
                jgdm.setBzjgdm(user.getBzjgdm());
                jgdm.setQzbz("0");
                //打印标志1
                jgdm.setDybz("1");
                em.persist(jgdm);
                sql = " delete from TQzjgdm where jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                addCzjl(em, jgdm, "迁址恢复", "V", null);

                //改变打印标志
                sql = "select model from TZs  model where model.jgdm=:jgdm order by fzsj desc";
                List<TZs> list = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                String lsh1 = (list == null ? "" : list.get(0).getLsh() + "");
                String lsh2 = "";
                if (list.size() > 1) {
                    lsh2 = list.get(1).getLsh() + "";
                }
                sql = "update TZs model set model.flag='1' where model.lsh in ('" + lsh1 + "','" + lsh2 + "')";
                // sql="update Tzs model set model.flag='1' where model.lsh=:lsh1 or model.lsh=:lsh2";

                em.createQuery(sql).executeUpdate();
                em.flush();
                em.clear();

                if ("1".equals(jgdm.getFkbz())) {
                    for (int i = 0; i < jgdm.getFksl(); ++i) {
                        TkKxxk kxxk = new TkKxxk();
                        kxxk.setHaveDown("0");
                        kxxk.setCzy(user.getUserName());
                        kxxk.setJgdm(jgdm.getJgdm());
                        kxxk.setBkbz("0");
                        kxxk.setCzsj(new Date());
                        kxxk.setSqsj(new Date());
                        kxxk.setFkbz("1");
                        kxxk.setFlag("0");
                        kxxk.setGsbz("0");
                        kxxk.setSbbz("0");
                        kxxk.setXzqh(user.getBzjgdm());
                        kxxk.setXgbz("0");
                        em.persist(kxxk);
                        addCzjl(em, jgdm, "补卡信息", "Q", kxxk.getLsh().longValue());
                    }
                }
                if (audit) {
                    clearSp(em, jgdm, "05");
                }
                audit = false;
                ywlclx = 21;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("打印证书");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "省间迁址恢复";
                setMessage("恢复机构代码(" + jgdm.getJgdm() + ")操作成功");
                setSource("outerRedo");
                setTitle("省间迁址恢复");
                currentPath = path + "success.jsp";

            }
        }.template();

    }

    /**
     * 省间迁出
     *
     * @return String
     */

    public String outerOut() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TJgdm jgdm1 = null;
              //获取配置文件
                String value = CommonPropertiesUtil.getValue("common.properties", "sjqc");
                //0是不需要修改从库里取值,1是需要修改从页面获取值
                if(value.equals("0")){
                	jgdm1 = em.find(TJgdm.class, jgdm.getJgdm());
                }else if(value.equals("1")){
                	jgdm1 = jgdm;
                }
                em.clear();
                TQzjgdm qzjgdm = new TQzjgdm();
                BeanUtilsEx.copyProperties(qzjgdm, jgdm1);
                TZrxzqh xzqh = InitSysParams.zrxzqhMap2.get(jgdm.getBzjgdm());
                if (xzqh != null)
                    qzjgdm.setQzxzqh(xzqh.getXzqh());
                qzjgdm.setBzrq(new Date());
                qzjgdm.setLry(user.getUserName());
                qzjgdm.setQzbz("3");
                qzjgdm.setLastdate(new Date());
                qzjgdm.setQzrq(new Date());
                qzjgdm.setQrdszxdm(sccenter);
                qzjgdm.setQrdbzjgdm(qrdbzjgdm);
                //qzjgdm.setBzjgdm(jgdm1.getBzjgdm());
                em.persist(qzjgdm);
                TBgk bgk = new TBgk();
                BeanUtilsEx.copyProperties(bgk, jgdm1);
                bgk.setBgsj(new Date());
                em.persist(bgk);
                String sql = "delete from TJgdm model where model.jgdm=:jgdm";
                Query query = em.createQuery(sql);
                query.setParameter("jgdm", jgdm.getJgdm()).executeUpdate();

                sql = "UPDATE TZs model SET model.flag='0' WHERE  model.jgdm =:jgdm and model.flag='1'";
                query = em.createQuery(sql);
                query.setParameter("jgdm", jgdm.getJgdm()).executeUpdate();

                sql = " SELECT model FROM TkFkk model WHERE model.jgdm =:jgdm";
                List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                for (TkFkk fkk : fkks) {
                    TkFzk fzk = new TkFzk();
                    fzk.setFzsj(new Date());
                    fzk.setKxlh(fkk.getKxlh());
                    fzk.setJgdm(fkk.getJgdm());
                    fzk.setOperater(user.getBzjgdm());
                    em.persist(fzk);
                }
                sql = "UPDATE TkFkk SET flag='0' WHERE flag='1' and jgdm ='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                sql = "SELECT model FROM TkKxxk model WHERE model.jgdm =:jgdm";
                List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                for (TkKxxk kxxk : kxxks)
                    addCzjl(em, jgdm, "省间迁出,销卡", "B", kxxk.getLsh().longValue());
                sql = "DELETE FROM TkKxxk WHERE jgdm='" + jgdm.getJgdm() + "'";

                em.createQuery(sql).executeUpdate();
                // em.createQuery("delete  from TSmrw  model where model.jgdm=:jgdm and model.status=false").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                jgdm = jgdm1;
                ywlclx = 15;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("迁址");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.省间迁出);
                type = "迁址";
                setMessage("机构代码（" + jgdm.getJgdm() + "）省间迁出成功！");
                addCzjl(em, jgdm, "省间迁出", "G", null);
                setSource("outerOut");
                deleteSp(em, jgdm.getJgdm());
                setTitle("省间迁出");
                currentPath = path + "success.jsp";
            }
        }.template();

    }

    /**
     * 省间迁入
     *
     * @return
     */
    public String outerIn() {
        if (submitType != 0) {
            return auditIn("outerIn");
        }
        
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "13");
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                    audit = false;
                }
                jgdm.setLastdate(new Date());
                jgdm.setBzjgdm(user.getBzjgdm());
                jgdm.setQzbz("0");
                jgdm.setCzflag("9");
                jgdm.setYjflag("0");
                jgdm.setSjzt("0");
                jgdm.setDybz("2");
                jgdm.setBgrq(new Date());
                jgdm.setFksl(jgdm.getFksl() == null ? 0 : jgdm.getFksl());
                if (!InitSysParams.njjhyMap.containsKey(jgdm.getNjjhy())) {
                    log.error("经济行业对照出错！");
                    message = "输入的经济行业不存在与码表中，请更正！";
                    currentPath = path + "outerIn.jsp";
                    return;
                }
                em.persist(jgdm);
                List<TQzjgdmSj> qzjgdmSjList = em.createQuery("select model from TQzjgdmSj  model where  model.jgdm='" + jgdm.getJgdm() + "' and model.qzbz='3'").getResultList();
                if (qzjgdmSjList != null && !qzjgdmSjList.isEmpty()) {
                    TQzjgdmSj qzjgdm = qzjgdmSjList.get(0);
                    TBgk bgk = new TBgk();
                    BeanUtilsEx.copyProperties(bgk, qzjgdm);
                    bgk.setBgsj(new Date());
                    em.persist(bgk);
                }
                if ("1".equals(jgdm.getFkbz())) {
                    for (int i = 0; i < jgdm.getFksl(); ++i) {
                        TkKxxk kxxk = new TkKxxk();
                        kxxk.setHaveDown("0");
                        kxxk.setCzy(user.getUserName());
                        kxxk.setJgdm(jgdm.getJgdm());
                        kxxk.setBkbz("0");
                        kxxk.setCzsj(new Date());
                        kxxk.setSqsj(new Date());
                        kxxk.setFkbz("1");
                        kxxk.setFlag("0");
                        kxxk.setGsbz("0");
                        kxxk.setSbbz("0");
                        kxxk.setXzqh(user.getBzjgdm());
                        kxxk.setXgbz("0");
                        em.persist(kxxk);
                        addCzjl(em, jgdm, "补卡信息", "Q", kxxk.getLsh().longValue());
                    }
                } 
                addTSmrw(em, SmTaskType.省间迁入);
                em.createQuery("delete TQzjgdmSj where jgdm='" + jgdm.getJgdm() + "'").executeUpdate();
                ywlclx = 16;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("迁入");
                		yw.setIsend("1");
                		yw.setJgmc(jgdm.getJgmc());
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "迁入";
                setMessage("机构代码（" + jgdm.getJgdm() + "）省间迁入成功！");
                setTitle("省间迁入");
                deleteSp(em, jgdm.getJgdm(), "13");
                addCzjl(em, jgdm, "省间迁入", "9", null);

                setSource("outerIn");
                currentPath = path + "success.jsp";
            }
        }.template();

    }

    public List<TQzjgdmSj> getQzjgdmSjs() {
        return qzjgdmSjs;
    }

    public void setQzjgdmSjs(List<TQzjgdmSj> qzjgdmSjs) {
        this.qzjgdmSjs = qzjgdmSjs;
    }

    public List<TQzjgdm> getQzjgdms() {
        return qzjgdms;
    }

    public void setQzjgdms(List<TQzjgdm> qzjgdms) {
        this.qzjgdms = qzjgdms;
    }

    public List<TJgdmSave> getJgdmSaves() {
        return jgdmSaves;
    }

    public void setJgdmSaves(List<TJgdmSave> jgdmSaves) {
        this.jgdmSaves = jgdmSaves;
    }

    public String getDzch() {
        return dzch;
    }

    public void setDzch(String dzch) {
        this.dzch = dzch;
    }

    public String getQrdbzjgdm() {
        return qrdbzjgdm;
    }


    public void setQrdbzjgdm(String qrdbzjgdm) {
        this.qrdbzjgdm = qrdbzjgdm;
    }
}