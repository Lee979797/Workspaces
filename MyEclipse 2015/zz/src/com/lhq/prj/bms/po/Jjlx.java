package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * Jjlx.java Create on 2008-9-18 下午08:02:11
 * 
 * 职务
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author 廖瀚卿
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Jjlx implements Serializable {

	public Jjlx() {
	}

	public Jjlx(Integer jjlxid,String jjlxdm, String jjlxmc, String pjjlxdm, String pjjlxmc,String ojjlxdm, String ojjlxmc, String note, String pjjlxmc2,String pjjlxdm2, String pjjlxmc3, String pjjlxdm3) {
		this.jjlxid = jjlxid;
		this.jjlxdm = jjlxdm;
		this.jjlxmc = jjlxmc;
		this.pjjlxdm = pjjlxdm;
		this.pjjlxmc = pjjlxmc;
		this.ojjlxdm = ojjlxdm;
		this.pjjlxdm = ojjlxmc;
		this.note=note;
		this.pjjlxmc2=pjjlxmc2;
		this.pjjlxdm2=pjjlxdm2;
		this.pjjlxmc3=pjjlxmc3;
		this.pjjlxdm3=pjjlxdm3;
	}

	private Integer jjlxid;

	private String jjlxdm;

	private String jjlxmc;
	
	private String pjjlxdm;

	private String pjjlxmc;
	
	private String pjjlxmc2;
	
	private String pjjlxdm2;
	
	private String pjjlxmc3;
	
	private String pjjlxdm3;
	
	private String ojjlxdm;

	private String ojjlxmc;
	
	private String note;

	
	public Integer getJjlxid() {
		return jjlxid;
	}
	
	public void setJjlxid(Integer jjlxid) {
		this.jjlxid = jjlxid;
	}
	

	public String getJjlxmc() {
		return jjlxmc;
	}

	public void setJjlxmc(String jjlxmc) {
		this.jjlxmc = jjlxmc;
	}

	public String getJjlxdm() {
		return jjlxdm;
	}

	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}

	public void setPjjlxdm(String pjjlxdm) {
		this.pjjlxdm = pjjlxdm;
	}

	public String getPjjlxdm() {
		return pjjlxdm;
	}

	public void setPjjlxmc(String pjjlxmc) {
		this.pjjlxmc = pjjlxmc;
	}

	public String getPjjlxmc() {
		return pjjlxmc;
	}

	public void setPjjlxmc2(String pjjlxmc2) {
		this.pjjlxmc2 = pjjlxmc2;
	}

	public String getPjjlxmc2() {
		return pjjlxmc2;
	}

	public void setPjjlxmc3(String pjjlxmc3) {
		this.pjjlxmc3 = pjjlxmc3;
	}

	public String getPjjlxmc3() {
		return pjjlxmc3;
	}

	public void setOjjlxdm(String ojjlxdm) {
		this.ojjlxdm = ojjlxdm;
	}

	public String getOjjlxdm() {
		return ojjlxdm;
	}

	public void setOjjlxmc(String ojjlxmc) {
		this.ojjlxmc = ojjlxmc;
	}

	public String getOjjlxmc() {
		return ojjlxmc;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setPjjlxdm2(String pjjlxdm2) {
		this.pjjlxdm2 = pjjlxdm2;
	}

	public String getPjjlxdm2() {
		return pjjlxdm2;
	}

	public void setPjjlxdm3(String pjjlxdm3) {
		this.pjjlxdm3 = pjjlxdm3;
	}

	public String getPjjlxdm3() {
		return pjjlxdm3;
	}
}
