package com.lhq.prj.bms.dao;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Dfile;

/**
 * IDfileDao.java Create on 2012-5-5
 * 
 * 机构处理
 * 
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public interface IDfileDao {
	
	/**
	 * 临时库--模糊查询
	 */
	public List findDfileByPage(Page page);
	/**
	 * 临时库--模糊查询总记录
	 */
	public int findDfileByCount(Page page);
	/**
	 * 临时库--高级查询
	 */
	public List findDfileByGjPage(Page page);
	/**
	 * 临时库--高级总记录
	 */
	public int findDfileByGjCount(Page page);
	
	/**
	 * 正式库--模糊查询
	 */
	public List findArchiveByPage(Page page);
	/**
	 * 正式库--模糊查询总记录
	 */
	public int findArchiveByCount(Page page);
	/**
	 * 正式库--高级查询
	 */
	public List findArchiveByGjPage(Page page);
	/**
	 * 正式库--高级总记录
	 */
	public int findArchiveByGjCount(Page page);
	
	
	/**
	 * 全库--模糊查询
	 */
	public List findAllByPage(Page page);
	/**
	 * 全库--模糊查询的总记录
	 */
	public int findAllByCount(Page page);
	
	
	/**
	 * 全库--简单查询
	 */
	public List findAllByGjPage(Page page);
	/**
	 * 全库--简单查询 总记录
	 */
	public int findAllByGjCount(Page page);
	
	
	/**
	 * 全库--组合查询
	 */
	public List findAllByZuhePage(Page page);
	/**
	 * 全库--组合查询总记录
	 */
	public int findAllByZuheCount(Page page);
	
	/**
	 * 保存一个实体到数据库
	 */
	public Object saveDfile(Dfile dfile);
	
	/**
	 * 保存一个实体到数据库
	 */
	public Object saveArchive(Dfile dfile);

	/**
	 * 修改z_org_dfile信息by orgid
	 */
	public Integer update(Dfile dfile) throws Exception;
	
	/**
	 * 修改z_org_dfile信息by DOCI
	 */
	public Integer updateDfileByDocid(Dfile dfile) throws Exception;
	
	/**
	 * 修改z_org_archive信息by DOCI
	 */
	public Integer updateArchiveByDocid(Dfile dfile) throws Exception;

	/**
	 * 根据id删除图书
	 */
	public Integer deleteById(Integer orgid);

	/***
	 * 根据id获得记录
	 */
	public Dfile findByDfileId(Integer orgid);
	
	public Dfile findByArchiveId(Integer orgid);
	
	public Dfile findByIdViewImg(Integer orgid);
	
	public Dfile findByArchiveIdViewImg(Integer orgid);
	
	public Dfile findArchiveByDocid(String docid);
	
	public List findDfileByQxPage(Page page);
	
	public int findDfileByQxCount(Page page);
	
}
