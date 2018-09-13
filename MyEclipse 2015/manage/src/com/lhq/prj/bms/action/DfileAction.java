package com.lhq.prj.bms.action;

import java.io.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.lhq.prj.bms.core.MyUtils;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.core.WriteImageData;
import com.lhq.prj.bms.po.Dfile;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.PrintLog;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IDfileService;
import com.lhq.prj.bms.service.impl.AutoAllocateCodeClientEncrypt;


/**
 * DfileAction.java Create on 2012-5-5
 * 机构管理
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
**/

@SuppressWarnings("serial")
public class DfileAction extends BaseAction {
	private IDfileService dfileService;
	private Map<String, String> dataMap;

	private Dfile dfile;
	private boolean success;
	private Page page;
	private Integer orgid;
	private File upload;// 上传的文件
	private String uploadContentType;// 上传问文件类型
	private String uploadFileName; // 上传文件名
	private String allowedTypes;// 允许上传的文件类型列表
	private String savePath;// 文件保存路径,通过ioc注入
	private float maxHeightSize;// 缩略图最大高度
	private float maxWidthSize;//缩略图最大宽度
	
	private String orderid;
	private String  centerid;
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String jglxdm;
	private String jglxOld;
	private String jglxdmOld;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jjlxdm;
	private String jjhydm;
	private String jjhymc;
	private String jjhydmOld;
	private String jjhymcOld;
	private String qyjj;
	private String jyfw;
	private String jjlx;
	private Date zcrq;
	private String zgdm;
	private String pzjgdm;
	private String xzqhCode;
	private String xzqhName;
	private String xzqhCode2;
	private String xzqhName2;
	private String jgdz;
	private String yzbm;
	private String dhhm;
	private Date scbzrq;
	private Date bzrq;
	private Date zfrq;
	private String bzjgdm;
	private String zycp1;
	private String zycp2;
	private String zycp3;
	private java.math.BigDecimal zczj;
	private String wftzgb;
	private String wftzgbdm;
	private String hbzl;
	private String hbzldm;
	private Integer zgrs;
	private Integer fbsl;
	private String zslsh;
	private String bgbj;
	private Date bgrq;
	private String lry;
	private Date njrq;
	private String njr;
	private Date njqx;
	private String xgr;
	private Integer zbsl;
	private String zch;
	private String qzbz;
	private Date qzrq;
	private String zgmc;
	private String pzjgmc;
	private String gslsh;
	private String gstbr;
	private String wjwlsh;
	private String pzwh;
	private Date pwrq;
	private String wjwtbr;
	private String gk;
	private String fkbz;
	private Integer fksl;
	private String dybz;
	private String email;
	private String weburl;
	private String mobile;
	private String djblx;
	private Date lastdate;
	private String czflag;
	private String yjflag;
	private String sjzt;
	private String jyjg;
	private Integer fz;
	private String memo;
	private String tbrzjlx;
	private String njjlx;
	private String memo2;
	private String memo3;
	private String memo4;
	private String tbrxm;
	private String tbrsfzh;
	private String isca;
	private String isxw;
	private String tbrlxfs;
	private Date gsfzrq;
	private String jydz;
	private String jyqhmc;
	private String jyqhdm;
	private String jyyb;
	private String jydh;
	private String jfly;
	private String khyh;
	private String khzh;
	private Date zsbfrq;
	private Date zszfrq;
	private String handleNote;
	
	private String moveoutCenter;
	private String moveoutBzjgdm;
	private String moveoutAddrss;
	private String moveoutReason;
	private String moveoutNote;
	private String offPzjgmc;
	private String offPzwh;
	private String offReason;
	private String offNote;
	
	private Integer d_flag;
	private Integer up_Dflag;
	private Integer up_Aflag;
	private String errorFlag;
	
	private String qyzclx;
	private String ywlx;
	private Integer userid;
	private String pageTypeStr;
	private String imageUrl;
	private String username;
	private String state;
	private Date collectTime;
	private int dfileCount;
	
	public DfileAction() {
		//初始化Map对象
		dataMap = new HashMap<String, String>();
	}
	
	/**
	* 添加临时库
	* @return
	 * @throws Exception 
	*/
	public String saveDfile() throws Exception {
		
		String sorgid = getRequest().getParameter("orgid");
		Dfile dfile = new Dfile();
		dfile.setOrgid(orgid);
		dfile.setCenterid(centerid);
		dfile.setJgdm(jgdm);
		dfile.setJgmc(jgmc);
		dfile.setJglx(jglx);
		dfile.setJglxdm(jglxdm);
		dfile.setJglxOld(jglxOld);
		dfile.setJglxdmOld(jglxdmOld);
		dfile.setFddbr(fddbr);
		
		dfile.setZjlx(zjlx);
		dfile.setZjhm(zjhm);
		dfile.setJjlxdm(jjlxdm);
		dfile.setJjhydm(jjhydm);
		dfile.setJjhymc(jjhymc);
		dfile.setJjhydmOld(jjhydmOld);
		dfile.setJjhymcOld(jjhymcOld);
		dfile.setQyjj(qyjj);
		dfile.setJyfw(jyfw);
		dfile.setJjlx(jjlx);
		dfile.setZcrq(zcrq);
		dfile.setZgdm(zgdm);
		dfile.setPzjgdm(pzjgdm);
		dfile.setXzqhCode(xzqhCode);
		dfile.setXzqhName(xzqhName);
		dfile.setXzqhCode2(xzqhCode2);
		dfile.setXzqhName2(xzqhName2);
		dfile.setJgdz(jgdz);
		dfile.setYzbm(yzbm);
		dfile.setDhhm(dhhm);
		dfile.setScbzrq(scbzrq);
		dfile.setBzrq(bzrq);
		dfile.setZfrq(zfrq);
		dfile.setBzjgdm(bzjgdm);
		dfile.setZycp1(zycp1);
		dfile.setZycp2(zycp2);
		dfile.setZycp3(zycp3);
		dfile.setZczj(zczj);
		dfile.setWftzgb(wftzgb);
		dfile.setHbzl(hbzl);
		dfile.setZgrs(zgrs);
		dfile.setFbsl(fbsl);
		dfile.setZslsh(zslsh);
		dfile.setBgbj(bgbj);
		dfile.setBgrq(bgrq);
		dfile.setLry(lry);
		dfile.setNjrq(njrq);
		dfile.setNjr(njr);
		dfile.setNjqx(njqx);
		dfile.setXgr(xgr);
		dfile.setZbsl(zbsl);
		dfile.setZch(zch);
		dfile.setQzbz(qzbz);
		dfile.setQzrq(qzrq);
		dfile.setZgmc(zgmc);
		dfile.setPzjgmc(pzjgmc);
		dfile.setGslsh(gslsh);
		dfile.setGstbr(gstbr);
		dfile.setWjwlsh(wjwlsh);
		dfile.setPzwh(pzwh);
		dfile.setPwrq(pwrq);
		dfile.setWjwtbr(wjwtbr);
		dfile.setGk(gk);
		dfile.setFkbz(fkbz);
		
		dfile.setFksl(fksl);
		dfile.setDybz(dybz);
		dfile.setEmail(email);
		dfile.setWeburl(weburl);
		dfile.setMobile(mobile);
		dfile.setDjblx(djblx);
		dfile.setLastdate(lastdate);
		dfile.setCzflag(czflag);
		dfile.setYjflag(yjflag);
		dfile.setSjzt(sjzt);
		dfile.setJyjg(jyjg);
		dfile.setFz(fz);
		dfile.setMemo(memo);
		dfile.setTbrzjlx(tbrzjlx);
		dfile.setNjjlx(njjlx);
		dfile.setMemo2(memo2);
		dfile.setMemo3(memo3);
		dfile.setMemo4(memo4);
		dfile.setTbrxm(tbrxm);
		dfile.setTbrsfzh(tbrsfzh);
		dfile.setIsca(isca);
		dfile.setTbrlxfs(tbrlxfs);
		dfile.setGsfzrq(gsfzrq);
		dfile.setJydz(jydz);
		dfile.setJyqhmc(jyqhmc);
		dfile.setJyqhdm(jyqhdm);
		dfile.setJyyb(jyyb);
		dfile.setJydh(jydh);
		dfile.setJfly(jfly);
		dfile.setKhyh(khyh);
		dfile.setKhzh(khzh);
		dfile.setZsbfrq(zsbfrq);
		dfile.setZszfrq(zszfrq);
		dfile.setMoveoutCenter(moveoutCenter);
		dfile.setMoveoutBzjgdm(moveoutBzjgdm);
		dfile.setMoveoutAddrss(moveoutAddrss);
		dfile.setMoveoutReason(moveoutReason);
		dfile.setOffPzjgmc(offPzjgmc);
		dfile.setOffPzwh(offPzwh);
		dfile.setOffReason(offReason);
		dfile.setOffNote(offNote);
		
		
		dfile.setD_flag(d_flag);
		dfile.setUp_Dflag(up_Dflag);
		dfile.setUp_Aflag(up_Aflag);
		dfile.setErrorFlag(errorFlag);
		
		dfile.setHandleNote(handleNote);
		
		dfile.setQyzclx(qyzclx);
		dfile.setYwlx(ywlx);
		dfile.setUserid(userid);
		dfile.setUsername(username);
		dfile.setState(state);
		

		if(sorgid != null && sorgid!="" && !"".equals(sorgid) ){
			dfileService.updateDfile(dfile);	
		}else{
			 orgid = (Integer) dfileService.saveDfile(dfile);		
		}
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",success:true,imageUrl:'" + dfile.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			//return INPUT;
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	/**
	* 添加正式库
	* @return
	 * @throws Exception 
	*/
	public String saveArchive() throws Exception {
		
		String sorgid = getRequest().getParameter("orgid");
		Dfile dfile = new Dfile();
		dfile.setOrgid(orgid);
		dfile.setOrderid(orderid);
		dfile.setCenterid(centerid);
		dfile.setJgdm(jgdm);
		dfile.setJgmc(jgmc);
		dfile.setJglx(jglx);
		dfile.setJglxdm(jglxdm);
		dfile.setJglxOld(jglxOld);
		dfile.setJglxdmOld(jglxdmOld);
		dfile.setFddbr(fddbr);
		
		dfile.setZjlx(zjlx);
		dfile.setZjhm(zjhm);
		dfile.setJjlxdm(jjlxdm);
		dfile.setJjhydm(jjhydm);
		dfile.setJjhymc(jjhymc);
		dfile.setJjhydmOld(jjhydmOld);
		dfile.setJjhymcOld(jjhymcOld);
		dfile.setQyjj(qyjj);
		dfile.setJyfw(jyfw);
		dfile.setJjlx(jjlx);
		dfile.setZcrq(zcrq);
		dfile.setZgdm(zgdm);
		dfile.setPzjgdm(pzjgdm);
		dfile.setXzqhCode(xzqhCode);
		dfile.setXzqhName(xzqhName);
		dfile.setXzqhCode2(xzqhCode2);
		dfile.setXzqhName2(xzqhName2);
		dfile.setJgdz(jgdz);
		dfile.setYzbm(yzbm);
		dfile.setDhhm(dhhm);
		dfile.setScbzrq(scbzrq);
		dfile.setBzrq(bzrq);
		dfile.setZfrq(zfrq);
		dfile.setBzjgdm(bzjgdm);
		dfile.setZycp1(zycp1);
		dfile.setZycp2(zycp2);
		dfile.setZycp3(zycp3);
		dfile.setZczj(zczj);
		dfile.setWftzgb(wftzgb);
		dfile.setHbzl(hbzl);
		dfile.setZgrs(zgrs);
		dfile.setFbsl(fbsl);
		dfile.setZslsh(zslsh);
		dfile.setBgbj(bgbj);
		dfile.setBgrq(bgrq);
		dfile.setLry(lry);
		dfile.setNjrq(njrq);
		dfile.setNjr(njr);
		dfile.setNjqx(njqx);
		dfile.setXgr(xgr);
		dfile.setZbsl(zbsl);
		dfile.setZch(zch);
		dfile.setQzbz(qzbz);
		dfile.setQzrq(qzrq);
		dfile.setZgmc(zgmc);
		dfile.setPzjgmc(pzjgmc);
		dfile.setGslsh(gslsh);
		dfile.setGstbr(gstbr);
		dfile.setWjwlsh(wjwlsh);
		dfile.setPzwh(pzwh);
		dfile.setPwrq(pwrq);
		dfile.setWjwtbr(wjwtbr);
		dfile.setGk(gk);
		dfile.setFkbz(fkbz);
		
		dfile.setFksl(fksl);
		dfile.setDybz(dybz);
		dfile.setEmail(email);
		dfile.setWeburl(weburl);
		dfile.setMobile(mobile);
		dfile.setDjblx(djblx);
		dfile.setLastdate(lastdate);
		dfile.setCzflag(czflag);
		dfile.setYjflag(yjflag);
		dfile.setSjzt(sjzt);
		dfile.setJyjg(jyjg);
		dfile.setFz(fz);
		dfile.setMemo(memo);
		dfile.setTbrzjlx(tbrzjlx);
		dfile.setNjjlx(njjlx);
		dfile.setMemo2(memo2);
		dfile.setMemo3(memo3);
		dfile.setMemo4(memo4);
		dfile.setTbrxm(tbrxm);
		dfile.setTbrsfzh(tbrsfzh);
		dfile.setIsca(isca);
		dfile.setIsxw(isxw);
		dfile.setTbrlxfs(tbrlxfs);
		dfile.setGsfzrq(gsfzrq);
		dfile.setJydz(jydz);
		dfile.setJyqhmc(jyqhmc);
		dfile.setJyqhdm(jyqhdm);
		dfile.setJyyb(jyyb);
		dfile.setJydh(jydh);
		dfile.setJfly(jfly);
		dfile.setKhyh(khyh);
		dfile.setKhzh(khzh);
		dfile.setZsbfrq(zsbfrq);
		dfile.setZszfrq(zszfrq);
		dfile.setMoveoutCenter(moveoutCenter);
		dfile.setMoveoutBzjgdm(moveoutBzjgdm);
		dfile.setMoveoutAddrss(moveoutAddrss);
		dfile.setMoveoutReason(moveoutReason);
		dfile.setOffPzjgmc(offPzjgmc);
		dfile.setOffPzwh(offPzwh);
		dfile.setOffReason(offReason);
		dfile.setOffNote(offNote);
		
		
		dfile.setD_flag(d_flag);
		dfile.setUp_Dflag(up_Dflag);
		dfile.setUp_Aflag(up_Aflag);
		dfile.setErrorFlag(errorFlag);
		
		dfile.setHandleNote(handleNote);
		
		dfile.setQyzclx(qyzclx);
		dfile.setYwlx(ywlx);
		dfile.setUserid(userid);
		dfile.setUsername(username);
		dfile.setState(state);
		

		if(sorgid != null && sorgid!="" && !"".equals(sorgid) ){
			dfileService.updateDfile(dfile);	
		}else{
			 orgid = (Integer) dfileService.saveDfile(dfile);		
		}
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",success:true,imageUrl:'" + dfile.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			//return INPUT;
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	
	/**
	 * 临时库查询
	 * 
	 * @return
	 */
	public String findDfile() {
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		if(strUserBzjgdm.equals(strCenterCode)){
			strUserBzjgdm=null;
		}
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
	
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
	
		page = new Page();
		page.setDflagConditions(dflagConditions);
		page.setConditions(conditions);
		page.setBzjgdm(strUserBzjgdm);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findDfileByPage(page);
		return SUCCESS;
	}
	
	/**
	 * 临时库权限查询
	 * 
	 * @return
	 */
	public String findQxDfile() {
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm="";
		/*String strCenterCode=user.getCenterCode();
		if(strUserBzjgdm.equals(strCenterCode)){
			strUserBzjgdm=null;
		}*/
		String strQxCode = user.getQxCode();
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
	
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
	
		page = new Page();
		page.setDflagConditions(dflagConditions);
		page.setConditions(conditions);
		page.setBzjgdm(strUserBzjgdm);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findDfileByQxPage(page);
		return SUCCESS;
	}
	
	public String findDfileCount(){

		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		if(strUserBzjgdm.equals(strCenterCode)){
			strUserBzjgdm=null;
		}
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
	
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
	
		page = new Page();
		page.setDflagConditions(dflagConditions);
		page.setConditions(conditions);
		page.setBzjgdm(strUserBzjgdm);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		dfileCount = dfileService.findDfileCount(page);
		success = true;
		return SUCCESS;
	
	}
	
	/**
	 * 临时库查询，高级
	 * 
	 * @return
	 */
	public String findDfileGjQuery() {
		String strJgdm = getRequest().getParameter("jgdm");
		if(strJgdm=="" || "".equals(strJgdm)){
			strJgdm=null;
		}
		String strJgmc = getRequest().getParameter("jgmc");
		if(strJgmc=="" || "".equals(strJgmc)){
			strJgmc=null;
		}
		String strNewdate1 = getRequest().getParameter("snewdate");
		String strNewdate2 = getRequest().getParameter("enewdate");
		if(strNewdate2!=null){
			if(strNewdate1==null){
				strNewdate1="1900-01-01";
			}
		}
		if(strNewdate1!=null) {
			if(strNewdate2==null){
				strNewdate2="9999-01-01";
			}
		}
		String strModifydate1 = getRequest().getParameter("smodifydate");
		String strModifydate2 = getRequest().getParameter("emodifydate");
		if (strModifydate2!=null){
			if(strModifydate1==null){
				strModifydate1="1900-01-01";
			}
		}
		if(strModifydate1!=null){
			if(strModifydate2==null){
				strModifydate2="9999-01-01";
			} 
		}
		
		String strArctype = getRequest().getParameter("arctype");
		if(strArctype=="" || "".equals(strArctype) || strArctype=="全部档案" || "全部档案".equals(strArctype)){
			strArctype=null;
		}
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		if(strUserBzjgdm.equals(strCenterCode)){
			strUserBzjgdm=null;
		}
		String strDflag = getRequest().getParameter("dflagConditions");
		String strCondition = getRequest().getParameter("conditions");
		
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, ","));
		
		page = new Page();
		page.setConditions(conditions);
		page.setDflagConditions(dflagConditions);
		page.setBzjgdm(strUserBzjgdm);
		
		page.setJgdm(strJgdm);
		page.setJgmc(strJgmc);
		page.setNewdate1(strNewdate1);
		page.setNewdate2(strNewdate2);
		page.setModifydate1(strModifydate1);
		page.setModifydate2(strModifydate2);
		page.setArctype(strArctype);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findDfileByGjPage(page);
		return SUCCESS;
	}

	
	/**
	 * 正式库查询
	 * 
	 * @return
	 */
	public String findArchive() {
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");
		
		User user = (User) getSession().getAttribute("user");
		/*String strUserBzjgdm=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		if(strUserBzjgdm.equals(strCenterCode)){
			strUserBzjgdm=null;
		}*/
		String strUserBzjgdm="";
		String strQxCode = user.getQxCode();
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		
		
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
		page = new Page();
		page.setConditions(conditions);
		page.setDflagConditions(dflagConditions);
		page.setBzjgdm(strUserBzjgdm);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findArchiveByPage(page);
		return SUCCESS;
	}
	
	/**
	 * 正式库查询，高级
	 * 
	 * @return
	 */
	public String findArchiveGjQuery() {
		String strJgdm = getRequest().getParameter("jgdm");
		if(strJgdm=="" || "".equals(strJgdm)){
			strJgdm=null;
		}
		String strJgmc = getRequest().getParameter("jgmc");
		if(strJgmc=="" || "".equals(strJgmc)){
			strJgmc=null;
		}
		String strNewdate1 = getRequest().getParameter("snewdate");
		String strNewdate2 = getRequest().getParameter("enewdate");
		if(strNewdate2!=null){
			if(strNewdate1==null){
				strNewdate1="1900-01-01";
			}
		}
		if(strNewdate1!=null) {
			if(strNewdate2==null){
				strNewdate2="9999-01-01";
			}
		}
		String strModifydate1 = getRequest().getParameter("smodifydate");
		String strModifydate2 = getRequest().getParameter("emodifydate");
		if (strModifydate2!=null){
			if(strModifydate1==null){
				strModifydate1="1900-01-01";
			}
		}
		if(strModifydate1!=null){
			if(strModifydate2==null){
				strModifydate2="9999-01-01";
			} 
		}
		
		String strArctype = getRequest().getParameter("arctype");
		if(strArctype=="" || "".equals(strArctype) || strArctype=="全部档案" || "全部档案".equals(strArctype)){
			strArctype=null;
		}
		
		User user = (User) getSession().getAttribute("user");
		String strBzjgCode=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		/*String strUserBzjgdm = getRequest().getParameter("bzjgdm");
		if(strBzjgCode.equals(strCenterCode)){
			if(strUserBzjgdm=="" || "".equals(strUserBzjgdm)){
				strUserBzjgdm=null;	
			}
		}else{
			strUserBzjgdm=strBzjgCode;
		}*/
		String strUserBzjgdm = "";
		String strQxCode = user.getQxCode();
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		
		
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, ","));
		
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
		page = new Page();
		page.setConditions(conditions);
		page.setDflagConditions(dflagConditions);
		page.setBzjgdm(strUserBzjgdm);
		page.setJgdm(strJgdm);
		page.setJgmc(strJgmc);
		page.setNewdate1(strNewdate1);
		page.setNewdate2(strNewdate2);
		page.setModifydate1(strModifydate1);
		page.setModifydate2(strModifydate2);
		page.setArctype(strArctype);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findArchiveByGjPage(page);
		return SUCCESS;
	}

	
	/**
	 * 全库库查询
	 * 
	 * @return
	 */
	public String findAllDfile() {
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");
		
		User user = (User) getSession().getAttribute("user");
		/*String strUserBzjgdm=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		if(strUserBzjgdm.equals(strCenterCode)){
			strUserBzjgdm=null;
		}*/
		String strUserBzjgdm="";
		String strQxCode = user.getQxCode();
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
		page = new Page();
		page.setDflagConditions(dflagConditions);
		page.setBzjgdm(strUserBzjgdm);
		page.setConditions(conditions);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findAllByPage(page);
		return SUCCESS;
	}
	
	
	/**
	 * 全库查询，简单查询
	 * 
	 * @return
	 */
	public String findAllDfileGjQuery() {
		String strJgdm = getRequest().getParameter("jgdm");
		if(strJgdm=="" || "".equals(strJgdm)){
			strJgdm=null;
		}
		String strJgmc = getRequest().getParameter("jgmc");
		if(strJgmc=="" || "".equals(strJgmc)){
			strJgmc=null;
		}
		String strNewdate1 = getRequest().getParameter("snewdate");
		String strNewdate2 = getRequest().getParameter("enewdate");
		if(strNewdate2!=null){
			if(strNewdate1==null){
				strNewdate1="1900-01-01";
			}
		}
		if(strNewdate1!=null) {
			if(strNewdate2==null){
				strNewdate2="9999-01-01";
			}
		}
		String strModifydate1 = getRequest().getParameter("smodifydate");
		String strModifydate2 = getRequest().getParameter("emodifydate");
		if (strModifydate2!=null){
			if(strModifydate1==null){
				strModifydate1="1900-01-01";
			}
		}
		if(strModifydate1!=null){
			if(strModifydate2==null){
				strModifydate2="9999-01-01";
			} 
		}
		
		
		String strArctype = getRequest().getParameter("arctype");
		if(strArctype=="" || "".equals(strArctype) || strArctype=="全部档案" || "全部档案".equals(strArctype)){
			strArctype=null;
		}
		
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");

		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm="";
		String strQxCode = user.getQxCode();
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		
		/*String strBzjgCode=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		String strUserBzjgdm = getRequest().getParameter("bzjgdm");
		if(strBzjgCode.equals(strCenterCode)){
			if(strUserBzjgdm=="" || "".equals(strUserBzjgdm)){
				strUserBzjgdm=null;	
			}
		}else{
			strUserBzjgdm=strBzjgCode;
		}*/
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, ","));
		
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
		page = new Page();
		page.setConditions(conditions);
		page.setBzjgdm(strUserBzjgdm);
		page.setDflagConditions(dflagConditions);
		page.setJgdm(strJgdm);
		page.setJgmc(strJgmc);
		page.setNewdate1(strNewdate1);
		page.setNewdate2(strNewdate2);
		page.setModifydate1(strModifydate1);
		page.setModifydate2(strModifydate2);
		page.setArctype(strArctype);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findAllByGjPage(page);
		return SUCCESS;
	}
	
	
	/**
	 * 全库查询，组合查询
	 * 
	 * @return
	 */
	public String findAllDfileZuheQuery() {
		String strWhere = getRequest().getParameter("strWhere");
		String strPx = getRequest().getParameter("strPx");
		
		String strArctype = getRequest().getParameter("arctype");
		if(strArctype=="" || "".equals(strArctype) || strArctype=="全部档案" || "全部档案".equals(strArctype)){
			strArctype=null;
		}
		
		String strCondition = getRequest().getParameter("conditions");
		String strDflag = getRequest().getParameter("dflagConditions");

		User user = (User) getSession().getAttribute("user");
		/*String strBzjgCode=user.getBzjgCode();
		String strCenterCode=user.getCenterCode();
		String strUserBzjgdm = null;
		if(strBzjgCode.equals(strCenterCode)){
				strUserBzjgdm=null;	
		}else{
			strUserBzjgdm=strBzjgCode;
		}*/
		String strUserBzjgdm="";
		String strQxCode = user.getQxCode();
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		
		
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, ","));
		
		List dflagConditions = new ArrayList();
		MyUtils.addToCollection(dflagConditions, MyUtils.split(strDflag, " ,"));
		
		page = new Page();
		page.setConditions(conditions);
		page.setBzjgdm(strUserBzjgdm);
		page.setDflagConditions(dflagConditions);
		page.setStrWhere(strWhere);
		page.setStrPx(strPx);
		page.setArctype(strArctype);
		
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = dfileService.findAllByZuhePage(page);
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteDfile() {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			success = dfileService.deleteDfile(getSession().getServletContext().getRealPath("/"), Integer.valueOf(strOrgid));
		}
		return SUCCESS;
	}
	
	/**
	 * 临时库数据审核提交
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateDfile() throws Exception{
		String strOrgid=getRequest().getParameter("orgid");  //为图片类型标识
		String newPageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		String strDflag = getRequest().getParameter("d_flag");
		String strERRORFLAG = "";
		String strDocid="";
		if(strDflag=="1" || "1".equals(strDflag)){
			
			//检测是否有选择问题类型
			String[] ERRORFLAG_LIST = getRequest().getParameterValues("errorFlag");
			if(ERRORFLAG_LIST!=null){
				for(int i=0; i<ERRORFLAG_LIST.length; i++){
					strERRORFLAG=strERRORFLAG+ERRORFLAG_LIST[i]+ ",";
				}
			}else{
				strERRORFLAG="";
			}
			
			if(strERRORFLAG==""){	//如果没有问题，把数据写到正式库
				Dfile dfile = new Dfile();
				dfile=dfileService.findByDfileId(Integer.valueOf(strOrgid));
				strDocid=dfile.getDocid();
				
				
				Dfile dfile3 = new Dfile();
				dfile3=dfileService.findArchiveByDocid(strDocid);//需要检测是否是档案库的驳回后的提交,即档案库是否存在此档案，如有则更新，否则插入
				if(dfile3!=null){
					dfile.setD_flag(0);
					dfile.setUp_Dflag(1);
					dfile.setUp_Aflag(0);
					dfile.setErrorFlag("");	
					dfile.setDocid(strDocid);
					success =dfileService.updateArchiveByDocid(dfile);
					if (success) {
						success = dfileService.deleteDfile(getSavePath(),Integer.valueOf(strOrgid));
					}
				}else{
					dfile.setD_flag(0);
					dfile.setUp_Dflag(1);
					dfile.setUp_Aflag(0);
					dfile.setErrorFlag("");
					dfile.setCollectTime(new Date());
					
					orgid = (Integer) dfileService.saveArchive(dfile);
					if (orgid != null) {
						success = dfileService.deleteDfile(getSavePath(),Integer.valueOf(strOrgid));
					}
				}
			}else{//如果有问题，把数据标识改为问题库2
				
				Dfile dfile = new Dfile();
				dfile.setOrgid(Integer.valueOf(strOrgid));
				strDflag="2";
				dfile.setD_flag(Integer.valueOf(strDflag));
				dfile.setErrorFlag(strERRORFLAG);
				dfile.setMemo(memo);
				success =dfileService.updateDfile(dfile);
			}
		}else{
			//如果是问题库数据的修改，则更改数据，且数据状态改为审核库2
			Dfile dfile = new Dfile();
			dfile.setOrgid(orgid);
			dfile.setOrderid(orderid);
			dfile.setJgdm(jgdm);
			dfile.setJgmc(jgmc);
			dfile.setJglx(jglx);
			dfile.setJglxdm(jglxdm);
			dfile.setJglxOld(jglxOld);
			dfile.setJglxdmOld(jglxdmOld);
			
			dfile.setZjlx(zjlx);
			dfile.setZjhm(zjhm);
			dfile.setJjlxdm(jjlxdm);
			dfile.setJjhydm(jjhydm);
			dfile.setJjhymc(jjhymc);
			dfile.setJjhydmOld(jjhydmOld);
			dfile.setJjhymcOld(jjhymcOld);
			dfile.setQyjj(qyjj);
			dfile.setJyfw(jyfw);
			dfile.setJjlx(jjlx);
			dfile.setZcrq(zcrq);
			dfile.setZgdm(zgdm);
			dfile.setPzjgdm(pzjgdm);
			dfile.setXzqhCode(xzqhCode);
			dfile.setXzqhName(xzqhName);
			dfile.setXzqhCode2(xzqhCode2);
			dfile.setXzqhName2(xzqhName2);
			dfile.setJgdz(jgdz);
			dfile.setYzbm(yzbm);
			dfile.setDhhm(dhhm);
			dfile.setScbzrq(scbzrq);
			dfile.setBzrq(bzrq);
			dfile.setZfrq(zfrq);
			dfile.setBzjgdm(bzjgdm);
			dfile.setZycp1(zycp1);
			dfile.setZycp2(zycp2);
			dfile.setZycp3(zycp3);
			dfile.setZczj(zczj);
			dfile.setWftzgb(wftzgb);
			dfile.setHbzl(hbzl);
			dfile.setZgrs(zgrs);
			dfile.setFbsl(fbsl);
			dfile.setZslsh(zslsh);
			dfile.setBgbj(bgbj);
			dfile.setBgrq(bgrq);
			dfile.setLry(lry);
			dfile.setNjrq(njrq);
			dfile.setNjr(njr);
			dfile.setNjqx(njqx);
			dfile.setXgr(xgr);
			dfile.setZbsl(zbsl);
			dfile.setZch(zch);
			dfile.setQzbz(qzbz);
			dfile.setQzrq(qzrq);
			dfile.setZgmc(zgmc);
			dfile.setPzjgmc(pzjgmc);
			dfile.setGslsh(gslsh);
			dfile.setGstbr(gstbr);
			dfile.setWjwlsh(wjwlsh);
			dfile.setPzwh(pzwh);
			dfile.setPwrq(pwrq);
			dfile.setWjwtbr(wjwtbr);
			dfile.setGk(gk);
			dfile.setFkbz(fkbz);
			
			dfile.setFksl(fksl);
			dfile.setDybz(dybz);
			dfile.setEmail(email);
			dfile.setWeburl(weburl);
			dfile.setMobile(mobile);
			dfile.setDjblx(djblx);
			dfile.setLastdate(lastdate);
			dfile.setCzflag(czflag);
			dfile.setYjflag(yjflag);
			dfile.setSjzt(sjzt);
			dfile.setJyjg(jyjg);
			dfile.setFz(fz);
			dfile.setMemo(memo);
			dfile.setTbrzjlx(tbrzjlx);
			dfile.setNjjlx(njjlx);
			dfile.setMemo2(memo2);
			dfile.setMemo3(memo3);
			dfile.setMemo4(memo4);
			dfile.setTbrxm(tbrxm);
			dfile.setTbrsfzh(tbrsfzh);
			dfile.setIsca(isca);
			dfile.setIsxw(isxw);
			dfile.setTbrlxfs(tbrlxfs);
			dfile.setGsfzrq(gsfzrq);
			
			
			if(newPageTypeStr==""||"".equals(newPageTypeStr)){
				
			}else{
				newPageTypeStr=str_replace(newPageTypeStr,"|","%");  //转换“PageType”中的字符串%为“|”
				dfile.setPageTypeStr(newPageTypeStr);
			}
			
			dfile.setJydz(jydz);
			dfile.setJyqhmc(jyqhmc);
			dfile.setJyqhdm(jyqhdm);
			dfile.setJyyb(jyyb);
			dfile.setJydh(jydh);
			dfile.setJfly(jfly);
			dfile.setKhyh(khyh);
			dfile.setKhzh(khzh);
			dfile.setZsbfrq(zsbfrq);
			dfile.setZszfrq(zszfrq);
			dfile.setMoveoutCenter(moveoutCenter);
			dfile.setMoveoutBzjgdm(moveoutBzjgdm);
			dfile.setMoveoutAddrss(moveoutAddrss);
			dfile.setMoveoutReason(moveoutReason);
			dfile.setOffPzjgmc(offPzjgmc);
			dfile.setOffPzwh(offPzwh);
			dfile.setOffReason(offReason);
			dfile.setOffNote(offNote);
			
			dfile.setHandleNote(handleNote);
			
			
			dfile.setD_flag(d_flag);
			dfile.setUp_Dflag(up_Dflag);
			dfile.setUp_Aflag(up_Aflag);
			dfile.setErrorFlag(errorFlag);
			
			dfile.setQyzclx(qyzclx);
			dfile.setYwlx(ywlx);
			dfile.setUserid(userid);
			dfile.setUsername(username);
			dfile.setState(state);
			strDflag="1";
			dfile.setD_flag(Integer.valueOf(strDflag));
			success =dfileService.updateDfile(dfile);
			
		}
		return SUCCESS;
		
	}
	
	
	/**
	 * 合格库数据驳回
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateArchiveNO() throws Exception{
		String strOrgid=getRequest().getParameter("orgid");  
		String strDocid="";  
		if(strOrgid!="" && !"".equals(strOrgid)){
			Dfile dfile = new Dfile();
			dfile=dfileService.findByArchiveId(Integer.valueOf(strOrgid));
			strDocid=dfile.getDocid();
			dfile.setD_flag(2);
			dfile.setErrorFlag("21");
			orgid = (Integer) dfileService.saveDfile(dfile);
			if (orgid != null) {
				Dfile dfile2 = new Dfile();
				dfile2.setD_flag(2);
				dfile2.setDocid(strDocid);
				success =dfileService.updateArchiveByDocid(dfile2);
			}
		}
		return SUCCESS;
		
	}

	
	/**
	 * 临时库数据批量审核通过
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateDfileOk() throws Exception{
		String strOrgids=getRequest().getParameter("orgids");  //为orgid的集合
		String strDocid="";
		success=false;

		if (strOrgids != null && !"".equals(strOrgids)) {
			String orgidList[]=MyUtils.split(strOrgids, ",");
			for (int i = 0; i < orgidList.length; i++) {
				//如果没有问题，把数据写到正式库
				Dfile dfile = new Dfile();
				String strOrgid=orgidList[i];
				dfile=dfileService.findByDfileId(Integer.valueOf(strOrgid));
				strDocid=dfile.getDocid();
				
				Dfile dfile3 = new Dfile();
				dfile3=dfileService.findArchiveByDocid(strDocid);//需要检测是否是档案库的驳回后的提交,即档案库是否存在此档案，如有则更新，否则插入
				if(dfile3!=null){
					dfile.setD_flag(0);
					dfile.setUp_Dflag(1);
					dfile.setUp_Aflag(0);
					dfile.setErrorFlag("");	
					dfile.setDocid(strDocid);
					success =dfileService.updateArchiveByDocid(dfile);
					if (success) {
						success = dfileService.deleteDfile(getSavePath(),Integer.valueOf(strOrgid));
					}
				}else{
					dfile.setD_flag(0);
					dfile.setUp_Dflag(1);
					dfile.setUp_Aflag(0);
					dfile.setErrorFlag("");
					dfile.setCollectTime(new Date());
					
					orgid = (Integer) dfileService.saveArchive(dfile);
					if (orgid != null) {
						//success=true;
						success = dfileService.deleteDfile(getSavePath(),Integer.valueOf(orgidList[i]));
					}
				}
			}
		}
		return SUCCESS;
		
	}
	
	
	private Dfile upload(Dfile dfile){
		String _imageUrl = null;
		if (upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(","))) {
			String rootPath = getSavePath();
			String savePath = rootPath + getSavePath();
			MyUtils.mkDirectory(savePath);
			String newFileName = MyUtils.upload(getUploadFileName(), savePath, getUpload());
			_imageUrl = getSavePath() + newFileName;
			try {
				MyUtils.createMiniPic(new File(savePath + newFileName), maxWidthSize,maxHeightSize);
			} catch (IOException e) {
				e.printStackTrace();
			}
			dfile.setImageUrl(_imageUrl);
		}
		return dfile;
	}
	
	/*替换字符串中的字符*/
	public static String str_replace(String strSource, String strFrom, String strTo) {    
	     if (strSource == null) {        
	       return null;    
	     }  
	     int i = 0;
	     if ((i = strSource.indexOf(strFrom, i)) >= 0) {
	       char[] cSrc = strSource.toCharArray();
	       char[] cTo = strTo.toCharArray();
	       int len = strFrom.length();  
	       StringBuffer buf = new StringBuffer(cSrc.length);  
	       buf.append(cSrc, 0, i).append(cTo);
	       i += len;    
	       int j = i;       
	       while ((i = strSource.indexOf(strFrom, i)) > 0) {  
	         buf.append(cSrc, j, i - j).append(cTo);   
	         i += len;  
	         j = i;        
	       }        
	       buf.append(cSrc, j, cSrc.length - j); 
	       return buf.toString(); 
	     } 
	     return strSource;
	   }

	
	/**
	 * 上传扫描数据到文本服务器efile目录下
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveImageDfile() throws Exception{
		

	  	String strOrgid = "";
	  	String strDocid = "";
		String savePath = "";  //根目录
		String saveFileName = ""; //文件名
		StringBuffer strBuffer = null;
		//String imageFlag="";
		String imageUrl;
		String mdImageUrl;
		String strBzjgdm="";
		
		if ((getRequest().getParameter("orgid")!=null)&& (!getRequest().getParameter("orgid").equals(""))){
	  		strOrgid=getRequest().getParameter("orgid");  
	  		strDocid=getRequest().getParameter("docid"); 
	  		strBzjgdm=getRequest().getParameter("bzjgdm");
	  	}
		
		Calendar  now  =  Calendar.getInstance();  
		String  year  =  String.valueOf(now.get(Calendar.YEAR));
		String strDqrq=new SimpleDateFormat("yyyyMMdd").format(now.getTime());
		
		
		
		savePath = getSavePath()+"efile";  //上传的临时路劲
		savePath = savePath.replace("\\", "/");   //上传的临时路劲 saveTmpPath，如E:/zzjgdmzx/Tomcat5.0/webapps/manage/WebRoot/efile
		

		saveFileName=strDocid+".tif";  //以DOCID作为临时文件名字 saveFileName，如74EE219F-A17D-4BDB-9FB0-F0CB87888301.tif
		imageUrl = year+"/"+strBzjgdm+"/"+strDqrq+"/"+saveFileName;   //上传文件的相对路径，如2013/100000/20130116/74EE219F-A17D-4BDB-9FB0-F0CB87888301.tif
		saveFileName=savePath+"/"+imageUrl;  //上传文件绝对路径，如E:/zzjgdmzx/Tomcat5.0/webapps/manage/WebRoot/efile/2013/100000/20130116/74EE219F-A17D-4BDB-9FB0-F0CB87888301.tif
		mdImageUrl=savePath+"/"+year+"/"+strBzjgdm+"/"+strDqrq;
		File dirFileUrl = null;
		dirFileUrl = new File(mdImageUrl);
		if (!(dirFileUrl.exists()) && !(dirFileUrl.isDirectory())) {
			boolean creadok = dirFileUrl.mkdirs();
			if (!creadok) {
				throw new Exception("新建文件夹出错!");
			}
		}
		
		String imageData=getRequest().getParameter("imageData"); //单个数据包内容
		String packindex=getRequest().getParameter("packindex");  //为数据包编码
		String pageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		String lastpack=getRequest().getParameter("lastpack");  //true为最后一个包
		
		
		if(lastpack=="false" || "false".equals(lastpack)){
			if(packindex=="0" || "0".equals(packindex)){
				strBuffer=new StringBuffer();
				strBuffer.append(imageData);
				getSession().setAttribute("strBuffer", strBuffer);
			}else{
				strBuffer = (StringBuffer) getSession().getAttribute("strBuffer");
				strBuffer.append(imageData);
			}
			//System.out.println("-----------------------------"+pageTypeStr);
			success= true;
		}else{
			if(packindex=="0" || "0".equals(packindex)){
				strBuffer=new StringBuffer();
				strBuffer.append(imageData);
				getSession().setAttribute("strBuffer", strBuffer);
			}else{
				strBuffer = (StringBuffer) getSession().getAttribute("strBuffer");
				strBuffer.append(imageData);
			}
			
			strBuffer = (StringBuffer)getSession().getAttribute("strBuffer");
			WriteImageData.WriteImageByStream(saveFileName, strBuffer.toString());
			
			File f = new File(saveFileName);
			long len = WriteImageData.getFileSizes(f);
			if(len<10240){
				success = false;
			}else{
				System.out.println("文件长度：：：："+len);
				pageTypeStr=MyUtils.str_replace(pageTypeStr,"|","%"); 
				Dfile dfile = new Dfile();
				dfile.setOrgid(Integer.valueOf(strOrgid));
				dfile.setPageTypeStr(pageTypeStr);
				dfile.setImageUrl(saveFileName);
				//dfile.setImageUrl(imageUrl);
				//orgnew.setImageFlag(imageFlag);
				success = dfileService.saveImageDfile(dfile);
			}
		}
		
		return SUCCESS;
	}

	
	/**
	* 单个加载原文
	* @return
	*/
	
	public String dfileViewImg() { //dfile临时表原文
		
		String systemPath = "";
		String imageData="";
		String imageUrl="";
		
		Integer orgid =  Integer.valueOf(getRequest().getParameter("orgid"));
		Integer d_flag =  Integer.valueOf(getRequest().getParameter("d_flag"));
		
		systemPath = getSavePath()+"efile\\";  //上传的临时路劲
		//systemPath = systemPath.replace("manage", "zz");   //上传的临时路劲 saveTmpPath，如E:/zzjgdmzx/Tomcat5.0/webapps/manage/WebRoot/efile
		//saveBase64CodeFileName=zuser.getUserName().toString()+".txt";  //以登录用户名作为临时文件名字 saveBase64CodeFileName，如admin.txt
		//filePath = getSession().getServletContext().getRealPath("/")+"eFile/";  //上传的临时路劲
		//filePath = filePath.replace("\\", "/");   //上传的临时路劲 saveTmpPath，如E:/zzjgdmzx/Tomcat5.0/webapps/manage/WebRoot/efile
		//filePath = filePath+"/"+zuser.getUserName().toString(); 
		
		Dfile dfile = new Dfile();
		if(d_flag==1 || d_flag==2){
			dfile=(Dfile) dfileService.dfileViewImg(orgid);
		}else{
			dfile=(Dfile) dfileService.archiveViewImg(orgid);
		}
		
		//imageUrl=systemPath+dfile.getImageUrl();
		imageUrl=dfile.getImageUrl();
		
		byte[] data = null;
		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imageUrl);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		sun.misc.BASE64Encoder encoder=new sun.misc.BASE64Encoder();
		imageData=encoder.encode(data);// 返回Base64编码过的字节数组字符串
		
		page = new Page();
		page.setImageData(imageData);
		page.setPageTypeStr(dfile.getPageTypeStr());
		return SUCCESS;
	}	
	
	
	public Dfile getDfile() {
		return dfile;
	}

	public void setDfile(Dfile dfile) {
		this.dfile = dfile;
	}

	public Integer getOrgid() {
		return orgid;
	}
	public void setOrgid(Integer orgid) {
		this.orgid = orgid;
	}

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	public float getMaxHeightSize() {
		return maxHeightSize;
	}
	public void setMaxHeightSize(float imageMaxSize) {
		this.maxHeightSize = imageMaxSize;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setDfileService(IDfileService dfileService) {
		this.dfileService = dfileService;
	}
	
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getAllowedTypes() {
		return allowedTypes;
	}
	public void setAllowedTypes(String allowedTypes) {
		this.allowedTypes = allowedTypes;
	}

	public float getMaxWidthSize() {
		return maxWidthSize;
	}
	public void setMaxWidthSize(float maxWidthSize) {
		this.maxWidthSize = maxWidthSize;
	}
    
	public String getJgdm() {
		return jgdm;
	}
	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}
	public String getJgmc() {
		return jgmc;
	}
	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getJglx() {
		return jglx;
	}
	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getJyfw() {
		return jyfw;
	}
	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}
	public String getJjlxdm() {
		return jjlxdm;
	}
	public void setJjlxdm(String jjlxdm) {
		this.jjlxdm = jjlxdm;
	}
	public String getJjlx() {
		return jjlx;
	}
	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}
	public Date getZcrq() {
		return zcrq;
	}
	public void setZcrq(Date zcrq) {
		this.zcrq = zcrq;
	}
	public String getZgdm() {
		return zgdm;
	}
	public void setZgdm(String zgdm) {
		this.zgdm = zgdm;
	}
	public String getPzjgdm() {
		return pzjgdm;
	}
	public void setPzjgdm(String pzjgdm) {
		this.pzjgdm = pzjgdm;
	}
	public String getXzqhCode() {
		return xzqhCode;
	}
	public void setXzqhCode(String xzqhCode) {
		this.xzqhCode = xzqhCode;
	}
	public String getXzqhName() {
		return xzqhName;
	}
	public void setXzqhName(String xzqhName) {
		this.xzqhName = xzqhName;
	}
	public String getJgdz() {
		return jgdz;
	}
	public void setJgdz(String jgdz) {
		this.jgdz = jgdz;
	}
	public String getYzbm() {
		return yzbm;
	}
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	public String getDhhm() {
		return dhhm;
	}
	public void setDhhm(String dhhm) {
		this.dhhm = dhhm;
	}
	public Date getScbzrq() {
		return scbzrq;
	}
	public void setScbzrq(Date scbzrq) {
		this.scbzrq = scbzrq;
	}
	public Date getBzrq() {
		return bzrq;
	}
	public void setBzrq(Date bzrq) {
		this.bzrq = bzrq;
	}
	public Date getZfrq() {
		return zfrq;
	}
	public void setZfrq(Date zfrq) {
		this.zfrq = zfrq;
	}
	public String getBzjgdm() {
		return bzjgdm;
	}
	public void setBzjgdm(String bzjgdm) {
		this.bzjgdm = bzjgdm;
	}
	public String getZycp1() {
		return zycp1;
	}
	public void setZycp1(String zycp1) {
		this.zycp1 = zycp1;
	}
	public String getZycp2() {
		return zycp2;
	}
	public void setZycp2(String zycp2) {
		this.zycp1 = zycp2;
	}
	public String getZycp3() {
		return zycp3;
	}
	public void setZycp3(String zycp3) {
		this.zycp1 = zycp3;
	}
	public java.math.BigDecimal getZczj() {
		return zczj;
	}
	public void setZczj(java.math.BigDecimal zczj) {
		this.zczj = zczj;
	}
	public String getHbzl() {
		return hbzl;
	}
	public void setHbzl(String hbzl) {
		this.hbzl = hbzl;
	}

	public String getWftzgb() {
		return wftzgb;
	}
	public void setWftzgb(String wftzgb) {
		this.wftzgb = wftzgb;
	}
	public Integer getZgrs() {
		return zgrs;
	}
	public void setZgrs(Integer zgrs) {
		this.zgrs = zgrs;
	}
	public Integer getFbsl() {
		return fbsl;
	}
	public void setFbsl(Integer fbsl) {
		this.fbsl = fbsl;
	}
	public String getZslsh() {
		return zslsh;
	}
	public void setZslsh(String zslsh) {
		this.zslsh = zslsh;
	}
	public String getBgbj() {
		return bgbj;
	}
	public void setBgbj(String bgbj) {
		this.bgbj = bgbj;
	}
	public Date getBgrq() {
		return bgrq;
	}
	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}
	public String getLry() {
		return lry;
	}
	public void setLry(String lry) {
		this.lry = lry;
	}
	public Date getNjrq() {
		return njrq;
	}
	public void setNjrq(Date njrq) {
		this.njrq = njrq;
	}
	public String getNjr() {
		return njr;
	}
	public void setNjr(String njr) {
		this.njr = njr;
	}
	public Date getNjqx() {
		return njqx;
	}
	public void setNjqx(Date njqx) {
		this.njqx = njqx;
	}
	public String getXgr() {
		return xgr;
	}
	public void setXgr(String xgr) {
		this.xgr = xgr;
	}
	public Integer getZbsl() {
		return zbsl;
	}
	public void setZbsl(Integer zbsl) {
		this.zbsl = zbsl;
	}
	public String getZch() {
		return zch;
	}
	public void setZch(String zch) {
		this.zch = zch;
	}
	public String getQzbz() {
		return qzbz;
	}
	public void setQzbz(String qzbz) {
		this.qzbz = qzbz;
	}
	public Date getQzrq() {
		return qzrq;
	}
	public void setQzrq(Date qzrq) {
		this.qzrq = qzrq;
	}
	public String getZgmc() {
		return zgmc;
	}
	public void setZgmc(String zgmc) {
		this.zgmc = zgmc;
	}
	public String getPzjgmc() {
		return pzjgmc;
	}
	public void setPzjgmc(String pzjgmc) {
		this.pzjgmc = pzjgmc;
	}
	public String getGslsh() {
		return gslsh;
	}
	public void setGslsh(String gslsh) {
		this.gslsh = gslsh;
	}
	public String getGstbr() {
		return gstbr;
	}
	public void setGstbr(String gstbr) {
		this.gstbr = gstbr;
	}
	public String getWjwlsh() {
		return wjwlsh;
	}
	public void setWjwlsh(String wjwlsh) {
		this.wjwlsh = wjwlsh;
	}
	public String getPzwh() {
		return pzwh;
	}
	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}
	public Date getPwrq() {
		return pwrq;
	}
	public void setPwrq(Date pwrq) {
		this.pwrq = pwrq;
	}
	public String getWjwtbr() {
		return wjwtbr;
	}
	public void setWjwtbr(String wjwtbr) {
		this.wjwtbr = wjwtbr;
	}
	public String getGk() {
		return gk;
	}
	public void setGk(String gk) {
		this.gk = gk;
	}
	public String getFkbz() {
		return fkbz;
	}
	public void setFkbz(String fkbz) {
		this.fkbz = fkbz;
	}
	public Integer getFksl() {
		return fksl;
	}
	public void setFksl(Integer fksl) {
		this.fksl = fksl;
	}
	public String getDybz() {
		return dybz;
	}
	public void setDybz(String dybz) {
		this.dybz = dybz;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWeburl() {
		return weburl;
	}
	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDjblx() {
		return djblx;
	}
	public void setDjblx(String djblx) {
		this.djblx = djblx;
	}
	public Date getLastdate() {
		return lastdate;
	}
	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	public String getCzflag() {
		return czflag;
	}
	public void setCzflag(String czflag) {
		this.czflag = czflag;
	}
	public String getYjflag() {
		return yjflag;
	}
	public void setYjflag(String yjflag) {
		this.yjflag = yjflag;
	}
	public String getSjzt() {
		return sjzt;
	}
	public void setSjzt(String sjzt) {
		this.sjzt = sjzt;
	}
	public String getJyjg() {
		return jyjg;
	}
	public void setJyjg(String jyjg) {
		this.jyjg = jyjg;
	}
	public Integer getFz() {
		return fz;
	}
	public void setFz(Integer fz) {
		this.fz = fz;
	}
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getNjjlx() {
		return njjlx;
	}
	public void setNjjlx(String njjlx) {
		this.njjlx = njjlx;
	}
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	public String getMemo3() {
		return memo3;
	}
	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}
	public String getMemo4() {
		return memo4;
	}
	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}
	public String getTbrsfzh() {
		return tbrsfzh;
	}
	public void setTbrsfzh(String tbrsfzh) {
		this.tbrsfzh = tbrsfzh;
	}
	public String getIsca() {
		return isca;
	}
	public void setIsca(String isca) {
		this.isca = isca;
	}
	public String getTbrlxfs() {
		return tbrlxfs;
	}
	public void setTbrlxfs(String tbrlxfs) {
		this.tbrlxfs = tbrlxfs;
	}
	public Date getGsfzrq() {
		return gsfzrq;
	}
	public void setGsfzrq(Date gsfzrq) {
		this.gsfzrq = gsfzrq;
	}
	public String getJydz() {
		return jydz;
	}
	public void setJydz(String jydz) {
		this.jydz = jydz;
	}
	public String getJyyb() {
		return jyyb;
	}
	public void setJyyb(String jyyb) {
		this.jyyb = jyyb;
	}
	public String getJydh() {
		return jydh;
	}
	public void setJydh(String jydh) {
		this.jydh = jydh;
	}
	public String getJfly() {
		return jfly;
	}
	public void setJfly(String jfly) {
		this.jfly = jfly;
	}

	public String getKhyh() {
		return khyh;
	}
	public void setKhyh(String khyh) {
		this.khyh = khyh;
	}
	
	public String getKhzh() {
		return khzh;
	}
	public void setKhzh(String khzh) {
		this.khzh = khzh;
	}
	public Date getZsbfrq() {
		return zsbfrq;
	}
	public void setZsbfrq(Date zsbfrq) {
		this.zsbfrq = zsbfrq;
	}
	public Date getZszfrq() {
		return zszfrq;
	}
	public void setZszfrq(Date zszfrq) {
		this.zszfrq = zszfrq;
	}
	
	public String getQyzclx() {
		return qyzclx;
	}
	public void setQyzclx(String qyzclx) {
		this.qyzclx = qyzclx;
	}
	
	public String getYwlx() {
		return ywlx;
	}
	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Map<String, String> getDataMap() {
		return dataMap;
	}
	public void setWftzgbdm(String wftzgbdm) {
		this.wftzgbdm = wftzgbdm;
	}
	public String getWftzgbdm() {
		return wftzgbdm;
	}
	public void setHbzldm(String hbzldm) {
		this.hbzldm = hbzldm;
	}
	public String getHbzldm() {
		return hbzldm;
	}
	public void setJjhydm(String jjhydm) {
		this.jjhydm = jjhydm;
	}
	public String getJjhydm() {
		return jjhydm;
	}
	public void setJjhymc(String jjhymc) {
		this.jjhymc = jjhymc;
	}
	public String getJjhymc() {
		return jjhymc;
	}
	public void setMoveoutAddrss(String moveoutAddrss) {
		this.moveoutAddrss = moveoutAddrss;
	}
	public String getMoveoutAddrss() {
		return moveoutAddrss;
	}
	public void setMoveoutReason(String moveoutReason) {
		this.moveoutReason = moveoutReason;
	}
	public String getMoveoutReason() {
		return moveoutReason;
	}
	public void setMoveoutNote(String moveoutNote) {
		this.moveoutNote = moveoutNote;
	}
	public String getMoveoutNote() {
		return moveoutNote;
	}
	public void setOffPzjgmc(String offPzjgmc) {
		this.offPzjgmc = offPzjgmc;
	}
	public String getOffPzjgmc() {
		return offPzjgmc;
	}
	public void setOffPzwh(String offPzwh) {
		this.offPzwh = offPzwh;
	}
	public String getOffPzwh() {
		return offPzwh;
	}
	public void setOffReason(String offReason) {
		this.offReason = offReason;
	}
	public String getOffReason() {
		return offReason;
	}
	public void setOffNote(String offNote) {
		this.offNote = offNote;
	}
	public String getOffNote() {
		return offNote;
	}
	public void setPageTypeStr(String pageTypeStr) {
		this.pageTypeStr = pageTypeStr;
	}
	public String getPageTypeStr() {
		return pageTypeStr;
	}
	public void setHandleNote(String handleNote) {
		this.handleNote = handleNote;
	}
	public String getHandleNote() {
		return handleNote;
	}
	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}
	public String getErrorFlag() {
		return errorFlag;
	}

	public void setIsxw(String isxw) {
		this.isxw = isxw;
	}

	public String getIsxw() {
		return isxw;
	}

	public void setJjhydmOld(String jjhydmOld) {
		this.jjhydmOld = jjhydmOld;
	}

	public String getJjhydmOld() {
		return jjhydmOld;
	}

	public void setJjhymcOld(String jjhymcOld) {
		this.jjhymcOld = jjhymcOld;
	}

	public String getJjhymcOld() {
		return jjhymcOld;
	}

	public void setTbrzjlx(String tbrzjlx) {
		this.tbrzjlx = tbrzjlx;
	}

	public String getTbrzjlx() {
		return tbrzjlx;
	}

	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}

	public Date getCollectTime() {
		return collectTime;
	}

	public void setJyqhmc(String jyqhmc) {
		this.jyqhmc = jyqhmc;
	}

	public String getJyqhmc() {
		return jyqhmc;
	}

	public void setJyqhdm(String jyqhdm) {
		this.jyqhdm = jyqhdm;
	}

	public String getJyqhdm() {
		return jyqhdm;
	}

	public void setMoveoutCenter(String moveoutCenter) {
		this.moveoutCenter = moveoutCenter;
	}

	public String getMoveoutCenter() {
		return moveoutCenter;
	}

	public void setMoveoutBzjgdm(String moveoutBzjgdm) {
		this.moveoutBzjgdm = moveoutBzjgdm;
	}

	public String getMoveoutBzjgdm() {
		return moveoutBzjgdm;
	}

	public String getXzqhCode2() {
		return xzqhCode2;
	}

	public void setXzqhCode2(String xzqhCode2) {
		this.xzqhCode2 = xzqhCode2;
	}

	public String getXzqhName2() {
		return xzqhName2;
	}

	public void setXzqhName2(String xzqhName2) {
		this.xzqhName2 = xzqhName2;
	}

	public int getDfileCount() {
		return dfileCount;
	}

	public void setDfileCount(int dfileCount) {
		this.dfileCount = dfileCount;
	}

	public String getQyjj() {
		return qyjj;
	}

	public void setQyjj(String qyjj) {
		this.qyjj = qyjj;
	}
}
