package com.lhq.prj.bms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IPrintLogDao;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.dao.ILoanLogDao;
import com.lhq.prj.bms.po.CodeDetail;
import com.lhq.prj.bms.po.PrintLog;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.LoanLog;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.ITjgdmService;
import com.opensymphony.xwork2.ActionContext;


/**
 * TjgdmService.java Create on 2012-5-12
 * 
 * 机构管理业务层
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class TjgdmService implements ITjgdmService {

	private ITjgdmDao tjgdmDao;

	private ILoanLogDao loanLogDao;
	private IPrintLogDao printLogDao;
	
	private Map appSysConfig;

	public void setLoanLogDao(ILoanLogDao loanLogDao) {
		this.loanLogDao = loanLogDao;
	}

	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}

	public void setPrintLogDao(IPrintLogDao printLogDao) {
		this.printLogDao = printLogDao;
	}

	public boolean deleteTjgdm(String rootPath, Integer orgid) {
		Tjgdm tjgdm = tjgdmDao.findById(orgid);
		Integer flag = tjgdmDao.deleteById(orgid);
		if (null != flag) {
			return MyUtils.delFile(rootPath + tjgdm.getImageUrl());
		}
		return false;
	}

	public Page findByPage(Page page) {
		String strBzjgdm=page.getBzjgdm();
		String strUserName=page.getUsername();
		if(strUserName=="admin" || "admin".equals(strUserName)){
			strBzjgdm=null;
		}else{
			appSysConfig = ActionContext.getContext().getApplication();
			if(!"1".equals(appSysConfig.get("sysBzjgLimitMode"))){
				strBzjgdm=null;
			}
		}
		page.setBzjgdm(strBzjgdm);
		page.setRoot(tjgdmDao.findByPage(page));
		page.setTotalProperty(tjgdmDao.findByCount(page));
		return page;
	}

	public Page findByDmmdPage(Page page) {
		page.setRoot(tjgdmDao.findByDmmdPage(page));
		page.setTotalProperty(tjgdmDao.findByDmmdCount(page));
		return page;
	}
	
	public Object saveTjgdm(Tjgdm tjgdm) {
		return tjgdmDao.saveTjgdm(tjgdm);
	}

	public boolean updateTjgdm(Tjgdm tjgdm) throws Exception {
		Integer flag = tjgdmDao.update(tjgdm);
		if (null != flag) {
			return true;
		}
		return false;
	}
    
	//搁置申请或取消申请，按机构代码
	public boolean returnTjgdm(Tjgdm tjgdm) throws Exception {
		String strHandleNote=tjgdm.getHandleNote();
		if(strHandleNote!=null){
			tjgdm.setState("0");  //搁置申请中
		}else{
			tjgdm.setState("100"); //正常
			tjgdm.setHandleNote("");  //搁置取消
			tjgdm.setHandleNote("");
			tjgdm.setHandleUserid("");
			tjgdm.setHandleUsername("");
			tjgdm.setHandleName("");
			tjgdm.setHandleDate(null);
		}
		Integer flag = tjgdmDao.update(tjgdm);
		//日志记载
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	//搁置
	public boolean returnTjgdmNo(Tjgdm tjgdm) throws Exception {
		String strMemo3=tjgdm.getMemo3();
		if(strMemo3=="1" || "1".equals(strMemo3)){
			tjgdm.setMemo3("");
			tjgdm.setState("-100");  //搁置申请中
		}else{
			tjgdm.setMemo3("");
			tjgdm.setState("100"); //正常
			tjgdm.setHandleNote("");
			tjgdm.setHandleUserid("");
			tjgdm.setHandleUsername("");
			tjgdm.setHandleName("");
			tjgdm.setHandleDate(null);
		}
		Integer flag = tjgdmDao.update(tjgdm);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	//搁置恢复
	public boolean returnTjgdmOk(Tjgdm tjgdm) throws Exception {
		tjgdm.setState("100");
		tjgdm.setHandleNote("");
		tjgdm.setHandleUserid("");
		tjgdm.setHandleUsername("");
		tjgdm.setHandleName("");
		tjgdm.setHandleDate(null);
		Integer flag = tjgdmDao.update(tjgdm);
		//日志
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	//废置恢复申请，或者取消申请
	public boolean returnTjgdmFeizhiHuifuSq(Tjgdm tjgdm) throws Exception {
		String strHandleNote=tjgdm.getHandleNote();
		if(strHandleNote!=null){
			tjgdm.setState("1");  //搁置申请中
		}else{
			tjgdm.setState("200"); //取消申请
			tjgdm.setHandleNote("");
			tjgdm.setHandleUserid("");
			tjgdm.setHandleUsername("");
			tjgdm.setHandleName("");
			tjgdm.setHandleDate(null);
		}
		Integer flag = tjgdmDao.update(tjgdm);
		return flag == null ? false:true;
	}
	
	//废置正式取消，转正常
	public boolean returnTjgdmFeizhiHuifu(Tjgdm tjgdm) throws Exception {
		String strAuditNote=tjgdm.getAuditNote();
		if(strAuditNote!=null){
			tjgdm.setState("200"); //已注销
		}else{
			tjgdm.setState("100");  //注销取消
			tjgdm.setAuditNote(""); 
			tjgdm.setAuditUserid("");
			tjgdm.setAuditUsername("");
			tjgdm.setAuditName("");
			tjgdm.setAuditDate(null);
		}
		Integer flag = tjgdmDao.update(tjgdm);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	
	public boolean returnTjgdmPrint(Tjgdm tjgdm) throws Exception {
		Integer strOrgid=tjgdm.getOrgid();
		
		String strPrinterId=tjgdm.getHandleUsername();
		String strPrinterName=tjgdm.getHandleName();
		Tjgdm tjgdm2 = new Tjgdm();
		tjgdm2 = tjgdmDao.findById(tjgdm.getOrgid());
		tjgdm2.setDybz("N");
		tjgdm2.setCzshbz(0);
		Integer flag = tjgdmDao.update(tjgdm2);
		
		if (null != flag) {
			String strCenterid=tjgdm2.getCenterid();
			String strOrgName=tjgdm2.getJgmc();
			String strOrgCode=tjgdm2.getJgdm();
			String strOrderId=tjgdm2.getOrderid();
			
			PrintLog printLog = new PrintLog();
			printLog.setCenterId(strCenterid);
			printLog.setOrderId(strOrderId);
			printLog.setOrgId(strOrgid);
			printLog.setOrgName(strOrgName);
			printLog.setOrgCode(strOrgCode);
			printLog.setPrintTime(new Date());
			printLog.setPrinterId(strPrinterId);
			printLog.setPrinterName(strPrinterName);
			printLog.setPrintTime(new Date());
	
 			Integer logId = (Integer) printLogDao.savePrintLog(printLog,tjgdm2.getBzjgdm());
			
			PrintLog printLog2 = new PrintLog();
			printLog2 = printLogDao.findById(logId);
			tjgdm2.setMemo4(printLog2.getPrintCode());
			tjgdmDao.update(tjgdm2);
		}
		
		/*tjgdm.setState("6");
		tjgdm.setDybz("Y");  //打印标志
		Integer flag = tjgdmDao.update(tjgdm);*/
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	public boolean returnTjgdmGo(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
		//yangqi需要判断 ?????????????
		//String strState=tjgdm.getState();	
		//if(strState=="6"){
			tjgdm.setState("7");
			//tjgdm.setCurrentReader("");// 清空当前日志
			//tjgdm.setCurrentReaderId(0);
			Integer flag = tjgdmDao.update(tjgdm);
			//LoanLog loanLog = new LoanLog();
			//loanLog.setLogId(tjgdm.getLogId());
			//loanLog.setReturnTime(new Date());
			//flag = loanLogDao.update(loanLog);
			//return flag == null ? false:true;
			return flag == null ? false:true;
		//}else{
		//	return false;
		//}	
	}
		
	public Tjgdm findByJgdm(Tjgdm tjgdm) {
		return tjgdmDao.findByJgdm(tjgdm);
	}
	
	public Tjgdm findByJgdmQz(Tjgdm tjgdm) {
		return tjgdmDao.findByJgdmQz(tjgdm);
	}
	
	public List fingCodeByTjgdm(Tjgdm tjgdm)  throws Exception{
		List tjgdmList=tjgdmDao.fingCodeByTjgdm(tjgdm);
		return tjgdmList;
	}

	@Override
	public Tjgdm tjgdmViewImg(Integer orgid) {
		// TODO Auto-generated method stub
		return tjgdmDao.findByIdViewImg(orgid);
	}

	@Override
	public Page findByPrintPage(Page page) {
		String strBzjgdm=page.getBzjgdm();
		String strUserName=page.getUsername();
		if(strUserName=="admin" || "admin".equals(strUserName)){
			strBzjgdm=null;
		}else{
			appSysConfig = ActionContext.getContext().getApplication();
			if(!"1".equals(appSysConfig.get("sysBzjgLimitMode"))){
				strBzjgdm=null;
			}
		}
		page.setBzjgdm(strBzjgdm);
		page.setRoot(tjgdmDao.findByPrintPage(page));
		page.setTotalProperty(tjgdmDao.findByPrintCount(page));
		return page;
	}

	@Override
	public int findPrintCount(Page page) {
		String strBzjgdm=page.getBzjgdm();
		String strUserName=page.getUsername();
		if(strUserName=="admin" || "admin".equals(strUserName)){
			strBzjgdm=null;
		}else{
			appSysConfig = ActionContext.getContext().getApplication();
			if(!"1".equals(appSysConfig.get("sysBzjgLimitMode"))){
				strBzjgdm=null;
			}
		}
		page.setBzjgdm(strBzjgdm);
		return tjgdmDao.findByPrintCount(page);
	}

}
