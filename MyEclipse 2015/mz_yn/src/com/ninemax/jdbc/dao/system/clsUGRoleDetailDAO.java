/**
 * 角色-用户组关联
 */
package com.ninemax.jdbc.dao.system;

import com.ninemax.jdbc.dao.DataAccess;
import com.ninemax.jpa.system.model.Role;
import com.ninemax.jpa.system.model.UserGroup;
import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

import java.util.ArrayList;


public class clsUGRoleDetailDAO {

	private static Logger log = Logger.getLogger(clsUGRoleDetailDAO.class); 
	
	public clsUGRoleDetailDAO(){
		
	}
	
	public int getCountByRoleId(String role_id) {
		
		DataAccess dataAccessObject  = new DataAccess();

		CachedRowSet crs = null;
		int intCount = 0;
		String sql = "select count(*) as num from sm_ugroledetail ur,sm_usergroup ug where ur.USERGROUP_ID=ug.usergroup_id and ug.usergroup_status='0' and  ur.role_id='"+role_id+"'";
		try{
			
			crs = dataAccessObject.query(sql);
			if(crs.next()){
				intCount = crs.getInt("num");
			}
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return intCount;
		
	}

	public boolean DeleteByGroupId(String group_id) {
		
		DataAccess dataAccessObject  = new DataAccess();
		boolean reuslt = false;
		String sql = "delete from  sm_ugroledetail  where usergroup_id='"+group_id+"'";
		try{
			if(dataAccessObject.execute(sql)==1){
				reuslt = true;
			}else{
				reuslt = false;
			}
		}catch(Exception e){throw new RuntimeException(e.getMessage(),e);}
		return reuslt ;
	}
	
	public ArrayList getRoleIdsByGroupId(String group_id){
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrRoleId = new ArrayList();
		String sql = "select * from sm_usergroup g ,sm_ugroledetail ur,sm_role r  where g.USERGROUP_ID='"+group_id+"' and g.USERGROUP_ID=ur.USERGROUP_ID and ur.ROLE_ID=r.ROLE_ID";
		//String sql = "select role_id from sm_ugroledetail where usergroup_id='"+group_id+"'";
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				Role role = new Role();
				role.setRoleId(crs.getInt("role_id"));
				role.setRoleKind(crs.getString("role_kind").trim());
				role.setRoleMemo(crs.getString("role_memo"));
				role.setRoleName(crs.getString("role_name").trim());
				role.setRoleStatus(crs.getString("role_status").trim());
				arrRoleId.add(role);
			}
			
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrRoleId;
	}
	

	public ArrayList getGroupIdsByRoleId(String role_id){
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrRoleId = new ArrayList();
		String sql = "select * from sm_usergroup g ,sm_ugroledetail ur,sm_role r  where r.role_ID='"+role_id+"' and g.USERGROUP_ID=ur.USERGROUP_ID and ur.ROLE_ID=r.ROLE_ID";
		//String sql = "select usergroup_id from sm_ugroledetail where role_id='"+role_id+"'";
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				UserGroup userGroup = new UserGroup();
				userGroup.setUsergroupId(crs.getInt("USERGROUP_ID"));
				userGroup.setUsergroupKind(crs.getString("UserGroup_kind").trim());
				userGroup.setUsergroupMemo(crs.getString("UserGroup_memo"));
				userGroup.setUsergroupName(crs.getString("UserGroup_name").trim());
				userGroup.setUsergroupStatus(crs.getString("UserGroup_status").trim());
				arrRoleId.add(userGroup);
			}
			
		}catch(Exception e){
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrRoleId;
	}
	
	
	public ArrayList getUgIdsByRoleId(String role_id){
		
		DataAccess dataAccessObject  = new DataAccess();
		CachedRowSet crs = null;
		ArrayList arrRoleId = new ArrayList();
		String sql = "select * from sm_usergroup g ,sm_ugroledetail ur,sm_role r  where r.role_ID='"+role_id+"' and g.USERGROUP_ID=ur.USERGROUP_ID and ur.ROLE_ID=r.ROLE_ID";
		//String sql = "select usergroup_id from sm_ugroledetail where role_id='"+role_id+"'";
		try{
			
			crs = dataAccessObject.query(sql);
			while(crs.next()){
				arrRoleId.add(crs.getString("USERGROUP_ID").trim());
			
			}
			
		}catch(Exception e){
			
			log.error("error", e);
			throw new RuntimeException(e.getMessage(),e);
		}
		return arrRoleId;
	}


	public boolean addRoleToGroup(String role_id, String group_id) {
		
		DataAccess dataAccessObject  = new DataAccess();
		boolean reuslt = false;
		String sql = "insert into sm_ugroledetail (usergroup_id,"
			       +"role_id)values("
			       +"'"+group_id+"',"
			       +"'"+role_id+"')";	
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
		
		return reuslt;
	}

}
