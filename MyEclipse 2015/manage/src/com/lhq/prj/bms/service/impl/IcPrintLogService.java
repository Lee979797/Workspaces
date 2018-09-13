package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IIcPrintLogDao;
import com.lhq.prj.bms.po.IcPrintLog;
import com.lhq.prj.bms.service.IIcPrintLogService;

public class IcPrintLogService implements IIcPrintLogService {
	private IIcPrintLogDao icPrintLogDao;

	public void setIcPrintLogDao(IIcPrintLogDao icPrintLogDao) {
		this.icPrintLogDao = icPrintLogDao;
	}

	public boolean saveICKxlh(IcPrintLog icPrintLog) {
		// TODO Auto-generated method stub
		IcPrintLog iPL = new IcPrintLog();
		iPL = icPrintLogDao.findByCondition(icPrintLog.getIckxlh());
		
		if(iPL == null){
			//第一次插入
			int s = icPrintLogDao.saveICKxlh(icPrintLog);
			//System.out.println("跟踪返回数据s:"+s);
			if(s<0){
				return false;
			}
			return true;
		}else{
			//表中已有数据，更新已存在数据
			int u = icPrintLogDao.updateICKxlh(icPrintLog);
			//System.out.println("跟踪返回数据u:"+u);
			if(u<0){
				return false;
			}
			return true;
		}
	}

	public Page findByPage(Page page) {
		// TODO Auto-generated method stub
		page.setRoot(icPrintLogDao.findByPage(page));
		page.setTotalProperty(icPrintLogDao.findByCount(page));
		return page;
	}
	
	
}
