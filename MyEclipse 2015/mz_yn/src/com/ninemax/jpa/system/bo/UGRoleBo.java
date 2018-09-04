package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.system.clsUGRoleDetailDAO;

import java.util.ArrayList;

public class UGRoleBo {
	
	private clsUGRoleDetailDAO uGRoleDetailDAO = null;
	public UGRoleBo(){
		uGRoleDetailDAO = new clsUGRoleDetailDAO();
	}
	
	/**
	 * 根据角色ID得到用户组对象
	 * @param role_id 角色ID
	 * @return
	 */
	public ArrayList getGroupIdsByRoleId(String role_id){
		return uGRoleDetailDAO.getGroupIdsByRoleId(role_id);
	}
	
	/**
	 * 得到该用户组所有角色
	 * @param group_id 用户组ID
	 * @return
	 */
	public ArrayList getRoleIdsByGroupId(String group_id){
		return uGRoleDetailDAO.getRoleIdsByGroupId(group_id);
	}
	
	/**
	 * 根据角色ID得到用户组ID
	 * @param role_id
	 * @return
	 */
	public ArrayList getUgIdsByRoleId(String role_id){
		return uGRoleDetailDAO.getUgIdsByRoleId(role_id);
	}

}
