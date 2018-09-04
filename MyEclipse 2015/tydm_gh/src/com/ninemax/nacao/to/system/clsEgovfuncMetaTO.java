package com.ninemax.nacao.to.system;

public class clsEgovfuncMetaTO {
	
	private String egov_id;  //电子政务功能项ID
	private String meta_id;  //元数据ID
	private String meta_name;  //元数据名称
	private String meta_status;  //元数据状态 1：无效；0：有效
	private String meta_tablefield;  //元数据对应的表字段
	private String meta_table;  //元数据对应的物理表名称
	public String getEgov_id() {
		return egov_id;
	}
	public void setEgov_id(String egov_id) {
		this.egov_id = egov_id;
	}
	public String getMeta_id() {
		return meta_id;
	}
	public void setMeta_id(String meta_id) {
		this.meta_id = meta_id;
	}
	public String getMeta_name() {
		return meta_name;
	}
	public void setMeta_name(String meta_name) {
		this.meta_name = meta_name;
	}
	public String getMeta_status() {
		return meta_status;
	}
	public void setMeta_status(String meta_status) {
		this.meta_status = meta_status;
	}
	public String getMeta_tablefield() {
		return meta_tablefield;
	}
	public void setMeta_tablefield(String meta_tablefield) {
		this.meta_tablefield = meta_tablefield;
	}
	public String getMeta_table() {
		return meta_table;
	}
	public void setMeta_table(String meta_table) {
		this.meta_table = meta_table;
	}

}
