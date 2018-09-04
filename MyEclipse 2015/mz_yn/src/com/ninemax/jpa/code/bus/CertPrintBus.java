package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TJgdmDAO;
import com.ninemax.jpa.code.dao.TSmTaskDAO;
import com.ninemax.jpa.code.dao.TZsslDao;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.QRCodeUtils;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-17
 * Time: ����6:28
 */
public class CertPrintBus {
    private static Logger log = Logger.getLogger(CertPrintBus.class);

    private TJgdmDAO jgdmDAO = new TJgdmDAO();
    private TSmTaskDAO smTaskDAO = new TSmTaskDAO();
    private TZsslDao zsslDao = new TZsslDao();
    private SerialBus serialBus = new SerialBus();

    /**
     * ���֤���ӡ��ǰ��ɨ��
     * 12b �����ǰ�õ���
     * ֤�� z
     * staFlag  ����ǰ��ɨ���������   1 ����    0 �ر�
     * @param jgdm
     * @param flag ����ӡ��־
     * @return
     */
    public String checkTime(String jgdm, String bzjgdm, boolean flag) {
        TJgdm jgdmObject = jgdmDAO.findById(jgdm);

         String staFlag=InitSysParams.getInstance().frontZrxzqh.get(bzjgdm);
         //1 ����    0 �ر�
        if (flag) {
            if ("1".equals(jgdmObject.getDybz().trim())) {
                return "false:�������루" + jgdm + "��֤���Ѿ���ӡ����Ҫ�ٴδ�ӡ�뵽����֤���ӡ��";
            }

        }
        if (InitSysParams.system.getQzsm() != null && InitSysParams.system.getQzsm()&&!"0".equals(staFlag)) {
            if ("0".equals(jgdmObject.getDybz())) {
                String sql = " from DFile0 model where   model.jgdm=?1  and ( model.arctype=?2 or  model.arctype=?4)  and model.modifydate>=?3 ";
                List<DFile0> dFiles = ThamsEntityManagerHelper.getEntityManager().createQuery("select model " + sql)
                        .setParameter(1, jgdmObject.getJgdm()).setParameter(2, "����").setParameter(4, "Ǩ��").setParameter(3, jgdmObject.getBzrq()).getResultList();
                ThamsEntityManagerHelper.closeEntityManager();
                if (dFiles.isEmpty() || dFiles.size() <= 0) {
                    return "false:��������(" + jgdmObject.getJgdm() + ")��û���ɨ�������������ɨ�������ٴ�֤!";
                } else {
                    DFile0 dFile0 = dFiles.get(0);
                    if (PreScanBus.isQzsm(dFile0.getBzjgdm(), 0, dFile0.getJglx())) {
                        String re = check(dFile0);
                        if (!"true".equals(re))
                            return re;
                    }
                }
            } else {
                String sql = " from DFile0 model where   model.jgdm=?1    and model.modifydate>=?2  and model.arctype in ('" + SmTaskType.getDfileType(3) + "','" + SmTaskType.getDfileType(4) + "','" + SmTaskType.getDfileType(13) + "' ,'Ǩ��','����') ";
                List<DFile0> dFiles = ThamsEntityManagerHelper.getEntityManager().createQuery("select model " + sql)
                        .setParameter(1, jgdmObject.getJgdm()).setParameter(2, jgdmObject.getBzrq()).getResultList();
                ThamsEntityManagerHelper.closeEntityManager();
                if (dFiles.isEmpty() || dFiles.size() <= 0) {
                    return "false:��������(" + jgdmObject.getJgdm() + ")��û���ɨ�������������ɨ�������ٴ�֤!";
                } else {
                    for (DFile0 dFile0 : dFiles) {
                        if (dFile0.getArctype().equals(SmTaskType.getDfileType(3)) && PreScanBus.isQzsm(dFile0.getBzjgdm(), 3, dFile0.getJglx())) {
                            String re = check(dFile0);
                            if (!"true".equals(re))
                                return re;
                        }
                        if (dFile0.getArctype().equals(SmTaskType.getDfileType(4)) && PreScanBus.isQzsm(dFile0.getBzjgdm(), 4, dFile0.getJglx())) {
                            String re = check(dFile0);
                            if (!"true".equals(re))
                                return re;
                        }
                        if (dFile0.getArctype().equals(SmTaskType.getDfileType(13)) && PreScanBus.isQzsm(dFile0.getBzjgdm(), 13, dFile0.getJglx())) {
                            String re = check(dFile0);
                            if (!"true".equals(re))
                                return re;
                        }
                    }
                }
            }
        }

        if("0".equals(staFlag)){
        	return "true";
        }

        int delay = InitSysParams.system.getPrintAfterDay();
        Date lastDate = jgdmObject.getBzrq();
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(lastDate);
        lastDate = DateUtil.dayAfter(DateUtil.strToDate(DateUtil.dateToStr(lastDate)), delay);
        if (lastDate.compareTo(calendar2.getTime()) < 0)
            return "true";
        return "false:�������루" + jgdm + "����֤��Ҫ��" + DateUtil.dateToStr(lastDate) + "�󷽿ɰ���";
    }

    private String check(DFile0 dFile0) {
        if (dFile0.getAttr() != 0) {
            if (dFile0.getAttr() == 2) {
                return "false:��������(" + dFile0.getJgdm() + ")�������������ݣ���ȴ�������˺��ٽ��д�֤!!";
            } else {

                return "false:��������(" + dFile0.getJgdm() + ")������δ��ˣ���ȴ������ɺ��ٽ��д�֤!";
            }
        }
        return "true";
    }

    /**
     * ����ȥ����ĩ
     */

    private int getDays(Date lastDate, int delay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastDate);
        int wday = calendar.get(Calendar.DAY_OF_WEEK);
        int time = wday - 1;
        time = (time > 0 ? time : 7) + delay;
        if (time > 5) {
            delay += (time / 7 + 1) * 2;
        }
        return delay;
    }

    public Boolean hasCert(String xzqh, int zb, int fb) {
        Boolean kcdybz = InitSysParams.system.getKcdybz();
        if (kcdybz) {
            List<TZssl> zssls = zsslDao.findbyhql("select model from TZssl model where model.xzqh='" + xzqh + "' and model.type='0'");
            if (!((zssls == null || zssls.isEmpty()) ? zb <= 0 : zssls.get(0).getKcsl() >= zb)) {
                return false;
            }
            zssls = zsslDao.findbyhql("select model from TZssl model where model.xzqh='" + xzqh + "' and model.type='1'");
            return (zssls == null || zssls.isEmpty()) ? fb <= 0 : zssls.get(0).getKcsl() >= fb;
        }
        return true;
    }

    private Boolean isMain(String bzjgdm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            TZrxzqh zrxzqh = em.find(TZrxzqh.class, bzjgdm);
            return zrxzqh.getBzjgflag() == null ? true : zrxzqh.getBzjgflag();
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;
    }

    public List<String> getXzqhs(String bzjgdm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        List<String> bzjgdms = new ArrayList<String>();
        try {
            List<TZrxzqh> xzqhs = em.createQuery("SELECT model from TZrxzqh model where  model.csxzqh=:bzjgdm").setParameter("bzjgdm", bzjgdm).getResultList();
            for (TZrxzqh zrxzqh : xzqhs) {
                bzjgdms.add(zrxzqh.getXzqh());
            }
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return bzjgdms;
    }

    public String checkBzjgdm(String jgdm, String bzjgdm) {
        TJgdm tJgdm = jgdmDAO.findById(jgdm);
        if (tJgdm == null) {
            return "�������벻����!";
        } else if ((!isMain(bzjgdm) && !bzjgdm.equals(tJgdm.getBzjgdm())) || (isMain(bzjgdm) && !getXzqhs(bzjgdm).contains(tJgdm.getBzjgdm()))) {
            return "��������(" + jgdm + ")�����ڱ���֤�������뵽��" + InitSysParams.zrxzqhMap.get(bzjgdm) + "��������";
        } else if (!"1".equals(tJgdm.getDybz())) {
            return "��������(" + jgdm + ")��δ��ӡ���޷�����ӡ!";
        } else
            return "success";
    }

    public boolean checkFb(String jgdm, String bzjgdm) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            TJgdm tJgdm = em.find(TJgdm.class, jgdm);
            if (tJgdm.getFbsl() == null || tJgdm.getFbsl() == 0) {
                tJgdm.setFbsl(1);
                em.merge(tJgdm);
                em.clear();
            }
            if (tJgdm.getFbsl() > 0) {
                List<TZssl> zssls = em.createQuery("select model from TZssl model where model.xzqh='" + bzjgdm + "' and model.type='0'").getResultList();
                if (zssls == null || zssls.isEmpty() || zssls.get(0).getKcsl() <= 0) {
                    flag = false;
                }
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    public Boolean isALLScanComplete(String jgdm, String bzjgdm) {
        if (!(InitSysParams.system.getIsSmTask() && InitSysParams.system.getQzsm())) {
            return true;
        }

        String staFlag=InitSysParams.getInstance().frontZrxzqh.get(bzjgdm);
        if("0".equals(staFlag)){
        	return true;

        }
        List<TSmrw> tasks = smTaskDAO.findByHql("select model from TSmrw model where model.jgdm='" + jgdm + "' and model.bzjgdm='" + bzjgdm + "' and status='0'");


        return tasks == null || tasks.isEmpty();
    }

    public Certi printCert(String jgdm, String bzjgdm) {
        Certi certi = new Certi();
        String res = checkTime(jgdm, bzjgdm, true);
        if (!"true".equals(res)) {
            certi.setTsxx1(res.split(":")[1]);
            return certi;
        }
        if (!isALLScanComplete(jgdm, bzjgdm)) {
            certi.setTsxx1("�������루" + jgdm + "����Ҫ�����ɨ��������ܴ�ӡ֤��");
            return certi;
        }
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            int zbsl = 0;
            int fbsl = 0;
            tx = em.getTransaction();
            tx.begin();
            TJgdm dm = em.find(TJgdm.class, jgdm);

            if ("4".equals(dm.getDybz().trim()) || "0".equals(dm.getDybz().trim()) || "2".equals(dm.getDybz().trim())) {
                String lsh = serialBus.getLsh(bzjgdm, "5");
                SerialPK pk = new SerialPK();
                pk.setTableType("5");
                pk.setXzqhCode(bzjgdm);
                Serial serial = em.find(Serial.class, pk);
                em.clear();
                serial.setFlowId(serial.getFlowId() + 1);
                em.merge(serial);
                dm.setZslsh(lsh);
                em.merge(dm);
            }
            String yxq = DateUtil.dateToStr(dm.getBzrq(), "��yyyy��MM��dd��") + DateUtil.dateToStr(dm.getZfrq(), "��yyyy��MM��dd��");
            certi.setDjhFbPre(dm.getZslsh() + "-");
            certi.setDjhZb(dm.getZslsh());
            if ("0".equals(dm.getDybz()) || "2".equals(dm.getDybz()) || "4".equals(dm.getDybz())) {
                zbsl = 1;
                dm.setZbsl(1);
                fbsl = dm.getFbsl() == null ? 1 : dm.getFbsl();
                certi.setFbSn("0");
            } else if ("3".equals(dm.getDybz())) {
                //�����������
                List<TZs> zses = em.createQuery("select model from TZs model where model.jgdm='" + dm.getJgdm() + "' and model.zstype='0' and model.flag='5' order by model.lsh desc ").getResultList();
                if (zses == null || zses.isEmpty()) {
                    zbsl = 0;
                } else {
                    zses = em.createQuery("select model from TZs model where model.jgdm='" + dm.getJgdm() + "' and model.zstype='0' order by model.lsh desc ").getResultList();
                    zbsl = 1;
                    TZs zbzs = zses.get(0);
                    if (zbzs.getDjh().trim().length() == 16) {
                        certi.setDjhZb(dm.getZslsh() + "��1");
                    } else {
                        String zbsn = zbzs.getDjh().trim().substring(17);
                        zbsn = Integer.toString(Integer.parseInt(zbsn) + 1);
                        certi.setDjhZb(dm.getZslsh() + "��" + zbsn);
                    }
                }
                //���������
                zses = em.createQuery("select model from TZs model where model.jgdm='" + dm.getJgdm() + "' and model.zstype='1' and model.flag='5' order by model.lsh desc ").getResultList();
                if (zses == null || zses.isEmpty()) {
                    fbsl = 0;
                    certi.setFbSn("0");
                } else {
                    fbsl = zses.size();
                    zses.get(0);
                    zses = em.createQuery("select model from TZs model where model.jgdm='" + dm.getJgdm() + "' and model.zstype='1' order by model.lsh desc ").getResultList();
                    TZs zbzs = zses.get(0);
                    certi.setFbSn(zbzs.getDjh().trim().substring(17));
                    certi.setDjhFbPre(zbzs.getZsbh() + "-");
                }
            } else {
                fbsl = dm.getFbsl() == null ? 1 : dm.getFbsl();
                certi.setFbSn("0");
            }
            dm.setDybz("1");
            dm.setLastdate(new Date());
            em.merge(dm);
            TZssl zssl;
            List<TZssl> zssls;
            if (zbsl > 0) {
                TZysh zysh = new TZysh();
                zysh.setXzqh(bzjgdm);
                zysh.setJgdm(dm.getJgdm());
                zysh.setType("0");
                zysh.setShtype("1");
                zysh.setShreason("��֤");
                zysh.setShsj(new Date());
                zysh.setShsl(zbsl);
                em.persist(zysh);
                zssls = em.createQuery("select model from TZssl model where model.xzqh='" + bzjgdm + "' and model.type='0'").getResultList();
                if (zssls == null || zssls.isEmpty()) {
                    certi.setTsxx1("�Ѿ�û�п���֤��(����)");
                    tx.rollback();
                    return certi;
                }
                zssl = zssls.get(0);
                em.createQuery("update TZssl set kcsl='" + (zssl.getKcsl() - zbsl) + "' where xzqh='" + zssl.getXzqh() + "' and type='0'").executeUpdate();

            }
            if (fbsl > 0) {
                TZysh zysh = new TZysh();
                zysh.setXzqh(bzjgdm);
                zysh.setJgdm(dm.getJgdm());
                zysh.setType("1");
                zysh.setShtype("1");
                zysh.setShreason("��֤");
                zysh.setShsj(new Date());
                zysh.setShsl(fbsl);
                em.persist(zysh);
                zssls = em.createQuery("select model from TZssl model where model.xzqh='" + bzjgdm + "' and model.type='1'").getResultList();
                if (zssls == null || zssls.isEmpty()) {
                    certi.setTsxx1("�Ѿ�û�п���֤�飨������");
                    tx.rollback();
                    return certi;
                }
                zssl = zssls.get(0);
                em.createQuery("update TZssl set kcsl='" + (zssl.getKcsl() - fbsl) + "' where xzqh='" + zssl.getXzqh() + "' and type='1'").executeUpdate();

            }
            int iFpsl = fbsl + zbsl;
            if (iFpsl > 0) {
                TZysh zysh = new TZysh();
                zysh.setXzqh(bzjgdm);
                zysh.setJgdm(dm.getJgdm());
                zysh.setType("2");
                zysh.setShtype("1");
                zysh.setShreason("��֤");
                zysh.setShsj(new Date());
                zysh.setShsl(iFpsl);
                em.persist(zysh);
                zssls = em.createQuery("select model from TZssl model where model.xzqh='" + bzjgdm + "' and model.type='2'").getResultList();
                if (zssls == null || zssls.isEmpty()) {
                    certi.setTsxx1("�Ѿ�û�п���֤�飨������");
                    tx.rollback();
                    return certi;
                }
                zssl = zssls.get(0);
                em.createQuery("update TZssl set kcsl='" + (zssl.getKcsl() - iFpsl) + "' where xzqh='" + zssl.getXzqh() + "' and type='1'").executeUpdate();

            }
            TCzjl czjl = new TCzjl();
            czjl.setJgdm(dm.getJgdm());
            czjl.setMemo("����������" + zbsl + "������������" + fbsl + "'");
            czjl.setName(bzjgdm);
            czjl.setType("M");
            czjl.setDate(new Date());
            czjl.setXzqh(bzjgdm);
            em.persist(czjl);
            em.createQuery("delete from TMdktemp where jgdm='" + dm.getJgdm() + "'").executeUpdate();
            List<TZrxzqh> xzqhs = em.createQuery("select model from TZrxzqh model  where model.xzqh=:xzqh")
                    .setParameter("xzqh", bzjgdm).getResultList();
            if (xzqhs == null || xzqhs.isEmpty()) {
                certi.setTsxx1("����������" + bzjgdm + ")������");
                tx.rollback();
                return certi;
            }
            TZrxzqh zrxzqh = xzqhs.get(0);
            em.createQuery("UPDATE TZs SET flag='0',lastdate=:lastdate WHERE jgdm =:jgdm and flag>='2'")
                    .setParameter("lastdate", new Date()).setParameter("jgdm", dm.getJgdm()).executeUpdate();
            if (zbsl > 0) {
                TZs zs = new TZs();
                BeanUtilsEx.copyProperties(zs, jgdm);
                zs.setFlag("1");
                zs.setFzr(bzjgdm);
                zs.setZstype("0");
                zs.setZslsh(dm.getZslsh());
                zs.setDjh("�����" + bzjgdm + "-" + certi.getDjhZb());
                zs.setFzsj(new Date());
                zs.setYxq(yxq);
                zs.setBzjgdm(bzjgdm);
                zs.setBzjgmc(xzqhs.get(0).getJgmc());
                em.persist(zs);
            }
            if (fbsl > 0) {
                for (int i = Integer.parseInt(certi.getFbSn().trim()); i < Integer.parseInt(certi.getFbSn().trim()) + fbsl; i++) {
                    TZs zs = new TZs();
                    BeanUtilsEx.copyProperties(zs, jgdm);
                    zs.setFlag("1");
                    zs.setFzr(bzjgdm);
                    zs.setZstype("1");
                    zs.setZslsh(dm.getZslsh());
                    zs.setDjh("�����" + bzjgdm + "-" + certi.getDjhFbPre() + (Integer.toString(i + 1)));
                    zs.setFzsj(new Date());
                    zs.setYxq(yxq);
                    zs.setBzjgdm(bzjgdm);
                    zs.setBzjgmc(xzqhs.get(0).getJgmc());
                    em.persist(zs);
                }
            }
            String strZstg0 = "";
            if (xzqhs.get(0).getNjtsbz() != null && xzqhs.get(0).getNjtsbz()) {
                if ("0".equals(zrxzqh.getNjfs())) {
                    strZstg0 = "����ÿ�����֤������,��" + DateUtil.dateToStr(dm.getNjqx()) + "ǰ���ܶ������;";
                }
                if ("1".equals(zrxzqh.getNjfs())) {
                    strZstg0 = "����ÿ��" + zrxzqh.getNjqsrq().substring(0, 2) + "��" + zrxzqh.getNjqsrq().substring(2, 4) + "����" + zrxzqh.getNjjzrq().substring(0, 2) + "��" + zrxzqh.getNjjzrq().substring(2, 4) + "��ǰ���ܶ������;";
                }
            }
            String strZstg2 = zrxzqh.getZstg2();
            if (dm.getNjqx() == null) {
                certi.setTsxx1("�������루" + dm.getJgdm() + ")���ʱ��������������ϵ����Ա");
                certi.setTsxx1("�������루" + jgdm + "����Ҫ�����ɨ��������ܴ�ӡ֤��");
                tx.rollback();

                return certi;
            }

            String njqx = DateUtil.dateToStr(dm.getNjqx());
            strZstg2 = strZstg2.replaceAll("%", String.valueOf(DateUtil.getMonth(njqx)));
            strZstg2 = strZstg2.replaceAll("&", String.valueOf(DateUtil.getDay(njqx)));
            em.createQuery("delete from TSpdmtemp where lsh in (select model.gllsh from TSp model where model.jgdm=:jgdm and model.flag='1' and model.shflag <> '1')")
                    .setParameter("jgdm", jgdm).executeUpdate();
            em.createQuery("update  TSp model set model.flag='2' where model.jgdm=:jgdm and model.flag='1' and model.shflag <> '1'")
                    .setParameter("jgdm", jgdm).executeUpdate();

            dm.setDybz("1");
            em.merge(dm);
            em.flush();
            certi.setJgdm(dm.getJgdm());
            certi.setFrdbMc(frmc(dm.getJglx() == null ? "" : dm.getJglx()));
            certi.setFrdbValue(dm.getFddbr());
            certi.setJgmc(dm.getJgmc());
            certi.setJglx(InitSysParams.jglxMap.get(dm.getJglx()));
            certi.setBzjgdm(InitSysParams.zrxzqhMap2.get(dm.getBzjgdm()).getJgmc());
            certi.setJgdz(dm.getJgdz());
            certi.setQRCode(QRCodeUtils.encoderQRCode(dm.getJgdm()));
            certi.setZbNumber(zbsl);
            certi.setFbNumber(fbsl);
            certi.setYxq(yxq);
            certi.setDjh(certi.getDjhZb());
            certi.setTsxx1(strZstg0);
            certi.setTsxx2(zrxzqh.getZstg1());
            certi.setTsxx3(strZstg2);
            tx.commit();
        } catch (Exception e) {
            log.error(CertPrintBus.class, e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return certi;
    }

    private String frmc(String jglx) {
        if ("1357C".contains(jglx))
            return "����������";
        return "������";
    }
}
