package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsRoleRightKeyDAO;
import com.ninemax.jdbc.dao.system.clsUserRightKeyDAO;

import java.util.ArrayList;



/**
 * 用户－－权限关联操作类
 */

public class clsUserRightKeyBus {
	

	private clsUserRightKeyDAO userRightKeyDAO = null;
	public clsUserRightKeyBus(){
		
		userRightKeyDAO = new clsUserRightKeyDAO();
	}
	
	/**
	 * 给用户赋权限 
	 * 
	 **/
	public void AddRoleRightToUser(String userId,String role_id){

		clsRoleRightKeyDAO roleRightKeyDAO = new clsRoleRightKeyDAO();
		//给用户赋权限
		ArrayList arrRightKey = roleRightKeyDAO.getKeyIdsByRoleId(role_id);
		if(arrRightKey!=null){
			if(arrRightKey.size()>0){
				for(int index=0;index<arrRightKey.size();index++){
					String strRightKey = (String)arrRightKey.get(index);
					userRightKeyDAO.AddKeyToUser(userId,strRightKey);
				}
			}
		}
		
	}
	
	/**
	 * 是否拥有权限 
	 **/
	public boolean HasRight(String userId,String keyId){
		return userRightKeyDAO.FindByUserIdKeyId(userId,keyId);
	}
	
	public boolean DeleteKeyByUserId(String userId,String rightkey) {
		return userRightKeyDAO.DeleteKeyByUserId(userId, rightkey);
	}
	public boolean AddKeyToUser(String userId,String key_id) {
		return userRightKeyDAO.AddKeyToUser(userId, key_id);
	}
	/**
	 * 强行删除key
	 * @param rightkey
	 * @return
	 */
	public boolean deleteKey(String rightkey){
		return userRightKeyDAO.deleteKey(rightkey);
	}
}
