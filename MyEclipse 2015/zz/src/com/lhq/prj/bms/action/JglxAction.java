package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Jglx;
import com.lhq.prj.bms.service.IJglxService;

/**
 * JglxAction.java Create on 2008-5-5
 * 
 * 办证机构管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class JglxAction extends BaseAction {

	private IJglxService jglxService;

	private Jglx jglx;

	private Integer jglxid;

	private boolean success;

	private Page page;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String saveJglx() {
		jglxid = (Integer) jglxService.saveJglx(jglx);
		if (jglxid != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 查找所有办证机构
	 * 
	 * @return
	 */
	public String findAllJglx(){
		page = new Page();
		page.setRoot(jglxService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionJglx() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = jglxService.findByPage(page);
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
	public String deleteJglx() {
		String strJglxid = getRequest().getParameter("jglxid");
		if (strJglxid != null && !"".equals(strJglxid)) {
			success = jglxService.deleteJglx(Integer.valueOf(strJglxid));
		}
		return SUCCESS;
	}

	/**
	 * 修改办证机构指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateJglx() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strJglxid = getRequest().getParameter("jglxid");
		if (strJglxid != null && !"".equals(strJglxid)) {
			Jglx c = new Jglx();
			c.setJglxid(Integer.valueOf(strJglxid));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = jglxService.updateJglx(c);
		}
		return SUCCESS;
	}
	
	private String pjglxmc;
	public String findByJglxdm()throws Exception {
		
		String jglxdm = getRequest().getParameter("jglxdm");
		pjglxmc = jglxService.findByJglxdm(jglxdm);
		
		return SUCCESS;
	}
	
	public Jglx getJglx() {
		return jglx;
	}
	public void setJglx(Jglx jglx) {
		this.jglx = jglx;
	}

	public Integer getJglxid() {
		return jglxid;
	}

	public void setJglxid(Integer jglxid) {
		this.jglxid = jglxid;
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

	public void setJglxService(IJglxService jglxService) {
		this.jglxService = jglxService;
	}

	public String getPjglxmc() {
		return pjglxmc;
	}

	public void setPjglxmc(String pjglxmc) {
		this.pjglxmc = pjglxmc;
	}
	
}
