package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;

/**    
 * ITjgdmService.java Create on 2012-5-5 
 *
 * 证书业务层接口
 *
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0  
 */
public interface ITjgdmService {
	/**
	 * 添加
	 * @param tjgdm
	 * @return
	 */
	Object saveTjgdm(Tjgdm tjgdm);

	/**
	 * 分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByPage(Page page);

	/**
	 * 修改信息
	 * @param tjgdm
	 * @return
	 * @throws Exception 
	 */
	boolean updateTjgdm(Tjgdm tjgdm) throws Exception;

	/**
	 * 删除
	 * 
	 * @param rootPath 上下文路径
	 * @param orgnewId
	 * @return
	 */
	boolean deleteTjgdm(String rootPath,Integer orgid);

	/**
	 * 提交新办申请单
	 *
	 * @param tjgdm
	 * @return
	 * @throws Exception 
	 */
	boolean returnTjgdm(Tjgdm tjgdm) throws Exception;
	
	
	/**
	 * 申请单网审通过OK
	 */
	boolean returnTjgdmOk(Tjgdm tjgdm) throws Exception;
	
	/**
	 * 申请单网审驳回NO
	 */
	boolean returnTjgdmNo(Tjgdm tjgdm) throws Exception;
	
	/**
	 * 证照赋码 
	 */
	boolean returnTjgdmCode(Tjgdm tjgdm) throws Exception;
	
	/**
	 * 证照归档 
	 */
	boolean returnTjgdmCreate(Tjgdm tjgdm) throws Exception;
	
	/**
	 * 证照打印
	 */
	boolean returnTjgdmPrint(Tjgdm tjgdm) throws Exception;
	
	/**
	 * 证照发放
	 */
	boolean returnTjgdmGo(Tjgdm tjgdm) throws Exception;

	Tjgdm returnTjgdmByJgdm(Tjgdm tjgdm);

}
 