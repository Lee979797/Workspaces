package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.dao.IQxDao;
import com.lhq.prj.bms.po.Qx;
import com.lhq.prj.bms.service.IQxService;

public class QxService implements IQxService {
	private IQxDao qxDao;
	public void setQxDao(IQxDao qxDao) {
		this.qxDao = qxDao;
	}

	public boolean saveQxSet(Qx qx) {
		boolean flag = false;
		int s = qxDao.saveQxSet(qx);
		if(s > 0){
			flag = true;
		}
		return flag;
	}

	public void deleteByBzjgCode(Qx qx) {
		qxDao.deleteByBzjgCode(qx);
	}

	public List findByBzjgCode(Qx qx) {
		List ywCodes = qxDao.findByBzjgCode(qx);
		return ywCodes;
	}

}
