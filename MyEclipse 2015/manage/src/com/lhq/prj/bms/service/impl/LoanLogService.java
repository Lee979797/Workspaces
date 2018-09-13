/*
 * @(#)LoanLogService.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.dao.ILoanLogDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.LoanLog;
import com.lhq.prj.bms.service.ILoanLogService;

/**    
 * Create on 2008-10-11 ����07:11:35
 *
 * ͼ��軹��¼ҵ���ʵ����
 *
 * @author �����
 * @version  1.0
 */
public class LoanLogService implements ILoanLogService {
	
	private ILoanLogDao loanLogDao;
	
	private IOrgnewDao orgnewDao;

	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}

	public void setLoanLogDao(ILoanLogDao loanLogDao) {
		this.loanLogDao = loanLogDao;
	}

	public boolean deleteLoanLog(Integer logId) {
		Integer flag = loanLogDao.deleteById(logId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(loanLogDao.findByPage(page));
		page.setTotalProperty(loanLogDao.findByCount(page));
		return page;
	}

	public Object saveLoanLog(LoanLog loanlog) throws Exception {
		Object flag = loanLogDao.saveLoanLog(loanlog);
		if(flag != null){
//			Orgnew book = new Orgnew(loanlog.getOrgnewId());
//			book.setLogId((Integer)flag);
//			book.setCurrentReaderId(loanlog.getReaderId());
//			book.setCurrentReader(loanlog.getReader());
//			book.setState(0);
//			bookDao.update(book);
		}
		return flag;
	}

	public boolean updateLoanLog(LoanLog loanlog) throws Exception {
		Integer flag = loanLogDao.update(loanlog);
		if (null != flag) {
			return true;
		}
		return false;
	}

}
 