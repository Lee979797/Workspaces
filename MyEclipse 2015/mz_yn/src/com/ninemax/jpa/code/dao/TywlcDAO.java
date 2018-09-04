package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TYwlc;
import com.ninemax.jpa.code.model.vo.TywlcVO;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-10-25
 * Time: 下午2:21
 */
public class TywlcDAO extends BaseDao{

    private static Logger log = Logger
            .getLogger(TYwlc.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TYwlc findById(String id) {
        log.info("finding Tsp instance with id: " + id);
        try {
            TYwlc instance = getEntityManager().find(TYwlc.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

    }

    @SuppressWarnings("unchecked")
    public List<TYwlc> findByProperty(String propertyName, final Object value) {
        log.info("finding Tsp instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TYwlc model where model."
                    + propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }   finally {
            EntityManagerHelper.closeEntityManager();
        }
    }


    public List<TYwlc> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from TYwlc model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and"));

                Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
                for (Map.Entry entry : map.entrySet()) {
                    query.setParameter((String) entry.getKey(), entry.getValue());
                }

                return query.getResultList();
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    @SuppressWarnings("unchecked")
    public List<TYwlc> findAll() {
        log.info("finding all Tsp instances");
        try {
            final String queryString = "select model from TYwlc model";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }   finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TYwlc> findbyhql(String hql) {
        log.info("finding all Tsp instances");
        try {
            Query query = getEntityManager().createQuery(hql);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }



    public Object findbysql(String sql) {
        log.info("finding all sql's data instances");
        try {
            Query query = getEntityManager().createNativeQuery(sql);
            return query.getSingleResult();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }    finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<TYwlc> listYwlc(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List<Object> params) throws Exception{
        log.info("finding listYwlc");
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

    /**
     * 本地查询分页
     * @param sql
     * @param pageno
     * @param rowNumsView
     * @param pageComponent
     * @param params
     * @return
     * @throws Exception
     */
    public List<Object[]> delNativeListTjgdmSave(String sql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding TJgdmSave instances");
		try {
            if(pageno==0){
                pageno = 1;
            }
			Query query = getEntityManager().createNativeQuery(sql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setNativeTotalSize(sql.substring(sql.indexOf("from"),sql.indexOf("order")),params);
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

    public List<TywlcVO> delListTjgdmSave(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding TJgdmSave instances");
		try {
            if(pageno==0){
                pageno = 1;
            }
			Query query = getEntityManager().createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query, params);
			pageComponent.setTotalSize(jql.substring(jql.indexOf("from"),jql.indexOf("order")),params);
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
}
