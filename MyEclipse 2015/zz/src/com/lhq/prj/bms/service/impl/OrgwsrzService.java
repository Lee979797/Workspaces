package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgwsrzDao;
import com.lhq.prj.bms.service.IOrgwsrzService;

public class OrgwsrzService implements IOrgwsrzService {
	private IOrgwsrzDao orgwsrzDao;

	public Page findByPage(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(orgwsrzDao.findByPage(page));
		page.setTotalProperty(orgwsrzDao.findByCount(page));
		return page;
	}

	
	public void setOrgwsrzDao(IOrgwsrzDao orgwsrzDao) {
		this.orgwsrzDao = orgwsrzDao;
	}

}
