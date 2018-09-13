package com.lhq.prj.bms.service.impl;

import java.util.List;

import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ILoanLogDao;
import com.lhq.prj.bms.dao.IOrgDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.Org;
import com.lhq.prj.bms.po.Zuser;
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

	private ILoanLogDao loanLogDao;
	
	private IZuserDao zuserDao;

	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}

	public void setLoanLogDao(ILoanLogDao loanLogDao) {
		this.loanLogDao = loanLogDao;
	}

	public void setOrgDao(IOrgDao orgDao) {
		this.orgDao = orgDao;
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
		page.setRoot(orgDao.findByPage(page));
		page.setTotalProperty(orgDao.findByCount(page));
		return page;
	}
	
//	public List findUsernameOrg(String username){
//		return orgDao.findUsernameOrg(username);
//	}

	public List findUsernameOrg(Page page){
		return orgDao.findUsernameOrg(page);
	}
	
	public List findOrgidOrg(Integer orgid){
		return orgDao.findOrgidOrg(orgid);
	}
	
	public Object saveOrg(Org org)  throws Exception  {
		Object flag = orgDao.saveOrg(org);
		if(flag != null){
			Integer ss=org.getUserid();
			System.out.print("666666666666666666666666666666666666666666666666666="+ss);
			Zuser zuser = new Zuser(ss);
			//yangqi   20120605  ??????????   此处文件的解决是陪配置applicationContext-services.xml
			zuser.setOrgid((Integer)flag);
			zuser.setOrgCode(org.getJgdm());
			zuser.setOrgName(org.getJgmc());
			zuser.setState("2");  
			zuserDao.update(zuser);
		}
		return flag;
	}


	//public List createKey(Keylog keylog){
		
		//return KeylogDao.findByKeylog(keylog);
		
		//return KeylogDao.findByPage(keylog);
		//page.setRoot(orgDao.findByPage(page));
		//page.setTotalProperty(orgDao.findByCount(page));
		//return page;
		
		//return  KeylogDao.findByPage(keylog);
	    //if (null != strKey) {
			//CallableStatement calls = con.prepareCall("{call " + procName +"(?,?)}");
			//calls.setString(1, tableName);
			//calls.registerOutParameter(2, Types.VARCHAR);//如果有输出参数，必须进行注册
			//calls.execute();
	//}

	//}

	
	public boolean updateOrg(Org org) throws Exception {
		Integer flag = orgDao.update(org);
		if (null != flag) {
			return true;
		}
		return false;
	}
	
	
	public List orgViewImg(Page page){
		return orgDao.findByIdViewImg(page);
	}
	
	//保存图片
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
			if(org2.getImageData()=="" || "".equals(org2.getImageData())){
				s2=s1;
			}else{
				s2=org2.getImageData()+s1;
			}
  			//System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			s2=org2.getImageData()+s1;
		}

		org2.setOrgid(orgid);		
		org2.setPageTypeStr(pageTypeStr);		
		org2.setImageUrl(packindex);
 		org2.setImageData(s2);
     		Integer flag = orgDao.update(org2);
		if (null != flag) {
			return true;
		}
		return false;
	}

	//用户提交
	public boolean returnOrg(Org org) throws Exception {
		org = orgDao.findById(org.getOrgid());
		Integer flag=null;
		//把State由字符转为数字
		String strState=org.getState();	
		Integer newUserState=0;
		String strImageData=org.getImageData();	
		if(strImageData=="" || "".equals(strImageData) || null==strImageData|| strImageData==null){
			flag=null;
			//System.out.println("sssssssss==================================="+flag);
			
		}else{
		    Integer intObj = new Integer(strState);
		    int inte = intObj.intValue(); 
	        //newUserState为2：新办，3：已办，4：注销，11：新年检，11：新年检，13：已年检
			switch(inte) {
			case 0:   //客户新办提交后，申请单为1，用户为2，同理类推
				inte=1;  
				newUserState=inte+1;
				break; 
			case 3: 
				inte=1;
				newUserState=inte+1;
				break;
			case 10: 
				inte=11;
				newUserState=inte+1;
				break; 
			case 13: 
				inte=11;
				newUserState=inte+1;
				break; 
			case 20: 
				inte=21;
				newUserState=inte+1;
				break; 
			case 23: 
				inte=21;
				newUserState=inte+1;
				break;
			case 30: 
				inte=31;
				newUserState=inte+1;
				break; 
			case 33: 
				inte=31;
				newUserState=inte+1;
				break;
			case 40: 
				inte=41;
				newUserState=inte+1;
				break;
			case 43: 
				inte=41;
				newUserState=inte+1;
				break;
			case 50: 
				inte=51;
				newUserState=inte+1;
				break;
			case 53: 
				inte=51;
				newUserState=inte+1;
				break;
			case 60: 
				inte=61;
				newUserState=inte+1;
				break;
			case 63: 
				inte=61;
				newUserState=inte+1;
				break;
			case 70: 
				inte=71;
				newUserState=inte+1;
				break;
			case 73: 
				inte=71;
				newUserState=inte+1;
				break;
			default: 
				System.out.println("用户申请单提交错误！");
			}
			
			//System.out.println("################################");
			//更新用户的状态为2，即已新办提交，同时更新用户当前最新的orgid
			//??????为什么不更新呢
			Zuser zuser = new Zuser();
			zuser.setZuserId(org.getUserid());//更新的条件为Userid
			zuser.setOrgid(org.getOrgid());
			zuser.setOrgCode(org.getJgdm());
			zuser.setOrgName(org.getJgmc());
			zuser.setState(String.valueOf(newUserState));  
			zuserDao.update(zuser);
			
	        //转换数字状态为字符串
			String newState=String.valueOf(inte);
			org.setState(newState);
			
			//org.setJgmc('sss');
			//org.setCurrentReader("");// 清空当前日志
			//org.setCurrentReaderId(0);
			flag = orgDao.update(org);
			//LoanLog loanLog = new LoanLog();
			//loanLog.setLogId(org.getLogId());
			//loanLog.setReturnTime(new Date());
			//flag = loanLogDao.update(loanLog);
		}
		return flag == null ? false:true;
		
	}
	
	
}
