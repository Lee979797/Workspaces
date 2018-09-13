/*
 * @(#)CodeDetailAction.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.action;

import java.util.Date;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.CodeDetail;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.service.IOrgnewService;
import com.lhq.prj.bms.service.ICodeDetailService;

/**
 * Create on 2012-12-19 
 * 
 * 证书利用
 * 
 * @author YQ
 * @version
 */
@SuppressWarnings("serial")
public class CodeDetailAction extends BaseAction {

	private ICodeDetailService codeDetailService;
	private IOrgnewService orgnewService;
	private boolean success;
	private Page page;
	private CodeDetail codeDetail;
	private Integer id;
	private String jgdm;
	private String jgmc;
	private String zch;
	private String dmlx;
	private Date fumaDate;
	private String fumaUsername;
	private String fumaName;
	private String isFuma;
	private String tip;

	/**
	 * 保存赋码记录
	 * 
	 * @return
	 * @throws Exception 
	 */

	public String saveCodeDetail() throws Exception {
		
		String strJgdm = getRequest().getParameter("jgdm");
		String strJgmc = getRequest().getParameter("jgmc");
		String strDmlx = getRequest().getParameter("dmlx");
		String strZch = getRequest().getParameter("zch");
		
		User user = (User) getSession().getAttribute("user");
		CodeDetail codeDetail = new CodeDetail();
		codeDetail.setJgdm(strJgdm);
		codeDetail.setJgmc(strJgmc);
		codeDetail.setDmlx(strDmlx);
		codeDetail.setZch(strZch);
		codeDetail.setBzjgdm(user.getBzjgCode());
		codeDetail.setFumaUsername(user.getUserName());
		codeDetail.setFumaName(user.getEmplName());
		codeDetail.setFumaDate(new Date());
		codeDetail.setIsFuma("1");
				
		success=codeDetailService.updateCodeDetail(codeDetail);

		if (success) {
			//Orgnew orgnew = new Orgnew();
			//orgnew.setOrgid(Integer.valueOf(orgid));
			//orgnew.setFbsl(Integer.valueOf(fbsl));
			//success = orgnewService.updateOrgnew(orgnew);
			return SUCCESS;
		}else{
			this.setTip("证书不能使用！");
			return INPUT;	
		}
		
	}


	public String updateCodeDetail() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strLogId = getRequest().getParameter("logId");
		if (strLogId != null && !"".equals(strLogId)) {
			CodeDetail codeDetail = new CodeDetail();
			codeDetail.setId(Integer.valueOf(strLogId));
			MyUtils.invokeSetMethod(fieldName, codeDetail, new Object[] { fieldValue });
			success = codeDetailService.updateCodeDetail(codeDetail);
		}
		return SUCCESS;
	}
	
	/**
	 * 码段资源管理中，依据码段查询代码
	 * 
	 * */
	@SuppressWarnings("unchecked")
	public String findCodeByDmmd() {
		String strQsdm = getRequest().getParameter("qsdm");
		String strJzdm = getRequest().getParameter("jzdm");
		
		page = new Page();
		page.setQsdm(strQsdm);
		page.setJzdm(strJzdm);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 10 : limit);
		page = codeDetailService.findByDmmdPage(page);
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public CodeDetail getCodeDetail() {
		return codeDetail;
	}

	public void setCodeDetail(CodeDetail codeDetail) {
		this.codeDetail = codeDetail;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setCodeDetailService(ICodeDetailService codeDetailService) {
		this.codeDetailService = codeDetailService;
	}

	public void setOrgnewService(IOrgnewService orgnewService) {
		this.orgnewService = orgnewService;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}


	public String getJgdm() {
		return jgdm;
	}


	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}


	public String getJgmc() {
		return jgmc;
	}


	public void setZch(String zch) {
		this.zch = zch;
	}


	public String getZch() {
		return zch;
	}


	public void setDmlx(String dmlx) {
		this.dmlx = dmlx;
	}


	public String getDmlx() {
		return dmlx;
	}


	public void setFumaDate(Date fumaDate) {
		this.fumaDate = fumaDate;
	}


	public Date getFumaDate() {
		return fumaDate;
	}


	public void setFumaUsername(String fumaUsername) {
		this.fumaUsername = fumaUsername;
	}


	public String getFumaUsername() {
		return fumaUsername;
	}


	public void setFumaName(String fumaName) {
		this.fumaName = fumaName;
	}


	public String getFumaName() {
		return fumaName;
	}


	public void setIsFuma(String isFuma) {
		this.isFuma = isFuma;
	}

	public String getIsFuma() {
		return isFuma;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}


	public String getTip() {
		return tip;
	}

}
