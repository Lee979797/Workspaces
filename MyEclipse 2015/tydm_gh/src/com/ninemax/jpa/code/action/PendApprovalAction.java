package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhhuiyan
 * Date: 12-12-20
 * Time: ÏÂÎç2:47
 */
public class PendApprovalAction extends ActionSupport implements SessionAware {
    private static final String path = "/product/jsp/pendApproval/";
    private String currentPath = "";
    private Map<String, Object> session;
    private List<TSp> sps;
    private Page page;
    private Date startDate;
    private Date endDate;
    private TJgdm jgdm;
    private Map<String, String> ywlxs;

    public String list() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("sendtime");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                List<TSppz> sppzs = em.createQuery("select model from TSppz model").getResultList();
                ywlxs = new HashMap<String, String>();
                for (TSppz pz : sppzs) {
                    ywlxs.put(pz.getYwlx().trim(), pz.getYwmc().trim());
                }
                String sql = " from TSp model  where " + sql("model.sendxzqh") + " and (model.flag='0' or model.flag='1') ";
                if (jgdm != null && jgdm.getJgdm() != null && !"".equals(jgdm.getJgdm())) {
                    sql += " and model.jgdm like '%" + jgdm.getJgdm() + "%' ";
                }
                if (startDate != null) {
                    sql += " and model.sendtime >= '" + DateUtil.dateToStr(startDate) + "'  ";
                }
                if (endDate != null) {
                    sql += " and model.sendtime < '" + DateUtil.dateToStr(DateUtil.dayAfter(endDate, 1)) + "'  ";
                }
                sps = em.createQuery("select model " + sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath = path + "list.jsp";
            }
        }.nSyTemplate();
    }

    public String show() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                TSpdmtemp spdmtemp = em.find(TSpdmtemp.class, Long.valueOf(jgdm.getJgdm()));
                BeanUtilsEx.copyProperties(jgdm, spdmtemp);

                currentPath = path + "show.jsp";
            }
        }.nSyTemplate();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public List<TSp> getSps() {
        return sps;
    }

    public void setSps(List<TSp> sps) {
        this.sps = sps;
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

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public Map<String, String> getYwlxs() {
        return ywlxs;
    }

    public void setYwlxs(Map<String, String> ywlxs) {
        this.ywlxs = ywlxs;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
