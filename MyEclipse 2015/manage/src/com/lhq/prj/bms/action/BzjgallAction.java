package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Bzjgall;
import com.lhq.prj.bms.service.IBzjgallService;

/**
 * BzjgallAction.java Create on 2008-5-5
 * 
 * 办证机构管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BzjgallAction extends BaseAction {

	private IBzjgallService bzjgallService;

	private Bzjgall bzjgall;

	private Integer bzjgid;

	private boolean success;

	private Page page;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String saveBzjgall() {
		bzjgid = (Integer) bzjgallService.saveBzjgall(bzjgall);
		if (bzjgid != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 查找所有办证机构
	 * 
	 * @return
	 */
	public String findAllBzjgall(){
		page = new Page();
		page.setRoot(bzjgallService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionBzjgall() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = bzjgallService.findByPage(page);
		if (null != page.getRoot()) {
			page.setSuccess(true);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 删除办证机构
	 * 
	 * @return
	 */
	public String deleteBzjgall() {
		String strBzjgid = getRequest().getParameter("bzjgid");
		if (strBzjgid != null && !"".equals(strBzjgid)) {
			success = bzjgallService.deleteBzjgall(Integer.valueOf(strBzjgid));
		}
		return SUCCESS;
	}

	/**
	 * 修改办证机构指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateBzjgall() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strBzjgid = getRequest().getParameter("bzjgid");
		if (strBzjgid != null && !"".equals(strBzjgid)) {
			Bzjgall c = new Bzjgall();
			c.setBzjgid(Integer.valueOf(strBzjgid));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = bzjgallService.updateBzjgall(c);
		}
		return SUCCESS;
	}
	
	
	public Bzjgall getBzjgall() {
		return bzjgall;
	}
	public void setBzjgall(Bzjgall bzjgall) {
		this.bzjgall = bzjgall;
	}

	public Integer getBzjgid() {
		return bzjgid;
	}

	public void setBzjgid(Integer bzjgid) {
		this.bzjgid = bzjgid;
	}
	
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setBzjgallService(IBzjgallService bzjgallService) {
		this.bzjgallService = bzjgallService;
	}
}
