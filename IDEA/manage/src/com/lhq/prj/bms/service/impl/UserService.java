package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.SysConfig;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.dao.ISysConfigDao;
import com.lhq.prj.bms.dao.IYwsetDao;
import com.lhq.prj.bms.dao.IJglxDao;
import com.lhq.prj.bms.dao.IUserDao;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.service.IUserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * UserService.java Create on 2008-9-19 ����01:41:43
 * 
 * �û�����ҵ���ʵ����
 * 
 * Copyright (c) 2008 by MTA.
 * 
 * @author �����
 * @version 1.0
 */
public class UserService implements IUserService {
	private IUserDao userDao;
	
	private ISysConfigDao sysConfigDao;
	
	private IYwsetDao ywsetDao;
	
	private IJglxDao jglxDao;
	
	private Map appSysConfig;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void setSysConfigDao(ISysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}
	
	public void setYwsetDao(IYwsetDao ywsetDao) {
		this.ywsetDao = ywsetDao;
	}
	
	public void setJglxDao(IJglxDao jglxDao) {
		this.jglxDao = jglxDao;
	}
	
	public boolean deleteUser(Integer userId) {
		Integer flag = userDao.deleteById(userId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public Page findByPage(Page page) {
		page.setRoot(userDao.findByPage(page));
		page.setTotalProperty(userDao.findByCount(page));
		return page;
	}

	public Object saveUser(User user) {
		return userDao.saveUser(user);
	}

	public Object regUser(User user) {
			return userDao.regUser(user);
	}
	
	public boolean updateUser(User user) throws Exception {
		Integer flag = userDao.update(user);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public boolean midifyUser(User user) throws Exception {
		Integer flag = userDao.updateSet(user);
		if (flag != null) {
			return true;
		}
		return false;
	}
	
	public User login(User user) {
		user = userDao.login(user);
		
		appSysConfig = ActionContext.getContext().getApplication();
		//根据application的sysAppName的值来判断是否为空来判断是否读取系统参数的值
		//System.out.print(appSysConfig.get("sysAppName"));
		if(appSysConfig.get("sysAppName")==null){
			List sysConfigList = new ArrayList();
			sysConfigList=sysConfigDao.findAll();
			SysConfig sysConfig=new SysConfig();
			
			for (int j = 0; j < sysConfigList.size(); j++) { 
				sysConfig=(SysConfig) sysConfigList.get(j);
				String sysConfigCode=sysConfig.getConfigCode();
				String sysConfigValue=sysConfig.getConfigValue();
				if("sysNetWorkMode".equals(sysConfigCode)&&"1".equals(sysConfigValue)){
					List ywnetList = new ArrayList();
					Ywset ys = new Ywset();
					ys.setFlag("0");
					ys.setBzjgdm(user.getBzjgCode());
					ywnetList=ywsetDao.findAll(ys);
					appSysConfig.put("ywnetList", ywnetList);
				}
				if("sysXcWorkMode".equals(sysConfigCode)){
					List jglxList = new ArrayList();
					jglxList=jglxDao.findAllByFlag();
					appSysConfig.put("jglxList", jglxList);
				}
				appSysConfig.put(sysConfigCode, sysConfigValue);
			}
			//appSysConfig.put("sysAppName", "组织机构代码数字档案管理系统");
		}
		return user;
	}
	
	public boolean updatePwd(String userPwdOld, User user) {
		return userDao.updatePwd(userPwdOld, user);
	}
	
	public List findByExample(User user) {
		return userDao.findByExample(user);
	}
}
