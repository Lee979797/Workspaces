package com.ninemax.jdbc.dao.tjgdm;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import com.ninemax.jdbc.dao.DataAccess;
/*
 * 2017-08-29 lvwei 存量库dao层
 */
public class clsTJgdmClkDAO {

	private static Logger log = Logger.getLogger(clsTJgdmClkDAO.class);

	
    public static void main(String g[]) throws SQLException {
        try {
        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    //根据jgmc查找jgdm
    public static String findJgdmByJgmc(String jgmc,String jgdm) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String jgdm2 = null;
        String sql = "select jgdm from t_jgdm_clk where jgmc = '" + jgmc + "'";
        try {
            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                jgdm2 = crs.getString("jgdm");
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        if(jgdm2 == null || jgdm2 == ""){
       	 return "";
       }else if(jgdm.equals(jgdm2)){
    	 return "";  
       }else{
           return jgdm2;
       }
    }
	
    //根据注册号查找机构代码
    public static String findJgdmByZch(String zch,String jgdm) {
    	System.out.println(zch+"1111111111111");
    	System.out.println(jgdm+"2222222222");
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String sql = "select jgdm from t_jgdm_clk where zch = '" + zch + "'";
        String jgdm2 =null;
        try {
            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                jgdm2 = crs.getString("jgdm");
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        System.out.println("jgdm2"+jgdm2);
        if(jgdm2 == null || jgdm2 == ""){
        	 return "";
        }else if(jgdm2.equals(jgdm)){
        	System.out.println("jinru");
        	 return "";
        }else{
        	 return jgdm2;
        }
    }
	
}
