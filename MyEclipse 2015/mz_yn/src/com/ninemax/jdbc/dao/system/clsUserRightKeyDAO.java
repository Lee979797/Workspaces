package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;



public class clsUserRightKeyDAO {

	private static Logger log = Logger.getLogger(clsUserRightKeyDAO.class);
	public clsUserRightKeyDAO(){
		
	}

	
	public boolean DeleteKeyByUserId(String userId) {
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		
		String sql = "delete from  sm_userrightkey where user_id='"+userId+"' and isRole='0'";
		
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

	public boolean AddKeyToUser(String userId,String key_id) {
		
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		String sql = "insert into sm_userrightkey (user_id,"
			       +"rightkey_id,"
			       +"isRole)values("
			       +"'"+userId+"',"
			       +"'"+key_id+"',"
			       +"'0')";
		
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
	

	public ArrayList getKeyIdsByUserId(String userId){
		
		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrRightKeyId = new ArrayList();
		String sql = "select rightkey_id from sm_userrightkey where user_id='"+userId+"' and isRole='0'";
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				arrRightKeyId.add(crs.getString("rightkey_id"));
			}
			
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrRightKeyId;
	}

	
	public  boolean FindByUserIdKeyId(String userId,String key_id) {

		String groups [] = this.findMoreGroupId(userId);
		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		boolean result = false;
		String sql = "select * from sm_userrightkey where isrole='1' and user_id in (select rtrim(role_id) from sm_ugroledetail where rtrim(usergroup_id) in " ;
		sql += "(";
		for(String groupid : groups){
			sql += "'"+groupid+"',";
		}
		sql += "''";
		sql += ")";
		//sql += "(select trim(usergroup_id) from sm_usermanage where user_id='"+userId+"')";
		sql += ") and rightkey_id='"+key_id+"'";

        //log.info("sql======"+sql);

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
	/**
	 * 查找用户对应的组id，有可能是多个，放入List集合中
	 * @param user_id
	 * @return
	 */
	public String [] findMoreGroupId(String user_id){
		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		String sql = "SELECT rtrim(usergroup_id) as groupid FROM sm_usermanage WHERE user_id = '"+user_id+"'";

		String str [] = null;
		try{   
			
			crs = dataAccessObject.query(sql);
			if(crs.next()){
				 String _str = crs.getString("groupid"); 
				 str= _str.split(",");
			}
			
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return str;
	}
	
	public  boolean FindByKeyId( String key_id) {

		DataAccess dataAccessObject = new DataAccess();
		CachedRowSet crs = null;
		boolean result = false;
		String sql = "select rightkey_id from sm_userrightkey where  rightkey_id='"+key_id+"' and isRole='0'";
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

	public boolean DeleteKeyByUserId(String userId,String rightkey) {
		
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		
		String sql = "delete from  sm_userrightkey where user_id='"+userId+"' and rightkey_id like '"+rightkey+"%' and isRole='0'";
		
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
	
	/**
	 * 强行删除key
	 * @param rightkey
	 * @return
	 */
	public boolean deleteKey(String rightkey){
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		
		String sql = "delete from  sm_userrightkey where rightkey_id = '"+rightkey.trim()+"'";
		
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
}
