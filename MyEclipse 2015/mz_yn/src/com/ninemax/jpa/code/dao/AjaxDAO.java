package com.ninemax.jpa.code.dao;

import com.ninemax.jdbc.dao.clsPageComponent;
import com.ninemax.jpa.global.EntityManagerHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 12-5-27
 * Time: 下午5:03
 */
public class AjaxDAO {
    private static Logger log = Logger.getLogger(AjaxDAO.class);
    public String getAjaxInfo(String method, String value, String bzjgdm) {
        List list = new ArrayList();
        JSONArray array = null;
        clsPageComponent pageComponent = new clsPageComponent();
        String sql = "";
        String orderByContent = "";
        if ("nnjjhy".equals(method)) {

            if (value != null && value.matches("\\d.*")) {
                sql = "select * from sc_jjhy where dm like '_" + value + "%' and len(dm) = 5";
            } else {
                sql = "select * from sc_jjhy where dm like '" + (value != null ? value.toUpperCase() : "") + "%' and len(dm) = 5";
            }
            orderByContent = "dm asc";
        }
        if ("nnjjlx".equals(method)) {

            sql = "select * from sc_lx where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("njjhy".equals(method)) {

            if (value != null && value.matches("\\d.*")) {
                sql = "select * from t_njjhy where dm like '_" + value + "%' and len(dm) = 5";
            } else {
                sql = "select * from t_njjhy where dm like '" + (value != null ? value.toUpperCase() : "") + "%' and len(dm) = 5";
            }
            orderByContent = "dm asc";
        }
        if ("jjhy".equals(method)) {
            if (value != null && value.matches("\\d.*")) {
                sql = "select * from t_jjhy where dm like '_" + value + "%' and len(dm) = 5";
            } else {
                sql = "select * from t_jjhy where dm like '" + (value != null ? value.toUpperCase() : "") + "%' and len(dm) = 5";
            }
            orderByContent = "dm asc";
        }
        if ("njjlx".equals(method)) {
            sql = "select * from t_njjlx where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("jjlx".equals(method)) {
            sql = "select * from t_jjlx where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("zgjg".equals(method)) {
            sql = "select * from t_zgjg where jgdm like '" + value + "%' ";
            orderByContent = "jgdm asc";
        }
        if ("wfgb".equals(method)) {
            sql = "select * from sc_gj where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("xzqh".equals(method)) {
            sql = "select * from sc_xzqh1 where substring(dm,5,2) != '00' and dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("zrxzqh".equals(method)) {
            sql = "select * from t_zrxzqh where xzqh like '" + value + "%' ";
            orderByContent = "xzqh asc";
        }
        if ("bzjgdm".equals(method)) {
            sql = "select * from SC_bzjgdm where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("sccenter".equals(method)) {
            sql = "select * from sc_center where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("pzjg".equals(method)) {
            sql = "select * from t_pzjg where pzjgdm like '" + value + "%' and bzjgdm = '" + bzjgdm + "' ";
            orderByContent = "pzjgdm asc";
        }
        if ("zycp".equals(method)) {
            sql = "select * from t_zycp where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("jglx".equals(method)) {
            sql = "select * from sc_jglx where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("hbzl".equals(method)) {
            sql = "select * from t_hb where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        try {
            pageComponent.setTotalSize(sql);
            pageComponent.setPageSize(10);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(1);
            pageComponent.setCurrentPage(1);
            pageComponent.setOrderByContent(orderByContent);
            CachedRowSet crs = pageComponent.getResultList(sql);
            //字符数组格式["A","A01","A011","A0111","A0112","A0113","A0114","A0115","A0116","A0117"]
            /*returnValue.append("[");
            while (crs.next()) {
                if("zgjg".equals(method)){
                    returnValue.append("\""+crs.getString("jgdm")+"\"");
                    returnValue.append(",");
                }else if("pzjg".equals(method)){
                    returnValue.append("\""+crs.getString("pzjgdm")+"\"");
                    returnValue.append(",");
                }else{
                    returnValue.append("\""+crs.getString("dm")+"\"");
                    returnValue.append(",");
                }
            }
            if(returnValue.indexOf(",")!=-1){
                returnValue.deleteCharAt(returnValue.lastIndexOf(","));
            }
            returnValue.append("]");*/
            while (crs.next()) {
                JSONObject jsonObj = new JSONObject();
                if ("zgjg".equals(method)) {
                    jsonObj.put("dm", crs.getString("jgdm"));
                    jsonObj.put("mc", crs.getString("zgjgmc"));
                } else if ("pzjg".equals(method)) {
                    jsonObj.put("dm", crs.getString("pzjgdm"));
                    jsonObj.put("mc", crs.getString("pzjgmc"));
                } else if ("zrxzqh".equals(method)) {
                    jsonObj.put("dm", crs.getString("xzqh"));
                    jsonObj.put("mc", crs.getString("mc"));
                } else {
                    jsonObj.put("dm", crs.getString("dm"));
                    jsonObj.put("mc", crs.getString("mc"));
                }
                list.add(jsonObj);
            }
            array = JSONArray.fromObject(list);
        } catch (Exception e) {
            log.error(AjaxDAO.class, e);

        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return array != null ? array.toString() : null;
    }

    public String getAjaxInfo(String method, String value, String filter, String bzjgdm) {
        List list = new ArrayList();
        JSONArray array = null;
        clsPageComponent pageComponent = new clsPageComponent();
        String sql = "";
        String orderByContent = "";
        if ("zrxzqh".equals(method)) {
            sql = "select xzqh as dm,mc from t_zrxzqh where xzqh like '" + value + "%'";
            orderByContent = "dm asc";
        }
        if ("bzjgdm".equals(method)) {
            sql = "select dm,mc from SC_bzjgdm where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        if ("sccenter".equals(method)) {
            sql = "select dm,mc from sc_center where dm like '" + value + "%' ";
            orderByContent = "dm asc";
        }
        try {
            pageComponent.setTotalSize(sql);
            pageComponent.setPageSize(10);
            pageComponent.setTotalPages();
            pageComponent.setLastPage();
            pageComponent.setStartIndex(1);
            pageComponent.setCurrentPage(1);
            pageComponent.setOrderByContent(orderByContent);
            CachedRowSet crs = pageComponent.getResultList(sql);
            while (crs.next()) {
                String dm = crs.getString("dm");
                if (bzjgdm.startsWith("3701")) {
                    continue;
                } else if (dm.startsWith(filter) && !dm.startsWith("3701")) {
                    continue;
                }
                String mc = crs.getString("mc");
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("dm", dm);
                jsonObj.put("mc", mc);
                list.add(jsonObj);
            }
            array = JSONArray.fromObject(list);
        } catch (Exception e) {
            log.error(AjaxDAO.class, e);
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
        return array != null ? array.toString() : null;
    }

}
