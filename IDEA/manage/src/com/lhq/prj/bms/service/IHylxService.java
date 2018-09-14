package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Hylx;

/**
 * IHylxService.java Create on 2012-5-5
 * 
 * 职务管理业务层接口
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author
 * @version 1.0
 */
public interface IHylxService {

	/**
	 * 添加职务
	 * 
	 * @param hylx
	 * @return
	 */
	Object saveHylx(Hylx hylx);

	/**
	 * 查找所有职务
	 * 
	 * @return
	 */
	List findAll();

	/**
	 * 修改职务信息
	 * 
	 * @param hylx
	 * @return
	 * @throws Exception
	 */
	boolean updateHylx(Hylx hylx) throws Exception;

	/**
	 * 删除职务
	 * 
	 * @param hylxId
	 * @return
	 */
	boolean deleteHylx(Integer hylxid);
	
	Page findByPage(Page page);
	
	List findByHylx1(String hylx1);
	
	Hylx findMcByDm(String code);
}
