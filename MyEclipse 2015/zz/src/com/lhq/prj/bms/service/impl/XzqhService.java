package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IXzqhDao;
import com.lhq.prj.bms.po.Xzqh;
import com.lhq.prj.bms.service.IXzqhService;

/**
 * XzqhService.java Create on 2012-5-5
 * 
 * 职务业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class XzqhService implements IXzqhService {

	private IXzqhDao xzqhDao;

	public void setXzqhDao(IXzqhDao xzqhDao) {
		this.xzqhDao = xzqhDao;
	}

	public boolean deleteXzqh(Integer xzqhId) {
		Integer flag = xzqhDao.deleteById(xzqhId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return xzqhDao.findAll();
	}

	public Object saveXzqh(Xzqh xzqh) {
		return xzqhDao.saveXzqh(xzqh);
	}

	public boolean updateXzqh(Xzqh xzqh) throws Exception {
		Integer flag = xzqhDao.update(xzqh);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(xzqhDao.findByPage(page));
		page.setTotalProperty(xzqhDao.findByCount(page));
		return page;
	}

}
