package com.ninemax.jpa.code.bus;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.dao.MakeVectorData;
import com.ninemax.jpa.code.dao.AuditingDAO;
import com.ninemax.jpa.code.model.*;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.util.BeanUtilsEx;
import com.ninemax.jpa.util.DateProcess;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;
import flex.messaging.io.ArrayList;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * @author Liuzy
 */
public class AuditingBus {
    private static Logger log = Logger.getLogger(AuditingBus.class);
    private AuditingDAO dao;

    public AuditingBus() {
        dao = new AuditingDAO();
    }

    public List<SmUser> findUserPageList(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages) {
        List<SmUser> lists = null;
        int flag = 2;
        try {
            String jql = "from SmUser user where user.usertype='1' and user.userstatus='0'";
            List<String> pms = new ArrayList();

            lists = dao.findPageListbyjql(jql, pageno, rowNumsView, pages, pms, flag);
        } catch (Exception e) {
            log.error(AuditingBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return lists;
    }

    public SmUser findUserById(long id) {
        int flag = 2;

        try {
            return dao.findObjectById(SmUser.class, id, flag);
        } catch (Exception e) {
            log.error(AuditingBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;
    }

    public String auditingUser(SmUser user, String ispass) {
        int flag = 2;

        String resultMsg = "审核成功！";
        try {
            if (ispass.equals("yes"))
                ispass = "1";
            else
                ispass = "2";
            String sql = "update sm_user set userstatus='" + ispass + "',memo='" + user.getMemo() + "' where id=" + user.getId();
            EntityManagerHelper.beginTransaction();
            int result = dao.executeSql(sql, flag);
            EntityManagerHelper.commit();
            if (result < 1)
                resultMsg = "审核失败！";
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            log.error(AuditingBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return resultMsg;
    }

    public Boolean isHasSps(String bzjgdm) {
        TZrxzqhBus zrxzqhBus = new TZrxzqhBus();
        User user =new User();
        user.setUserName("");
        user.setBzjgdm(bzjgdm);
        String sql = zrxzqhBus.sql("model.sendxzqh", user);
        EntityManager em = EntityManagerHelper.getEntityManager();
        try{
            List list = em.createQuery("select model from  TSp model where (model.flag='0' or model.flag='1') and  " + sql).getResultList();
            if (list == null || list.isEmpty())
                return false;
        }catch (Exception e){}finally {
            EntityManagerHelper.closeEntityManager();
        }
        return true;
    }

    public List<TSp> findSpList(Map<String, String> params, Integer pageno, Integer rowNumsView, clsPageComponent pages) {
        List<TSp> lists = null;
        int flag = 1;
        try {
            String jql = "from TSp t where t.flag='0' and t.recexzqh='" + params.get("recexzqh") + "'";
            List<String> pms = new ArrayList();

            lists = dao.findPageListbyjql(jql, pageno, rowNumsView, pages, pms, flag);
        } catch (Exception e) {
            log.error(AuditingBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return lists;
    }

    public TSpdmtemp findIndata(String jgdm) {

        try {
            String jql = "from TSpdmtemp t where t.jgdm='" + jgdm + "'";

            return dao.findObjectById(TSpdmtemp.class, jql, 1);
        } catch (Exception e) {
            log.error(AuditingBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return null;
    }

    //内网数据查找审核
    public Vector findIndata(String strJgdm, String strYwlx, String strLsh) throws Exception {
        Vector vecRet = new Vector();
        String strSql = "", strDm = "", strName = "";
        Hashtable hashData = null;
        Hashtable hashSppz = null;
        Hashtable hashSp = null;
        Vector vecJglx = null;
        Vector vecHbzl = null;
        Vector vecBsx = null;
        Vector vecData = null;
        String strZjlx = "", strZjlx1 = "", strJglx = "", strJglx1 = "", strFksl = "";
        String strJjhy = "", strJjlx = "", strZcrq = "";
        String strZycp1 = "", strZycp2 = "", strZycp3 = "", strZgrs = "";
        String strHbzl = "", strZczj = "", strWftzgb = "", strXzqh = "";
        String strPzjgdm = "", strPzjgmc = "", strBzrq = "";
        String strZfrq = "", strGk = "", strFkbz = "", strDybz = "";
        String strXzqh1 = "", strJjhy1 = "", strJjlx1 = "";
        String strZycp11 = "", strZycp21 = "", strZycp31 = "";
        String strWftzgb1 = "", strNjqx = "", strNjrq = "", strNjjhy = "";
        String strNjjhy1 = "", strNjjlx = "", strNjjlx1 = "", strGllsh = "", strYwmc = "";
        if (strJgdm == null) {
            throw new Exception("非法访问，请重新登录!");
        }

        DataAccess dataObject = new DataAccess();
        try {
//		      ProDW prodw = new ProDW();

            strSql = "select gllsh from t_sp where lsh=" + strLsh;
            CachedRowSet cs = dataObject.query(strSql);
            if (cs.next())
                strGllsh = cs.getString("gllsh");
            cs.close();

            strSql = "select ywmc,tablename,columnlabel,columnname,condition from t_sppz where ywlx='" + (strYwlx.length() < 2 ? "0" + strYwlx : strYwlx) + "'";
            CachedRowSet cs1 = dataObject.query(strSql);
            String strTableName = "";
            String strColumnLabel = "";
            String strColumnName = "";
            String strCondition = "";
            if (cs1.next()) {
                strTableName = cs1.getString("tablename");
                strColumnLabel = cs1.getString("columnlabel");
                strColumnName = cs1.getString("columnname");
                strCondition = cs1.getString("condition");
                strYwmc = cs1.getString("ywmc");
            }
            cs1.close();

            String[] strArrColumnLabel = strColumnLabel.split(",");
            String[] strArrColumnName = strColumnName.split(",");
            String strAdditionColumn = "";
            for (int i = 0; i < strArrColumnName.length; i++) {
                strAdditionColumn = strAdditionColumn + "," + strArrColumnName[i];
            }
            strSql = "select * " + strAdditionColumn + " from " + strTableName;
            strCondition = strCondition.replaceAll("keyvalue", strGllsh);
            strSql = strSql + " where " + strCondition;

            vecData = MakeVectorData.dbQuery(strSql);
            if ((vecData == null) || (vecData.size() <= 0)) {
                throw new Exception("机构代码(" + strJgdm + ")不存在!请重新输入!");
            }
            if (vecData.size() > 1) {
                throw new Exception("机构代码(" + strJgdm + ")有重码!请重新输入!");
            }

            hashData = (Hashtable) vecData.elementAt(0);
            strHbzl = (String) hashData.get("hbzl");
//		      String strHbzl1 = prodw.getItemName("币种", strHbzl);
            hashData.put("hbzl1", "币种");
            strZczj = (String) hashData.get("zczj");
            hashData.put("zczj", strZczj);
            strFkbz = (String) hashData.get("fkbz");
            hashData.put("fkbz", strFkbz);
            strJglx = (String) hashData.get("jglx");
            if (!strJglx.equals("")) {
//		        strJglx1 = prodw.getItemName("机构类型", strJglx);
                if ((strJglx1.equals("")) || (strJglx1 == null))
                    strJglx1 = "";
            }
            hashData.put("jglx1", strJglx1);
            strZjlx = (String) hashData.get("zjlx");
            if (!strZjlx.equals("")) {
//		        strZjlx1 = prodw.getItemName("证件类型", strZjlx);
                if ((strZjlx1.equals("")) || (strZjlx1 == null))
                    strZjlx1 = "";
            }
            hashData.put("zjlx1", strZjlx1);
            strJjhy = (String) hashData.get("jjhy");
            if (!strJjhy.equals("")) {
//		        strJjhy1 = prodw.getItemName("经济行业", strJjhy);
                if ((strJjhy1.equals("")) || (strJjhy1 == null)) {
                    strJjhy1 = "";
                }
            }

            hashData.put("jjhy1", strJjhy1);
            strNjjhy = (String) hashData.get("njjhy");
            if (!strNjjhy.equals("")) {
//		        strNjjhy1 = prodw.getItemName("新经济行业", strNjjhy);
                if ((strNjjhy1.equals("")) || (strNjjhy1 == null))
                    strNjjhy1 = "";
            }
            hashData.put("njjhy1", strNjjhy1);
            strJjlx = (String) hashData.get("jjlx");
            if (!strJjlx.equals("")) {
//		        strJjlx1 = prodw.getItemName("经济类型", strJjlx);
                if ((strJjlx1.equals("")) || (strJjlx1 == null))
                    strJjlx1 = "";
            }
            hashData.put("jjlx1", strJjlx1);
            strNjjlx = (String) hashData.get("njjlx");
            if (!strNjjlx.equals("")) {
//		        strNjjlx1 = prodw.getItemName("新经济类型", strNjjlx);
                if ((strNjjlx1.equals("")) || (strNjjlx1 == null))
                    strNjjlx1 = "";
            }
            hashData.put("njjlx1", strNjjlx1);
            strZcrq = (String) hashData.get("zcrq");

            if (strZcrq.length() > 10) {
                strZcrq = strZcrq.substring(0, 10);
            }

            if (strZcrq.equals("1900-01-01")) {
                strZcrq = "";
            }

            hashData.put("zcrq", strZcrq);

            strNjrq = (String) hashData.get("njrq");
            if (strNjrq.length() > 10) {
                strNjrq = strNjrq.substring(0, 10);
            }

            strZfrq = (String) hashData.get("zfrq");
            if (strZfrq.length() > 10) {
                strZfrq = strZfrq.substring(0, 10);
            }
            if (strZfrq.equals("1900-01-01")) {
                strZfrq = "";
            }
            hashData.put("zfrq", strZfrq);

            strNjqx = (String) hashData.get("njqx");
            if (strNjqx.length() > 10) {
                strNjqx = strNjqx.substring(0, 10);
            }

            if (strNjqx.equals("1900-01-01")) {
                strNjqx = "";
            }

            hashData.put("njqx", strNjqx);

            strZycp1 = (String) hashData.get("zycp1");
            if (!strZycp1.equals("")) {
//		        strZycp11 = prodw.getItemName("主要产品", strZycp1);
                if ((strZycp11.equals("")) || (strZycp11 == null))
                    strZycp11 = "";
            }
            hashData.put("zycp11", strZycp11);

            strZycp2 = (String) hashData.get("zycp2");
            if (!strZycp2.equals("")) {
//		        strZycp21 = prodw.getItemName("主要产品", strZycp2);
                if ((strZycp21.equals("")) || (strZycp21 == null))
                    strZycp21 = "";
            }
            hashData.put("zycp21", strZycp21);
            strZycp3 = (String) hashData.get("zycp3");
            if (!strZycp3.equals("")) {
//		        strZycp31 = prodw.getItemName("主要产品", strZycp3);
                if ((strZycp31.equals("")) || (strZycp31 == null))
                    strZycp31 = "";
            }
            hashData.put("zycp31", strZycp31);
            strZgrs = (String) hashData.get("zgrs");
            if (strZgrs.equals(""))
                strZgrs = "0";
            hashData.put("zgrs", strZgrs);

            strZczj = (String) hashData.get("zczj");
            if (strZczj.equals("")) {
                strZczj = "0";
            }
            hashData.put("zczj", strZczj);
            strWftzgb = (String) hashData.get("wftzgb");
            if (!strWftzgb.equals("")) {
//		        strWftzgb1 = prodw.getItemName("国别", strWftzgb);
                if ((strWftzgb1.equals("")) || (strWftzgb1 == null))
                    strWftzgb1 = "";
            }
            hashData.put("wftzgb1", strWftzgb1);
            strXzqh = (String) hashData.get("xzqh");
            if (!strXzqh.equals("")) {
//		        strXzqh1 = prodw.getItemName("行政区划1", strXzqh);
                if ((strXzqh1.equals("")) || (strXzqh1 == null))
                    strXzqh1 = "";
            }
            hashData.put("xzqh1", strXzqh1);
            strBzrq = (String) hashData.get("bzrq");
            if (strBzrq.length() > 10) {
                strBzrq = strBzrq.substring(0, 10);
            }

            if (strBzrq.equals("1900-01-01")) {
                strBzrq = "";
            }

            hashData.put("bzrq", strBzrq);
            strGk = (String) hashData.get("gk");
            if (strGk.equals("")) {
                strGk = "0";
            }
            hashData.put("gk", strGk);

            strFksl = (String) hashData.get("fksl");
            if (strFksl.equals("")) {
                strFksl = "0";
            }
            if (strFkbz.equals("0")) {
                strFksl = "0";
            }
            hashData.put("fksl", strFksl);
            String strGsfzrq = (String) hashData.get("gsfzrq");
            if (strGsfzrq.equals("1900-01-01")) {
                strGsfzrq = "";
            }
            if (strGsfzrq.length() > 10) {
                strGsfzrq = strGsfzrq.substring(0, 10);
            }
            hashData.put("gsfzrq", strGsfzrq);

            hashSp = new Hashtable();
            for (int i = 0; i < strArrColumnName.length; i++) {
                hashSp.put("label" + Integer.toString(i + 1), strArrColumnLabel[i]);
                hashSp.put("display" + Integer.toString(i + 1), (String) hashData.get(strArrColumnName[i]));
            }
            hashSp.put("ywmc", strYwmc);
            hashSp.put("ywlx", strYwlx);
            hashSp.put("lsh", strLsh);
        } catch (Exception e) {
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        vecRet.addElement(hashData);
        vecRet.addElement(hashSp);
        return vecRet;
    }

    public String findYwlxBydm(String dm) {
        try {
            String sql = "select ywmc as mc from t_sppz where ywlx='" + dm + "'";
            return clsStringTool.convertNull("" + dao.findObjectByjql(sql));
        } catch (Exception e) {
            log.error(AuditingBus.class,e);
        }
        return "";
    }

    public String auditIndata(TSp sp, String shMan) {
        String strYwmc = "", strSql = "";
        String strLsh = "" + sp.getLsh();
        String strShFlag = "" + sp.getShflag();
        String strShReason = sp.getShreason();
        if ((strLsh == null) || (strLsh.equals(""))) {
            return "非法访问，请重新登录!";
        }
        TSppz sppz = dao.find(TSppz.class, sp.getYwlx());
        try {
            TSpdmtemp spdmtemp = dao.find(TSpdmtemp.class, sp.getGllsh());
            EntityManagerHelper.beginTransaction();
            strYwmc = sppz.getYwmc();
            if (sppz.getYwlx().equals("06") || sppz.getYwlx().equals("10") || sppz.getYwlx().equals("11")) {
                TSpcf spcf = new TSpcf();
                BeanUtilsEx.copyProperties(spcf, spdmtemp);
                spcf.setCanUse(Boolean.valueOf(sp.getShflag()));
                EntityManagerHelper.getEntityManager().persist(spcf);
            }
            strSql = "update t_sp set shman='" + shMan + "',shtime='" + DateProcess.getSysTime() + "',shflag='" + strShFlag + "',shreason='" + strShReason + "',flag='1' where lsh=" + strLsh;
            dao.executeSql(strSql);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            log.error(AuditingBus.class,e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }

        return strYwmc + "的申请(流水号：" + strLsh + ")，审核完毕。";
    }

}
