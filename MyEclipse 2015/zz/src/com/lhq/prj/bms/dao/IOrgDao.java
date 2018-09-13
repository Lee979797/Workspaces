package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Org;

/**
 * IOrgDao.java Create on 2012-5-5
 * 
 * 机构处理
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public interface IOrgDao {
	/**
	 * 保存一个实体到数据库
	 * 
	 * @param org
	 *         机构实体
	 * @return 主键id
	 */
	public Object saveOrg(Org org) throws Exception;


	/**
	 * 分页查找
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public List findByPage(Page page);

	/**
	 * 分页查找的总记录
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public int findByCount(Page page);

	/**
	 * 修改图书信息
	 * 
	 * @param org
	 * @return
	 * @throws Exception
	 */
	public Integer update(Org org) throws Exception;

	/**
	 * 根据id删除图书
	 * 
	 * @param orgid
	 * @return
	 */
	public Integer deleteById(Integer orgid);


	/***
	 * 根据id获得记录
	 *
	 * @param orgid
	 * @return
	 */
	public Org findById(Integer orgid);
	
	
	/***
	 * 根据username获得记录
	 *
	 * @param username
	 * @return
	 */

	//public List findUsernameOrg(String username);
	
	public List findUsernameOrg(Page page);
	
	public List findOrgidOrg(Integer orgid);
	
	
	public Integer saveImageOrg(Org org) throws Exception;

	public List findByIdViewImg(Page page);



}
