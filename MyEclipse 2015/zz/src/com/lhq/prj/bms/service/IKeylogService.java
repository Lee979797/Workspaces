package com.lhq.prj.bms.service;

import com.lhq.prj.bms.core.Page;

/**    
 * ITjgdmService.java Create on 2012-5-5 
 *
 * 主键业务层接口
 *
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0  
 */
public interface IKeylogService {

	/**
	 * 分页查找
	 * @param page 分页对象
	 * @return
	 */
	Page createKey(Page page);
	
	
}
 