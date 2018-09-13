package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IKeyLogDao;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.KeyLog;
import com.lhq.prj.bms.service.IKeyLogService;

/**    
 * KeyLogService.java Create on 2008-9-16 ����10:40:48   
 *
 *
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class KeyLogService implements IKeyLogService {
	
	private IKeyLogDao keyLogDao;

	public void setKeyLogDao(IKeyLogDao keyLogDao) {
		this.keyLogDao = keyLogDao;
	}

	public boolean deleteKeyLog(Integer keyLogId) {
		Integer flag = keyLogDao.deleteById(keyLogId);
		if(flag != null){
			return true;
		}
		return false;
	}

	public List findAll() {
		return keyLogDao.findAll();
	}

	public Page findByPage(Page page) {
		page.setRoot(keyLogDao.findByPage(page));
		page.setTotalProperty(keyLogDao.findByCount(page));
		return page;
	}

	public Object saveKeyLog(KeyLog keyLog) {
		return keyLogDao.saveKeyLog(keyLog);
	}

	public boolean updateKeyLog(KeyLog keyLog) throws Exception {
		Integer flag = keyLogDao.update(keyLog);
		if(flag != null){
			return true;
		}
		return false;
	}

	public Page findKeyLogByCenter(Page page) {
		page.setRoot(keyLogDao.findKeyLogByCenter((Center) page.getConditions().get(0)));
		return page;
	}


}
 