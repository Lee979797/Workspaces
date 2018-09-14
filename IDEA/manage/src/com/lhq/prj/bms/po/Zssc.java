/*
 * @(#)Zssc.java 2008-9-16 
 *
 * Copyright 2008 MTA, Inc. All rights reserved.
 */

package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

/**
 * ������
 * 
 * @author lhq
 * @version 1.0 ����04:49:30
 */
@SuppressWarnings("serial")
public class Zssc implements Serializable {
	public Zssc() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	private Integer id;
	private String qsbh;
	private String jzbh;
	private Integer zssl;
	private String zstype;
	private String fpbzjg;
	private String flag;
	private Date lrsj;
	private String note;
	
	public Integer getId() {
		return id;
	}

	public void setQsbh(String qsbh) {
		this.qsbh = qsbh;
	}

	public String getQsbh() {
		return qsbh;
	}

	public void setJzbh(String jzbh) {
		this.jzbh = jzbh;
	}

	public String getJzbh() {
		return jzbh;
	}

	public void setZssl(Integer zssl) {
		this.zssl = zssl;
	}

	public Integer getZssl() {
		return zssl;
	}

	public void setZstype(String zstype) {
		this.zstype = zstype;
	}

	public String getZstype() {
		return zstype;
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

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
