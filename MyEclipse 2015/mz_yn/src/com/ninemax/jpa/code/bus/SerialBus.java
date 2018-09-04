package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.SerialDAO;
import com.ninemax.jpa.code.model.Serial;
import com.ninemax.jpa.code.model.SerialPK;
import com.ninemax.jpa.global.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-11
 * Time: 下午7:23
 */
public class SerialBus {

    private SerialDAO dao;

    public SerialBus() {
        dao = new SerialDAO();
    }

    /**
     * 获取单个流水号
     *
     * @param xzqh
     * @param table_type
     * @return
     */
    public String getLsh(String xzqh, String table_type) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        String lsh = "";
        try{
            SerialPK pk = new SerialPK();
            pk.setTableType(table_type);
            pk.setXzqhCode(xzqh);
            Serial serial = em.find(Serial.class, pk);
            em.clear();

            String flow_id_len = "";
            if (serial != null) {
                lsh = serial.getFlowId().toString();
                flow_id_len = serial.getFlowIdLen();
            } else {
                serial = new Serial();
                serial.setTableType(table_type);
                serial.setXzqhCode(xzqh);
                serial.setFlowId(0);
                serial.setFlowIdLen("6");
                em.persist(serial);
                em.flush();
            }
            String temp = "";
            if ("".equals(flow_id_len.trim()))
                flow_id_len = "6";
            int len = Integer.valueOf(flow_id_len.trim());
            if (lsh.length() < len) {
                for (int i = 0; i < len - lsh.length(); i++) {
                    temp += "0";
                }
                lsh = temp + lsh;
            }
        }catch (Exception e){}finally {
            EntityManagerHelper.closeEntityManager();
        }
        return lsh;
    }

    /**
     * 获取指定数量的流水号
     *
     * @param xzqh
     * @param table_type
     * @return
     */
    public String[] getLshNum(String xzqh, String table_type, int number) {
        List<Object[]> list = dao.findbysql("select flow_id,flow_id_len from s_serial where xzqh_code = '" + xzqh + "' and table_type = '" + table_type + "' ");
        String[] wjwlshs = new String[number];
        String[] lshs = new String[number];
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
                }else{
                    lshs[i] = wjwlshs[i];
                }
            }
        }
        return lshs;
    }

    public boolean updateLsh(int num, String xzqh, String table_type) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        boolean flag = false;
        try {
            tx = em.getTransaction();
            tx.begin();
            em.createNativeQuery("update s_serial set flow_id = flow_id + ?1 where xzqh_code = ?2 and table_type = ?3 ").setParameter(1, num).setParameter(2, xzqh).setParameter(3, table_type).executeUpdate();
            flag = true;
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            flag = true;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    public static void main(String[] args) {
        String[] strs = new SerialBus().getLshNum("100000", "1", 3);
        if (strs != null && strs.length > 0) {
            for (String str : strs) {
                //System.out.println(str);
            }
        }
        /*String str = new SerialBus().getLsh("100000","1");
        System.out.println(str);*/
    }

}
