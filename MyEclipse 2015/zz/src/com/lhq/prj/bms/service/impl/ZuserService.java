package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ISysConfigDao;
import com.lhq.prj.bms.dao.IYwsetDao;
import com.lhq.prj.bms.dao.IZuserDao;
import com.lhq.prj.bms.po.SysConfig;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IZuserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * ZuserService.java Create on 2012-5-5
 * 
 * 用户管理业务层实现类
 * 
 * Copyright (c) 2008 by MTA.
 * @author
 * @version 1.0
 */
public class ZuserService implements IZuserService {

	private IZuserDao zuserDao;
	private Map appSysConfig;
	private ISysConfigDao sysConfigDao;
	
	private IYwsetDao ywsetDao;
	public void setZuserDao(IZuserDao zuserDao) {
		this.zuserDao = zuserDao;
	}

	public boolean deleteZuser(Integer userid) {
		Integer flag = zuserDao.deleteById(userid);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(zuserDao.findByPage(page));
		page.setTotalProperty(zuserDao.findByCount(page));
		return page;
	}

	public Object saveZuser(Zuser zuser) {
		return zuserDao.saveZuser(zuser);
	}

	
	public Object regZuser(Zuser zuser) {
        //暂时屏蔽
		Zuser zuser2= zuserDao.checkByUserName(zuser);
		if (zuser2==null) {
			return zuserDao.regZuser(zuser);
		}
		//return zuser;
		return null;
	}

	
	public boolean updateZuser(Zuser zuser) throws Exception {
		Integer flag = zuserDao.update(zuser);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Zuser zlogin(Zuser zuser) {
		
		zuser = zuserDao.zlogin(zuser);
		if(zuser!=null){
			appSysConfig = ActionContext.getContext().getApplication();
			List sysConfigList = new ArrayList();
			sysConfigList=sysConfigDao.findAll();
			SysConfig sysConfig=new SysConfig();
			for (int j = 0; j < sysConfigList.size(); j++) { //循环过滤state的值，如果不等于，则b就TRUE
				sysConfig=(SysConfig) sysConfigList.get(j);
				String sysConfigCode=sysConfig.getConfigCode();
				String sysConfigValue=sysConfig.getConfigValue();
				//System.out.println(sysConfigCode+"：：跟踪代码：："+sysConfigValue);
				if("sysNetWorkMode".equals(sysConfigCode)&&"1".equals(sysConfigValue)){
					List ywnetList = new ArrayList();
					Ywset ys = new Ywset();
					ys.setFlag("0");
					ys.setBzjgdm(zuser.getBzjgdm());
					ywnetList=ywsetDao.findAll(ys);
					appSysConfig.put("ywnetList", ywnetList);
				}
				appSysConfig.put(sysConfigCode, sysConfigValue);
			}
		}
		return zuser;
	}
	
	//检查用户名称是否存在
	public boolean checkZuser(String userName) {
		Zuser zuser=new Zuser();
		zuser.setUserName(userName);
		zuser=zuserDao.checkByUserName(zuser);
		if (zuser != null) {
			return true;   //用户已存在
		}
		return false;  //可注册
	}
	
	public boolean checkZuserJgmc(String jgmc) {
		Integer flag = zuserDao.checkByJgmc(jgmc);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findByExample(Zuser zuser) {
		return zuserDao.findByExample(zuser);
	}

	/*public Zuser findUserInfo(Zuser zu) {
		// TODO Auto-generated method stub
		return zuserDao.checkByUserName(zu);
	}*/
	
	public List findUserInfo(Zuser zu) {
		// TODO Auto-generated method stub
		return zuserDao.findUserInfo(zu);
	}

	public boolean updatePwd(String userPwdOld, Zuser zuser) {
		// TODO Auto-generated method stub
		return zuserDao.updatePwd(userPwdOld, zuser);
	}

	public Map getAppSysConfig() {
		return appSysConfig;
	}

	public void setAppSysConfig(Map appSysConfig) {
		this.appSysConfig = appSysConfig;
	}

	public void setSysConfigDao(ISysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}

	public void setYwsetDao(IYwsetDao ywsetDao) {
		this.ywsetDao = ywsetDao;
	}

	public String findJgdmByUserid(int userid) {
		// TODO Auto-generated method stub
		return zuserDao.findJgdmByUserid(userid);
	}
	
}
