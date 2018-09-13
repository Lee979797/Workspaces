package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Xzqh;
import com.lhq.prj.bms.service.IXzqhService;

/**
 * XzqhAction.java Create on 2008-5-5
 * 
 * 行政区划管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class XzqhAction extends BaseAction {

	private IXzqhService xzqhService;

	private Xzqh xzqh;

	private Integer xzqhId;

	private boolean success;

	private Page page;
	
	
	/**
	 * 保存行政区划到数据库
	 *
	 * @return
	 */
	public String saveXzqh() {
		xzqhId = (Integer) xzqhService.saveXzqh(xzqh);
		if (xzqhId != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 查找所有行政区划
	 * 
	 * @return
	 */
	public String findAllXzqh(){
		page = new Page();
		page.setRoot(xzqhService.findAll());
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String findAllByConditionXzqh() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = xzqhService.findByPage(page);
		if (null != page.getRoot()) {
			page.setSuccess(true);
		}
		return SUCCESS;
	}

	/**
	 * 删除行政区划
	 * 
	 * @return
	 */
	public String deleteXzqh() {
		String strXzqhId = getRequest().getParameter("xzqhId");
		if (strXzqhId != null && !"".equals(strXzqhId)) {
			success = xzqhService.deleteXzqh(Integer.valueOf(strXzqhId));
		}
		return SUCCESS;
	}

	/**
	 * 修改行政区划指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateXzqh() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strXzqhId = getRequest().getParameter("xzqhId");
		if (strXzqhId != null && !"".equals(strXzqhId)) {
			Xzqh c = new Xzqh();
			c.setXzqhId(Integer.valueOf(strXzqhId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = xzqhService.updateXzqh(c);
		}
		return SUCCESS;
	}
	
	
	public Xzqh getXzqh() {
		return xzqh;
	}
	public void setXzqh(Xzqh xzqh) {
		this.xzqh = xzqh;
	}

	public Integer getXzqhId() {
		return xzqhId;
	}
	public void setXzqhId(Integer xzqhId) {
		this.xzqhId = xzqhId;
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

	public void setXzqhService(IXzqhService xzqhService) {
		this.xzqhService = xzqhService;
	}
}
