/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.SerialBus;
import com.ninemax.jpa.code.bus.TJgdmSaveBus;
import com.ninemax.jdbc.dao.DataAccess;
import sun.jdbc.rowset.CachedRowSet;
import com.ninemax.jpa.code.bus.WsbzXbBus;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;
import com.ninemax.tygs.bus.TyGsBus;
import com.ninemax.tygs.service.HdService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yanzh
 */
public class DailyBusinessAction extends CommonJgdmAction {
    private static final String path = "/product/jsp/dailybusiness/";
    private WsbzXbBus wsbzBus;
    private List<TFzdm> fzdms;

    private List<TBgk> listBgk;
    private List<TFddbr> listFddbr;
    private TFddbr fddbr;
    private TFrjl frjl;
    private TBgk bgk;
    private Date startDate;
    private Date endDate;
    private String type;
    private Boolean updataType;
    private String djh;
    private String allJgdms;
    private String dzch;
    private String jglx;
    private List<TNNjjlx> jjlx;
    private TFzr fzr;
    private List<TFzr> listFzr;
    private String isdang;
    private List<ScZw> zwList;
    private String zxpzwh;
    private String fzrq;
    private TFzdm fzdm;
    private TFddbr tfddbr;
    private TFrjl tfrjl;
    private String bgyy;
    private String xjwh;
    private String jlrq;
    private String jlwh;
    private String xjrq;
    private String url;
    private String bgxzqh;
    private String bgjgdz;
    private String bgyzbm;
    private String jgdz;
    private String jyfw;
    private String zgmc;
    private String zgdm;
    private String qtzw;
    
    
    
    TJgdmSaveBus saveBus;
    public DailyBusinessAction() { 
        serialBus = new SerialBus();
        wsbzBus = new WsbzXbBus();
        saveBus=new TJgdmSaveBus();
    }
//获取法定代表人
    public String Fddbr(){
    	
		return null;
    	
    }
    public String list() {
    
        if ("update".equals(source)) {
            ywType = 22;
            setTitle("非证书项变更");
            if (InitSysParams.system.getBgsh() != null && InitSysParams.system.getBgsh()) {
                needAudit = true;
            }
        } else if ("update_no".equals(source)) {
            ywType = 6;
            setTitle("证书项变更");
           /* if (InitSysParams.system.getBgsh() != null && InitSysParams.system.getBgsh()) {
                needAudit = true;
            }*/
        } else if ("check".equals(source)) {
            ywType = 10;
            setTitle("年检");
            needAudit = false;
        } else if ("unvalidate".equals(source)) {
            ywType = 8;
            setTitle("注销恢复");
            //System.out.println("===++++++++++++++++++"+source);
            needAudit = true;
            
        } else if ("delete".equals(source)) {
            ywType = 11;
            setTitle("删除");
            if (InitSysParams.system.getDeletesh() != null && InitSysParams.system.getDeletesh()) {
                needAudit = true;
            }
        } else if ("validate".equals(source)) {
            ywType = 7;
            setTitle("注销");
           /* if (InitSysParams.system.getFzsh() != null && InitSysParams.system.getFzsh()) {
                needAudit = true;
            }*/
        } else {
            return ERROR;
        }
        //isYwlc = InitSysParams.system.getIsYwlc() == null ? false : InitSysParams.system.getIsYwlc();
       

            return new ActionUtils(session) {
                @Override
                protected void excute() throws Exception {
                    if (jgdm == null) {
                        jgdm = new TJgdm();
                        page = new Page();
                        currentPath = path + "list.jsp";
                        //System.out.println("============================================"+jgdm);
                        return;
                    }
                    if ("unvalidate".equals(source)) {
                    	//System.out.println("-----------------------------------------------"+source);
                        //String sql = "from TFzdm model  where " + sql() + " and model.jglx='"+jglx+"' and  model.tyshxydm like '" + "%" + (jgdm.getTyshxydm() == null ? "" : jgdm.getTyshxydm()) + "%" + "'";
                    	String sql = "from TFzdm model  where " + sql() + " and model.jglx in (1,9) and  ( model.tyshxydm like '%" + jgdm.getTyshxydm() + "%'" +" or model.jgdm like '%"+  jgdm.getTyshxydm() +"%'or model.jgmc like'%" +  jgdm.getTyshxydm()+"%')";
                        if (page == null) {
                            page = new Page();
                            page.setOrderByField("zfrq");
                            page.setOrderByType("desc");
                        }
                        String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                        fzdms = em.createQuery("select model " + sql + orderBy)
                                .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                                .getResultList();
                        page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                                .getResultList().get(0)).intValue());
//                        String fddbrSql = "from TFddbr model where  model.tyshxydm = '"+ jgdm.getTyshxydm()+"'";
//                        fddbr = (TFddbr) em.createQuery(fddbrSql).getSingleResult();
                     
                    } else {
                        toList();
                    }
                    currentPath = path + "list.jsp";
                }

                private void toList(String sql) {
                    if (page == null) {
                        page = new Page();
                    }
                    String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by jgdm." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                    Date date = new Date();
                   
                   
                    Query query = em.createQuery("select model " + sql + orderBy);
                  
                    //query.setParameter("zfrq", date);
                    jgdms = query
                            .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                            .getResultList();
                    query = em.createQuery("select count(model) " + sql);
                  
                    //query.setParameter("zfrq", date);
                    page.setTotalRecord(((Long) query
                            .getResultList().get(0)).intValue());
                }

                private void toList() {
              	  User user = (User) session.get("sysUser");
                    if (jgdm == null) {
                        jgdm = new TJgdm();
                    }
                   // String sql = "from TJgdm model where  " + sql() + " and  model.dybz='1' and model.zfrq>=:zfrq  and  model.jgdm like '" + "%" + (jgdm.getJgdm() == null ? "" : jgdm.getJgdm()) + "%" + "' ";
                    String sql = "from TJgdm model where  " + sql() + "  and  (model.tyshxydm like '" + "%" + (jgdm.getTyshxydm() == null ? "" : jgdm.getTyshxydm()) + "%" + "' or model.jgdm like '" + "%" + (jgdm.getTyshxydm() == null ? "" : jgdm.getTyshxydm()) + "%" + "' or model.jgmc like '"+"%"+(jgdm.getTyshxydm() == null? "" :jgdm.getTyshxydm())+"%"+"')  and model.dybz='1'";
                      toList(sql);
                }

            }.nSyTemplate();
        

    }
   


	/**
	 * 法定代表人记录
	 * LP
	 * 2016-6-17
	 * @return
	 * Version @1.0
	 */
	public String fddbrRecordList() {

		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				if (jgdm == null) {
					jgdm = new TJgdm();
					page = new Page();
					currentPath = "/product/jsp/certificate/fddbrRecordList.jsp";
					return;
				}
				String sql = "from TFddbr model  where model.tyshxydm like '" + "%"
						+ (jgdm.getTyshxydm() == null ? "" : jgdm.getTyshxydm()) + "%" + "'";
				if (page == null) {
					page = new Page();
					page.setOrderByField("zfrq");
					page.setOrderByType("desc");
				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";
				listFddbr = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
						.getResultList();
				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());

				currentPath = "/product/jsp/certificate/fddbrRecordList.jsp";
			}

		}.nSyTemplate();

	}

	/**
	 * 查询法定代表人详细信息
	 * LP
	 * 2016-6-17
	 * @return
	 * Version @1.0
	 */
	public String showFddbrSearch() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				TFddbr tfddbr=em.find(TFddbr.class,fddbr.getLsh() );
				BeanUtilsEx.copyProperties(fddbr, tfddbr);
				String sql="from TFrjl model where model.frId="+tfddbr.getLsh();
				List<TFrjl> listFrjl=em.createQuery(sql).getResultList();
				if(listFrjl.size()>0){
					frjl=listFrjl.get(0);
				}
				
				currentPath = "/product/jsp/certificate/show-fddbr-search.jsp";
			}
		}.nSyTemplate();
	}
	


	/**
	 * 变更库列表
	 * LP
	 * 2016-6-17
	 * @return
	 * Version @1.0
	 */
	public String bgRecordList() {

		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				if (jgdm == null) {
					jgdm = new TJgdm();
					page = new Page();
					currentPath = "/product/jsp/certificate/bgRecordList.jsp";
					return;
				}
				String sql = "from TBgk model  where  model.tyshxydm like '" + "%"
						+ (jgdm.getTyshxydm() == null ? "" : jgdm.getTyshxydm()) + "%" + "'";
				if (page == null) {
					page = new Page();
					page.setOrderByField("zfrq");
					page.setOrderByType("desc");
				}
				String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model."
						+ page.getOrderByField() + " " + page.getOrderByType()) : "";
				listBgk = em.createQuery("select model " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
						.getResultList();
				page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql).getResultList().get(0)).intValue());

				currentPath = "/product/jsp/certificate/bgRecordList.jsp";
			}

		}.nSyTemplate();

	}
	

	/**
	 * 查询变更库信息
	 * LP
	 * 2016-6-17
	 * @return
	 * Version @1.0
	 */
	public String shwoBgSearch() {
		return new ActionUtils(session) {
			@Override
			protected void excute() throws Exception {
				String sql="from TBgk model where model.sn="+bgk.getSn();
				List<TBgk> listBgk=em.createQuery(sql).getResultList();
				if(listBgk.size()>0){
					bgk=listBgk.get(0);
				}
				jgdm=new TJgdm();
				BeanUtilsEx.copyProperties(jgdm, bgk);
				
				currentPath = "/product/jsp/certificate/show-bg-search.jsp";
			}
		}.nSyTemplate();
	}
	
	
	
    public String search() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if ("unvalidate".equals(type)) {
                    TSpdmtemp spdm = getSpdm(em, mc, "04");
                    if (spdm != null) {
                        jgdm = new TJgdm();
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        TFzdm fzdm = em.find(TFzdm.class, mc);
                        em.clear();
                        if (fzdm == null) {
                            setMessage("注销代码不存在");
                            currentPath = path + "list.jsp";
                            return;
                        }
                        jgdm = new TJgdm();

                        BeanUtilsEx.copyProperties(jgdm, fzdm);
                        jgdm.setBzrq(new Date());//变更了办证日期
                        jgdm.setNjrq(null);
                      //  TZrxzqh zrxzqh = InitSysParams.zrxzqhMap2.get(getUser().getBzjgdm());
                 /*       if ("1".equals(zrxzqh.getNjfs())) {
                            Date date = DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + zrxzqh.getNjqsrq().substring(0, 2) + "-" + zrxzqh.getNjqsrq().substring(2, 4));
                            if (date.after(new Date())) {
                                jgdm.setNjqx(DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2, 4)));
                            } else {
                                jgdm.setNjqx(DateUtil.strToDate((Calendar.getInstance().get(Calendar.YEAR) + 1) + "-" + zrxzqh.getNjjzrq().substring(0, 2) + "-" + zrxzqh.getNjjzrq().substring(2, 4)));

                            }
                        } else {
                            jgdm.setNjqx(DateUtil.yearAfter(jgdm.getBzrq(), 1));
                        }*/


                    }
                    //jgdm = null;
                    //tfddbr=saveBus.fddbrList(em,jgdm.getTyshxydm());
                    tfddbr=saveBus.fddbrList(em,mc);
                    //System.out.println("tfddbr.getLsh():"+tfddbr.getLsh());
                    if(tfddbr!=null){
                    tfrjl=saveBus.getFrjl(em,tfddbr.getLsh());
                    }
                } else if ("update".equals(type)) {
                    TSpdmtemp spdm = getSpdm(em, mc, "17");
                    if (spdm == null) {
                        jgdm = em.find(TJgdm.class, mc);
                    } else {
                        jgdm = new TJgdm();
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    }
                    if (jgdm == null) {
                        message = "统一代码不存在！";
                        currentPath = path + "list.jsp";
                        return;
                    }
                    /*
                    if (jgdm.getZfrq().compareTo(new Date()) < 0) {
                        message = "机构代码证书已经过期作废，只能换证或者注销";
                        currentPath = path + "list.jsp";
                        return;
                    }
                    */

                } else if ("update_no".equals(type)) {
                    //TSpdmtemp spdm = getSpdm(em, mc, "07,13");
                    
                        jgdm = em.find(TJgdm.class, mc);
                        if(jgdm!=null){
                        	
                        	tfddbr=saveBus.fddbrList(em,jgdm.getTyshxydm());
                        	if(tfddbr!=null){
                        	tfrjl=saveBus.getFrjl(em,tfddbr.getLsh());
                        	}
                        }
                 
                    if (jgdm == null) {
                        message = "机构代码不存在！";
                        currentPath = path + "list.jsp";
                        return;
                    }
                    /*
                    if (jgdm.getZfrq().compareTo(new Date()) < 0) {
                        message = "机构代码证书已经过期作废，只能换证或者注销";
                        currentPath = path + "list.jsp";
                        return;
                    }
                    */
                } else if ("check".equals(type)) {
                    TSpdmtemp spdm;
                    spdm = getSpdm(em, mc, "12");
                    if (spdm != null) {
                        jgdm = new TJgdm();
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        jgdm = em.find(TJgdm.class, mc);
                        if (jgdm == null) {
                            message = "机构代码不存在！";
                            currentPath = path + "list.jsp";
                            return;
                        } 
                        em.clear();
                        
                        TZrxzqh xzqh = InitSysParams.zrxzqhMap2.get(getUser().getBzjgdm());
                   /*     if ("1".equals(xzqh.getNjfs())) {
                            Date date = DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjqsrq().substring(0, 2) + "-" + xzqh.getNjqsrq().substring(2, 4));
                            if (date.after(new Date())) {
                                jgdm.setNjqx(DateUtil.strToDate(Calendar.getInstance().get(Calendar.YEAR) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));
                            } else {
                                jgdm.setNjqx(DateUtil.strToDate((Calendar.getInstance().get(Calendar.YEAR) + 1) + "-" + xzqh.getNjjzrq().substring(0, 2) + "-" + xzqh.getNjjzrq().substring(2, 4)));

                            }
                        } else {
                            Date real = DateUtil.yearAfter(new Date(), 1);
                            jgdm.setNjqx(real);
                        }*/

                    }
                    if (jgdm == null) { 
                        message = "机构代码不存在！";
                        currentPath = path + "list.jsp";
                        return;
                    }
                    if (jgdm.getYxqxe().compareTo(new Date()) < 0) {
                        message = "机构代码证书已经过期作废，只能换证或者注销";
                        currentPath = path + "list.jsp";
                        return;
                    }
                } else if ("validate".equals(type)) {
                	/////注销操作
                    //TSpdmtemp spdm = getSpdm(em, mc, "01");
                    /*if (spdm != null) {
                        jgdm = new TJgdm();
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {*/
                        jgdm = em.find(TJgdm.class, mc);
                    //}
                    if (jgdm == null) {
                        message = "机构代码不存在！";
                        currentPath = path + "list.jsp";
                        return;
                    }
                } else {
                    TSpdmtemp spdm = getSpdm(em, mc, "03");
                    if (spdm != null) {
                        jgdm = new TJgdm();
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    } else {
                        jgdm = em.find(TJgdm.class, mc);
                    }
                    if (jgdm == null) {
                        message = "机构代码不存在！";
                        currentPath = path + "list.jsp";
                        return;
                    }
                }

                
                if(em.isOpen()){
                	em.clear();
                }
                //    setSource(type);
                currentPath = path + (type == null ? "" : type) + "Business.jsp";
                System.out.println(currentPath);
                if("validate".equals(type)){
                	 //获取配置文件
                  /*  String value = CommonPropertiesUtil.getValue("common.properties", "fz");
                    //0是不需要修改,1是需要修改
                    if(value.equals("0")){
                    	currentPath = path + "validateBusiness2.jsp";
                    }*/
                } 
            }
        }.nSyTemplate();

    }

    public String auditUpdate_no() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm.getTyshxydm() == null) {
                    setMessage("输入机构代码错误");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
           
              
                	deleteSp(em, jgdm.getTyshxydm(), "07");
                
                TSpdmtemp spdm = new TSpdmtemp();
                jgdm.setLry(user.getUserName());
                TJgdm jgdm1 = em.find(TJgdm.class, jgdm.getTyshxydm());
                em.clear();
                BeanUtilsEx.copyProperties(jgdm1, jgdm);
                BeanUtilsEx.copyProperties(spdm, jgdm1);
                /*spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);*/
//                 Map<Object, Object> map = BeanUtilsEx.describe(spdm);
//                for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                    System.out.println("entry= " + entry.getKey() + ":" + entry.getValue());
//                }
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setGllsh(spdm.getLsh());
                sp.setFlag("0");
                sp.setShflag("0");
            
                	
                	sp.setYwlx("07");
              
                sp.setSubmitType(submitType);
                sp.setJglx(jglx);
                sp.setJgmc(jgdm.getJgmc());
                sp.setTyshxydm(jgdm.getTyshxydm());
                sp.setRecexzqh("");
                sp.setSendxzqh(jgdm.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                em.persist(sp);
                em.flush();
                setTitle("日常业务 &gt;&gt; 代码变更 &gt;&gt; 发送变更申请");
                setMessage("向省中心提交机构代码（" + jgdm.getTyshxydm() + "）变更请求成功！");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String auditUpdate_no_fr() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm.getTyshxydm() == null) {
                    setMessage("输入机构代码错误");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
               
                	deleteSp(em, jgdm.getTyshxydm(), "13");
            
                TSpdmtemp spdm = new TSpdmtemp();
                jgdm.setLry(user.getUserName());
                TJgdm jgdm1 = em.find(TJgdm.class, jgdm.getTyshxydm());
                em.clear();
                BeanUtilsEx.copyProperties(jgdm1, jgdm);
                BeanUtilsEx.copyProperties(spdm, jgdm1);
                /*spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);*/
//                 Map<Object, Object> map = BeanUtilsEx.describe(spdm);
//                for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                    System.out.println("entry= " + entry.getKey() + ":" + entry.getValue());
//                }
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setGllsh(spdm.getLsh());
                sp.setFlag("0");
                sp.setShflag("0");
               
                	sp.setYwlx("13");

               
                sp.setSubmitType(submitType);
                sp.setJglx(jglx);
                sp.setJgmc(jgdm.getJgmc());
                sp.setTyshxydm(jgdm.getTyshxydm());
                sp.setRecexzqh("");
                sp.setSendxzqh(jgdm.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                em.persist(sp);
                em.flush();
                setTitle("日常业务 &gt;&gt; 代码变更 &gt;&gt; 发送变更申请");
                setMessage("向省中心提交机构代码（" + jgdm.getTyshxydm() + "）变更请求成功！");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String auditUpdate() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm.getJgdm() == null) {
                    setMessage("输入机构代码错误");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
                deleteSp(em, jgdm.getJgdm(), "17");
                TSpdmtemp spdm = new TSpdmtemp();
                jgdm.setLry(user.getUserName());
                TJgdm jgdm1 = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();
                BeanUtilsEx.copyProperties(jgdm1, jgdm);
                BeanUtilsEx.copyProperties(spdm, jgdm1);
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                Map<Object, Object> map = BeanUtilsEx.describe(spdm);
//                for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                    System.out.println("entry= " + entry.getKey() + ":" + entry.getValue());
//                }
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setGllsh(spdm.getLsh());
                sp.setGllsh(spdm.getLsh());
                sp.setFlag("0");
                sp.setShflag("0");
                sp.setYwlx("17");
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setSendxzqh(jgdm.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                em.persist(sp);
                em.flush();
                setTitle("日常业务 &gt;&gt; 代码变更 &gt;&gt; 发送变更申请");
                setMessage("向省中心提交机构代码（" + jgdm.getJgdm() + "）变更请求成功！");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String sameName(final String shType) {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm.getJgdm() == null) {
                    setMessage("输入机构代码错误");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
                deleteSp(em, jgdm.getJgdm(), shType);
                TSpdmtemp spdm = new TSpdmtemp();
                jgdm.setLry(user.getUserName());
                em.clear();
                BeanUtilsEx.copyProperties(spdm, jgdm);
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                em.merge(spdm);
                TSp sp = new TSp();
                sp.setGllsh(spdm.getLsh());
                sp.setGllsh(spdm.getLsh());
                sp.setFlag("0");
                sp.setShflag("0");
                sp.setYwlx(shType);
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setSendxzqh(jgdm.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
//                Map<Object, Object> map = BeanUtilsEx.describe(sp);
//                for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                    System.out.println("entry.getKey()+\":\"+entry.getValue() = " + entry.getKey() + ":" + entry.getValue());
//                }
                em.persist(sp);
                em.flush();
                setMessage("向省中心提交机构代码（" + jgdm.getJgdm() + "）" + (submitType == 1 ? "重名注册" : submitType == 2 ? "重注册号" : "重名重注册") + "审核请求成功！");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String update_no() {
        if (submitType != 0) {
        	if(submitType ==5){
        		return auditUpdate_no_fr();
        	}else{
        		
        		return auditUpdate_no();
        	}
        }
        
        final TJgdm[] jgdmArr = {null};
        String result = new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
            	User user = (User) session.get("sysUser");
                TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getTyshxydm());
             

                em.clear();

                TBgk bgk = new TBgk();
                if("".equals(jgdm2.getYxqxs())||jgdm2.getYxqxs()==null){
            		bgk.setYxqxs(null);
            	}
                if("".equals(jgdm2.getYxqxe())||jgdm2.getYxqxe()==null){
                	bgk.setYxqxe(null);
                }
                if("".equals(jgdm2.getZcrq())||jgdm2.getZcrq()==null){
                	bgk.setZcrq(null);
                }
                if("".equals(jgdm2.getBzrq())||jgdm2.getBzrq()==null){
                	bgk.setBzrq(null);
                }
                BeanUtilsEx.copyProperties(bgk, jgdm2);
                //bgk.setBgsj(new Date());
                em.persist(bgk);
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getTyshxydm(), "07,13");
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                }

                if (updataType != null && updataType) {
               
                
                		addCzjl(em, jgdm, "工会更新机构代码", "2", null);
                	
                    //jgdm.setDybz("2");
                } else {
                    addCzjl(em, jgdm, "问题数据修改", "F", null);
                }


               /* List<TZs> zses = em.createQuery("select model from TZs model where model.flag= ?1 and model.jgdm=?2").setParameter(1, "1").setParameter(2, jgdm.getJgdm()).getResultList();
                for (TZs zs : zses) {
                    zs.setFlag("2");
                    zs.setLastdate(new Date());
                    em.merge(zs);
                }*/
             /*   if (("1".equals(jgdm2.getFkbz())) || ("1".equals(jgdm.getFkbz()))) {
                    List<TkKxxk> kxxks = em.createQuery(" SELECT model FROM TkKxxk model WHERE model.kxlh is not null and model.jgdm =:jgdm").setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    Date date = new Date();
                    if (kxxks != null && !kxxks.isEmpty()) {
                        for (TkKxxk kxxk : kxxks) {
                            TkFzk fzk = new TkFzk();
                            fzk.setJgdm(jgdm.getJgdm());
                            fzk.setKxlh(kxxk.getKxlh());
                            fzk.setFzsj(date);
                            fzk.setOperater(user.getUserName());
                            fzk.setXzqh(user.getBzjgdm());
                            em.persist(fzk);
                        }
                    }
                    em.createQuery("delete from TkKxxk where jgdm=:jgdm").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                    for (int i = 0; i < jgdm.getFksl(); ++i) {
                        TkKxxk kxxk = new TkKxxk();
                        kxxk.setCzy(user.getUserName());
                        kxxk.setJgdm(jgdm.getJgdm());
                        kxxk.setBkbz("0");
                        kxxk.setCzsj(date);
                        kxxk.setSqsj(new Date());
                        kxxk.setFkbz("1");
                        kxxk.setFlag("0");
                        kxxk.setGsbz("0");
                        kxxk.setSbbz("0");
                        kxxk.setXzqh(user.getBzjgdm());
                        kxxk.setXgbz("0");
                        kxxk.setHaveDown("0");
                        em.persist(kxxk);
                        addCzjl(em, jgdm, "写卡信息", "Q", kxxk.getLsh().longValue());
                    }
                }*/
                dy = "0";
                jgdm.setBgrq(new Date());
                jgdm.setLastdate(new Date());
                jgdm.setLry(user.getUserName());
                jgdm.setZgmc(zgmc);
                jgdm.setZgdm(zgdm);
                jgdm.setJyfw(jyfw);
                jgdm.setBgxzqh(bgxzqh);
                jgdm.setJgdz(jgdz);
                jgdm.setBgjgdz(bgjgdz);
                jgdm.setJlwh(jlwh.substring(0, jlwh.indexOf(",")));
                jgdm.setXjwh(xjwh);
                jgdm.setBgyzbm(bgyzbm);
                jgdm.setLastdate(new Date());
                jgdm.setPzjgmc(user.getPrintName());
                jgdm.setZjlx(jgdm2.getZjlx());
                jgdm.setZjhm(jgdm2.getZjhm());
                jgdm.setUrl(url);
                jgdm.setFddbr(jgdm.getFddbr());
                //jgdm.setWtbz(0);
                /*   BeanUtilsEx.copyProperties(jgdm2, jgdm);
                Map<Object, Object> map = BeanUtilsEx.describe(jgdm2);
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    System.out.println("name::value=|" + entry.getKey() + "|" + entry.getValue());
                }*/
              /*  if (!InitSysParams.njjhyMap.containsKey(jgdm.getNjjhy())) {
                    log.error("经济行业对照出错！");
                    message = "输入的经济行业不存在与码表中，请更正！";
                    currentPath = path + "jjhyError.jsp";
                    return;
                }*/
                System.out.println(jgdz);
                System.out.println(jlwh);
                System.out.println(jlwh.substring(0, jlwh.indexOf(",")));
                System.out.println("qtzw="+qtzw);
                System.out.println(jgdm2.getJgdz());
                System.out.println(jgdm2.getXjwh());
                System.out.println(jgdm2.getJlwh());
                System.out.println(jgdm2.getXjrq());
                System.out.println(jgdm2.getJlrq());
                jgdm.setPzjgmc(jgdm2.getPzjgmc());
                jgdm.setDybz("1");
                //lvwei 20180103上报字段
                jgdm.setDflag(0);
                jgdm.setYwlx("1");                         
                jgdm.setJglx(jgdm2.getJglx());
                jgdm.setJgdm(jgdm2.getJgdm());
             	//jgdm.setJlwh(jgdm2.getJlwh());
            	jgdm.setJlrq(jgdm2.getJlrq()); 
                //jgdm.setXjwh(jgdm2.getXjwh());
            	jgdm.setXjrq(jgdm2.getXjrq());
                if("0".equals(isdang)){
                	jgdm.setJlwh(jlwh);
                	jgdm.setJlrq(DateUtil.strToDate(jlrq));
                	em.merge(jgdm);
                	System.out.println("机构代码1："+jgdm.toString());
                }else if("1".equals(isdang)){
                	saveBus.updateFddbr(em, jgdm.getTyshxydm());
                	saveBus.AddFddbr(em,fddbr, jgdm, frjl);
                	jgdm.setZjlx(fddbr.getZjlx());
                    jgdm.setZjhm(fddbr.getZjhm());
                    jgdm.setFddbr(fddbr.getXm());
                	jgdm.setDybz("0");
                	jgdm.setXjwh(xjwh);
                	jgdm.setXjrq(DateUtil.strToDate(xjrq));
                	System.out.println("机构代码2："+jgdm.toString());
                }else{
                	saveBus.updateFddbr(em, jgdm.getTyshxydm());
                	saveBus.AddFddbr(em,fddbr, jgdm, frjl);
                	jgdm.setDybz("0");
                	jgdm.setFddbr(fddbr.getXm());
                	jgdm.setZjlx(fddbr.getZjlx());
                	jgdm.setZjhm(fddbr.getZjhm());             	
                	jgdm.setJlrq(DateUtil.strToDate(jlrq));
                	//jgdm.setXjwh(xjwh);
                	jgdm.setXjrq(DateUtil.strToDate(xjrq));
                	em.merge(jgdm);
                }
                //jgdm.setZfrq(jgdm2.getZfrq());
                em.flush();
                //操作人员信息
                //saveBus.AddTjgdmFzr(em,fzr, jgdm.getTyshxydm());
                String memo =null;
                try{
               	 String name = "流水号";
               	 String sql = "select bbh from   DB_ZDB where  name ='"+ name + "'  " ;
               	 System.out.println(sql);
    				  DataAccess dataObject = new DataAccess();
                	  CachedRowSet cs = dataObject.query(sql);
                	 while(cs.next()){
                  	   memo =cs.getString("bbh").toString();
                   //将版本号传入前台，前台进行处理
   				   System.out.println(memo+"aaaaaaaaaaaa");
   				  }
                	 System.out.println(memo+"aaaaaaaaaaaa1111111111");
               	//  int bzlsh =10000;
               	  int i = Integer.parseInt(memo);
               	  int bzlsh1 =i+1;
                 	 String sql2 = "update DB_ZDB set bbh ='"+ bzlsh1 + "'   where  name ='"+ name + "'  " ;
    				  DataAccess dataObject2 = new DataAccess();
                	  CachedRowSet cs2 = dataObject2.update(sql2);
                	 System.out.println(sql2);
                }catch (Exception e) {
   					e.printStackTrace();           					
   				}
                jgdm.setLsh(memo);
                em.flush();
                ywlclx = 6;
                //业务流程更新
                	/*List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("证书项变更");
                		yw.setIsend("1");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }*/
               // type = "1".equals(jgdm.getDybz()) ? "无证书变更" : "变更";
                //addTSmrw(em, SmTaskType.变更);
                if (audit) {
                    clearSp(em, jgdm, "07,13");
                }
                /*if (!source.equals("update_no")) {
                    EntityManager manager = CodeEntityManagerHelper.getEntityManager();
                    manager.getTransaction().begin();
                    try {

                        manager.createQuery("delete from SmProJgdm model where model.jgdm=?1").setParameter(1, jgdm.getJgdm()).executeUpdate();
                        manager.flush();
                        manager.getTransaction().commit();
                    } catch (Exception e) {
                        manager.getTransaction().rollback();
                        throw e;
                    } finally {
                        CodeEntityManagerHelper.closeEntityManager();
                    }
                    em.createQuery("delete  from  TProjgdmGj model where model.jgdm=?1").setParameter(1, jgdm.getJgdm()).executeUpdate();
                }
                deleteSp(em, jgdm.getJgdm(), "07");*/
                jgdmArr[0] = jgdm;
                em.flush();
                TBgjl bgjl = new TBgjl();
                String bgsxmc="";
                String bgq="";
                String bgh="";
                
                if(!clsStringTool.isNewStr(bgk.getJgmc()).equals(clsStringTool.isNewStr(jgdm.getJgmc()))){
                	bgsxmc+="名称变更";
                	bgq+=bgk.getJgmc();
                	bgh+=jgdm.getJgmc();
                	jgdm.setDybz("0");
                }
                
                /*if(!clsStringTool.isNewStr(bgk.getFddbr()).equals(clsStringTool.isNewStr(jgdm.getFddbr()))){
                	bgsxmc+="、法人变更";
                	bgq+="、"+bgk.getFddbr();
                	bgh+="、"+jgdm.getFddbr();
                	jgdm.setDybz("0");
                }
                if(!clsStringTool.isNewStr(bgk.getZjhm()).equals(clsStringTool.isNewStr(jgdm.getZjhm()))){
                	bgsxmc+="、证件号码变更";
                	bgq+="、"+bgk.getZjhm();
                	bgh+="、"+jgdm.getZjhm();
                	jgdm.setDybz("0");
                }
                if(!clsStringTool.isNewStr(bgk.getFddbr()).equals(clsStringTool.isNewStr(jgdm.getFddbr()))){
                	bgsxmc+="、法人变更";
                	bgq+="、"+bgk.getFddbr();
                	bgh+="、"+jgdm.getFddbr();
                	jgdm.setDybz("0");
                }
                if(!clsStringTool.isNewStr(bgk.getMobile()).equals(clsStringTool.isNewStr(jgdm.getMobile()))){
                	bgsxmc+="、法人手机变更";
                	bgq+="、"+bgk.getMobile();
                	bgh+="、"+jgdm.getMobile();
                }*/
                if(!clsStringTool.isNewStr(bgk.getXzqh()).equals(clsStringTool.isNewStr(jgdm.getXzqh()))){
                	bgsxmc+="、行政区划变更";
                	bgq+="、"+bgk.getXzqh();
                	bgh+="、"+jgdm.getXzqh();
                }
               
                if(!clsStringTool.isNewStr(bgk.getJgdz()).equals(clsStringTool.isNewStr(jgdm.getJgdz()))){
                	bgsxmc+="、地址变更";
                	bgq+="、"+bgk.getJgdz();
                	bgh+="、"+jgdm.getJgdz();
                	jgdm.setDybz("0");
                }
             /*   if(!clsStringTool.isNewStr(bgk.getJjlx2011()).equals(clsStringTool.isNewStr(jgdm.getJjlx2011()))){
                	bgsxmc+="、登记类型变更"; 
                	bgq+="、"+bgk.getJjhy2011();
                	bgh+="、"+jgdm.getJjhy2011();
                }*/
              /*  if(!clsStringTool.isNewStr(String.valueOf(bgk.getZczj())).equals(clsStringTool.isNewStr(String.valueOf(jgdm.getZczj())))){
                	bgsxmc+="、注册资金变更";
                	bgq+="、"+bgk.getZczj();
                	bgh+="、"+jgdm.getZczj();
                }*/
              /*  if(!clsStringTool.isNewStr(String.valueOf(bgk.getZgrs())).equals(clsStringTool.isNewStr(String.valueOf(jgdm.getZgrs())))){
                	bgsxmc+="、职工人数变更";
                	bgq+="、"+bgk.getZgrs();
                	bgh+="、"+jgdm.getZgrs();
                }*/
                if(!clsStringTool.isNewStr(bgk.getYzbm()).equals(clsStringTool.isNewStr(jgdm.getYzbm()))){
                	bgsxmc+="、邮政编码变更";
                	bgq+="、"+bgk.getYzbm();
                	bgh+="、"+jgdm.getYzbm();
                }
                if(!clsStringTool.isNewStr(bgk.getDhhm()).equals(clsStringTool.isNewStr(jgdm.getDhhm()))){
                	bgsxmc+="、电话号码变更";
                	bgq+="、"+bgk.getDhhm();
                	bgh+="、"+jgdm.getDhhm();
                }
               /* if(!clsStringTool.isNewStr(bgk.getZgdm()).equals(clsStringTool.isNewStr(jgdm.getZgdm()))){
                	bgsxmc+="、业务主管单位代码变更";
                	bgq+="、"+bgk.getZgdm();
                	bgh+="、"+jgdm.getZgdm();
                	
                }*/
            /*    if(!clsStringTool.isNewStr(bgk.getZgmc()).equals(clsStringTool.isNewStr(jgdm.getZgmc()))){
                	bgsxmc+="、业务主管单位名称变更";
                	bgq+="、"+bgk.getZgmc();
                	bgh+="、"+jgdm.getZgmc();
                }*/
             /*   if(!clsStringTool.isNewStr(bgk.getUrl()).equals(clsStringTool.isNewStr(jgdm.getUrl()))){
                	bgsxmc+="、网址变更";
                	bgq+="、"+bgk.getUrl();
                	bgh+="、"+jgdm.getUrl();
                }*/
               /* if(!clsStringTool.isNewStr(bgk.getEmail()).equals(clsStringTool.isNewStr(jgdm.getEmail()))){
                	bgsxmc+="、邮箱变更";
                	bgq+="、"+bgk.getEmail();
                	bgh+="、"+jgdm.getEmail();
                }*/
                if(!clsStringTool.isNewStr(bgk.getTbrxm()).equals(clsStringTool.isNewStr(jgdm.getTbrxm()))){
                	bgsxmc+="、经办人姓名变更";
                	bgq+="、"+bgk.getTbrxm();
                	bgh+="、"+jgdm.getTbrxm();
                }
                if(!clsStringTool.isNewStr(bgk.getTbrsfzh()).equals(clsStringTool.isNewStr(jgdm.getTbrsfzh()))){
                	bgsxmc+="、经办人证件号码变更";
                	bgq+="、"+bgk.getTbrsfzh();
                	bgh+="、"+jgdm.getTbrsfzh();
                }
                if(!clsStringTool.isNewStr(bgk.getTbrlxfs()).equals(clsStringTool.isNewStr(jgdm.getTbrlxfs()))){
                	bgsxmc+="、经办人联系方式变更";
                	bgq+="、"+bgk.getTbrlxfs();
                	bgh+="、"+jgdm.getTbrlxfs();
                }
               /* System.out.println(isnull(bgk.getMemo().trim()));
                System.out.println(isnull(jgdm.getMemo().trim()));
                if(!isnull(bgk.getMemo().trim()).equals(isnull(jgdm.getMemo().trim()))){
                	bgsxmc+="、备注变更";
                	bgq+="、"+bgk.getMemo();
                	bgh+="、"+jgdm.getMemo();
                }*/
            /*    if(!DateUtil.dateToStr(bgk.getYxqxs()).equals(DateUtil.dateToStr(jgdm.getYxqxs()))){
                	bgsxmc+="、有效期限自变更";
                	bgq+="、"+DateUtil.dateToStr(bgk.getYxqxs());
                	bgh+="、"+DateUtil.dateToStr(jgdm.getYxqxs());
                }*/
                if(!DateUtil.dateToStr(bgk.getBzrq()).equals(DateUtil.dateToStr(jgdm.getBzrq()))){
                	bgsxmc+="、发证日期变更";
                	bgq+="、"+DateUtil.dateToStr(bgk.getBzrq());
                	bgh+="、"+DateUtil.dateToStr(jgdm.getBzrq());
                }
                if(!DateUtil.dateToStr(bgk.getZcrq()).equals(DateUtil.dateToStr(jgdm.getZcrq()))){
                	bgsxmc+="、成立日期变更";
                	bgq+="、"+DateUtil.dateToStr(bgk.getZcrq());
                	bgh+="、"+DateUtil.dateToStr(jgdm.getZcrq());
                }
              /*  if(!DateUtil.dateToStr(bgk.getZfrq()).equals(DateUtil.dateToStr(jgdm.getZfrq()))){
                	bgsxmc+="、有效期限至变更";
                	bgq+="、"+DateUtil.dateToStr(bgk.getZfrq());
                	bgh+="、"+DateUtil.dateToStr(jgdm.getZfrq());
                	jgdm.setDybz("0");
                }*/
                bgjl.setTyshxydm(jgdm.getTyshxydm());
                bgjl.setStmc(bgk.getJgmc());
                if(!"".equals(bgsxmc)){
                	
                	char bz=bgsxmc.charAt(0);
                	if(bz=='、'){
                    	bgsxmc=bgsxmc.substring(1,bgsxmc.length());
                    }
                }
                if(!"".equals(bgq)){
                	
                	char bzq=bgq.charAt(0);
                	 if(bzq=='、'){
                     	bgq=bgq.substring(1,bgq.length());
                     }
                }
                if(!"".equals(bgh)){
                	  char bzh=bgh.charAt(0);
                      if(bzh=='、'){
                      	bgh=bgh.substring(1,bgh.length());
                      }
                }
              
               
                bgjl.setBgyy(bgyy);
                bgjl.setBgsxmc(bgsxmc);
                bgjl.setBgqnr(bgq);
                bgjl.setBghnr(bgh);
                bgjl.setBgrq(new Date());
                em.persist(bgjl);
                em.merge(jgdm);
                currentPath = path + "updateSuccess.jsp";
            }
        }.template();


       /* if (result.equalsIgnoreCase("SUCCESS")) {
            if (clsStringTool.isEmpty(djh)) {
//                if(wsbzBus.isWsywByjgdm(jgdmArr[0].getJgdm(),"2")){
                wsbzBus.updateXbByjgdm(jgdmArr[0].getJgdm(), "3", "2", jgdmArr[0]);
                wsbzBus.delWsywByjgdm(jgdmArr[0].getJgdm(), "2");
//                }
            } else {
//                if(wsbzBus.isWsyw(djh,"2")){
                wsbzBus.updateXb(djh, "3", "2", jgdmArr[0]);
                wsbzBus.delWsyw(djh, "2");
//                }
            }
        }*/

        return result;
    }
    public String isnull(String res){
 	   String result="";
 	   if(res==null){
 		   return result="";
 	   }
 	   return result;
    }

    public String update() {
        if (submitType != 0) {
            return auditUpdate();
        }
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();

                User user = (User) session.get("sysUser");
                TBgk bgk = new TBgk();
                BeanUtilsEx.copyProperties(bgk, jgdm2);
                //bgk.setBgsj(new Date());
                em.persist(bgk);
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "17");
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                }
                if (updataType != null && updataType) {
                    addCzjl(em, jgdm, "非证书项变更", "2B", null);
                } else {
                    addCzjl(em, jgdm, "问题数据修改", "F", null);
                }

                boolean noNeedPrint = jgdm2 != null && (jgdm2.getJgdm() != null && jgdm2.getJgdm().equals(jgdm.getJgdm())) &&
                        (jgdm2.getJgmc() != null && jgdm2.getJgmc().equals(jgdm.getJgmc())) &&
                        (jgdm2.getJglx() != null && jgdm2.getJglx().equals(jgdm.getJglx())) &&
                        (jgdm2.getJgdz() != null && jgdm2.getJgdz().equals(jgdm.getJgdz())) &&
                        (jgdm2.getZfrq() != null && DateUtil.dateToStr(jgdm2.getZfrq()).equals(DateUtil.dateToStr(jgdm.getZfrq()))) &&
                        (jgdm2.getXzqh() != null && jgdm2.getXzqh().equals(jgdm.getXzqh()));
                if (InitSysParams.system.getFrbgprintzs())
                    noNeedPrint = noNeedPrint && (jgdm2.getFddbr() != null && jgdm2.getFddbr().equals(jgdm.getFddbr()));
                if (noNeedPrint && !((jgdm2.getJjlx() != null && jgdm2.getJjlx().equals(jgdm.getJjlx())) &&
                        (jgdm2.getZch() != null && jgdm2.getZch().equals(jgdm2.getZch())) &&
                        (jgdm2.getZczj() != null && jgdm2.getZczj().equals(jgdm.getZczj())) &&
                        (jgdm2.getHbzl() != null && jgdm2.getHbzl().equals(jgdm.getHbzl())) &&
                        (jgdm2.getWftzgb() != null && jgdm2.getWftzgb().equals(jgdm.getWftzgb())) &&
                        (jgdm2.getYzbm() != null && jgdm2.getYzbm().equals(jgdm.getYzbm())) &&
                        (jgdm2.getDhhm() != null && jgdm2.getDhhm().equals(jgdm.getDhhm())))) {
                    if ("1".equals(jgdm.getFkbz())) {
                        dy = "1";
                    }
                }
                if ("1".equals(jgdm2.getFkbz())) {
                    List<TkKxxk> kxxks = em.createQuery("select model from TkKxxk model where model.flag= ?1 and model.jgdm=?2 ").setParameter(1, "1").setParameter(2, jgdm.getJgdm()).getResultList();
                    for (TkKxxk kxxk : kxxks) {
                        addCzjl(em, jgdm, "更新卡信息", "R", kxxk.getLsh().longValue());
                    }
                    kxxks = em.createQuery("select model from TkKxxk model where model.haveDown=?1 and model.jgdm=?2 ").setParameter(1, "1").setParameter(2, jgdm.getJgdm()).getResultList();
                    for (TkKxxk kxxk : kxxks) {
                        kxxk.setXgbz("1");
                        kxxk.setHaveDown("0");
                        kxxk.setCzsj(new Date());
                        kxxk.setCzy(user.getUserName());
                        em.merge(kxxk);
                    }
                }
                if (("1".equals(jgdm2.getFkbz())) || ("1".equals(jgdm.getFkbz()))) {
                    Date date = new Date();
                    if (jgdm2.getFksl() > jgdm.getFksl()) {
                        List<TkKxxk> kxxks = em.createQuery(" SELECT model FROM TkKxxk model WHERE model.kxlh is not null and model.jgdm =:jgdm").setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        if (kxxks != null && !kxxks.isEmpty()) {
                            for (int i = jgdm.getFksl(); i < jgdm2.getFksl() && i < kxxks.size(); ++i) {
                                TkKxxk kxxk = kxxks.get(i);
                                TkFzk fzk = new TkFzk();
                                fzk.setJgdm(jgdm.getJgdm());
                                fzk.setKxlh(kxxk.getKxlh());
                                fzk.setFzsj(date);
                                fzk.setOperater(user.getUserName());
                                fzk.setXzqh(user.getBzjgdm());
                                em.persist(fzk);
                            }
                        }
                    } else {
                        for (int i = jgdm2.getFksl(); i < jgdm.getFksl(); ++i) {
                            TkKxxk kxxk = new TkKxxk();
                            kxxk.setCzy(user.getUserName());
                            kxxk.setJgdm(jgdm.getJgdm());
                            kxxk.setBkbz("0");
                            kxxk.setCzsj(date);
                            kxxk.setFkbz("1");
                            kxxk.setSqsj(new Date());
                            kxxk.setFlag("0");
                            kxxk.setGsbz("0");
                            kxxk.setSbbz("0");
                            kxxk.setXzqh(user.getBzjgdm()); 
                            kxxk.setXgbz("0");
                            kxxk.setHaveDown("0");
                            em.persist(kxxk);
                            addCzjl(em, jgdm, "写卡信息", "Q", kxxk.getLsh().longValue());
                        }
                    }

                }

                jgdm.setBgrq(new Date());
                jgdm.setLastdate(new Date());
                jgdm.setLry(user.getUserName());
                jgdm.setLastdate(new Date());
                jgdm.setWtbz(0);
           /*        BeanUtilsEx.copyProperties(jgdm2, jgdm);
                Map<Object, Object> map = BeanUtilsEx.describe(jgdm2);
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    System.out.println("name::value=|" + entry.getKey() + "|" + entry.getValue());
                }*/
                if (!InitSysParams.njjhyMap.containsKey(jgdm.getNjjhy())) {
                    log.error("经济行业对照出错！");
                    message = "输入的经济行业不存在与码表中，请更正！";
                    currentPath = path + "jjhyError.jsp";
                    return;
                }
                em.merge(jgdm);
                ywlclx = 22;
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("非证书项变更");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "1".equals(jgdm.getDybz()) ? "无证书变更" : "变更";
               // if ("update".equals(source))
                 //   addTSmrw(em, SmTaskType.变更);
                deleteSp(em, jgdm.getJgdm(), "17");
                em.flush();
                currentPath = path + "updateSuccess_no.jsp";
            }
        }.template();

    }

    /**
     * 年检
     *
     * @return String
     */
    public String check() {
        if (submitType != 0) {
            return sameName("12");
        }
        final TJgdm[] jgdmArr = {null};
        String result = new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TJgdm jgdm2 = em.find(TJgdm.class, jgdm.getJgdm());
                em.clear();

                TBgk bgk = new TBgk();
                BeanUtilsEx.copyProperties(bgk, jgdm2);
                bgk.setBgsj(new Date());

                em.persist(bgk);
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "12");
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                }
                jgdm.setNjrq(new Date());
                jgdm.setLastdate(new Date());
                jgdm.setBgrq(new Date());
                User user = (User) session.get("sysUser");
                jgdm.setNjr(user.getUserName());
//                String dybz1 = jgdm2.getDybz();
                BeanUtilsEx.copyProperties(jgdm2, jgdm);
//                jgdm2.setDybz(dybz1);
                if (!InitSysParams.njjhyMap.containsKey(jgdm.getNjjhy())) {
                    log.error("经济行业对照出错！");
                    message = "输入的经济行业不存在与码表中，请更正！";
                    currentPath = path + "jjhyError.jsp";
                    return;
                }
                
                em.merge(jgdm2);
                jgdmArr[0] = jgdm2;
                jgdm = jgdm2;
                ywlclx = 10;
                type = "年检";
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("年检");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.年检);
                addCzjl(em, jgdm, "年检", "6", null);
                fksl = jgdm.getFksl() - jgdm2.getFksl();
                if ((fksl >= 1)) {
                    for (int i = 0; i < fksl; ++i) {
                        TkKxxk kxxk = new TkKxxk();
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

                        addCzjl(em, jgdm, "写卡信息", "Q", kxxk.getLsh().longValue());
                    }
                }
                deleteSp(em, jgdm.getJgdm(), "12");
                source = "check";
                currentPath = path + "checkSuccess.jsp";
            }
        }.template();

        if (result.equalsIgnoreCase("success")) {
            if (clsStringTool.isEmpty(djh)) {
                wsbzBus.updateXbByjgdm(jgdmArr[0].getJgdm(), "3", "1", jgdmArr[0]);
            } else {
                wsbzBus.updateXb(djh, "3", "1", jgdmArr[0]);
            }
        }
        return result;
    }

    public String auditValidate() {

        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm.getJgdm() == null) {
                    throw new Exception("输入机构代码错误");
                }
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                deleteSp(em, jgdm.getJgdm(), "01");
                TSpdmtemp spdm = new TSpdmtemp();
                BeanUtilsEx.copyProperties(spdm, jgdm);
                spdm.setLry(user.getUserName());
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setGllsh(spdm.getLsh());
                sp.setFlag("0");
                sp.setShflag("0");
                sp.setYwlx("01");
                sp.setSubmitType(submitType);
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setSendxzqh(jgdm.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                em.persist(sp);
                setTitle("日常业务 &gt;&gt; 代码注销 &gt;&gt; 发送申请");
                setMessage("向省中心提交机构代码（" + jgdm.getJgdm() + "）" + (submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "注销请求成功！");
                setSource("validate");
                currentPath = path + "success.jsp";
            }
        }.template();
    }
    
    //自动恢复注销
    public String auditUnValidate() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (jgdm.getTyshxydm() == null) {
                    throw new Exception("输入机构代码错误");
                }
                deleteSp(em, jgdm.getTyshxydm(), "04");
                TSpdmtemp spdm = new TSpdmtemp();
                jgdm.setJgmc(jgdm.getJgmc());

                BeanUtilsEx.copyProperties(spdm, jgdm);
                spdm.setLry(user.getUserName());
               // spdm.setCzreason(fzreason);
                //spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setFlag("0");
                sp.setShflag("0");
                sp.setJglx(jgdm.getJglx());
               // sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setYwlx("04");
                sp.setSubmitType(submitType);
                sp.setGllsh(spdm.getLsh());
                //sp.setJgdm(jgdm.getJgdm());
                sp.setJgmc(jgdm.getJgmc());
                sp.setTyshxydm(jgdm.getTyshxydm());
                sp.setSendxzqh(user.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                em.persist(sp);
                //saveBus.AddTjgdmFzr(em, fzr, jgdm.getTyshxydm());
                saveBus.AddTjgdmFddbr(em, fddbr, jgdm.getTyshxydm());
                setTitle("日常业务 &gt;&gt; 代码注销恢复 &gt;&gt; 发送申请");
                setMessage("向省中心提交机构代码" + (submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "注销恢复（" + jgdm.getTyshxydm() + "）请求成功！");
                setSource("unvalidate");
                currentPath = path + "success2.jsp";
            }
        }.template();
    }

    
    /**
     * 注销提交
     * LP
     * 2016-6-17
     * @return
     * Version @1.0
     */
    public String validateDM() {
/*        if (submitType != 0) {
            return auditValidate();
        }*/
        String result = new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");

                jgdm = em.find(TJgdm.class, jgdm.getTyshxydm());
                
                TFzdm tfzdm = new TFzdm();
                BeanUtilsEx.copyProperties(tfzdm, jgdm);
                
                tfzdm.setDhhm(fzdm.getDhhm());//单位电话
                tfzdm.setSqzxrq(fzdm.getSqzxrq());//申请注销日期
                tfzdm.setSjghmc(fzdm.getSjghmc());//批准上级公会名称
                tfzdm.setDwzxyy(fzdm.getDwzxyy());//单位注销原因
                tfzdm.setDwzxrq(fzdm.getDwzxrq());//单位注销日期
                tfzdm.setQswbrq(fzdm.getQswbrq());//清算完毕日期
                tfzdm.setPzzxrq(fzdm.getPzzxrq());//上级工会批准注销日期
                tfzdm.setZyzxrq(fzdm.getZyzxrq());//准予注销日期
                tfzdm.setTbrxm(fzdm.getTbrxm());//经办人姓名
                
                tfzdm.setTbrsfzh(fzdm.getTbrsfzh());//经办人证件号码
                tfzdm.setTbrmobile(fzdm.getTbrmobile());//经办人移动电话
                tfzdm.setTbrlxfs(fzdm.getTbrlxfs());//经办人座机
                tfzdm.setMemo(fzdm.getMemo());//备注
                
                //lvwei 20180103 废止库上报
                tfzdm.setZxpzwh(fzdm.getZxpzwh());//注销批准文号
                tfzdm.setDflag(0);
                tfzdm.setArch_Id(fzdm.getArch_Id());
                tfzdm.setYwlx("3");
                
                em.persist(tfzdm);
                String sql = "delete TJgdm where jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();

                addCzjl(em, jgdm, "代码注销", "0", null);

                ywlclx = 7;
                type = "注销";
                //deleteSp(em, jgdm.getJgdm(), "01");
                setTitle("日常业务 &gt;&gt; 代码注销 &gt;&gt; 代码注销成功");
                setMessage(" 统一代码(" + jgdm.getTyshxydm() + ")注销成功");
                setSource("validate");
                currentPath = path + "success.jsp";
            }
        }.template();

        return result;
    }
    
    
    public String auditDelete() {

        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (jgdm.getJgdm() == null) {
                    throw new Exception("输入机构代码错误");
                }
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                deleteSp(em, jgdm.getJgdm(), "03");
                TSpdmtemp spdm = new TSpdmtemp();
                BeanUtilsEx.copyProperties(spdm, jgdm);
                spdm.setLry(user.getUserName());
                spdm.setCzreason(fzreason);
                spdm.setCzyj(fzyj);
                em.persist(spdm);
                TSp sp = new TSp();
                sp.setFlag("0");
                sp.setShflag("0");
                sp.setYwlx("03");
                sp.setSubmitType(submitType);
                sp.setGllsh(spdm.getLsh());
                sp.setJgdm(jgdm.getJgdm());
                sp.setRecexzqh(InitSysParams.system.getXzqhdm().trim());
                sp.setSendxzqh(user.getBzjgdm());
                sp.setSendman(user.getUserName());
                sp.setSendtime(new Date());
                em.persist(sp);
                setTitle("日常业务 &gt;&gt; 代码删除 &gt;&gt; 发送删除申请");
                setMessage("向省中心提交机构代码" + (submitType == 0 ? "" : submitType == 1 ? "重名" : submitType == 2 ? "重注册号" : "名称和注册号重复") + "删除（" + jgdm.getJgdm() + "）请求成功！");
                setSource("delete");
                currentPath = path + "success.jsp";

            }
        }.template();
    }

    /**
     * 删除机构代码
     *
     * @return
     */
    public String delete() {
        if (submitType != 0) {
            return auditDelete();
        }
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                mc = jgdm.getJgdm();
                String sql;
                TLjdm ljdm = new TLjdm();
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "03");
                    if (spdm == null) {
                        throw new Exception("提交审核数据不存在");
                    } else {
                        BeanUtilsEx.copyProperties(ljdm, spdm);
                    }
                } else {
                    BeanUtilsEx.copyProperties(ljdm, jgdm);
                }
                ljdm.setDybz("0");
                ljdm.setLastdate(new Date());
                ljdm.setFzr(user.getUserName());
                em.persist(ljdm);
                em.createQuery("delete TJgdm where jgdm='" + jgdm.getJgdm() + "'").executeUpdate();
                sql = "delete Hzcq where jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                addCzjl(em, jgdm, "代码删除", "T", null);
                if ("1".equals(jgdm.getDybz())) {
                    TBlack black = new TBlack();
                    BeanUtilsEx.copyProperties(black, jgdm);
                    black.setXzqh(InitSysParams.system.getXzqhdm().trim());
                    black.setCzr(user.getUserName());
                    black.setCzrq(new Date());
                    black.setDjh("组代管-" + InitSysParams.system.getXzqhdm().trim() + "-" + jgdm.getZslsh());
                    DateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                    if (jgdm.getBzrq() != null && jgdm.getZfrq() != null)
                        black.setYxdate("自" + format.format(jgdm.getBzrq()) + "至" + format.format(jgdm.getBzrq()));
//                    Map<Object, Object> map = BeanUtilsEx.describe(black);
//                    for (Map.Entry<Object, Object> entry : map.entrySet()) {
//                        System.out.println("entry.getKey()+entry.getValue() = " + entry.getKey() + ":" + entry.getValue());
//                    }
                    em.persist(black);
                    sql = "update TZs set flag='0' where  jgdm='" + jgdm.getJgdm() + "'";
                    em.createQuery(sql).executeUpdate();

                }

                if ("1".equals(jgdm.getFkbz())) {
                    sql = ("select model from  TkFkk model where model.jgdm=:jgdm");
                    List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    if (fkks != null && !fkks.isEmpty())
                        for (int i = 0; i < fkks.size(); i++) {
                            TkFkk fkk = fkks.get(i);
                            TkFzk fzk = new TkFzk();
                            fzk.setFzsj(new Date());
                            fzk.setKxlh(fkk.getKxlh());
                            fzk.setJgdm(fkk.getJgdm());
                            fzk.setOperater(user.getUserName());
                            em.persist(fzk);
                            TBlack black = new TBlack();
                            BeanUtilsEx.copyProperties(black, jgdm);
                            black.setXzqh(user.getBzjgdm());
                            black.setLsh(fkk.getKxlh().toString());
                            black.setType("2");
                            black.setCzr(user.getUserName());
                            black.setCzrq(new Date());
                            em.persist(black);
                        }
                    sql = ("delete from  TkFkk where jgdm=:jgdm");
                    em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                    sql = ("select model from  TkKxxk model where model.jgdm=:jgdm");
                    List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    for (TkKxxk kxxk : kxxks) {
                        addCzjl(em, jgdm, "删除卡信息", "B", kxxk.getLsh().longValue());
                    }
                    em.createQuery("delete TkKxxk where jgdm='" + jgdm.getJgdm() + "'").executeUpdate();
                } else if ("2".equals(jgdm.getFkbz())) {
                    sql = ("select model from  TkFkk model where model.jgdm=:jgdm");
                    List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    if (fkks != null && !fkks.isEmpty()) {
                        for (TkFkk fkk : fkks) {
                            TkFzk fzk = new TkFzk();
                            fzk.setFzsj(new Date());
                            fzk.setKxlh(fkk.getKxlh());
                            fzk.setJgdm(fkk.getJgdm());
                            fzk.setOperater(user.getUserName());
                            em.persist(fzk);
                            TBlack black = new TBlack();
                            BeanUtilsEx.copyProperties(black, jgdm);
                            black.setXzqh(user.getBzjgdm());
                            black.setLsh(fkk.getKxlh().toString());
                            black.setType("2");
                            black.setCzr(user.getUserName());
                            black.setCzrq(new Date());
                            em.persist(black);
                        }
                        em.createQuery("delete TkFkk where jgdm='" + jgdm.getJgdm() + "'").executeUpdate();

                    }
                    sql = ("select model from  TkKxxk model where model.jgdm=:jgdm");
                    List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    em.createQuery("delete from TSmrw model where model.jgdm=:jgdm").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                    for (TkKxxk kxxk : kxxks) {
                        addCzjl(em, jgdm, "删除卡信息", "B", kxxk.getLsh().longValue());
                    }
                    em.createQuery("delete TkKxxk where jgdm='" + jgdm.getJgdm() + "'");
                }

                if (audit) {
                    clearSp(em, jgdm, "03");
                }
                deleteSp(em, jgdm.getJgdm(), "03");
                ywlclx = 11;
                type = "删除";
              //业务流程更新
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("删除");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                em.createQuery("update  TYwlc model set model.isend='2' where  model.jgdm=:jgdm").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                setTitle("日常业务 &gt;&gt; 代码删除 &gt;&gt; 删除成功");
                setMessage(" 机构代码(" + jgdm.getJgdm() + ")删除成功，已经无法使用！");
                setSource("delete");
                currentPath = path + "success.jsp";
            }
        }.template();


    }

    /**
     * 删除机构代码
     *
     * @return
     */
    public String validateAll() {

        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");

                if (allJgdms == null || "".equals(allJgdms)) {
                    throw new Exception("提交审核数据不存在");
                }
                String[] dms = allJgdms.split(",");
                for (String dm : dms) {
                    if (dm.length() != 9)
                        continue;
                    jgdm = em.find(TJgdm.class, dm);
                    TFzdm fzdm = new TFzdm();
                    if (audit) {
                        TSpdmtemp spdm = getSpdm(em, jgdm.getJgdm(), "01");
                        if (spdm == null) {
                            throw new Exception("提交审核数据不存在");
                        } else {
                            BeanUtilsEx.copyProperties(fzdm, spdm);
                        }
                    } else {
                        BeanUtilsEx.copyProperties(fzdm, jgdm);
                    }

                    fzdm.setFzyj(fzyj);
                    fzdm.setFzreason(fzreason);
                    fzdm.setFzrq(new Date());
                    fzdm.setFzr(user.getUserName());
                    em.persist(fzdm);
                    String sql = "delete TJgdm where jgdm='" + jgdm.getJgdm() + "'";
                    em.createQuery(sql).executeUpdate();
                    addCzjl(em, jgdm, "代码注销", "3", null);
                    if (("1".equals(jgdm.getDybz()))) {
                        TBlack black = new TBlack();
                        BeanUtilsEx.copyProperties(black, jgdm);
                        black.setXzqh(InitSysParams.system.getXzqhdm().trim());
                        black.setCzr(user.getUserName());
                        black.setDjh("组代管-" + InitSysParams.system.getXzqhdm().trim() + "-" + jgdm.getZslsh());
                        if (jgdm.getBzrq() != null && jgdm.getZfrq() != null)
                            black.setYxdate("自" + DateUtil.dateToStr(jgdm.getBzrq()) + "至" + DateUtil.dateToStr(jgdm.getZfrq()));
                        black.setCzrq(new Date());
                        em.persist(black);
                        sql = "update  TZs set flag='" + 0 + "' where  jgdm='" + jgdm.getJgdm() + "'";
                        em.createQuery(sql).executeUpdate();
                    }
                    if ("1".equals(jgdm.getFkbz())) {
                        sql = "SELECT model FROM TkFkk model WHERE model.jgdm =:jgdm";
                        Date date = new Date();
                        List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        if (fkks != null && !fkks.isEmpty())
                            for (TkFkk kxxk : fkks) {
                                TkFzk fzk = new TkFzk();
                                fzk.setJgdm(jgdm.getJgdm());
                                fzk.setKxlh(kxxk.getKxlh());
                                fzk.setFzsj(date);
                                fzk.setOperater(user.getUserName());
                                fzk.setXzqh(user.getBzjgdm());
                                em.persist(fzk);
                            }
                        sql = "select model from TkKxxk model where model.jgdm=:jgdm";
                        List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        for (TkKxxk kxxk : kxxks) {
                            addCzjl(em, jgdm, "删除卡信息", "B", kxxk.getLsh().longValue());
                        }
                        sql = "delete TkKxxk where jgdm='" + jgdm.getJgdm() + "'";
                        em.createQuery(sql).executeUpdate();
                    } else if ("2".equals(jgdm.getFkbz())) {
                        sql = "select model from TkFkk model where model.jgdm=:jgdm";
                        List<TkFkk> fkks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        if (fkks != null && !fkks.isEmpty()) {
                            for (TkFkk fkk : fkks) {
                                TkFzk fzk = new TkFzk();
                                fzk.setFzsj(new Date());
                                fzk.setKxlh(fkk.getKxlh());
                                fzk.setJgdm(fkk.getJgdm());
                                fzk.setOperater(user.getUserName());
                                em.persist(fzk);
                                TBlack black = new TBlack();
                                BeanUtilsEx.copyProperties(black, jgdm);
                                black.setXzqh(user.getBzjgdm());
                                black.setLsh(fkk.getKxlh().toString());
                                black.setType("2");
                                black.setCzr(user.getUserName());
                                black.setCzrq(new Date());
                                em.persist(black);
                            }
                            sql = ("UPDATE TkFkk SET flag='0' WHERE flag='1' and jgdm=:jgdm");
                            em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).executeUpdate();


                        }
                        sql = "select model from TkKxxk model where model.jgdm=:jgdm";
                        List<TkKxxk> kxxks = em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).getResultList();
                        for (TkKxxk kxxk : kxxks) {
                            addCzjl(em, jgdm, "注销卡信息", "B", kxxk.getLsh().longValue());
                        }
                        sql = ("DELETE from  TkKxxk WHERE jgdm=:jgdm");
                        em.createQuery(sql).setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                    }
                    if (audit) {
                        clearSp(em, jgdm, "01");
                    }
                }
                ywlclx = 7;
                type = "注销";
                setTitle("日常业务 &gt;&gt; 代码注销 &gt;&gt; 代码注销成功");
                setMessage(" 机构代码批量注销成功，注销代码暂时已经无法使用,若还想重新使用,可在已注销恢复模块中恢复！");
                setSource("validate");
                currentPath = path + "success.jsp";
            }
        }.template();


    }

    public String unValidate() {
        if (submitType != 0) {
            return auditUnValidate();
        }
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TFzdm fzdm = em.find(TFzdm.class, jgdm.getTyshxydm());
                fzdm.setJgdm(jgdm.getTyshxydm().substring(8, 17));
                mc = jgdm.getJgdm();
                if (audit) {
                    TSpdmtemp spdm = getSpdm(em, jgdm.getTyshxydm(), "04");
                    if (spdm == null) {
                        throw new Exception("提交审核数据不存在");
                    } else {
                        BeanUtilsEx.copyProperties(jgdm, spdm);
                    }
                } else {
                    BeanUtilsEx.copyProperties(fzdm, jgdm);
                    BeanUtilsEx.copyProperties(jgdm, fzdm);
                }
                jgdm.setLastdate(new Date());
                jgdm.setDybz("0");
                //lvwei 20180103 上报字段
                jgdm.setDflag(0);
                jgdm.setYwlx("4");
                
                em.persist(jgdm);
                em.createQuery("delete from  TFzdm where tyshxydm=:jgdm").setParameter("jgdm", fzdm.getTyshxydm()).executeUpdate();
                   if("1".equals(jglx)){
                	
                	addCzjl(em, jgdm, "社团代码注销恢复", "C", null);
                }else if("2".equals(jglx)){
                	addCzjl(em, jgdm, "民非代码注销恢复", "C", null);
                }else if("3".equals(jglx)){
                	addCzjl(em, jgdm, "基金会代码注销恢复", "C", null);
                }

                if (audit) {
                    clearSp(em, jgdm, "04");
                }
                deleteSp(em, jgdm.getTyshxydm(), "04");
                ywlclx = 8;
                type = "注销恢复";

                setTitle("日常业务 &gt;&gt; 代码注销 &gt;&gt; 注销恢复成功");
                setMessage(" 机构代码(" + jgdm.getTyshxydm() + ")恢复成功！");
                setSource("unvalidate");
                setYwlx(fzdm.getJglx());
                currentPath = path + "unvalidateSuccess.jsp";
            }
        }.template();
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


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TFzdm> getFzdms() {
        return fzdms;
    }

    public void setFzdms(List<TFzdm> fzdms) {
        this.fzdms = fzdms;
    }

    public String getAllJgdms() {
        return allJgdms;
    }

    public void setAllJgdms(String allJgdms) {
        this.allJgdms = allJgdms;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public Boolean getUpdataType() {
        return updataType;
    }

    public void setUpdataType(Boolean updataType) {
        this.updataType = updataType;
    }

    public String getDzch() {
        return dzch;
    }

    public void setDzch(String dzch) {
        this.dzch = dzch;
    }

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public List<TNNjjlx> getJjlx() {
		return jjlx;
	}

	public void setJjlx(List<TNNjjlx> jjlx) {
		this.jjlx = jjlx;
	}

	public TFzr getFzr() {
		return fzr;
	}

	public void setFzr(TFzr fzr) {
		this.fzr = fzr;
	}

	public List<TFzr> getListFzr() {
		return listFzr;
	}

	public void setListFzr(List<TFzr> listFzr) {
		this.listFzr = listFzr;
	}

	public String getIsdang() {
		return isdang;
	}

	public void setIsdang(String isdang) {
		this.isdang = isdang;
	}

	public List<ScZw> getZwList() {
		return zwList;
	}

	public void setZwList(List<ScZw> zwList) {
		this.zwList = zwList;
	}

	public String getZxpzwh() {
		return zxpzwh;
	}

	public void setZxpzwh(String zxpzwh) {
		this.zxpzwh = zxpzwh;
	}

	public String getFzrq() {
		return fzrq;
	}

	public void setFzrq(String fzrq) {
		this.fzrq = fzrq;
	}

	public TFzdm getFzdm() {
		return fzdm;
	}

	public void setFzdm(TFzdm fzdm) {
		this.fzdm = fzdm;
	}

	public List<TFddbr> getListFddbr() {
		return listFddbr;
	}

	public void setListFddbr(List<TFddbr> listFddbr) {
		this.listFddbr = listFddbr;
	}

	public TFddbr getFddbr() {
		return fddbr;
	}

	public void setFddbr(TFddbr fddbr) {
		this.fddbr = fddbr;
	}

	public TFrjl getFrjl() {
		return frjl;
	}

	public void setFrjl(TFrjl frjl) {
		this.frjl = frjl;
	}

	public List<TBgk> getListBgk() {
		return listBgk;
	}

	public void setListBgk(List<TBgk> listBgk) {
		this.listBgk = listBgk;
	}

	public TBgk getBgk() {
		return bgk;
	}

	public void setBgk(TBgk bgk) {
		this.bgk = bgk;
	}

	public TFddbr getTfddbr() {
		return tfddbr;
	}

	public void setTfddbr(TFddbr tfddbr) {
		this.tfddbr = tfddbr;
	}

	public TFrjl getTfrjl() {
		return tfrjl;
	}

	public void setTfrjl(TFrjl tfrjl) {
		this.tfrjl = tfrjl;
	}

	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

	public String getXjwh() {
		return xjwh;
	}

	public void setXjwh(String xjwh) {
		this.xjwh = xjwh;
	}

	public String getJlrq() {
		return jlrq;
	}

	public void setJlrq(String jlrq) {
		this.jlrq = jlrq;
	}

	public String getJlwh() {
		return jlwh;
	}

	public void setJlwh(String jlwh) {
		this.jlwh = jlwh;
	}

	public String getXjrq() {
		return xjrq;
	}

	public void setXjrq(String xjrq) {
		this.xjrq = xjrq;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBgxzqh() {
		return bgxzqh;
	}
	public void setBgxzqh(String bgxzqh) {
		this.bgxzqh = bgxzqh;
	}
	public String getBgjgdz() {
		return bgjgdz;
	}
	public void setBgjgdz(String bgjgdz) {
		this.bgjgdz = bgjgdz;
	}
	public String getBgyzbm() {
		return bgyzbm;
	}
	public void setBgyzbm(String bgyzbm) {
		this.bgyzbm = bgyzbm;
	}
	public String getJgdz() {
		return jgdz;
	}
	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}
	public String getZgmc() {
		return zgmc;
	}
	public void setZgmc(String zgmc) {
		this.zgmc = zgmc;
	}
	public String getZgdm() {
		return zgdm;
	}
	public void setZgdm(String zgdm) {
		this.zgdm = zgdm;
	}
	public String getQtzw() {
		return qtzw;
	}
	public void setQtzw(String qtzw) {
		this.qtzw = qtzw;
	}   

}