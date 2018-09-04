package com.ninemax.jpa.code.interceptor;

import com.ninemax.jpa.code.dao.TSmTaskDAO;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

/**
 * User: zhhuiyan
 * Date: 12-12-6
 * Time: ÏÂÎç5:06
 */
public class SmTaskInterceptor extends MethodFilterInterceptor {
    private static Logger log = Logger.getLogger(SmTaskInterceptor.class);

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        before();
        return actionInvocation.invoke();
    }

    private void before() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if (!em.isOpen())
            em = EntityManagerHelper.getEntityManager();
        if (tx == null)
            tx = em.getTransaction();
        tx.begin();
        try {

            if (tx.isActive())
                tx.commit();
        } catch (Exception e) {
            if (tx.isActive())
                tx.rollback();
            log.error(SmTaskInterceptor.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}
