package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TCzjl;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * @author Liuzy
 */
public class TCzjlDAO extends BaseDao {

    private static Logger log = Logger
            .getLogger(TCzjlDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TCzjl findById(String id) {
        log.info("finding Tczjl instance with id: " + id);
        try {
            TCzjl instance = getEntityManager().find(TCzjl.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<TCzjl> findByProperty(String propertyName, final Object value) {
        log.info("finding Tczjl instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TCzjl model where model."
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
    public List<TCzjl> findAll() {
        log.info("finding all Tczjl instances");
        try {
            final String queryString = "select model from TCzjl model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TCzjl> findbyhql(String hql) {
        log.info("finding all Tczjl instances");
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

    public List<TCzjl> findByDmWithDateNotInType(String jgdm, Date date, String type) {
       /* EntityManager em = EntityManagerHelper.getEntityManager();
        em.getTransaction().begin();
        String hql = "select model from TCzjl model  where model.jgdm=:jgdm and model.date>=:sdate and model.date<:edate and model.type<>:type";
     */   List<TCzjl> czjls = null;
        /*try {
            czjls = em.createQuery(hql).setParameter("jgdm", jgdm)
                    .setParameter("sdate", getAboutDate(date, false))
                    .setParameter("edate", getAboutDate(date, true))
                    .setParameter("type", type).getResultList();
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log.error("findByDmWithDateNotInType failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }*/
        return czjls;
    }

    public Integer findCountByDmWithDateType(String jgdm, Date date, String type) {


        /*EntityManager em = EntityManagerHelper.getEntityManager();
        em.getTransaction().begin();
        String hql = "select  count (model.id) from TCzjl model where model.jgdm=:jgdm and model.date>=:sdate and model.date<:edate and model.type=:type";

        Integer count = 0;
        try {
            Long countL = (Long) em.createQuery(hql).setParameter("jgdm", jgdm)
                    .setParameter("sdate", getAboutDate(date, false))
                    .setParameter("edate", getAboutDate(date, true))
                    .setParameter("type", type).getResultList().get(0);
            count = countL.intValue();
            em.getTransaction().commit();
        } catch (RuntimeException re) {
            log.error("findCountByDmWithDateType failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return count;*/
    	return 0;
    }

    private Date getAboutDate(Date date, boolean b) {
        if (b) {
            date = DateUtil.strToDatehhmmss(DateUtil.dateToStr(date) + " 24:00:00");
        } else {
            date = DateUtil.strToDate(DateUtil.dateToStr(date));
        }
        return date;
    }

    public List<TCzjl> listOperRecords(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) throws Exception{
		try {
            if(pageno==0){
                pageno = 1;
            }
			Query query = getEntityManager().createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setTotalSize(jql.substring(0,jql.indexOf("order")),params);
			pageComponent.setPageSize(rowNumsView);
			pageComponent.setTotalPages();
			pageComponent.setLastPage();

			pageComponent.setStartIndex(pageno);
			pageComponent.setCurrentPage(pageno);
			return query.getResultList();
		} catch (Exception re) {
			log.error("find all failed", re);
			throw re;
		}
    }

    public List<TCzjl> listOperRecords(String jql, List<Object> params) throws Exception{
		try {

			Query query = getEntityManager().createQuery(jql);
			setQueryParams(query, params);
			return query.getResultList();
		} catch (Exception re) {
			log.error("find all failed", re);
			throw re;
		} finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}