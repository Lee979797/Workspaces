package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Zuser;

/**    
 * IZuserService.java Create on 2012-5-5
 *
 * 用户管理业务层接口
 *
 * Copyright (c) 20QW by YQ.
 * @author 
 * @version 1.0  
 */
public interface IZuserService {
	/**
	 * 添加用户
	 * @param zuser
	 * @return
	 */
	Object saveZuser(Zuser zuser);

   /**
	 * 用户注册
	 * @param zuser
	 * @return
	 */
   Object regZuser(Zuser zuser);
   
	/**
	 * 分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * 修改用户信息
	 * @param zuser
	 * @return
	 * @throws Exception 
	 */
	boolean updateZuser(Zuser zuser) throws Exception;

	/**
	 * 删除用户
	 * 
	 * @param deptId
	 * @return
	 */
	boolean deleteZuser(Integer userid);


	/**
	 * 系统登录
	 * 
	 * @param zuser
	 * @return zuser
	 */
	Zuser zlogin(Zuser zuser);
	
	
	/**
	 * 用户检查
	 * 
	 * @param zuser
	 * @return zuser
	 */
	boolean checkZuser(String userName);
	
	
	/**
	 * 用户检查
	 * 
	 * @param zuser
	 * @return zuser
	 */
	boolean checkZuserJgmc(String jgmc);


	/**
	 * 根据用户实例查找用户
	 *
	 * @param zuser
	 * @return
	 */
	List findByExample(Zuser zuser);

	//Zuser findUserInfo(Zuser zu);

	List findUserInfo(Zuser zu);

	boolean updatePwd(String userPwdOld, Zuser zuser);
	
	String findJgdmByUserid(int userid);
	
}
 