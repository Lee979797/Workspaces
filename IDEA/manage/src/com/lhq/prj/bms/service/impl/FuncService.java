package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.dao.IFuncDao;
import com.lhq.prj.bms.po.Func;
import com.lhq.prj.bms.service.IFuncService;

/**
 * FuncService.java Create on 2008-9-18 ����08:15:34
 * 
 * ְ��ҵ���ʵ����
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class FuncService implements IFuncService {

	private IFuncDao funcDao;

	public void setFuncDao(IFuncDao funcDao) {
		this.funcDao = funcDao;
	}

	public boolean deleteFunc(Integer funcId) {
		Integer flag = funcDao.deleteById(funcId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return funcDao.findAll();
	}

	public Object saveFunc(Func func) {
		return funcDao.saveFunc(func);
	}

	public boolean updateFunc(Func func) throws Exception {
		Integer flag = funcDao.update(func);
		if (flag != null) {
			return true;
		}
		return false;
	}

}
