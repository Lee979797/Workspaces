package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.service.IBzjgService;

/**
 * BzjgAction.java Create on 2008-9-16 ����10:35:18
 * 
 * ���Ŵ���
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class BzjgAction extends BaseAction {
	private IBzjgService bzjgService;

	private Bzjg bzjg;

	private boolean success;

	private Page page;

	private Integer bzjgId;

	/**
	 * ��Ӳ���
	 * 
	 * @return
	 */
	public String saveBzjg() {
		bzjgId = (Integer) bzjgService.saveBzjg(bzjg);
		if (bzjgId != null) {
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
	public String findBzjgByCenter() {
		String strCenterId = getRequest().getParameter("centerId");
		Center center = new Center();
		if(strCenterId != null && !"".equals(strCenterId)){
			center.setCenterId(Integer.valueOf(strCenterId));
		}
		List conditions = new ArrayList();
		conditions.add(center);
		page = new Page();
		page.setConditions(conditions);
		page = bzjgService.findBzjgByCenter(page);
		return SUCCESS;
	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllBzjg() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = bzjgService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * 
	 * @return
	 */
	public String deleteBzjg() {
		String strBzjgId = getRequest().getParameter("bzjgId");
		if (strBzjgId != null && !"".equals(strBzjgId)) {
			success = bzjgService.deleteBzjg(Integer.valueOf(strBzjgId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateBzjg() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strBzjgId = getRequest().getParameter("bzjgId");
		if (strBzjgId != null && !"".equals(strBzjgId)) {
			Bzjg bzjg = new Bzjg();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				bzjg.setCenterId(Integer.valueOf(strCenterId));
			}
			bzjg.setBzjgId(Integer.valueOf(strBzjgId));
			MyUtils.invokeSetMethod(fieldName, bzjg, new Object[] { fieldValue });
			success = bzjgService.updateBzjg(bzjg);
		}
		return SUCCESS;
	}

	public Bzjg getBzjg() {
		return bzjg;
	}

	public void setBzjg(Bzjg bzjg) {
		this.bzjg = bzjg;
	}

	public void setBzjgService(IBzjgService bzjgService) {
		this.bzjgService = bzjgService;
	}

	public Integer getBzjgId() {
		return bzjgId;
	}

	public void setBzjgId(Integer bzjgId) {
		this.bzjgId = bzjgId;
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
