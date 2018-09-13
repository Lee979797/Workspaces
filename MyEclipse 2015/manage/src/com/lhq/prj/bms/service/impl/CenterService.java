package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ICenterDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.service.ICenterService;

public class CenterService implements ICenterService {

	private ICenterDao centerDao;

	public void setCenterDao(ICenterDao centerDao) {
		this.centerDao = centerDao;
	}

	public Object saveCenter(Center center) {
		return centerDao.saveCenter(center);
	}

	public List findAll() {
		return centerDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(centerDao.findByPage(page));
		page.setTotalProperty(centerDao.findByCount(page));
		return page;
	}

	public boolean updateCenter(Center c) throws Exception {
		Integer flag = centerDao.update(c);
		if(flag != null){
			return true;
		}
		return false;
	}

	public boolean deleteCenter(Integer centerId) {
		Integer flag = centerDao.deleteById(centerId);
		if(flag != null){
			return true;
		}
		return false;
	}

}
