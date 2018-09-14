package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.DictDetail;
import com.lhq.prj.bms.po.DictIndex;
import com.lhq.prj.bms.service.IDictDetailService;

/**
 * DeptAction.java Create on 2008-9-16 ����10:35:18
 * 
 * ���ദ��
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author �����
 * @version 1.0
 */
@SuppressWarnings("serial")
public class DictDetailAction extends BaseAction {
	private IDictDetailService dictDetailService;

	private DictDetail dictDetail;

	private boolean success;

	private Page page;

	private Integer categoryId;

	/**
	 * ��ӷ���
	 * 
	 * @return
	 */
	public String saveDictDetail() {
		categoryId = (Integer) dictDetailService.saveDictDetail(dictDetail);
		if (categoryId != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * ��ݷֿ�Ŀ���ҷ���
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String findDictDetailByDictIndex() {
		String strSubjectId = getRequest().getParameter("subjectId");
		DictDetail dictDetail = new DictDetail();
		if (strSubjectId != null && !"".equals(strSubjectId)) {
			dictDetail.setSubjectId(Integer.valueOf(strSubjectId));
		}
		List conditions = new ArrayList();
		conditions.add(dictDetail);
		page = new Page();
		page.setConditions(conditions);
		page = dictDetailService.findDictDetailByDictIndex(page);
		return SUCCESS;
	}
	
	
	/**
	 * 依据代码查询名称
	 * 
	 * */

	public String findDictCodeByName(){
		
		String strSubjectId = getRequest().getParameter("subjectId");
		String strCategoryName = getRequest().getParameter("categoryName");
		DictDetail dictDetail2 = new DictDetail();
		dictDetail2.setSubjectId(Integer.valueOf(strSubjectId));
		dictDetail2.setCategoryName(strCategoryName);
		dictDetail=dictDetailService.findMcByDm(dictDetail2);
		return SUCCESS;
	}
	
	/**
	 * �������з���
	 * 
	 * @return
	 */
	public String findAll() {
		page = new Page();
		page.setRoot(dictDetailService.findAll());
		return SUCCESS;
	}

	
	public String findAllBySubjectid() {
		String strSubjectId = getRequest().getParameter("subjectId");
		page = new Page();
		page.setRoot(dictDetailService.findAllBySubjectid(Integer.valueOf(strSubjectId)));
		return SUCCESS;
	}
	
	public String findByCategoryid() {
		String strCategoryId = getRequest().getParameter("categoryId");
		page = new Page();
		page.setRoot(dictDetailService.findByCategoryid(Integer.valueOf(strCategoryId)));
		return SUCCESS;
	}
	
	/**
	 * ���ҷ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllDictDetail() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dictDetailService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ�����
	 * 
	 * @return
	 */
	public String deleteDictDetail() {
		String strCategoryId = getRequest().getParameter("categoryId");
		if (strCategoryId != null && !"".equals(strCategoryId)) {
			success = dictDetailService.deleteDictDetail(Integer.valueOf(strCategoryId));
		}
		return SUCCESS;
	}

	/**
	 * �޸ķ�����Ϣ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateDictDetail() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strSubjectId = getRequest().getParameter("subjectId");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strCategoryId = getRequest().getParameter("categoryId");
		if (strCategoryId != null && !"".equals(strCategoryId)) {
			DictDetail dictDetail = new DictDetail();
			if ("subjectName".equals(fieldName) && !"".equals(strSubjectId)) {
				dictDetail.setSubjectId(Integer.valueOf(strSubjectId));
			}
			dictDetail.setCategoryId(Integer.valueOf(strCategoryId));
			MyUtils.invokeSetMethod(fieldName, dictDetail, new Object[] { fieldValue });
			success = dictDetailService.updateDictDetail(dictDetail);
		}
		return SUCCESS;
	}

	public DictDetail getDictDetail() {
		return dictDetail;
	}

	public void setDictDetail(DictDetail dictDetail) {
		this.dictDetail = dictDetail;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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

	public void setDictDetailService(IDictDetailService dictDetailService) {
		this.dictDetailService = dictDetailService;
	}

}
