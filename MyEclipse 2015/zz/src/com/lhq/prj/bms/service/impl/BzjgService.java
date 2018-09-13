package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IBzjgDao;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.service.IBzjgService;

/**
 * BzjgService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class BzjgService implements IBzjgService {

	private IBzjgDao bzjgDao;

	public void setBzjgDao(IBzjgDao bzjgDao) {
		this.bzjgDao = bzjgDao;
	}

	public boolean deleteBzjg(Integer bzjgid) {
		Integer flag = bzjgDao.deleteById(bzjgid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return bzjgDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(bzjgDao.findByPage(page));
		page.setTotalProperty(bzjgDao.findByCount(page));
		return page;
	}
	
	public Object saveBzjg(Bzjg bzjg) {
		return bzjgDao.saveBzjg(bzjg);
	}

	public boolean updateBzjg(Bzjg bzjg) throws Exception {
		Integer flag = bzjgDao.update(bzjg);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Bzjg findByBzjgdm(Bzjg bzjg) {
		// TODO Auto-generated method stub
		return bzjgDao.findByBzjgdm(bzjg);
	}

}
