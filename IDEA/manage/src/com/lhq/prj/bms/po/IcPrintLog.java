package com.lhq.prj.bms.po;

import java.util.Date;

public class IcPrintLog {
	private int klsh;//   卡流水号
	private String centerid;//
	private String orderId;//    
	private String orgName;//   机构名称	jgmc
	private String orgCode;//   机构代码	jgdm
	private Date printTime;// 打卡时间	当前系统时间
	private String ickxlh;//    卡序列号
	private String printerName;// 打卡人（当前系统登录用户） currentZzUsername
	private int flag;//1表示使用中  0表示挂失
	private String note;//
	
	public int getKlsh() {
		return klsh;
	}
	public void setKlsh(int klsh) {
		this.klsh = klsh;
	}
	public String getCenterid() {
		return centerid;
	}
	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public Date getPrintTime() {
		return printTime;
	}
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}
	public String getIckxlh() {
		return ickxlh;
	}
	public void setIckxlh(String ickxlh) {
		this.ickxlh = ickxlh;
	}
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "IcPrintLog [klsh=" + klsh + ", centerid=" + centerid
				+ ", orderId=" + orderId + ", orgName="
				+ orgName + ", orgCode=" + orgCode + ", printTime=" + printTime
				+ ", ickxlh=" + ickxlh + ", printerName=" + printerName
				+ ", flag=" + flag + ", note=" + note + "]";
	}
}
