package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TJglxPzjg;
import com.ninemax.jpa.code.model.TJjlx;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Liuzy
 */
public class TJglxPzjgDao extends BaseDao {
    private static Logger log = Logger
            .getLogger(TJglxPzjgDao.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<TJglxPzjg> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TJglxPzjg model order by model.jglx";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error(TJglxPzjgDao.class, re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}