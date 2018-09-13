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
	Object saveOrg(Org org);

	/**
	 * 分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByPage(Page page);

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
	 * 提交新办申请单
	 *
	 * @param org
	 * @return
	 * @throws Exception 
	 */
	boolean returnOrg(Org org) throws Exception;
	
	
	/**
	 * 申请单网审通过OK
	 */
	boolean returnOrgOk(Org org) throws Exception;
	
	/**
	 * 申请单网审驳回NO
	 */
	boolean returnOrgNo(Org org) throws Exception;
	
	/**
	 * 证照赋码 
	 */
	boolean returnOrgCode(Org org) throws Exception;
	
	/**
	 * 证照归档 
	 */
	boolean returnOrgCreate(Org org) throws Exception;
	
	/**
	 * 证照打印
	 */
	boolean returnOrgPrint(Org org) throws Exception;
	
	/**
	 * 证照办理
	 */
	boolean returnOrgDo(Org org) throws Exception;
	
	
	
	/**
	 * 证照发放
	 */
	boolean returnOrgGo(Org org) throws Exception;

	List orgViewImg(Integer orgid);

	boolean saveImageOrg(Org org) throws Exception;


}
 