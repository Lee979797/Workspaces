/*
 * @(#)ZslyAction.java 2008-10-11
 *
 * Copyright LHQ. All rights reserved.
 */

package com.lhq.prj.bms.action;

import java.util.Date;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Zsly;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.service.IOrgnewService;
import com.lhq.prj.bms.service.IZslyService;

/**
 * Create on 2012-12-19 
 * 
 * 证书利用
 * 
 * @author YQ
 * @version
 */
@SuppressWarnings("serial")
public class ZslyAction extends BaseAction {

	private IZslyService zslyService;
	private IOrgnewService orgnewService;
	private boolean success;
	private Page page;
	private Zsly zsly;
	private Integer id;
	private String zsbh;
	private String zslx;
	private String ssds;
	private String sszbjg;
	private Date fpsj;
	private Date dysj;
	private String flag;
	private String czy;
	private String djh;
	private String tip;


	/**
	 * 保存证书打印记录
	 * 
	 * @return
	 * @throws Exception 
	 */
	
 
	public String saveZsly() throws Exception {
		
		String zslx = getRequest().getParameter("txtZfbFlag");
		String addFuben = getRequest().getParameter("addFuben");
		String orgid = getRequest().getParameter("txtOrgid");
		String fbsl = getRequest().getParameter("txtFbsl");
		String zsbh = (String)getRequest().getParameter("txtzsbh_pre")+(String)getRequest().getParameter("txtzsbh_suf");
		String txtDjh = "组代管"+getRequest().getParameter("txtDjh");
		String txtJgdm = getRequest().getParameter("txtJgdm");
		String txtJgmc = new String(getRequest().getParameter("txtJgmc").getBytes("ISO-8859-1"),"GBK");
		System.out.print(txtJgmc);
		User user = (User) getSession().getAttribute("user");
		Zsly zsly = new Zsly();
		zsly.setDysj(new Date());
		zsly.setJgdm(txtJgdm);
		zsly.setJgmc(txtJgmc);
		zsly.setCzy(user.getUserName());
		zsly.setSsds(String.valueOf(user.getCenterCode()));
		zsly.setSsbzjg(user.getBzjgCode());
		zsly.setZslx(zslx);
		zsly.setZsbh(zsbh);
		zsly.setDjh(txtDjh);
		zsly.setFlag("1");
				
		success=zslyService.updateZsly(zsly);
		System.out.print(fbsl);
		System.out.print(success);
		if (success) {
			if(addFuben=="1" || "1".equals(addFuben)){
				Orgnew orgnew = new Orgnew();
				orgnew.setOrgid(Integer.valueOf(orgid));
				orgnew.setFbsl(Integer.valueOf(fbsl));
				success = orgnewService.updateOrgnew(orgnew);
			}
			return SUCCESS;
		}else{
			this.setTip("证书不能使用！");
			return INPUT;	
		}
		
	}


	@SuppressWarnings("unchecked")
	public String findZslyByZsbh() {
		String strQsbh = getRequest().getParameter("qsbh");
		String strJzbh = getRequest().getParameter("jzbh");
		String strZstype = getRequest().getParameter("zstype");
		String strJgdm = getRequest().getParameter("jgdm");
		
		page = new Page();
		page.setQsbh(strQsbh);
		page.setJzbh(strJzbh);
		page.setZstype(strZstype);
		page.setJgdm(strJgdm);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 10 : limit);
		page = zslyService.findByPage(page);
		return SUCCESS;
	}

	public String updateZsly() throws Exception {
		String fieldName = getRequest().getParameter("fieldName");
		String fieldValue = getRequest().getParameter("fieldValue");
		String strLogId = getRequest().getParameter("logId");
		if (strLogId != null && !"".equals(strLogId)) {
			Zsly zsly = new Zsly();
			zsly.setId(Integer.valueOf(strLogId));
			MyUtils.invokeSetMethod(fieldName, zsly, new Object[] { fieldValue });
			success = zslyService.updateZsly(zsly);
		}
		return SUCCESS;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Zsly getZsly() {
		return zsly;
	}

	public void setZsly(Zsly zsly) {
		this.zsly = zsly;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setZslyService(IZslyService zslyService) {
		this.zslyService = zslyService;
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

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	public String getZsbh() {
		return zsbh;
	}

	public void setZslx(String zslx) {
		this.zslx = zslx;
	}

	public String getZslx() {
		return zslx;
	}
	public void setSsds(String ssds) {
		this.ssds = ssds;
	}

	public String getSsds() {
		return ssds;
	}
	
	public void setSszbjg(String sszbjg) {
		this.sszbjg = sszbjg;
	}

	public String getSszbjg() {
		return sszbjg;
	}
	
	public void setFpsj(Date fpsj) {
		this.fpsj = fpsj;
	}

	public Date getFpsj() {
		return fpsj;
	}

	public void setDysj(Date dysj) {
		this.dysj = dysj;
	}
	
	public Date getDysj() {
		return dysj;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getFlag() {
		return flag;
	}
	
	public void setCzy(String czy) {
		this.czy = czy;
	}

	public String getCzy() {
		return flag;
	}
	
	public void setDjh(String djh) {
		this.djh = djh;
	}

	public String getDjh() {
		return djh;
	}


	public void setTip(String tip) {
		this.tip = tip;
	}


	public String getTip() {
		return tip;
	}

}
