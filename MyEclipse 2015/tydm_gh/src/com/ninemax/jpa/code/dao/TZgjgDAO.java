package com.ninemax.jpa.code.dao;

// default package

import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TZgjg;
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
 * 
 * @author Liuzy
 *
 */
public class TZgjgDAO extends BaseDao {

	private static Logger log = Logger
			.getLogger(TZgjgDAO.class);

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public TZgjg findById(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TZgjg instance = getEntityManager().find(TZgjg.class, id);
            if(instance==null){
                TJgdm tJgdm = new TJgdmDAO().findById(id);
                if(tJgdm!=null){
                    instance = new TZgjg();
                    instance.setDm(tJgdm.getJgdm());
                    instance.setMc(tJgdm.getJgmc());
                }
            }
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    public TZgjg findByMc(String mc) {
        try {
        List<TZgjg>     zgjgs = getEntityManager().createQuery("select model from TZgjg model where model.mc=?1").setParameter(1,mc).getResultList();
            if(!zgjgs.isEmpty()){
              return zgjgs.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        }  finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public TZgjg findByRealId(String id) {
		log.info("finding Tsp instance with id: " + id);
		try {
            TZgjg instance = getEntityManager().find(TZgjg.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TZgjg> findByProperty(String propertyName, final Object value) {
		log.info("finding Tsp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from TZgjg model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	@SuppressWarnings("unchecked")
	public List<TZgjg> findAll() {
		log.info("finding all Tsp instances");
		try {
			final String queryString = "select model from TZgjg model";
			Query query = getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}  finally {
            EntityManagerHelper.closeEntityManager();
        }
	}

	public List<TZgjg> findbyhql(String hql) {
		log.info("finding all Tsp instances");
		try {
			Query query = getEntityManager().createQuery(hql);
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}    finally {
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
		}   finally {
            EntityManagerHelper.closeEntityManager();
        }
	}
    public List<TZgjg> getListPage(String userInput, int pageSize, int pageNo, com.ninemax.jdbc.dao.clsPageComponent pageComponent) {
        List array = new ArrayList();
        String sql = "select * from t_zgjg where 1=1 ";
        if(!clsStringTool.isEmpty(userInput)){
            sql += " and jgdm like '%"+userInput+"%' or zgjgmc like '%"+userInput+"%'";
        }
        String orderByContent = "jgdm asc";

        try {
            pageComponent.setTotalSize(sql);
            pageComponent.setPageSize(pageSize);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(pageNo);
            pageComponent.setCurrentPage(pageNo);
            pageComponent.setOrderByContent(orderByContent);
            CachedRowSet crs = pageComponent.getResultList(sql);

            if(crs!=null&&crs.size()>0){
                while (crs.next()) {
                    TZgjg zgjg = new TZgjg();
                    zgjg.setDm(crs.getString("jgdm"));
                    zgjg.setMc(crs.getString("zgjgmc"));
                    array.add(zgjg);
                }
            }else if(!clsStringTool.isEmpty(userInput)){
                sql = "select jgdm,jgmc from t_jgdm where jgdm like '%" + userInput + "%' or jgmc like '%" + userInput + "%'";
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
                    TZgjg zgjg = new TZgjg();
                    zgjg.setDm(crs.getString("jgdm"));
                    zgjg.setMc(crs.getString("jgmc"));
                    array.add(zgjg);
                }
            }

        } catch (Exception e) {
            log.error(e);
        }

        return array;
    }
}