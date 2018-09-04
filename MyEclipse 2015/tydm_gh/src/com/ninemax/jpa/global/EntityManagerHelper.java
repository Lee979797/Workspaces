package com.ninemax.jpa.global;
// default package

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ninemax
 */
public class EntityManagerHelper {

    private static final EntityManagerFactory emf;
    private static final Map<String, EntityManagerFactory> ems;
    private static final ThreadLocal<EntityManager> threadLocal;
    private static final Logger logger;

    static {
        ems = new HashMap<String, EntityManagerFactory>();
        emf = Persistence.createEntityManagerFactory("ninemax");
        threadLocal = new ThreadLocal<EntityManager>();
        logger = Logger.getLogger("ninemax");
        logger.setLevel(Level.ALL);
    }

    public static void init() {

    }

    public static EntityManager getEntityManager(String unit) {
        EntityManager manager = threadLocal.get();
        if (manager == null || !manager.isOpen()) {
            EntityManagerFactory emf = ems.get(unit);
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory(unit);
                ems.put(unit, Persistence.createEntityManagerFactory(unit));
            }
            if (emf == null) {
                return null;
            }
            manager = emf.createEntityManager();
            threadLocal.set(manager);
        }
        return manager;
    }
    public static void excute(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            closeEntityManager();
        }


    }

    public static void excuteWithTransaction(Runnable runnable) {
        try {
            beginTransaction();
            runnable.run();
        } catch (Exception e) {
            log("事物处理失败", Level.ALL, e);
            rollback();
        } finally {
            closeEntityManager();
        }


    }
    public static EntityManager getEntityManager() {
        EntityManager manager = threadLocal.get();
        if (manager == null || !manager.isOpen()) {
            manager = emf.createEntityManager();
            threadLocal.set(manager);
        }
        return manager;
    }


    public static void closeEntityManager() {

        EntityManager em = threadLocal.get();
        threadLocal.set(null);
        if (em != null && em.isOpen())
            em.close();
    }

    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static void commit() {
        getEntityManager().getTransaction().commit();
    }

    public static void rollback() {
        getEntityManager().getTransaction().rollback();
    }

    public static Query createQuery(String query) {
        return getEntityManager().createQuery(query);
    }

    public static void log(String info, Level level, Throwable ex) {
        logger.log(level, info, ex);
    }

}
