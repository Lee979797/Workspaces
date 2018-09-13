package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Jjlx;

/**
 * IJjlxService.java Create on 2012-5-5
 * 
 * 职务管理业务层接口
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author
 * @version 1.0
 */
public interface IJjlxService {

	/**
	 * 添加职务
	 * 
	 * @param jjlx
	 * @return
	 */
	Object saveJjlx(Jjlx jjlx);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param jjlx
	 * @return
	 * @throws Exception
	 */
	boolean updateJjlx(Jjlx jjlx) throws Exception;

	/**
	 * 删除职务
	 * 
	 * @param jjlxId
	 * @return
	 */
	boolean deleteJjlx(Integer jjlxid);
	
	Page findByPage(Page page);
	
	List findByPjjlx(String pjjlx);

	Jjlx findMcByDm(String code);

}
