package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Company;
import com.lhq.prj.bms.po.Dept;
import com.lhq.prj.bms.service.IDeptService;

/**
 * DeptAction.java Create on 2008-9-16 ����10:35:18
 * 
 * ���Ŵ���
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DeptAction extends BaseAction {
	private IDeptService deptService;

	private Dept dept;

	private boolean success;

	private Page page;

	private Integer deptId;

	/**
	 * ��Ӳ���
	 * 
	 * @return
	 */
	public String saveDept() {
		deptId = (Integer) deptService.saveDept(dept);
		if (deptId != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * ��ݷֹ�˾���Ҳ���
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDeptByCompany() {
		String strCompanyId = getRequest().getParameter("companyId");
		Company company = new Company();
		if(strCompanyId != null && !"".equals(strCompanyId)){
			company.setCompanyId(Integer.valueOf(strCompanyId));
		}
		List conditions = new ArrayList();
		conditions.add(company);
		page = new Page();
		page.setConditions(conditions);
		page = deptService.findDeptByCompany(page);
		return SUCCESS;
	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllDept() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = deptService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * 
	 * @return
	 */
	public String deleteDept() {
		String strDeptId = getRequest().getParameter("deptId");
		if (strDeptId != null && !"".equals(strDeptId)) {
			success = deptService.deleteDept(Integer.valueOf(strDeptId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateDept() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCompanyId = getRequest().getParameter("companyId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strDeptId = getRequest().getParameter("deptId");
		if (strDeptId != null && !"".equals(strDeptId)) {
			Dept dept = new Dept();
			if ("companyName".equals(fieldName) && !"".equals(strCompanyId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				dept.setCompanyId(Integer.valueOf(strCompanyId));
			}
			dept.setDeptId(Integer.valueOf(strDeptId));
			MyUtils.invokeSetMethod(fieldName, dept, new Object[] { fieldValue });
			success = deptService.updateDept(dept);
		}
		return SUCCESS;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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

}
