package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.service.IBzjgService;

/**
 * BzjgAction.java Create on 2008-5-5
 * 
 * 办证机构管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BzjgAction extends BaseAction {

	private IBzjgService bzjgService;

	private Bzjg bzjg;

	private Integer bzjgid;

	private boolean success;

	private Page page;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String saveBzjg() {
		bzjgid = (Integer) bzjgService.saveBzjg(bzjg);
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
	public String findAllBzjg(){
		page = new Page();
		page.setRoot(bzjgService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionBzjg() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = bzjgService.findByPage(page);
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
	public String deleteBzjg() {
		String strBzjgid = getRequest().getParameter("bzjgid");
		if (strBzjgid != null && !"".equals(strBzjgid)) {
			success = bzjgService.deleteBzjg(Integer.valueOf(strBzjgid));
		}
		return SUCCESS;
	}

	/**
	 * 修改办证机构指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateBzjg() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strBzjgid = getRequest().getParameter("bzjgid");
		if (strBzjgid != null && !"".equals(strBzjgid)) {
			Bzjg c = new Bzjg();
			c.setBzjgId(Integer.valueOf(strBzjgid));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = bzjgService.updateBzjg(c);
		}
		return SUCCESS;
	}
	
	
	public Bzjg getBzjg() {
		return bzjg;
	}
	public void setBzjg(Bzjg bzjg) {
		this.bzjg = bzjg;
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

	public void setBzjgService(IBzjgService bzjgService) {
		this.bzjgService = bzjgService;
	}
}
