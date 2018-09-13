package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Tsfm;
import com.lhq.prj.bms.po.Zuser;

/**
 * ITjgdmDao.java Create on 2012-5-5
 * 
 * 机构处理
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public interface ITjgdmDao {
	/**
	 * 保存一个实体到数据库
	 * 
	 * @param tjgdm
	 *         机构实体
	 * @return 主键id
	 */
	public Object saveTjgdm(Tjgdm tjgdm);


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
	 * 按码段，分页查找
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public List findByDmmdPage(Page page);

	/**
	 * 按码段，分页查找的总记录
	 * 
	 * @param page
	 *          条件
	 * @return
	 */
	public int findByDmmdCount(Page page);


	/**
	 * 修改图书信息
	 * 
	 * @param tjgdm
	 * @return
	 * @throws Exception
	 */
	public Integer update(Tjgdm tjgdm) throws Exception;

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
	public Tjgdm findById(Integer orgid);
	
	public Tjgdm findByJgdm(Tjgdm tjgdm);
	
	public Tjgdm findByJgdmQz(Tjgdm tjgdm);
	
	public List fingCodeByTjgdm(Tjgdm tjgdm);


	public Tjgdm findByIdViewImg(Integer orgid);


	public int CheckCodeTjgdm(Tsfm tsfm);


	public List findByPrintPage(Page page);


	public int findByPrintCount(Page page);
	
}
