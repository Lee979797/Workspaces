package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.KeyLog;
import com.lhq.prj.bms.service.IKeyLogService;

/**
 * KeyLogAction.java Create on 2008-9-16 ����10:35:18
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class KeyLogAction extends BaseAction {
	private IKeyLogService keyLogService;
	private KeyLog keyLog;
	private boolean success;
	private Page page;
	private Integer id;
	/**
	 * ��Ӳ���
	 * 
	 * @return
	 */
	public String saveKeyLog() {
		id = (Integer) keyLogService.saveKeyLog(keyLog);
		if (id != null) {
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
	public String findKeyLogByCenter() {
		String strCenterId = getRequest().getParameter("centerId");
		Center center = new Center();
		if(strCenterId != null && !"".equals(strCenterId)){
			center.setCenterId(Integer.valueOf(strCenterId));
		}
		List conditions = new ArrayList();
		conditions.add(center);
		page = new Page();
		page.setConditions(conditions);
		page = keyLogService.findKeyLogByCenter(page);
		return SUCCESS;
	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllKeyLog() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = keyLogService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * @return
	 */
	public String deleteKeyLog() {
		String strKeyLogId = getRequest().getParameter("id");
		if (strKeyLogId != null && !"".equals(strKeyLogId)) {
			success = keyLogService.deleteKeyLog(Integer.valueOf(strKeyLogId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public String updateKeyLog() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strKeyLogId = getRequest().getParameter("id");
		if (strKeyLogId != null && !"".equals(strKeyLogId)) {
			KeyLog keyLog = new KeyLog();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//keyLog.setCenterId(Integer.valueOf(strCenterId));
			}
			//keyLog.setKeyLogId(Integer.valueOf(strKeyLogId));
			MyUtils.invokeSetMethod(fieldName, keyLog, new Object[] { fieldValue });
			success = keyLogService.updateKeyLog(keyLog);
		}
		return SUCCESS;
	}

	public KeyLog getKeyLog() {
		return keyLog;
	}

	public void setKeyLog(KeyLog keyLog) {
		this.keyLog = keyLog;
	}

	public void setKeyLogService(IKeyLogService keyLogService) {
		this.keyLogService = keyLogService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
