package com.ninemax.jpa.system.dao;

import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.ScFields;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class ScFieldsDAO {
    private static Logger log = Logger.getLogger(ScFieldsDAO.class);
    public static final String FIELD_NAME = "fieldName";
    public static final String FIELD_CODE = "fieldCode";
    public static final String FIELDTYPE_ID = "fieldtypeId";
    public static final String FIELD_LENGTH = "fieldLength";
    public static final String FIELD_COLOR = "fieldColor";
    public static final String IS_SHOW = "isShow";
    public static final String IS_INPUT = "isInput";
    public static final String BELONG_TABLE = "belongTable";
    public static final String MEMO1 = "memo1";
    public static final String MEMO2 = "memo2";

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public ScFields findById(String id) {
        log.info("finding ScFields instance with id: " + id);
        try {
            ScFields instance = getEntityManager().find(ScFields.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("find failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ScFields> findByProperty(String propertyName,
                                         final Object value, final int... rowStartIdxAndCount) {
        log.info("finding ScFields instance with property: "
                + propertyName + ", value: " + value);
        try {
            final String queryString = "select model from ScFields model where model."
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
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<ScFields> findByFieldName(Object fieldName,
                                          int... rowStartIdxAndCount) {
        return findByProperty(FIELD_NAME, fieldName, rowStartIdxAndCount);
    }

    public List<ScFields> findByFieldCode(Object fieldCode,
                                          int... rowStartIdxAndCount) {
        return findByProperty(FIELD_CODE, fieldCode, rowStartIdxAndCount);
    }

    public List<ScFields> findByFieldtypeId(Object fieldtypeId,
                                            int... rowStartIdxAndCount) {
        return findByProperty(FIELDTYPE_ID, fieldtypeId, rowStartIdxAndCount);
    }

    public List<ScFields> findByFieldLength(Object fieldLength,
                                            int... rowStartIdxAndCount) {
        return findByProperty(FIELD_LENGTH, fieldLength, rowStartIdxAndCount);
    }

    public List<ScFields> findByFieldColor(Object fieldColor,
                                           int... rowStartIdxAndCount) {
        return findByProperty(FIELD_COLOR, fieldColor, rowStartIdxAndCount);
    }

    public List<ScFields> findByIsShow(Object isShow,
                                       int... rowStartIdxAndCount) {
        return findByProperty(IS_SHOW, isShow, rowStartIdxAndCount);
    }

    public List<ScFields> findByIsInput(Object isInput,
                                        int... rowStartIdxAndCount) {
        return findByProperty(IS_INPUT, isInput, rowStartIdxAndCount);
    }

    public List<ScFields> findByBelongTable(Object belongTable,
                                            int... rowStartIdxAndCount) {
        return findByProperty(BELONG_TABLE, belongTable, rowStartIdxAndCount);
    }

    public List<ScFields> findByBelongTable(Object belongTable,
                                            Boolean isRequired) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<ScFields> fields = new ArrayList<ScFields>();
        try {
            tx.begin();
            fields = em.createQuery("select model from ScFields model where  model.belongTable=:belongto and model.required=:required")
                    .setParameter("belongto", belongTable).setParameter("required", isRequired)
                    .getResultList();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return fields;
    }

    public List<ScFields> findByMemo1(Object memo1, int... rowStartIdxAndCount) {
        return findByProperty(MEMO1, memo1, rowStartIdxAndCount);
    }

    public List<ScFields> findByMemo2(Object memo2, int... rowStartIdxAndCount) {
        return findByProperty(MEMO2, memo2, rowStartIdxAndCount);
    }

    /**
     * Find all ScFields entities.
     *
     * @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the the
     *                            row index in the query result-set to begin collecting the
     *                            results. rowStartIdxAndCount[1] specifies the the maximum
     *                            count of results to return.
     * @return List<ScFields> all ScFields entities
     */
    @SuppressWarnings("unchecked")
    public List<ScFields> findAll(final int... rowStartIdxAndCount) {
        log.info("finding all ScFields instances");
        try {
            final String queryString = "select model from ScFields model";
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
            log.error("find all failed", re);
            throw re;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    /**
     * @return
     */
    public List<ScFields> selectAll() {

        String sql = "select model from ScFields model";
        try {
            Query query = getEntityManager().createQuery(sql);
            return query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }


    }

    //”¶”√±ÿÃÓ
    public String selectAl(String[] str, String[] str2) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            for (int i = 0; i < str.length; i++) {
                String sql = "update ScFields model set model.required =true where model.fieldId='" + str[i] + "'";
                em.createQuery(sql).executeUpdate();
            }
            for (int j = 0; j < str2.length; j++) {
                String sql2 = "update ScFields model set model.required =false where model.fieldId='" + str2[j] + "'";
                em.createQuery(sql2).executeUpdate();
            }
            tx.commit();
            return "success";
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            return "fail";
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public List<ScFields> selectByBelongTo(String tableName) {
        String sql = "from ScFields s where s.belongTable='" + tableName + "'";
        try {
            Query query = getEntityManager().createQuery(sql);
            return query.getResultList();

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
}