package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jdbc.to.system.clsProvinceTO;
import com.ninemax.jpa.util.clsStringTool;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class clsProvinceDAO {

    private static Logger log = Logger.getLogger(clsProvinceDAO.class);

    public boolean AddProvince(clsProvinceTO provinceTO) {

        DataAccess dataAccessObject = new DataAccess();
        boolean reuslt = false;

        String sql = "insert into sc_xzqh ("
                + "xzqh_id,"
                + "xzqh_name) values("
                + "'" + provinceTO.getId() + "',"
                + "'" + provinceTO.getProvinceName() + "')";

        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return reuslt;
    }


    public boolean ModifyProvince(clsProvinceTO provinceTO) {

        DataAccess dataAccessObject = new DataAccess();
        boolean reuslt = false;

        String sql = "update sc_xzqh set "

                + "xzqh_name='" + provinceTO.getProvinceName() + "' where xzqh_id='" + provinceTO.getId() + "'";

        try {
            if (dataAccessObject.execute(sql) == 1) {
                reuslt = true;
            } else {
                reuslt = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }

        return reuslt;
    }

    public boolean DeleteProvince(String id) {
        boolean result = false;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "delete from  sc_xzqh  where xzqh_id='" + id + "'";
        try {
            if (dataAccessObject.execute(sql) == 1) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return result;
    }

    public clsProvinceTO FindProvinceById(String id) {

        DataAccess dataAccessObject = new DataAccess();
        clsProvinceTO provinceTO = null;
        String sql = "select * from sc_xzqh where xzqh_id='" + id + "' ";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                provinceTO = SetProvince(crs);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinceTO;
    }


    public clsProvinceTO FindProvinceByName(String name) {

        DataAccess dataAccessObject = new DataAccess();
        clsProvinceTO provinceTO = null;
        String sql = "select * from sc_xzqh where xzqh_name='" + name.trim() + "' ";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                provinceTO = SetProvince(crs);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinceTO;
    }

    /**
     * 列出行政区划列表信息
     *
     * @return
     */
    public ArrayList ListAll() {
        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        clsProvinceTO provinceTO = null;
        String sql = "select * from sc_xzqh order by dm asc ";
        //String sql = "select * from sc_xzqh  order by xzqh_id asc ";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                provinceTO = new clsProvinceTO();
                provinceTO.setId(crs.getString("dm"));
                provinceTO.setProvinceName(crs.getString("mc"));
                provinces.add(provinceTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinces;
    }

    /**
     * 列出一级行政区划列表信息
     *
     * @return
     */
    public ArrayList ListFirstAll() {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        String sql = "select * from sc_xzqh where substring(xzqh_id,3,4)='0000' order by xzqh_id asc ";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                clsProvinceTO provinceTO = SetProvince(crs);
                provinces.add(provinceTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinces;
    }

    /**
     * 列出二级行政区划列表信息
     *
     * @return
     */
    public ArrayList ListTwoAll(String first_id) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        String _first_id = "";
        String sql = "";
        clsProvinceTO provinceTO = null;
        if (!clsStringTool.isEmpty(first_id)) {
            //后面是4个0说明是省直辖市级办证点;否则是市级相当于省级的办证点
            if ("0000".equals(first_id.trim().substring(2))) {
                _first_id = first_id.substring(0, 2);
                //sql = "select b.dm,b.mc FROM SC_bzjgdm b where substring(dm,1,4)+'00' not in (select dm from sc_center where dm not like '%0000') and  dm like '"+_first_id+"%'";
                //TODO 将机构表更改为准入区县
                sql = "select b.bzjg_id as xzqh,b.bzjg_name as mc  FROM sc_bzjgdm b";
            } else {
                _first_id = first_id.substring(0, 4);
                sql = "select xzqh,mc from t_zrxzqh where xzqh like '" + _first_id + "%' ";
            }
            log.info("sql====" + sql);
        }
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                provinceTO = new clsProvinceTO();
                provinceTO.setId(crs.getString("xzqh"));
                provinceTO.setProvinceName(crs.getString("mc"));
                provinces.add(provinceTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinces;
    }

    public ArrayList listQxAll(String first_id) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        String _first_id = "";
        String sql = "";
        clsProvinceTO provinceTO = null;
        if (!clsStringTool.isEmpty(first_id)) {
            //后面是4个0说明是省直辖市级办证点;否则是市级相当于省级的办证点
            if ("0000".equals(first_id.trim().substring(2))) {
                _first_id = first_id.substring(0, 2);
                //TODO 将机构表更改为准入区县
                sql = "select b.xzqh,b.mc FROM t_zrxzqh b where  xzqh like '" + _first_id + "%'";
            } else {
                _first_id = first_id.substring(0, 4);
                sql = "select xzqh,mc from t_zrxzqh where  xzqh like '" + _first_id + "%' ";
            }
            log.info("sql====" + sql);
        }
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                provinceTO = new clsProvinceTO();
                provinceTO.setId(crs.getString("xzqh"));
                provinceTO.setProvinceName(crs.getString("mc"));
                provinces.add(provinceTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinces;
    }

    public ArrayList listSAll(String first_id) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        String _first_id = "";
        String sql = "";
        clsProvinceTO provinceTO = null;
        if (!clsStringTool.isEmpty(first_id)) {
            //后面是4个0说明是省直辖市级办证点;否则是市级相当于省级的办证点
            //TODO 将机构表更改为准入区县
            if ("0000".equals(first_id.trim().substring(2))) {
                _first_id = first_id.substring(0, 2);
                sql = "select b.xzqh,b.mc FROM t_zrxzqh b where substring(xzqh,3,2)<>'00' and substring(xzqh,5,2)='00' and xzqh like '" + _first_id + "%'";
            } else {
                _first_id = first_id.substring(0, 4);
                sql = "select xzqh,mc from t_zrxzqh where substring(xzqh,3,2)<>'00' and substring(xzqh,5,2)='00' and xzqh like '" + _first_id + "%' ";
            }
            log.info("sql====" + sql);
        }
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                provinceTO = new clsProvinceTO();
                provinceTO.setId(crs.getString("xzqh"));
                provinceTO.setProvinceName(crs.getString("mc"));
                provinces.add(provinceTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinces;
    }

    /**
     * 列出三级行政区划列表信息
     *
     * @return
     */
    public ArrayList ListThreeAll(String two_id) {

        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        String _two_id = "";
        if (!clsStringTool.isEmpty(two_id)) {
            _two_id = two_id.substring(0, 4);
        }
        String sql = "select * from sc_xzqh where substring(xzqh_id,1,4)='" + _two_id + "' and substring(xzqh_id,5,2)<>'00' and substring(xzqh_id,3,4)<>'0000' order by xzqh_id asc ";

        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                clsProvinceTO provinceTO = SetProvince(crs);
                provinces.add(provinceTO);
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinces;
    }


    public boolean IsExistTwo(String first_id) {
        boolean result = false;
        DataAccess dataAccessObject = new DataAccess();
        ArrayList provinces = new ArrayList();
        String _first_id = "";
        if (!clsStringTool.isEmpty(first_id)) {
            _first_id = first_id.substring(0, 2);
        }
        String sql = "select * from sc_xzqh where substring(xzqh_id,1,2)='" + _first_id + "' and substring(xzqh_id,5,2)='00' and substring(xzqh_id,3,4)<>'0000' order by xzqh_id asc ";

        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.size() > 0) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return result;
    }

    private static clsProvinceTO SetProvince(CachedRowSet crs) throws SQLException {
        clsProvinceTO provinceTO = new clsProvinceTO();
        provinceTO.setId(crs.getString("mxzqh"));
        provinceTO.setProvinceName(crs.getString("mc"));

        return provinceTO;

    }

    public HashMap<String, String> putAll() {
        DataAccess dataAccessObject = new DataAccess();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String sql = "select dm,mc from SC_bzjgdm order by dm asc";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            while (crs.next()) {
                hashMap.put(crs.getString("dm").trim(), crs.getString("mc").trim());
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return hashMap;
    }


    public boolean isSjFlag(String bzjgdm) {
        boolean flag = false;
        DataAccess dataAccessObject = new DataAccess();
        String sql = "select * from sc_center where dm = '" + bzjgdm + "'";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return flag;
    }

    public String getProvinceName(String bzjgdm) {
        String provinceName = "";
        DataAccess dataAccessObject = new DataAccess();
        String sql = "select bzjg_name as mc from sc_bzjgdm where bzjg_id= '" + bzjgdm + "'";
        try {
            CachedRowSet crs = dataAccessObject.query(sql);
            if (crs.next()) {
                provinceName = crs.getString("mc");
            }
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
        return provinceName;
    }
}
