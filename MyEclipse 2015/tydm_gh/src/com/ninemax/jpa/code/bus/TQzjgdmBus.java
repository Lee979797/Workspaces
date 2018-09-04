package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TQzjgdmDAO;
import com.ninemax.jpa.code.model.TQzjgdm;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ����1:33
 */
public class TQzjgdmBus {

    private static Logger log = Logger
            .getLogger(TQzjgdmBus.class);

    private TQzjgdmDAO tQzjgdmDAO = new TQzjgdmDAO();
    private TZrxzqhBus zrxzqhBus = new TZrxzqhBus();

    /**
     * �Ƿ���ڻ�������
     *
     * @param codeName
     * @return
     */
    public boolean isExistCodeName(String codeName, String jgdm) {
        List<TQzjgdm> list = null;
        try {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            map.put("jgmc", codeName);
            map.put("qzbz", "1");
            list = EntityManagerHelper.getEntityManager().createQuery("select model from TQzjgdm model where model.jgmc='" +
                    codeName + "' and model.qzbz <> '2'  and model.qzbz <> '0' ").getResultList();

        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return (list != null && !list.isEmpty() && (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }

    /**
     * �Ƿ�淨��������
     *
     * @param fddbr
     * @return
     */
    public boolean isExistFrdb(String fddbr, String jgdm) {
        List<TQzjgdm> list = null;
        try {
            list = EntityManagerHelper.getEntityManager().createQuery("select model from TQzjgdm model where model.fddbr='" +
                    fddbr + "' and model.qzbz <> '2' ").getResultList();

        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return !(list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }

    /**
     * �Ƿ��֤������
     *
     * @param zjlx
     * @param zjhm
     * @param jgdm
     * @return
     */
    public boolean isExistZjhm(String zjlx, String zjhm, String jgdm) {
        List<TQzjgdm> list = null;
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("zjlx", zjlx);
            map.put("zjhm", zjhm);
            list = EntityManagerHelper.getEntityManager().createQuery("select model from TQzjgdm model where model.zjlx='" +
                    zjlx + "' and model.zjhm='" + zjhm + "' and model.qzbz <> '2' ").getResultList();
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return !(list == null || list.isEmpty() || (list.size() == 1 && list.get(0).getJgdm().equals(jgdm)));
    }

    /**
     * ����ע��Ų�ѯ�б�
     *
     * @param zch
     * @return
     */
    public List<TQzjgdm> isExistZch(String zch, String jglx) {
        List<TQzjgdm> tQzjgdmList = null;
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            tQzjgdmList = em.createQuery("select model from TQzjgdm model where model.zch='" +
                    zch + "' and model.qzbz <> '2' ").getResultList();
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return tQzjgdmList;
    }

    /**
     * ���qzjgdm�Ƿ����     ��Ǩ���ز��ǵ�ǰ����
     *
     * @param jgdm ��������
     * @param bzjg Ǩ�뵽��������
     * @param type
     * @return
     */
    public String checkForIn(String jgdm, String bzjg, String userName, String type) {
        log.info("checkForIn:" + jgdm + "::" + type);
        String sql = "select model from TQzjgdm model where model.jgdm='" + jgdm + "' and model.qzbz='" + type + "'";
        List<TQzjgdm> dms = tQzjgdmDAO.findbyhql(sql);
        if (dms == null || dms.isEmpty()) {
            return "false:��ѯ�Ļ������루" + jgdm + "����������Ǩַ���У���������Ƿ������Ǩַ��";
        }

        TQzjgdm qzjgdm = dms.get(0);
        if (qzjgdm.getQzbz() == null || qzjgdm.getQzbz().equals("0")) {
            return "false:�������루" + jgdm + "���Ѿ����Ǩַ������Ҫ�ٴΰ���Ǩַ��";
        }
        if (userName.contains("admin")) {
            return "true";
        }
        User user = new User();
        user.setUserName(userName);
        user.setBzjgdm(bzjg);
        List<String> bzjgs = zrxzqhBus.getXzqhs(user);
        if (qzjgdm.getQrdbzjgdm() == null || !bzjgs.contains(qzjgdm.getQrdbzjgdm())) {
            return "false:�������루" + jgdm + "�������ڵ�ǰ��֤����,�뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getQrdbzjgdm()) + "��������";
        }

        return "true";
    }

    /**
     * ���qzjgdm�Ƿ����
     *
     * @param jgdm
     * @param type
     * @return
     */
    public String checkForRedo(String jgdm, String bzjg, String userName, String type) {
        String sql = "select model from TQzjgdm model where model.jgdm='" + jgdm + "' and model.qzbz='" + type + "'";
        List<TQzjgdm> dms = tQzjgdmDAO.findbyhql(sql);
        if (dms == null || dms.isEmpty()) {
            return "false:��ѯ�Ļ������루" + jgdm + "��û�а���Ǩַ����Ϊ��" + (type.equals("1") ? "ʡ��" : (type.equals("2") ? "Ԥ����" : "ʡ��")) + "����Ǩַҵ�񣬲���Ҫ����Ǩַ�ָ���";
        }
        TQzjgdm qzjgdm = dms.get(0);
        if (userName.contains("admin")) {
            return "true";
        }
        User user = new User();
        user.setUserName(userName);
        user.setBzjgdm(bzjg);
        List<String> bzjgs = zrxzqhBus.getXzqhs(user);
        if (qzjgdm.getBzjgdm() == null || !bzjgs.contains(qzjgdm.getBzjgdm())) {
            return "false:�������루" + jgdm + "�������ڵ�ǰ��֤����,�뵽��" + InitSysParams.zrxzqhMap.get(qzjgdm.getQrdbzjgdm()) + "��������";
        }
        return "true";
    }

    /**
     * �жϻ��������Ƿ���Ǩַ��
     *
     * @param jgdm
     * @return
     * @author zx
     */
    public Boolean checkJgdm(String jgdm) {
        String sql = "select model from TQzjgdm model where model.jgdm='";
        sql = sql + jgdm + "' and (model.qzbz='1' or model.qzbz='3') ";

        List<TQzjgdm> dms = tQzjgdmDAO.findbyhql(sql);
        return !(dms == null || dms.isEmpty());
    }


    public TQzjgdm getQzjgdm(String jgdm) {
        String sql = "select model from TQzjgdm model where model.jgdm='";
        sql = sql + jgdm + "' and (model.qzbz='1' or model.qzbz='3') ";

        List<TQzjgdm> dms = tQzjgdmDAO.findbyhql(sql);
        if (dms == null || dms.isEmpty()) {
            return null;
        } else
            return dms.get(0);
    }

    public TQzjgdm getQzjgdmByJgdm(String jgdm) {
        String sql = "select model from TQzjgdm model where model.jgdm='" + jgdm + "'";
        List<TQzjgdm> dms = tQzjgdmDAO.findbyhql(sql);
        if (dms == null || dms.isEmpty()) {
            return null;
        } else
            return dms.get(0);
    }

    public List<TQzjgdm> listQzTjgdm(User user, Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages, String orderbyColum, String orderbyMethod) {
        List<TQzjgdm> list = null;
        try {
            String cond = new HandleBus().sql(user);
            String jql = "from TQzjgdm model where " + cond + " and (model.qzbz = '1' or model.qzbz = '3') ";
            List<Object> pms = new ArrayList();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    if ("jgmc".equals(key)) {
                        value = "%" + value + "%";
                        jql += " and " + key + " like ?";
                    } else
                        jql += " and " + key + " = ?";
                    pms.add(value);
                }
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum)
                    && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent = orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent = " model.bzrq desc";
            }
            jql += " order by " + orderByContent;
            list = tQzjgdmDAO.listQzTjgdm(jql, pageno, rowNumsView, pages, pms);
        } catch (Exception e) {
            log.error("TQzjgdmBus listQzTjgdm error " + e.toString());
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return list;
    }
}
