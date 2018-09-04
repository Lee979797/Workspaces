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
	 * 根据用户名得到自述用户对象
	 * @param user_name
	 * @return
	 */
	public ZSuser FindByName(String user_name) {
		List<ZSuser> user =  zsUserDAO.FindByName(user_name);
		return user.get(0);
	}
	
	/**
	 * 根据用户ID得到自述用户对象
	 * @param userId 用户ID
	 * @return
	 */
	public ZSuser GetZSuser(String userId) {
			
		return zsUserDAO.findById(Integer.valueOf(userId));
	}
	
	
	/**
	 * 修改用户
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
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int AddZSuser(ZSuser user) {
		clsUserBus userBus = new clsUserBus();
		if(userBus.isExistZSuserName(user.getUserName())){//用户名已经存在
			return -1;
		}
		
		boolean userId = zsUserDAO.save(user);
		if(userId){//添加失败
			
			//给用户赋权限
		//	userBus.AddRightToUser(String.valueOf(user.getUserId()),user.getUsergroupId());
			return 1;
		}else{
			return -2;
		}
		
	}
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 * @throws SQLException 
	 */
	public int Login(String username,String password) throws SQLException {
		//Commented automatically
		if(clsStringTool.isEmpty(username))return -3;//用户名为空
		if(clsStringTool.isEmpty(password))return -4;//密码为空
		
		if(!com.ninemax.jdbc.business.system.clsUserBus.isExistUsername(username)){//用户名不存在
			return -2;
		}
		
		if(clsUserDAO.CheckPassword(username, password)){
			return 1;
		}else{
			return -1;//密码错误
		}
		
		//return 0;
	}

}
