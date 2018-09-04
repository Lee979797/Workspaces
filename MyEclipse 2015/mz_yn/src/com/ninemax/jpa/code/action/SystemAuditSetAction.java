/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yanzh
 */
public class SystemAuditSetAction extends ActionSupport implements SessionAware {
    private String currentPath;
    private TSystem system;
    private String message;
    private String startDate;
    private String endDate;
    private String type;
    private String jgdm;
    private String center;
    private Map<String, Object> session;
    private List<TOperateType> types;
    /*private List<ScFields> fields;*/

    public SystemAuditSetAction() {
    }

    public String setting() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                system = InitSysParams.system;
                em.clear();
                currentPath = "/product/jsp/frame/auditSetting.jsp";
            }
        }.nSyTemplate();
    }

    public String updata() {
        return new ActionUtils(session) {
            public EntityManager codeEm = CodeEntityManagerHelper.getEntityManager();
            public EntityTransaction codeTx = codeEm.getTransaction();

            @Override
            protected void excute() throws Exception {

                if (!codeTx.isActive()) {
                    codeTx.begin();
                }
                currentPath = "/product/jsp/frame/ok.jsp";
                if (type == null || "".equals(type)) {
                    message = "nok";
                    return;
                }
                try {
                    String sql = "";
                    if (jgdm != null && jgdm.length() == 9) {
                        sql = " and model.jgdm='" + jgdm + "'";
                    } else {
                        if ((startDate != null && !"".equals(startDate)) || (endDate != null && !"".equals(endDate))) {
                            if (startDate != null && !"".equals(startDate)) {
                                sql += " and model.lastdate >='" + startDate + "'";
                            }
                            if (endDate != null && !"".equals(endDate)) {
                                sql += " and  model.lastdate <='" + endDate + "'";
                            }
                        } else {
                            sql = " and model.lastdate >='" + DateUtil.dateToStr(new Date(), "yyyy-MM-dd") + "'";
                        }
                    }
                    if ("dm".equals(type) || "*".equals(type)) {
                        List<TJgdm> jgdms = em.createQuery("select model from TJgdm model where (model.wtbz<>2  or model.wtbz is null ) and model.dybz='1' " + sql).getResultList();
                        for (TJgdm jgdm : jgdms) {
                            TJgdmDb1 db1 = new TJgdmDb1();
                            BeanUtilsEx.copyProperties(db1, jgdm, 1, codeEm, "T_JGDM");
                            db1.setId(null);
                            db1.setImportdate(DateUtil.dateToStr(new Date()));
                            db1.setSsss(getUser().getBzjgdm());
                            codeEm.persist(db1);
                        }
                    }
                    if ("fz".equals(type) || "*".equals(type)) {
                        List<TFzdm> jgdms = em.createQuery("select model from TFzdm model where 1=1 " + sql).getResultList();
                        for (TFzdm jgdm : jgdms) {
                            TFzdmDb1 db1 = new TFzdmDb1();
                            BeanUtilsEx.copyProperties(db1, jgdm, 1, codeEm, "T_FZDM");
                            db1.setId(null);
                            db1.setImportdate(DateUtil.dateToStr(new Date()));
                            db1.setSsss(getUser().getBzjgdm());
                            codeEm.persist(db1);
                        }
                    }
                    if ("qz".equals(type) || "*".equals(type)) {
                        List<TQzjgdm> jgdms = em.createQuery("select model from TQzjgdm model where  model.qzbz='3'  " + sql).getResultList();
                        //    Map<String, Integer> fieldLength = MetaDataUtil.getFieldLength("code_DB1", "T_QZDM");
                        for (TQzjgdm jgdm : jgdms) {
                            TQzdmDb1 db1 = new TQzdmDb1();
                            BeanUtilsEx.copyProperties(db1, jgdm, 1,codeEm, "T_QZDM");
                            db1.setId(null);
                            db1.setImportdate(DateUtil.dateToStr(new Date()));
                            db1.setSsss(getUser().getBzjgdm());
                            codeEm.persist(db1);
                        }
                    }
                    if ("sc".equals(type) || "*".equals(type)) {
                        List<TLjdm> jgdms = em.createQuery("select model from TLjdm model where  1=1 " + sql).getResultList();
                        for (TLjdm jgdm : jgdms) {
                            TDjgdmDb1 db1 = new TDjgdmDb1();
                            BeanUtilsEx.copyProperties(db1, jgdm, 1, codeEm, "T_DJGDM");
                            db1.setImportdate(DateUtil.dateToStr(new Date()));
                            db1.setSsss(getUser().getBzjgdm());
                            codeEm.persist(db1);
                        }
                    }
                    message = "ok";
                    codeEm.flush();
                    codeTx.commit();
                } catch (Exception e) {
                    message = "nok";
                    codeTx.rollback();
                    throw e;
                } finally {
                    CodeEntityManagerHelper.closeEntityManager();
                }
            }
        }.template();
    }

    public String saveSetting() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TSystem system1 = InitSysParams.system;
                BeanUtilsEx.copyProperties(system1, system, 2,null,null);
                em.merge(system1);
                InitSysParams.system = system1;
                setMessage("系统参数设置成功！");
                currentPath = "/product/jsp/frame/auditSetting.jsp";
            }
        }.template();
    }

    public String YYBTX() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                startDate = UserPropertiesData.getValueByPropertyName("startDate");
                endDate = UserPropertiesData.getValueByPropertyName("endDate");
                center = UserPropertiesData.getValueByPropertyName("center");
                List<TSystem> systems = em.createQuery("select model from TSystem model ").getResultList();
                types = em.createQuery("select model from TOperateType model").getResultList();
            /*    fields = em.createQuery("select model from ScFields model").getResultList();*/
                em.clear();
                if (systems == null || systems.isEmpty())
                    throw new Exception("系统参数设置表数据有误！");
                system = systems.get(0);
                em.clear();
                currentPath = "/product/jsp/frame/list2_yingyongbitian.jsp";
            }
        }.nSyTemplate();
    }

    public String SetYYBTX() {InitSysParams.getInstance().InitSysParams();
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                   boolean startDateFlag = UserPropertiesData.changeValueByPropertyName("startDate", startDate);
                boolean endDateFlag = UserPropertiesData.changeValueByPropertyName("endDate", endDate);
                boolean centerFlag = UserPropertiesData.changeValueByPropertyName("center", center);
                if (startDateFlag && endDateFlag && centerFlag) {
                    message = "ok";
                } else {
                    message = "no";
                    return;
                } 
                session.put("center", center);
                TSystem system1=InitSysParams.system;
                if(!system1.getXzqhdm().equals(center)){
                em.createNativeQuery("update t_system set xzqhdm='"+center+"',xzqhmc='"+InitSysParams.scCenterMap.get(center)+"'").executeUpdate();
                }
                system.setXzqhdm(center);
                system.setXzqhmc(InitSysParams.scCenterMap.get(center));
	            BeanUtilsEx.copyProperties(system1, system, 2,null,null);
	            system1.setDm("");
	            system1.setMc("");
	            em.merge(system1);
                //InitSysParams.system = system1;
                for (TOperateType type : types) {
                    if (null == type.getMain()) {
                        type.setMain(false);
                    }
                    em.createQuery("update TOperateType  opt set opt.main=:main where opt.czlxdm=:czlxdm ")
                            .setParameter("main", type.getMain()).setParameter("czlxdm", type.getCzlxdm()).executeUpdate();
                }
            /*    fields = em.createQuery("select model from ScFields model").getResultList();*/
                types = em.createQuery("select model from TOperateType model").getResultList();
                em.flush();
                setMessage("ok");
                ////////////////////////////////////////////////////////////////////////////////////////////////////////
                //解决系统设置卡死情况
                //InitSysParams.getInstance().InitSysParams();
                currentPath = "/product/jsp/frame/list2_yingyongbitian.jsp";
            }
        }.template();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public TSystem getSystem() {
        return system;
    }

    public void setSystem(TSystem system) {
        this.system = system;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TOperateType> getTypes() {
        return types;
    }

    public void setTypes(List<TOperateType> types) {
        this.types = types;
    }


    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJgdm() {
        return jgdm;
    }

    public void setJgdm(String jgdm) {
        this.jgdm = jgdm;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
