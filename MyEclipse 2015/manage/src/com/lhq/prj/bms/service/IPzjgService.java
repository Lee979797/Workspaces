package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Pzjg;

/**
 * IPzjgService.java Create on 2012-5-5
 * 
 * 职务管理业务层接口
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author
 * @version 1.0
 */
public interface IPzjgService {

	/**
	 * 添加职务
	 * 
	 * @param pzjg
	 * @return
	 */
	Object savePzjg(Pzjg pzjg);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param pzjg
	 * @return
	 * @throws Exception
	 */
	boolean updatePzjg(Pzjg pzjg) throws Exception;

	/**
	 * 删除职务
	 * 
	 * @param pzjgId
	 * @return
	 */
	boolean deletePzjg(Integer pzjgid);
	
	Page findByPage(Page page);
	
	List findByBzjgdm(String bzjgdm);
	
	Pzjg findMcByDm(Pzjg pzjg);
}
