package com.lhq.prj.bms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Report;
import com.lhq.prj.bms.service.IReportService;

public class ReportAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IReportService reportService;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:m:s");
	private List con;
	
	public String findByHandleDate() throws ParseException{
		
		Report report = new Report();
		report.setHd1(sdf.parse(getRequest().getParameter("handleDate1")));
		report.setHd2(sdf.parse(getRequest().getParameter("handleDate2")+" 23:59:59"));
		
		con = reportService.findByHandleDate(report);
		
		return SUCCESS;
	}
	
	public String findXzqhYwReport() throws ParseException{
		
		Report report = new Report();
		report.setBzjgdm(getRequest().getParameter("bzjgdm"));
		report.setHd1(sdf.parse(getRequest().getParameter("hd1")+" 00:00:00"));
		report.setHd2(sdf.parse(getRequest().getParameter("hd2")+" 23:59:59"));
		
		con = reportService.findXzqhYwReport(report);
		return SUCCESS;
	}
	
	
	
	

	public List getCon() {
		return con;
	}
	public void setCon(List con) {
		this.con = con;
	}
	public void setReportService(IReportService reportService) {
		this.reportService = reportService;
	}
}
