package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Xzqh;

/**
 * IXzqhDao.java Create on 2008-9-18 下午08:16:37
 * 
 * 职务持久层接口
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
public interface IXzqhDao {

	/**
	 * 保存一个职务到数据库
	 * 
	 * @param xzqh
	 * @return
	 */
	public Object saveXzqh(Xzqh xzqh);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	public List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param xzqh
	 * @return
	 * @throws Exception
	 */
	public Integer update(Xzqh xzqh) throws Exception;

	/**
	 * 根据id删除职务
	 * 
	 * @param xzqhId
	 * @return
	 */
	public Integer deleteById(Integer xzqhId);

	public List findByPage(Page page);

	public int findByCount(Page page);
}
