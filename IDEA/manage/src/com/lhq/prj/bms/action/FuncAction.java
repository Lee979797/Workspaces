package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Func;
import com.lhq.prj.bms.service.IFuncService;

/**
 * FuncAction.java Create on 2008-9-18 ����08:10:48
 * 
 * ְ�����
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class FuncAction extends BaseAction {

	private IFuncService funcService;

	private Func func;

	private Integer funcId;

	private boolean success;

	private Page page;
	
	
	/**
	 * ����ְ����ݿ�
	 *
	 * @return
	 */
	public String saveFunc() {
		funcId = (Integer) funcService.saveFunc(func);
		if (funcId != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * ��������ְ��
	 * 
	 * @return
	 */
	public String findAllFunc(){
		page = new Page();
		page.setRoot(funcService.findAll());
		return SUCCESS;
	}


	/**
	 * ɾ��ְ��
	 * 
	 * @return
	 */
	public String deleteFunc() {
		String strFuncId = getRequest().getParameter("funcId");
		if (strFuncId != null && !"".equals(strFuncId)) {
			success = funcService.deleteFunc(Integer.valueOf(strFuncId));
		}
		return SUCCESS;
	}

	/**
	 * �޸�ְ��ָ���ֶε�ֵ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateFunc() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strFuncId = getRequest().getParameter("funcId");
		if (strFuncId != null && !"".equals(strFuncId)) {
			Func c = new Func();
			c.setFuncId(Integer.valueOf(strFuncId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = funcService.updateFunc(c);
		}
		return SUCCESS;
	}
	
	
	public Func getFunc() {
		return func;
	}

	public void setFunc(Func func) {
		this.func = func;
	}

	public Integer getFuncId() {
		return funcId;
	}

	public void setFuncId(Integer funcId) {
		this.funcId = funcId;
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

	public void setFuncService(IFuncService funcService) {
		this.funcService = funcService;
	}
}
