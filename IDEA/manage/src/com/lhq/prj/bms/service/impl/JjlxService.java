package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJjlxDao;
import com.lhq.prj.bms.po.Jjlx;
import com.lhq.prj.bms.service.IJjlxService;

/**
 * JjlxService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class JjlxService implements IJjlxService {

	private IJjlxDao jjlxDao;

	public void setJjlxDao(IJjlxDao jjlxDao) {
		this.jjlxDao = jjlxDao;
	}

	public boolean deleteJjlx(Integer jjlxid) {
		Integer flag = jjlxDao.deleteById(jjlxid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return jjlxDao.findAll();
	}
	
	public Page findByPage(Page page) {
		page.setRoot(jjlxDao.findByPage(page));
		page.setTotalProperty(jjlxDao.findByCount(page));
		return page;
	}
	
	public List findByPjjlx(String pjjlx) {
		return jjlxDao.findByPjjlx(pjjlx);
	}
	
	public Object saveJjlx(Jjlx jjlx) {
		return jjlxDao.saveJjlx(jjlx);
	}

	public boolean updateJjlx(Jjlx jjlx) throws Exception {
		Integer flag = jjlxDao.update(jjlx);
		if (flag != null) {
			return true;
		}
		return false;
	}
	
	public Jjlx findMcByDm(String code) {
		return jjlxDao.findMcByDm(code);
	}

}
