package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IHylxDao;
import com.lhq.prj.bms.po.Hylx;
import com.lhq.prj.bms.po.Jjlx;
import com.lhq.prj.bms.service.IHylxService;

/**
 * HylxService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class HylxService implements IHylxService {

	private IHylxDao hylxDao;

	public void setHylxDao(IHylxDao hylxDao) {
		this.hylxDao = hylxDao;
	}

	public boolean deleteHylx(Integer hylxid) {
		Integer flag = hylxDao.deleteById(hylxid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return hylxDao.findAll();
	}
	
	public Page findByPage(Page page) {
		page.setRoot(hylxDao.findByPage(page));
		page.setTotalProperty(hylxDao.findByCount(page));
		return page;
	}
	
	public List findByHylx1(String hylx1) {
		return hylxDao.findByHylx1(hylx1);
	}
	
	public Object saveHylx(Hylx hylx) {
		return hylxDao.saveHylx(hylx);
	}

	public boolean updateHylx(Hylx hylx) throws Exception {
		Integer flag = hylxDao.update(hylx);
		if (flag != null) {
			return true;
		}
		return false;
	}
	
	public Hylx findMcByDm(String code) {
		return hylxDao.findMcByDm(code);
	}
	

}
