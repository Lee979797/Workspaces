package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ISysConfigDao;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.SysConfig;
import com.lhq.prj.bms.service.ISysConfigService;
import com.opensymphony.xwork2.ActionContext;
/**
 * SysConfigService.java Create on 2013-4-13
 * 
 * 系统参数设置    业务层实现类
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author yangqi
 * @version 1.0
 */
public class SysConfigService implements ISysConfigService {

	private ISysConfigDao sysConfigDao;
	
	private Map appSysConfig;

	public void setSysConfigDao(ISysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}

	public boolean deleteSysConfig(Integer configId) {
		Integer flag = sysConfigDao.deleteById(configId);
		if (flag != null) {
			return true;
		}
		return false;
	}

	public List findAll() {
		return sysConfigDao.findAll();
	}
	
	public Page findByPage(Page page) {
		page.setRoot(sysConfigDao.findByPage(page));
		page.setTotalProperty(sysConfigDao.findByCount(page));
		return page;
	}
	
	public Object saveSysConfig(SysConfig sysConfig) {
		return sysConfigDao.saveSysConfig(sysConfig);
	}
    
	public Object findById(Integer configId){
		return sysConfigDao.findById(configId);
	}
	
	public boolean updateSysConfig(SysConfig sysConfig) throws Exception {
		Integer flag = sysConfigDao.update(sysConfig);
		if (flag != null) {
			Integer intConfigId=sysConfig.getConfigId();
			SysConfig newSysConfig=new SysConfig();
			newSysConfig=sysConfigDao.findById(intConfigId);
			if(newSysConfig!=null){
				appSysConfig = ActionContext.getContext().getApplication();
				//在改变系统参数的时候，需更新application相应的值
				String sysConfigCode=newSysConfig.getConfigCode();
				String sysConfigValue=newSysConfig.getConfigValue();
				//System.out.println(ywlxdm);
				appSysConfig.put(sysConfigCode, sysConfigValue);
			}
			return true;
		}
		return false;
	}
	
	public String findMcByDm(String configCode) {
		return sysConfigDao.findMcByDm(configCode);
	}
}
