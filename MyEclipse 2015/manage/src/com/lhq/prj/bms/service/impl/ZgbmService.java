package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IZgbmDao;
import com.lhq.prj.bms.service.IZgbmService;

public class ZgbmService implements IZgbmService {
	public IZgbmDao ZgbmDao;
	
	public void setZgbmDao(IZgbmDao zgbmDao) {
		ZgbmDao = zgbmDao;
	}

	public List findAll() {
		// TODO Auto-generated method stub
		return ZgbmDao.findAll();
	}

	public Page findByPage(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(ZgbmDao.findByPage(page));
		page.setTotalProperty(ZgbmDao.findByCount(page));
		return page;
	}
	
	public String findMcByDm(String code) {
		return ZgbmDao.findMcByDm(code);
	}

}
