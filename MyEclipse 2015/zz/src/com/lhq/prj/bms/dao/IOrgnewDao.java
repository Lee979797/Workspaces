package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;

/**
 * IOrgnewDao.java Create on 2012-5-5
 * 
 * 机构处理
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public interface IOrgnewDao {
	/**
	 * 保存一个实体到数据库
	 * 
	 * @param org
	 *         机构实体
	 * @return 主键id
	 */
	public Object saveOrgnew(Orgnew orgnew) throws Exception;


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
	public Integer update(Orgnew orgnew) throws Exception;

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
	public Orgnew findById(Integer orgid);
	
	
	/***
	 * 根据username获得记录
	 *
	 * @param username
	 * @return
	 */

	//public List findUsernameOrgnew(String username);
	
	public List findUsernameOrgnew(Page page);
	
	public List findOrgidOrgnew(Integer orgid);
	
	
	public Integer saveImageOrgnew(Orgnew orgnew) throws Exception;

	public Orgnew findByIdViewImg(Integer orgid);


	public Orgnew checkUsernameByJgdm(String strJgdm);


	public List findJgdmOrgnew(Page page);


	public List findConditionsOrgnew(Page page);



}
