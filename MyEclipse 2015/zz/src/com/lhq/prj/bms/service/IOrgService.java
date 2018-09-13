package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Org;

/**    
 * IOrgService.java Create on 2012-5-5 
 *
 * 证书业务层接口
 *
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0  
 */
public interface IOrgService {
	/**
	 * 添加
	 * @param org
	 * @return
	 */
	Object saveOrg(Org org) throws Exception;

	/**
	 * 分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * 根据用户查找
	 * @param 
	 * @return
	 */
	//List findUsernameOrg(String username);
	List findUsernameOrg(Page page);
	
	
	/**
	 * 根据orgid
	 * @param 
	 * @return
	 */
	List findOrgidOrg(Integer orgid);
	
	
	/**
	 * 修改信息
	 * @param org
	 * @return
	 * @throws Exception 
	 */
	boolean updateOrg(Org org) throws Exception;

	/**
	 * 删除
	 * 
	 * @param rootPath 上下文路径
	 * @param orgId
	 * @return
	 */
	boolean deleteOrg(String rootPath,Integer orgId);

	/**
	 * 用户提交申请单
	 *
	 * @param org
	 * @return
	 * @throws Exception 
	 */
	boolean returnOrg(Org org) throws Exception;

	boolean saveImageOrg(Org org) throws Exception;

	List orgViewImg(Page page);

}
 