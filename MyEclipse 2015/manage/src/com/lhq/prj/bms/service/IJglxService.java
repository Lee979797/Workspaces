package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Jglx;

/**
 * IJglxService.java Create on 2012-5-5
 * 
 * 职务管理业务层接口
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author
 * @version 1.0
 */
public interface IJglxService {

	/**
	 * 添加职务
	 * 
	 * @param jglx
	 * @return
	 */
	Object saveJglx(Jglx jglx);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param jglx
	 * @return
	 * @throws Exception
	 */
	boolean updateJglx(Jglx jglx) throws Exception;

	/**
	 * 删除职务
	 * 
	 * @param jglxId
	 * @return
	 */
	boolean deleteJglx(Integer jglxid);
	
	Page findByPage(Page page);
	
	List findByPjglx(String pjglx);
	
	Jglx findMcByDm(String code);
}
