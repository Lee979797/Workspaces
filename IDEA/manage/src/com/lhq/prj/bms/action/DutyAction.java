package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Duty;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.service.IDutyService;

/**
 * DutyAction.java Create on 2008-9-18 ����08:10:48
 * 
 * ְ�����
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DutyAction extends BaseAction {

	private IDutyService dutyService;

	private Duty duty;

	private Integer dutyId;

	private boolean success;

	private Page page;
	
	
	/**
	 * ����ְ����ݿ�
	 *
	 * @return
	 */
	public String saveDuty() {
		dutyId = (Integer) dutyService.saveDuty(duty);
		if (dutyId != null) {
			success = true;
		}
		return SUCCESS;
	}
	
	
	/**
	 * ��������ְ��
	 * 
	 * @return
	 */
	public String findAllDuty(){
		page = new Page();
		page.setRoot(dutyService.findAll());
		return SUCCESS;
	}


	/**
	 * ɾ��ְ��
	 * 
	 * @return
	 */
	public String deleteDuty() {
		String strDutyId = getRequest().getParameter("dutyId");
		if (strDutyId != null && !"".equals(strDutyId)) {
			success = dutyService.deleteDuty(Integer.valueOf(strDutyId));
		}
		return SUCCESS;
	}

	/**
	 * �޸�ְ��ָ���ֶε�ֵ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateDuty() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strDutyId = getRequest().getParameter("dutyId");
		String strFuncCode = getRequest().getParameter("funcCode");
		if (strDutyId != null && !"".equals(strDutyId)) {
			Duty c = new Duty();
			if ("funcName".equals(fieldName) && !"".equals(strFuncCode)) {
				c.setFuncCode(strFuncCode);
			}
			c.setDutyId(Integer.valueOf(strDutyId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = dutyService.updateDuty(c);
		}
		return SUCCESS;
	}
	
	public String qxDuty() throws Exception {
		String strDutyId = getRequest().getParameter("dutyId");
		String strDutyName = getRequest().getParameter("dutyName");
		String strFuncName = MyUtils.str_replace(getRequest().getParameter("funcName")," ","");
		String strFuncCode = getRequest().getParameter("funcCode");
		String strRemark = getRequest().getParameter("remark");
		if (strDutyId != null && !"".equals(strDutyId)) {
			Duty duty = new Duty();
			duty.setDutyId(Integer.valueOf(strDutyId));
			duty.setDutyName(strDutyName);
			duty.setFuncName(strFuncName);
			duty.setFuncCode(strFuncCode);
			duty.setRemark(strRemark);
			success = dutyService.updateDuty(duty);
		}
		return SUCCESS;
	}
	
	
	public Duty getDuty() {
		return duty;
	}

	public void setDuty(Duty duty) {
		this.duty = duty;
	}

	public Integer getDutyId() {
		return dutyId;
	}

	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
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

	public void setDutyService(IDutyService dutyService) {
		this.dutyService = dutyService;
	}
}
