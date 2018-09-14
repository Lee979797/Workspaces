package com.lhq.prj.bms.service;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.Sfwqpz;

/**    
 * ISfwqpzService.java Create on 2012-5-5
 *
 * 用户管理业务层接口
 *
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0  
 */
public interface ISfwqpzService {
	
	
	/**
	 * 根据服务器配置表
	 *
	 * @param sfwupz
	 * @return
	 */
	Sfwqpz findByPzname(String PZNAME);

}
 