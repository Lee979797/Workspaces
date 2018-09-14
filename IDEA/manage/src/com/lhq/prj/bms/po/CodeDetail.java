/*
 * @(#)CodeDetail.java 2012-12-19 
 *
 * Copyright 2012 YQ.
 */

package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 赋码情况
 * 
 * @author lhq
 * @version 1.0 ����03:25:39
 */
@SuppressWarnings("serial")
public class CodeDetail implements Serializable {
	public CodeDetail(Integer id) {
		super();
		this.id = id;
	}

	public CodeDetail() {
		super();
	}

	
	private Integer id;
	private String jgdm;
	private String jgmc;
	private String zch;
	private String dmlx;
	private String bzjgdm;
	private String fumaUsername;
	private String fumaName;
	private Date fumaDate;
	private String isFuma;
	private String flag;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setZch(String zch) {
		this.zch = zch;
	}

	public String getZch() {
		return zch;
	}

	public void setDmlx(String dmlx) {
		this.dmlx = dmlx;
	}

	public String getDmlx() {
		return dmlx;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setFumaDate(Date fumaDate) {
		this.fumaDate = fumaDate;
	}

	public Date getFumaDate() {
		return fumaDate;
	}

	public void setFumaUsername(String fumaUsername) {
		this.fumaUsername = fumaUsername;
	}

	public String getFumaUsername() {
		return fumaUsername;
	}

	public void setFumaName(String fumaName) {
		this.fumaName = fumaName;
	}

	public String getFumaName() {
		return fumaName;
	}

	public void setIsFuma(String isFuma) {
		this.isFuma = isFuma;
	}

	public String getIsFuma() {
		return isFuma;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}
}
