package com.lhq.prj.bms.action;

import java.util.ArrayList;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IZuserService;

/**
 * ZuserAction.java Create on 2012-5-9 
 * 
 * 用户处理
 * 
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ZuserAction extends BaseAction {

	public static final String SUCCESS_MANAGER = "success_manager";

	private IZuserService zuserService;

	private Zuser zuser;

	private boolean success;

	private Page page;

	private Integer userid;

	private String userName;
	
	private String userPwd;

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
	/** 手机 */
	private String mPhone;
	/** 电话 */
	private String tel;
	/** 电子邮件*/
	private String email;
	/** 联系地址*/
	private String address;
	/** 邮政编码*/
	private String postalcode;
	/**姓名*/
	private String name;
	/** 性别 */
	private String sex;
	
	/** 证件类型*/
	private String zjlx;
	
	/** 身份证号码*/
	private String sfzHao;
	/** 通知信息方式 */
	private Integer msgType;
	/** 备注 */
	private String note;

	private String state;
	
	private String tip;

	public String zlogout() {
		getSession().removeAttribute("zuser");
		success = true;
		return SUCCESS;
	}

	public String zlogin() {
		Zuser zuser = new Zuser();
		zuser.setUserName(userName);
		zuser.setUserPwd(userPwd);
		zuser.setState(state);
		Zuser _zuser = zuserService.zlogin(zuser);
		
		if (_zuser != null) {
			//if (zuser.isState() == true && _zuser.isState() == true) {
			//	this.setTip("manager");// 管理员
			//} else {
				this.setTip("simple");// 普通用户
			//}
			getSession().setAttribute("zuser", _zuser);
			return SUCCESS;
		} else {
			this.setTip("用户名或者密码错误!");
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
	 * 用户注册
	 * 
	 * @return
	 */
	public String regZuser() {
		userid = (Integer) zuserService.regZuser(zuser);
		if (userid != null) {
			success = true;
			return SUCCESS;
		}else{
			return INPUT;	
		}
	}


	/**
	 * 查找用户信息
	 * 
	 * @return
	 */
	public String findAllZuser() {
		String strCondition = getRequest().getParameter("conditions");
		String strUserBzjgdm = getRequest().getParameter("userBzjgdm");
		String strUserName = getRequest().getParameter("userName");
		
		//User user = (User) getSession().getAttribute("user");
		//String bzjgdm=user.getBzjgCode();
		//String userName=user.getUserName();
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		page.setBzjgdm(strUserBzjgdm);
		page.setUsername(strUserName);
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

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String deleteZuser() {
		String strUserid = getRequest().getParameter("userid");
		if (strUserid != null && !"".equals(strUserid)) {
			success = zuserService.deleteZuser(Integer.valueOf(strUserid));
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
		String strUserid = getRequest().getParameter("userid");
		zuser.setUserid(Integer.valueOf(strUserid));
		zuser.setOrgName(getRequest().getParameter("orgName"));
		zuser.setOrgCode(getRequest().getParameter("orgCode"));
		zuser.setOrgZch(getRequest().getParameter("orgZch"));
		zuser.setPzjgmc(getRequest().getParameter("pzjgmc"));
		zuser.setPzjgdm(getRequest().getParameter("pzjgdm"));
		zuser.setPostalcode(getRequest().getParameter("postalcode"));
		zuser.setName(getRequest().getParameter("name"));
		zuser.setZjlx(getRequest().getParameter("zjlx"));
		zuser.setSfzHao(getRequest().getParameter("sfzHao"));
		zuser.setAddress(getRequest().getParameter("address"));
		zuser.setmPhone(getRequest().getParameter("mPhone"));
		zuser.setTel(getRequest().getParameter("tel"));
		zuser.setEmail(getRequest().getParameter("email"));
		zuser.setNote(getRequest().getParameter("note"));
	
		if (strUserid != null && !"".equals(strUserid)) {
			success = zuserService.updateZuser(zuser);
		}
		return SUCCESS;
		
	}

	public String returnZuserOk() throws Exception {
		String strUserid = getRequest().getParameter("userid");
		if (strUserid != null && !"".equals(strUserid)) {
			Zuser zuser = new Zuser();
			zuser.setUserid(Integer.valueOf(strUserid));
			success = zuserService.returnZuserOk(zuser);
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
	public void setUserId(Integer userid) {
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

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
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

	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public Integer getOrgid() {
		return orgid;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}

	public String getPzjgmc() {
		return pzjgmc;
	}

}
