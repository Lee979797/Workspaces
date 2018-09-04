package com.ninemax.jdbc.business.system;

import com.ninemax.jdbc.dao.system.clsRoleRightKeyDAO;
import com.ninemax.jdbc.dao.system.clsUserRightKeyDAO;

import java.util.ArrayList;



/**
 * �û�����Ȩ�޹���������
 */

public class clsUserRightKeyBus {
	

	private clsUserRightKeyDAO userRightKeyDAO = null;
	public clsUserRightKeyBus(){
		
		userRightKeyDAO = new clsUserRightKeyDAO();
	}
	
	/**
	 * ���û���Ȩ�� 
	 * 
	 **/
	public void AddRoleRightToUser(String userId,String role_id){

		clsRoleRightKeyDAO roleRightKeyDAO = new clsRoleRightKeyDAO();
		//���û���Ȩ��
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
	 * �Ƿ�ӵ��Ȩ�� 
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
	 * ǿ��ɾ��key
	 * @param rightkey
	 * @return
	 */
	public boolean deleteKey(String rightkey){
		return userRightKeyDAO.deleteKey(rightkey);
	}
}
