package com.lhq.prj.bms.service.impl;

import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ILoanLogDao;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.service.ITjgdmService;


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

	public void setLoanLogDao(ILoanLogDao loanLogDao) {
		this.loanLogDao = loanLogDao;
	}

	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
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
		page.setRoot(tjgdmDao.findByPage(page));
		page.setTotalProperty(tjgdmDao.findByCount(page));
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
    
	//新办提交
	public boolean returnTjgdm(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
		tjgdm.setState("1");
		//tjgdm.setJgmc('sss');
		//tjgdm.setCurrentReader("");// 清空当前日志
		//tjgdm.setCurrentReaderId(0);
		Integer flag = tjgdmDao.update(tjgdm);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	//新办网审驳回NO
	public boolean returnTjgdmNo(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
		//把State由字符转为数字
		String strState=tjgdm.getState();	
	    Integer intObj = new Integer(strState);
	    int inte = intObj.intValue(); 

		switch(inte) {
		case 1: 
			inte=inte+2;
			break; 
		case 11: 
			inte=inte+2;
			break; 
		case 21: 
			inte=inte+2;
			break; 
		case 31: 
			inte=inte+2;
			break;
		case 41: 
			inte=inte+2;
			break;
		case 51: 
			inte=inte+2;
			break;
		case 61: 
			inte=inte+2;
			break;
		case 71: 
			inte=inte+2;
			break;
		default: 
			System.out.println("工单审查驳回错误！");
		}
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		tjgdm.setState(newState);
		tjgdm.setAduditUsername("");// 设置审核人用户名
		tjgdm.setAduditName("");// 设置审核人姓名
		
		
		//tjgdm.setState("1");
		//tjgdm.setJgmc('sss');
		//tjgdm.setCurrentReader("");// 清空当前日志
		//tjgdm.setCurrentReaderId(0);
		Integer flag = tjgdmDao.update(tjgdm);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	//新办网审通过OK
	public boolean returnTjgdmOk(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
        //把State由字符转为数字
		String strState=tjgdm.getState();	
	    Integer intObj = new Integer(strState);
	    int inte = intObj.intValue(); 

		switch(inte) {
		case 1: 
			inte=inte+1;
			break; 
		case 11: 
			inte=inte+1;
			break; 
		case 21: 
			inte=inte+1;
			break; 
		case 31: 
			inte=inte+1;
			break;
		case 41: 
			inte=inte+1;
			break;
		case 51: 
			inte=inte+1;
			break;
		case 61: 
			inte=inte+1;
			break;
		case 71: 
			inte=inte+1;
			break;
		default: 
			System.out.println("工单审查通过错误！");
		}
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		tjgdm.setState(newState);
			tjgdm.setAduditUsername("");// 设置审核人用户名
			tjgdm.setAduditName("");// 设置审核人姓名
		Integer flag = tjgdmDao.update(tjgdm);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	public boolean returnTjgdmCode(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
		tjgdm.setState("4");
		tjgdm.setJgdm("10888888-X");
		Integer flag = tjgdmDao.update(tjgdm);
		return flag == null ? false:true;
	}
	
	public boolean returnTjgdmCreate(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
		tjgdm.setState("5");
		//tjgdm.setJgmc('sss');
		//tjgdm.setCurrentReader("");// 清空当前日志
		//tjgdm.setCurrentReaderId(0);
		Integer flag = tjgdmDao.update(tjgdm);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(tjgdm.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	
	public boolean returnTjgdmPrint(Tjgdm tjgdm) throws Exception {
		tjgdm = tjgdmDao.findById(tjgdm.getOrgid());
		tjgdm.setState("6");
		tjgdm.setDybz("Y");  //打印标志
		//tjgdm.setCurrentReader("");// 清空当前日志
		//tjgdm.setCurrentReaderId(0);
		Integer flag = tjgdmDao.update(tjgdm);
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
		
	public Tjgdm checkJgdm(Tjgdm tjgdm) {
		return tjgdmDao.findByJgdm(tjgdm);
	}

	public Tjgdm returnTjgdmByJgdm(Tjgdm tjgdm) {
		// TODO Auto-generated method stub
		if(tjgdmDao.findConditionsTjgdm(tjgdm).size()>0){
			return (Tjgdm) tjgdmDao.findConditionsTjgdm(tjgdm).get(0);
		}else{
			return null;
		}
	}

}
