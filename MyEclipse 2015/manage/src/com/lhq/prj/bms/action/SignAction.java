package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.service.ISignService;

public class SignAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ISignService signService;
	private String re;
	private String errorMessage = "";
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setSignService(ISignService signService) {
		this.signService = signService;
	}

	public String getSign(){
		String jgdm = getRequest().getParameter("jgdm");
		String bzjgdm = getRequest().getParameter("bzjgdm");
		String bzrq = getRequest().getParameter("bzrq");
		
		re = signService.getSign(jgdm,bzjgdm,bzrq);
		errorMessage = signService.getErrorMessage();
		System.out.println("跟踪re:"+re);
		return SUCCESS;
	}

	public String getRe() {
		return re;
	}

	public void setRe(String re) {
		this.re = re;
	}
		
}
