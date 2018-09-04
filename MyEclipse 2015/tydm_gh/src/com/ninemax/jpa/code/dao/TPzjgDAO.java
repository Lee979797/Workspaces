package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.PzjgPK;
import com.ninemax.jpa.code.model.TJglxPzjg;
import com.ninemax.jpa.code.model.TPzjg;
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
public class TPzjgDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TPzjgDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TPzjg findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            TPzjg instance = getEntityManager().find(TPzjg.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TPzjg> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TPzjg model where model."
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

    @SuppressWarnings("unchecked")
    public List<TPzjg> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TPzjg model order by  model.id.bzjgdm ";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TPzjg> findbyhql(String hql) {
        log.info("finding all Tsp instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }


    public List findbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TPzjg> getAll() {
        List<TPzjg> pzjgs = getEntityManager().createQuery("select model from TPzjg model order by model.id.bzjgdm ").getResultList();
        EntityManagerHelper.closeEntityManager();
        return pzjgs;
    }

    public List<TPzjg> getListPage(String mc, String bzjgdm, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from t_pzjg where 1=1 and bzjgdm = '" + bzjgdm + "' ";
        //如果条件为空，去查询t_pzjg,否则查询先查t_pzjg,在去查询t_jgdm
        if (!clsStringTool.isEmpty(mc)) {
            sql += " and pzjgdm like '%" + mc + "%' or pzjgmc like '%" + mc + "%'";
        }
        String orderByContent = "pzjgdm asc";

        try {
            pageComponent.setTotalSize(sql);
            pageComponent.setPageSize(pageSize);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(pageNo);
            pageComponent.setCurrentPage(pageNo);
            pageComponent.setOrderByContent(orderByContent);
            CachedRowSet crs = pageComponent.getResultList(sql);

            if (crs != null && crs.size() > 0) {
                while (crs.next()) {
                    TPzjg pzjg = new TPzjg();
                    PzjgPK id = new PzjgPK();
                    id.setPzjgdm(crs.getString("pzjgdm"));
                    id.setBzjgdm(crs.getString("bzjgdm"));
                    pzjg.setId(id);
                    pzjg.setPzjgmc(crs.getString("pzjgmc"));
                    array.add(pzjg);
                }
            } else if (!clsStringTool.isEmpty(mc)) {
                sql = "select jgdm,jgmc,bzjgdm from t_jgdm where jgdm like '%" + mc + "%' or jgmc like '%" + mc + "%'";
                orderByContent = "jgdm asc";
                pageComponent.setTotalSize(sql);
                pageComponent.setPageSize(pageSize);
                pageComponent.setTotalPages();
                pageComponent.setLastPage();
                pageComponent.setStartIndex(pageNo);
                pageComponent.setCurrentPage(pageNo);
                pageComponent.setOrderByContent(orderByContent);
                crs = pageComponent.getResultList(sql);
                while (crs.next()) {
                    TPzjg pzjg = new TPzjg();
                    PzjgPK id = new PzjgPK();
                    id.setPzjgdm(crs.getString("jgdm"));
                    id.setBzjgdm(crs.getString("bzjgdm"));
                    pzjg.setId(id);
                    pzjg.setPzjgmc(crs.getString("jgmc"));
                    array.add(pzjg);
                }
            }
        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }
}