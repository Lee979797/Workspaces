/**
 *
 */
package com.ninemax.jpa.util;

import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.ThamsEntityManagerHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author yanzh
 */
public abstract class ThamsActionUtils extends ActionSupport {
    private static Logger log = Logger.getLogger(ActionUtils.class);
    public EntityManager em = ThamsEntityManagerHelper.getEntityManager();
    public EntityTransaction tx = em.getTransaction();

    public String nSyTemplate() {
        if (em == null || !em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        try {
            excute();
            em.clear();
            return SUCCESS;
        } catch (Exception e) {
            log.error(ThamsActionUtils.class, e);
            return ERROR;
        } finally {
            ThamsEntityManagerHelper.closeEntityManager();
        }
    }

    public String template() {
        if (em == null || !em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        if (tx == null)
            tx = em.getTransaction();
        tx.begin();
        try {
            excute();
            em.clear();
            tx.commit();
            return SUCCESS;
        } catch (Exception e) {
            tx.rollback();
            log.error(ThamsActionUtils.class, e);
            return ERROR;
        } finally {
            ThamsEntityManagerHelper.closeEntityManager();
        }
    }

    protected abstract void excute() throws Exception;
}