package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.system.clsRoleRightKeyDAO;

import java.util.ArrayList;

public class RoleRightkeyBo {
	private clsRoleRightKeyDAO roleRightKeyDAO = null;
	public RoleRightkeyBo(){

		roleRightKeyDAO = new clsRoleRightKeyDAO();
	}
	
	/**
	 * ��ɫ�Ƿ��и�Ȩ��
	 * @param roleId ��ɫID
	 * @param key_id Ȩ��ID
	 * @return
	 */
	public boolean HasRight(String roleId,String key_id) {
		return roleRightKeyDAO.FindByRoleIdKeyId(roleId,key_id);
	}
	
	/**
	 * ���ݽ�ɫID�õ�Ȩ��
	 * @param roleId ��ɫID
	 * @return
	 */
	public ArrayList getKeyIdsByRoleId(String roleId){
		return roleRightKeyDAO.getKeyIdsByRoleId(roleId);
	}
	
	/**
	 * ���ݽ�ɫ�޸�Ȩ��
	 * @param roleId ��ɫID
	 * @param rightkeys Ȩ��
	 * @param isUpdate �Ƿ����
	 * @return
	 */
	public boolean UpdateRoleRightKey(String roleId,String[] rightkeys,boolean isUpdate ){
			
		//clsUGRoleBus uGRoleBus = new clsUGRoleBus();
		//clsUserBus userBus = new clsUserBus();
		//clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
		//ArrayList oldRoleKeys = getKeyIdsByRoleId(roleId);
		//ArrayList groupsByRole = uGRoleBus.getGroupIdsByRoleId(roleId);
		
		if(isUpdate){
		    /**����ɾ���ý�ɫ������Ȩ��*/
		    roleRightKeyDAO.DeleteKeyByRoleId(roleId);
		    /**ɾ���û������û��Ľ�ɫ*/
		
		/*
		    if(groupsByRole!=null && groupsByRole.size()>0){
			/**�ҵ��û���**\/
			    for(int index=0;index<groupsByRole.size();index++){
				    clsUserGroupTO userGroupTO = (clsUserGroupTO)groupsByRole.get(index);
				
				    String groupId = userGroupTO.getUserGroup_id();
				
				    /**�����û�������Ȩ��*\/
				
				    /**�ҵ��û�**\/
				    ArrayList userIds = userBus.GetUserIdByGroupId(groupId);
				    if(userIds!=null && userIds.size()>0){
					
					    for(int index2=0;index2<userIds.size();index2++){
						    String userId = (String)userIds.get(index2);
						    /**ɾ��ԭ�ȵ�Ȩ��*\/
						    if(oldRoleKeys!=null && oldRoleKeys.size()>0){
							    for(int index3=0;index3<oldRoleKeys.size();index3++){
								
								    String oldRoleKeyId = (String)oldRoleKeys.get(index3);
								
								    userRightKeyBus.DeleteKeyByUserId(userId, oldRoleKeyId);
							    }
						    }
					    }
				    }
				
				
			    }
		    }*/
		}
		/**���¸���ɫ��Ȩ��*/
		if(rightkeys!=null && rightkeys.length>0){
			
			//clsLog.logDebug("rightkeys.length="+rightkeys.length);
			for(int index=0;index<rightkeys.length;index++){
				roleRightKeyDAO.AddKeyToRole(rightkeys[index],roleId);
			}
		}
		/**����ý�ɫ�����û���Ȩ��*/
		
		/*if(groupsByRole!=null && groupsByRole.size()>0){
			
			for(int index=0;index<groupsByRole.size();index++){
				clsUserGroupTO userGroupTO = (clsUserGroupTO)groupsByRole.get(index);
				
				String groupId = userGroupTO.getUserGroup_id();
				
				/**�����û��������Ȩ��*\/
				
				ArrayList userIds = userBus.GetUserIdByGroupId(groupId);
				if(userIds!=null && userIds.size()>0){
					
					for(int index2=0;index2<userIds.size();index2++){
						String userId = (String)userIds.get(index2);
						/**������Ȩ��*\/
						if(rightkeys!=null && rightkeys.length>0){
							for(int index3=0;index3<rightkeys.length;index3++){
								userRightKeyBus.AddKeyToUser(userId, rightkeys[index3]);
							}
						}
					}
				}
				
				
			}
		}*/
		return true;
	}
}
