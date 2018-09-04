/**
 *
 */
package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.bus.TZrxzqhBus;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class PreScanSettiongsAction extends ActionSupport {
    private static final String path = "/product/jsp/preScanSettings/";

    private String currentPath = path + "";
    private PreScan scan;
    private List<TZrxzqh> xzqhs;
    private String message;
    private Page page;
    private ScanManage scanManage;

    public String show() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                PreScanPK pk = new PreScanPK();
                pk.setXzqh(scan.getXzqh());
                pk.setType(scan.getType());
                scan = em.find(PreScan.class, pk);
                if (scan == null) {
                    scan = new PreScan();
                    scan.setType(pk.getType());
                    scan.setXzqh(pk.getXzqh());
                    scan.setJglxs("");
                    em.persist(scan);
                }
                em.clear();
                currentPath = path + "/preScanSettings.jsp";
            }
        }.nSyTemplate();
    }

    public String list() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByType("asc");
                    page.setOrderByField("xzqh");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TZrxzqh model  ";

                if (scan != null && scan.getXzqh() != null && !"".equals(scan.getXzqh().trim())) {
                    sql += "  where xzqh like '%" + scan.getXzqh() + "'";

                }
                xzqhs = em.createQuery("select model " + sql + orderBy).
                        setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());

                currentPath = path + "/list.jsp";
            }
        }.nSyTemplate();
    }

    public String save() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                em.merge(scan);
                message = InitSysParams.zrxzqhMap.get(scan.getXzqh()) + ":" + SmTaskType.get(scan.getType()) + "前置扫描设置成功!";
                InitSysParams.scans = em.createQuery("select model from PreScan model ").getResultList();
                currentPath = path + "/preScanSettings.jsp";
            }
        }.template();
    }


    public String frontScanList() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                if (page == null) {
                    page = new Page();
                    page.setOrderByType("asc");
                    page.setOrderByField("xzqh");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                String sql = " from TZrxzqh model  ";

                if (scan != null && scan.getXzqh() != null && !"".equals(scan.getXzqh().trim())) {
                    sql += "  where xzqh like '%" + scan.getXzqh() + "'";

                }
                xzqhs = em.createQuery("select model " + sql + orderBy).
                        setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());

                currentPath = path + "/frontScanList.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 查看机构扫描设置
     *
     * @return
     */
    public String frontScanShow() {

        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                int xzqh = scanManage.getXzqh();
                String mc = scanManage.getMemo1();
                scanManage = em.find(ScanManage.class, xzqh);


                if (scanManage == null) {
                    scanManage = new ScanManage();
                    scanManage.setXzqh(xzqh);
                    scanManage.setStatus("1");
                }
                scanManage.setMemo1(mc);
                em.clear();
                currentPath = path + "/frontScanUp.jsp";
            }
        }.nSyTemplate();
    }

    /**
     * 保存机构前置扫描管理
     *
     * @return
     */
    public String frontScanSave() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                em.merge(scanManage);
                em.flush();
                em.clear();
                em.close();
                InitSysParams.frontZrxzqh.put(scanManage.getXzqh() + "", scanManage.getStatus());
                currentPath = "/bsweb/preScan_list";
            }
        }.template();
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public PreScan getScan() {
        return scan;
    }

    public void setScan(PreScan scan) {
        this.scan = scan;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TZrxzqh> getXzqhs() {
        return xzqhs;
    }

    public void setXzqhs(List<TZrxzqh> xzqhs) {
        this.xzqhs = xzqhs;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public ScanManage getScanManage() {
        return scanManage;
    }

    public void setScanManage(ScanManage scanManage) {
        this.scanManage = scanManage;
    }

}
