package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.User;

/**    
 * IUserDao.java Create on 2008-9-19 ����01:42:11   
 *
 * �û�����־ò�ӿ�
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public interface IUserDao {
	/**
	 * ����һ���û�ʵ�嵽��ݿ�
	 * 
	 * @param user
	 *            �û�ʵ��
	 * @return ����id
	 */
	public Object saveUser(User user);


	/**
	 * ��ҳ����
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * ҳ���ҵ��ܼ�¼
	 * 
	 * @param page
	 *            ����
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * �޸��û���Ϣ
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer update(User user) throws Exception;

	/**
	 * ���idɾ���û�
	 * 
	 * @param userId
	 * @return
	 */
	public Integer deleteById(Integer userId);


	/**
	 * �û���¼����
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user);


	/**
	 * ����û�ʾ������û�
	 *
	 * @param user
	 * @return
	 */
	public List findByExample(User user);

	public Object regUser(User user);

}
 