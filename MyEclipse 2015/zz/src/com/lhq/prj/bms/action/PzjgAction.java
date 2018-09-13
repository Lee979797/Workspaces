package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.service.IPzjgService;

/**
 * PzjgAction.java Create on 2008-5-5
 * 
 * 办证机构管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PzjgAction extends BaseAction {

	private IPzjgService pzjgService;

	private Pzjg pzjg;

	private Integer pzjgid;

	private boolean success;

	private Page page;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String savePzjg() {
		pzjgid = (Integer) pzjgService.savePzjg(pzjg);
		if (pzjgid != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 查找所有办证机构
	 * 
	 * @return
	 */
	public String findAllPzjg(){
		page = new Page();
		page.setRoot(pzjgService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionPzjg() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = pzjgService.findByPage(page);
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
	public String deletePzjg() {
		String strPzjgid = getRequest().getParameter("pzjgid");
		if (strPzjgid != null && !"".equals(strPzjgid)) {
			success = pzjgService.deletePzjg(Integer.valueOf(strPzjgid));
		}
		return SUCCESS;
	}

	/**
	 * 修改办证机构指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updatePzjg() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strPzjgid = getRequest().getParameter("pzjgid");
		if (strPzjgid != null && !"".equals(strPzjgid)) {
			Pzjg c = new Pzjg();
			c.setPzjgid(Integer.valueOf(strPzjgid));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = pzjgService.updatePzjg(c);
		}
		return SUCCESS;
	}
	
	
	public Pzjg getPzjg() {
		return pzjg;
	}
	public void setPzjg(Pzjg pzjg) {
		this.pzjg = pzjg;
	}

	public Integer getPzjgid() {
		return pzjgid;
	}

	public void setPzjgid(Integer pzjgid) {
		this.pzjgid = pzjgid;
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

	public void setPzjgService(IPzjgService pzjgService) {
		this.pzjgService = pzjgService;
	}
}
