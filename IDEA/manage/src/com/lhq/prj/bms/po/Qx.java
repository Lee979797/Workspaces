package com.lhq.prj.bms.po;

import java.io.Serializable;

public class Qx implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bzjgCode;
	private String ywlxCode;
	private String ywlx;
	private int shbz;
	
	public String getBzjgCode() {
		return bzjgCode;
	}
	public void setBzjgCode(String bzjgCode) {
		this.bzjgCode = bzjgCode;
	}
	public String getYwlxCode() {
		return ywlxCode;
	}
	public void setYwlxCode(String ywlxCode) {
		this.ywlxCode = ywlxCode;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	public String getYwlx() {
		return ywlx;
	}
	public int getShbz() {
		return shbz;
	}
	public void setShbz(int shbz) {
		this.shbz = shbz;
	}
	@Override
	public String toString() {
		return "Qx [bzjgCode=" + bzjgCode + ", ywlxCode=" + ywlxCode
				+ ", shbz=" + shbz + "]";
	}
	
}
