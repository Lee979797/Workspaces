package com.ninemax.jpa.system.bo;

import com.ninemax.jdbc.business.system.clsUserBus;
import com.ninemax.jdbc.dao.system.clsUserDAO;
import com.ninemax.jpa.system.dao.ZSuserDAO;
import com.ninemax.jpa.system.model.ZSuser;
import com.ninemax.jpa.util.clsPageComponent;
import com.ninemax.jpa.util.clsStringTool;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class ZSuserBo {
	private ZSuserDAO zsUserDAO = new ZSuserDAO();
	
	public List<ZSuser> findAll() {
		return zsUserDAO.findAll();
	}
	public List<ZSuser> findPageList(String searchField, String searchValue,String orderbyColum,String orderbyMethod,int pageSize,int pageNo,clsPageComponent pageComponent) throws ParseException  {
		return zsUserDAO.findPageList(searchField, searchValue,orderbyColum,orderbyMethod,pageSize, pageNo, pageComponent);
	}
	public boolean save(ZSuser zSuser){
		return zsUserDAO.save(zSuser);
	}
	public boolean update(ZSuser zSuser){
		return zsUserDAO.update(zSuser);
	}
	public boolean delete(ZSuser zSuser){
		return zsUserDAO.delete(zSuser);
	}
	public ZSuser findById(int id){
		return zsUserDAO.findById(id);
	}
	
	clsUserBus userBus = new clsUserBus();
	
	/**
	 * �����û����õ������û�����
	 * @param user_name
	 * @return
	 */
	public ZSuser FindByName(String user_name) {
		List<ZSuser> user =  zsUserDAO.FindByName(user_name);
		return user.get(0);
	}
	
	/**
	 * �����û�ID�õ������û�����
	 * @param userId �û�ID
	 * @return
	 */
	public ZSuser GetZSuser(String userId) {
			
		return zsUserDAO.findById(Integer.valueOf(userId));
	}
	
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 */
	public int ModifyZSuser(ZSuser user) {

		if(zsUserDAO.update(user)){
		
			return 1;
		}else{
			return -2;
		}
	}
	
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public int AddZSuser(ZSuser user) {
		clsUserBus userBus = new clsUserBus();
		if(userBus.isExistZSuserName(user.getUserName())){//�û����Ѿ�����
			return -1;
		}
		
		boolean userId = zsUserDAO.save(user);
		if(userId){//���ʧ��
			
			//���û���Ȩ��
		//	userBus.AddRightToUser(String.valueOf(user.getUserId()),user.getUsergroupId());
			return 1;
		}else{
			return -2;
		}
		
	}
	
	/**
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return
	 * @throws SQLException 
	 */
	public int Login(String username,String password) throws SQLException {
		//Commented automatically
		if(clsStringTool.isEmpty(username))return -3;//�û���Ϊ��
		if(clsStringTool.isEmpty(password))return -4;//����Ϊ��
		
		if(!com.ninemax.jdbc.business.system.clsUserBus.isExistUsername(username)){//�û���������
			return -2;
		}
		
		if(clsUserDAO.CheckPassword(username, password)){
			return 1;
		}else{
			return -1;//�������
		}
		
		//return 0;
	}

}
