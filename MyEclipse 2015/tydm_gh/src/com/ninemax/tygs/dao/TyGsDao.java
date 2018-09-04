package com.ninemax.tygs.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TYwlc;
import com.ninemax.jpa.code.model.TZgjg;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.tygs.model.TDmsj;
import com.ninemax.tygs.model.TGssj;


public class TyGsDao {
	private static Logger log = Logger.getLogger(TyGsDao.class);

	private EntityManager getEntityManager() {
		return CodeEntityManagerHelper.getEntityManager();
	}

	
	/**
	 * 更新工商数据状态
	 * fh
	 * 2015-6-1
	 * @param id
	 * @return
	 * Version @1.0
	 */
	public boolean upStatus(String id){
        boolean flag = true;
        EntityManager em = CodeEntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            final String queryString = "update t_gssj set tqflag='1' where lsh= '" + id + "'";
            em.createNativeQuery(queryString).executeUpdate();
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("error", e);
            log.error(e);
            return flag;
        } finally {
        	CodeEntityManagerHelper.closeEntityManager();
        }
        return flag;
	}
	/**
	 * 工商数据推送
	 * fh
	 * 2015-6-1
	 * @param id
	 * @return
	 * Version @1.0
	 */
	public void ts(TJgdm jgdm,User user){
        boolean flag = true;
        EntityManager em = CodeEntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
           tx.begin();
           TDmsj dmsj=new TDmsj();
           List<TGssj> gssjList=em.createQuery("from TGssj model where model.lsh='"+jgdm.getBak4()+"'").getResultList();
           TGssj gssj=gssjList.get(0);
           dmsj.setBzdwdm(user.getBzjgdm());
           dmsj.setBzdwmc(InitSysParams.zrxzqhMap2.get(user.getBzjgdm()).getJgmc());
           dmsj.setZzsyzdm(jgdm.getJgdm());
           dmsj.setZzsyzmc(jgdm.getJgmc());
           dmsj.setLsh(jgdm.getBak4());
        
           dmsj.setGxrq(new Date());
           dmsj.setHzsj(jgdm.getBzrq());
           dmsj.setFstime(new Date());
           dmsj.setFsflag("1");
           dmsj.setBusinessid(gssj.getId().toString());
           dmsj.setTydm(jgdm.getBak2());
           em.persist(dmsj);
           tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("error", e);
            log.error(e);
           
        } finally {
        	CodeEntityManagerHelper.closeEntityManager();
        }
      
	}
	public boolean add(Object table){
		boolean flag = true;
		EntityManager em = EntityManagerHelper.getEntityManager();
		em.clear();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(table);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			log.error("error", e);
			log.error(e);
			return flag;
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return flag;
	}
	public boolean update(String zch){
		 boolean flag = true;
		 EntityManager em = EntityManagerHelper.getEntityManager();
	        em.clear();
	        EntityTransaction tx = em.getTransaction();
	        try {
	        
	            final String queryString = "update t_qydjbgxx set status='1' where regno= '" + zch + "'";
	            em.createNativeQuery(queryString).executeUpdate();
	            tx.commit();
	         } catch (Exception e) {
	             flag = false;
	             if (tx != null && tx.isActive()) {
	                 tx.rollback();
	             }
	             log.error("error", e);
	             log.error(e);
	            
	         } finally {
	         	EntityManagerHelper.closeEntityManager();
	         }
	         return flag;
	}
	public boolean updatefz(String zch){
		 boolean flag = true;
		 EntityManager em = EntityManagerHelper.getEntityManager();
	        em.clear();
	        EntityTransaction tx = em.getTransaction();
	        try {
	        
	            final String queryString = "update t_qydjfzxx set status='1' where regno= '" + zch + "'";
	            em.createNativeQuery(queryString).executeUpdate();
	            tx.commit();
	         } catch (Exception e) {
	             flag = false;
	             if (tx != null && tx.isActive()) {
	                 tx.rollback();
	             }
	             log.error("error", e);
	             log.error(e);
	            
	         } finally {
	         	EntityManagerHelper.closeEntityManager();
	         }
	         return flag;
	}
}
