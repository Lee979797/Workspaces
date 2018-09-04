package com.ninemax.nacao.to.system;

public class clsEgovfuncTO {
	
	private String egov_id;  //电子政务功能项ID
	private String egov_name;  //电子政务功能名称
	private String egov_status;  //电子政务功能状态 状态 1：无效；0：有效
	private String egov_memo;  //电子政务功能备注
	public String getEgov_id() {
		return egov_id;
	}
	public void setEgov_id(String egov_id) {
		this.egov_id = egov_id;
	}
	public String getEgov_name() {
		return egov_name;
	}
	public void setEgov_name(String egov_name) {
		this.egov_name = egov_name;
	}
	public String getEgov_status() {
		return egov_status;
	}
	public void setEgov_status(String egov_status) {
		this.egov_status = egov_status;
	}
	public String getEgov_memo() {
		return egov_memo;
	}
	public void setEgov_memo(String egov_memo) {
		this.egov_memo = egov_memo;
	}
	

}
