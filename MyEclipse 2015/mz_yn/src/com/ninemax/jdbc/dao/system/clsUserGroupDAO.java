package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

public class clsUserGroupDAO  {

	private static Logger log = Logger.getLogger(clsUserGroupDAO.class);
	public clsUserGroupDAO(){
		
	}

	
	
	public boolean DeleteUserGroup(String groupId) {
		
		DataAccess dataAccessObject  = new DataAccess();
		boolean reuslt = false;
		String sql = "update sm_usergroup set usergroup_status='1' where usergroup_id='"+groupId+"'";
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
	 * 查找有没有对应记录
	 * @param channel_id
	 * @param unitId
	 * @return
	 */
	public boolean isExitUserGroupId(String usergroup_id){
		DataAccess dataAccessObject = new DataAccess();
		boolean reuslt = false;
		String sql = " select * from sm_usergroup where usergroup_id='"+usergroup_id+"' ";

		try {

			CachedRowSet crs = dataAccessObject.query(sql);
			if (crs.next()) {
				reuslt = true;

			}
		} catch (Exception e) {
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return reuslt;
	}
	

}
