package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Bzjg;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IBzjgService;
import com.lhq.prj.bms.service.ITjgdmService;
import com.lhq.prj.bms.service.IZuserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * ZuserAction.java Create on 2012-5-9
 * 
 * 用户处理
 * 
 * Copyright (c) 2012 by YQ.
 * 
 * @author
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ZuserAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IZuserService zuserService;

	private ITjgdmService tjgdmService;

	private IBzjgService bzjgService;

	private Zuser zuser;

	private boolean success;

	private Page page;

	private Integer userid;

	private String userName;
	private String userName1;
	private String userName2;

	private String userPwd;
	private String userPwd1;
	private String userPwd2;
	private String userPwdOld;

	/** 注册号 */
	private String orgZch;

	/** 行政区划名称 */
	private String xzqhName;
	/** 行政区划编码 */
	private String xzqhCode;

	/** 机构 编码 */
	private Integer orgid;
	/** 机构姓名 */
	private String orgName;
	/** 机构 编码 */
	private String orgCode;
	/** 机构 类型 */
	private String orgType;
	/** 机构 类型 */
	private String pzjgmc;
	/** 机构 类型 */
	private String pzjgdm;

	private String bzjgdm;
	/** 手机 */
	private String mPhone;
	/** 电话 */
	private String tel;
	/** 电子邮件 */
	private String email;
	/** 联系地址 */
	private String address;
	/** 邮政编码 */
	private String postalcode;
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sex;

	/** 证件类型 */
	private String zjlx;

	/** 身份证号码 */
	private String sfzHao;
	/** 通知信息方式 */
	private Integer msgType;
	/** 备注 */
	private String note;

	private String state;

	private String tip;

	private String validateStr11;

	public String getValidateStr11() {
		return validateStr11;
	}

	public void setValidateStr11(String validateStr11) {
		this.validateStr11 = validateStr11;
	}

	public String zlogout() {
		getSession().removeAttribute("jgdm");
		getSession().removeAttribute("bzjgdm");
		success = true;
		return SUCCESS;
	}

	public String checkZuser() {
		String strUserName = getRequest().getParameter("userName");
		if (strUserName != "" || "".equals(strUserName)) {
			success = zuserService.checkZuser(strUserName);
		}
		return SUCCESS;
	}

	public String checkZuserJgmc() {
		String strJgmc = getRequest().getParameter("jgmc");
		if (strJgmc != "" || "".equals(strJgmc)) {
			success = zuserService.checkZuserJgmc(strJgmc);
		}
		return SUCCESS;
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String zlogin() {
		/*String jgdm = (String) getSession().getAttribute("jgdm");*/
		String jgdm = "010883003";
		if (jgdm != null && !jgdm.equals("")) {
			userName2 = jgdm;
			getSession().removeAttribute("jgdm");
		} else {
			this.setTip("请从页面通过认证！");
			return "veri";
		}
		Tjgdm tjgdm = new Tjgdm();
		tjgdm.setJgdm(userName2);
		tjgdm = tjgdmService.returnTjgdmByJgdm(tjgdm);
		Map appSysConfig = ActionContext.getContext().getApplication();
		if (tjgdm != null) {
			if (tjgdm.getBzjgdm() != null && tjgdm.getBzjgdm().equals("610000")
					&& appSysConfig.get("sysCaSwitch").equals("1")) {
				if (tjgdm.getMemo() != null
						&& MyUtils.ToSBC(tjgdm.getMemo()).equals(
								MyUtils.ToSBC("ca"))) {
					zuser = new Zuser();
					zuser.setOrgCode(userName2);
					zuser.setBzjgdm(tjgdm.getBzjgdm());
					zuserService.zlogin(zuser);

					this.setTip("new");// 新用户
					getSession().setAttribute("jgdm", userName2);
					getSession().setAttribute("bzjgdm", tjgdm.getBzjgdm());
					getSession().setAttribute("zuser", null);
					return SUCCESS;
				} else {
					System.out.println("您所持数字证书未在质监注册，请与数字证书公司联系！");
					this.setTip("您所持数字证书未在质监注册，请与数字证书公司联系！");
					return INPUT;
				}
			} else {
				zuser = new Zuser();
				zuser.setOrgCode(userName2);
				zuser.setBzjgdm(tjgdm.getBzjgdm());
				zuserService.zlogin(zuser);

				this.setTip("new");// 新用户
				getSession().setAttribute("jgdm", userName2);
				getSession().setAttribute("bzjgdm", tjgdm.getBzjgdm());
				getSession().setAttribute("zuser", null);
				return SUCCESS;
			}
		} else {
			System.out.println("无企业信息！");
			this.setTip("无企业信息！");
			return INPUT;
		}
	}

	public String zloginNew() {
		Zuser zuser = new Zuser();
		zuser.setUserName(userName2);
		zuser.setUserPwd(userPwd2);
		Zuser _zuser = zuserService.zlogin(zuser);
		System.out.println("::::::::::::::::" + _zuser);
		if (_zuser != null) {
			this.setTip("new");// 新用户
			getSession().setAttribute("jgdm", "");
			getSession().setAttribute("bzjgdm", _zuser.getBzjgdm());
			getSession().setAttribute("zuser", _zuser);
			Bzjg bzjg = new Bzjg();
			bzjg.setBzjgCode(_zuser.getBzjgdm());
			bzjg = bzjgService.findByBzjgdm(bzjg);
			getSession().setAttribute("bfdw", bzjg.getBzjgName());
			return SUCCESS;
		} else {
			this.setTip("用户名密码错误，或用户注册没审核通过!");
			return INPUT;
		}
	}

	/**
	 * 用户注册
	 * 
	 * @return
	 */
	public String regZuser() {

		// 此处数据集合，在录入界面中定义zuser.sex
		String validateStr = getRequest().getParameter("validateStr"); // 验证码
		String ccode2 = (String) getSession().getAttribute("ccode"); // 验证码

		if (validateStr.equals(ccode2) || validateStr == ccode2) {
			Zuser zuser = new Zuser();
			zuser.setUserName(userName1);
			zuser.setUserPwd(userPwd1);
			zuser.setOrgCode(orgCode);
			zuser.setOrgName(orgName);
			zuser.setPzjgmc(pzjgmc);
			zuser.setPzjgdm(pzjgdm);
			zuser.setBzjgdm(bzjgdm);
			zuser.setAddress(address);
			zuser.setOrgZch(orgZch);
			zuser.setEmail(email);
			zuser.setTel(tel);

			userid = (Integer) zuserService.regZuser(zuser);
			if (userid != null) {
				success = true;
				return SUCCESS;
			} else {
				this.setTip("用户名已存在，不可注册！!");
				return INPUT;
			}
		} else {
			getSession().setAttribute("msg", "验证码错误！");
			return INPUT;
		}
	}

	/**
	 * 添加系统用户
	 * 
	 * @return
	 */
	public String saveZuser() {
		userid = (Integer) zuserService.saveZuser(zuser);
		if (userid != null) {
			success = true;
		}
		return SUCCESS;
	}

	/**
	 * 查找用户信息
	 * 
	 * @return
	 */
	public String findAllZuser() {
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = zuserService.findByPage(page);
		return SUCCESS;
	}

	public String findByExample() {
		page = new Page();
		page.setRoot(zuserService.findByExample(zuser));
		return SUCCESS;
	}

	public String findUserInfo() {

		String strUserName = getRequest().getParameter("username");
		Zuser zu = new Zuser();
		zu.setUserName(strUserName);

		page = new Page();
		page.setRoot(zuserService.findUserInfo(zu));
		return SUCCESS;
	}

	public String updatePwd() {

		zuser = new Zuser();
		zuser.setUserid(userid);
		zuser.setUserPwd(userPwd);
		success = zuserService.updatePwd(userPwdOld, zuser);

		return SUCCESS;
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String deleteZuser() {
		String strZuserid = getRequest().getParameter("userid");
		if (strZuserid != null && !"".equals(strZuserid)) {
			success = zuserService.deleteZuser(Integer.valueOf(strZuserid));
		}
		return SUCCESS;
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateZuser() throws Exception {

		Zuser zuser = new Zuser();
		zuser.setZuserId(Integer.valueOf(userid));
		zuser.setOrgName(orgName);
		zuser.setOrgCode(orgCode);
		zuser.setOrgZch(orgZch);
		zuser.setPzjgmc(pzjgmc);
		zuser.setPzjgdm(pzjgdm);
		zuser.setPostalcode(postalcode);
		zuser.setName(name);
		zuser.setZjlx(zjlx);
		zuser.setSfzHao(sfzHao);
		zuser.setAddress(address);
		zuser.setMPhone(mPhone);
		zuser.setTel(tel);
		zuser.setEmail(email);
		zuser.setNote(note);
		zuser.setXzqhCode(xzqhCode);
		zuser.setXzqhName(xzqhName);

		String strUserid = getRequest().getParameter("userid");
		if (strUserid != null && !"".equals(strUserid)) {
			success = zuserService.updateZuser(zuser);
		}
		return SUCCESS;
	}

	public String findJgdmByUserid() {
		String strZuserid = getRequest().getParameter("userid");
		if (strZuserid != null && !"".equals(strZuserid)) {
			orgCode = zuserService
					.findJgdmByUserid(Integer.valueOf(strZuserid));
		}
		return SUCCESS;
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

	public Zuser getZuser() {
		return zuser;
	}

	public void setZuser(Zuser zuser) {
		this.zuser = zuser;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getZuserid() {
		return userid;
	}

	public void setZuserId(Integer userid) {
		this.userid = userid;
	}

	public void setZuserService(IZuserService zuserService) {
		this.zuserService = zuserService;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgZch(String orgZch) {
		this.orgZch = orgZch;
	}

	public String getOrgZch() {
		return orgZch;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setMPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public String getMPhone() {
		return mPhone;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setSfzHao(String sfzHao) {
		this.sfzHao = sfzHao;
	}

	public String getSfzHao() {
		return sfzHao;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNote() {
		return note;
	}

	public void setXzqhName(String xzqhName) {
		this.xzqhName = xzqhName;
	}

	public String getXzqhName() {
		return xzqhName;
	}

	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}

	public String getXzqhCode() {
		return xzqhCode;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	public String getPzjgmc() {
		return pzjgmc;
	}

	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}

	public String getPzjgdm() {
		return pzjgdm;
	}

	public String getUserPwdOld() {
		return userPwdOld;
	}

	public void setUserPwdOld(String userPwdOld) {
		this.userPwdOld = userPwdOld;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	public String getUserName2() {
		return userName2;
	}

	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}

	public String getUserPwd1() {
		return userPwd1;
	}

	public void setUserPwd1(String userPwd1) {
		this.userPwd1 = userPwd1;
	}

	public String getUserPwd2() {
		return userPwd2;
	}

	public void setUserPwd2(String userPwd2) {
		this.userPwd2 = userPwd2;
	}

	public String getBzjgdm() {
		return bzjgdm;
	}

	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}

	public void setTjgdmService(ITjgdmService tjgdmService) {
		this.tjgdmService = tjgdmService;
	}

	public void setBzjgService(IBzjgService bzjgService) {
		this.bzjgService = bzjgService;
	}
}
