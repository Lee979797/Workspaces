package com.lhq.prj.bms.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.dao.IJglxDao;
import com.lhq.prj.bms.po.Jglx;
import com.lhq.prj.bms.service.IJglxService;
import com.opensymphony.xwork2.ActionContext;

/**
 * JglxService.java Create on 2012-5-5
 * 
 * 办证机构业务层实现类
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
public class JglxService implements IJglxService {

	private IJglxDao jglxDao;
	
	private Map appSysConfig;

	public void setJglxDao(IJglxDao jglxDao) {
		this.jglxDao = jglxDao;
	}
	
	public boolean deleteJglx(Integer jglxid) {
		Integer flag = jglxDao.deleteById(jglxid);
		if (flag != null) {
			appSysConfig = ActionContext.getContext().getApplication();
			List jglxList = new ArrayList();
			jglxList=jglxDao.findAllByFlag();
			appSysConfig.put("jglxList", jglxList);
			return true;
		}
		return false;
	}

	public List findAll() {
		return jglxDao.findAll();
	}
	
	public Page findByPage(Page page) {
		page.setRoot(jglxDao.findByPage(page));
		page.setTotalProperty(jglxDao.findByCount(page));
		return page;
	}

	public List findByPjglx(String pjglx) {
		return jglxDao.findByPjglx(pjglx);
	}
	
	public Object saveJglx(Jglx jglx) {
		Object objJglx= jglxDao.saveJglx(jglx);
		if(objJglx!=null){
			appSysConfig = ActionContext.getContext().getApplication();
			List jglxList = new ArrayList();
			jglxList=jglxDao.findAllByFlag();
			appSysConfig.put("jglxList", jglxList);
		}
		return objJglx;
	}

	public boolean updateJglx(Jglx jglx) throws Exception {
		Integer flag = jglxDao.update(jglx);
		if (flag != null) {
			appSysConfig = ActionContext.getContext().getApplication();
			List jglxList = new ArrayList();
			jglxList=jglxDao.findAllByFlag();
			appSysConfig.put("jglxList", jglxList);
			return true;
		}
		return false;
	}
	
	public Jglx findMcByDm(String code) {
		return jglxDao.findMcByDm(code);
	}

}
