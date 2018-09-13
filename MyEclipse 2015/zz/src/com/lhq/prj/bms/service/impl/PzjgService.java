package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IPzjgDao;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.service.IPzjgService;

/**
 * PzjgService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class PzjgService implements IPzjgService {

	private IPzjgDao pzjgDao;

	public void setPzjgDao(IPzjgDao pzjgDao) {
		this.pzjgDao = pzjgDao;
	}

	public boolean deletePzjg(Integer pzjgid) {
		Integer flag = pzjgDao.deleteById(pzjgid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return pzjgDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(pzjgDao.findByPage(page));
		page.setTotalProperty(pzjgDao.findByCount(page));
		return page;
	}
	
	public Object savePzjg(Pzjg pzjg) {
		return pzjgDao.savePzjg(pzjg);
	}

	public boolean updatePzjg(Pzjg pzjg) throws Exception {
		Integer flag = pzjgDao.update(pzjg);
		if (flag != null) {
			return true;
		}
		return false;
	}

}
