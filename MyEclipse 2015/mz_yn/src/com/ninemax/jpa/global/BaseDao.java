package com.ninemax.jpa.global;

import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.*;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * IUser: ninemax
 * Date: 2011-01-11
 * Time: 10:40:16
 */
public abstract class BaseDao {

    private static Logger log = Logger.getLogger(BaseDao.class);

    protected String generatePrimaryKey() {
        return java.util.UUID.randomUUID().toString();
    }

    public <T> boolean delete(Class<T> entityClass, Object entityid) {
        return delete(entityClass, new Object[]{entityid});
    }

    public boolean delete(String jql) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx =  em.getTransaction();
        try {
            tx.begin();
            int n = em.createQuery(jql).executeUpdate();
            if (n == 0) flag = false;
            tx.commit();
        } catch (Exception e) {
            log.error(BaseAction.class, e);
            tx.rollback();
            flag = false;


        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    public <T> boolean delete(Class<T> entityClass, Object[] entityids) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        boolean flag = true;
        try {
            tx.begin();
            for (Object id : entityids) {
                em.remove(em.getReference(entityClass, id));
            }
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error(BaseAction.class, e);
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }


    public <T> T find(Class<T> entityClass, Object entityId) {

        EntityManager em = EntityManagerHelper.getEntityManager();

        try {
            return em.find(entityClass, entityId);
        } catch (RuntimeException e) {
            throw e;
        } finally {

            EntityManagerHelper.closeEntityManager();
        }


    }

    public boolean save(Object entity) throws ConstraintViolationException{
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error(BaseAction.class, e);
            return false;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return true;
    }


    @SuppressWarnings("unchecked")
    public List find(String jql) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            Query query = em.createQuery(jql);
            return query.getResultList();
        } catch (Exception e) {
            log.error(BaseAction.class, e);
            return null;
        } finally {

            EntityManagerHelper.closeEntityManager();
        }


    }

    /*
    @SuppressWarnings("unchecked")
	public List findByHibernateCache(String jql) {
        	EntityManager em = EntityManagerHelper.getEntityManager();
        	Query query = em.createQuery(jql);
			org.hibernate.ejb.QueryImpl hs = null;
			org.hibernate.Query hbQuery = null;
			List list = new ArrayList();
			if(query instanceof org.hibernate.ejb.QueryImpl) {
			    hs = (org.hibernate.ejb.QueryImpl)query;
			    hbQuery = hs.getHibernateQuery();
			    hbQuery.setCacheable(true);
			    list = hbQuery.list();
			} else {
			    list = query.getResultList();
			}
        return list;
    }
    */


    public <T> long getCount(Class<T> entityClass) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            return (Long) em.createQuery("select count(" + getCountField(entityClass) + ") from " + getEntityName(entityClass) + " o").getSingleResult();
        } catch (Exception e) {
            log.error(BaseDao.class,e);
            return 0;
        } finally {

            EntityManagerHelper.closeEntityManager();
        }


    }

    public boolean update(Object entity) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(entity);
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error(BaseDao.class,e);
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    public boolean delete(Object entity) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(entity);
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error(BaseDao.class,e);
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

    public boolean deleteById(Class clazz, Object id) {
        boolean flag = true;
        EntityManager em = EntityManagerHelper.getEntityManager();
        em.clear();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Object o = em.getReference(clazz, id);
            em.remove(o);
            tx.commit();
        } catch (Exception e) {
            flag = false;
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error(BaseDao.class,e);
            return flag;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }


    protected void setQueryParams(Query query, Object[] queryParams) {
        if (queryParams != null && queryParams.length > 0) {
            for (int i = 0; i < queryParams.length; i++) {
                query.setParameter(i + 1, queryParams[i]);
            }
        }
    }

    protected void setQueryParams(Query query, List<Object> queryParams) {
        if (queryParams != null) {
            for (int i = 0; i < queryParams.size(); i++) {
                query.setParameter(i + 1, queryParams.get(i));
            }
        }
    }

    /**
     * @param orderby
     * @return
     */
    protected String buildOrderby(LinkedHashMap<String, String> orderby) {
        StringBuffer orderbyql = new StringBuffer("");
        if (orderby != null && orderby.size() > 0) {
            orderbyql.append(" order by ");
            for (String key : orderby.keySet()) {
                orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
            }
            orderbyql.deleteCharAt(orderbyql.length() - 1);
        }
        return orderbyql.toString();
    }

    /**
     * @param <T>
     * @param entityClass
     * @return
     */
    protected <T> String getEntityName(Class<T> entityClass) {
        String entityname = entityClass.getSimpleName();
        Entity entity = entityClass.getAnnotation(Entity.class);
        if (entity.name() != null && !"".equals(entity.name())) {
            entityname = entity.name();
        }
        return entityname;
    }

    protected <T> String getCountField(Class<T> clazz) {
        String out = "o";
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            for (PropertyDescriptor propertydesc : propertyDescriptors) {
                Method method = propertydesc.getReadMethod();
                if (method != null && method.isAnnotationPresent(EmbeddedId.class)) {
                    PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
                    out = "o." + propertydesc.getName() + "." + (!ps[1].getName().equals("class") ? ps[1].getName() : ps[0].getName());
                    break;
                }
            }
        } catch (Exception e) {
            log.error(BaseDao.class,e);
        }
        return out;
    }

    public int executeSql(String sql) {
        log.info("execute sql");
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            int a = em.createNativeQuery(sql).executeUpdate();
            return a;
        } catch (RuntimeException re) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            log.error("find all failed", re);
            throw re;
        } finally {
            log.info("closing all ");
            EntityManagerHelper.closeEntityManager();
        }
    }

}
