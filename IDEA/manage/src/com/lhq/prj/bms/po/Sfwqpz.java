package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.util.Date;

/**
 * Sfwqpz.java Create on 2012-5-5
 * 
 * 档案临时类
 * 
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Sfwqpz implements Serializable {

	private Integer DID;
	private String PZNAME;
	private Integer CCFS;
	private Integer  DBTYPE;
	private String   SERVERADDR;
	private  String  USERNAME;
	private  String  PASSWD;
	private  String  SAVEDBNAME;
	private  String  PORT;
	private  Integer  ISDEFAULT;
	
	public Sfwqpz() {
	}
	
	public Integer getDID() {
		return DID;
	}
	public void setDID(Integer DID) {
		this.DID = DID;
	}

	public void setPZNAME(String pZNAME) {
		PZNAME = pZNAME;
	}

	public String getPZNAME() {
		return PZNAME;
	}

	public void setCCFS(Integer cCFS) {
		CCFS = cCFS;
	}

	public Integer getCCFS() {
		return CCFS;
	}

	public void setDBTYPE(Integer dBTYPE) {
		DBTYPE = dBTYPE;
	}

	public Integer getDBTYPE() {
		return DBTYPE;
	}

	public void setSERVERADDR(String sERVERADDR) {
		SERVERADDR = sERVERADDR;
	}

	public String getSERVERADDR() {
		return SERVERADDR;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}

	public String getPASSWD() {
		return PASSWD;
	}

	public void setSAVEDBNAME(String sAVEDBNAME) {
		SAVEDBNAME = sAVEDBNAME;
	}

	public String getSAVEDBNAME() {
		return SAVEDBNAME;
	}

	public void setPORT(String pORT) {
		PORT = pORT;
	}

	public String getPORT() {
		return PORT;
	}

	public void setISDEFAULT(Integer iSDEFAULT) {
		ISDEFAULT = iSDEFAULT;
	}

	public Integer getISDEFAULT() {
		return ISDEFAULT;
	}

	
}
