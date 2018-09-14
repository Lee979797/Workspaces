package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Xzqh;

/**
 * IXzqhService.java Create on 2012-5-5
 * 
 * 职务管理业务层接口
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author
 * @version 1.0
 */
public interface IXzqhService {

	/**
	 * 添加职务
	 * 
	 * @param xzqh
	 * @return
	 */
	Object saveXzqh(Xzqh xzqh);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param xzqh
	 * @return
	 * @throws Exception
	 */
	boolean updateXzqh(Xzqh xzqh) throws Exception;

	/**
	 * 删除职务
	 * 
	 * @param xzqhId
	 * @return
	 */
	boolean deleteXzqh(Integer xzqhId);
	
	Page findByPage(Page page);
	
	String findXzqhNameByXzqhCode(String xzqhCode);
}
