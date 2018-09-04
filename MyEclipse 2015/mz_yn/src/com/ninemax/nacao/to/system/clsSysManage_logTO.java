package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * 系统管理日志
 * @author Administrator
 *
 */
public class clsSysManage_logTO implements Serializable{
	
	private String oper_id;
	private String operdate;
	private String user_id;
	private String oper_rightkey;
	private String oper_describe;
	
	private static final long serialVersionUID = 100002l;
	public String getOper_id() {
		return oper_id;
	}
	public void setOper_id(String oper_id) {
		this.oper_id = oper_id;
	}
	public String getOperdate() {
		return operdate;
	}
	public void setOperdate(String operdate) {
		this.operdate = operdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOper_rightkey() {
		return oper_rightkey;
	}
	public void setOper_rightkey(String oper_rightkey) {
		this.oper_rightkey = oper_rightkey;
	}
	public String getOper_describe() {
		return oper_describe;
	}
	public void setOper_describe(String oper_describe) {
		this.oper_describe = oper_describe;
	}
	
	
	
}
