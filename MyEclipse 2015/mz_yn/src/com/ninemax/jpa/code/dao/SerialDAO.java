package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-11
 * Time: ÏÂÎç7:24
 */
public class SerialDAO {

    private static Logger log = Logger
            .getLogger(SerialDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public List findbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

}
