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

    //xiaruibo 20180531 ����Ǩַ����
    public String searchBy(){
   	 return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
           	 String tydm = jgdm.getTyshxydm();
           	 System.out.println("ͳһ�����룺"+jgdm.getTyshxydm());
           	 
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
           		 setMessage("��������ȷ�Ļ������룡");
           		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
           		 return;    
           	 }

           	 List<Object[]> jgdmList = em.createQuery(" select model.jgmc,model.bzjgdm,model.jglx from TJgdm model where model.tyshxydm = '"+tydm+"'").getResultList();
           	 if(jgdmList.size() == 0){
           		 setMessage("��ѯ�����ݲ����ڣ�û�д�����Ӧ�Ļ����������ݣ�");
           		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
           		 return; 
           	 }else if(jgdmList.size()>1){
           		 setMessage("���ڲ�ֹһ����Ǩַ������Ϣ�����������ݣ�����ϵϵͳ����Ա��");
           		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
           		 return; 
           	 }
//lvwei 2018-01-16 ����Ǩַ��������Ȩ��    
           	 HttpServletRequest request = ServletActionContext.getRequest(); 
           	 User user = (User)request.getSession().getAttribute("sysUser");
           	 String user_bzjgdm = user.getBzjgdm();          		
           	//ȫ���˺�		        	 
           	if(user_bzjgdm.substring(1).equals("00000")){
           		 for(Object[] obj : jgdmList){	 
           			 jgdm.setJgmc((String)obj[0]);
       				 jgdm.setBzjgdm((String)obj[1]);
       				 jgdm.setJglx((String)obj[2]);
       			 }
           		 	currentPath = path + "updateBzjgdm.jsp";
           	//ʡ���˺�
           	}else if(user_bzjgdm.substring(2).equals("0000")){
           		for(Object[] obj : jgdmList){	 
      				 	if(!user_bzjgdm.substring(0,2).equals((String)obj[1].toString().substring(0,2))){
      					 setMessage("��ǰ�˺���Ȩ���д˻�����Ǩַ");
                  		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
                  		 return; 
      				 	}
      				 jgdm.setJgmc((String)obj[0]);
      				 jgdm.setBzjgdm((String)obj[1]);
      				 jgdm.setJglx((String)obj[2]);
      			 	}
           		currentPath = path + "updateBzjgdm.jsp";
           	//�м��˺�
           	}else if(user_bzjgdm.substring(4).equals("00")){
           		for(Object[] obj : jgdmList){	 
      				 	if(!user_bzjgdm.substring(0,4).equals((String)obj[1].toString().substring(0,4))){
      					 setMessage("��ǰ�˺���Ȩ���д˻�����Ǩַ");
                  		 currentPath = path + "search_"+jglx+"_bzjgdm.jsp";
                  		 return; 
      				 	}
      				 jgdm.setJgmc((String)obj[0]);
      				 jgdm.setBzjgdm((String)obj[1]);
      				 jgdm.setJglx((String)obj[2]);
      			 	}
           		currentPath = path + "updateBzjgdm.jsp";
           	//�����˺�
           	}else{
           		for(Object[] obj : jgdmList){	 
      				 	if(!user_bzjgdm.equals((String)obj[1])){
      					 setMessage("��ǰ�˺���Ȩ���д˻�����Ǩַ");
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
    //xiaruibo 20180531 ����Ǩַ�޸�
    public String upBzjgdm(){

    	return new ActionUtils() {
    		@Override
    		protected void excute() throws Exception {

    			System.out.println("��֤�������룺"+jgdm.getBzjgdm());
    			Object bzjgdm_mc = em.createQuery(" select model.mc from Bzjgdm model where model.dm = '"+jgdm.getBzjgdm()+"'").getSingleResult();
    			
    			String sql = "update TJgdm model set model.bzjgdm = '"+jgdm.getBzjgdm()+"',model.pzjgmc = '"+bzjgdm_mc.toString()+"',model.savetype = '0',model.lastdate='"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"'  where tyshxydm ='"+jgdm.getTyshxydm()+"'" ;
    			em.createQuery(sql).executeUpdate();
    			setMessage("ͳһ���룺"+jgdm.getTyshxydm()+" ��֤�����޸ĳɹ�");
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
                        title = "Ǩ��";
                        ywlc.setType(title);

                    } else if ("outerIn".equals(source)) {
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    } else if ("innerOut".equals(source)) {
                        ywlc.setYwlclx(14);
                        title = "Ǩַ";
                        ywlc.setType(title);

                    } else if ("outerOut".equals(source)) {
                        ywlc.setYwlclx(15);
                        title = "Ǩַ";
                        ywlc.setType(title);

                    } else if ("innerRedo".equals(source)) {
                        ywlc.setYwlclx(20);
                        title = "ʡ��Ǩַ�ָ�";
                        ywlc.setType(title);

                    } else if ("outerRedo".equals(source)) {
                        ywlc.setYwlclx(21);
                        title = "ʡ��Ǩַ�ָ�";
                        ywlc.setType(title);

                    } else if ("yfmIn".equals(source)) {
                        ywlc.setYwlclx(18);
                        title = "Ǩ��";
                        ywlc.setType(title);

                    } else if ("yfmOut".equals(source)) {
                        ywlc.setYwlclx(17);
                        title = "Ǩַ";
                        ywlc.setType(title);

                    } else if ("yfmRedo".equals(source)) {
                        ywlc.setYwlclx(17);
                        title = "Ԥ����ָ�";
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
                    setMessage("�������,�Ҳ����ύ��˵�����");
                    currentPath = path + "search.jsp?source=" + source;
                    return;
                }
                if (source == null) {
                    setMessage("����������,ϵͳ·������");
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
                        //1�Ƕ������ 0�ǰ�֤���ڼ�һ��
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
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ��Ǩַ����");
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
                        //1�Ƕ������ 0�ǰ�֤���ڼ�һ��
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
                    //--------------�������ݴ���--------------------
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
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ��Ǩַ����");
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
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ��Ǩַ����");
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
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ�Ļ�����������");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }
                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    em.clear();
                    
                    String value = CommonPropertiesUtil.getValue("common.properties", "snqc");
                    //0�ǲ���Ҫ�޸Ĵӿ���ȡֵ,1����Ҫ�޸Ĵ�ҳ���ȡֵ
                    if(value.equals("0")){
                    	 currentPath = path +"innerOut2.jsp";
                    }else if(value.equals("1")){
                    	 currentPath = path + "innerOut.jsp";
                    }
                    
                   
                }
                if ("outerOut".equals(source)) {
                    jgdm = em.find(TJgdm.class, mc);
                    if (jgdm == null) {
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ�Ļ�����������");
                        currentPath = path + "search.jsp?source=" + source;
                        return;
                    }

                    if (chufa(em)) {
                        source = "change_" + source;
                        return;
                    }
                    em.clear();
                    String value = CommonPropertiesUtil.getValue("common.properties", "sjqc");
                    //0�ǲ���Ҫ�޸Ĵӿ���ȡֵ,1����Ҫ�޸Ĵ�ҳ���ȡֵ
                    if(value.equals("0")){
                    	 currentPath = path + "outerOut2.jsp";
                    }else if(value.equals("1")){
                    	 currentPath = path + "outerOut.jsp";
                    }
                }
                if ("yfmOut".equals(source)) {
                    List<TJgdmSave> jgdmSaves = em.createQuery("select model from TJgdmSave model where model.jgdm=:jgdm").setParameter("jgdm", mc).getResultList();
                    if (jgdmSaves == null || jgdmSaves.isEmpty() || jgdmSaves.size() < 1) {
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ�Ļ�����������");
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
                        setMessage("��ѯ�����ݲ�����,û�д�����Ӧ��Ǩַ����");
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
     * ʡ��Ǩ��
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
                //��ȡ�����ļ�
                String value = CommonPropertiesUtil.getValue("common.properties", "snqc");
                //0�ǲ���Ҫ�޸Ĵӿ���ȡֵ,1����Ҫ�޸Ĵ�ҳ���ȡֵ
                if(value.equals("0")){
                	jgdm1=jgdm2;	
                }else if(value.equals("1")){
                	jgdm1 = jgdm;
                }
                em.clear();
                TQzjgdm qzjgdm = new TQzjgdm();
                BeanUtilsEx.copyProperties(qzjgdm, jgdm1);
                //��ǰ��֤
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
                    addCzjl(em, jgdm, "ʡ��Ǩ��,����", "B", kxxk.getLsh().longValue());
                setMessage("�������루" + jgdm.getJgdm() + "��ʡ�ڰ�֤��ַǨ���ɹ��������Ҫ�ָ����뵽��ʡ��Ǩַ�ָ���ҳ����в�����");
                jgdm = jgdm1;
                ywlclx = 14;
              //ҵ�����̸���
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("Ǩַ");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.ʡ��Ǩ��);
                type = "Ǩַ";
                deleteSp(em, jgdm.getJgdm());
                setSource("innerOut");
                addCzjl(em, jgdm, "ʡ��Ǩ��", "G", null);
                setTitle("ʡ��Ǩ��");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * ʡ��Ǩ��
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
                    log.error("������ҵ���ճ���");
                    message = "����ľ�����ҵ������������У��������";
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
                        addCzjl(em, jgdm, "������Ϣ", "Q", kxxk.getLsh().longValue());
                    }
                }
                addCzjl(em, jgdm, "������Ϣ", "Q", null);
                em.createQuery("delete from TQzjgdm   where id=" + qzjgId).executeUpdate();
                ywlclx = 16;
              //ҵ�����̸���
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("Ǩ��");
                		yw.setIsend("1");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.ʡ��Ǩ��);
                type = "Ǩ��";
                setMessage("�������루" + jgdm.getJgdm() + "��ʡ�ڰ�֤������ַǨ��ɹ���");
                setTitle("ʡ��Ǩ��");
                deleteSp(em, jgdm.getJgdm(), "06");
                addCzjl(em, jgdm, "ʡ��Ǩ��", "9", null);
                source = "innerIn";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * Ԥ����Ǩ��
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
                    //��ǰ��֤
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
                    setMessage("�������루" + jgdm.getJgdm() + "��Ԥ����Ǩַ�ɹ���");
                    BeanUtilsEx.copyProperties(jgdm, jgdmSave);
                    ywlclx = 17;
                  
                    deleteSp(em, jgdm.getJgdm());
                    //   addTSmrw(em, SmTaskType.Ԥ����);
                    type = "Ǩַ";
                    setSource("yfmOut");
                } catch (NumberFormatException e) {
                    log.error(ChangeBZAddressAction.class, e);
                }
                addCzjl(em, jgdm, "Ԥ����Ǩ��", "G", null);
                setTitle("Ԥ����Ǩ��");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * Ԥ����Ǩ��
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
             
                type = "Ǩ��";
                setMessage("�������루" + jgdm.getJgdm() + "��Ԥ�����ַǨ��ɹ���");
                setTitle("Ԥ����Ǩ��");
                deleteSp(em, jgdm.getJgdm(), "14");
                addCzjl(em, jgdm, "Ԥ����Ǩ��", "9", null);
                source = "yfmIn";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * Ԥ����Ǩ������
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
                setMessage((submitType == 0 ? "" : submitType == 1 ? "����" : submitType == 2 ? "��ע���" : "���ƺ�ע����ظ�") + "Ǩ���������(" + jgdm.getJgdm() + ")�������Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ���Ǩ��˴��룡");
                source = "yfmIn";
                audit = true;
                setTitle("Ԥ����Ǩ������");
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
                setMessage((submitType == 0 ? "" : submitType == 1 ? "����" : submitType == 2 ? "��ע���" : "���ƺ�ע����ظ�") + "Ǩ���������(" + jgdm.getJgdm() + ")�������Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ���Ǩ��˴��룡");
                source = sc;
                audit = true;
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * *
     * *Ԥ����Ǩ���ָ�
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
                addCzjl(em, jgdm, "Ǩַ�ָ�", "V", null);
                ywlclx = 20;
              
                type = "Ԥ����ָ�";
                setMessage("�ָ�Ԥ����(" + jgdm.getJgdm() + ")�����ɹ�");
                setSource("yfmRedo");
                setTitle("Ԥ����ָ��ɹ�");
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
                    throw new Exception("Ǩַ�����ݲ�����");
                } else if (qzjgdms.size() > 1) {
                    throw new Exception("���ڲ�ֹһ����Ǩַ������Ϣ");
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
                setMessage((submitType == 0 ? "" : submitType == 1 ? "����" : submitType == 2 ? "��ע���" : "���ƺ�ע����ظ�") + "�ָ���������(" + jgdm.getJgdm() + ")�������Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Իָ��˴��룡");
                source = "innerRedo";
                audit = true;
                setTitle("ʡ��Ǩַ�ָ�����");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * Ǩ�ƻָ�--ֻ����ʡ�ڵ�
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
                        throw new Exception("Ǩַ��������ݲ�����");
                    }
                    BeanUtilsEx.copyProperties(jgdm, spdm);

                } else {
                    sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='1'";
                    query = em.createQuery(sql);
                    List<TQzjgdm> qzjgdms = query.setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        throw new Exception("Ǩַ�����ݲ�����");
                    } else if (qzjgdms.size() > 1) {
                        throw new Exception("���ڲ�ֹһ����Ǩַ������Ϣ");
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                    jgdm.setXzqh(qzjgdm.getQzxzqh());
                }
                jgdm.setLry(user.getUserName());
                jgdm.setLastdate(new Date());
                jgdm.setQzbz("0");
                //�޸Ĵ�ӡ��־ 1
                jgdm.setDybz("1");
                em.persist(jgdm);
                sql = " delete from TQzjgdm where jgdm='" + jgdm.getJgdm() + "'";
                //TSmrwsc smrwsc = qzjgdms.get(0);
                //BeanUtilsEx.copyProperties(jgdm, smrwsc);
                //sql2 = " delete from TSmrw where jgdm='" + jgdm.getJgdm() + "'";
                //em.createQuery(sql2).executeUpdate();
               
                em.createQuery(sql).executeUpdate();
                addCzjl(em, jgdm, "Ǩַ�ָ�", "V", null);
                
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
                        addCzjl(em, jgdm, "������Ϣ", "Q", kxxk.getLsh().longValue());
                    }
                }
                if (audit) {
                    clearSp(em, jgdm, "05");
                }
                audit = false;
                ywlclx = 20;
              //ҵ�����̸���
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("��ӡ֤��");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "ʡ��Ǩַ�ָ�";
                setMessage("�ָ���������(" + jgdm.getJgdm() + ")�����ɹ�");
                setSource("innerRedo");
                setTitle("ʡ��Ǩַ�ָ��ɹ�");
                currentPath = path + "success.jsp";

            }
        }.template();

    }

    /**
     * ʡ��Ǩַ�ָ����
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
                    throw new Exception("Ǩַ�����ݲ�����");
                } else if (qzjgdms.size() > 1) {
                    throw new Exception("���ڲ�ֹһ����Ǩַ������Ϣ");
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
                setMessage((submitType == 0 ? "" : submitType == 1 ? "����" : submitType == 2 ? "��ע���" : "���ƺ�ע����ظ�") + "�ָ���������(" + jgdm.getJgdm() + ")�������Ѿ����͸�ʡ���ġ�һ��ʡ������˺󣬾Ϳ��Իָ��˴��룡");
                audit = true;
                source = "outerRedo";
                setTitle("ʡ��Ǩַ�ָ�����ɹ�");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    /**
     * ʡ��Ǩ�ƻָ�--ֻ����ʡ�ڵ�
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
                        throw new Exception("Ǩַ��������ݲ�����");
                    }
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                } else {
                    sql = "select model from TQzjgdm model where model.jgdm=:jgdm and model.qzbz='3'";
                    query = em.createQuery(sql);
                    List<TQzjgdm> qzjgdms = query.setParameter("jgdm", jgdm.getJgdm()).getResultList();
                    if (qzjgdms == null || qzjgdms.isEmpty()) {
                        throw new Exception("Ǩַ�����ݲ�����");
                    } else if (qzjgdms.size() > 1) {
                        throw new Exception("���ڲ�ֹһ����Ǩַ������Ϣ");
                    }
                    TQzjgdm qzjgdm = qzjgdms.get(0);
                    BeanUtilsEx.copyProperties(jgdm, qzjgdm);
                }
                jgdm.setLry(user.getUserName());
                jgdm.setLastdate(new Date());
                jgdm.setBzjgdm(user.getBzjgdm());
                jgdm.setQzbz("0");
                //��ӡ��־1
                jgdm.setDybz("1");
                em.persist(jgdm);
                sql = " delete from TQzjgdm where jgdm='" + jgdm.getJgdm() + "'";
                em.createQuery(sql).executeUpdate();
                addCzjl(em, jgdm, "Ǩַ�ָ�", "V", null);

                //�ı��ӡ��־
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
                        addCzjl(em, jgdm, "������Ϣ", "Q", kxxk.getLsh().longValue());
                    }
                }
                if (audit) {
                    clearSp(em, jgdm, "05");
                }
                audit = false;
                ywlclx = 21;
              //ҵ�����̸���
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("��ӡ֤��");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "ʡ��Ǩַ�ָ�";
                setMessage("�ָ���������(" + jgdm.getJgdm() + ")�����ɹ�");
                setSource("outerRedo");
                setTitle("ʡ��Ǩַ�ָ�");
                currentPath = path + "success.jsp";

            }
        }.template();

    }

    /**
     * ʡ��Ǩ��
     *
     * @return String
     */

    public String outerOut() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TJgdm jgdm1 = null;
              //��ȡ�����ļ�
                String value = CommonPropertiesUtil.getValue("common.properties", "sjqc");
                //0�ǲ���Ҫ�޸Ĵӿ���ȡֵ,1����Ҫ�޸Ĵ�ҳ���ȡֵ
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
                    addCzjl(em, jgdm, "ʡ��Ǩ��,����", "B", kxxk.getLsh().longValue());
                sql = "DELETE FROM TkKxxk WHERE jgdm='" + jgdm.getJgdm() + "'";

                em.createQuery(sql).executeUpdate();
                // em.createQuery("delete  from TSmrw  model where model.jgdm=:jgdm and model.status=false").setParameter("jgdm", jgdm.getJgdm()).executeUpdate();
                jgdm = jgdm1;
                ywlclx = 15;
              //ҵ�����̸���
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("Ǩַ");
                		yw.setIsend("2");
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                addTSmrw(em, SmTaskType.ʡ��Ǩ��);
                type = "Ǩַ";
                setMessage("�������루" + jgdm.getJgdm() + "��ʡ��Ǩ���ɹ���");
                addCzjl(em, jgdm, "ʡ��Ǩ��", "G", null);
                setSource("outerOut");
                deleteSp(em, jgdm.getJgdm());
                setTitle("ʡ��Ǩ��");
                currentPath = path + "success.jsp";
            }
        }.template();

    }

    /**
     * ʡ��Ǩ��
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
                    log.error("������ҵ���ճ���");
                    message = "����ľ�����ҵ������������У��������";
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
                        addCzjl(em, jgdm, "������Ϣ", "Q", kxxk.getLsh().longValue());
                    }
                } 
                addTSmrw(em, SmTaskType.ʡ��Ǩ��);
                em.createQuery("delete TQzjgdmSj where jgdm='" + jgdm.getJgdm() + "'").executeUpdate();
                ywlclx = 16;
              //ҵ�����̸���
                	List<TYwlc> ywlcs = em.createQuery("from TYwlc where jgdm='"+jgdm.getJgdm()+"' and isend='0' order by clsj desc").getResultList();
                	if(ywlcs!=null&&ywlcs.size()>0){
                		TYwlc yw=ywlcs.get(0);
                		yw.setType("Ǩ��");
                		yw.setIsend("1");
                		yw.setJgmc(jgdm.getJgmc());
                		
                		em.merge(yw);
                		
                		TYwlcLog ywlog=new TYwlcLog();
                		BeanUtilsEx.copyProperties(ywlog, yw);
                		ywlog.setId(null);
                		em.persist(ywlog);
                }
                type = "Ǩ��";
                setMessage("�������루" + jgdm.getJgdm() + "��ʡ��Ǩ��ɹ���");
                setTitle("ʡ��Ǩ��");
                deleteSp(em, jgdm.getJgdm(), "13");
                addCzjl(em, jgdm, "ʡ��Ǩ��", "9", null);

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