package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Ywset;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IYwsetService;

/**
 * YwsetAction.java Create on 2008-9-16 ����10:35:18
 * 
 * ���Ŵ���
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class YwsetAction extends BaseAction {
	private IYwsetService ywsetService;

	private Ywset ywset;

	private boolean success;

	private Page page;

	private Integer ywsetId;

	/**
	 * ��Ӳ���
	 * 
	 * @return
	 */
	public String saveYwset() {
		Zuser zuser = (Zuser)getSession().getAttribute("zuser");
		ywsetId = (Integer) ywsetService.saveYwset(ywset,zuser.getBzjgdm());
		if (ywsetId != null) {
			success = true;
		}
		return SUCCESS;
	}

//	/**
//	 * ��ݷֹ�˾���Ҳ���
//	 * 
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public String findYwsetByBzjg() {
//		String strBzjgdm = getRequest().getParameter("bzjgdm");
//		Bzjg bzjg = new Bzjg();
//		if(strBzjgdm != null && !"".equals(strBzjgdm)){
//			bzjg.setBzjgCode(strBzjgdm);
//		}
//		List conditions = new ArrayList();
//		conditions.add(bzjg);
//		page = new Page();
//		page.setConditions(conditions);
//		page = ywsetService.findYwsetByBzjg(page);
//		return SUCCESS;
//	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllYwset() {
		String strCondition = getRequest().getParameter("conditions");
		String strFlag = getRequest().getParameter("flag");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setFlag(strFlag);
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		
		page = ywsetService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * 
	 * @return
	 */
	public String deleteYwset() {
		Zuser zuser = (Zuser)getSession().getAttribute("zuser");
		String strYwsetId = getRequest().getParameter("ywsetId");
		if (strYwsetId != null && !"".equals(strYwsetId)) {
			success = ywsetService.deleteYwset(Integer.valueOf(strYwsetId),zuser.getBzjgdm());
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateYwset() throws Exception {
		Zuser zuser = (Zuser)getSession().getAttribute("zuser");
		String fieldName = getRequest().getParameter("fieldName");
		String strBzjgdm = getRequest().getParameter("bzjgdm");
		String strYwlxdm = getRequest().getParameter("ywlxdm");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strYwsetId = getRequest().getParameter("ywsetId");
		if (strYwsetId != null && !"".equals(strYwsetId)) {
			Ywset ywset = new Ywset();
			if ("bzjgmc".equals(fieldName) && !"".equals(strBzjgdm)) {//办证机构代码
				ywset.setBzjgdm(strBzjgdm);
			}
			if ("ywlx".equals(fieldName) && !"".equals(strYwlxdm)) {//业务类型代码
				ywset.setYwlxdm(strYwlxdm);
			}
			ywset.setYwsetId(Integer.valueOf(strYwsetId));
			MyUtils.invokeSetMethod(fieldName, ywset, new Object[] { fieldValue });
			success = ywsetService.updateYwset(ywset,zuser.getBzjgdm());
		}
		return SUCCESS;
	}

	public Ywset getYwset() {
		return ywset;
	}

	public void setYwset(Ywset ywset) {
		this.ywset = ywset;
	}

	public void setYwsetService(IYwsetService ywsetService) {
		this.ywsetService = ywsetService;
	}

	public Integer getYwsetId() {
		return ywsetId;
	}

	public void setYwsetId(Integer ywsetId) {
		this.ywsetId = ywsetId;
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
