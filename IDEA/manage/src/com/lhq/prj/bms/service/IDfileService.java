package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Dfile;

/**    
 * IDfileService.java Create on 2012-5-5 
 *
 * 证书档案业务层接口
 *
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0  
 */
public interface IDfileService {
	

	/**
	 * 审核库（临时库+问题库）  模糊查询
	 * @param page 分页对象
	 * @return
	 */
	Page findDfileByPage(Page page);
	
	/**
	 * 正式库   模糊查询
	 * @param page 分页对象
	 * @return
	 */
	Page findArchiveByPage(Page page);
	
	
	/**
	 * 审核库（临时库+问题库） 高级查询
	 * @param page 分页对象
	 * @return
	 */
	Page findDfileByGjPage(Page page);
	
	
	/**
	 * 正式库（临时库+问题库） 高级查询
	 * @param page 分页对象
	 * @return
	 */
	Page findArchiveByGjPage(Page page);
	
	
	/**
	 * 全库（审核库+正式库）模糊查询
	 * @param page 分页对象
	 * @return
	 */
	Page findAllByPage(Page page);
	
	/**
	 * 全库（审核库+正式库）简单查询，分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findAllByGjPage(Page page);

	
	/**
	 * 全库（审核库+正式库）组合查询，分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findAllByZuhePage(Page page);
	
	/**
	 * 归档，新增数据
	 * @param dfile
	 * @return
	 */
	Object saveDfile(Dfile dfile);
	
	/**
	 * 归档，新增数据
	 * @param dfile
	 * @return
	 */
	Object saveArchive(Dfile dfile);
	
	/**
	 * 修改z_org_dfile信息by orgid
	 * @param dfile
	 * @return
	 * @throws Exception 
	 */
	boolean updateDfile(Dfile dfile) throws Exception;
	
	/**
	 * 修改z_org_dfile信息by docid
	 * @param dfile
	 * @return
	 * @throws Exception 
	 */
	boolean updateDfileByDocid(Dfile dfile) throws Exception;
	
	/**
	 * 修改z_org_archive信息by docid
	 * @param dfile
	 * @return
	 * @throws Exception 
	 */
	boolean updateArchiveByDocid(Dfile dfile) throws Exception;

	/**
	 * 删除
	 * 
	 * @param rootPath 上下文路径
	 * @param dfileId
	 * @return
	 */
	boolean deleteDfile(String rootPath,Integer orgid);

	
	/**
	 * 浏览原文
	 * @param dfile
	 * @return
	 * @throws Exception 
	 */
	Object dfileViewImg(Integer orgid);
	
	/**
	 * 浏览原文
	 * @param dfile
	 * @return
	 * @throws Exception 
	 */
	Object archiveViewImg(Integer orgid);
	
	
	/**
	 * 上传原文
	 * @param dfile
	 * @return
	 * @throws Exception 
	 */
	boolean saveImageDfile(Dfile dfile) throws Exception;
	
	
	Dfile findByDfileId(Integer orgid);
	
	Dfile findByArchiveId(Integer orgid);
	
	Dfile findArchiveByDocid(String docid);

	int findDfileCount(Page page);

	Page findDfileByQxPage(Page page);
}
 