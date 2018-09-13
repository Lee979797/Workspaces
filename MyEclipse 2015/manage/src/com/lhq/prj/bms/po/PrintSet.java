package com.lhq.prj.bms.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PrintSet implements Serializable  {

	private int userid;
	private String bzjgdm;
	private int printerType;
	private String printPort;
	private int communicationPort;
	private int baudRate;
	
	public int getPrinterType() {
		return printerType;
	}

	public void setPrinterType(int printerType) {
		this.printerType = printerType;
	}

	public String getPrintPort() {
		return printPort;
	}

	public void setPrintPort(String printPort) {
		this.printPort = printPort;
	}

	public int getCommunicationPort() {
		return communicationPort;
	}

	public void setCommunicationPort(int communicationPort) {
		this.communicationPort = communicationPort;
	}

	public int getBaudRate() {
		return baudRate;
	}

	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	@Override
	public String toString() {
		return "PrintSet [userid=" + userid + ", bzjgdm=" + bzjgdm
				+ ", printerType=" + printerType + ", printPort=" + printPort
				+ ", communicationPort=" + communicationPort + ", baudRate="
				+ baudRate + "]";
	}

}
