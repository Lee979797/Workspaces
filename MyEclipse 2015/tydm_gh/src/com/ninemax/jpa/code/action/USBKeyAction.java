package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.ninemax.jpa.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-25
 * Time: 下午2:26
 */
public class USBKeyAction extends ActionSupport implements SessionAware, ServletContextAware {
    private static Logger log = Logger.getLogger(USBKeyAction.class);
    protected static final String path = "/product/jsp/usbkey/";
    private ServletContext context;
    private String message;
    private Map<String, Object> session;
    private TJgdm jgdm;
    private TUsbListF usbListF;
    private TUsbListC usbListC;
    private TUsbList usbList;
    protected String currentPath = path + "";
    private Long ukeyid;
    private List<TUsbListF> fkjls;
    private List<TUsbList> rkjls;
    private Page page;
    private String startDate;
    private String endDate;

    public String add() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath += "add.jsp";
            }
        }.template();
    }

    public String cx() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath += "cx.jsp";
            }
        }.template();
    }

    public String cx_exec() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                List<TUsbListC> usbListFs = em.createQuery("select model from TUsbListC model where model.jgdm=?1").setParameter(1, jgdm.getJgdm().trim()).getResultList();
                if (usbListFs.isEmpty() || usbListFs.size() <= 0) {
                    message = "查询机构没有发UKey记录";
                    currentPath += "cx.jsp";
                    return;
                }
                jgdm = em.find(TJgdm.class, jgdm.getJgdm().trim());
                currentPath += "cx_show.jsp";
            }
        }.template();
    }

    public String addRK() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                currentPath += "addRK.jsp";
            }
        }.template();
    }

    public String search() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                List<TUsbListF> usbListFs = em.createQuery("select model from TUsbListF model where model.jgdm=?1 and model.start <=?2 and model.end>=?3")
                        .setParameter(1, user.getBzjgdm().trim())
                        .setParameter(2, String.valueOf(ukeyid))
                        .setParameter(3, String.valueOf(ukeyid))
                        .getResultList();
                if (usbListFs != null && usbListFs.size() > 0) {
                    jgdm = em.find(TJgdm.class, jgdm.getJgdm());
                    em.clear();
                    List<TZs> zses = em.createQuery("select model from TZs model where model.jgdm=?1 and model.zstype='0'").setParameter(1, jgdm.getJgdm()).getResultList();
                    if (zses != null && zses.size() > 0) {
                        jgdm.setZslsh(zses.get(0).getDjh());
                    }
                    currentPath += "show_write.jsp";
                    return;
                } else {
                    message = "用户没有写该UKey的权限，请联系发放单位核对！";
                    currentPath += "search.jsp";
                }

            }
        }.template();
    }

    public String read() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                List<TUsbListF> usbListFs = em.createQuery("select model from TUsbListF model where model.jgdm=?1").setParameter(1, user.getBzjgdm().trim()).getResultList();
                if (usbListFs != null && usbListFs.size() > 0) {
                    usbListF = usbListFs.get(0);
                } else {
                    usbListF = new TUsbListF();
                }

                currentPath += "readUsbKey.jsp";
            }
        }.template();
    }

    public String fk() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("time");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = " from TUsbListF model ";
                fkjls = em.createQuery(" select model  " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath += "fkjl.jsp";
            }
        }.template();
    }

    public String add_exec() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                List<TUsbListF> usbs = em.createQuery("SELECT model FROM TUsbListF model where (model.start <=?1 and model.end >=?2) or ( model.start <=?3  and model.end >=?4) or(model.start >=?5 and model.end <=?6) ")
                        .setParameter(1, usbListF.getStart()).setParameter(2, usbListF.getStart())
                        .setParameter(3, usbListF.getEnd()).setParameter(4, usbListF.getEnd())
                        .setParameter(5, usbListF.getStart()).setParameter(6, usbListF.getEnd())
                        .getResultList();
                if (usbs == null || usbs.isEmpty() || usbs.size() <= 0) {
                    List<TUsbList> usb2s = em.createQuery("SELECT model FROM TUsbList model where (model.start <=?1 and model.end >=?2) and ( model.start <=?3  and model.end >=?4)")
                            .setParameter(1, usbListF.getStart()).setParameter(2, usbListF.getStart())
                            .setParameter(3, usbListF.getEnd()).setParameter(4, usbListF.getEnd())
                            .getResultList();

                    if (usb2s != null && !usb2s.isEmpty() && usb2s.size() >= 1) {
                        usbListF.setTime(DateUtil.dateToStr(new Date()));
                        em.persist(usbListF);
                        message = "UsbKey发放成功！";
                    } else {
                        message = "UsbKey发放失败,请确认该号段已经入库！";
                    }


                } else {
                    message = "UsbKey发放失败，该号段部分已经发放，请核对后再发放！";
                }
                currentPath += "add.jsp";

            }
        }.template();
    }

    public String rk_edit() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                usbList = em.find(TUsbList.class, usbList.getId());
                currentPath += "rk_edit.jsp";

            }
        }.template();
    }

    public String rk_edit_exec() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                usbList.setTime(DateUtil.dateToStr(new Date()));
                em.merge(usbList);
                message = "保存成功！";
                currentPath += "rk_edit.jsp";

            }
        }.template();
    }

    public String rk_exec() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                List<TUsbList> usbs = em.createQuery("SELECT model FROM TUsbList model where (model.start <=?1 and model.end >=?2) or ( model.start <=?3  and model.end >=?4) or(model.start >=?5 and model.end <=?6) ")
                        .setParameter(1, usbList.getStart()).setParameter(2, usbList.getStart())
                        .setParameter(3, usbList.getEnd()).setParameter(4, usbList.getEnd())
                        .setParameter(5, usbList.getStart()).setParameter(6, usbList.getEnd())
                        .getResultList();
                if (usbs == null || usbs.isEmpty() || usbs.size() <= 0) {
                    usbList.setTime(DateUtil.dateToStr(new Date()));
                    em.persist(usbList);
                    message = "UsbKey入库成功！";

                } else {
                    message = "UsbKey入库失败，请查看该号段是否已入库！";
                }
                currentPath += "addRK.jsp";

            }
        }.template();
    }

    public String cc_exec() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                List<TUsbListC> usbs = em.createQuery("SELECT model FROM TUsbListC model where (model.ukey=?1) ")
                        .setParameter(1, usbListC.getUkey()).getResultList();
                if (usbs == null || usbs.isEmpty() || usbs.size() <= 0) {
                    usbListC.setTime(DateUtil.dateToStr(new Date()));
                    em.persist(usbListC);
                    currentPath += "ok.jsp";
                } else {
                    currentPath += "nok.jsp";
                }
            }
        }.template();
    }


    public String rk() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("time");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = " from TUsbList model ";
                rkjls = em.createQuery(" select model  " + sql + orderBy).setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) " + sql)
                        .getResultList().get(0)).intValue());
                currentPath += "rkjl.jsp";
            }
        }.template();
    }

    public String tj() {
        return new ActionUtils() {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                if (page == null) {
                    page = new Page();
                    page.setOrderByField("cnum");
                    page.setOrderByType("desc");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by " + page.getOrderByField() + " " + page.getOrderByType()) : "";

                String sql = " select f.num as fnum ,c.num as cnum ,f.jgdm as jgdm  from (select sum(cast(num as int))as num,jgdm from t_usb_list_f where 1=1 ";

                if (usbListF != null && usbListF.getJgdm() != null && !"".equals(usbListF.getJgdm())) {
                    sql += " and    jgdm ='" + usbListF.getJgdm().trim() + "' ";
                }
                if (startDate != null && !"".equals(startDate)) {
                    sql += " and    time >='" + startDate + "' ";
                }
                if (endDate != null && !"".equals(endDate)) {
                    sql += " and    time <='" + endDate + "' ";
                }
                sql += "  group by jgdm  ) f left outer join  (select count(distinct id) as num ,bzjg  from t_usb_list_c where 1=1 ";
                if (usbListF != null && usbListF.getJgdm() != null && !"".equals(usbListF.getJgdm())) {
                    sql += " and   bzjg ='" + usbListF.getJgdm().trim() + "' ";
                }
                if (startDate != null && !"".equals(startDate)) {
                    sql += " and    time >='" + startDate + "' ";
                }
                if (endDate != null && !"".equals(endDate)) {
                    sql += " and    time <='" + endDate + "' ";
                }
                sql += " group by bzjg ) c   on f.jgdm=c.bzjg ";
                List<Object[]> objects = em.createNativeQuery(sql + orderBy)
                        .setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                fkjls = new ArrayList<TUsbListF>();
                for (Object[] obj : objects) {
                	TUsbListF usbListF = new TUsbListF();
                    usbListF.setJgdm(obj[2].toString());
                    usbListF.setStart(obj[0] == null ? "0" : obj[0].toString());
                    usbListF.setEnd(obj[1] == null ? "0" : obj[1].toString());
                    usbListF.setNum(String.valueOf(Long.valueOf(usbListF.getStart()) - Long.valueOf(usbListF.getEnd())));
                    fkjls.add(usbListF);
                }

                page.setTotalRecord(((Integer) em.createNativeQuery("select count(*) from (" + sql + " ) as a ")
                        .getResultList().get(0)));
                currentPath = path + "tj.jsp";
            }
        }.template();
    }

    public List<TUsbListF> getFkjls() {
        return fkjls;
    }

    public void setFkjls(List<TUsbListF> fkjls) {
        this.fkjls = fkjls;
    }

    @Override
    public void setServletContext(ServletContext context) {
        this.context = context;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(String currentPath) {
        this.currentPath = currentPath;
    }

    public TJgdm getJgdm() {
        return jgdm;
    }

    public void setJgdm(TJgdm jgdm) {
        this.jgdm = jgdm;
    }

    public TUsbListF getUsbListF() {
        return usbListF;
    }

    public void setUsbListF(TUsbListF usbListF) {
        this.usbListF = usbListF;
    }

    public Long getUkeyid() {
        return ukeyid;
    }

    public void setUkeyid(Long ukeyid) {
        this.ukeyid = ukeyid;
    }

    public List<TUsbList> getRkjls() {
        return rkjls;
    }

    public void setRkjls(List<TUsbList> rkjls) {
        this.rkjls = rkjls;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public TUsbList getUsbList() {
        return usbList;
    }

    public void setUsbList(TUsbList usbList) {
        this.usbList = usbList;
    }

    public TUsbListC getUsbListC() {
        return usbListC;
    }

    public void setUsbListC(TUsbListC usbListC) {
        this.usbListC = usbListC;
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
}
