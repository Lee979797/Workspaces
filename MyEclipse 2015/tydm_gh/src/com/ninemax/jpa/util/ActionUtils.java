/**
 *
 */
package com.ninemax.jpa.util;

import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Bzjgdm;
import com.ninemax.jpa.system.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yanzh
 */
public abstract class ActionUtils extends ActionSupport {
    protected static final Logger log = Logger.getLogger(ActionUtils.class);
    public EntityManager em;
    public EntityTransaction tx;
    private Map<String, Object> session;
    private User user;

    public ActionUtils() {
        em = EntityManagerHelper.getEntityManager();
        tx = em.getTransaction();
    }

   /* public ActionUtils(String unit) {
        em = EntityManagerHelper.getEntityManager(unit);
        tx = em.getTransaction();
    }*/

    public ActionUtils(Map<String, Object> session) {
        this();
        this.session = session;
    }

 /*   public ActionUtils(String unit, Map<String, Object> session) {
        this(unit);
        this.session = session;
    }*/

    public User getUser() {
        if (user == null)
            user = (User) session.get("sysUser");
        return user;
    }

    private Boolean isMain() {
    	Bzjgdm zrxzqh = em.find(Bzjgdm.class, user.getBzjgdm());
        return true;
    }

    public List<String> getXzqhs() {

        List<Bzjgdm> xzqhs = em.createQuery("SELECT model from Bzjgdm model where  model.dm=:bzjgdm").setParameter("bzjgdm", getUser().getBzjgdm()).getResultList();
        List<String> bzjgdms = new ArrayList<String>();
        for (Bzjgdm zrxzqh : xzqhs) {
            bzjgdms.add(zrxzqh.getDm());
        }
        return bzjgdms;
    }

    public String sql() {
    	String sql="";
        if (getUser().getUserName().equals("admin")) {
            return " 1=1 ";
        }else{
        	
        	sql = " model.bzjgdm='" + user.getBzjgdm() + "' ";
        }

      
       
        return sql;
    }
    public String sql(User user) { 
    	if (user.getUsergroupId().equals("1")) {
    		return " 1=1 ";
    	}else{
    		return " bzjgdm='"+user.getBzjgdm()+"'";
    	}
    }
    
    public String sqlse() {
        if (getUser().getUserName().contains("admin")) {
            return " 1=1 ";
        }
        String sql = "";
        List<String> xzqhs = getXzqhs();
        if (!isMain() || xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
            sql = " model.xzqh='" + user.getBzjgdm() + "' ";
        } else {
            sql = " model.xzqh in ('";
            for (String bzjgdm : xzqhs) {
                sql += bzjgdm + "','";
            }
            sql += user.getBzjgdm();
            sql += "') ";
        }
        return sql;
    }
    
    

    public String sql(String name) {
        String sql = "";
        List<String> xzqhs = getXzqhs();
        if (isMain() || xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
            sql = " " + name + "='" + user.getBzjgdm() + "' ";
        } else {
            sql = " " + name + " in ('";
            for (String bzjgdm : xzqhs) {
                sql += bzjgdm + "','";
            }
            sql += user.getBzjgdm() + "'";
            sql += " ) ";
        }
        return sql;
    }
    public String nSyTemplate() {
        synchronized (log) {
            if (em == null || !em.isOpen())
                em = EntityManagerHelper.getEntityManager();
           try {
                excute();
                   return SUCCESS;
            } catch (Exception e) {
                this.addActionError(e.getMessage());
                log.error(ActionUtils.class, e);
                return ERROR;
            } finally {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }
    public String template() {
        synchronized (log) {
            if (em == null || !em.isOpen())
                em = EntityManagerHelper.getEntityManager();
            if (tx == null)
                tx = em.getTransaction();
            tx.begin();
            try {
                excute();
                if (tx.isActive())
                    tx.commit();
                return SUCCESS;
            } catch (Exception e) {
                if (tx.isActive())
                    tx.rollback();
                this.addActionError(e.getMessage());
                log.error(ActionUtils.class, e);
                return ERROR;
            } finally {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    public void run() {
        synchronized (log) {
            if (em == null || !em.isOpen())
                em = EntityManagerHelper.getEntityManager();
            if (tx == null)
                tx = em.getTransaction();
            tx.begin();
            try {
                excute();
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                log.error(ActionUtils.class, e);
            } finally {
                EntityManagerHelper.closeEntityManager();
            }
        }
    }

    protected abstract void excute() throws Exception;
}