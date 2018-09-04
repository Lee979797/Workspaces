package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.system.clsRoleRightKeyDAO;

import java.util.ArrayList;

public class RoleRightkeyBo {
	private clsRoleRightKeyDAO roleRightKeyDAO = null;
	public RoleRightkeyBo(){

		roleRightKeyDAO = new clsRoleRightKeyDAO();
	}
	
	/**
	 * 角色是否有该权限
	 * @param roleId 角色ID
	 * @param key_id 权限ID
	 * @return
	 */
	public boolean HasRight(String roleId,String key_id) {
		return roleRightKeyDAO.FindByRoleIdKeyId(roleId,key_id);
	}
	
	/**
	 * 根据角色ID得到权限
	 * @param roleId 角色ID
	 * @return
	 */
	public ArrayList getKeyIdsByRoleId(String roleId){
		return roleRightKeyDAO.getKeyIdsByRoleId(roleId);
	}
	
	/**
	 * 根据角色修改权限
	 * @param roleId 角色ID
	 * @param rightkeys 权限
	 * @param isUpdate 是否更改
	 * @return
	 */
	public boolean UpdateRoleRightKey(String roleId,String[] rightkeys,boolean isUpdate ){
			
		//clsUGRoleBus uGRoleBus = new clsUGRoleBus();
		//clsUserBus userBus = new clsUserBus();
		//clsUserRightKeyBus userRightKeyBus = new clsUserRightKeyBus();
		//ArrayList oldRoleKeys = getKeyIdsByRoleId(roleId);
		//ArrayList groupsByRole = uGRoleBus.getGroupIdsByRoleId(roleId);
		
		if(isUpdate){
		    /**首先删除该角色的所有权限*/
		    roleRightKeyDAO.DeleteKeyByRoleId(roleId);
		    /**删除用户组下用户的角色*/
		
		/*
		    if(groupsByRole!=null && groupsByRole.size()>0){
			/**找到用户组**\/
			    for(int index=0;index<groupsByRole.size();index++){
				    clsUserGroupTO userGroupTO = (clsUserGroupTO)groupsByRole.get(index);
				
				    String groupId = userGroupTO.getUserGroup_id();
				
				    /**更新用户的所有权限*\/
				
				    /**找到用户**\/
				    ArrayList userIds = userBus.GetUserIdByGroupId(groupId);
				    if(userIds!=null && userIds.size()>0){
					
					    for(int index2=0;index2<userIds.size();index2++){
						    String userId = (String)userIds.get(index2);
						    /**删除原先的权限*\/
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
		/**重新给角色赋权限*/
		if(rightkeys!=null && rightkeys.length>0){
			
			//clsLog.logDebug("rightkeys.length="+rightkeys.length);
			for(int index=0;index<rightkeys.length;index++){
				roleRightKeyDAO.AddKeyToRole(rightkeys[index],roleId);
			}
		}
		/**整理该角色所有用户的权限*/
		
		/*if(groupsByRole!=null && groupsByRole.size()>0){
			
			for(int index=0;index<groupsByRole.size();index++){
				clsUserGroupTO userGroupTO = (clsUserGroupTO)groupsByRole.get(index);
				
				String groupId = userGroupTO.getUserGroup_id();
				
				/**更新用户组的所有权限*\/
				
				ArrayList userIds = userBus.GetUserIdByGroupId(groupId);
				if(userIds!=null && userIds.size()>0){
					
					for(int index2=0;index2<userIds.size();index2++){
						String userId = (String)userIds.get(index2);
						/**增加新权限*\/
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
