package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class QualityManagerAction extends CommonJgdmAction {
    private static final String path = "/product/jsp/qualityManager/";
    private Map<String, Object> session;
    private String currentPath;
    private String message;
    private String title;
    private String source;
    private List<SmProJgdm> smProJgdms;
    private List<SmRecode> recodes;
    private List<TJgdmCode> jgdmCodes;
    private List<SmSendLog> smSendLogs;
    private List<BzjgLog> bzjgLogs;
    private List<TProjgdmGj> projgdmGjs;
    private List<TJgdmCysh> jgdmCyshs;
    private TJgdmCysh jgdmCysh;
    private TJgdm jgdm;
    private List<TJgdm> jgdms;
    private List<SmStorageJgdm> storageJgdms;
    private String bzjgdm;
    private Page page;
    private Date startDate;
    private Date endDate;

    public QualityManagerAction() {
    }

    /**
     * 上传问题数据
     *
     * @return
     */
    public String uploadProblemData() {
        return new CodeActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("asc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = "";
                if (!user.getUserName().contains("admin")) {
                    sql += "  model.bzjgdm='" + user.getBzjgdm() + "'  ";
                } else {
                    sql += " 1=1  ";
                }
                if (bzjgdm != null && !"".equals(bzjgdm)) {
                    sql = "  and   model.jgdm= '" + bzjgdm + "'";
                }
                if (startDate != null) {
                    sql += " and model.lastdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.lastdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }

                smProJgdms = em.createQuery("select model from SmProJgdm model where " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) from SmProJgdm model where model.bzjgdm='" + user.getBzjgdm() + "'  " + sql)
                        .getResultList().get(0)).intValue());

                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 上传问题数据");
                currentPath = path + "uploadProblemData.jsp";
            }
        }.template();
    }

    /**
     * 上传重码数据
     *
     * @return
     */
    public String uploadRepeatCodeData() {
        return new CodeActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";


                String sql = "";
                if (bzjgdm != null && !"".equals(bzjgdm)) {
                    sql = "  and   model.jgdm = '" + bzjgdm + "'";
                }
                if (startDate != null) {
                    sql += " and model.lastdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.lastdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                recodes = em.createQuery("select model from SmRecode model where model.bzjgdm='" + user.getBzjgdm() + "' " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) from SmRecode model where model.bzjgdm='" + user.getBzjgdm() + "'  " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 上传重码数据");
                currentPath = path + "uploadRepeatCodeData.jsp";
            }
        }.template();
    }

    /**
     * 国家问题数据
     *
     * @return
     */
    public String nationProblemData() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("asc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "";
                if (bzjgdm != null && !"".equals(bzjgdm)) {
                    sql = "  model.jgdm='" + bzjgdm + "'";
                } else {
                    sql = " 1=1 ";
                }
                if (!user.getUserName().contains("admin")) {
                    sql += " and  model.bzjgdm='" + user.getBzjgdm() + "'  ";
                }
                projgdmGjs = em.createQuery("select model from TProjgdmGj model  where  " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) from TProjgdmGj model where  model.bzjgdm=' " + user.getBzjgdm() + "' " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 国家问题数据");
                currentPath = path + "nationProblemData.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 审核问题数据
     *
     * @return
     */
    public String auditProblemData() {
        return new CheckActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("asc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = "";
                if (bzjgdm != null && !bzjgdm.equals("")) {
                    sql = "  and   model.jgdm='" + bzjgdm + "'";
                } else {
                    sql = "";

                }
                if (!user.getUserName().contains("admin")) {
                    sql += " and  model.bzjgdm='" + user.getBzjgdm() + "'  ";
                }
                jgdmCyshs = em.createQuery("select model from TJgdmCysh model where   model.shbz='1' and model.status='2' " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) from TJgdmCysh model where model.bzjgdm='" + user.getBzjgdm() + "'  and  model.shbz='1' and model.status='2' " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 审核问题数据");
                currentPath = path + "auditProblemData.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 审核问题数据
     *
     * @return
     */
    public String problem_datas() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                if (page == null) {
                    page = new Page();
                    page.setOrderByField("jgdm");
                    page.setOrderByType("asc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = " from TJgdm model where model.wtbz=2   and  " + sql();
                if (jgdm != null && !"".equals(jgdm.getJgdm())) {
                    sql += "  and   model.jgdm='" + jgdm.getJgdm() + "'";
                } else {
                    sql += "";

                }
                jgdms = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 问题数据修改");
                currentPath = path + "problem_datas.jsp";
            }
        }.template();
    }

    public String problem_data_edit() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TSpdmtemp spdm;
                spdm = getSpdm(em, mc, "07");
                if (spdm == null) {
                    jgdm = em.find(TJgdm.class, mc);
                } else {
                    jgdm = new TJgdm();
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                }
                if (spdm == null) {
                    jgdm = em.find(TJgdm.class, mc);
                } else {
                    jgdm = new TJgdm();
                    BeanUtilsEx.copyProperties(jgdm, spdm);
                }
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 问题数据修改");
                currentPath = path + "problem_data_edit.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 国家问题数据
     *
     * @return
     */
    public String auditProblemData_save() {
        return new CheckActionUtils() {
            @Override
            protected void excute() throws Exception {
                TJgdmCysh
                        cysh = em.find(TJgdmCysh.class, jgdmCysh.getJgdm());
                cysh.setStatus("1");
                BeanUtilsEx.copyProperties(cysh, jgdmCysh);
                em.merge(cysh);
                setMessage("审核问题数据（" + jgdmCysh.getJgdm() + "）,修改成功！");
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 审核问题数据");
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String auditProblemData_show() {
        return new CheckActionUtils() {
            @Override
            protected void excute() throws Exception {
                jgdmCysh = em.find(TJgdmCysh.class, jgdmCysh.getJgdm());
                setTitle("质量 &gt;&gt; 数据质量管理&gt;&gt; 审核问题数据修改");
                currentPath = path + "auditProblemData_edit.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 传输数据统计
     *
     * @return
     */
    public String updateDataCount() {
        return new CodeActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("clDate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "from SmSendLog model where 1=1 ";
                if (startDate != null) {
                    sql += " and model.clDate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.clDate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }

                smSendLogs = em.createQuery("select model  " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("统计 &gt;&gt; 上传数据统计 &gt;&gt; 传输数据统计");
                currentPath = path + "updateDataCount.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 上传数据查询
     *
     * @return
     */
    public String updateDataSearch() {
        return new CodeActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("importdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "from TJgdmCode model where 1=1 ";
                if (startDate != null) {
                    sql += " and model.importdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.importdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }

                jgdmCodes = em.createQuery("select model  " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("查询 &gt;&gt; 上传数据查询 &gt;&gt; 上传数据查询");
                currentPath = path + "updateDataSearch.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 办证点数据统计
     *
     * @return
     */
    public String bzjgDataCount() {
        return new CodeActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("logDate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = "from BzjgLog model where 1=1 ";
                if (startDate != null) {
                    sql += " and model.logDate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.logDate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                bzjgLogs = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                setTitle("统计 &gt;&gt; 上传数据统计 &gt;&gt; 办证点数据统计");
                currentPath = path + "bzjgDataCount.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 上传失败数据统计
     *
     * @return
     */
    public String updateFailData() {
        return new CodeActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("lastdate");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by  " + page.getOrderByField() + " " + page.getOrderByType()) : "";


                String sql = " FROM " +
                        "sm_storagejgdm a,sm_zkfailreason b where  a.id=b.id ";

                if (startDate != null) {
                    sql += " and importdate >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and importdate < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                storageJgdms = new ArrayList<SmStorageJgdm>();
                List<Object[]> objects = em.createNativeQuery("SELECT jgdm,jgmc,bzrq,bgrq,zfrq,lastdate,importdate,fail_reason " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Integer) em.createNativeQuery("select count(1) " + sql)
                        .getResultList().get(0)));
                for (Object[] objs : objects) {
                    SmStorageJgdm dm = new SmStorageJgdm();
                    dm.setJgdm((String) (objs[0]));
                    dm.setJgmc((String) (objs[1]));
                    dm.setBzrq((Date) (objs[2]));
                    dm.setBgrq((Date) (objs[3]));
                    dm.setZfrq((Date) (objs[4]));
                    dm.setLastdate((Date) (objs[5]));
                    dm.setImportdate((String) (objs[6]));
                    dm.setBzjgdm((String) (objs[7]));
                    storageJgdms.add(dm);
                }
                setTitle("统计 &gt;&gt; 上传数据统计 &gt;&gt; 上传失败数据统计");
                currentPath = path + "updateFailData.jsp";
            }
        }.nSyTemplate();
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


    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getBzjgdm() {
        return bzjgdm;
    }

    public void setBzjgdm(String bzjgdm) {
        this.bzjgdm = bzjgdm;
    }

    public List<SmStorageJgdm> getStorageJgdms() {
        return storageJgdms;
    }

    public void setStorageJgdms(List<SmStorageJgdm> storageJgdms) {
        this.storageJgdms = storageJgdms;
    }

    public List<TProjgdmGj> getProjgdmGjs() {
        return projgdmGjs;
    }

    public void setProjgdmGjs(List<TProjgdmGj> projgdmGjs) {
        this.projgdmGjs = projgdmGjs;
    }

    public List<BzjgLog> getBzjgLogs() {
        return bzjgLogs;
    }

    public void setBzjgLogs(List<BzjgLog> bzjgLogs) {
        this.bzjgLogs = bzjgLogs;
    }

    public List<SmSendLog> getSmSendLogs() {
        return smSendLogs;
    }

    public void setSmSendLogs(List<SmSendLog> smSendLogs) {
        this.smSendLogs = smSendLogs;
    }

    public List<TJgdmCode> getJgdmCodes() {
        return jgdmCodes;
    }

    public void setJgdmCodes(List<TJgdmCode> jgdmCodes) {
        this.jgdmCodes = jgdmCodes;
    }

    public List<SmRecode> getRecodes() {
        return recodes;
    }

    public void setRecodes(List<SmRecode> recodes) {
        this.recodes = recodes;
    }

    public List<SmProJgdm> getSmProJgdms() {
        return smProJgdms;
    }

    public void setSmProJgdms(List<SmProJgdm> smProJgdms) {
        this.smProJgdms = smProJgdms;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<TJgdmCysh> getJgdmCyshs() {
        return jgdmCyshs;
    }

    public void setJgdmCyshs(List<TJgdmCysh> jgdmCyshs) {
        this.jgdmCyshs = jgdmCyshs;
    }

    public TJgdmCysh getJgdmCysh() {
        return jgdmCysh;
    }

    public void setJgdmCysh(TJgdmCysh jgdmCysh) {
        this.jgdmCysh = jgdmCysh;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public List<TJgdm> getJgdms() {
        return jgdms;
    }

    public void setJgdms(List<TJgdm> jgdms) {
        this.jgdms = jgdms;
    }
}
