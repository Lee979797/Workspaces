package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Center;
import com.lhq.prj.bms.po.CodeManage;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.service.ICodeManageService;


/**
 * CodeManageAction.java Create on 2008-9-16 ����10:35:18
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CodeManageAction extends BaseAction {
	private ICodeManageService codeManageService;
	private CodeManage codeManage;
	private boolean success;
	private Page page;
	private Integer id;
	private String qsdm;
	private String jzdm;
	private Integer dmsl;
	private String fmtype;
	private String fmjgdm;
	private String fmjgmc;
	private String fpbzjg;
	private String flag;
	private Date lrsj;
	private Integer userid;
	private String username;
	private String name;
	private String note;
	


	public String saveCodeManage() {
		
		qsdm= getRequest().getParameter("qsdm");
		jzdm= getRequest().getParameter("jzdm");
		fmtype= getRequest().getParameter("fmtype");
		fmjgdm= getRequest().getParameter("fmjgdm");
		fmjgmc= getRequest().getParameter("fmjgmc");
		fpbzjg= getRequest().getParameter("fpbzjg");
		note=getRequest().getParameter("note");
		Integer qsdm1=0;
		Integer jzdm1=0;
		if("0".equals(fmtype)){
			qsdm1 = Integer.valueOf(qsdm.substring(1));
			jzdm1 = Integer.valueOf(jzdm.substring(1));
		}else{
			qsdm1 = Integer.valueOf(qsdm);
			jzdm1 = Integer.valueOf(jzdm);
		}
		dmsl=(int)(jzdm1-qsdm1+1);
		
		User user = (User) getSession().getAttribute("user");
		Integer strUserid=user.getUserId();
		String strUsername=user.getUserName();
		String strName=user.getEmplName();
		String strCenterid= user.getCenterCode();;
		
		CodeManage codeManage = new CodeManage();
		codeManage.setId(id);
		codeManage.setCenterid(strCenterid);
		codeManage.setQsdm(qsdm);
		codeManage.setJzdm(jzdm);
		codeManage.setFmtype(fmtype);
		codeManage.setFmjgdm(fmjgdm);
		codeManage.setFmjgmc(fmjgmc);
		codeManage.setDmsl(dmsl);
		codeManage.setFpbzjg(fpbzjg);
		codeManage.setUserid(strUserid);
		codeManage.setUsername(strUsername);
		codeManage.setName(strName);
		codeManage.setLrsj(new Date());
		codeManage.setFlag("1");
		codeManage.setNote(note);

		id = (Integer) codeManageService.saveCodeManage(codeManage);
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
	public String findCodeManageByCenter() {
		String strCenterId = getRequest().getParameter("centerId");
		Center center = new Center();
		if(strCenterId != null && !"".equals(strCenterId)){
			center.setCenterId(Integer.valueOf(strCenterId));
		}
		List conditions = new ArrayList();
		conditions.add(center);
		page = new Page();
		page.setConditions(conditions);
		page = codeManageService.findCodeManageByCenter(page);
		return SUCCESS;
	}

	/**
	 * ���Ҳ�����Ϣ
	 * 
	 * @return
	 */
	public String findAllCodeManage() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = codeManageService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * ɾ����
	 * @return
	 */
	public String deleteCodeManage() {
		String strCodeManageId = getRequest().getParameter("id");
		if (strCodeManageId != null && !"".equals(strCodeManageId)) {
			success = codeManageService.deleteCodeManage(Integer.valueOf(strCodeManageId));
		}
		return SUCCESS;
	}

	/**
	 * �޸Ĳ�����Ϣ
	 * @return
	 * @throws Exception
	 */
	public String updateCodeManage() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strCodeManageId = getRequest().getParameter("id");
		if (strCodeManageId != null && !"".equals(strCodeManageId)) {
			CodeManage codeManage = new CodeManage();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//codeManage.setCenterId(Integer.valueOf(strCenterId));
			}
			//codeManage.setCodeManageId(Integer.valueOf(strCodeManageId));
			MyUtils.invokeSetMethod(fieldName, codeManage, new Object[] { fieldValue });
			success = codeManageService.updateCodeManage(codeManage);
		}
		return SUCCESS;
	}

	//无用，可删除
	public String fpCodeManage() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String strCenterId = getRequest().getParameter("centerId");// ��÷ֹ�˾id,���޸������ֹ�˾ʱ����ֵ������
		String fieldValue = getRequest().getParameter("fieldValue");
		String strCodeManageId = getRequest().getParameter("id");
		if (strCodeManageId != null && !"".equals(strCodeManageId)) {
			CodeManage codeManage = new CodeManage();
			if ("centerName".equals(fieldName) && !"".equals(strCenterId)) {// ���޸������ֹ�˾��ʱ�������⴦��
				//codeManage.setCenterId(Integer.valueOf(strCenterId));
			}
			//codeManage.setCodeManageId(Integer.valueOf(strCodeManageId));
			MyUtils.invokeSetMethod(fieldName, codeManage, new Object[] { fieldValue });
			success = codeManageService.updateCodeManage(codeManage);
		}
		return SUCCESS;
	}

	public CodeManage getCodeManage() {
		return codeManage;
	}

	public void setCodeManage(CodeManage codeManage) {
		this.codeManage = codeManage;
	}

	public void setCodeManageService(ICodeManageService codeManageService) {
		this.codeManageService = codeManageService;
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
