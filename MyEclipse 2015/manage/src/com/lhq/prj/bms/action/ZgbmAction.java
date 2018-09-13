package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.service.IZgbmService;

@SuppressWarnings("serial")
public class ZgbmAction extends BaseAction {
	private IZgbmService zgbmService;
	
	private boolean success;

	private Page page;
	
	private String zgjgmc;
	
	public String findAllZgbm(){
		page = new Page();
		page.setRoot(zgbmService.findAll());
		return SUCCESS;
	}
	
	/**
	 * 依据代码查询名称
	 * 
	 * */
	public String findZgjgNameByCode(){
		
		String code = getRequest().getParameter("jgdm");
		
		setZgjgmc(zgbmService.findMcByDm(code));
		
		return SUCCESS;
	}
	
	
	@SuppressWarnings("unchecked")
	public String findAllByConditionZgbm() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = zgbmService.findByPage(page);
		if (null != page.getRoot()) {
			page.setSuccess(true);
		}
		return SUCCESS;
	}
	
	

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setZgbmService(IZgbmService zgbmService) {
		this.zgbmService = zgbmService;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setZgjgmc(String zgjgmc) {
		this.zgjgmc = zgjgmc;
	}

	public String getZgjgmc() {
		return zgjgmc;
	}
}
