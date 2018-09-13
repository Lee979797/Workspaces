package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;

/**    
 * IOrgnewService.java Create on 2012-5-5 
 *
 * 证书业务层接口
 *
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0  
 */
public interface IOrgnewService {
	/**
	 * 添加
	 * @param orgnew
	 * @return
	 */
	Object saveOrgnew(Orgnew orgnew) throws Exception;

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
	//List findUsernameOrgnew(String username);
	List findUsernameOrgnew(Page page);
	
	
	/**
	 * 根据orgid
	 * @param 
	 * @return
	 */
	List findOrgidOrgnew(Integer orgid);
	
	
	/**
	 * 修改信息
	 * @param orgnew
	 * @return
	 * @throws Exception 
	 */
	boolean updateOrgnew(Orgnew orgnew) throws Exception;

	/**
	 * 删除
	 * 
	 * @param rootPath 上下文路径
	 * @param orgnewId
	 * @return
	 */
	boolean deleteOrgnew(String rootPath,Integer orgnewId);

	/**
	 * 用户提交申请单
	 *
	 * @param orgnew
	 * @return
	 * @throws Exception 
	 */
	boolean returnOrgnew(Orgnew orgnew) throws Exception;

	boolean saveImageOrgnew(Orgnew orgnew) throws Exception;

	Object orgnewViewImg(Integer orgid);

	boolean checkUsernameByJgdm(String strJgdm, String strUsername);

	List findJgdmOrgnew(Page page);

	List findConditionsOrgnew(Page page);

}
 