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
	Object saveOrgnew(Orgnew orgnew);

	/**
	 * 分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByPage(Page page);
	
	List findCountByPage(Page page);
	
	List verifyFieldByJgdm(String jgdm);
	
	Page findShenheXcByPage(Page page);
	
	Page findShenheNetByPage(Page page);
	
	Page findAllOrgnewOrTjgdmByPage(Page page);

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
	 * 提交新办申请单
	 *
	 * @param orgnew
	 * @return
	 * @throws Exception 
	 */
	boolean returnOrgnew(Orgnew orgnew) throws Exception;
	
	
	/**
	 * 申请单网审通过OK
	 */
	boolean returnOrgnewOk(Orgnew orgnew) throws Exception;
	
	/**
	 * 申请单网审驳回NO
	 */
	boolean returnOrgnewNo(Orgnew orgnew) throws Exception;
	
	
	/**
	 * 分中心审批通过OK
	 */
	boolean shenheOrgnewOk(Orgnew orgnew) throws Exception;
	
	/**
	 * 分中心审批驳回NO
	 */
	boolean shenheOrgnewNo(Orgnew orgnew) throws Exception;
	
	/**
	 * 证照赋码 
	 */
	boolean returnOrgnewCode(Orgnew orgnew) throws Exception;
	
	/**
	 * 证照归档 
	 */
	boolean returnOrgnewCreate(Orgnew orgnew) throws Exception;
	
	/**
	 * 证照打印
	 */
	boolean returnOrgnewPrint(Orgnew orgnew) throws Exception;
	
	/**
	 * 证照办理
	 */
	boolean returnOrgnewDo(Orgnew orgnew,boolean f) throws Exception;
	
	
	Object saveOrgnewModify(Orgnew orgnew);
	
	boolean updateOrgnewModify(Orgnew orgnew) throws Exception;
	/**
	 * 数据清理
	 */
	boolean returnOrgnewModify(Orgnew orgnew) throws Exception;
	
	
	/**
	 * 证照发放
	 */
	boolean returnOrgnewGo(Orgnew orgnew) throws Exception;

	Object orgnewViewImg(Integer orgid);
	
	List findOrgnewByOrgid(Integer orgid);

	boolean saveImageOrgnew(Orgnew orgnew) throws Exception;

	boolean updateDybzByOrgid(Orgnew orgnew);

	String findByOrgnew(Orgnew orgnew);

	Page findAllExcpOrgnew(Page page);

	boolean updateExceptionOrgnew(Orgnew orgnew) throws Exception;

	boolean delExceptionOrgnew(Integer orgid);

	Page findByQxPage(Page page);

	Page findByYwqxPage(Page page);

	boolean validateJgmc(Orgnew orgnew);


}
 