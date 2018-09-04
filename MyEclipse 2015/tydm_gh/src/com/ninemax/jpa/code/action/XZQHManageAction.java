package com.ninemax.jpa.code.action;

import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.ActionUtils;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import javax.persistence.EntityManager;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class XZQHManageAction extends ActionSupport implements SessionAware {
    private static final String path = "/product/jsp/XZQHManage/";
    private Map<String, Object> session;
    private String currentPath;
    private String message;
    private String title;
    private String source;
    private List<TZrxzqh> zrxzqhs;
    private List<TXzqh> xzqhs;
    private TZrxzqh zrxzqh;
    private Boolean cjjggly;
    private Page page;

    public XZQHManageAction() {
    }


    public String lissc_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                String from = "";
                if (zrxzqh != null) {
                    if (zrxzqh.getXzqh() != null)
                        from += " and  xzqh like '%" + zrxzqh.getXzqh() + "%'";
                    if (zrxzqh.getFlag() != null && !"".equals(zrxzqh.getFlag())) {
                        from += " and flag=" + zrxzqh.getFlag();
                    }
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByType("asc");
                    page.setOrderByField("xzqh");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                zrxzqhs = em.createQuery("select model from TZrxzqh model where 1=1 " + from + orderBy).
                        setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) from TZrxzqh model where 1=1 " + from)
                        .getResultList().get(0)).intValue());
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 准入机构管理");
                currentPath = path + "lissc_xzqh.jsp";
            }
        }.nSyTemplate();
    }

    public String lissc_xzqh_yq() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                String from = "";
                if (zrxzqh != null) {
                    if (zrxzqh.getXzqh() != null)
                        from += " and  xzqh like '%" + zrxzqh.getXzqh() + "%'";
                    if (zrxzqh.getFlag() != null && !"".equals(zrxzqh.getFlag())) {
                        from += " and flag=" + zrxzqh.getFlag();
                    }
                }
                if (page == null) {
                    page = new Page();
                    page.setOrderByType("asc");
                    page.setOrderByField("xzqh");
                }
                String orderBy = (page.getOrderByField() != null && !"".equals(page.getOrderByField())) ? (" order by model." + page.getOrderByField() + " " + page.getOrderByType()) : "";
                zrxzqhs = em.createQuery("select model from TZrxzqh model where 1=1 " + from + orderBy).
                        setFirstResult(page.getStartRecord()).setMaxResults(page.getPageSize())
                        .getResultList();
                page.setTotalRecord(((Long) em.createQuery("select count(model) from TZrxzqh model where 1=1 " + from)
                        .getResultList().get(0)).intValue());
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 延期设置");
                currentPath = path + "lissc_xzqh_yq.jsp";
            }
        }.nSyTemplate();
    }

    public String yq() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                em.clear();
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 延期设置");
                currentPath = path + "yq_xzqh.jsp";
                source = "yq_xzqh";
            }
        }.nSyTemplate();
    }

    public String yq_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TZrxzqh zrxzqh1 = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                zrxzqh1.setSmyq(zrxzqh.getSmyq());
                zrxzqh1.setDayq(zrxzqh.getDayq());
                zrxzqh1.setSjyq(zrxzqh.getSjyq());

                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 延期设置");
                message = "行政区划（" + zrxzqh.getXzqh() + "）延期设置成功！";
                em.merge(zrxzqh1);
                em.flush();
                InitSysParams.zrxzqhMap2.put(zrxzqh1.getXzqh(), zrxzqh1);
                zrxzqh = zrxzqh1;
                currentPath = path + "success.jsp";
                source = "lissc_xzqh_yq";
            }
        }.template();
    }

    public String show_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                em.clear();
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 查看准入办证机构");
                currentPath = path + "show_xzqh.jsp";
                source = "show_xzqh";
            }
        }.nSyTemplate();
    }

    /**
     * 编辑一条处罚记录
     *
     * @return
     */

    public String edisc_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                em.clear();
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 准入办证机构编辑");
                currentPath = path + "edisc_xzqh.jsp";
                source = "update_xzqh";
            }
        }.template();
    }

    /**
     * 所有可添加行政区划，到添加检索页面
     *
     * @return String
     */
    public String search_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                exec(em);
            }
        }.nSyTemplate();
    }

    private void exec(EntityManager em) throws Exception {
        User user = (User) session.get("sysUser");
        /*if (!(user.getUserName()!=null && user.getUserName().contains("admin"))) {
            setMessage("您无权进行该操作");
        } else {*/
        xzqhs = em.createQuery("select model from TXzqh model order by model.dm").getResultList();
        /*}*/
        setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 添加准入机构");
        currentPath = path + "search_xzqh.jsp";
    }

    /**
     * 检索可添加的行政区划
     *
     * @return String
     */
    public String search() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                exeForAdd(em);
            }
        }.nSyTemplate();
    }

    private void exeForAdd(EntityManager em) throws Exception {
        User user = (User) session.get("sysUser");
        TXzqh xzqh = em.find(TXzqh.class, zrxzqh.getXzqh());
        if (xzqh == null) {
            xzqh = em.find(TXzqh.class, zrxzqh.getCsxzqh());
        }
        zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
        em.clear();
        if (zrxzqh == null) {
            zrxzqh = new TZrxzqh();
            zrxzqh.setBzjgflag(true);
            zrxzqh.setFmflag(true);
            zrxzqh.setFzflag("1");
            zrxzqh.setFlag("1");
        } else {
            zrxzqh.setFmflag(true);
            zrxzqh.setBzjgflag(false);
            zrxzqh.setFzflag("1");
            zrxzqh.setFlag("1");
        }

        zrxzqh.setCsxzqh(zrxzqh.getXzqh());
        zrxzqh.setMc(xzqh.getMc());
        zrxzqh.setXzqh(xzqh.getDm());
        setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 添加准入办证机构");
        currentPath = path + "add_xzqh.jsp";
        source = "add_xzqh";
    }

    /**
     * 添加准入行政区划
     *
     * @return String
     */
    public String add_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                User user = (User) session.get("sysUser");
                TZrxzqh zrxzqh1 = null;
                if ("1".equals(zrxzqh.getFzflag())) {
                    zrxzqh.setFzxzqh(zrxzqh.getXzqh());
                } else {
                    zrxzqh1 = em.find(TZrxzqh.class, zrxzqh.getSjxzqh());
                    if (zrxzqh1 == null || !"1".equals(zrxzqh1.getFzflag())) {
                        zrxzqh1 = em.find(TZrxzqh.class, user.getBzjgdm());
                        if (zrxzqh1 == null || !"1".equals(zrxzqh1.getFzflag())) {
                            message = "请设置有效的可打证行政区划(上级行政区划)！";
                            exeForAdd(em);
                            return;
                        } else {
                            zrxzqh.setFzxzqh(user.getBzjgdm());
                        }
                    } else {
                        zrxzqh.setFzxzqh(zrxzqh.getSjxzqh());
                    }
                }

                if ("1".equals(zrxzqh.getDkflag())) {
                    zrxzqh.setDkxzqh(zrxzqh.getXzqh());
                } else {
                    zrxzqh1 = em.find(TZrxzqh.class, zrxzqh.getSjxzqh());
                    if (zrxzqh1 == null || !"1".equals(zrxzqh1.getDkflag())) {
                        zrxzqh1 = em.find(TZrxzqh.class, user.getBzjgdm());
                        if (zrxzqh1 == null || !"1".equals(zrxzqh1.getDkflag())) {
                            message = "请设置有效的可制卡行政区划(上级行政区划)！";
                            exeForAdd(em);
                            return;
                        } else {
                            zrxzqh.setDkxzqh(user.getBzjgdm());
                        }
                    } else {
                        zrxzqh.setDkxzqh(zrxzqh.getSjxzqh());
                    }

                }
                SerialPK pk = new SerialPK();
                pk.setTableType("5");
                pk.setXzqhCode(zrxzqh.getXzqh());
                Serial serial = em.find(Serial.class, pk);
                em.clear();
                if (serial != null) {
                    serial.setFlowId(Integer.valueOf(zrxzqh.getZsbh()));
                    serial.setFlowIdLen("6");
                    serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                    serial.setTableName("证书打印流水号");
                    em.merge(serial);
                } else {
                    serial = new Serial();
                    serial.setXzqhCode(zrxzqh.getXzqh());
                    serial.setTableType("5");
                    serial.setFlowId(Integer.valueOf(zrxzqh.getZsbh()));
                    serial.setFlowIdLen("6");
                    serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                    serial.setTableName("证书打印流水号");
                    em.persist(serial);
                }
                em.persist(zrxzqh);
                em.flush();
                //添加管理员
                em.flush();
                InitSysParams.zrxzqhMap.put(zrxzqh.getXzqh(), zrxzqh.getMc());
                InitSysParams.zrxzqhMap2.put(zrxzqh.getXzqh(), zrxzqh);
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 准入办证机构添加成功");
                message = "办证机构（" + zrxzqh.getXzqh() + "）准入成功";
                source = "search_xzqh";
                currentPath = path + "success.jsp";
            }
        }.template();
    }

    public String update_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                SerialPK pk = new SerialPK();
                pk.setTableType("5");
                pk.setXzqhCode(zrxzqh.getXzqh());
                Serial serial = em.find(Serial.class, pk);
                em.clear();
                
                //TZrxzqh zrxzqh=em.find(TZrxzqh.class, zrxzqh.getXzqh());
                TZrxzqh qh=(TZrxzqh)em.createQuery("select model from TZrxzqh model  where model.xzqh=:xzqh").setParameter("xzqh", zrxzqh.getXzqh()).getSingleResult();
                if (serial != null) {
                  /*  serial.setFlowId(Integer.valueOf(zrxzqh.getZsbh()));
                    serial.setFlowIdLen("6");
                    serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                    serial.setTableName("证书打印流水号");
                    em.merge(serial);*/
                } else {
                    serial = new Serial();
                    serial.setXzqhCode(zrxzqh.getXzqh());
                    serial.setTableType("5");
                    serial.setFlowId(Integer.valueOf(zrxzqh.getZsbh()));
                    serial.setFlowIdLen("6");
                    serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                    serial.setTableName("证书打印流水号");
                    em.persist(serial);
                }
                
                zrxzqh.setDh(qh.getDh());
                zrxzqh.setDkflag(qh.getDkflag());
                zrxzqh.setDkxzqh(qh.getDkxzqh());
                zrxzqh.setSmdr(qh.getSmdr());
                
                
                em.merge(zrxzqh);
                em.flush();
                InitSysParams.zrxzqhMap.put(zrxzqh.getXzqh(), zrxzqh.getMc());
                InitSysParams.zrxzqhMap2.put(zrxzqh.getXzqh(), zrxzqh);
                setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 准入办证机构修改");
                message = "办证机构（" + zrxzqh.getXzqh() + "）更新成功!";
                currentPath = path + "success.jsp";
                source = "lissc_xzqh";
            }
        }.template();
    }


    public String update_zr() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TZrxzqh zrxzqh1 = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                if ("1".equals(zrxzqh1.getFlag())) {
                    zrxzqh1.setFlag("0");
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 取消办证机构准入成功");
                    message = "行政区划（" + zrxzqh.getXzqh() + "）取消准入完毕。您可通过恢复准入操作来允许此机构代码访问系统！";
                } else {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 办证机构准入成功");
                    message = "行政区划（" + zrxzqh.getXzqh() + "）恢复准入完毕！";
                    zrxzqh1.setFlag("1");
                }

                em.merge(zrxzqh1);
                em.flush();
                zrxzqh = zrxzqh1;
                InitSysParams.zrxzqhMap2.put(zrxzqh.getXzqh(), zrxzqh);
                currentPath = path + "success.jsp";
                source = "lissc_xzqh";
            }
        }.template();
    }


    public String update_nqtsbz() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {

                TZrxzqh zrxzqh1 = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                if (zrxzqh.getNjtsbz() == null || zrxzqh.getNjtsbz()) {
                    zrxzqh1.setNjtsbz(false);
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 隐藏年检提示成功");
                    message = "行政区划（" + zrxzqh.getXzqh() + "）打证隐藏年检提示设置完成！";
                } else {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 显示年检提示成功");
                    message = "行政区划（" + zrxzqh.getXzqh() + "）打证显示年检提示设置完成！";
                    zrxzqh1.setNjtsbz(true);
                }

                em.merge(zrxzqh1);
                em.flush();
                zrxzqh = zrxzqh1;
                InitSysParams.zrxzqhMap2.put(zrxzqh.getXzqh(), zrxzqh);
                currentPath = path + "success.jsp";
                source = "lissc_xzqh";
            }
        }.template();
    }

    public String zr_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                em.clear();
                if ("1".equals(zrxzqh.getFlag())) {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 取消办证机构准入");
                } else {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 恢复办证机构准入");
                }
                currentPath = path + "show_xzqh.jsp";
                source = "update_zr";
            }
        }.nSyTemplate();
    }
    public String smdr() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                em.clear();
                if (zrxzqh.getSmdr() != null && zrxzqh.getSmdr()) {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 关闭扫描导入");
                } else {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 开启扫描导入");
                }
                currentPath = path + "show_xzqh.jsp";
                source = "update_smdr";
            }
        }.nSyTemplate();
    }

    public String update_smdr() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                TZrxzqh zrxzqh1 = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                if (zrxzqh1.getSmdr() != null && zrxzqh1.getSmdr()) {
                    zrxzqh1.setSmdr(false);
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 关闭扫描成功");
                    message = "行政区划（" + zrxzqh.getXzqh() + "）关闭扫描完毕！";
                } else {
                    setTitle("系统 &gt;&gt; 办证机构准入 &gt;&gt; 开启扫描导入成功");
                    message = "行政区划（" + zrxzqh.getXzqh() + "）开启扫描导入完毕！";
                    zrxzqh1.setSmdr(true);
                }

                em.merge(zrxzqh1);
                em.flush();
                zrxzqh = zrxzqh1;
                InitSysParams.zrxzqhMap2.put(zrxzqh.getXzqh(), zrxzqh);
                currentPath = path + "success.jsp";
                source = "lissc_xzqh";
            }
        }.template();
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<TZrxzqh> getZrxzqhs() {
        return zrxzqhs;
    }

    public void setZrxzqhs(List<TZrxzqh> zrxzqhs) {
        this.zrxzqhs = zrxzqhs;
    }

    public List<TXzqh> getXzqhs() {
        return xzqhs;
    }

    public void setXzqhs(List<TXzqh> xzqhs) {
        this.xzqhs = xzqhs;
    }

    public TZrxzqh getZrxzqh() {
        return zrxzqh;
    }

    public void setZrxzqh(TZrxzqh zrxzqh) {
        this.zrxzqh = zrxzqh;
    }

    public Boolean getCjjggly() {
        return cjjggly;
    }

    public void setCjjggly(Boolean cjjggly) {
        this.cjjggly = cjjggly;
    }

}
