package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: ÏÂÎç5:38
 */
public class StandardBus {
    private static Logger log = Logger.getLogger(StandardBus.class);

    public Boolean isExitDM(String table, String dm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if (em == null && !em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        if (tx == null)
            tx = em.getTransaction();
        tx.begin();
        try {
            String sql = "";
            if("t_zgjg".equals(table)){
                sql = "select jgdm ,zgjgmc from " + table + "   where jgdm ='" + dm + "' ";
            }else if("t_pzjg".equals(table)){
                sql = "select bzjg_id from sc_bzjgdm   where bzjg_id='" + dm + "' ";
            }else if("sc_jglx_pzjg".equals(table)){
                sql = "select pzjgdm from " + table + "   where pzjgdm ='" + dm + "' ";
            }else
                sql = "select dm ,mc from " + table + "   where dm ='" + dm + "' ";

            List list = em.createNativeQuery(sql)
                    .getResultList();
            if (list == null || list.isEmpty()) {
                return false;
            }
            em.clear();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;

    }
    
    public Boolean isExitName(String table, String mc, String dm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
      //  EntityTransaction tx = em.getTransaction();
        if (em == null && !em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        //if (tx == null)
          //  tx = em.getTransaction();
        //tx.begin();
        try {
            String sql = "";
            if("t_zgjg".equals(table)){
                sql = "select jgdm ,zgjgmc from " + table + "   where zgjgmc ='" + mc + "' ";
            }else  if("t_pzjg".equals(table)){
                sql = "select bzjg_id,bzjg_name from sc_bzjgdm  where bzjg_name='" + mc + "' ";
            }else  if("sc_bzjgdm".equals(table)){
                sql = "select bzjg_id,bzjg_name from sc_bzjgdm  where bzjg_name='" + mc + "' ";
            }else  if("sc_jjhy".equals(table)){
                sql = "select id,dm,mc from sc_jjhy  where mc='" + mc + "' ";
            }else
                sql = "select dm,mc from " + table + " where mc = '" + mc + "' ";
            List list = em.createNativeQuery(sql)
                    .getResultList();
            em.clear();
            if (list == null || list.isEmpty()) {
                return false;
            } else {
                if (list.size() == 1) {
                    Object[] objects = (Object[]) list.get(0);
                    if (objects[0] != null && objects[0].toString().trim().equals(dm.trim())) {
                        return false;
                    }
                }
            }
           // tx.commit();
        } catch (Exception e) {
            //tx.rollback();
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;

    }

    public Boolean isExitGbJcName(String table, String zfdm, String dm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if (em == null && !em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        if (tx == null)
            tx = em.getTransaction();
        tx.begin();
        try {
            String sql = "select dm ,zfdm from " + table + "   where zfdm ='" + zfdm + "' ";
            List list = em.createNativeQuery(sql)
                    .getResultList();
            if (list == null || list.isEmpty()) {
                return false;
            } else {
                if (list.size() == 1) {
                    Object[] objects = (Object[]) list.get(0);
                    if (objects[0] != null && objects[0].equals(dm)) {
                        return false;
                    }
                }
            }
            em.clear();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;

    }

    public Boolean isExitGbJc(String table, String zfdm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if (em == null && !em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        if (tx == null)
            tx = em.getTransaction();
        tx.begin();
        try {
            String sql = "select dm ,zfdm from " + table + "   where zfdm ='" + zfdm + "' ";
            List list = em.createNativeQuery(sql)
                    .getResultList();
            if (list == null || list.isEmpty()) {
                return false;
            } else {
                if (list.size() == 1) {
                    Object[] objects = (Object[]) list.get(0);
                    if (objects[0] != null && objects[0].equals(zfdm)) {
                        return false;
                    }
                }
            }
            em.clear();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            log.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;

    }

}
