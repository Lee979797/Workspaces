package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Bzjg;

/**
 * IBzjgService.java Create on 2012-5-5
 * 
 * 职务管理业务层接口
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author
 * @version 1.0
 */
public interface IBzjgService {

	/**
	 * 添加职务
	 * 
	 * @param bzjg
	 * @return
	 */
	Object saveBzjg(Bzjg bzjg);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param bzjg
	 * @return
	 * @throws Exception
	 */
	boolean updateBzjg(Bzjg bzjg) throws Exception;

	/**
	 * 删除职务
	 * 
	 * @param bzjgId
	 * @return
	 */
	boolean deleteBzjg(Integer bzjgid);
	
	Page findByPage(Page page);

	Bzjg findByBzjgdm(Bzjg bzjg);
}
