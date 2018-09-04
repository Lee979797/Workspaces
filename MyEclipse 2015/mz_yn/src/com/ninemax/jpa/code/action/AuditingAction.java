/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.*;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.TjgdmCommon;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author Liuzy
 */
public class AuditingAction extends ActionSupport {
    private static final String path = "/product/jsp/auditing/";
    private AuditingBus auditBus;
    private WsbzXbBus wsbzBus;
    private String resultMsg = "";
    private String currentPath = "";
    private String source = "";
    private String title = "";
    private List<SmUser> userList;
    private List<TSp> spList;
    private List<TjgdmCommon> jgdms;
    private TSp sp;
    private Map<String, String> ywlxs;
    private SmUser user;
    private clsPageComponent pages;
    private Integer rowNumsView = 20; 
    private Integer pageno = 1;
    private String ispass;
    private TSpdmtemp jgdm;
    private TSppz sppz;
    private List<TJgdmWw> jgdmwws;
    private String _jgdm;
    private String bzjgdm;
    private Page page;
    private Date startDate;
    private Date endDate;
    private Boolean cfmc;
    private Boolean cfzch;
    private String jglx;
    public AuditingAction() {
        if (auditBus == null)
            auditBus = new AuditingBus();

        if (wsbzBus == null) {
            wsbzBus = new WsbzXbBus();
        }
    }

    //审核用户列表
    public String auditUserList() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                HttpSession session = ServletActionContext.getRequest().getSession();
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("username");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by user." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                userList = em.createQuery("select user from SmUser user where user.usertype='1' and user.userstatus='0'" + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(user) from SmUser user where user.usertype = '1'and user.userstatus = '0'")
                        .getResultList().get(0)).intValue());
                currentPath = path + "auditUser_list.jsp";
            }
        }.template();
    }

    //要审核的用户
    public String userOfAudit() {
        user = auditBus.findUserById(user.getId());
        if (clsStringTool.isEmpty(currentPath))
            currentPath = "/product/jsp/auditing/user_auditing.jsp";
        return this.SUCCESS;
    }

    //审核用户
    public String auditUser() {
        resultMsg = auditBus.auditingUser(user, ispass);
        currentPath = "/product/jsp/auditing/success.jsp";
        source = "auditUserList";
        setTitle("用户审核");
        return this.SUCCESS;
    }

    //要审核的内网数据列表
    public String inDataList() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                HttpSession session = ServletActionContext.getRequest().getSession();
                User user = (User) session.getAttribute("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("sendtime");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TSp model where model.flag='0' and model.jglx='" + jglx + "' ";
                if (_jgdm != null && !"".equals(_jgdm)) {
                    sql += " and model.tyshxydm = '" + _jgdm + "'  ";
                } else {
                    if (startDate != null) {
                        sql += " and model.sendtime >= '" + DateUtil.dateToStr(startDate) + "'  ";
                    }
                    if (endDate != null) {
                        sql += " and model.sendtime < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                    }
                }
                if (bzjgdm != null && !"".equals(bzjgdm)) {
                    sql += " and model.bzjgdm like '%" + bzjgdm + "%'";
                }
                spList = em.createQuery("select model" + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath = path + "auditIndata_list.jsp";
            }
        }.template();
    }

    public String outDataList() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                HttpSession session = ServletActionContext.getRequest().getSession();
                User user = (User) session.getAttribute("sysUser");

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("asc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TJgdmWw model where  model.bzjgdm=:bzjgdm  and  model.status='0'";
                if (_jgdm != null && !"".equals(_jgdm)) {
                    sql += " and model.jgdm like '%" + _jgdm + "%'  ";
                } else {
                    if (startDate != null) {
                        sql += " and model.bzrq >= '" + DateUtil.dateToStr(startDate) + "'  ";
                    }
                    if (endDate != null) {
                        sql += " and model.bzrq < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                    }
                }
                jgdmwws = em.createQuery("select model " + sql + orderBy)
                        .setParameter("bzjgdm", user.getBzjgdm())
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .setParameter("bzjgdm", user.getBzjgdm())
                        .getResultList().get(0)).intValue());
                currentPath = path + "auditOutData_list.jsp";
            }
        }.template();
    }

    public String findInData() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                sp = em.find(TSp.class, sp.getLsh());
                //TSppz sppz = em.find(TSppz.class, sp.getYwlx());
                jgdm = em.find(TSpdmtemp.class, sp.getGllsh());
                if("11".equals(sp.getYwlx())){
                	jgdm.setJgdm(jgdm.getJgdm());
                }else{
                	
                	jgdm.setJgdm(jgdm.getTyshxydm().length() == 18 ? jgdm.getJgdm() : "");
                }
                currentPath = path + "indata_auditing.jsp";
            }
        }.template();
    }

    public String _findInSameName() {
        return new ActionUtils() {
            private TjgdmCommon make(Object[] objects) {
                TjgdmCommon vo = new TjgdmCommon();
                System.out.println("判读"+objects[0]);
                if(objects[0]==null){
                	 vo.setTyshxydm("");
                }else{
                	
                	vo.setTyshxydm(objects[0].toString().trim().equals("") ? objects[7].toString() : objects[0].toString());
                }
                vo.setJgmc(objects[1].toString());
                vo.setFddbr(objects[2]==null ? "" : objects[2].toString());
                vo.setSjly(objects[4].toString());
                vo.setBzjgdm(objects[3] == null ? "0" : objects[3].toString());
                vo.setTableName(objects[5].toString());
                vo.setZjhm(objects[6] == null ? "无" : objects[6].toString());
                vo.setId((objects[7] == null || objects[7].equals("0")) ? "无" : objects[7].toString());
                vo.setZfrq((objects[8] == null ? null : (Date) objects[8]));
                return vo;
            }

            public void get(int type, String... mcs) {
                String where = "";
                if (type == 1) {
                	System.out.println(mcs[0]);
                    where += " where jgmc = '" + mcs[0] + "' ";
                }
                if (type == 2) {
                	System.out.println(mcs[1] );
                    where += " where zch = '" + mcs[1] + "' ";
                }
                if (type == 3) {
                    where += " where (jgmc = '" + mcs[0] + "' or zch = '" + mcs[1] + "') ";
                }
                if (type == 5) {
                    //where += " where (jgmc = '" + mcs[0] + "' or zch = '" + mcs[1] + "') and zjhm= '"+mcs[2]+"'";
                    where += " where zjhm= '"+mcs[2]+"'";

                }
                String save = (jgdm.getTyshxydm().trim().length() == 18  ? " tyshxydm" : " id") + " = '" + jgdm.getTyshxydm().trim() + "' ";
                String sql = "SELECT tyshxydm,jgmc,fddbr,jglx,'临时表' AS sjly,'t_jgdm_save' AS tablename,zch, id,NULL FROM t_jgdm_save where   " + save +
                        "UNION SELECT tyshxydm,jgmc,fddbr,jglx,'有效库' AS sjly,'t_jgdm' AS tablename,zch,0,NULL FROM t_jgdm where tyshxydm='" + jgdm.getTyshxydm().trim() + "' " +
                        
                        "UNION SELECT tyshxydm,jgmc,fddbr,jglx,'注销库' AS sjly,'t_fzdm' AS tablename,zch,0,fzrq FROM t_fzdm  where tyshxydm='" + jgdm.getTyshxydm().trim() + "' ";
                Query query = em.createNativeQuery(sql);
                List<Object[]> returnList = query.getResultList();
                if (returnList != null && returnList.size() > 0) {
                    Object[] objects = returnList.get(0);
                    jgdms.get(0).setSjly(objects[4].toString());
                    jgdms.get(0).setTableName(objects[5].toString());
                }
                save = (jgdm.getTyshxydm().trim().length() == 18 ? " tyshxydm" : " id ") + " <> '" + jgdm.getTyshxydm().trim() + "' ";
                sql = "SELECT tyshxydm,jgmc,fddbr,jglx,'临时表' AS sjly,'t_jgdm_save' AS tablename,zch, id,NULL FROM t_jgdm_save " + where + " and " + save +
                        " UNION SELECT tyshxydm,jgmc,fddbr,jglx,'有效库' AS sjly,'t_jgdm' AS tablename,zch,0,NULL FROM t_jgdm " + where + " and tyshxydm <> '" + jgdm.getTyshxydm().trim() + "' " +
                       
                        " UNION SELECT tyshxydm,jgmc,fddbr,jglx,'注销库' AS sjly,'t_fzdm' AS tablename,zch,0,fzrq FROM t_fzdm  " + where + " and tyshxydm <> '" + jgdm.getTyshxydm().trim() + "' ";
                query = em.createNativeQuery(sql);
                returnList = query.getResultList();
                if (returnList != null && returnList.size() > 0) {
                    for (Object[] objects : returnList) {
                        jgdms.add(make(objects));

                    }
                }
           /*     save = (jgdm.getTyshxydm().trim().length() == 18 ? " tyshxydm" : " id ") + " = '" + jgdm.getTyshxydm().trim() + "' ";
                sql = "SELECT tyshxydm,jgmc,fddbr,jglx,'临时表' AS sjly,'t_jgdm_save' AS tablename,zch, id,NULL FROM t_jgdm_save " + where + " and " + save +
                " UNION SELECT tyshxydm,jgmc,fddbr,jglx,'有效库' AS sjly,'t_jgdm' AS tablename,zch,0,NULL FROM t_jgdm " + where + " and tyshxydm = '" + jgdm.getTyshxydm().trim() + "' " +
               
                " UNION SELECT tyshxydm,jgmc,fddbr,jglx,'注销库' AS sjly,'t_fzdm' AS tablename,zch,0,fzrq FROM t_fzdm  " + where + " and tyshxydm = '" + jgdm.getTyshxydm().trim() + "' ";
                query = em.createNativeQuery(sql);
                returnList = query.getResultList();
                if (returnList != null && returnList.size() > 0) {
                	for (Object[] objects : returnList) {
                		jgdms.add(make(objects));

                	}
                }*/
            	
            /*     sql = "SELECT jgdm,jgmc,fddbr,jglx,'BS注销库' AS sjly,'t_fzdm' AS tablename,zch,0,fzrq FROM t_fzdm  where jgmc='" + jgdm.getJgmc().trim() + "' ";
                 Query querybss = CheckEntityManagerHelper.getEntityManager().createNativeQuery(sql);
                 returnList = querybss.getResultList();
                 if (returnList != null && returnList.size() > 0) {
                	 Object[] objects = returnList.get(0);
                	 jgdms.get(0).setSjly(objects[4].toString()); 
                	 jgdms.get(0).setTableName(objects[5].toString());
                 }*/
                 save = (jgdm.getTyshxydm().trim().length() == 18 ? " tyshxydm" : " id ") + " <> '" + jgdm.getTyshxydm().trim() + "' ";
                 sql = "SELECT jgdm,jgmc,fddbr,jglx,'BS注销库' AS sjly,'t_fzdm' AS tablename,zch,0,fzrq FROM t_fzdm  " + where + " and jgmc = '" + jgdm.getJgmc().trim() + "' and jgdm<>'"+jgdm.getTyshxydm()+"' ";
                 Query querybss1 = CheckEntityManagerHelper.getEntityManager().createNativeQuery(sql);
                
                 returnList = querybss1.getResultList();
                 if (returnList != null && returnList.size() > 0) {
                	 for (Object[] objects : returnList) {
                		 jgdms.add(make(objects));

                	 } 
                 }
              /*  if(type == 5){
                sql = "SELECT jgdm,jgmc,fddbr,jglx,'BS注销库' AS sjly,'t_fzdm_bs' AS tablename,zch,0,fzrq FROM t_fzdm "+where;
            	Query querybs = CheckEntityManagerHelper.getEntityManager().createNativeQuery(sql);
            	returnList = querybs.getResultList();
                 if (returnList != null && returnList.size() > 0) {
                     Object[] objects = returnList.get(0);
                     jgdms.get(0).setSjly(objects[4].toString());
                     jgdms.get(0).setTableName(objects[5].toString());
                 }
                 sql = "SELECT jgdm,jgmc,fddbr,jglx,'BS注销库' AS sjly,'t_fzdm_bs' AS tablename,zch,0,fzrq FROM t_fzdm  " + where + " and jgdm <> '" + jgdm.getTyshxydm() + "' ";
                 Query querybs1 = CheckEntityManagerHelper.getEntityManager().createNativeQuery(sql);
                 returnList = querybs1.getResultList();
            	   if (returnList != null && returnList.size() > 0) {
                       for (Object[] objects : returnList) {
                           jgdms.add(make(objects));

                       }
                   }
                }*/
            }

            @Override
            protected void excute() throws Exception {
                sp = em.find(TSp.class, sp.getLsh());
                jgdm = em.find(TSpdmtemp.class, sp.getGllsh());
                jgdms = new ArrayList<TjgdmCommon>();
                TjgdmCommon vo = new TjgdmCommon();
                vo.setTyshxydm(jgdm.getTyshxydm());
                vo.setJgmc(jgdm.getJgmc());
                vo.setSjly("");
                vo.setBzjgdm(jgdm.getJglx());
                vo.setTableName("");
                vo.setZjhm(jgdm.getZch());
                vo.setZfrq(jgdm.getZfrq());
                vo.setFddbr(jgdm.getFddbr());
                jgdms.add(vo);
                get(sp.getSubmitType(), jgdm.getJgmc(), jgdm.getZch(),jgdm.getZjhm());
                currentPath = path + "diff_auditing.jsp";
            }
        }.nSyTemplate();
    }

    public String _delete() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                sp = em.find(TSp.class, sp.getLsh());
                em.clear();
                em.createQuery("delete from  TSpdmtemp model where model.lsh=:lsh").setParameter("lsh", sp.getGllsh()).executeUpdate();
                em.createQuery("delete from  TSp model where model.lsh=:lsh").setParameter("lsh", sp.getLsh()).executeUpdate();
                em.flush();
                resultMsg = "机构代码（" + sp.getJgdm() + "）的审核不通过审批数据删除成功！";
                source = "list";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String findOutData() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                jgdm = new TSpdmtemp();

                TJgdmWw jgdmWw = em.find(TJgdmWw.class, Long.valueOf(_jgdm));
                BeanUtilsEx.copyProperties(jgdm, jgdmWw);
                currentPath = path + "outData_auditing.jsp";
            }
        }.nSyTemplate();
    }

    //内网数据审核
    public String auditIndata() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                HttpSession session = ServletActionContext.getRequest().getSession();
                User user = (User) session.getAttribute("sysUser");
                TSp sp1 = em.find(TSp.class, sp.getLsh());
                //TSppz sppz = em.find(TSppz.class, sp1.getYwlx());
                if ("1".equals(sp.getShflag())) {
                    if (cfmc != null && cfmc && (sp1.getSubmitType() == 1 || sp1.getSubmitType() == 3)) {

                        TSpdmtemp spdmtemp = em.find(TSpdmtemp.class, sp1.getGllsh());
                        List<Object[]> objects = em.createNativeQuery("SELECT tyshxydm COLLATE Chinese_PRC_CI_AS AS a,'0','2'  FROM t_jgdm WHERE jgmc ='" + spdmtemp.getJgmc() + "'" +
                                "UNION SELECT tyshxydm COLLATE Chinese_PRC_CI_AS AS a,id,djblx FROM t_jgdm_save WHERE  jgmc ='" + spdmtemp.getJgmc() + "'" +
                                "UNION SELECT tyshxydm COLLATE Chinese_PRC_CI_AS AS a,'0','2' FROM t_fzdm WHERE jgmc ='" + spdmtemp.getJgmc() + "'" ).getResultList();
                   /*     for (Object[] objs : objects) {
                            Object jgdm = "0".equals(objs[2]) ? objs[1] : objs[0];
                            TSpcf spcf = new TSpcf();
                            List<TSpcf> spcfs = em.createQuery("SELECT model FROM TSpcf model WHERE model.jgdm='" + jgdm + "' AND model.jgmc='" + spdmtemp.getJgmc() + "'").getResultList();
                            if (spcfs != null && !spcfs.isEmpty()) {
                                spcf = spcfs.get(0);
                                spcf.setCanUse(sp.getShflag().equals("1"));
                                em.merge(spcf);
                            } else {
                                spcf.setCanUse(sp.getShflag().equals("1"));
                                spcf.setJgmc(spdmtemp.getJgmc());
                                spcf.setJgdm(spdmtemp.getJgdm());
                                spcf.setLsh(null);
                                em.persist(spcf);
                            }
                        }*/

                    }
                  /*  if (cfzch != null && cfzch && (sp1.getSubmitType() == 2 || sp1.getSubmitType() == 3)) {
                        TSpdmtemp spdmtemp = em.find(TSpdmtemp.class, sp1.getGllsh());
                        List<Object[]> objects = em.createNativeQuery("SELECT tyshxydm COLLATE Chinese_PRC_CI_AS AS a,'0','2'  FROM t_jgdm WHERE zch ='" + spdmtemp.getZch() + "'" +
                                "UNION SELECT tyshxydm COLLATE Chinese_PRC_CI_AS AS a,id,djblx FROM t_jgdm_save WHERE  zch ='" + spdmtemp.getZch() + "'" +
                                "UNION SELECT tyshxydm COLLATE Chinese_PRC_CI_AS AS a,'0','2' FROM t_fzdm WHERE zch ='" + spdmtemp.getZch() + "'").getResultList();
                        for (Object[] objs : objects) {
                            Object jgdm = "0".equals(objs[2]) ? objs[1] : objs[0];
                            TSpcf spcf = new TSpcf();
                            List<TSpcf> spcfs = em.createQuery("SELECT model FROM TSpcf model WHERE model.jgdm='" + jgdm + "' AND model.zch='" + spdmtemp.getZch() + "'").getResultList();
                            if (spcfs != null && !spcfs.isEmpty()) {
                                spcf = spcfs.get(0);
                                spcf.setCanUse(sp.getShflag().equals("1"));
                                em.merge(spcf);
                            } else {
                                spcf.setCanUse(sp.getShflag().equals("1"));
                                spcf.setZch(spdmtemp.getZch());
                                spcf.setJgdm(spdmtemp.getJgdm());
                                spcf.setLsh(null);
                                em.persist(spcf);
                            }

                        }
                    }*/

                }

                sp1.setShman(user.getUserName());
                sp1.setShflag(sp.getShflag());
                sp1.setShtime(new Date());
                sp1.setShreason(sp.getShreason());
                sp1.setFlag("1");
                em.merge(sp1);
                resultMsg =  "重名:"+"(流水号：'" + sp1.getLsh() + "')，审核完毕";
                currentPath = path + "success.jsp";
                source = "inDataList";
                setTitle("内网数据审核");
            }
        }.template();
    }

    //外网数据审核
    public String outDataAudit() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                TJgdmWw jgdmWw = em.find(TJgdmWw.class, Long.valueOf(_jgdm));
                if (jgdmWw != null) {
                    em.createQuery("update TJgdmWw  model set model.status=:status ,model.shSuggest=:shSuggest where model.id=:id")
                            .setParameter("id", Long.valueOf(_jgdm))
                            .setParameter("status", sp.getShflag())
                            .setParameter("shSuggest", sp.getShreason()).executeUpdate();
                    if ("1".equals(sp.getShflag())) {
                        if ("1".equals(jgdmWw.getType().trim())) {
                            TJgdmSave save = new TJgdmSave();
                            BeanUtilsEx.copyProperties(save, jgdmWw);
                            save.setId(null);
                            save.setDjblx("0");
                            em.persist(save);
                        } else {
                            TJgdm save = em.find(TJgdm.class, jgdmWw.getJgdm());
                            if (save == null) {
                                save = new TJgdm();
                                BeanUtilsEx.copyProperties(save, jgdmWw);
                                em.persist(save);
                            } else {
                                BeanUtilsEx.copyProperties(save, jgdmWw);
                            }
                        }
                        em.remove(jgdmWw);
                        em.flush();
                    }
                    resultMsg = "外网机构代码（" + jgdmWw.getJgmc() + "）审核完成!";
                } else {
                    throw new Exception("流水号为" + _jgdm + "的外网审核数据有问题！");
                }
                currentPath = path + "success.jsp";
                source = "outDataList";
                setTitle("外网数据审核");
            }
        }.template();
    }

    public String _show() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                TJgdm dm = em.find(TJgdm.class, jgdm.getTyshxydm());
                //机构代码表
                if (dm == null) {
                    TJgdmSave jgdmSave = null;
                    if (jgdm.getTyshxydm() != null && jgdm.getTyshxydm().trim().length() == 18) {
                        List<TJgdmSave> saves = em.createQuery("select model from TJgdmSave  model where model.jgdm='" + jgdm.getTyshxydm().trim() + "'").getResultList();
                        if (!saves.isEmpty() && saves.size() > 0) {
                            jgdmSave = saves.get(0);
                        }
                    } else if (!"".equals(jgdm.getTyshxydm())) {
                        int id = Integer.valueOf(jgdm.getTyshxydm());
                        jgdmSave = em.find(TJgdmSave.class, id);

                    }

                    //机构代码注销表
                    if (jgdmSave == null) {
                        TFzdm fzdm;
                        fzdm = em.find(TFzdm.class, jgdm.getTyshxydm());
                        //机构代码注销表
                        if (fzdm == null) {
                        	EntityManager em1 = CheckEntityManagerHelper.getEntityManager();
                            List<TJgdmBs> qzdms;
                            List<TFzdmBs> fzdms;
                            qzdms = em1.createQuery("select model from TJgdmBs model where model.jgdm=:jgdm order by model.lastdate desc")
                                    .setParameter("jgdm", jgdm.getTyshxydm()).getResultList();
                            //机构代码迁址表
                            if (qzdms == null || qzdms.isEmpty()) {
                            	 fzdms = em1.createQuery("select model from TFzdmBs model where model.jgdm=:jgdm order by model.lastdate desc")
                                 .setParameter("jgdm", jgdm.getTyshxydm()).getResultList();
                            	 if(fzdms == null || fzdms.isEmpty()){
                            		 List<TSpdmtemp> spdmtemps = em.createQuery("select model from TSpdmtemp model where model.jgdm=:jgdm order by model.lastdate desc")
                                     .setParameter("jgdm", jgdm.getTyshxydm()).getResultList();
                             if (spdmtemps == null || spdmtemps.isEmpty())
                                 return;
                             BeanUtilsEx.copyProperties(jgdm, spdmtemps.get(0)); 
                            	 }else{
                            		 BeanUtilsEx.copyProperties(jgdm, fzdms.get(0));
                            	 }
                               
                            } else {
                                BeanUtilsEx.copyProperties(jgdm, qzdms.get(0));
                                jgdm.setLry(qzdms.get(0).getLry());
                            }
                        } else {
                            BeanUtilsEx.copyProperties(jgdm, fzdm);
                            //jgdm.setLry(fzdm.getFzr());
                        }
                    } else {
                        BeanUtilsEx.copyProperties(jgdm, jgdmSave);
                    }
                } else {
                    BeanUtilsEx.copyProperties(jgdm, dm);
                }
                currentPath = path + "show.jsp";
            }
        }.nSyTemplate();
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

    public clsPageComponent getPages() {
        return pages;
    }

    public void setPages(clsPageComponent pages) {
        this.pages = pages;
    }

    public Integer getRowNumsView() {
        return rowNumsView;
    }

    public void setRowNumsView(Integer rowNumsView) {
        this.rowNumsView = rowNumsView;
    }

    public Integer getPageno() {
        return pageno;
    }

    public void setPageno(Integer pageno) {
        this.pageno = pageno;
    }

    public List<SmUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SmUser> userList) {
        this.userList = userList;
    }

    public SmUser getUser() {
        return user;
    }

    public void setUser(SmUser user) {
        this.user = user;
    }

    public String getIspass() {
        return ispass;
    }

    public void setIspass(String ispass) {
        this.ispass = ispass;
    }

    public List<TSp> getSpList() {
        return spList;
    }

    public void setSpList(List<TSp> spList) {
        this.spList = spList;
    }

    public Map<String, String> getYwlxs() {
        return ywlxs;
    }

    public void setYwlxs(Map<String, String> ywlxs) {
        this.ywlxs = ywlxs;
    }

    public TSp getSp() {
        return sp;
    }

    public void setSp(TSp sp) {
        this.sp = sp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TSpdmtemp getJgdm() {
        return jgdm;
    }

    public void setJgdm(TSpdmtemp jgdm) {
        this.jgdm = jgdm;
    }

    public TSppz getSppz() {
        return sppz;
    }

    public void setSppz(TSppz sppz) {
        this.sppz = sppz;
    }

    public List<TJgdmWw> getJgdmwws() {
        return jgdmwws;
    }

    public void setJgdmwws(List<TJgdmWw> jgdmwws) {
        this.jgdmwws = jgdmwws;
    }

    public String get_jgdm() {
        return _jgdm;
    }

    public void set_jgdm(String _jgdm) {
        this._jgdm = _jgdm;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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

    public List<TjgdmCommon> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TjgdmCommon> jgdms) {
        this.jgdms = jgdms;
    }

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public Boolean getCfmc() {
        return cfmc;
    }

    public void setCfmc(Boolean cfmc) {
        this.cfmc = cfmc;
    }

    public Boolean getCfzch() {
        return cfzch;
    }

    public void setCfzch(Boolean cfzch) {
        this.cfzch = cfzch;
    }

	public String getJglx() {
		return jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}
    
}
