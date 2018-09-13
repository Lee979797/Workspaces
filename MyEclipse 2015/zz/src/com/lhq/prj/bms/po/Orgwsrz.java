package com.lhq.prj.bms.po;

import java.util.Date;

public class Orgwsrz {
	private int rzid;
	private String orderid;
	private String jgdm;
	private String jgmc;
	private String ywlx;
	private Date handleDate;
	private String handleUsername;
	private Date auditDate;
	private String auditUsername;
	private String auditNote;
	private Date lrDate;
	private String lry;
	
	public int getRzid() {
		return rzid;
	}
	public void setRzid(int rzid) {
		this.rzid = rzid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public Date getHandleDate() {
		return handleDate;
	}
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	public String getHandleUsername() {
		return handleUsername;
	}
	public void setHandleUsername(String handleUsername) {
		this.handleUsername = handleUsername;
	}
	public Date getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	public String getAuditUsername() {
		return auditUsername;
	}
	public void setAuditUsername(String auditUsername) {
		this.auditUsername = auditUsername;
	}
	public String getAuditNote() {
		return auditNote;
	}
	public void setAuditNote(String auditNote) {
		this.auditNote = auditNote;
	}
	
	public Date getLrDate() {
		return lrDate;
	}
	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}
	public String getLry() {
		return lry;
	}
	public void setLry(String lry) {
		this.lry = lry;
	}
	@Override
	public String toString() {
		return "Orgwsrz [rzid=" + rzid + ", orderid=" + orderid + ", jgdm="
				+ jgdm + ", jgmc=" + jgmc + ", ywlx=" + ywlx + ", handleDate="
				+ handleDate + ", handleUsername=" + handleUsername
				+ ", auditDate=" + auditDate + ", auditUsername="
				+ auditUsername + ", auditNote=" + auditNote + ", lrDate="
				+ lrDate + ", lry=" + lry + "]";
	}

}
