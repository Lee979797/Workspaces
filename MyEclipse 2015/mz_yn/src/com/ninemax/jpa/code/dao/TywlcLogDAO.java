package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TYwlcLog;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.util.clsPageComponent;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-11-2
 * Time: ÏÂÎç5:59
 */
public class TywlcLogDAO {

    private static Logger log = Logger
            .getLogger(TywlcLogDAO.class);

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }


    public List<TYwlcLog> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from TYwlcLog model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and")) +" order by model.id desc";

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


}
