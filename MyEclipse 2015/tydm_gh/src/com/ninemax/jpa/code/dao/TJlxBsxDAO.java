package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TJlxBsx;
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
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-9-20
 * Time: ÉÏÎç10:35
 */
public class TJlxBsxDAO extends BaseDao{

    private static Logger log = Logger
            .getLogger(TJlxBsxDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TJlxBsx findById(String id) {
        return find(TJlxBsx.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<TJlxBsx> findByProperty(String propertyName, final Object value) {
        log.info("finding findByProperty instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TJlxBsx model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

}
