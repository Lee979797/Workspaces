package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.ISysConfigDao;
import com.lhq.prj.bms.dao.IYwsetDao;
import com.lhq.prj.bms.po.SysConfig;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.service.IYwsetService;
import com.opensymphony.xwork2.ActionContext;

/**    
 * YwsetService.java Create on 2008-9-16 ����10:40:48   
 *
 *
 *
 * Copyright (c) 2008 by MTA.
 *
 * @author �����
 * @version 1.0  
 */
public class YwsetService implements IYwsetService {
	
	private IYwsetDao ywsetDao;
	
	private ISysConfigDao sysConfigDao;
	
	private Map appSysConfig;

	public void setYwsetDao(IYwsetDao ywsetDao) {
		this.ywsetDao = ywsetDao;
	}

	public void setSysConfigDao(ISysConfigDao sysConfigDao) {
		this.sysConfigDao = sysConfigDao;
	}
	
	public boolean deleteYwset(Integer ywsetId) {
		Integer flag = ywsetDao.deleteById(ywsetId);
		if(flag != null){
			appSysConfig = ActionContext.getContext().getApplication();
			//根据application的sysAppName的值来判断是否为空来判断是否读取系统参数的值
			List sysConfigList = new ArrayList();
			sysConfigList=sysConfigDao.findAll();
			SysConfig sysConfig=new SysConfig();
			
			for (int j = 0; j < sysConfigList.size(); j++) { //循环过滤state的值，如果不等于，则b就TRUE
				sysConfig=(SysConfig) sysConfigList.get(j);
				String sysConfigCode=sysConfig.getConfigCode();
				String sysConfigValue=sysConfig.getConfigValue();
				if("sysNetWorkMode".equals(sysConfigCode)){
					List ywnetList = new ArrayList();
					Ywset ys = new Ywset();
					ys.setFlag("0");
					
					ywnetList=ywsetDao.findAll(ys);
					appSysConfig.put("ywnetList", ywnetList);
				}
				appSysConfig.put(sysConfigCode, sysConfigValue);
			}
			return true;
		}
		return false;
	}

	public List findAll(Ywset ywset) {
		return ywsetDao.findAll(ywset);
	}

	public Page findByPage(Page page) {
		page.setRoot(ywsetDao.findByPage(page));
		page.setTotalProperty(ywsetDao.findByCount(page));
		return page;
	}

	public Object saveYwset(Ywset ywset) {
		Object objYwset=ywsetDao.saveYwset(ywset);
		if(objYwset!=null){
			appSysConfig = ActionContext.getContext().getApplication();
			//根据application的sysAppName的值来判断是否为空来判断是否读取系统参数的值
			List sysConfigList = new ArrayList();
			sysConfigList=sysConfigDao.findAll();
			SysConfig sysConfig=new SysConfig();
			
			for (int j = 0; j < sysConfigList.size(); j++) { //循环过滤state的值，如果不等于，则b就TRUE
				sysConfig=(SysConfig) sysConfigList.get(j);
				String sysConfigCode=sysConfig.getConfigCode();
				String sysConfigValue=sysConfig.getConfigValue();
				if("sysNetWorkMode".equals(sysConfigCode)){
					List ywnetList = new ArrayList();
					Ywset ys = new Ywset();
					ys.setFlag("0");
					ywnetList=ywsetDao.findAll(ys);
					appSysConfig.put("ywnetList", ywnetList);
				}
				appSysConfig.put(sysConfigCode, sysConfigValue);
			}
		}
		return objYwset;
	}

	public boolean updateYwset(Ywset ywset) throws Exception {
		Integer flag = ywsetDao.update(ywset);
		if(flag != null){
			appSysConfig = ActionContext.getContext().getApplication();
			//根据application的sysAppName的值来判断是否为空来判断是否读取系统参数的值
			List sysConfigList = new ArrayList();
			sysConfigList=sysConfigDao.findAll();
			SysConfig sysConfig=new SysConfig();
			
			for (int j = 0; j < sysConfigList.size(); j++) { //循环过滤state的值，如果不等于，则b就TRUE
				sysConfig=(SysConfig) sysConfigList.get(j);
				String sysConfigCode=sysConfig.getConfigCode();
				String sysConfigValue=sysConfig.getConfigValue();
				if("sysNetWorkMode".equals(sysConfigCode) || "sysXcWorkMode".equals(sysConfigCode)){
					List ywnetList = new ArrayList();
					Ywset ys = new Ywset();
					ys.setFlag("0");
					ywnetList=ywsetDao.findAll(ys);
					appSysConfig.put("ywnetList", ywnetList);
				}
				appSysConfig.put(sysConfigCode, sysConfigValue);
			}
			return true;
		}
		return false;
	}

	public List findYwsetByBzjg(String bzjgdm) {
		return ywsetDao.findYwsetByBzjg(bzjgdm);
	}
	
	public List findYwsetByNotBzjg(String bzjgdm) {
		return ywsetDao.findYwsetByNotBzjg(bzjgdm);
	}
}
 