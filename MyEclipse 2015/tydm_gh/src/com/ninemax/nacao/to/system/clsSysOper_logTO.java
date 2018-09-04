package com.ninemax.nacao.to.system;

import java.io.Serializable;

public class clsSysOper_logTO implements Serializable {
	
	private String operId;
	private String operdate;
	private String user_id;
	private String user_name;
	private String rightkey_id;
	private String operDescribe;
	private String operMemo;
	
	private static final long serialVersionUID = 100003l;
	public String getOperdate() {
		return operdate;
	}
	public void setOperdate(String operdate) {
		this.operdate = operdate;
	}
	public String getOperDescribe() {
		return operDescribe;
	}
	public void setOperDescribe(String operDescribe) {
		this.operDescribe = operDescribe;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getOperMemo() {
		return operMemo;
	}
	public void setOperMemo(String operMemo) {
		this.operMemo = operMemo;
	}
	public String getRightkey_id() {
		return rightkey_id;
	}
	public void setRightkey_id(String rightkey_id) {
		this.rightkey_id = rightkey_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	

}
