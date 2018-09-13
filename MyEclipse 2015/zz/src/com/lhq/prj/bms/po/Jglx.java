package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Jglx.java Create on 2008-9-18 下午08:02:11
 * 
 * 职务
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Jglx implements Serializable {

	public Jglx() {
	}

	public Jglx(Integer jglxid,String jglxdm, String jglxmc, String pjglxdm, String pjglxmc,String ojglxdm, String ojglxmc, String note) {
		this.jglxid = jglxid;
		this.jglxdm = jglxdm;
		this.jglxmc = jglxmc;
		this.jglxdm = pjglxdm;
		this.jglxmc = pjglxmc;
		this.jglxdm = ojglxdm;
		this.jglxmc = ojglxmc;
		this.note=note;
	}

	private Integer jglxid;

	private String jglxdm;

	private String jglxmc;
	
	private String pjglxdm;

	private String pjglxmc;
	
	private String ojglxdm;

	private String ojglxmc;
	
	private String note;

	
	public Integer getJglxid() {
		return jglxid;
	}
	
	public void setJglxid(Integer jglxid) {
		this.jglxid = jglxid;
	}
	

	public String getJglxmc() {
		return jglxmc;
	}

	public void setJglxmc(String jglxmc) {
		this.jglxmc = jglxmc;
	}

	public String getJglxdm() {
		return jglxdm;
	}

	public void setJglxdm(String jglxdm) {
		this.jglxdm = jglxdm;
	}

	public void setPjglxdm(String pjglxdm) {
		this.pjglxdm = pjglxdm;
	}

	public String getPjglxdm() {
		return pjglxdm;
	}

	public void setPjglxmc(String pjglxmc) {
		this.pjglxmc = pjglxmc;
	}

	public String getPjglxmc() {
		return pjglxmc;
	}

	public void setOjglxdm(String ojglxdm) {
		this.ojglxdm = ojglxdm;
	}

	public String getOjglxdm() {
		return ojglxdm;
	}

	public void setOjglxmc(String ojglxmc) {
		this.ojglxmc = ojglxmc;
	}

	public String getOjglxmc() {
		return ojglxmc;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
