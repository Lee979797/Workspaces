package com.ninemax.jpa.system.dao;


import java.text.ParseException;
import java.util.Enumeration;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.log4j.Logger;

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;

public class UserDAO extends BaseDao {

    private static Logger log = Logger.getLogger(UserDAO.class);


    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }


    public User findById(Integer id) {
        log.info("finding User instance with id: " + id);
        try {
            User instance = getEntityManager().find(User.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }


    /**
     * Find all User entities with a specific property value.
     *
     * @param propertyName the name of the User property to query
     * @param value        the property value to match
     * @return List<User> found by query
     */
    @SuppressWarnings("unchecked")
    public List<User> findByProperty(String propertyName, final Object value
    ) {
        log.info("finding User instance with property: " + propertyName + ", value: " + value);
        try {
            final String queryString = "select model from User model where model."
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

    /**
     * Find all User entities.
     *
     * @return List<User> all User entities
     */
    @SuppressWarnings("unchecked")
    public List<User> findAll(
    ) {
        log.info("finding all User instances");
        try {
            final String queryString = "select model from User model";
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
    public List<User> FindByName(String user_name) {
        log.info("finding FindByName User instances");
        try {
            final String queryString = "select model from User model where model.userName='" + user_name + "'";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<User> FindByChineseName(String user_name) {
        log.info("finding FindByName User instances");
        try {
            final String queryString = "select model from User model where model.userChinesename='" + user_name + "'";
            Query query = getEntityManager().createQuery(queryString);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    /**
     * IC卡验证
     *
     * @param jgdm
     * @return
     */
    public User checkIC(String user_name) {
        try {
            final String queryString = "select model from User model where model.iccade='" + user_name + "' and model.userStatus='0'";
            List<User> userList = getEntityManager().createQuery(queryString).getResultList();
            if (!userList.isEmpty() && userList.size() > 0) ;
            return userList.get(0);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;
    }

    /**
     * CA验证
     *
     * @param name
     * @return
     */
    public User checkCA(String name, String chooseName) {

        try {
            final String queryString = "select model from User model where model.cncode='" + clsStringTool.convertNull(name) + "' and model.userStatus='0' and model.userName='" + chooseName + "'";
            List<User> userList = getEntityManager().createQuery(queryString).getResultList();
            if (!userList.isEmpty() && userList.size() > 0)
            return userList.get(0);
        } catch (RuntimeException re) {
            log.error(UserDAO.class, re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;
    }

    public boolean setLastLogin(String user_id) {
        boolean reuslt = false;
        try {
            final String queryString = "update User model set model.lastlogin='" + com.ninemax.jpa.util.DateProcess.getSysTime() + "' where model.userId=" + user_id + "";
            Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
            if (query.executeUpdate() > 0) {
                reuslt = true;
            }
        } catch (RuntimeException re) {
            log.error(UserDAO.class, re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return reuslt;
    }

    public List<User> userCAList(String name) {
        try {
            final String queryString = "select model from User model where model.cncode='" + clsStringTool.convertNull(name) + "' and model.userStatus='0' ";
            List<User> userList = getEntityManager().createQuery(queryString).getResultList();
            return userList;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;

    }

    public List<User> findPageList(String searchField, String searchValue, String orderbyColum, String orderbyMethod, int pageSize, int pageNo, clsPageComponent pageComponent,String zrxzqu) throws ParseException {
        log.info("finding  User instances-------------------------");
        if(zrxzqu.equals("")){
        	zrxzqu = "100000";
        }
        
        try {
        	String queryString = null;
        	
        	if(zrxzqu.equals("100000")){
        		queryString = "from User model where model.userStatus='0'";

        	}else{
        		queryString = "from User model where model.userStatus='0' and model.zrxzqu like '" + zrxzqu.substring(0,2) + "%'";
        	}

            if (!clsStringTool.isEmpty(searchValue)) {
                queryString += " and model." + searchField.trim() + " like '%" + searchValue + "%'";
            }
            String orderByContent = "";
            if (!clsStringTool.isEmpty(orderbyColum) && !clsStringTool.isEmpty(orderbyMethod)) {
                orderByContent += " order by model." + orderbyColum + " " + orderbyMethod;
            } else {
                orderByContent += " order by model.userId desc";
            }
            Query query = getEntityManager().createQuery(queryString + orderByContent);
            query.setFirstResult(pageSize * (pageNo - 1));
            query.setMaxResults(pageSize);
            Object params[] = {};
            setQueryParams(query, params);
            try {
                pageComponent.setTotalSize(queryString, params);
                pageComponent.setPageSize(pageSize);
                pageComponent.setTotalPages();
                pageComponent.setLastPage();
                pageComponent.setStartIndex(pageNo);
                pageComponent.setCurrentPage(pageNo);
            } catch (Exception e) {
                log.error("error", e);
                new RuntimeException(e.getMessage(), e);
            }
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public static boolean CheckPassword(String user_name, String password) {
        try {
            final String queryString = "select model from User model where model.userName='" + user_name + "' and model.userPassword='" + password + "' and model.userStatus='0' ";
            List<User> userList = EntityManagerHelper.getEntityManager().createQuery(queryString).getResultList();
            if (!userList.isEmpty())
                return true;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return false;

    }

    public static boolean checkXzqh(String user_name, String password) {
        try {
            final String queryString = "select model from User model where model.userName='" + user_name + "' and model.userPassword='" + password +
                    "' and model.userStatus='0' and (select count(xzqh) from TZrxzqh xzqh where  model.bzjgdm=xzqh.xzqh and xzqh.flag='1' )!=0 ";
            List<User> userList = EntityManagerHelper.getEntityManager().createQuery(queryString).getResultList();
            if (!userList.isEmpty())
                return true;
        } catch (RuntimeException re) {
            log.error("find all failed", re);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return false;
    }

}