package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Jjlx;
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
	 * 按代码段分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page findByDmmdPage(Page page);
	
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


	boolean returnTjgdm(Tjgdm tjgdm) throws Exception;

	boolean returnTjgdmOk(Tjgdm tjgdm) throws Exception;
	

	boolean returnTjgdmNo(Tjgdm tjgdm) throws Exception;
	

	boolean returnTjgdmFeizhiHuifuSq(Tjgdm tjgdm) throws Exception;
	

	boolean returnTjgdmFeizhiHuifu(Tjgdm tjgdm) throws Exception;
	

	boolean returnTjgdmPrint(Tjgdm tjgdm) throws Exception;
	

	boolean returnTjgdmGo(Tjgdm tjgdm) throws Exception;
	
	public Tjgdm findByJgdm(Tjgdm tjgdm);
	
	public Tjgdm findByJgdmQz(Tjgdm tjgdm);
	
	List fingCodeByTjgdm(Tjgdm tjgdm) throws Exception;

	Tjgdm tjgdmViewImg(Integer orgid);

	Page findByPrintPage(Page page);

	int findPrintCount(Page page);

}
 