package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TZsds;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-6-21
 * Time: ÏÂÎç1:46
 */
public class TZsdsDAO  {
    private static Logger log = Logger
            .getLogger(TZsDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public TZsds findById(String id) {
        log.info("finding TZsds instance with id: " + id);
        try {
            TZsds instance = getEntityManager().find(TZsds.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        }finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    protected void setQueryParams(Query query, List<Object> queryParams) {
        if (queryParams != null) {
            for (int i = 0; i < queryParams.size(); i++) {
                query.setParameter(i + 1, queryParams.get(i));
            }
        }
    }

    public List<TZsds> listTZsds(String jql, Integer pageno, Integer rowNumsView, clsPageComponent pageComponent, List params) throws Exception {
        log.info("finding TJgdmSave instances");
		try {
            if (pageno == 0) {
                pageno = 1;
            }
			Query query = getEntityManager().createQuery(jql);
			query.setFirstResult(rowNumsView*(pageno-1));
			query.setMaxResults(rowNumsView);
			setQueryParams(query,params);
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
}
