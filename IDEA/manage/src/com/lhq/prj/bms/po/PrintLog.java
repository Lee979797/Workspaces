/*
 * @(#)PrintLog.java 2008-8-26 
 *
 * Copyright 2008 MTA, Inc. All rights reserved.
 */

package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

/**
 * �����¼
 * 
 * @author lhq
 * @version 1.0 ����03:25:39
 */
@SuppressWarnings("serial")
public class PrintLog implements Serializable {
	public PrintLog(Integer logId) {
		super();
		this.logId = logId;
	}

	public PrintLog() {
		super();
	}
 
	private Integer logId;
	private String centerId;
	private String orderId;
	private Integer orgId;
	private String orgName;
	private String orgCode;
	private Date printTime;
	private Integer printNum;
	private String printCode;
	private Date giveTime;
	private String printerId;
	private String printerName;
	private String note;


	public Date getPrintTime() {
		return printTime;
	}

	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	public String getCenterId() {
		return centerId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setGiveTime(Date giveTime) {
		this.giveTime = giveTime;
	}

	public Date getGiveTime() {
		return giveTime;
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
