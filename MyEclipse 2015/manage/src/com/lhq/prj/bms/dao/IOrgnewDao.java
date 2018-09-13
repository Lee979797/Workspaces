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
	public Object saveOrgnew(Orgnew org);


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
	
	

	public List findByCountList(Page page);
	
	
	public List verifyFieldByJgdm(String jgdm);
	/**
	 * 分页查找
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public List findShenheXcByPage(Page page);

	/**
	 * 分页查找的总记录
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public int findShenheXcByCount(Page page);
	
	
	/**
	 * 分页查找
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public List findShenheNetByPage(Page page);

	/**
	 * 分页查找的总记录
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public int findShenheNetByCount(Page page);
	
	

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

	public Orgnew findByIdViewImg(Integer orgid);
	
	public List findOrgnewByOrgid(Integer orgid);
	
	public Orgnew findByOrgnewJgdm(String jgdm);


	public Integer updateDybzByOrgid(Orgnew orgnew);


	public List findShenheNetByPageCenterid(Page page);


	public int findShenheNetByCountCenterid(Page page);


	public String findByOrgnew(Orgnew orgnew);


	public List findAllExcpOrgnew(Page page);


	public int findAllExcpOrgnewCount(Page page);


	public Integer updateExceptionOrgnew(Orgnew orgnew);


	public List findByQxPage(Page page);


	public int findByQxCount(Page page);


	public List findByYwqxPage(Page page);


	public int findByYwqxCount(Page page);


	public List validateJgmc(Orgnew orgnew);

}
