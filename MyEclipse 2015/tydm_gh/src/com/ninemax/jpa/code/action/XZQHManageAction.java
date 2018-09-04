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
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ׼���������");
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
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ��������");
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
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ��������");
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

                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ��������");
                message = "����������" + zrxzqh.getXzqh() + "���������óɹ���";
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
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; �鿴׼���֤����");
                currentPath = path + "show_xzqh.jsp";
                source = "show_xzqh";
            }
        }.nSyTemplate();
    }

    /**
     * �༭һ��������¼
     *
     * @return
     */

    public String edisc_xzqh() {
        return new ActionUtils(session) {
            @Override
            protected void excute() throws Exception {
                zrxzqh = em.find(TZrxzqh.class, zrxzqh.getXzqh());
                em.clear();
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ׼���֤�����༭");
                currentPath = path + "edisc_xzqh.jsp";
                source = "update_xzqh";
            }
        }.template();
    }

    /**
     * ���п������������������Ӽ���ҳ��
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
            setMessage("����Ȩ���иò���");
        } else {*/
        xzqhs = em.createQuery("select model from TXzqh model order by model.dm").getResultList();
        /*}*/
        setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ���׼�����");
        currentPath = path + "search_xzqh.jsp";
    }

    /**
     * ��������ӵ���������
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
        setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ���׼���֤����");
        currentPath = path + "add_xzqh.jsp";
        source = "add_xzqh";
    }

    /**
     * ���׼����������
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
                            message = "��������Ч�Ŀɴ�֤��������(�ϼ���������)��";
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
                            message = "��������Ч�Ŀ��ƿ���������(�ϼ���������)��";
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
                    serial.setTableName("֤���ӡ��ˮ��");
                    em.merge(serial);
                } else {
                    serial = new Serial();
                    serial.setXzqhCode(zrxzqh.getXzqh());
                    serial.setTableType("5");
                    serial.setFlowId(Integer.valueOf(zrxzqh.getZsbh()));
                    serial.setFlowIdLen("6");
                    serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                    serial.setTableName("֤���ӡ��ˮ��");
                    em.persist(serial);
                }
                em.persist(zrxzqh);
                em.flush();
                //��ӹ���Ա
                em.flush();
                InitSysParams.zrxzqhMap.put(zrxzqh.getXzqh(), zrxzqh.getMc());
                InitSysParams.zrxzqhMap2.put(zrxzqh.getXzqh(), zrxzqh);
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ׼���֤������ӳɹ�");
                message = "��֤������" + zrxzqh.getXzqh() + "��׼��ɹ�";
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
                    serial.setTableName("֤���ӡ��ˮ��");
                    em.merge(serial);*/
                } else {
                    serial = new Serial();
                    serial.setXzqhCode(zrxzqh.getXzqh());
                    serial.setTableType("5");
                    serial.setFlowId(Integer.valueOf(zrxzqh.getZsbh()));
                    serial.setFlowIdLen("6");
                    serial.setYear("" + Calendar.getInstance().get(Calendar.YEAR));
                    serial.setTableName("֤���ӡ��ˮ��");
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
                setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ׼���֤�����޸�");
                message = "��֤������" + zrxzqh.getXzqh() + "�����³ɹ�!";
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
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ȡ����֤����׼��ɹ�");
                    message = "����������" + zrxzqh.getXzqh() + "��ȡ��׼����ϡ�����ͨ���ָ�׼�����������˻����������ϵͳ��";
                } else {
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ��֤����׼��ɹ�");
                    message = "����������" + zrxzqh.getXzqh() + "���ָ�׼����ϣ�";
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
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ���������ʾ�ɹ�");
                    message = "����������" + zrxzqh.getXzqh() + "����֤���������ʾ������ɣ�";
                } else {
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ��ʾ�����ʾ�ɹ�");
                    message = "����������" + zrxzqh.getXzqh() + "����֤��ʾ�����ʾ������ɣ�";
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
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ȡ����֤����׼��");
                } else {
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; �ָ���֤����׼��");
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
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; �ر�ɨ�赼��");
                } else {
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ����ɨ�赼��");
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
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; �ر�ɨ��ɹ�");
                    message = "����������" + zrxzqh.getXzqh() + "���ر�ɨ����ϣ�";
                } else {
                    setTitle("ϵͳ &gt;&gt; ��֤����׼�� &gt;&gt; ����ɨ�赼��ɹ�");
                    message = "����������" + zrxzqh.getXzqh() + "������ɨ�赼����ϣ�";
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
