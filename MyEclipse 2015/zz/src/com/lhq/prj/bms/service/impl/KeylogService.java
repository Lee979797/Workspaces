package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IKeylogDao;
import com.lhq.prj.bms.service.IKeylogService;


/**
 * KeylogService.java Create on 20012-6-28
 * 
 * 主键业务层实现类
 * 
 * Copyright (c) 2008 by YQ.
 * 
 * @author yq
 * @version 1.0
 */

public class KeylogService implements IKeylogService {

	private IKeylogDao keylogDao;

	public void setKeylogDao(IKeylogDao keylogDao) {
		this.keylogDao = keylogDao;
	}
	
	
	public Page createKey(Page page) {
		page.setRoot(keylogDao.createByKey(page));
		return page;
	}
}
