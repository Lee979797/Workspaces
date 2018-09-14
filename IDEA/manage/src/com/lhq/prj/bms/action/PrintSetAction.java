package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.po.PrintSet;
import com.lhq.prj.bms.service.IPrintSetService;

public class PrintSetAction extends BaseAction {
	
	private IPrintSetService printSetService;
	private PrintSet printset;
	private boolean success;
	private int printerType;
	private String printPort;
	private int communicationPort;
	private int baudRate;
	
	@SuppressWarnings("unchecked")
	public String findCardPrintSet(){
		
		String username = getRequest().getParameter("username");
		printset = printSetService.findCardPrintSet(username);
		
		return SUCCESS;
	}
	public String saveCardPrintSet(){
		
		String username = getRequest().getParameter("username");
		String bzjgdm = getRequest().getParameter("bzjgdm");
		
		printset = new PrintSet();
		printset.setBzjgdm(bzjgdm);
		printset.setPrinterType(printerType);
		printset.setPrintPort(printPort);
		printset.setCommunicationPort(communicationPort);
		printset.setBaudRate(baudRate);
		
		success = printSetService.saveCardPrintSet(username,printset);
		
		return SUCCESS;
	}

	public PrintSet getPrintset() {
		return printset;
	}
	public void setPrintset(PrintSet printset) {
		this.printset = printset;
	}
	public void setPrintSetService(IPrintSetService printSetService) {
		this.printSetService = printSetService;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
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

}
