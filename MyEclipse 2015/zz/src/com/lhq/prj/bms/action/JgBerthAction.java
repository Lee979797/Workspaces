package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.JgBerth;
import com.lhq.prj.bms.service.IJgBerthService;

public class JgBerthAction extends BaseAction {
	
	private int jgid;
	private String jgmc;
	private String jgdm;
	private String jgdz;
	private String pzjgmc;
	private String pzjgdm;
	private String zch;
	private String email;
	private String dhhm;
	private String state;
	private int userid; 
	private Page page;
	private boolean success;
	private IJgBerthService jgberthService;
	
	public String saveJgBerth(){
		JgBerth jb = new JgBerth();
		System.out.println(":::::::::::::"+jgid);
		jb.setJgid(jgid);
		jb.setJgdm(jgdm);
		jb.setJgmc(jgmc);
		jb.setJgdz(jgdz);
		jb.setPzjgmc(pzjgmc);
		jb.setPzjgdm(pzjgdm);
		jb.setDhhm(dhhm);
		jb.setEmail(email);
		jb.setState(state);
		jb.setUserid(userid);
		jb.setZch(zch);
		System.out.println(jb);
		if(jgid>0){
			//库中已存在的机构
			jgberthService.updateJgBerth(jb);
			success = true;
		}else{//
			int id = jgberthService.findJgBerthByJgmc(jb);
			if(id > 0){
				jb.setJgid(id);
				jgberthService.updateJgBerth(jb);
				success = true;
			}else{
				success = jgberthService.saveJgBerth(jb);
			}
		}
		return SUCCESS;
	}
	
	public String delJgBerth(){
		
		JgBerth jb = new JgBerth();
		System.out.println(jgid);
		jb.setJgid(jgid);
		success = jgberthService.delJgBerth(jb);
		return SUCCESS;
	}
	
	public String findAllJgBerth(){
		int userId = Integer.valueOf(getRequest().getParameter("userid"));
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setUserid(userId);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = jgberthService.findAllJgBerth(page);
		return SUCCESS;
	}
	
	public int getJgid() {
		return jgid;
	}
	public void setJgid(int jgid) {
		this.jgid = jgid;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getJgdz() {
		return jgdz;
	}
	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}
	public String getPzjgmc() {
		return pzjgmc;
	}
	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}
	public String getPzjgdm() {
		return pzjgdm;
	}
	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}
	public String getZch() {
		return zch;
	}
	public void setZch(String zch) {
		this.zch = zch;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDhhm() {
		return dhhm;
	}
	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public IJgBerthService getJgberthService() {
		return jgberthService;
	}
	public void setJgberthService(IJgBerthService jgberthService) {
		this.jgberthService = jgberthService;
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
