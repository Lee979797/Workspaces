package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * 系统加载日志
 * @author Administrator
 *
 */
public class clsDataload_logTO implements Serializable {
	
	private String oper_id;
	private String operdate;
	private String loadamount;
	private String status;
	private static final long serialVersionUID = 100001l;
	
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
	public String getLoadamount() {
		return loadamount;
	}
	public void setLoadamount(String loadamount) {
		this.loadamount = loadamount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
