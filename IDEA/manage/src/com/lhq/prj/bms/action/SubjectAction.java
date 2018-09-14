package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Subject;
import com.lhq.prj.bms.service.ISubjectService;

/**
 * SubjectAction.java Create on 2008-9-21 ����03:55:20
 * 
 * ��Ŀ����
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SubjectAction extends BaseAction {

	private ISubjectService subjectService;

	private Subject subject;

	private Integer subjectId;

	private boolean success;

	private Page page;

	/**
	 * ����ְ����ݿ�
	 * 
	 * @return
	 */
	public String saveSubject() {
		subjectId = (Integer) subjectService.saveSubject(subject);
		if (subjectId != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * �������п�Ŀ
	 * 
	 * @return
	 */
	public String findAllSubject() {
		page = new Page();
		page.setRoot(subjectService.findAll());
		return SUCCESS;
	}

	
	
	/**
	 * ɾ���Ŀ
	 * 
	 * @return
	 */
	public String deleteSubject() {
		String strSubjectId = getRequest().getParameter("subjectId");
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			success = subjectService.deleteSubject(Integer.valueOf(strSubjectId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ŀ�Ŀָ���ֶε�ֵ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateSubject() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strSubjectId = getRequest().getParameter("subjectId");
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			Subject c = new Subject();
			c.setSubjectId(Integer.valueOf(strSubjectId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = subjectService.updateSubject(c);
		}
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public void setSubjectService(ISubjectService subjectService) {
		this.subjectService = subjectService;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
