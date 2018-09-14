package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.User;

/**    
 * IUserService.java Create on 2008-9-19 ����01:39:40   
 *
 * �û�����ҵ���ӿ�
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface IUserService {
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	Object saveUser(User user);

   /**
	 * �û�ע��
	 * @param user
	 * @return
	 */
   Object regUser(User user);
   
	/**
	 * ��ҳ����
	 * @param page ��ҳ����
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean updateUser(User user) throws Exception;

	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception 
	 */
	boolean midifyUser(User user) throws Exception;
	/**
	 * ɾ���û�
	 * 
	 * @param deptId
	 * @return
	 */
	boolean deleteUser(Integer bzjgId);


	/**
	 * ��½ϵͳ
	 * 
	 * @param user
	 * @return user
	 */
	User login(User user);

	boolean updatePwd(String userPwdOld, User user);

	/**
	 * ����û�ʵ������û�
	 *
	 * @param user
	 * @return
	 */
	List findByExample(User user);
}
 