package com.lhq.prj.bms.po;

import java.io.Serializable;

/**
 * SysConfig.java Create on 2013-4-18 下午03:02:11
 * 
 * 系统参数设置
 * 
 * Copyright (c) 2013 by YQ.
 * 
 * @author yangqi
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SysConfig implements Serializable {

	public SysConfig() {
	}

	public SysConfig(Integer configId,String configCode,String configName, String configValue, String note) {
		this.configId = configId;
		this.setConfigCode(configCode);
		this.configName = configName;
		this.configValue = configValue;
		this.note=note;
	}

	private Integer configId;
	
	private String configCode;

	private String configName;

	private String configValue;
	
	private String note;

	
	public Integer getConfigId() {
		return configId;
	}
	
	public void setConfigId(Integer configId) {
		this.configId = configId;
	}
	

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}

	public String getConfigCode() {
		return configCode;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}
}
