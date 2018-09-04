package com.ninemax.jpa.system.dao;

// default package

import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.Group;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Level;


public class GroupDAO extends BaseDao {
	private static Logger log = Logger.getLogger(GroupDAO.class);
	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	public Group findById(String id) {
		log.info("finding Group instance with id: ");
		try {
			Group instance = getEntityManager().find(Group.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("find failed",  re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}

	/**
	 * Find all Group entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Group property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Group> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Group> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
		log.info("finding Group instance with property: "
				+ propertyName + ", value: " + value);
		try {
			final String queryString = "select model from Group model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find by property name failed",
					 re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}
	/**
	 * Find all Group entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Group> all Group entities
	 */
	@SuppressWarnings("unchecked")
	public List<Group> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper
				.log("finding all Group instances", Level.INFO, null);
		try {
			final String queryString = "select model from Group model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			log.error("find all failed",re);
			throw re;
		}finally
        {
        	EntityManagerHelper.closeEntityManager();
        }
	}

}