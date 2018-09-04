package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TJgdmDAO;
import com.ninemax.jpa.code.dao.TJgdmSaveDAO;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.*;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ����1:29
 */
public class TjgdmBus {
    private static Logger log = Logger
            .getLogger(TjgdmBus.class);
    private TJgdmDAO tJgdmDAO = new TJgdmDAO();
    private TZrxzqhBus zrxzqhBus = new TZrxzqhBus();
    private TJgdmSaveDAO jgdmSaveDAO = new TJgdmSaveDAO();
    private HandleBus handleBus = new HandleBus();

    /**
     * ���ǰ��ɨ��
     *
     * @param jgdm
     * @param type
     * @return
     */
    public boolean checkQzsm(final String jgdm, final String type) {
        if (InitSysParams.system.getQzsm() != null && InitSysParams.system.getQzsm()) {
            final Boolean[] flag = new Boolean[1];
            EntityManagerHelper.excute(new Runnable() {
                @Override
                public void run() {
                    flag[0] = EntityManagerHelper.getEntityManager().createQuery("select  model from TQzsm model where jgdm=?1 and model.type=?2 and model.createTime <=?3 ")
                            .setParameter(1, jgdm).setParameter(2, type).setParameter(3, new Date())
                            .getResultList().size() > 0;
                }
            });
            return flag[0];
        } else {
            return true;
        }

    }

    /**
     * �Ƿ���ڻ�������
     *
     * @param codeName ��������
     * @return boolean
     */
    public boolean isExistCodeName(String codeName, String jgdm) {
        List<TJgdm> list = tJgdmDAO.findByProperty("jgmc", codeName);
        return !(list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }
    
    public boolean isExistCodeNameBs(String codeName, String jgdm) {
    	List<TJgdmBs> list = tJgdmDAO.findByPropertyBs("jgmc", codeName);
    	return !(list == null || list.isEmpty() || (list.size() == 1 &&(jgdm).equals(list.get(0).getJgdm())));
    }

    /**
     * �Ƿ���ڷ��˴���
     *
     * @param fddbr
     * @return
     */
    public boolean isExistFrdb(String fddbr, String jgdm) {
        List<TJgdm> list = tJgdmDAO.findByProperty("fddbr", fddbr);
        return !(list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }

    /**
     * �Ƿ����֤������
     *
     * @param zjlx
     * @param zjhm
     * @param jgdm
     * @return
     */
    public boolean isExistZjhm(String zjlx, String zjhm, String jgdm,String jglx) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("zjlx", zjlx);
        map.put("zjhm", zjhm);
        List<TJgdm> list = tJgdmDAO.findByPropertys(map,jglx);
        return !(list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }
    public boolean isExistZjhmBs(String zjlx, String zjhm, String jgdm,String jglx) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("zjlx", zjlx);
        map.put("zjhm", zjhm);
        List<TJgdmBs> list = tJgdmDAO.findByPropertyBs(map,jglx);
        return !(list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }
    public String isZjhmHasCFJL(String zjhm, String jgdm) {
        if (InitSysParams.system.getIsPunish() != null && InitSysParams.system.getIsPunish()) {
            String jgdms = "";
            TCfjlbBus bus = new TCfjlbBus();
            List<TCfjlb> cfjlbs = bus.findCfjlByzjhm(zjhm);
            if (zjhm.length() == 18) {
                zjhm = zjhm.substring(0, 6) + zjhm.substring(8, 17);
                cfjlbs.addAll(bus.findCfjlByzjhm(zjhm));
            }

            if (!cfjlbs.isEmpty()) {
                for (TCfjlb cfjlb : cfjlbs) {
                    if (cfjlb.getJgdm().equals(jgdm))
                        jgdms += cfjlb.getJgmc() + "(" + cfjlb.getJgdm() + ")��";
                }
            }
            if (jgdms.length() >= 1) {
                return "true:����������������µ�λ�Ĵ���ҵ��" + jgdms + "";
            }
        }
        return "false";
    }

    public String isZjhmHasHzcq(String zjhm, String jgdm, int type) {
        if (type == 0 && !InitSysParams.system.getXbfz()) {
            return "false";
        }
        if (type == 1 && !InitSysParams.system.getNjfz()) {
            return "false";
        }
        if (type == 2 && !InitSysParams.system.getHzfz()) {
            return "false";
        }
        EntityManager em = EntityManagerHelper.getEntityManager();
        String jgdms = "";
        List<Hzcq> hzcqs = em.createQuery(" select model from Hzcq model where model.jgdm !=?1 and zjhm=?2")
                .setParameter(1, jgdm).setParameter(2, zjhm).getResultList();
        if (zjhm.length() == 18) {
            zjhm = zjhm.substring(0, 6) + zjhm.substring(8, 17);
            hzcqs.addAll(em.createQuery(" select model from Hzcq model where model.jgdm !=?1 and zjhm=?2")
                    .setParameter(1, jgdm).setParameter(2, zjhm).getResultList());
        }
        if (!hzcqs.isEmpty()) {
            for (Hzcq hzcq : hzcqs) {
                jgdms += ("" + hzcq.getJgmc() + "(" + hzcq.getJgdm() + ")��");
            }
        }
        if (jgdms.length() >= 1) {
            return "true:�����и�������ص�����ע��ҵ��Ҫ����" + jgdms + "�봦������ص�λ���������ҵ��";
        }
        return "false";
    }

    /**
     * ����ע��Ų�ѯ�б�
     *
     * @param zch
     * @return
     */
    public List<TJgdm> isExistZch(String zch, String jglx) {
        Map<String, Object> params = new HashedMap();
        params.put("zch", zch);
        //params.put("jglx", jglx);
        return tJgdmDAO.findByPropertys(params);
    }


    public TJgdm findById(String jgdm) {
        return tJgdmDAO.findById(jgdm);
    }
    
    public TJgdmBs findByIdBs(String jgdm) {
    	TJgdmBs tjgdm = CheckEntityManagerHelper.getEntityManager().find(TJgdmBs.class, jgdm);
    	CheckEntityManagerHelper.closeEntityManager();
    	return tjgdm;
    }

    public String getZssl(String jgdm) {
        TJgdm jgdm1 = tJgdmDAO.findById(jgdm);
        if (jgdm1 == null)
            return "error";
        return jgdm1.getZbsl() + ":" + jgdm1.getFbsl();
    }

    public String check(String jgdm) {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jgdm", jgdm);
        List<TJgdm> jgdms = tJgdmDAO.findByPropertys(props);
        if ((jgdms == null) || (jgdms.isEmpty())) {
            return "false:��������(" + jgdm + ")������������������!";
        } else if (jgdms.size() > 1) {
            return "false:��������(" + jgdm + ")������!����������!";
        }

        return "true";
    }

    public Boolean isExit(String jgdm) {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jgdm", jgdm);
        List<TJgdm> jgdms = tJgdmDAO.findByPropertys(props);
        return !((jgdms == null) || (jgdms.isEmpty()));
    }

    public String check(String jgdm, String bzjgdm, String userName) {
        TJgdm dm = tJgdmDAO.findById(jgdm);
        bzjgdm = bzjgdm.trim();
        User user = new User();

        user.setUserName(userName);
        user.setBzjgdm(bzjgdm);
        List<String> mcs = zrxzqhBus.getXzqhs(user);
        if (dm == null) {
            return "false:��������(" + jgdm + ")������!";
        } else {
            if (!"1".equals(dm.getDybz()))
                return "false:�������루" + jgdm + "����δ��֤�����ܰ����ҵ��";
            if (userName.contains("admin"))
                return "true";
            if (!mcs.contains(dm.getBzjgdm())) {
                return "false:�������루" + jgdm + "�������ڱ���֤��������(ԭ��֤������" + InitSysParams.zrxzqhMap.get(dm.getBzjgdm()) + ")�������ڴ˰���ҵ��";
            }
          /*  if (bzjgdm.subSequence(4, 6).equals("00")) {
                if (!dm.getBzjgdm().startsWith(bzjgdm.substring(0, 4)))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            } else {
            }*/

          /*  if (dm.getZfrq().before(new Date()))
                return "false:�������루" + jgdm + "��֤���Ѿ�����ʧЧ�����ܰ����ҵ�����Ȱ���֤ҵ��";*/
            return "true";
        }
    }

    public String checkNoPrint(String jgdm, String bzjgdm, String userName) {
        TJgdm dm = tJgdmDAO.findById(jgdm);


        User user = new User();
        user.setUserName(userName);
        user.setBzjgdm(bzjgdm);
        List<String> mcs = zrxzqhBus.getXzqhs(user);
        if (dm == null) {
            return "false:��������(" + jgdm + ")������!";
        } else {
            if (userName.contains("admin"))
                return "true";
            if (!mcs.contains(dm.getBzjgdm())) {
                return "false:�������루" + jgdm + "�������ڱ���֤��������(ԭ��֤������" + InitSysParams.zrxzqhMap.get(dm.getBzjgdm()) + ")�������ڴ˰���ҵ��";
            }
           /* if (bzjgdm.subSequence(4, 6).equals("00")) {
                if (!dm.getBzjgdm().startsWith(bzjgdm.substring(0, 4)))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            } else {
                if (!mcs.contains(dm.getBzjgdm()))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            }*/
            return "true";
        }
    }

    public String checkQz(String jgdm, String bzjgdm, String userName) {
        TJgdm dm = tJgdmDAO.findById(jgdm);


        User user = new User();
        user.setUserName(userName);
        user.setBzjgdm(bzjgdm);
        List<String> mcs = zrxzqhBus.getXzqhs(user);
        if (dm == null) {
            return "false:��������(" + jgdm + ")������!";
        } else {
            if (!"1".equals(dm.getDybz()))
                return "false:�������루" + jgdm + "����δ��֤�����ܰ����ҵ��";
            if (userName.contains("admin"))
                return "true";
            if (!mcs.contains(dm.getBzjgdm())) {
                return "false:�������루" + jgdm + "�������ڱ���֤��������(ԭ��֤������" + InitSysParams.zrxzqhMap.get(dm.getBzjgdm()) + ")�������ڴ˰���ҵ��";
            }
          /*  if (bzjgdm.subSequence(4, 6).equals("00")) {
                if (!dm.getBzjgdm().startsWith(bzjgdm.substring(0, 4)))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            } else {
                if (!mcs.contains(dm.getBzjgdm()))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            }*/


            return "true";
        }
    }

    public String checkSave(String jgdm, String bzjgdm, String userName) {
        TJgdmSave dm = jgdmSaveDAO.findByJgdm(jgdm);

        if (userName.contains("admin"))
            return "true";
        User user = new User();
        user.setUserName(userName);
        user.setBzjgdm(bzjgdm);
        List<String> mcs = zrxzqhBus.getXzqhs(user);
        if (dm == null) {
            return "false:��������(" + jgdm + ")������!";
        } else {
            if (!mcs.contains(dm.getBzjgdm())) {
                return "false:�������루" + jgdm + "�������ڱ���֤��������(ԭ��֤������" + InitSysParams.zrxzqhMap.get(dm.getBzjgdm()) + ")�������ڴ˰���ҵ��";
            }
            /*if (bzjgdm.subSequence(4, 6).equals("00")) {
                if (!dm.getBzjgdm().startsWith(bzjgdm.substring(0, 4)))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            } else {
                if (!mcs.contains(dm.getBzjgdm()))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";

            }*/
            return "true";
        }
    }

    /**
     * zx �ж�������޸�,ɾ����������Ϸ���
     *
     * @param jgdm
     * @param bzjgdm
     * @return
     */
    public String checkCert(String jgdm, String bzjgdm, String userName, String source) {
        Map<String, Object> props = new HashMap<String, Object>();
        props.put("jgdm", jgdm);
        //props.put("bzjgdm", bzjgdm);
        TJgdm dm = tJgdmDAO.findById(jgdm);
        if ((dm == null)) {
            return "false:ͳһ����(" + jgdm + ")������,���ܰ����ҵ��!";
        } else {
            if (source.equals("update")) {
                if ("1".equals(dm.getDybz())) {
                    return "false:ͳһ����(" + jgdm + ")֤���Ѿ���ӡ!���ܽ���������޸�!";
                }
            }
            if (source.equals("delete")) {
                if (!"0".equals(dm.getDybz())) {
                    return "false:ͳһ����(" + jgdm + ")֤���Ѿ���ӡ!���ܽ��������ɾ��!";
                }
                /*//�������Ÿ��룬Ԥ���벻��ɾ��
                if ("1".equals(jgdms.get(0).getDjblx()) || "2".equals(jgdms.get(0).getDjblx())) {
                    return "false:��������(" + jgdm + ")��������ͨ��������!";
                }*/
            }
            if (source.equals("certChange")) {
                if (!"1".equals(dm.getDybz())) {
                    return "false:ͳһ����(" + jgdm + ")��δ��ӡ����֤��!���ܽ��л�֤����!";
                }
                if (InitSysParams.system.getHzqx() != null
                        && InitSysParams.system.getHzqx() > 0 &&
                        dm.getZfrq().compareTo(DateUtil.dayAfter(new Date(), InitSysParams.system.getHzqx())) >= 0) {
                    return "false:ͳһ����(" + jgdm + ")���ڻ�֤������!���ܽ��л�֤����!";
                }
            }
            /*if (source.equals("certChange")) {
                if ("0".equals(jgdms.get(0).getDybz())) {
                    return "false:��������(" + jgdm + ")û�д�ӡ֤�飬�޷�����֤��!";
                }
                if (clsStringTool.isEmpty(jgdms.get(0).getZslsh())) {
                    return "false:��������(" + jgdm + ")û�з���֤�飬�޷�����֤��!";
                }
            }*/
            if (source.equals("gsPrint")) {
                if (!"1".equals(dm.getDybz())) {
                    return "false:ͳһ����(" + jgdm + ")��δ��ӡ֤��!";
                }
            }
            User user = new User();
            user.setUserName(userName);
            user.setBzjgdm(bzjgdm);
            if (userName.contains("admin")) {
                return "true";
            }
            String bzjgdms = handleBus.sql(user);
       /*     if (!bzjgdms.contains(dm.getBzjgdm())) {
                return "false:��������(" + jgdm + ")�����ڸð�֤����,���ܰ����ҵ��!";
            }*/
            return "true";
        }
    }

    /**
     * zx ������޸ģ������ɾ�� ����������ѯt_jgdm
     *
     * @param source �޸Ļ�ɾ��
     * @param jgdm   ��������
     * @param bzjgdm ��֤��������
     * @return
     */
    public TJgdm findJgdmByCondition(String source, String jgdm, String bzjgdm) {
        String sql = "";
        TJgdm tJgdm = null;
        if ("update".equals(source)) {
            sql = "from TJgdm model where model.jgdm = '" + jgdm + "' and model.bzjgdm = '" + bzjgdm + "' and model.dybz <> '1' ";
        }
        if ("delete".equals(source)) {
            sql = "from TJgdm model where model.jgdm = '" + jgdm + "' and model.bzjgdm = '" + bzjgdm + "' and model.dybz='0' and model.djblx <> '1'";
        }
        if ("certChange".equals(source)) {
            sql = "from TJgdm model where model.jgdm = '" + jgdm + "' and model.bzjgdm = '" + bzjgdm + "' and model.dybz='1'";
        }
        List<TJgdm> list = tJgdmDAO.findbyhql(sql);
        if (list != null && list.size() > 0) {
            tJgdm = list.get(0);
        }
        return tJgdm;
    }

    /**
     * zx ������޸�
     *
     * @param tJgdm
     * @param user
     * @param flag  �û����ķ�����Ϣ
     * @return int
     */
    public int updateJgdm(TJgdm tJgdm, User user, boolean flag,String jglx) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            tJgdm.setPzjgmc(user.getPrintName());
            em.merge(tJgdm);
            String codeId = tJgdm.getTyshxydm();
            //����û����ķ�����Ϣ,���ѡ�񷢿���Ҫ���п���Ϣ����
           /* if (flag) {
                em.createQuery("delete from  TkKxxk model where  model.jgdm =?1").setParameter(1, codeId).executeUpdate();
                em.flush();
                if ("1".equals(tJgdm.getFkbz())) {
                    int fksl = tJgdm.getFksl();
                    //��ȡҵ����ˮ��
                    String[] strs = new SerialBus().getLshNum("100000", "1", fksl);
                    if (strs != null && strs.length > 0) {
                        for (String num : strs) {
                            //����ic����Ϣ��
                            TkKxxk kxxk = new TkKxxk();
                            kxxk.setCzy(user.getUserName());
                            kxxk.setJgdm(tJgdm.getJgdm());
                            kxxk.setBkbz("1");
                            kxxk.setCzsj(DateUtil.getCurrentSystemDateTime());
                            kxxk.setSqsj(DateUtil.getCurrentSystemDateTime());
                            kxxk.setFkbz("0");
                            kxxk.setFlag("0");
                            kxxk.setGsbz("0");
                            kxxk.setSbbz("0");
                            kxxk.setXzqh(user.getBzjgdm());
                            kxxk.setXgbz("0");
                            kxxk.setHaveDown("0");
                            em.persist(kxxk);
                            //���������־
                            TCzjl czjl = new TCzjl();
                            czjl.setDate(DateUtil.getCurrentSystemDateTime());
                            czjl.setJgdm(tJgdm.getJgdm());
                            czjl.setName(user.getUserName());
                            czjl.setType("Q");
                            czjl.setXzqh(user.getBzjgdm());
                            czjl.setKlsh(Long.valueOf(num));
                            em.persist(czjl);
                        }
                    }
                    em.createNativeQuery("update s_serial set flow_id = flow_id + ?1 where xzqh_code = ?2 and table_type = ?3 ").setParameter(1, fksl).setParameter(2, "100000").setParameter(3, 1).executeUpdate();
                }
            }*/
       /*     if ((tJgdm.getDybz().equals("0")) && (!tJgdm.getJglx().equals("B")) && (!tJgdm.getJglx().equals("b"))) {
                Integer xbcqsz = InitSysParams.system.getXbcqsz();
                //�°��Ƿ񴦷�
                Boolean xbcqcf = InitSysParams.system.getXbsfcf();
                if (xbcqcf && xbcqsz > 0) {
                    String strsql = "select * from t_jgdm where datediff(day,zcrq,bzrq)>" + xbcqsz + " and jgdm='" + codeId + "'";
                    List cfList = em.createNativeQuery(strsql).getResultList();
                    em.clear();
                    if (cfList != null && cfList.size() > 0) {
                        TCfjlb cfjlb = new TCfjlb();
                        cfjlb.setJgdm(codeId);
                        cfjlb.setCfbz(false);
                        em.remove(cfjlb);
                        //em.createNativeQuery("delete from t_cfjlb where jgdm= 1? and  cfbz=0 ").setParameter(1, codeId).executeUpdate();
                        strsql = "insert into t_cfjlb(jgdm,bzjgdm,jgmc,jglx,fddbr,jgdz,zfrq,lrrq,lrr,zjhm,zjlx,njqx,zcrq,cflx) values('" + codeId + "','" + tJgdm.getXzqh() + "','" + tJgdm.getJgmc() + "','" + tJgdm.getJglx() + "','" + tJgdm.getFddbr() + "','" + tJgdm.getJgdz() + "','" + tJgdm.getZfrq() + "','" + DateUtil.getCurrentDateTime() + "','" + user.getUserName() + "','" + tJgdm.getZjhm() + "','" + tJgdm.getZjlx() + "','" + tJgdm.getNjqx() + "','" + tJgdm.getZcrq() + "','01')";
                        em.createNativeQuery(strsql).executeUpdate();
                    }
                }
            }*/
          /*  List<TSmrw> smrws = em.createQuery("select model from TSmrw model where  model.jgdm=?1 and (model.type in (0,3,4,6,9))")
                    .setParameter(1, tJgdm.getJgdm()).getResultList();
            for (TSmrw smrw : smrws) {
                BeanUtilsEx.copyProperties(smrw, tJgdm);
            }*/
            TCzjl czjl = new TCzjl();
            czjl.setDate(DateUtil.getCurrentSystemDateTime());
            czjl.setTyshxydm(codeId);
            czjl.setName(user.getUserName());
            czjl.setType("4");
            czjl.setXzqh(user.getBzjgdm());
            czjl.setMemo("����������޸�!");
            em.persist(czjl);
            em.flush();
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error(TjgdmBus.class, e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    /**
     * ��֤�޸�
     *
     * @param strFkbzOld
     * @param strFkslOld
     * @param user
     * @param tJgdm
     * @return
     */
    public int certChange(User user, TJgdm tJgdm,String jglx) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            String codeId = tJgdm.getJgdm();
            String strSysDate = DateUtil.getCurrentDateTime();
            String strsql = "";
       /*     if ("1".equals(tJgdm.getFkbz())) {
                strsql = "insert into t_czjl(name,type,date,jgdm,xzqh,klsh)  select";
                strsql = strsql + "'" + user.getUserName() + "','B','" + strSysDate + "','" + codeId + "','" + user.getBzjgdm() + "',lsh from tk_kxxk WHERE  jgdm ='" + codeId + "'";
                em.createNativeQuery(strsql).executeUpdate();
                strsql = " INSERT INTO tk_fzk(jgdm,kxlh,fzsj,operater,xzqh) SELECT jgdm,kxlh,'" + strSysDate + "','" + user.getUserName() + "','" + user.getBzjgdm() + "' FROM tk_kxxk WHERE kxlh is not null and jgdm ='" + codeId + "'";
                em.createNativeQuery(strsql).executeUpdate();
                em.createNativeQuery("delete from tk_kxxk where jgdm = ?1").setParameter(1, codeId).executeUpdate();
                int fksl = tJgdm.getFksl();
                //��ȡҵ����ˮ��
                String[] strs = new SerialBus().getLshNum("100000", "1", fksl);
                if (strs != null && strs.length > 0) {
                    for (String num : strs) {
                        //����ic����Ϣ��
                        TkKxxk kxxk = new TkKxxk();
                        kxxk.setLsh(Integer.valueOf(num));
                        kxxk.setCzy(user.getUserName());
                        kxxk.setJgdm(tJgdm.getJgdm());
                        kxxk.setBkbz("1");
                        kxxk.setCzsj(DateUtil.getCurrentSystemDateTime());
                        kxxk.setSqsj(new Date());
                        kxxk.setFkbz("0");
                        kxxk.setFlag("0");
                        kxxk.setGsbz("0");
                        kxxk.setSbbz("0");
                        kxxk.setXzqh(user.getBzjgdm());
                        kxxk.setXgbz("0");
                        kxxk.setHaveDown("0");
                        em.persist(kxxk);
                        //���������־
                        TCzjl czjl = new TCzjl();
                        czjl.setDate(DateUtil.getCurrentSystemDateTime());
                        czjl.setJgdm(tJgdm.getJgdm());
                        czjl.setName(user.getUserName());
                        czjl.setType("Q");
                        czjl.setXzqh(user.getBzjgdm());
                        czjl.setKlsh(Long.valueOf(num));
                        em.persist(czjl);
                    }
                }
                em.createNativeQuery("update s_serial set flow_id = flow_id + ?1 where xzqh_code = ?2 and table_type = ?3 ").setParameter(1, fksl).setParameter(2, "100000").setParameter(3, 1).executeUpdate();
            }*/
      /*      if (("0".equals(tJgdm.getFkbz()) || tJgdm.getFkbz() == null) && ("3".equals(tJgdm.getJglx()) || "4".equals(tJgdm.getJglx()))) {
                tJgdm.setFkbz(strFkbzOld);
                tJgdm.setFksl(strFkslOld);
            }*/
            /*strsql = "UPDATE t_zs SET flag='8',lastdate=getdate() WHERE  jgdm ='" + codeId + "' and flag='1'";
            em.createNativeQuery(strsql).executeUpdate();*/
         /*   strsql = "insert into t_bgk(bgrq,njjhy,njjlx,memo,memo2,bgsj,jgdm,jgmc,jglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjlx,zcrq,zgdm,pzjgdm,xzqh,jgdz,yzbm,dhhm,scbzrq,bzrq,zfrq,bzjgdm,zycp1,zycp2,zycp3,zczj,hbzl,wftzgb,zgrs,fbsl,zslsh,bgbj,lry,njrq,njr,njqx,xgr,zbsl,zch,qzbz,zgmc,pzjgmc,gslsh,gstbr,wjwlsh,pzwh,pwrq,wjwtbr,gk,fkbz,fksl,dybz,email,url,mobile,lastdate,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh) ";
            strsql = strsql + "select bgrq,njjhy,njjlx,memo,memo2,'" + strSysDate + "',jgdm,jgmc,jglx,fddbr,zjlx,zjhm,jyfw,jjhy,jjlx,zcrq,zgdm,pzjgdm,xzqh,jgdz,yzbm,dhhm,scbzrq,bzrq,zfrq,bzjgdm,zycp1,zycp2,zycp3,zczj,hbzl,wftzgb,zgrs,fbsl,zslsh,bgbj,lry,njrq,njr,njqx,xgr,zbsl,zch,qzbz,zgmc,pzjgmc,gslsh,gstbr,wjwlsh,pzwh,pwrq,wjwtbr,gk,fkbz,fksl,dybz,email,url,mobile,lastdate,tbrxm,tbrsfzh,tbrlxfs,gsfzrq,jydz,jyyb,jydh,jfly,khyh,khzh from t_jgdm where jgdm='" + codeId + "'";
            em.createNativeQuery(strsql).executeUpdate();*/
            //tJgdm.setDybz("2");
            TJgdm jgdm2 = em.find(TJgdm.class, tJgdm.getTyshxydm());
            TBgk bgk = new TBgk();
            BeanUtilsEx.copyProperties(bgk, jgdm2);
            //bgk.setBgsj(new Date());
            em.persist(bgk);
            em.merge(tJgdm);
            /*strsql = "select top 1 lsh,gllsh from t_sp where jgdm='" + codeId + "' and flag='1' and ywlx='02' order by lsh desc";
            List<Object[]> lshList = em.createNativeQuery(strsql).getResultList();
            String strLsh = "";
            String strGllsh = "";*/
           /* if (lshList != null && lshList.size() > 0) {
                Object[] objs = lshList.get(0);
                strLsh = objs[0].toString();
                strGllsh = objs[1].toString();
                strsql = "delete from t_sp where lsh=" + strLsh;
                em.createNativeQuery(strsql).executeUpdate();
                //ɾ������������ʱ��
                strsql = "delete from t_spdmtemp where lsh=" + strGllsh;
                em.createNativeQuery(strsql).executeUpdate();
            }*/
            //TSystem system = InitSysParams.system;

         /*   if (system.getIsSmTask() && system.getHzSmTask()) {
                List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                        .setParameter(1, "4")
                        .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date()))).setParameter(3, tJgdm.getJgdm()).getResultList();
                if (rws.isEmpty() && rws.size() <= 0) {

                    TSmrw task = new TSmrw();
                    BeanUtilsEx.copyProperties(task, tJgdm);
                    task.setId(null);
                    task.setCreateTime(new Date());
                    task.setStatus(false);
                    task.setType("4");
                    task.setCzr(user.getUserName());
                    em.persist(task);
                }
            }*/
        /*    String sql = "delete Hzcq where jgdm='" + tJgdm.getJgdm() + "'";
            em.createQuery(sql).executeUpdate();*/
            TCzjl czjl = new TCzjl();
            czjl.setDate(DateUtil.getCurrentSystemDateTime());
            czjl.setTyshxydm(tJgdm.getTyshxydm());
            czjl.setName(user.getUserName());
            czjl.setType("8");
            czjl.setXzqh(user.getBzjgdm());
            if("1".equals(jglx)){
            	
            	czjl.setMemo("���Ż�֤����!");
            }else if("2".equals(jglx)){
            	czjl.setMemo("��ǻ�֤����!");
            }else if("3".equals(jglx)){
            	czjl.setMemo("����ỻ֤����!");
            }
            em.persist(czjl);
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error(TjgdmBus.class, e);
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    public String[] getLshNum(String xzqh, String table_type, int number) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        String[] lshs = new String[number];
        try {
            List<Object[]> list = em.createNativeQuery("select flow_id,flow_id_len from s_serial where xzqh_code = '" + xzqh + "' and table_type = '" + table_type + "' ").getResultList();
            String[] wjwlshs = new String[number];

            String wjwlsh = "";
            String flow_id_len = "";
            if (list != null && list.size() > 0) {
                Object[] objs = list.get(0);
                wjwlsh = objs[0].toString();
                flow_id_len = objs[1].toString();
            }

            for (int i = 0; i < number; i++) {
                wjwlshs[i] = String.valueOf(Integer.valueOf(wjwlsh) + i);
            }
            if (wjwlshs.length > 0) {
                for (int i = 0; i < wjwlshs.length; i++) {
                    String temp = "";
                    String lsh = wjwlshs[i];
                    if (lsh.length() < Integer.valueOf(flow_id_len.trim())) {
                        for (int j = 0; j < Integer.valueOf(flow_id_len.trim()) - wjwlsh.length(); j++) {
                            temp += "0";
                        }
                        lsh = temp + lsh;
                        lshs[i] = lsh;
                    } else {
                        lshs[i] = wjwlshs[i];
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return lshs;
    }

    public String checkJgdmForIC(String jgdm, String bzjgdm, String userName) {

        TJgdm dm = tJgdmDAO.findById(jgdm);
        if (null == dm) {
            return "false:�������루" + jgdm + "�������ڣ�";
        }
        if (!"1".equals(dm.getDybz()))
            return "false:�������루" + jgdm + "����δ��֤�����ܰ����ҵ��";

        if (!(userName.contains("admin") || dm.getBzjgdm().equals(bzjgdm))) {
            return "false:�������루" + jgdm + "�������ڱ���֤��������(ԭ��֤������" + InitSysParams.zrxzqhMap.get(dm.getBzjgdm()) + ")�������ڴ˰���ҵ��";
        }
           /* if (bzjgdm.subSequence(4, 6).equals("00")) {
                if (!dm.getBzjgdm().startsWith(bzjgdm.substring(0, 4)))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            } else {
                if (!dm.getBzjgdm().equals(bzjgdm))
                    return "false:�������루" + jgdm + "�������ڱ���֤�������������ڴ˰���ҵ��";
            }*/
        return "true";
    }

    public List<TjgdmVO> listTjgdm(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod,String jglx,String tyshxydm) {
        List<TjgdmVO> list = null;
        try {
            String cond = handleBus.sql(user);
            String jql = "select model.tyshxydm,model.jgmc,model.bzrq,s.flag,s.shflag,model.xzqh,model.zch from t_jgdm model left join (select tyshxydm,flag,shflag from  t_sp  where  flag !=2 and ywlx in ('16') ) s on model.tyshxydm = s.tyshxydm where " + cond + " and model.dybz <> '1'";
            List<Object> pms = new ArrayList();
             if (!clsStringTool.isEmpty(tyshxydm)) {
            jql+=" and (model.tyshxydm='"+tyshxydm+"' or model.jgdm='"+tyshxydm+"')";
        }
            
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } 
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                if ("jgdm".equals(orderbyColum)) {
                    orderByContent = "model.tyshxydm" + " " + orderbyMethod;
                } else
                    orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.bzrq desc";
            }
            jql += " order by " + orderByContent;
            List<Object[]> returnList = tJgdmDAO.listTjgdm(jql, pageno, rowNumsView, pages, pms);
            if (returnList != null && returnList.size() > 0) {
                list = new ArrayList<TjgdmVO>();
                TjgdmVO vo = null;
                for (Object[] objects : returnList) {
                    vo = new TjgdmVO();
                    vo.setJgdm(objects[0].toString());
                    vo.setJgmc(objects[1].toString());
                    vo.setBzrq(DateUtil.strToDate(objects[2].toString()));
                    vo.setFlag(objects[3] == null ? "" : objects[3].toString());
                    vo.setShflag(objects[4] == null ? "" : objects[4].toString());
                    vo.setXzqh(objects[5] == null ? "" : objects[5].toString());
                    vo.setZch(objects[6] == null ? "" : objects[6].toString());
                    list.add(vo);
                }
            }
        } catch (Exception e) {
            log.error(e);
            log.error("TJgdmBus listTjgdm error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }

    public List<TjgdmVO> listCertTjgdm(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod,String jglx,String tyshxydm) {
        List<TjgdmVO> list = null;
        try {
            String cond = handleBus.sql(user);
            //���ݺ�̨���û�֤�������޼���ʱ�� ��ǰ���ڼӺ�̨���õ�ʱ��
            //String date = (InitSysParams.system.getHzqx() == null || InitSysParams.system.getHzqx() <= 0) ? DateUtil.dateToStr(new Date()): DateUtil.dateToStr(DateUtil.dayAfter(new Date(), InitSysParams.system.getHzqx()));
            //String jql = "select new com.ninemax.jpa.code.model.vo.TjgdmVO(model.jgdm,model.jgmc,model.bzrq) from TJgdm model where " + cond + " and model.zfrq <= '" + date + "' ";
            String jql = "select new com.ninemax.jpa.code.model.vo.TjgdmVO(model.jgdm,model.jgmc,model.bzrq,model.tyshxydm,model.bzjgdm,model.zch) from TJgdm model where "+cond+" and model.jglx='"+jglx+"' and  model.dybz='1' and  (model.tyshxydm like '" + "%" + ("".equals(tyshxydm) ? "" : tyshxydm) + "%" + "' or model.jgdm like '" + "%" + ("".equals(tyshxydm) ? "" : tyshxydm) + "%" + "')";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } 
                    pms.add(value);
                }
                String orderByContent = "";
                if (!clsStringTool.isEmpty(orderbyColum)
                        && !clsStringTool.isEmpty(orderbyMethod)) {
                    orderByContent = orderbyColum + " " + orderbyMethod;
                } else {
                    orderByContent = " model.bzrq desc";
                }
                orderByContent = " model.bzrq desc";
            }
            jql += " order by model.bzrq desc" ;
            list = tJgdmDAO.listCertTjgdm(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TJgdmSaveBus delListTjgdmSave error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return list;
    }

    public boolean isChuFa() {
        return InitSysParams.system.getIsPunish() == null ? false : InitSysParams.system.getIsPunish();
    }

    public List<TCfjlb> getCfzlList(String jgdm) {
        List<TCfjlb> cfjlbList = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            cfjlbList = em.createQuery("select model from TCfjlb model where model.jgdm='" + jgdm + "' and model.cfbz=false").getResultList();
        } catch (Exception e) {
            log.error("TJgdmBus isChuFa exception============" + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return cfjlbList;
    }

    public int forceUpdate(TJgdm tjgdm, TBgk jgdmHis, User user) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(jgdmHis);
            TCzjl czjl = new TCzjl();
            czjl.setDate(DateUtil.getCurrentSystemDateTime());
            czjl.setJgdm(tjgdm.getTyshxydm());
            czjl.setName(user.getUserName());
            czjl.setType("Z");
            czjl.setXzqh(user.getBzjgdm());
            czjl.setMemo("��Ϣ�޸ģ���Ч�⣩");
            em.persist(czjl);
            em.merge(tjgdm);
            result = 1;
            tx.commit();
        } catch (Exception e) {
            log.error("TJgdmBus forceUpdate exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    public String problemDatas(String jgdm) {
        EntityManager codeEm = CodeEntityManagerHelper.getEntityManager();
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManager checkEm = CheckEntityManagerHelper.getEntityManager();
        try {
            int flag = 0;
            List list = codeEm.createQuery("select model from SmProJgdm model where model.jgdm=?1").setParameter(1, jgdm).getResultList();
            if (!list.isEmpty()) {
                flag |= 1;
            }
            list = em.createQuery("select model from TProjgdmGj model where model.jgdm=?1").setParameter(1, jgdm).getResultList();
            if (!list.isEmpty()) {
                flag |= 2;
            }
            list = checkEm.createQuery("select model from TJgdmCysh model where model.jgdm=?1").setParameter(1, jgdm).getResultList();
            if (!list.isEmpty()) {
                flag |= 4;

            }
            if (flag == 1) {
                return "true:���½�Ҫ�������������ݣ�ȷ���ύ��";
            }
            if (flag == 2) {
                return "true:���½�Ҫ�����ع����������ݣ�ȷ���ύ��";
            }
            if (flag == 3) {
                return "true:���½�Ҫ��������������,�����������ݣ�ȷ���ύ��";
            }
            if (flag == 4) {
                return "true:���½�Ҫ����������������ݣ�ȷ���ύ��";
            }
            if (flag == 5) {
                return "true:���½�Ҫ��������������,����������ݣ�ȷ���ύ��";
            }
            if (flag == 6) {
                return "true:���½�Ҫ�����ع�����������,����������ݣ�ȷ���ύ��";
            }
            if (flag == 7) {
                return "true:���½�Ҫ��������������,������������,����������ݣ�ȷ���ύ��";
            }
        } catch (Exception e) {
        } finally {
            CodeEntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManager();
            CheckEntityManagerHelper.closeEntityManager();
        }
        return "false";
    }

    public String checkJgdmStatus(String jgdm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            TJgdm dm = em.find(TJgdm.class, jgdm);
            //���������
            if (dm == null) {
                TFzdm fzdm = null;
                fzdm = em.find(TFzdm.class, jgdm);
                //��������ע����
                if (fzdm == null) {

                    TLjdm ljdm = null;
                    ljdm = em.find(TLjdm.class, jgdm);
                    //��Ч�����
                    if (ljdm == null) {
                        List<TQzjgdm> qzdms = null;
                        qzdms = em.createQuery("select model from TQzjgdm model where model.jgdm=:jgdm and  model.qzbz<>'2' order by model.lastdate desc")
                                .setParameter("jgdm", jgdm).getResultList();
                        //��������Ǩַ��
                        if (qzdms == null || qzdms.isEmpty()) {
                            return ("��ѯ�Ļ������벻����");
                        } else {
                            return ("������������Ǩַ");
                        }
                    } else {
                        return ("����������ע��");
                    }


                } else {
                    return ("��������������Ч����");
                }
            } else {
                List<TSp> sps = em.createQuery("select  model from TSp model where model.jgdm=:jgdm and model.flag=:flag").setParameter("jgdm", jgdm).setParameter("flag", "0").getResultList();
                if (sps != null && !sps.isEmpty() && sps.size() > 0) {
                    return ("�����������������");
                } else {
                    if (!"1".equals(dm.getDybz())) {
                        return ("��������δ��֤,���֤");
                    } else {
                        if (Calendar.getInstance().after(dm.getZfrq())) {
                            return ("���������ѹ���");
                        } else {
                            List<TCfjlb> cfjlbs = em.createQuery("select model from TCfjlb model where model.jgdm=:jgdm and model.cfbz=false").setParameter("jgdm", jgdm).getResultList();
                            if (cfjlbs != null && !cfjlbs.isEmpty() && cfjlbs.size() > 0) {
                                return ("�������봦����");
                            } else {

                                return ("������������");

                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("TJgdmBus forceUpdate exception============" + e.toString());
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;
    }

    public boolean updateTjgdm(TJgdm tJgdm) {
        return tJgdmDAO.update(tJgdm);
    }



   /* public static void main(String[] args) {
        int flag = 10000;
        System.out.println("flag = " + flag);
        flag |= 20000;
        System.out.println("flag = " + flag);
        flag |= 2;
        System.out.println("flag = " + flag);
        flag |= 4;
        System.out.println("flag = " + flag);
    }*/
}
