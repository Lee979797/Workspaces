package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IBzjgDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.service.IBzjgService;

/**    
 * BzjgService.java Create on 2008-9-16 ����10:40:48   
 *
 *
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class BzjgService implements IBzjgService {
	
	private IBzjgDao bzjgDao;

	public void setBzjgDao(IBzjgDao bzjgDao) {
		this.bzjgDao = bzjgDao;
	}

	public boolean deleteBzjg(Integer bzjgId) {
		Integer flag = bzjgDao.deleteById(bzjgId);
		if(flag != null){
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
		if(flag != null){
			return true;
		}
		return false;
	}

	public Page findBzjgByCenter(Page page) {
		page.setRoot(bzjgDao.findBzjgByCenter((Center) page.getConditions().get(0)));
		return page;
	}


}
 