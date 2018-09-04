package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.ScPageKind;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Liuzy
 */
public class ScPageKindDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(ScPageKindDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public ScPageKind findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            ScPageKind instance = getEntityManager().find(ScPageKind.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

    }

    @SuppressWarnings("unchecked")
    public List<ScPageKind> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from ScPageKind model order by model.pagekindId";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, ScPageKind> getMaps() {
        List<ScPageKind> kinds = findAll();
        Map<String, ScPageKind> kindMaps = new HashMap<String, ScPageKind>();
        for (ScPageKind kind : kinds) {
            kindMaps.put(kind.getPagekindId(), kind);
        }
        return kindMaps;
    }
}