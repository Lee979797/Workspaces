package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Hylx;
import com.lhq.prj.bms.service.IHylxService;

/**
 * HylxAction.java Create on 2008-5-5
 * 
 * 办证机构管理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class HylxAction extends BaseAction {

	private IHylxService hylxService;

	private Hylx hylx;

	private Integer hylxid;

	private boolean success;

	private Page page;
	
	private String hylxmc;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String saveHylx() {
		hylxid = (Integer) hylxService.saveHylx(hylx);
		if (hylxid != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	/**
	 * 依据代码查询名称
	 * 
	 * */
	public String findHylxNameByCode(){
		
		String code = getRequest().getParameter("hylxdm");
		
		hylx=hylxService.findMcByDm(code);
		
		return SUCCESS;
	}
	
	/**
	 * 查找所有办证机构
	 * 
	 * @return
	 */
	public String findAllHylx(){
		page = new Page();
		page.setRoot(hylxService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionHylx() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = hylxService.findByPage(page);
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
	public String deleteHylx() {
		String strHylxid = getRequest().getParameter("hylxid");
		if (strHylxid != null && !"".equals(strHylxid)) {
			success = hylxService.deleteHylx(Integer.valueOf(strHylxid));
		}
		return SUCCESS;
	}

	/**
	 * 修改办证机构指定字段的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateHylx() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strHylxid = getRequest().getParameter("hylxid");
		if (strHylxid != null && !"".equals(strHylxid)) {
			Hylx c = new Hylx();
			c.setHylxid(Integer.valueOf(strHylxid));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = hylxService.updateHylx(c);
		}
		return SUCCESS;
	}
	
	
	public Hylx getHylx() {
		return hylx;
	}
	public void setHylx(Hylx hylx) {
		this.hylx = hylx;
	}

	public Integer getHylxid() {
		return hylxid;
	}

	public void setHylxid(Integer hylxid) {
		this.hylxid = hylxid;
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

	public void setHylxService(IHylxService hylxService) {
		this.hylxService = hylxService;
	}

	public void setHylxmc(String hylxmc) {
		this.hylxmc = hylxmc;
	}

	public String getHylxmc() {
		return hylxmc;
	}
}
