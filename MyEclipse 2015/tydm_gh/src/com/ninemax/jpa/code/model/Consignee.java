package com.ninemax.jpa.code.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Table(name = "T_CONSIGNEE")
@Entity
public class Consignee implements Serializable{
	
	@javax.persistence.Column(name = "lsh")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer lsh;
	public Integer getLsh() {
		return lsh;
	}

	public void setLsh(Integer lsh) {
		this.lsh = lsh;
	}

	@javax.persistence.Column(name = "jgdm")
    @Basic
	private String jgdm;
	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	@javax.persistence.Column(name = "jgmc")
    @Basic
	private String jgmc;
	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	@javax.persistence.Column(name = "consigneeTime")
    @Basic
	private String consigneeTime;
	public String getConsigneeTime() {
		return consigneeTime;
	}

	public void setConsigneeTime(String consigneeTime) {
		this.consigneeTime = consigneeTime;
	}

	@javax.persistence.Column(name = "consigneeName")
    @Basic
	private String consigneeName;
	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	@javax.persistence.Column(name = "bzjgdm")
    @Basic
	private String bzjgdm;
	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}
	

	@javax.persistence.Column(name = "jkdh")
    @Basic
	private String jkdh;
	public String getJkdh() {
		return jkdh;
	}

	public void setJkdh(String jkdh) {
		this.jkdh = jkdh;
	}

	@javax.persistence.Column(name = "consigneeData")
    @Basic
	private String consigneeData;
	public String getConsigneeData() {
		return consigneeData;
	}

	public void setConsigneeData(String consigneeData) {
		this.consigneeData = consigneeData;
	}

	@javax.persistence.Column(name = "memo1")
    @Basic	
	private String memo1;
	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	@javax.persistence.Column(name = "memo2")
    @Basic	
	private String memo2;
	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	
	
	@javax.persistence.Column(name = "ydmzk")
    @Basic	
	private String ydmzk;
	
	
	public String getYdmzk() {
		return ydmzk;
	}

	public void setYdmzk(String ydmzk) {
		this.ydmzk = ydmzk;
	}

	
	@javax.persistence.Column(name = "mcbg")
    @Basic	
	private String mcbg;
	public String getMcbg() {
		return mcbg;
	}

	public void setMcbg(String mcbg) {
		this.mcbg = mcbg;
	}

	@javax.persistence.Column(name = "application")
    @Basic	
	private String application;
	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	@javax.persistence.Column(name = "sjdm")
    @Basic	
	private String sjdm;
	public String getSjdm() {
		return sjdm;
	}

	public void setSjdm(String sjdm) {
		this.sjdm = sjdm;
	}

	@javax.persistence.Column(name = "card")
    @Basic	
	private String card;
	public String getCard() {
		return card;
	}


	public void setCard(String card) {
		this.card = card;
	}

	
	@javax.persistence.Column(name = "dmwts")
    @Basic	
	private String dmwts;
	public String getDmwts() {
		return dmwts;
	}

	public void setDmwts(String dmwts) {
		this.dmwts = dmwts;
	}

	
	@javax.persistence.Column(name = "dwdb")
    @Basic
	private String dwdb;
	public String getDwdb() {
		return dwdb;
	}

	public void setDwdb(String dwdb) {
		this.dwdb = dwdb;
	}

	
	@javax.persistence.Column(name = "tbz")
    @Basic
	private String tbz;
	public String getTbz() {
		return tbz;
	}

	public void setTbz(String tbz) {
		this.tbz = tbz;
	}

	@javax.persistence.Column(name = "yhdw")
    @Basic
	private String yhdw;
	public String getYhdw() {
		return yhdw;
	}

	public void setYhdw(String yhdw) {
		this.yhdw = yhdw;
	}


	@javax.persistence.Column(name = "other")
    @Basic
	private String other;
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}



}
