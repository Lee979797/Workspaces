/*
 * @(#)PrintLogAction.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.action;

import java.util.Date;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.PrintLog;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.service.IPrintLogService;

/**
 * Create on 2008-10-11 ����07:16:21
 * 
 * ͼ��軹����
 * 
 * @author �����
 * @version
 */
@SuppressWarnings("serial")
public class PrintLogAction extends BaseAction {

	private IPrintLogService printLogService;

	private boolean success;

	private Integer logId;

	private Page page;
	
	private PrintLog printLog;
	
	/** �鱾id */
	private Integer orgId;

	/** ���� 50 */
	private String orgName;
	
	/** ���� 50 */
	private String orgCode;

	/** ���ʱ�� */
	private Date printTime;

	/** ������� */
	private Integer printNum;

	/** Ԥ�ƻ���ʱ�� */
	private String printCode;

	/** ʵ�ʻ���ʱ�� */
	private Date giveTime;

	/** ������id */
	private String printerId;

	/** ������ 50 */
	private String printerName;

	/** ����Ա��� 50 */
	private String note;


	/**
	 * ����һ���軹��¼
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String savePrintLog() throws Exception {
		User user = (User) getSession().getAttribute("user");
		printLog.setPrintTime(new Date());
		printLog.setPrinterId(user.getUserName());
		printLog.setPrinterName(user.getEmplName());
		logId = (Integer) printLogService.savePrintLog(printLog,user.getBzjgCode());
		if (logId != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * ����ͼ��軹��¼
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findAllPrintLog() {
		String strOrgId = getRequest().getParameter("orgId");
		Orgnew orgnew = new Orgnew();
		if (strOrgId != null && !"".equals(strOrgId)) {
			orgnew.setOrgid(Integer.valueOf(strOrgId));
		}
		page = new Page();
		page.setObjCondition(orgnew);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 10 : limit);
		page = printLogService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * �޸Ľ軹��¼��Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePrintLog() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strLogId = getRequest().getParameter("logId");
		if (strLogId != null && !"".equals(strLogId)) {
			PrintLog printLog = new PrintLog();
			printLog.setLogId(Integer.valueOf(strLogId));
			MyUtils.invokeSetMethod(fieldName, printLog, new Object[] { fieldValue });
			success = printLogService.updatePrintLog(printLog);
		}
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public PrintLog getPrintLog() {
		return printLog;
	}

	public void setPrintLog(PrintLog printLog) {
		this.printLog = printLog;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setPrintLogService(IPrintLogService printLogService) {
		this.printLogService = printLogService;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintNum(Integer printNum) {
		this.printNum = printNum;
	}

	public Integer getPrintNum() {
		return printNum;
	}

	public void setPrintCode(String printCode) {
		this.printCode = printCode;
	}

	public String getPrintCode() {
		return printCode;
	}

	public void setGiveTime(Date giveTime) {
		this.giveTime = giveTime;
	}

	public Date getGiveTime() {
		return giveTime;
	}


	public void setPrinterId(String printerId) {
		this.printerId = printerId;
	}

	public String getPrinterId() {
		return printerId;
	}

	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	public String getPrinterName() {
		return printerName;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

}
