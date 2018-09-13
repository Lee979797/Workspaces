package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJglxDao;
import com.lhq.prj.bms.po.Jglx;
import com.lhq.prj.bms.service.IJglxService;

/**
 * JglxService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class JglxService implements IJglxService {

	private IJglxDao jglxDao;

	public void setJglxDao(IJglxDao jglxDao) {
		this.jglxDao = jglxDao;
	}

	public boolean deleteJglx(Integer jglxid) {
		Integer flag = jglxDao.deleteById(jglxid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return jglxDao.findAll();
	}
	
	public Page findByPage(Page page) {
		page.setRoot(jglxDao.findByPage(page));
		page.setTotalProperty(jglxDao.findByCount(page));
		return page;
	}
	
	public List findByPjglx(String pjglx) {
		return jglxDao.findByPjglx(pjglx);
	}
	
	public Object saveJglx(Jglx jglx) {
		return jglxDao.saveJglx(jglx);
	}

	public boolean updateJglx(Jglx jglx) throws Exception {
		Integer flag = jglxDao.update(jglx);
		if (flag != null) {
			return true;
		}
		return false;
	}
	
	public String findByJglxdm(String jglxdm) {
		// TODO Auto-generated method stub
		return jglxDao.findByJglxdm(jglxdm);
	}
}
