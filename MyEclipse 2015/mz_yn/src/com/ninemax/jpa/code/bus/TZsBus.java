package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TZsDAO;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateUtil;
import com.ninemax.jpa.util.clsStringTool;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-23
 * Time: 上午10:04
 */
public class TZsBus {

    private TZsDAO dao = new TZsDAO();

    public List<TZs> findByZslsh(String zslsh) {
        return dao.findByProperty("zslsh", zslsh);
    }

    /**
     * zx 证书挂失合法性判断
     *
     * @param jgdm
     * @return
     */
    public String checkCert(String jgdm, String source) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jgdm", jgdm);
        if ("yygs".equals(source)) {
            map.put("flag", "1");
        } else {
            map.put("flag", "N");
        }
        List<TZs> tzs = dao.findByPropertys(map);
        if ((tzs == null) || (tzs.isEmpty())) {
            if ("yygs".equals(source)) {
                return "false:机构代码(" + jgdm + ")无有效的证书,无法进行证书挂失操作!";
            }
            if ("qxgs".equals(source)) {
                return "false:机构代码(" + jgdm + ")无预约挂失的证书,无法进行取消预约挂失操作!";
            }
            if ("qrgs".equals(source)) {
                return "false:机构代码（" + jgdm + ")无预约挂失的证书,无法进行证书确认挂失操作!";
            }
        }
        return "true";
    }

    /**
     * @param jgdm
     * @return
     */
    public List<TZs> findByJgdm(String jgdm, String source) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jgdm", jgdm);
        if ("yygs".equals(source)) {
            map.put("flag", "1");
        } else {
            map.put("flag", "N");
        }
        List<TZs> tzs = dao.findByPropertys(map);
        return tzs;
    }


    public List<TZs> findBylsh(String[] lsh) {
        String _lsh = "";
        if (lsh != null && lsh.length > 0) {
            for (String l : lsh) {
                if (!clsStringTool.isEmpty(l)) {
                    _lsh += "'" + l + "',";
                }
            }
            _lsh = _lsh.substring(0, _lsh.length() - 1);
        }
        String hql = "select model from TZs model where model.flag='1' and model.lsh in (" + _lsh + ")";
        List<TZs> tzs = dao.findbyhql(hql);
        return tzs;
    }

    /**
     * 证书预约挂失
     *
     * @param djhs
     * @param jgdm
     * @param user
     * @return
     */


    public int dateCertLost(String[] djhs, String jgdm, User user) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        String strsql = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            for (int i = 0; i < djhs.length; ++i) {
                strsql = "UPDATE t_zs SET flag='N',lastdate='" + DateUtil.getCurrentDateTime() + "' where djh='" + djhs[i] + "' and jgdm='" + jgdm + "' and flag='1'";
                em.createNativeQuery(strsql).executeUpdate();
                TCzjl czjl = new TCzjl();
                czjl.setDate(DateUtil.getCurrentSystemDateTime());
                czjl.setJgdm(jgdm);
                czjl.setName(user.getUserName());
                czjl.setType("N");
                czjl.setXzqh(user.getBzjgdm());
                czjl.setMemo("证书预约挂失!");
                em.persist(czjl);
            }
            result = 1;
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }
    
    /**
     * 证书预约挂失
     *
     * @param djhs
     * @param jgdm
     * @param user
     * @return
     */


	public int wsLost(String jgdm, User user) {
		int result = 0;
		EntityManager em = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = null;
		String strsql = "";
		try {
			tx = em.getTransaction();
			tx.begin();

			strsql = "UPDATE t_zs SET flag='N'  where  flag='1' and jgdm='"+jgdm+"'";
			em.createNativeQuery(strsql).executeUpdate();

			result = 1;
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			result = 0;
		} finally {
			EntityManagerHelper.closeEntityManager();
		}
		return result;
	}

    /**
     * 证书取消预约挂失
     *
     * @param djhs
     * @param jgdm
     * @param user
     * @return
     */
    public int cancelCertLost(String[] djhs, String jgdm, User user) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        String strsql = "";
        try {
            tx = em.getTransaction();
            tx.begin();
            for (String djh : djhs) {
                strsql = "UPDATE t_zs SET flag='1',lastdate='" + DateUtil.getCurrentDateTime() + "' where djh='" + djh + "' and jgdm='" + jgdm + "' and flag='N'";
                em.createNativeQuery(strsql).executeUpdate();
                TCzjl czjl = new TCzjl();
                czjl.setDate(DateUtil.getCurrentSystemDateTime());
                czjl.setJgdm(jgdm);
                czjl.setName(user.getUserName());
                czjl.setType("Y");
                czjl.setXzqh(user.getBzjgdm());
                czjl.setMemo("证书取消预约挂失!");
                em.persist(czjl);
            }
            result = 1;
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }

    /**
     * 证书确认挂失
     *
     * @param djhs
     * @param jgdm
     * @param user
     * @param gsyj
     * @param gsreason
     * @return
     */
    public int confirmCertLost(String[] djhs, String jgdm, User user, String gsyj, String gsreason, String zfrq) {
        int result = 0;
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityTransaction tx = null;
        String strsql = "";
        String strSysDate = DateUtil.getCurrentDateTime();
        try {
            tx = em.getTransaction();
            tx.begin();
            for (String djh : djhs) {
                strsql = "INSERT INTO t_zsds(jgdm,jgmc,djh,djrq,st,czy,bgrq,gsreason,gsyj) ";
                strsql = strsql + "SELECT jgdm,jgmc,djh,fzsj,'1','" + user.getUserName() + "','" + strSysDate + "','" + gsreason + "','" + gsyj + "' FROM t_zs ";
                strsql = strsql + " where djh='" + djh + "' and jgdm='" + jgdm + "' and flag='N'";
                em.createNativeQuery(strsql).executeUpdate();
                strsql = "INSERT INTO t_black(xzqh,jgdm,jglx,jgmc,jgdz,bzrq,zfrq,yxdate,djh,lsh,type,czrq,czr,zsbh)";
                strsql = strsql + "SELECT bzjgdm,jgdm,jglx,jgmc,jgdz,fzsj,'" + zfrq + "',yxq,djh,zslsh,'1','" + strSysDate + "','" + user.getUserName() + "',zsbh FROM t_zs";
                strsql = strsql + " where djh='" + djh + "' and jgdm='" + jgdm + "' and flag='N'";
                em.createNativeQuery(strsql).executeUpdate();

                strsql = "UPDATE t_zs SET flag='5',lastdate='" + DateUtil.getCurrentDateTime() + "' where djh='" + djh + "' and jgdm='" + jgdm + "'";// and flag='N'";
                em.createNativeQuery(strsql).executeUpdate();
                TCzjl czjl = new TCzjl();
                czjl.setDate(DateUtil.getCurrentSystemDateTime());
                czjl.setJgdm(jgdm);
                czjl.setName(user.getUserName());
                czjl.setType("5");
                czjl.setXzqh(user.getBzjgdm());
                czjl.setMemo("证书确认挂失!");
                em.persist(czjl);
                strsql = "update t_jgdm set dybz='3' where jgdm='" + jgdm + "'";
                em.createNativeQuery(strsql).executeUpdate();
            }
            List<TSmrw> rws = em.createQuery("select model from TSmrw model where model.type=?1 and model.createTime >= ?2 and model.jgdm=?3 ")
                    .setParameter(1, SmTaskType.挂失.getValue().toString())
                    .setParameter(2, DateUtil.strToDate(DateUtil.dateToStr(new Date())))
                    .setParameter(3, jgdm).getResultList();
            if (rws.isEmpty() || rws.size() <= 0) {
                TSmrw task = new TSmrw();
                BeanUtilsEx.copyProperties(task, em.find(TJgdm.class, jgdm));
                task.setId(null);
                task.setCreateTime(new Date());
                task.setStatus(false);
                task.setType(SmTaskType.挂失.getValue().toString());
                task.setCzr(user.getUserName());
                em.persist(task);
            }
            result = 1;
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            result = 0;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return result;
    }
}
