package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Report implements Serializable  {

	//公共参数
	private String bzjgdm;
	private int num;
	private Date hd1;
	private Date hd2;
	
	//折线图参数
	private String bzjgmc;
	private String bzjgjc;
	
	//行政区划业务报表参数
	private String ywlx;
	private String xzqhName;
	private String xzqhCode;
	private int xbNum;
	private int njNum;
	private int bgNum;
	private int hzNum;
	private int bzNum;
	private int qrNum;
	private int qcNum;
	private int yfmNum;
	private int zxNum;
	private int plzxNum;
	
	public String getBzjgdm() {
		return bzjgdm;
	}
	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getHd1() {
		return hd1;
	}
	public void setHd1(Date hd1) {
		this.hd1 = hd1;
	}
	public Date getHd2() {
		return hd2;
	}
	public void setHd2(Date hd2) {
		this.hd2 = hd2;
	}
	public String getBzjgmc() {
		return bzjgmc;
	}
	public void setBzjgmc(String bzjgmc) {
		this.bzjgmc = bzjgmc;
	}
	public String getBzjgjc() {
		return bzjgjc;
	}
	public void setBzjgjc(String bzjgjc) {
		this.bzjgjc = bzjgjc;
	}
	public String getXzqhName() {
		return xzqhName;
	}
	public void setXzqhName(String xzqhName) {
		this.xzqhName = xzqhName;
	}
	public String getXzqhCode() {
		return xzqhCode;
	}
	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}
	public int getXbNum() {
		return xbNum;
	}
	public void setXbNum(int xbNum) {
		this.xbNum = xbNum;
	}
	public int getNjNum() {
		return njNum;
	}
	public void setNjNum(int njNum) {
		this.njNum = njNum;
	}
	public int getBgNum() {
		return bgNum;
	}
	public void setBgNum(int bgNum) {
		this.bgNum = bgNum;
	}
	public int getHzNum() {
		return hzNum;
	}
	public void setHzNum(int hzNum) {
		this.hzNum = hzNum;
	}
	public int getBzNum() {
		return bzNum;
	}
	public void setBzNum(int bzNum) {
		this.bzNum = bzNum;
	}
	public int getQrNum() {
		return qrNum;
	}
	public void setQrNum(int qrNum) {
		this.qrNum = qrNum;
	}
	public int getQcNum() {
		return qcNum;
	}
	public void setQcNum(int qcNum) {
		this.qcNum = qcNum;
	}
	public int getYfmNum() {
		return yfmNum;
	}
	public void setYfmNum(int yfmNum) {
		this.yfmNum = yfmNum;
	}
	public int getZxNum() {
		return zxNum;
	}
	public void setZxNum(int zxNum) {
		this.zxNum = zxNum;
	}
	public int getPlzxNum() {
		return plzxNum;
	}
	public void setPlzxNum(int plzxNum) {
		this.plzxNum = plzxNum;
	}
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	
}
