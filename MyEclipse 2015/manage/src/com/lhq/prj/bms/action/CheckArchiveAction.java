package com.lhq.prj.bms.action;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.po.CheckArchive;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.service.ICheckArchiveService;

public class CheckArchiveAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CheckArchive ca;
	private Integer orgid;
	private String jgdm;
	private ICheckArchiveService checkArchiveService;

	public String checkArchive(){
		System.out.println(orgid+":"+jgdm);
		//jglxOld,zchInfo,frInfo
		
		Orgnew orgnew = new Orgnew();
		orgnew.setOrgid(orgid);
		orgnew.setJgdm(jgdm);
		
		ca = checkArchiveService.checkArchive(orgnew);
		
		return SUCCESS;
	}
	
	public CheckArchive getCa() {
		return ca;
	}
	public void setCa(CheckArchive ca) {
		this.ca = ca;
	}

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	public void setCheckArchiveService(ICheckArchiveService checkArchiveService) {
		this.checkArchiveService = checkArchiveService;
	}
}
