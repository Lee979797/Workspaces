package com.lhq.prj.bms.service.impl;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.dao.ITjgdmDao;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.dao.IZuserDao;

import com.lhq.prj.bms.po.Org;
import com.lhq.prj.bms.dao.IOrgDao;

import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.dao.IPzjgDao;

import com.lhq.prj.bms.service.IOrgService;


/**
 * OrgService.java Create on 2012-5-12
 * 
 * 机构管理业务层
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
 */
public class OrgService implements IOrgService {

	private IOrgDao orgDao;

	private IZuserDao zuserDao;

	private ITjgdmDao tjgdmDao;
	
	private IPzjgDao pzjgDao;

	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}

	public void setOrgDao(IOrgDao orgDao) {
		this.orgDao = orgDao;
	}

	public void setTjgdmDao(ITjgdmDao tjgdmDao) {
		this.tjgdmDao = tjgdmDao;
	}
	
	public void setPzjgDao(IPzjgDao pzjgDao) {
		this.pzjgDao = pzjgDao;
	}
	public boolean deleteOrg(String rootPath, Integer orgid) {
		Org org = orgDao.findById(orgid);
		Integer flag = orgDao.deleteById(orgid);
		if (null != flag) {
			return MyUtils.delFile(rootPath + org.getImageUrl());
		}
		return false;
	}

	public Page findByPage(Page page) {
		//String bzjgdm=page.getUsername();
		//String bzjgdm="110000";
		String bzjgdm=page.getBzjgdm();
		String userName=page.getUsername();
		
		if(userName=="admin" || "admin".equals(userName)){
			
		}else{
			List pzjgList=pzjgDao.findByBzjgdm(bzjgdm);
			List pzjgdmList = new ArrayList();
			Pzjg pzjg=new Pzjg();
			for (int i = 0; i < pzjgList.size(); i++) {
				System.out.println(pzjgList.size());
				pzjg=(Pzjg) pzjgList.get(i);
				String pzjgdm=pzjg.getPzjgdm();
				pzjgdmList.add(pzjgdm);
			}
			page.setPzjgdmConditions(pzjgdmList);
		}
		page.setRoot(orgDao.findByPage(page));
		page.setTotalProperty(orgDao.findByCount(page));
		return page;
	}

	
//	public Page findByPage(Page page) {
//	page.setRoot(orgDao.findByPage(page));
//	page.setTotalProperty(orgDao.findByCount(page));
//	return page;
//}
	
	public Object saveOrg(Org org) {
		//sqlMapper.queryForObject("maxOutProcedure","sss");
		//org.setJjlx("sssss");
		return orgDao.saveOrg(org);
	}

	public boolean updateOrg(Org org) throws Exception {
		Integer flag = orgDao.update(org);
		if (null != flag) {
			return true;
		}
		return false;
	}
    
	//新办提交
	public boolean returnOrg(Org org) throws Exception {
		org = orgDao.findById(org.getOrgid());
		String strState=org.getState();
		Integer flag = null;
		if(strState=="0" || "0".equals(strState)){
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setJgmc(org.getJgmc());
			//增加方法  findByJgdmJgmc 检测此单位是否已办证
			tjgdm = tjgdmDao.findByJgdm(tjgdm);
            //如过老库中没有此用户则审核通过
			if(tjgdm == null){
				org.setState("1");
				flag = orgDao.update(org);
			}
		}
		return flag == null ? false:true;
	}
	
	//新办网审驳回NO
	public boolean returnOrgNo(Org org) throws Exception {
		String strHandlenote = org.getHandle_note();
		String newHandleUsername=org.getHandle_username();
		String newHandleUserid=org.getHandle_userid();
		String newHandleName=org.getHandle_name();
		org = orgDao.findById(org.getOrgid());
		//把State由字符转为数字
		Integer inte=Integer.parseInt(org.getState());	
		Integer newUserState=0;
	    //Integer intObj = new Integer(strState);
	    //int inte = intObj.intValue(); 

		switch(inte) {
		case 1: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 11: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 21: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 31: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 41: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 51: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 61: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 71: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		default: 
			System.out.println("工单审查驳回错误！");
		}
		
		
		Zuser zuser = new Zuser();
		zuser.setUserid(org.getUserid());
		zuser.setOrgid(org.getOrgid());
		zuser.setState(String.valueOf(newUserState));  
		zuserDao.update(zuser);
		
		
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		org.setState(newState);
		org.setHandle_userid(String.valueOf(newHandleUserid));
		org.setHandle_username(newHandleUsername);// 设置审核人用户名
		org.setHandle_name(newHandleName);// 设置审核人姓名
		org.setHandle_date(new Date());
		org.setHandle_note(strHandlenote);
		
		//org.setHandleUsername("");// 设置审核人用户名
		//org.setHandleName("");// 设置审核人姓名
		//org.setState("1");
		//org.setJgmc('sss');
		//org.setCurrentReader("");// 清空当前日志
		//org.setCurrentReaderId(0);
		Integer flag = orgDao.update(org);
		//更改用户状态改为3已办证,且把机构代码号赋为用户
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(org.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	//新办网审通过OK
	public boolean returnOrgOk(Org org) throws Exception {
		String newHandleUsername=org.getHandle_username();
		String newHandleUserid=org.getHandle_userid();
		String newHandleName=org.getHandle_name();
		String strHandlenote = org.getHandle_note();
		org = orgDao.findById(org.getOrgid());
		//此处应该监测机构名称是否存在????????yangqi 
        //把State由字符转为数字
		Integer inte=Integer.parseInt(org.getState());
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
			System.out.println("错误！");
		}
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		
		org.setState(newState);
		org.setHandle_userid(String.valueOf(newHandleUserid));
		org.setHandle_username(newHandleUsername);// 设置审核人用户名
		org.setHandle_name(newHandleName);// 设置审核人姓名
		org.setHandle_date(new Date());
		org.setHandle_note(strHandlenote);
		
		Integer flag = orgDao.update(org);

		return flag == null ? false:true;
	}
	
	public boolean returnOrgCode(Org org) throws Exception {
		org = orgDao.findById(org.getOrgid());
		org.setState("4");
		org.setJgdm("10888888-X");
		Integer flag = orgDao.update(org);
		return flag == null ? false:true;
	}
	

	
	public List orgViewImg(Integer orgid){
		return orgDao.findByIdViewImg(orgid);
	}
	

	public boolean saveImageOrg(Org org) throws Exception {
		String s1=org.getImageData();
		String packindex=org.getPackindex();
		String pageTypeStr=org.getPageTypeStr();
		Integer orgid=org.getOrgid();
		String s2="";
		
  		Org org2 = new Org();
		org2 = orgDao.findById(orgid);
		if(packindex=="0" || "0".equals(packindex)){
			//System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			s2=s1;
		}else{
  			//System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			if(org2.getImageData()=="" || "".equals(org2.getImageData())){
				s2=s1;
			}else{
				s2=org2.getImageData()+s1;
			}
			
		}

		org2.setOrgid(orgid);		
		org2.setPageTypeStr(pageTypeStr);		
		org2.setImageUrl(packindex);
		org2.setImageData(s2);
		Integer flag = orgDao.update(org2);
		System.out.println(pageTypeStr);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	
	public boolean returnOrgCreate(Org org) throws Exception {
		org = orgDao.findById(org.getOrgid());
		String strState=org.getState();
		Integer flag = null;
		Tjgdm tjgdm = new Tjgdm();
		String newState="";
		String dybz="";
		if(strState=="4" || "4".equals(strState) || strState=="14" || "14".equals(strState) || strState=="24" || "24".equals(strState)|| strState=="34" || "34".equals(strState)|| strState=="44" || "44".equals(strState)|| strState=="54" || "54".equals(strState)|| strState=="64" || "64".equals(strState)|| strState=="74" || "74".equals(strState)){
			if(strState=="74" || "74".equals(strState)){
				newState="200";//为注销状态
			}else{
				newState="100";	
			}
			
			if(strState=="4" || "4".equals(strState)||strState=="5" || "5".equals(strState)||strState=="34" || "34".equals(strState)||strState=="44" || "44".equals(strState)||strState=="54" || "54".equals(strState)){
				dybz="";
			}else{
				dybz="Y";	//为已打印
			}
			//如过老库中没有此用户则审核通过????????此处字段信息要补充
			tjgdm.setUserid(org.getUserid());
			//tjgdm.setUsername(org.Username());
			tjgdm.setOrderid(org.getOrderid());
			tjgdm.setName(org.getName());
			tjgdm.setJgmc(org.getJgmc());
			tjgdm.setJgdm(org.getJgmc());
			tjgdm.setZch(org.getZch());
			tjgdm.setXzqhCode(org.getXzqhCode());
			tjgdm.setXzqhName(org.getXzqhName());
			tjgdm.setState(newState);
			tjgdmDao.saveTjgdm(tjgdm);
				
			org.setState(newState);
			org.setImageData("");
			org.setPageTypeStr("");
			org.setTbrxm("");
			org.setMemo("");
			org.setTbrlxfs("");
			org.setTbrsfzh("");
			org.setYwlx("");
			org.setXgr("");
			org.setHandle_userid("");
			org.setHandle_username("");
			org.setHandle_name("");
			org.setHandle_date(null);
			org.setHandle_note("");
			org.setMoveoutAddrss("");
			org.setMoveoutReason("");
			org.setMoveoutNote("");
			org.setOffPzjgmc("");
			org.setOffPzwh("");
			org.setOffReason("");
			org.setOffNote("");
			org.setOrderid("");
			
			org.setDybz(dybz);
			flag = orgDao.update(org);
			
			//更改用户状态改为7已办证,且把机构代码号赋为用户
			//已建档后的用户状态都为7
			Zuser zuser = new Zuser();
			if(strState=="74" || "74".equals(strState)){
				zuser.setState("-1");  //用户注销
			}else{
				zuser.setState("7");
			}
			zuser.setOrgCode(org.getJgdm());
			zuser.setUserid(org.getUserid());
			flag = zuserDao.update(zuser);

		}

		return flag == null ? false:true;
	}
	
	
	public boolean returnOrgPrint(Org org) throws Exception {
		org = orgDao.findById(org.getOrgid());		
		org.setDybz("Y");  //打印标志
		//org.setCurrentReader("");// 清空当前日志
		//org.setCurrentReaderId(0);
		Integer flag = orgDao.update(org);
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(org.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);\
		
		//更改用户状态改为10已办证完毕
		Zuser zuser = new Zuser();
		zuser.setState("7");
		zuser.setUserid(org.getUserid());
		flag = zuserDao.update(zuser);
		
		return flag == null ? false:true;
	}
	
	

	//现场办理
	public boolean returnOrgDo(Org org) throws Exception {
		//org = orgDao.findById(org.getOrgid());
		//把State由字符转为数字
		Integer inte=Integer.parseInt(org.getState());

		Integer newUserState=0;

		switch(inte) {
		case 2: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 12: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 22: 
			inte=inte+2;
			newUserState=inte+1;
			break; 
		case 32: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 42: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 52: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 62: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		case 72: 
			inte=inte+2;
			newUserState=inte+1;
			break;
		default: 
			System.out.println("工单审查驳回错误！");
		}
		
		
		Zuser zuser = new Zuser();
		zuser.setUserid(org.getUserid());
		zuser.setState(String.valueOf(newUserState));  
		zuserDao.update(zuser);
		
		
        //转换数字状态为字符串
		String newState=String.valueOf(inte);
		org.setOrgid(org.getOrgid());
		//org.setState(org.getJgdm());
		org.setState(newState); 
		org.setHandle_username(org.getHandle_username());// 设置审核人用户名
		org.setHandle_name(org.getHandle_name());// 设置审核人姓名
		
		org.setHandle_username(org.getHandle_username());
		org.setHandle_name(org.getHandle_name());
		org.setHandle_date(new Date());
		
		Integer flag = orgDao.update(org);
		//更改用户状态改为3已办证,且把机构代码号赋为用户
		//LoanLog loanLog = new LoanLog();
		//loanLog.setLogId(org.getLogId());
		//loanLog.setReturnTime(new Date());
		//flag = loanLogDao.update(loanLog);
		return flag == null ? false:true;
	}
	
	
	
	public boolean returnOrgGo(Org org) throws Exception {
		org = orgDao.findById(org.getOrgid());
		//yangqi需要判断 ?????????????
		//String strState=org.getState();	
		//if(strState=="6"){
			org.setState("7");
			//org.setCurrentReader("");// 清空当前日志
			//org.setCurrentReaderId(0);
			Integer flag = orgDao.update(org);
			//LoanLog loanLog = new LoanLog();
			//loanLog.setLogId(org.getLogId());
			//loanLog.setReturnTime(new Date());
			//flag = loanLogDao.update(loanLog);
			//return flag == null ? false:true;
			return flag == null ? false:true;
		//}else{
		//	return false;
		//}	
	}	

}
