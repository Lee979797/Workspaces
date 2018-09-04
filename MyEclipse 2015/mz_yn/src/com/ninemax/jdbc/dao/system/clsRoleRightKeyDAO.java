package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;



public class clsRoleRightKeyDAO {
	private static Logger log = Logger.getLogger(clsRoleRightKeyDAO.class);

	public clsRoleRightKeyDAO(){

	}
	
	public boolean DeleteKeyByRoleId(String roleId) {
		
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		String sql = "delete from  sm_userrightkey where user_id='"+roleId+"' and isRole='1'";
		//clsLog.logDebug("delete="+sql);
		try{
			if(dataAccessObject.execute(sql)==1){
				reuslt = true;
			}else{
				reuslt = false;
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);

		}
		return reuslt ;
		
	}

	public boolean AddKeyToRole(String key_id,String roleId) {
		
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		String sql = "insert into sm_userrightkey (user_id,"
			       +"rightkey_id,"
			       +"isRole)values("
			       +"'"+roleId+"',"
			       +"'"+key_id+"',"
			       +"'1')";
	
		try{
			if(dataAccessObject.execute(sql)==1){
				reuslt = true;
			}else{
				reuslt = false;
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		
		return false;
	}
	
    /**
     * ArrayList¿Ô√Ê «String
     ***/
	public ArrayList getKeyIdsByRoleId(String roleId){
		
		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrRightKeyId = new ArrayList();
		String sql = "select rightkey_id from sm_userrightkey where user_id='"+roleId+"' and isRole='1'";
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				arrRightKeyId.add(crs.getString("rightkey_id").trim());
			}
			
		}catch(Exception e){
			
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrRightKeyId;
	}
	
	public boolean FindByRoleIdKeyId(String roleId,String key_id) {

		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		boolean result = false;
		String sql = "select rightkey_id from sm_userrightkey where user_id='"+roleId+"' and rightkey_id='"+key_id+"' and isRole='1'";
		//clsLog.logDebug("sql="+sql);
		try{
			
			crs = dataAccessObject.query(sql);
			if(crs.next()){
				result = true;
			}
			
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
			
		}
		return result;
	}

	public boolean DeleteKeyByRoleId(String role_id, String rightkey) {
		
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		String sql = "delete from  sm_userrightkey where user_id='"+role_id+"' and rightkey_id like '"+rightkey+"%' and isRole='1'";
		try{
			//clsLog.logDebug("delete="+sql);
			if(dataAccessObject.execute(sql)==1){
				reuslt = true;
			}else{
				reuslt = false;
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return reuslt ;
		
	}
}
