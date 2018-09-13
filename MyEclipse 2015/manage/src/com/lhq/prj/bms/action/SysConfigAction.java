package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;
import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.SysConfig;
import com.lhq.prj.bms.service.ISysConfigService;


/**
 * SysConfigAction.java Create on 2013-4-18
 * 
 * 系统参数设置
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SysConfigAction extends BaseAction {

	private ISysConfigService sysConfigService;

	private SysConfig sysConfig;

	private Integer configId;

	private boolean success;

	private Page page;
	
	private String configCode;
	
	private String configName;
	
	private String configValue;
	
	
	/**
	 * 保存办证机构到数据库
	 *
	 * @return
	 */
	public String saveSysConfig() {
		configId = (Integer) sysConfigService.saveSysConfig(sysConfig);
		if (configId != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * 依据变量ConfigCode查询变量值
	 * 
	 * */
	public String findConfigValueByCode(){
		
		String configCode = getRequest().getParameter("configCode");
		
		setConfigValue(sysConfigService.findMcByDm(configCode));
		
		return SUCCESS;
	}
	
	/**
	 * 查找所有系统参数
	 * 
	 * @return
	 */
	public String findAllSysConfig(){
		page = new Page();
		page.setRoot(sysConfigService.findAll());
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String findAllByConditionSysConfig() {
		String strCondition = getRequest().getParameter("conditions");	
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page(); 
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = sysConfigService.findByPage(page);
		if (null != page.getRoot()) {
			page.setSuccess(true);
		}
		return SUCCESS;
	}
	
	
	/**
	 * 删除系统参数
	 * 
	 * @return
	 */
	public String deleteSysConfig() {
		String strSysConfigId = getRequest().getParameter("configId");
		if (strSysConfigId != null && !"".equals(strSysConfigId)) {
			success = sysConfigService.deleteSysConfig(Integer.valueOf(strSysConfigId));
		}
		return SUCCESS;
	}

	/**
	 * 修改办系统参数的值
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateSysConfig() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strConfigId = getRequest().getParameter("configId");
		if (strConfigId != null && !"".equals(strConfigId)) {
			SysConfig c = new SysConfig();
			c.setConfigId(Integer.valueOf(strConfigId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = sysConfigService.updateSysConfig(c);
		}
		return SUCCESS;
	}
	
	
	public SysConfig getSysConfig() {
		return sysConfig;
	}
	public void setSysConfig(SysConfig sysConfig) {
		this.sysConfig = sysConfig;
	}

	public Integer getSysConfigId() {
		return configId;
	}

	public void setSysConfigId(Integer configId) {
		this.configId = configId;
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

	public void setSysConfigService(ISysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}


	public String getConfigCode() {
		return configCode;
	}


	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigName() {
		return configName;
	}
	
	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigValue() {
		return configValue;
	}
	
}
