package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Keylog;
import com.lhq.prj.bms.service.IKeylogService;

/**
 * KeylogAction.java Create on 2008-9-18 下午08:10:48
 * 
 * 主键的管理
 * 
 * Copyright (c) 2012 by yq.
 * 
 * @author YQ
 * @version 1.0
 */
@SuppressWarnings("serial")
public class KeylogAction extends BaseAction {

	private IKeylogService keylogService;

	private Keylog keylog;

	private Integer LogID;

	private boolean success;

	private Page page;
	
	/**
	 * 生成主键
	 * flag=tableName
	 * flag2=wordtrack 
	 * @return 
	 */
	public String createKey() {
		String flag = getRequest().getParameter("tableName");
		String flag2 = getRequest().getParameter("wordtrack");
		page = new Page();
		page.setFlag(flag);
		page.setFlag2(flag2);
		page = keylogService.createKey(page);
		return SUCCESS;
	}
	
	public Keylog getKeylog() {
		return keylog;
	}

	public void setKeylog(Keylog keylog) {
		this.keylog = keylog;
	}

	public Integer getLogID() {
		return LogID;
	}
	public void setLogID(Integer LogID) {
		this.LogID = LogID;
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

	public void setKeylogService(IKeylogService keylogService) {
		this.keylogService = keylogService;
	}
}
