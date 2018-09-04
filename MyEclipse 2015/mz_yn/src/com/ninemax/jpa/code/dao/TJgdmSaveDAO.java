package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.ScXzqhdz;
import com.ninemax.jpa.code.model.TJgdmBs;
import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.CheckEntityManagerHelper;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-6
 * Time: 下午2:52
 */
public class TJgdmSaveDAO extends BaseDao {

    private static Logger log = Logger.getLogger(TJgdmSaveDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<TJgdmSave> findByProperty(String propertyName, final Object value) {
        log.info("finding Tjgdm instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from TJgdmSave model where model."
                    + propertyName + "= :propertyValue" + " order by model.id desc";
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
     * add by ZSL 20160917 
     */
    public List findMdbyjql(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding Tjgdm instances");
        try {
            Query query = getEntityManager().createQuery(jql);
            query.setFirstResult(rowNumsView * (pageno==0?0:pageno - 1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query, params);

            int length = jql.indexOf("order");
            length = length > 0 ? length : jql.length();
            pageComponent.setTotalSize(jql.substring(0,length), params);
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

    public List<TJgdmSave> findByPropertys(final Map<String, Object> map,String jglx) {
        try {
        	StringBuilder where = null;
        	if("1".equals(jglx)){
        		
        		where = new StringBuilder("select model from TJgdmSave model where jglx='1' and");
        	}else{
        		where = new StringBuilder("select model from TJgdmSave model where");
        	}
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and")).toString();

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

    public TJgdmSave findById(Integer id) {
        try {
            TJgdmSave instance = getEntityManager().find(TJgdmSave.class, id);
            return instance;
        } catch (RuntimeException re) {
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    public String getYzbm(String xzqh) {
   	 String flag = "";
        EntityManager em = EntityManagerHelper.getEntityManager();
 
     
        try {
       
            String sql="";
          
            	sql="from ScXzqhdz model where model.dm=:dm";
          
            
            	
            
            List<ScXzqhdz> list=em.createQuery(sql).setParameter("dm", xzqh).getResultList();
            if(list.size()>0){
           	 flag=list.get(0).getYzbm()+":"+list.get(0).getDhqh();
            }
        } catch (Exception e) {
           
           e.printStackTrace();
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
  
       
   }
    public String getZgdm(String zgmc) {
      	 String flag = "";
           EntityManager em = CheckEntityManagerHelper.getEntityManager();
    
        
           try {
          
               String sql="";
             
               	sql="from TJgdmBs model where model.jgmc=:zgmc";
             
               
               	
               
               List<TJgdmBs> list=em.createQuery(sql).setParameter("zgmc", zgmc).getResultList();
               if(list.size()>0){
              	 flag=list.get(0).getJgdm();
               }
           } catch (Exception e) {
              
              e.printStackTrace();
           } finally {
               EntityManagerHelper.closeEntityManager();
           }
           return flag;
     
          
      }
    public String getZgmc(String zgdm) {
     	 String flag = "";
          EntityManager em = CheckEntityManagerHelper.getEntityManager();
   
       
          try {
         
              String sql="";
            
              	sql="from TJgdmBs model where model.jgdm=:zgdm";
            
              
              	
              
              List<TJgdmBs> list=em.createQuery(sql).setParameter("zgdm", zgdm).getResultList();
              if(list.size()>0){
             	 flag=list.get(0).getJgmc();
              }
          } catch (Exception e) {
             
             e.printStackTrace();
          } finally {
              EntityManagerHelper.closeEntityManager();
          }
          return flag;
    
         
     }
    public TJgdmSave findByJgdm(String jgdm) {
        try {
            List<TJgdmSave> instances = getEntityManager().createQuery("SELECT model from TJgdmSave  model where model.jgdm =:jgdm").setParameter("jgdm", jgdm).getResultList();
            if (instances != null && !instances.isEmpty())
                return instances.get(0);
            return null;
        } catch (RuntimeException re) {
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }


    public List<Object[]> listTjgdmSave(String sql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding TJgdmSave instances");
        try {
            if (pageno == 0) {
                pageno = 1;
            }
            Query query = getEntityManager().createNativeQuery(sql);
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query, params);
            pageComponent.setNativeTotalSize(sql.substring(sql.indexOf("from"), sql.indexOf("order")), params);
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

    public List<TjgdmVO> delListTjgdmSave(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding TJgdmSave instances");
        try {
            if (pageno == 0) {
                pageno = 1;
            }
            Query query = getEntityManager().createQuery(jql);
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query, params);
            pageComponent.setTotalSize(jql.substring(jql.indexOf("from"), jql.indexOf("order")), params);
            pageComponent.setPageSize(rowNumsView);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();

            pageComponent.setStartIndex(pageno);
            pageComponent.setCurrentPage(pageno);
            return query.getResultList();
        } catch (Exception re) {
            log.error("find all failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    /**
     * 本地查询分页
     *
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
            if (pageno == 0) {
                pageno = 1;
            }
            Query query = getEntityManager().createNativeQuery(sql);
            query.setFirstResult(rowNumsView * (pageno - 1));
            query.setMaxResults(rowNumsView);
            setQueryParams(query, params);
            pageComponent.setNativeTotalSize(sql.substring(sql.indexOf("from"), sql.indexOf("order")), params);
            pageComponent.setPageSize(rowNumsView);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();

            pageComponent.setStartIndex(pageno);
            pageComponent.setCurrentPage(pageno);
            return query.getResultList();
        } catch (Exception re) {
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}
