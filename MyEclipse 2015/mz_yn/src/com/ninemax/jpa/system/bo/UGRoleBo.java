package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.dao.system.clsUGRoleDetailDAO;

import java.util.ArrayList;

public class UGRoleBo {
	
	private clsUGRoleDetailDAO uGRoleDetailDAO = null;
	public UGRoleBo(){
		uGRoleDetailDAO = new clsUGRoleDetailDAO();
	}
	
	/**
	 * ���ݽ�ɫID�õ��û������
	 * @param role_id ��ɫID
	 * @return
	 */
	public ArrayList getGroupIdsByRoleId(String role_id){
		return uGRoleDetailDAO.getGroupIdsByRoleId(role_id);
	}
	
	/**
	 * �õ����û������н�ɫ
	 * @param group_id �û���ID
	 * @return
	 */
	public ArrayList getRoleIdsByGroupId(String group_id){
		return uGRoleDetailDAO.getRoleIdsByGroupId(group_id);
	}
	
	/**
	 * ���ݽ�ɫID�õ��û���ID
	 * @param role_id
	 * @return
	 */
	public ArrayList getUgIdsByRoleId(String role_id){
		return uGRoleDetailDAO.getUgIdsByRoleId(role_id);
	}

}
