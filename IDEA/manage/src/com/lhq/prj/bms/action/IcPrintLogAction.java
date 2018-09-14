package com.lhq.prj.bms.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IOrgnewDao;
import com.lhq.prj.bms.po.IcPrintLog;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.service.IIcPrintLogService;

public class IcPrintLogAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IIcPrintLogService icPrintLogService;
	private IOrgnewDao orgnewDao;
	private IcPrintLog icPrintLog;
	private boolean success;
	private Page page;
	
	private int klsh;//   卡流水号
	private String centerid;//
	private String orderId;//   -----     -----
	private String orgName;//   机构名称	jgmc ----
	private String orgCode;//   机构代码	jgdm----
	private Date printTime;// 打卡时间	当前系统时间
	private String ickxlh;//    卡序列号
	private String printerName;// 打卡人（当前系统登录用户） currentZzUsername
	private int flag;
	private String note;//
	
	
	public String saveICKxlh() throws Exception{
		//ickxlh,printerName,centerid,orgCode
		ickxlh = getRequest().getParameter("ickxlh");
		printerName = getRequest().getParameter("printerName");
		centerid = getRequest().getParameter("centerid");
		orgCode = getRequest().getParameter("orgCode");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(new Date());
		printTime = sdf.parse(str);
		
		Orgnew orgnew = new Orgnew();
		orgnew = orgnewDao.findByOrgnewJgdm(orgCode);
		orderId = orgnew.getOrderid();
		orgName = orgnew.getJgmc();
		
		icPrintLog = new IcPrintLog();
		icPrintLog.setCenterid(centerid);/////
		icPrintLog.setOrderId(orderId);
		icPrintLog.setOrgName(orgName);
		icPrintLog.setOrgCode(orgCode);/////
		icPrintLog.setPrintTime(printTime);////
		icPrintLog.setIckxlh(ickxlh);///
		icPrintLog.setPrinterName(printerName);////
		icPrintLog.setFlag(1);
		icPrintLog.setNote(note);
		//System.out.println("跟踪icPrintLog：："+icPrintLog);
		success = icPrintLogService.saveICKxlh(icPrintLog);
		
		return SUCCESS;
	}
	
	public String findAllIcPrintLog(){
		page = new Page();
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setConditions(conditions);
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = icPrintLogService.findByPage(page);
		return SUCCESS;
	}
	public String lossOrRecoverIC(){
		
		ickxlh = getRequest().getParameter("ickxlh");
		flag = Integer.valueOf(getRequest().getParameter("flag"));
		icPrintLog = new IcPrintLog();
		icPrintLog.setIckxlh(ickxlh);
		icPrintLog.setFlag(flag);
		success = icPrintLogService.saveICKxlh(icPrintLog);
		return SUCCESS;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getKlsh() {
		return klsh;
	}
	public void setKlsh(int klsh) {
		this.klsh = klsh;
	}
	public String getCenterid() {
		return centerid;
	}
	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public Date getPrintTime() {
		return printTime;
	}
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}
	public String getIckxlh() {
		return ickxlh;
	}
	public void setIckxlh(String ickxlh) {
		this.ickxlh = ickxlh;
	}
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setIcPrintLogService(IIcPrintLogService icPrintLogService) {
		this.icPrintLogService = icPrintLogService;
	}
	public void setOrgnewDao(IOrgnewDao orgnewDao) {
		this.orgnewDao = orgnewDao;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
