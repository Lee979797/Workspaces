package com.ninemax.jpa.code.bus;

import com.ninemax.jpa.code.dao.TJgdmDAO;
import com.ninemax.jpa.code.dao.TKqnjqhDAO;
import com.ninemax.jpa.code.model.TJgdm;
import com.ninemax.jpa.code.model.TKqnjqh;
import com.ninemax.jpa.code.model.TSystem;
import com.ninemax.jpa.code.model.TZrxzqh;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.global.InitSysParams;
import com.ninemax.jpa.util.DateUtil;

import javax.persistence.EntityManager;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-18
 * Time: 下午1:33
 */
public class TKqnjqhBus {

    private TKqnjqhDAO kqnjDao = new TKqnjqhDAO();

    public String checkYear(String jgdm, String bzjgdm) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        try {
            Map<String, Object> props = new HashMap<String, Object>();
            props.put("sfkq", "1");
            props.put("xzqh", bzjgdm);
            List<TKqnjqh> kqnjqhs = kqnjDao.findByPropertys(props);
            String sql = "select model from TJgdm model where ";
            if (kqnjqhs == null || kqnjqhs.isEmpty()) {
                sql += sql(bzjgdm) + " and model.jgdm='" + jgdm + "' and model.dybz='1'";
            } else {
                sql += sql(bzjgdm.substring(0, bzjgdm.length() - 2) + "00") + " and model.jgdm='" + jgdm + "' and model.dybz='1'";
            }
            TJgdm dm = em.find(TJgdm.class, jgdm);
            if (dm == null) {
                return "false:该机构代码(" + jgdm + ")不存在,请确认输入正确，是否已办理迁址或注销！";
            }
            List<TKqnjqh> njqhs = em.createQuery("select model from TKqnjqh model where model.xzqh like ?1 ")
                    .setParameter(1, bzjgdm.substring(0, 4) + "%")
                    .getResultList();
            if (!(njqhs != null &&
                    !njqhs.isEmpty() &&
                    "1".equals(njqhs.get(0).getSfkq()) &&
                    dm.getBzjgdm().substring(0, 4).equals(bzjgdm.substring(0, 4)))) {
                if (!getXzqhs(bzjgdm).contains(dm.getBzjgdm())) {
                    return "false:机构代码(" + jgdm + ")不属于本办证机构，请到（" + InitSysParams.zrxzqhMap.get(dm.getBzjgdm()) + ")处办理！";
                }
            }

            if (!"1".equals(dm.getDybz())) {
                return "false:请先打印代码（" + jgdm + "）证书!";
            }

            if ((dm.getNjrq() != null && dm.getNjrq().compareTo(new Date()) > 0) || dm.getNjqx() == null ||
                    dm.getNjqx().compareTo(DateUtil.dayAfter(new Date(), ((TSystem) em.createQuery("select model from TSystem model").getSingleResult()).getNjqx())) > 0)
                return "false:机构代码(" + jgdm + ")不在年检期限内，不能进行年检操作！";
            if (dm.getZfrq().compareTo(new Date()) < 0) {
                return "false:机构代码(" + jgdm + ")已经超过作废期限，不能再办理年检，请先去办理变更或者换证！";
            }
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return "true";

    }

    private Boolean isMain(String bzjgdm) {
        try {
            TZrxzqh zrxzqh = EntityManagerHelper.getEntityManager().find(TZrxzqh.class, bzjgdm);
            return zrxzqh.getBzjgflag() == null ? true : zrxzqh.getBzjgflag();
        } catch (Exception e) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;
    }

    public List<String> getXzqhs(String bzjgdm) {
        List<String> bzjgdms = new ArrayList<String>();
        try {
            List<TZrxzqh> xzqhs = EntityManagerHelper.getEntityManager().createQuery("SELECT model from TZrxzqh model where  model.csxzqh=:bzjgdm").setParameter("bzjgdm", bzjgdm).getResultList();
            bzjgdms.add(bzjgdm);
            for (TZrxzqh zrxzqh : xzqhs) {
                bzjgdms.add(zrxzqh.getXzqh());
            }
        } catch (Exception ignored) {
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return bzjgdms;
    }

    public String sql(String bzjgdm) {
        String sql = "";
        List<String> xzqhs = getXzqhs(bzjgdm);
        if (isMain(bzjgdm) || xzqhs == null || xzqhs.isEmpty() || xzqhs.size() <= 1) {
            sql = " model.bzjgdm='" + bzjgdm + "' ";
        } else {
            sql = " model.bzjgdm in ('";
            for (String bzjg : xzqhs) {
                sql += bzjg + "','";
            }
            sql = sql.substring(0, sql.lastIndexOf(",'"));
            sql += ") ";
        }
        return sql;
    }

}
