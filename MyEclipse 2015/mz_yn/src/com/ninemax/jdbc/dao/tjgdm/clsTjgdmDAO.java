package com.ninemax.jdbc.dao.tjgdm;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.global.EntityManagerHelper;
import com.ninemax.jpa.system.model.User;
import com.ninemax.jpa.system.model.ZSuser;
import com.ninemax.jpa.util.clsStringTool;

import org.apache.log4j.Logger;

import sun.jdbc.rowset.CachedRowSet;

import javax.persistence.EntityManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clsTjgdmDAO {

    private static Logger log = Logger.getLogger(clsTjgdmDAO.class);

    public clsTjgdmDAO() {

    }

  

    public static void main(String g[]) throws SQLException {

        try {

        } catch (Exception e) {
            log.error("error", e);
            throw new RuntimeException(e.getMessage(), e);
        }


    }

   
//lvwei 删除机构
    public static boolean deleteByTyshxydm(String tyshxydm){
    	DataAccess dataAccessObject = new DataAccess();
    	CachedRowSet crs = null;
        String sql = "delete from t_jgdm where tyshxydm = '" + tyshxydm + "'";
        boolean result = false;
        try{
			if(dataAccessObject.execute(sql)==1){
				result = true;
			}else{
				result = false;
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return result ;       
    }
    
    
 //lvwei 审核机构
    public static boolean shenheByXzqh(String xzqh){
    	DataAccess dataAccessObject = new DataAccess();
    	CachedRowSet crs = null;
        String sql = "update  t_jgdm set dybz = '1' where dybz = '2' and xzqh = '" + xzqh + "'";
        boolean result = false;
        try{
			dataAccessObject.execute(sql);
			result = true;	
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return result ;       
    }
    
    //换码
    public static boolean dmUpdate(String oldDm,String newDm){
    	DataAccess dataAccessObject = new DataAccess();
    	CachedRowSet crs = null;
        String sql = "update  t_jgdm set tyshxydm = '" + newDm + "' where tyshxydm = '" + oldDm + "'";
        boolean result = false;
        try{
			dataAccessObject.execute(sql);
			result = true;	
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return result ;       
    }
    
  
    public static String findUserByChineseName(String userLoginValue) {
        DataAccess dataAccessObject = new DataAccess();
        CachedRowSet crs = null;
        String userName = null;
        String sql = "select user_name from SM_UserManage where USER_CHINESENAME = '" + userLoginValue + "'";
        try {
            crs = dataAccessObject.query(sql);
            if (crs.next()) {
                userName = crs.getString("user_name");
            }
        } catch (Exception e) {
            log.error("error", e);
            e.printStackTrace();
        }
        return userName;
    }
}
