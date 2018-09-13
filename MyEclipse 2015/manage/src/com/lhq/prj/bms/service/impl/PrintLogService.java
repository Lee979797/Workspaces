/*
 * @(#)PrintLogService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.dao.IPrintLogDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.PrintLog;
import com.lhq.prj.bms.service.IPrintLogService;

/**    
 * Create on 2008-10-11 ����07:11:35
 *
 * ͼ��軹��¼ҵ���ʵ����
 *
 * @author �����
 * @version  1.0
 */
public class PrintLogService implements IPrintLogService {
	
	private IPrintLogDao printLogDao;
	
	private IOrgnewDao orgnewDao;

	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}

	public void setPrintLogDao(IPrintLogDao printLogDao) {
		this.printLogDao = printLogDao;
	}

	public boolean deletePrintLog(Integer logId) {
		Integer flag = printLogDao.deleteById(logId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(printLogDao.findByPage(page));
		page.setTotalProperty(printLogDao.findByCount(page));
		return page;
	}

	public Object savePrintLog(PrintLog printlog,String bzjgdm) throws Exception {
		Object flag = printLogDao.savePrintLog(printlog,bzjgdm);
		if(flag != null){
			Orgnew orgnew = new Orgnew(printlog.getOrgId());
			orgnew.setDybz("Y");
			orgnewDao.update(orgnew);
		}
		return flag;
	}

	public boolean updatePrintLog(PrintLog printlog) throws Exception {
		Integer flag = printLogDao.update(printlog);
		if (null != flag) {
			return true;
		}
		return false;
	}

}
 