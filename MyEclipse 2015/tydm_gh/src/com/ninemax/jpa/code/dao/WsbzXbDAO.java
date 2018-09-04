package com.ninemax.jpa.code.dao;

import com.ninemax.jpa.code.model.TJgdmSave;
import com.ninemax.jpa.code.model.WXb;
import com.ninemax.jpa.code.model.vo.TjgdmVO;
import com.ninemax.jpa.global.BaseDao;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.WsbzEntityManagerHelper;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.nacao.util.DateProcess;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: liuzy
 * Date: 13-6-13
 * Time: 11:10
 */
public class WsbzXbDAO extends BaseDao {

    private static Logger log = Logger.getLogger(WsbzXbDAO.class);

    private EntityManager getEntityManager() {
        return WsbzEntityManagerHelper.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    public List<WXb> findByProperty(String propertyName, final Object value) {
        log.info("finding Tjgdm instance with property: " + propertyName
                + ", value: " + value);
        try {
            final String queryString = "select model from WXb model where model."
                    + propertyName + "= :propertyValue" + " order by model.id desc";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);
            return query.getResultList();
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            return null;
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
    }

    public List<WXb> findByPropertys(final Map<String, Object> map) {
        try {
            StringBuilder where = new StringBuilder("select model from WXb model where ");
            if (map != null && !map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    where.append(" model." + entry.getKey() + "= :" + entry.getKey() + " and");
                }
                final String queryString = where.substring(0, where.lastIndexOf("and"));

                Query query = getEntityManager().createQuery(queryString);
                for (Map.Entry entry : map.entrySet()) {
                    query.setParameter((String) entry.getKey(), entry.getValue());
                }

                return query.getResultList();
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            return null;
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
    }

    public WXb findById(Integer id) {
        try {
            return getEntityManager().find(WXb.class, id);
        } catch (RuntimeException re) {
//            rlog.error(e);
            return null;
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
    }

    public WXb findByJgdm(String jgdm) {
        try {
            List<WXb> instances = getEntityManager().createQuery("SELECT model from WXb  model where model.jgdm =:jgdm").setParameter("jgdm", jgdm).getResultList();
            if (instances != null && !instances.isEmpty())
                return instances.get(0);
            return null;
        } catch (RuntimeException re) {
//            rlog.error(e);
            return null;
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
    }

    public void queryWsyw(String sql) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tc = em.getTransaction();
        try {
            tc.begin();
            em.createNativeQuery(sql).executeUpdate();
            tc.commit();
        } catch (RuntimeException re) {
            if (tc != null) {
                tc.rollback();
            }
            log.error(WsbzXbDAO.class, re);

//            rlog.error(e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public void queryWs(String sql) {
        EntityManager em = WsbzEntityManagerHelper.getEntityManager();
        EntityTransaction tc = em.getTransaction();
        try {

            tc.begin();
            em.createNativeQuery(sql).executeUpdate();
            tc.commit();
        } catch (RuntimeException re) {
            if (tc != null) {
                tc.rollback();
            }
            log.error(WsbzXbDAO.class, re);
//            rlog.error(e);
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }
    }

    public boolean isWsyw(String sql) {
        try {
            Object oj = EntityManagerHelper.getEntityManager().createNativeQuery(sql).getSingleResult();
            int su = Integer.parseInt("" + oj);
            return su > 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public String findDjhBySql(String sql) {
        try {
            List<String> ojs = EntityManagerHelper.getEntityManager().createNativeQuery(sql).getResultList();
            if (ojs != null && !ojs.isEmpty()) {
                return ojs.get(0);
            } else {
                return null;
            }
        } catch (RuntimeException re) {
            log.error(WsbzXbDAO.class, re);
            return "";
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public boolean updateXb(WXb entity) {
        boolean flag = false;
        if (entity != null) {
            String sql = "update w_xb set w_xb_bj='" + entity.getBj() + "', w_xb_blr='" + entity.getBlr() + "', w_xb_blsj='" + DateUtil.dateToStr(entity.getBlsj()) + "', w_xb_bz='" + entity.getBz() + "', w_xb_bzjgdm='" + entity.getBzjgdm() + "', w_xb_createtime='" + DateUtil.dateToStr(entity.getCreatetime()) + "', w_xb_lxdh='" + entity.getDhhm() + "', w_xb_djh='" + entity.getDjh() + "', w_xb_email='" + entity.getEmail() + "', w_xb_fbsl1='" + entity.getFbsl() + "', w_xb_fbsl3='" + entity.getFbsl3() + "', w_xb_fddbr='" + entity.getFddbr() + "', w_xb_fbsl2='" + entity.getFksl() + "', w_xb_sfsm='" + entity.getGk() + "', w_xb_jyqx='" + DateUtil.dateToStr(entity.getGsfzrq()) + "', w_xb_hbzl='" + entity.getHbzl() + "', w_xb_jyly='" + entity.getJfly() + "', w_xb_jgdm='" + entity.getJgdm() + "', w_xb_dwdz='" + entity.getJgdz() + "', w_xb_jglx='" + entity.getJglx() + "', w_xb_jgmc='" + entity.getJgmc() + "', w_xb_jjhy='" + entity.getJjhy() + "', w_xb_jjlx='" + entity.getJjlx() + "', w_xb_jydh='" + entity.getJydh() + "', w_xb_jydz='" + entity.getJydz() + "', w_xb_jyfw='" + entity.getJyfw() + "', w_xb_jyyzbm='" + entity.getJyyb() + "', w_xb_khh='" + entity.getKhyh() + "', w_xb_khzh='" + entity.getKhzh() + "', w_xb_lb='" + entity.getLb() + "', w_xb_frdh='" + entity.getMobile() + "', w_xb_xjjhy='" + entity.getNjjhy() + "', w_xb_xjjlx='" + entity.getNjjlx() + "', w_xb_pzjg='" + entity.getPzjgdm() + "', w_xb_jbrdh='" + entity.getTbrlxfs() + "', w_xb_sfzhm='" + entity.getTbrsfzh() + "', w_xb_jbr='" + entity.getTbrxm() + "', w_xb_tjr='" + entity.getTjr() + "', w_xb_tjsj='" + DateUtil.dateToStr(entity.getTjsj()) + "', w_xb_url='" + entity.getUrl() + "', w_xb_wfgb='" + entity.getWftzgb() + "', w_xb_xgsj='" + DateUtil.dateToStr(entity.getXgsj()) + "', w_xb_xzqh='" + entity.getXzqh() + "', w_xb_yzbm='" + entity.getYzbm() + "', w_xb_pzwh='" + entity.getZch() + "', w_xb_clrq='" + DateUtil.dateToStr(entity.getZcrq()) + "', w_xb_zczj='" + entity.getZczj() + "', w_xb_zgjg='" + entity.getZgdm() + "', w_xb_zgjgmc='" + entity.getZgjgmc() + "', w_xb_zgrs='" + entity.getZgrs() + "', w_xb_zjhm='" + entity.getZjhm() + "', w_xb_zjlx='" + entity.getZjlx() + "', w_xb_zt='" + entity.getZt() + "', w_xb_cp1='" + entity.getZycp1() + "', w_xb_cp2='" + entity.getZycp2() + "', w_xb_cp3='" + entity.getZycp3() + "' where w_xb_id='" + entity.getId() + "'";
            Transaction tc = null;
            Session session = null;
            try {
                session = (Session) WsbzEntityManagerHelper.getEntityManager().getDelegate();
                tc = session.getTransaction();
                tc.begin();
                session.createSQLQuery(sql).executeUpdate();
                tc.commit();
                flag = true;
            } catch (RuntimeException re) {
                flag = false;
                if (tc != null) {
                    tc.rollback();
                }
//                rlog.error(e);
                return flag;
            } finally {
                WsbzEntityManagerHelper.closeEntityManager();
            }
        }
        /*EntityManager em = WsbzEntityManagerHelper.getEntityManager();
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
            log.error("error", e);
            log.error(e);
            return flag;
        } finally {
            WsbzEntityManagerHelper.closeEntityManager();
        }*/
        return flag;
    }
}
