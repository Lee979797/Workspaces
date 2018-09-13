/*
 * @(#)CodeManage.java 2008-9-16 
 *
 * Copyright 2008 MTA, Inc. All rights reserved.
 */

package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

/**
 *码段管理
 * 
 * @author lhq
 * @version 1.0 ����04:49:30
 */
@SuppressWarnings("serial")
public class CodeManage implements Serializable {
	public CodeManage() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	private Integer id;
	private String centerid;
	private String qsdm;
	private String jzdm;
	private Integer dmsl;
	private String fmtype;
	private String fmjgdm;
	private String fmjgmc;
	private String fpbzjg;
	private String flag;
	private Date lrsj;
	private Integer userid;
	private String username;
	private String name;
	private String note;
	
	public Integer getId() {
		return id;
	}

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public String getCenterid() {
		return centerid;
	}

	public void setQsdm(String qsdm) {
		this.qsdm = qsdm;
	}

	public String getQsdm() {
		return qsdm;
	}

	public void setJzdm(String jzdm) {
		this.jzdm = jzdm;
	}

	public String getJzdm() {
		return jzdm;
	}

	public void setDmsl(Integer dmsl) {
		this.dmsl = dmsl;
	}

	public Integer getDmsl() {
		return dmsl;
	}

	public void setFmtype(String fmtype) {
		this.fmtype = fmtype;
	}

	public String getFmtype() {
		return fmtype;
	}

	public void setFmjgdm(String fmjgdm) {
		this.fmjgdm = fmjgdm;
	}

	public String getFmjgdm() {
		return fmjgdm;
	}

	public void setFmjgmc(String fmjgmc) {
		this.fmjgmc = fmjgmc;
	}

	public String getFmjgmc() {
		return fmjgmc;
	}

	public void setFpbzjg(String fpbzjg) {
		this.fpbzjg = fpbzjg;
	}

	public String getFpbzjg() {
		return fpbzjg;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

	public Date getLrsj() {
		return lrsj;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
