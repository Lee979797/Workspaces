/**
 *
 */
package com.ninemax.jpa.util;

import com.ninemax.jpa.global.CodeEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * @author yanzh
 */
public abstract class CodeActionUtils extends ActionSupport {
    private static Logger log = Logger.getLogger(ActionUtils.class);
    public EntityManager em = CodeEntityManagerHelper.getEntityManager();
    public EntityTransaction tx = em.getTransaction();

    public String template() {
        if (em == null || !em.isOpen())
            em = CodeEntityManagerHelper.getEntityManager();
        if (tx == null)
            tx = em.getTransaction();
        tx.begin();
        try {
            excute();
            tx.commit();
            return SUCCESS;
        } catch (Exception e) {
            tx.rollback();
            log.error(CodeActionUtils.class, e);
            return ERROR;
        } finally {
            CodeEntityManagerHelper.closeEntityManager();
        }
    }

    public String nSyTemplate() {
        if (em == null || !em.isOpen())
            em = CodeEntityManagerHelper.getEntityManager();
        try {
            excute();
            return SUCCESS;
        } catch (Exception e) {
            log.error(CodeActionUtils.class, e);
            return ERROR;
        } finally {
            CodeEntityManagerHelper.closeEntityManager();
        }
    }

    protected abstract void excute() throws Exception;
}