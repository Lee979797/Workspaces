package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IBzjgallDao;
import com.lhq.prj.bms.po.Bzjgall;
import com.lhq.prj.bms.service.IBzjgallService;

/**
 * BzjgallService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class BzjgallService implements IBzjgallService {

	private IBzjgallDao bzjgallDao;

	public void setBzjgallDao(IBzjgallDao bzjgallDao) {
		this.bzjgallDao = bzjgallDao;
	}

	public boolean deleteBzjgall(Integer bzjgid) {
		Integer flag = bzjgallDao.deleteById(bzjgid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return bzjgallDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(bzjgallDao.findByPage(page));
		page.setTotalProperty(bzjgallDao.findByCount(page));
		return page;
	}
	
	public Object saveBzjgall(Bzjgall bzjgall) {
		return bzjgallDao.saveBzjgall(bzjgall);
	}

	public boolean updateBzjgall(Bzjgall bzjgall) throws Exception {
		Integer flag = bzjgallDao.update(bzjgall);
		if (flag != null) {
			return true;
		}
		return false;
	}

}
