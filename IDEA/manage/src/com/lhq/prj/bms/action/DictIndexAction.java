package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.DictIndex;
import com.lhq.prj.bms.service.IDictIndexService;

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
public class DictIndexAction extends BaseAction {

	private IDictIndexService dictIndexService;

	private DictIndex dictIndex;

	private Integer subjectId;

	private boolean success;

	private Page page;

	/**
	 * ����ְ����ݿ�
	 * 
	 * @return
	 */
	public String saveDictIndex() {
		subjectId = (Integer) dictIndexService.saveDictIndex(dictIndex);
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
	public String findAllDictIndex() {
		page = new Page();
		page.setRoot(dictIndexService.findAll());
		return SUCCESS;
	}

	
	
	/**
	 * ɾ���Ŀ
	 * 
	 * @return
	 */
	public String deleteDictIndex() {
		String strSubjectId = getRequest().getParameter("subjectId");
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			success = dictIndexService.deleteDictIndex(Integer.valueOf(strSubjectId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ŀ�Ŀָ���ֶε�ֵ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateDictIndex() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strSubjectId = getRequest().getParameter("subjectId");
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			DictIndex c = new DictIndex();
			c.setSubjectId(Integer.valueOf(strSubjectId));
			MyUtils.invokeSetMethod(fieldName, c, new Object[] { fieldValue });
			success = dictIndexService.updateDictIndex(c);
		}
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public DictIndex getDictIndex() {
		return dictIndex;
	}

	public void setDictIndex(DictIndex dictIndex) {
		this.dictIndex = dictIndex;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public void setDictIndexService(IDictIndexService dictIndexService) {
		this.dictIndexService = dictIndexService;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
