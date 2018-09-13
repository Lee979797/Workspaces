package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.service.IOrgwsrzService;

@SuppressWarnings("serial")
public class OrgwsrzAction extends BaseAction {

	private Page page;
	private IOrgwsrzService orgwsrzService;
	
	public String findOrgwsrzByConditions(){
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgwsrzService.findByPage(page);
		return SUCCESS;
	}


	public void setOrgwsrzService(IOrgwsrzService orgwsrzService) {
		this.orgwsrzService = orgwsrzService;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
