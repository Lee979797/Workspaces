package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Jjlx;
import com.lhq.prj.bms.service.IJjlxService;

/**
 * JjlxAction.java Create on 2008-5-5
 * 
 * 办证机构管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class JjlxAction extends BaseAction {

	private IJjlxService jjlxService;

	private Jjlx jjlx;

	private Integer jjlxid;

	private boolean success;

	private Page page;
	
	private String jjlxmc;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String saveJjlx() {
		jjlxid = (Integer) jjlxService.saveJjlx(jjlx);
		if (jjlxid != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	/**
	 * 依据代码查询名称
	 * 
	 * */
	public String findJjlxNameByCode(){
		
		String code = getRequest().getParameter("jjlxdm");
		
		jjlx = jjlxService.findMcByDm(code);
		
		return SUCCESS;
	}
	
	
	/**
	 * 查找所有办证机构
	 * 
	 * @return
	 */
	public String findAllJjlx(){
		page = new Page();
		page.setRoot(jjlxService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionJjlx() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = jjlxService.findByPage(page);
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
	public String deleteJjlx() {
		String strJjlxid = getRequest().getParameter("jjlxid");
		if (strJjlxid != null && !"".equals(strJjlxid)) {
			success = jjlxService.deleteJjlx(Integer.valueOf(strJjlxid));
		}
		return SUCCESS;
	}

	/**
	 * 修改办证机构指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateJjlx() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strJjlxid = getRequest().getParameter("jjlxid");
		if (strJjlxid != null && !"".equals(strJjlxid)) {
			Jjlx c = new Jjlx();
			c.setJjlxid(Integer.valueOf(strJjlxid));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = jjlxService.updateJjlx(c);
		}
		return SUCCESS;
	}
	
	
	public Jjlx getJjlx() {
		return jjlx;
	}
	public void setJjlx(Jjlx jjlx) {
		this.jjlx = jjlx;
	}

	public Integer getJjlxid() {
		return jjlxid;
	}

	public void setJjlxid(Integer jjlxid) {
		this.jjlxid = jjlxid;
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

	public void setJjlxService(IJjlxService jjlxService) {
		this.jjlxService = jjlxService;
	}

	public String getJjlxmc() {
		return jjlxmc;
	}

	public void setJjlxmc(String jjlxmc) {
		this.jjlxmc = jjlxmc;
	}
	
}
