package com.lhq.prj.bms.service.impl;

import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Sfwqpz;
import com.lhq.prj.bms.dao.ISfwqpzDao;
import com.lhq.prj.bms.service.ISfwqpzService;


/**
 * SfwqpzService.java Create on 2012-5-5
 * 
 * 用户管理业务层实现类
 * 
 * Copyright (c) 2008 by MTA.
 * @author
 * @version 1.0
 */
public class SfwqpzService implements ISfwqpzService {

	private ISfwqpzDao sfwupzDao;

	public void setSfwqpzDao(ISfwqpzDao sfwupzDao) {
		this.sfwupzDao = sfwupzDao;
	}
   
	
	public Sfwqpz findByPzname(String PZNAME){
		return sfwupzDao.findByPzname(PZNAME);
	}
	
}
