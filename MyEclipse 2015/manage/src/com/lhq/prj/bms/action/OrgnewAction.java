package com.lhq.prj.bms.action;

import java.io.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;


import com.lhq.prj.bms.core.CodeAssignClient;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.core.WriteImageData;
import com.lhq.prj.bms.core.UUID;

import com.lhq.prj.bms.po.CheckArchive;
import com.lhq.prj.bms.po.Orgnew;
import com.lhq.prj.bms.po.PrintLog;
import com.lhq.prj.bms.po.Qx;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.po.CodeDetail;
import com.lhq.prj.bms.service.ITjgdmService;
import com.lhq.prj.bms.service.IOrgnewService;
import com.lhq.prj.bms.service.ICodeDetailService;
import com.lhq.prj.bms.service.impl.AutoAllocateCodeClientEncrypt;
import com.opensymphony.xwork2.ActionContext;


/**
 * OrgnewAction.java Create on 2012-5-5
 * 机构管理
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
**/

@SuppressWarnings("serial")
public class OrgnewAction extends BaseAction {
	private IOrgnewService orgnewService;
	private ITjgdmService tjgdmService;
	private ICodeDetailService codeDetailService;
	private Map<String, String> dataMap;

	private Orgnew orgnew;
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
	private String centerid;
	//private String docid;
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String jglxdm;
	private String jglxOld;
	private String jglxdmOld;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jjhydm;
	private String jjhymc;
	private String jjhydmOld;
	private String jjhymcOld;
	private String jyfw;
	private String qyjj;
	private String jjlx;
	private String jjlxdm;
	private String jjlxOld;
	private String jjlxdmOld;
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
	private String lrName;
	private Date lrDate;
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
	private String njjhy;
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
	private String imageFlag;
	private String username;
	private String state;

	private Map appSysConfig;
	
	private List msgCountList;
	
	private List verifyFieldList;

	private List fieldList = new ArrayList();
	
	private List tjgdmList; 
	
	public OrgnewAction() {
		//初始化Map对象
		dataMap = new HashMap<String, String>();
	}
	/**
	* 添加
	* @return
	 * @throws Exception 
	*/
	public String saveOrgnew() throws Exception {
		String strJglxOld;
		String strJglxdmOld;
		String docid="";
		Integer ijglxdm=0;
		String sorgid = getRequest().getParameter("orgid");

		if(getRequest().getParameter("jglxdm")!=null && getRequest().getParameter("jglxdm")!="" && !"".equals(jglxdm)){
			ijglxdm = Integer.parseInt(getRequest().getParameter("jglxdm"));
		}
		User user = (User) getSession().getAttribute("user");
		Orgnew orgnew = new Orgnew();
		orgnew.setOrgid(orgid);
		orgnew.setJgdm(jgdm);
		orgnew.setJgmc(jgmc);
		orgnew.setJglx(jglx);
		orgnew.setJglxdm(jglxdm);

		orgnew.setFddbr(fddbr);
		orgnew.setZjlx(zjlx);
		orgnew.setZjhm(zjhm);
		orgnew.setJjhydm(jjhydm);
		orgnew.setJjhymc(jjhymc);
		orgnew.setJjhydmOld(jjhydmOld);
		orgnew.setJjhymcOld(jjhymcOld);
		orgnew.setJyfw(jyfw);
		orgnew.setQyjj(qyjj);
		orgnew.setJjlx(jjlx);
		orgnew.setJjlxdm(jjlxdm);
		orgnew.setJjlxOld(jjlxOld);
		orgnew.setJjlxdmOld(jjlxdmOld);
		orgnew.setZcrq(zcrq);
		orgnew.setZgdm(zgdm);
		orgnew.setPzjgdm(pzjgdm);
		orgnew.setXzqhCode(xzqhCode);
		orgnew.setXzqhName(xzqhName);
		orgnew.setXzqhCode2(xzqhCode2);
		orgnew.setXzqhName2(xzqhName2);
		orgnew.setJgdz(jgdz);
		orgnew.setYzbm(yzbm);
		orgnew.setDhhm(dhhm);
		orgnew.setScbzrq(scbzrq);
		orgnew.setBzrq(bzrq);
		orgnew.setZfrq(zfrq);
		orgnew.setBzjgdm(bzjgdm);
		orgnew.setZycp1(zycp1);
		orgnew.setZycp2(zycp2);
		orgnew.setZycp3(zycp3);
		orgnew.setZczj(zczj);
		orgnew.setWftzgb(wftzgb);
		orgnew.setWftzgbdm(wftzgbdm);
		orgnew.setHbzl(hbzl);
		orgnew.setHbzldm(hbzldm);
		orgnew.setZgrs(zgrs);
		orgnew.setFbsl(fbsl);
		orgnew.setZslsh(zslsh);
		orgnew.setBgbj(bgbj);
		orgnew.setBgrq(bgrq);
		orgnew.setNjrq(njrq);
		orgnew.setNjr(njr);
		orgnew.setNjqx(njqx);
		orgnew.setXgr(xgr);
		orgnew.setZbsl(zbsl);
		orgnew.setZch(zch);
		orgnew.setQzrq(qzrq);
		orgnew.setZgmc(zgmc);
		orgnew.setPzjgmc(pzjgmc);
		orgnew.setGslsh(gslsh);
		orgnew.setGstbr(gstbr);
		orgnew.setWjwlsh(wjwlsh);
		orgnew.setPzwh(pzwh);
		orgnew.setPwrq(pwrq);
		orgnew.setWjwtbr(wjwtbr);
		orgnew.setGk(gk);
		orgnew.setFkbz(fkbz);
		
		orgnew.setFksl(fksl);
		orgnew.setDybz(dybz);
		orgnew.setEmail(email);
		orgnew.setWeburl(weburl);
		orgnew.setMobile(mobile);
		orgnew.setDjblx(djblx);
		orgnew.setLastdate(lastdate);
		orgnew.setCzflag(czflag);
		orgnew.setYjflag(yjflag);
		orgnew.setSjzt(sjzt);
		orgnew.setJyjg(jyjg);
		orgnew.setFz(fz);
		orgnew.setTbrzjlx(tbrzjlx);
		orgnew.setMemo(memo);
		orgnew.setNjjlx(njjlx);
		orgnew.setMemo2(memo2);
		orgnew.setMemo3(memo3);
		orgnew.setMemo4(memo4);
		orgnew.setTbrxm(tbrxm);
		orgnew.setTbrsfzh(tbrsfzh);
		orgnew.setIsca(isca);
		orgnew.setIsxw(isxw);
		orgnew.setTbrlxfs(tbrlxfs);
		orgnew.setGsfzrq(gsfzrq);
		orgnew.setJydz(jydz);
		orgnew.setJyqhmc(jyqhmc);
		orgnew.setJyqhdm(jyqhdm);
		orgnew.setJyyb(jyyb);
		orgnew.setJydh(jydh);
		orgnew.setJfly(jfly);
		orgnew.setKhyh(khyh);
		orgnew.setKhzh(khzh);
		orgnew.setZsbfrq(zsbfrq);
		orgnew.setZszfrq(zszfrq);
		orgnew.setMoveoutCenter(moveoutCenter);
		orgnew.setMoveoutBzjgdm(moveoutBzjgdm);
		orgnew.setMoveoutAddrss(moveoutAddrss);
		orgnew.setMoveoutReason(moveoutReason);
		orgnew.setOffPzjgmc(offPzjgmc);
		orgnew.setOffPzwh(offPzwh);
		orgnew.setOffReason(offReason);
		orgnew.setOffNote(offNote);
		
		orgnew.setD_flag(d_flag);
		orgnew.setUp_Dflag(1);
		orgnew.setUp_Aflag(up_Aflag);
		orgnew.setErrorFlag(errorFlag);
		
		orgnew.setHandleNote(handleNote);
		
		orgnew.setQyzclx(qyzclx);
		orgnew.setYwlx(ywlx);
		orgnew.setUserid(userid);
		orgnew.setUsername(username);
		orgnew.setState(state);
		orgnew.setImageFlag(imageFlag);

		switch(ijglxdm) {
		case 11: 
			strJglxOld="企业法人";
			strJglxdmOld="1";
			break; 
		case 13: 
			strJglxOld="企业法人";
			strJglxdmOld="1";
			break; 
		case 15: 
			strJglxOld="企业非法人";
			strJglxdmOld="2";
			break; 
		case 17: 
			strJglxOld="企业非法人";
			strJglxdmOld="2";
			break;
		case 19: 
			strJglxOld="企业非法人";
			strJglxdmOld="2";
			break;
		case 31: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 32: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 33: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 34: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 35: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 36: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 37: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 39: 
			strJglxOld="机关非法人";
			strJglxdmOld="8";
			break;
		case 51: 
			strJglxOld="事业法人";
			strJglxdmOld="3";
			break;
		case 53: 
			strJglxOld="事业非法人";
			strJglxdmOld="4";
			break;
		case 59: 
			strJglxOld="其他事业法人";
			strJglxdmOld="D";
			break;
		case 71: 
			strJglxOld="社团法人";
			strJglxdmOld="5";
			break;
		case 73: 
			strJglxOld="社团非法人";
			strJglxdmOld="6";
			break;
		case 79: 
			strJglxOld="其它社团法人";
			strJglxdmOld="6";
			break;
		case 91: 
			strJglxOld="民办非企业单位";
			strJglxdmOld="A";
			break;
		case 93: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 94: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 95: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 96: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 97: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 98: 
			strJglxOld="个体";
			strJglxdmOld="B";
			break;
		case 99: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		default:
			strJglxOld=null;
			strJglxdmOld=null;
		}
		orgnew.setJglxOld(strJglxOld);
		orgnew.setJglxdmOld(strJglxdmOld);

		if(sorgid != null && sorgid!="" && !"".equals(sorgid) ){
			System.out.println("更新");
			//如果不是新录入的，则更新
			orgnew.setBzjgdm(user.getBzjgCode());
			docid=getRequest().getParameter("docid");
			orgnew.setDocid(docid);
			System.out.println("跟踪OrgnewAction：更新：updateOrgnew："+orgnew.getBzjgdm());
			orgnewService.updateOrgnew(orgnew);	
			orgid=Integer.parseInt(sorgid);
		}else{System.out.println("新录入");
			//if(!(ywlx.equals("年检")&&user.getBzjgCode().equals(user.getCenterCode()))){
				orgnew.setBzjgdm(user.getBzjgCode());
			//}
			orgnew.setCenterid(user.getCenterCode());
			orgnew.setLry(user.getUserName());
			orgnew.setLrName(user.getEmplName());
			orgnew.setLrDate(new Date());
			
			docid=UUID.randomUUID().toString().toUpperCase();
			orgnew.setDocid(docid);
			//否则插入一条数据，保存
			orgid = (Integer) orgnewService.saveOrgnew(orgnew);		
		}
		
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",docid:'"+docid+"',success:true,imageUrl:'" + orgnew.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}

	public static String encodeInt1(String paramString)
	  {
	    int i = 0;
	    int j = 0;
	    try
	    {
	      j = Integer.parseInt(paramString);
	      int intId = j;
	      //if (intId== 0) intId;
	      switch (intId)
	      {
	      case 0:
	        i = 3;
	        break;
	      case 1:
	        i = 6;
	        break;
	      case 2:
	        i = 1;
	        break;
	      case 3:
	        i = 0;
	        break;
	      case 4:
	        i = 7;
	        break;
	      case 5:
	        i = 5;
	        break;
	      case 6:
	        i = 9;
	        break;
	      case 7:
	        i = 8;
	        break;
	      case 8:
	        i = 4;
	        break;
	      case 9:
	        i = 2;
	      }
	      return String.valueOf(i);
	    }
	    catch (Exception localException)
	    {
	    }
	    return paramString;
	  }
	 
	private static String getjcode(String v){
  	
  	String strRtn="";
  	if(v==null||v.length()<9){
  		return v;
  	}
	    
  	strRtn="3"+v.substring(1,9);
  	
	    for   (int   i   =   9;   i   <   v.length();   i++)   { 
	    	strRtn=strRtn+encodeInt1(v.substring(i, i+1));
	    	
	    } 
	    
	    strRtn=getPaluev(strRtn);

	    return strRtn;
  }
	
	private static String getPaluev(String str){
		//String vReturn="220100710011036383207143041122";
		if(str==null){
			return str;
		}
		
		if(str!=null&&str.equals("slyt")){
			return "SLYT";
		}
		
		int l=str.length();
		try{
		String v9="";
		if(str.length()>8){
			v9=str.substring(0, 9);
			l=l-9;
		}
		else{
			v9="";
			l=l;
		}
		String[] hexDigits = { "1", "7", "0", "4", "0", "9",   
	            "6", "8", "1", "3", "9", "1", "2", "3", "8", "5" };
		
		MessageDigest md = MessageDigest.getInstance("MD5");  
      StringBuffer resultSb = new StringBuffer();   
      for (int i = 0; i < md.digest(str.getBytes()).length; i++) {  
      	byte bb=md.digest(str.getBytes())[i];
          int n = bb;   
          if (n < 0)   
              n = 256 + n;   
          int d1 = n / 16;   
          int d2 = n % 16;   
    
          String abc= hexDigits[d1] + hexDigits[d2]; 
          resultSb.append(abc);
          
      }   
      
      String v= resultSb.toString();
      String xx=v.substring(0,l);
		//System.out.println(v9);
		//System.out.println(xx);
      return "4"+v9+xx;
		}
		catch(Exception e){
			e.printStackTrace();
			return "123456789";
		}
	}
	
	/**
	* 查找所有需要业务办理的申请单
	* @return
	 * @throws Exception 
	*/
	public String findAllOrgnew() throws Exception {
		String handleUsername= getRequest().getParameter("handleUsername");
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		String strYwlxCondition= getRequest().getParameter("ywlxConditions");
		String strDybz = getRequest().getParameter("dybz");
		String strHandleDate = getRequest().getParameter("handleDate");
		String strYwlx= getRequest().getParameter("ywlx");
		page = new Page();
		System.out.println(strHandleDate);
		if(strHandleDate!=null){
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date d = new Date();
			Date d2 = sdf1.parse(sdf2.format(d)+" 12:30:00");
			
			if(d.after(d2)){
				d2 = sdf1.parse(sdf2.format(d)+" 18:30:00");
			}
			d2 = new Date(d2.getTime()-24*60*60*1000);
			System.out.println("打证查询日期：："+sdf1.format(d2));
			page.setHandleDate(d2);
		}
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm="";
		String strUserName=user.getUserName();
		
		/*if(strYwlx!=null){
			strUserBzjgdm=null;
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}*/
		String strYwqx = user.getYwqx();
		page.setYwqx(strYwqx);
		strUserBzjgdm=user.getBzjgCode();
		
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		List ywlxConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		MyUtils.addToCollection(ywlxConditions, MyUtils.split(strYwlxCondition, " ,"));
		
		page.setBzjgdm(strUserBzjgdm);
		page.setUsername(strUserName);
		page.setHandleUsername(handleUsername);
		page.setStateConditions(stateConditions);
		page.setYwlxConditions(ywlxConditions);
		page.setDybz(strDybz);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		
		System.out.println("=====================");
		System.out.println(page.getBzjgdm());
		System.out.println(page.getUsername());
		System.out.println(page.getStateConditions());
		System.out.println(page.getYwlxConditions());
		System.out.println(page.getConditions());
		System.out.println("=====================");
		
		page = orgnewService.findByPage(page);
		return SUCCESS;
	}
	
	/**
	* 查找所有需要业务办理的申请单
	* @return
	 * @throws Exception 
	*/
	public String findAllYwqxOrgnew() throws Exception {
		String handleUsername= getRequest().getParameter("handleUsername");
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		String strYwlxCondition= getRequest().getParameter("ywlxConditions");
		String strDybz = getRequest().getParameter("dybz");
		String strHandleDate = getRequest().getParameter("handleDate");
		page = new Page();
		System.out.println(strHandleDate);
		if(strHandleDate!=null){
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date d = new Date();
			Date d2 = sdf1.parse(sdf2.format(d)+" 12:30:00");
			
			if(d.after(d2)){
				d2 = sdf1.parse(sdf2.format(d)+" 18:30:00");
			}
			d2 = new Date(d2.getTime()-24*60*60*1000);
			System.out.println("打证查询日期：："+sdf1.format(d2));
			page.setHandleDate(d2);
		}
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm="";
		String strUserName=user.getUserName();
		
		String strYwqx = user.getYwqx();
		if(strYwqx.equals("1")){//中心
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strYwqx.equals("2")){//跨区
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
			page.setCenterBzjgdm(user.getCenterCode());
		}else{//区县
			strUserBzjgdm=user.getBzjgCode();
		}
		page.setYwqx(strYwqx);
		
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		List ywlxConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		MyUtils.addToCollection(ywlxConditions, MyUtils.split(strYwlxCondition, " ,"));
		
		page.setBzjgdm(strUserBzjgdm);
		page.setUsername(strUserName);
		page.setHandleUsername(handleUsername);
		page.setStateConditions(stateConditions);
		page.setYwlxConditions(ywlxConditions);
		page.setDybz(strDybz);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		
		System.out.println("=====================");
		System.out.println(page.getBzjgdm());
		System.out.println(page.getUsername());
		System.out.println(page.getStateConditions());
		System.out.println(page.getYwlxConditions());
		System.out.println(page.getConditions());
		System.out.println("=====================");
		
		page = orgnewService.findByYwqxPage(page);
		return SUCCESS;
	}
	
	
	/**
	* 查找所有需要业务办理的申请单
	* @return
	 * @throws Exception 
	*/
	public String findQxAllOrgnew() throws Exception {
		String handleUsername= getRequest().getParameter("handleUsername");
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		String strYwlxCondition= getRequest().getParameter("ywlxConditions");
		String strDybz = getRequest().getParameter("dybz");
		String strHandleDate = getRequest().getParameter("handleDate");
		//String strYwlx= getRequest().getParameter("ywlx");
		page = new Page();
		System.out.println(strHandleDate);
		if(strHandleDate!=null){
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date d = new Date();
			Date d2 = sdf1.parse(sdf2.format(d)+" 12:30:00");
			
			if(d.after(d2)){
				d2 = sdf1.parse(sdf2.format(d)+" 18:30:00");
			}
			d2 = new Date(d2.getTime()-24*60*60*1000);
			System.out.println("打证查询日期：："+sdf1.format(d2));
			page.setHandleDate(d2);
		}
		
		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm="";
		String strUserName=user.getUserName();
		String strQxCode = user.getQxCode();
		
		if(strQxCode.equals("1")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 2);
		}else if(strQxCode.equals("2")){
			strUserBzjgdm=user.getBzjgCode().substring(0, 4);
		}else{
			strUserBzjgdm=user.getBzjgCode();
			page.setUsername(strUserName);
		}
		page.setQxCode(strQxCode);
		page.setCenterBzjgdm(user.getCenterCode());
		System.out.println("跟踪用户权限：：："+strQxCode+"--匹配办证机构："+strUserBzjgdm);
		/*if(strYwlx!=null){
			strUserBzjgdm=null;
		}else{
			strUserBzjgdm=user.getBzjgCode();
		}*/
		
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		List ywlxConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		MyUtils.addToCollection(ywlxConditions, MyUtils.split(strYwlxCondition, " ,"));
		
		page.setBzjgdm(strUserBzjgdm);
		
		page.setHandleUsername(handleUsername);
		page.setStateConditions(stateConditions);
		page.setYwlxConditions(ywlxConditions);
		page.setDybz(strDybz);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		
		System.out.println("=====================");
		System.out.println(page.getBzjgdm());
		System.out.println(page.getUsername());
		System.out.println(page.getStateConditions());
		System.out.println(page.getYwlxConditions());
		System.out.println(page.getConditions());
		System.out.println("=====================");
		
		page = orgnewService.findByQxPage(page);
		return SUCCESS;
	}
	
	public String findAllExcpOrgnew(){
		String strCondition = getRequest().getParameter("conditions");
		String strBzjgdm;
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		page = new Page();
		User user = (User) getSession().getAttribute("user");
		if(user.getBzjgCode().equals(user.getCenterCode())){
			strBzjgdm = null;
		}else{
			strBzjgdm = user.getBzjgCode();
		}
		page.setBzjgdm(strBzjgdm);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgnewService.findAllExcpOrgnew(page);
		return SUCCESS;
	}
	
	public String returnExceptionOrgnew() throws Exception{
		
		Orgnew orgnew = new Orgnew();
		orgnew = (Orgnew) orgnewService.findOrgnewByOrgid(orgid).get(0);
		orgnew.setState(state);
		success = orgnewService.updateExceptionOrgnew(orgnew);
		return SUCCESS;
	}
	
	public String delExceptionOrgnew(){
		
		success = orgnewService.delExceptionOrgnew(orgid);
		return SUCCESS;
	}

	/**
	* 查找网上办证业务办理的申请单
	* @return
	*/
	public String findNetAllOrgnew() {
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		String strYwlxCondition= getRequest().getParameter("ywlxConditions");
		String strDybz = getRequest().getParameter("dybz");

		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm=user.getBzjgCode();
		
		//String strAuditUserName=getRequest().getParameter("auditUsername");
		
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		List ywlxConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		MyUtils.addToCollection(ywlxConditions, MyUtils.split(strYwlxCondition, " ,"));
		
		
		page = new Page();
		page.setBzjgdm(strUserBzjgdm);
		//page.setAuditUsername(strAuditUserName);
		page.setStateConditions(stateConditions);
		page.setYwlxConditions(ywlxConditions);
		page.setDybz(strDybz);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		
		page = orgnewService.findByPage(page);
		return SUCCESS;
	}
	/**
	* 查找所有需要业务办理的申请单数量
	* @return
	*/
	public String findCountAllOrgnew() {
		String handleUsername= getRequest().getParameter("handleUsername");
		String strStateCondition= getRequest().getParameter("stateConditions");

		User user = (User) getSession().getAttribute("user");
		String strUserBzjgdm=user.getBzjgCode();
		String strUserName=user.getUserName();
		
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		
		page = new Page();
		page.setBzjgdm(strUserBzjgdm);
		page.setUsername(strUserName);
		page.setHandleUsername(handleUsername);
		page.setStateConditions(stateConditions);
		msgCountList=orgnewService.findCountByPage(page);
		System.out.println(msgCountList);
		return SUCCESS;
	}
	
	/**
	* 比较z_org_new和z_tjgdm表中同一属性的值，如不相同，则生成字段LIST
	* @return
	*/
	public String verifyOrgnew() {
		String strJgdm = getRequest().getParameter("jgdm");
		verifyFieldList=orgnewService.verifyFieldByJgdm(strJgdm);
		if(verifyFieldList.size()==2){
				Orgnew orgnew1=new Orgnew();
				orgnew1=(Orgnew)verifyFieldList.get(0);
				
				Orgnew orgnew2=new Orgnew();
				orgnew2=(Orgnew)verifyFieldList.get(1);
				
				Field[] fields=orgnew1.getClass().getDeclaredFields();
				String fieldName;
			    String fieldType;
			    String fieldValue=null;
			    String oldfieldValue=null;
			    for(int i=0;i<fields.length;i++){
			    	fieldName=fields[i].getName();//字段名
			    	fieldType=fields[i].getType().toString();//字段属性
			    	//System.out.println(fieldName+","+fieldType);
			    	if("class java.util.Date".equals(fieldType) || "class java.lang.Integer".equals(fieldType)){
			    		if(MyUtils.getFieldValueByName(fields[i].getName(), orgnew1)!=null){
			    			fieldValue=new SimpleDateFormat("yyyyMMdd").format(MyUtils.getFieldValueByName(fields[i].getName(), orgnew1));//属性值1
			    		}
			    		if(MyUtils.getFieldValueByName(fields[i].getName(), orgnew2)!=null){
			    			oldfieldValue=new SimpleDateFormat("yyyyMMdd").format(MyUtils.getFieldValueByName(fields[i].getName(), orgnew2));//属性值2
			    		}
			    	}else if("class java.math.BigDecimal".equals(fieldType)){
			    		fieldValue=MyUtils.getFieldValueByName(fields[i].getName(), orgnew1).toString();//属性值1
				    	oldfieldValue=MyUtils.getFieldValueByName(fields[i].getName(), orgnew2).toString();//属性值2
			    	}else{
			    		fieldValue=(String) MyUtils.getFieldValueByName(fields[i].getName(), orgnew1);//属性值1
				    	oldfieldValue=(String) MyUtils.getFieldValueByName(fields[i].getName(), orgnew2);//属性值2
			    	}
			    	
			    	
			    	if(fieldValue!=null &&  oldfieldValue!=null){
				    	if(!fieldValue.equals(oldfieldValue)){//属性值
				    		Map<String,String> fieldMap = new HashMap<String,String>();
				    		fieldMap.put("oldValue", oldfieldValue);
				    		fieldMap.put("fieldName", fieldName);
				    		fieldList.add(fieldMap);
				    	} 
			    	}
			    }
		}
		System.out.println(fieldList);
		return SUCCESS;
	}
	/**
	* 分中心审核，查找所有需要审核的申请单
	* @return
	*/
	public String findShenheXcAllOrgnew() {
		String strUserName = getRequest().getParameter("userName");
		String strBzjgdm= getRequest().getParameter("userBzjgdm");
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");	

		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		
		page = new Page();
		page.setBzjgdm(strBzjgdm);
		page.setUsername(strUserName);
		page.setStateConditions(stateConditions);
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgnewService.findShenheXcByPage(page);
		return SUCCESS;
	}
	
	
	/**
	* 网上办证审核需要审核的申请单
	* @return
	*/
	public String findShenheNetAllOrgnew() {
		String strUserName = getRequest().getParameter("userName");
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");		
		String strBzjgdm = getRequest().getParameter("bzjgdm");
		//String strBzjgdmCondition= getRequest().getParameter("bzjgdmConditions");

		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		//List bzjgdmConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		//MyUtils.addToCollection(bzjgdmConditions, MyUtils.split(strBzjgdmCondition, " ,"));

		page = new Page();
		page.setBzjgdm(strBzjgdm);
		page.setUsername(strUserName);
		page.setStateConditions(stateConditions);
		page.setConditions(conditions);
		//page.setBzjgdmConditions(bzjgdmConditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgnewService.findShenheNetByPage(page);
		return SUCCESS;
	}
	
	

	/**
	 * 删除
	 * @return
	 */
	public String deleteOrgnew() {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			success = orgnewService.deleteOrgnew(getSession().getServletContext().getRealPath("/"), Integer.valueOf(strOrgid));
		}
		return SUCCESS;
	}
	
	/**
	 * 修改信息
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateOrgnew() throws Exception{
		
		String newPageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		Orgnew orgnew = new Orgnew();
		orgnew.setOrgid(orgid);
		orgnew.setOrderid(orderid);
		orgnew.setJgdm(jgdm);
		orgnew.setJgmc(jgmc);
		orgnew.setJglx(jglx);
		orgnew.setJglxdm(jglxdm);
		orgnew.setJglxOld(jglxOld);
		orgnew.setJglxdmOld(jglxdmOld);
		orgnew.setZjlx(zjlx);
		orgnew.setZjhm(zjhm);
		orgnew.setJjhydm(jjhydm);
		orgnew.setJjhymc(jjhymc);
		orgnew.setJjhydmOld(jjhydmOld);
		orgnew.setJjhymcOld(jjhymcOld);
		orgnew.setJyfw(jyfw);
		orgnew.setQyjj(qyjj);
		orgnew.setJjlx(jjlx);
		orgnew.setJjlxdm(jjlxdm);
		orgnew.setJjlxOld(jjlxOld);
		orgnew.setJjlxdmOld(jjlxdmOld);
		orgnew.setZcrq(zcrq);
		orgnew.setZgdm(zgdm);
		orgnew.setPzjgdm(pzjgdm);
		orgnew.setXzqhCode(xzqhCode);
		orgnew.setXzqhName(xzqhName);
		orgnew.setJgdz(jgdz);
		orgnew.setYzbm(yzbm);
		orgnew.setDhhm(dhhm);
		orgnew.setScbzrq(scbzrq);
		orgnew.setBzrq(bzrq);
		orgnew.setZfrq(zfrq);
		orgnew.setBzjgdm(bzjgdm);
		orgnew.setZycp1(zycp1);
		orgnew.setZycp2(zycp2);
		orgnew.setZycp3(zycp3);
		orgnew.setZczj(zczj);
		orgnew.setWftzgb(wftzgb);
		orgnew.setWftzgbdm(wftzgbdm);
		orgnew.setHbzl(hbzl);
		orgnew.setZgrs(zgrs);
		orgnew.setFbsl(fbsl);
		orgnew.setZslsh(zslsh);
		orgnew.setBgbj(bgbj);
		orgnew.setBgrq(bgrq);
		orgnew.setLry(lry);
		orgnew.setNjrq(njrq);
		orgnew.setNjr(njr);
		orgnew.setNjqx(njqx);
		orgnew.setXgr(xgr);
		orgnew.setZbsl(zbsl);
		orgnew.setZch(zch);
		orgnew.setQzbz(qzbz);
		orgnew.setQzrq(qzrq);
		orgnew.setZgmc(zgmc);
		orgnew.setPzjgmc(pzjgmc);
		orgnew.setGslsh(gslsh);
		orgnew.setGstbr(gstbr);
		orgnew.setWjwlsh(wjwlsh);
		orgnew.setPzwh(pzwh);
		orgnew.setPwrq(pwrq);
		orgnew.setWjwtbr(wjwtbr);
		orgnew.setGk(gk);
		orgnew.setFkbz(fkbz);
		
		orgnew.setFksl(fksl);
		orgnew.setDybz(dybz);
		orgnew.setEmail(email);
		orgnew.setWeburl(weburl);
		orgnew.setMobile(mobile);
		orgnew.setDjblx(djblx);
		orgnew.setLastdate(lastdate);
		orgnew.setCzflag(czflag);
		orgnew.setYjflag(yjflag);
		orgnew.setSjzt(sjzt);
		orgnew.setJyjg(jyjg);
		orgnew.setFz(fz);
		orgnew.setTbrzjlx(tbrzjlx);
		orgnew.setMemo(memo);
		orgnew.setNjjlx(njjlx);
		orgnew.setMemo2(memo2);
		orgnew.setMemo3(memo3);
		orgnew.setMemo4(memo4);
		orgnew.setTbrxm(tbrxm);
		orgnew.setTbrsfzh(tbrsfzh);
		orgnew.setIsca(isca);
		orgnew.setIsxw(isxw);
		orgnew.setTbrlxfs(tbrlxfs);
		orgnew.setGsfzrq(gsfzrq);
		
		
		if(newPageTypeStr=="" || "".equals(newPageTypeStr)){
			
		}else{
			newPageTypeStr=MyUtils.str_replace(newPageTypeStr,"|","%");  //转换“PageType”中的字符串%为“|”
			orgnew.setPageTypeStr(newPageTypeStr);
		}
		
		orgnew.setJydz(jydz);
		orgnew.setJyqhmc(jyqhmc);
		orgnew.setJyqhdm(jyqhdm);
		orgnew.setJyyb(jyyb);
		orgnew.setJydh(jydh);
		orgnew.setJfly(jfly);
		orgnew.setKhyh(khyh);
		orgnew.setKhzh(khzh);
		orgnew.setZsbfrq(zsbfrq);
		orgnew.setZszfrq(zszfrq);
		orgnew.setMoveoutCenter(moveoutCenter);
		orgnew.setMoveoutBzjgdm(moveoutBzjgdm);
		orgnew.setMoveoutAddrss(moveoutAddrss);
		orgnew.setMoveoutReason(moveoutReason);
		orgnew.setOffPzjgmc(offPzjgmc);
		orgnew.setOffPzwh(offPzwh);
		orgnew.setOffReason(offReason);
		orgnew.setOffNote(offNote);
		
		orgnew.setHandleNote(handleNote);
		
		
		orgnew.setD_flag(d_flag);
		orgnew.setUp_Dflag(1);
		orgnew.setUp_Aflag(up_Aflag);
		orgnew.setErrorFlag(errorFlag);
		
		orgnew.setQyzclx(qyzclx);
		orgnew.setYwlx(ywlx);
		orgnew.setUserid(userid);
		orgnew.setUsername(username);
		orgnew.setState(state);
		
		orgnew = this.upload(orgnew);
		/*1.如果图书本来没有图片则不用删除原来图片
		 *2.如果原来有图片并且修改后的图片不一样则删除原来图片
		 */
		if(imageUrl != null && null != orgnew.getImageUrl() && !imageUrl.equals(orgnew.getImageUrl())){
			MyUtils.delFile(getSession().getServletContext().getRealPath("/")+ imageUrl);
		}
		if(upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) && orgnewService.updateOrgnew(orgnew) ){
			this.jsonString = "{success:true,imageUrl:'" + orgnew.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}else if(upload == null && orgnewService.updateOrgnew(orgnew)){
			this.jsonString = "{success:true,imageUrl:'" + imageUrl + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	/**
	* 查找所有需要审核的申请单
	* @return
	*/
	public String findAllOrgnewOrTjgdm() {

		String strUserName = getRequest().getParameter("userName");
		String strUserBzjgdm = getRequest().getParameter("userBzjgdm");
		String strCondition = getRequest().getParameter("conditions");
		List conditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));

		page = new Page();
		page.setUsername(strUserName);
		
		User user = (User) getSession().getAttribute("user");
		if(!user.getBzjgCode().equals(user.getCenterCode())){
			page.setBzjgdm(strUserBzjgdm);
		}
		page.setConditions(conditions);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgnewService.findAllOrgnewOrTjgdmByPage(page);
		return SUCCESS;
	}
	
	private Orgnew upload(Orgnew orgnew){
		String _imageUrl = null;
		if (upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(","))) {
			String rootPath = getSession().getServletContext().getRealPath("/");
			String savePath = rootPath + getSavePath();
			MyUtils.mkDirectory(savePath);
			String newFileName = MyUtils.upload(getUploadFileName(), savePath, getUpload());
			_imageUrl = getSavePath() + newFileName;
			try {
				MyUtils.createMiniPic(new File(savePath + newFileName), maxWidthSize,maxHeightSize);
			} catch (IOException e) {
				e.printStackTrace();
			}
			orgnew.setImageUrl(_imageUrl);
		}
		return orgnew;
	}


	
	/**
	 * 上传扫描数据到文本服务器efile目录下
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveImageOrgnew() throws Exception{
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
			success=true;
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
				pageTypeStr=MyUtils.str_replace(pageTypeStr,"|","%"); 
				Orgnew orgnew = new Orgnew();
				orgnew.setOrgid(Integer.valueOf(strOrgid));
				orgnew.setPageTypeStr(pageTypeStr);
				orgnew.setImageUrl(saveFileName);
				//orgnew.setImageUrl(imageUrl);
				//orgnew.setImageFlag(imageFlag);
				success = orgnewService.saveImageOrgnew(orgnew);
			}
		}
		return SUCCESS;
	}


	
	/**
	 * 提交申请
	 */
	public String returnOrgnew() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.returnOrgnew(orgnew);
		}
		return SUCCESS;
	}
	
	/**
	 * 网上审核
	 */
	public String returnOrgnewOk() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		//String strBzjgdm = getRequest().getParameter("currentZzUserBzjgdm");
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Orgnew orgnew = new Orgnew();
			orgnew.setAuditUserid(String.valueOf(user.getUserId()));
			orgnew.setAuditUsername(user.getUserName());
			orgnew.setAuditName(user.getEmplName());
			//orgnew.setUserid(user.getUserId());
			//orgnew.setBzjgdm(strBzjgdm);
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.returnOrgnewOk(orgnew);
		}
		return SUCCESS;
	}
	
	public String returnOrgnewNo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Orgnew orgnew = new Orgnew();
			orgnew.setAuditUserid(String.valueOf(user.getUserId()));
			orgnew.setAuditUsername(user.getUserName());
			orgnew.setAuditName(user.getEmplName());
			//orgnew.setUserid(user.getUserId());
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.returnOrgnewNo(orgnew);
		}
		return SUCCESS;
	}
	
	/**
	 * 分中心审核
	 */
	public String shenheOrgnewOk() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		String strAuditNote = getRequest().getParameter("auditNote");
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Orgnew orgnew = new Orgnew();
			orgnew.setAuditNote(strAuditNote);
			orgnew.setAuditUserid(String.valueOf(user.getUserId()));
			orgnew.setAuditUsername(user.getUserName());
			orgnew.setAuditName(user.getEmplName());
			orgnew.setUserid(user.getUserId());
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.shenheOrgnewOk(orgnew);
		}
		return SUCCESS;
	}
	
	public String shenheOrgnewNo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		String strAuditNote = getRequest().getParameter("auditNote");
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Orgnew orgnew = new Orgnew();
			orgnew.setAuditNote(strAuditNote);
			orgnew.setAuditUserid(String.valueOf(user.getUserId()));
			orgnew.setAuditUsername(user.getUserName());
			orgnew.setAuditName(user.getEmplName());
			orgnew.setUserid(user.getUserId());
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.shenheOrgnewNo(orgnew);
		}
		return SUCCESS;
	}
	public String returnOrgnewCode() throws Exception {

		//Orgnew orgnew = new Orgnew();
		String strOrgid = getRequest().getParameter("orgid");
		String strJgmc = getRequest().getParameter("jgmc");
		String strJgdz = getRequest().getParameter("jgdz");
		String strDmlx = getRequest().getParameter("dmlx");
		String strZch = getRequest().getParameter("zch");
		String strFlag=getRequest().getParameter("flag");//是否进行校验，0校验，1不校验
		String strUrl = "";
		String strUsername = "";
		String strPassword = "";

		System.out.println("取码+++++++|"+strJgmc+"|-----|"+strJgdz+"|-----|"+strDmlx+"|-----|"+strZch+"|-----|"+strFlag+"|+++++++++++");
		//String strDmlx = "0";   //0 个体，3非个体，5军队
		
		if (strOrgid != null && !"".equals(strOrgid)) {
			appSysConfig = ActionContext.getContext().getApplication();
			String strCreateCodeMode=appSysConfig.get("sysCreateCodeMode").toString();
			if(strCreateCodeMode.equals("0")){
				//通过远程接口取机构代码
				try{
					
					if(appSysConfig.get("sysAutoCodeServerUrl")!=null && !"".equals(appSysConfig.get("sysAutoCodeServerUrl"))){
						strUrl = "https://" + appSysConfig.get("sysAutoCodeServerUrl") + "/unifyorgcode/services/code-assign/only-text";
					}else{
						strUrl = "https://190.15.15.156:7001/unifyorgcode/services/code-assign/only-text";
					}
					strUsername = (String) appSysConfig.get("sysCodeUsername");
					strPassword = (String) appSysConfig.get("sysCodePassword");
					System.out.println("++++++"+strUrl+"++++++");
					System.out.println(strUsername+"+++++++++++++"+strPassword);
					CodeAssignClient cac = new CodeAssignClient();
					String resultCode = cac.onlyTextApply(strUrl, strUsername, strPassword, strJgmc, strZch, strJgdz, strDmlx, strFlag);
					System.out.println("取码返回值+++"+resultCode);
					//0：成功，1：疑似赋码， 2：重复赋码， 3：失败
					resultCode = resultCode.substring(1, resultCode.length()-1);
					resultCode = resultCode.replaceAll("'", "");
					String[] rs = resultCode.split(",",3);
					Map<String,String> m = new HashMap<String,String>();
					for(int i = 0; i < rs.length;i++){
						String[] strRs = rs[i].split(":",2);
						if(strRs.length==2){
							m.put(strRs[0],strRs[1]);
						}else{
							m.put(strRs[0], "");
						}
					}
					List root=new ArrayList();
					Map<String,String> dataMap = new HashMap<String,String>();
					Map<String,String> m2 = new HashMap<String,String>();
					if(m.get("flag").equals("1")||m.get("flag").equals("2")){
						String str = m.get("info");
						//以下对疑似赋码信息进行处理
						//{orgName:中科通图,regNum:601092874,orgAddress:北京市海淀区学清路,code:12029761x }
						//,{orgName:中科通图,regNum:601092882,orgAddress:北京市海淀区学清路,code:10029841x }
						String[] strInfo = str.split("},");
						for(int i = 0; i < strInfo.length;i++){
							String s = strInfo[i].replace('{', ' ').replace('}', ' ').trim();
							//orgName:中科通图,regNum:601092874,orgAddress:北京市海淀区学清路,code:12029761x
							String[] sa = s.split(",");
							for(int j = 0; j < sa.length;j++){
								String[] saa = sa[j].split(":");
								dataMap.put(saa[0], saa[1]);
							}
							m2.put("jgdm",dataMap.get("code"));
							m2.put("jgmc",dataMap.get("orgName"));
							m2.put("zch",dataMap.get("regNum"));
							m2.put("flag",m.get("flag"));
							root.add(m2);
						}
						
					}else{
						dataMap.put("jgdm",m.get("code"));
						dataMap.put("jgmc",strJgmc);
						dataMap.put("zch",strZch);
						dataMap.put("flag",m.get("flag"));
						dataMap.put("info",m.get("info"));
						root.add(dataMap);
					}
					page = new Page();
					page.setSuccess(success);
					page.setRoot(root);	
					return SUCCESS;
								
				}catch(Exception e){
					e.printStackTrace();
					
				}
			}else{
				List root=new ArrayList();
				if(!"1".equals(strFlag)){
					Tjgdm tjgdm= new Tjgdm();
					tjgdm.setZch(strZch);
					tjgdm.setJgmc(strJgmc);
					tjgdmList=tjgdmService.fingCodeByTjgdm(tjgdm); //查询疑似赋码

					if(tjgdmList.size()>0){//疑似赋码
						for(int i=0;i<tjgdmList.size();i++){
							Tjgdm tjgdm2=new Tjgdm();
							tjgdm2=(Tjgdm)tjgdmList.get(i);
							Map<String,String> dataMap = new HashMap<String,String>();
							dataMap.put("jgdm",tjgdm2.getJgdm());
							dataMap.put("jgmc",tjgdm2.getJgmc());
							dataMap.put("zch",tjgdm2.getZch());
							dataMap.put("flag","4");
							root.add(dataMap);
						}
					}else{//去代码表取码 
						CodeDetail codeDetail= new CodeDetail();
						codeDetail.setZch(strZch);
						codeDetail.setJgmc(strJgmc);
						codeDetail.setDmlx(strDmlx);
						CodeDetail codeDetail2=codeDetailService.createCode(codeDetail); 
						if(codeDetail2!=null){
							Map<String,String> dataMap = new HashMap<String,String>();
							dataMap.put("jgdm",codeDetail2.getJgdm());
							dataMap.put("jgmc",strJgmc);
							dataMap.put("zch",strZch);
							dataMap.put("flag",codeDetail2.getFlag()); 
							root.add(dataMap);
						}
					}
				}else{
					CodeDetail codeDetail= new CodeDetail();
					codeDetail.setZch(strZch);
					codeDetail.setJgmc(strJgmc);
					codeDetail.setDmlx(strDmlx);
					CodeDetail codeDetail2=codeDetailService.createCode(codeDetail);
					if(codeDetail2!=null){
						Map<String,String> dataMap = new HashMap<String,String>();
						dataMap.put("jgdm",codeDetail2.getJgdm());
						dataMap.put("jgmc",strJgmc);
						dataMap.put("zch",strZch);
						dataMap.put("flag",codeDetail2.getFlag()); 
						root.add(dataMap);
					}
				}
				page = new Page();
				page.setSuccess(success);
				page.setRoot(root);	
				return SUCCESS;
			}
		}
		return SUCCESS;
	}
	
	public String saveOrgnewCode() throws Exception {

		String sorgid = getRequest().getParameter("orgid");
		String sjgdm = getRequest().getParameter("jgdm");
		String scenterid = getRequest().getParameter("centerid");
		String szch = getRequest().getParameter("zch");
		String sjgmc = getRequest().getParameter("jgmc");
		String strUrl = "";
		String strUsername = "";
		String strPassword = "";
		success=false;
		Orgnew orgnew = new Orgnew();
		orgnew.setOrgid(Integer.valueOf(sorgid));
		orgnew.setJgdm(sjgdm);
		//orgnewService.updateOrgnew(orgnew);
		if(orgnewService.updateOrgnew(orgnew)){
			appSysConfig = ActionContext.getContext().getApplication();
			String strCreateCodeMode=appSysConfig.get("sysCreateCodeMode").toString();
			if(strCreateCodeMode.equals("0")){
				/*AutoAllocateCodeClientEncrypt encSig = new AutoAllocateCodeClientEncrypt();
				encSig.successConfirm(scenterid, sjgmc, szch,sjgdm);*/
				if(appSysConfig.get("sysAutoCodeServerUrl")!=null && !"".equals(appSysConfig.get("sysAutoCodeServerUrl"))){
					strUrl = "https://" + appSysConfig.get("sysAutoCodeServerUrl") + "/unifyorgcode/services/code-assign/confirm";
				}else{
					strUrl = "https://190.15.15.129:7001/unifyorgcode/services/code-assign/confirm";
				}
				strUsername = (String) appSysConfig.get("sysCodeUsername");
				strPassword = (String) appSysConfig.get("sysCodePassword");
				CodeAssignClient cac = new CodeAssignClient();
				String resultCode = cac.confirm(strUrl, strUsername, strPassword, sjgdm);
				System.out.println("-------------------------|"+sjgdm+"|保存成功过后，给代码库返回成功的方法------------------------");
				System.out.println("-------------------------执行确认方法后的返回值|"+resultCode+"|------------------------");
				
				success=true;
			}else{
				//删除(或者赋isFuma值为2);
				success=codeDetailService.deleteCodeDetail(sjgdm);
			}
		}
		return SUCCESS;
	}

	
	//归档
	public String returnOrgnewCreateOne() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			success = orgnewService.returnOrgnewCreate(orgnew);
		}
		return SUCCESS;
	}
	
	//批量归档
	public String returnOrgnewCreate() throws Exception {
		success=false;
		String strOrgids = getRequest().getParameter("orgids");
		//System.out.print(strOrgids);
		if (strOrgids != null && !"".equals(strOrgids)) {
			String orgidList[]=MyUtils.split(strOrgids, ",");
			for (int i = 0; i < orgidList.length; i++) {
				Orgnew orgnew = new Orgnew();
				orgnew.setOrgid(Integer.valueOf(orgidList[i]));
				success = orgnewService.returnOrgnewCreate(orgnew);
			}
		}
		return SUCCESS;
	}
	
	/**
	* 单个加载原文
	* @return
	*/
	public String orgnewViewImg() { //zz目录下的原文
		String systemPath = "";
		String imageData="";
		String imageUrl="";
		Integer orgid =  Integer.valueOf(getRequest().getParameter("orgid"));
		systemPath = getSavePath()+"efile\\";  //上传的临时路劲
		//systemPath = getSession().getServletContext().getRealPath("/")+"efile\\";  //上传的临时路劲
		
		Orgnew orgnew = new Orgnew();
		orgnew=(Orgnew) orgnewService.orgnewViewImg(orgid);	
		imageUrl=orgnew.getImageUrl();
		success=false;
		if(imageUrl!="" && imageUrl!=null){
			//imageUrl=systemPath+orgnew.getImageUrl();
			imageUrl=orgnew.getImageUrl();
			
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
			page.setPageTypeStr(orgnew.getPageTypeStr());
			success=true;
		}
		return SUCCESS;
	}
	
	public String findOrgnewByOrgid() { //zz目录下
		Integer orgid =  Integer.valueOf(getRequest().getParameter("orgid"));		
		page = new Page();
		page.setRoot(orgnewService.findOrgnewByOrgid(orgid));
		return SUCCESS;
	}
	
	public String returnOrgnewPrint() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Orgnew orgnew = new Orgnew();
			orgnew.setHandleUsername(user.getUserName());
			orgnew.setHandleName(user.getEmplName());
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			orgnewService.returnOrgnewPrint(orgnew);
		}
		return SUCCESS;
	}
	
	//现场业务办理的提交办理
	public String returnOrgnewDo() throws Exception {	
		String strOrgid = getRequest().getParameter("orgid");
		String strJgdm = getRequest().getParameter("jgdm");
		String strState = getRequest().getParameter("state");
		String strYwlx = getRequest().getParameter("ywlx");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			orgnew.setJgdm(strJgdm);
			orgnew.setYwlx(strYwlx);
			orgnew.setState(strState);
			//System.out.println(strState+"::::::::::::::::::"+orgnew.getState());
			User user = (User) getSession().getAttribute("user");
			if("10".equals(strState)){
				orgnew.setLry(String.valueOf(user.getUserId()));
				orgnew.setLrName(user.getUserName());
				orgnew.setLrDate(new Date());
			}else{
				orgnew.setHandleUserid(String.valueOf(user.getUserId()));
				orgnew.setHandleUsername(user.getUserName());
				orgnew.setHandleName(user.getEmplName());
				orgnew.setHandleDate(new Date());
			}
			System.out.println("需要保存的bzjgdm:"+bzjgdm);
			boolean f = user.getBzjgCode().equals(user.getCenterCode());
			
			success = orgnewService.returnOrgnewDo(orgnew,f);
			state = orgnewService.findByOrgnew(orgnew);
		}
		return SUCCESS;
	}
	

	public String saveOrgnewModify() throws Exception {
		String strJglxOld="";
		String strJglxdmOld="";
		String docid="";
		Integer ijglxdm=0;
		String sorgid = getRequest().getParameter("orgid");
		if(getRequest().getParameter("jglxdm")!=null && getRequest().getParameter("jglxdm")!=""){
			ijglxdm = Integer.parseInt(getRequest().getParameter("jglxdm"));
		}
		User user = (User) getSession().getAttribute("user");
		String centerid=user.getCenterCode();
		
		Orgnew orgnew = new Orgnew();
		orgnew.setOrgid(orgid);
		orgnew.setCenterid(centerid);
		orgnew.setJgdm(jgdm);
		orgnew.setJgmc(jgmc);
		orgnew.setJglx(jglx);
		orgnew.setJglxdm(jglxdm);

		orgnew.setFddbr(fddbr);
		orgnew.setZjlx(zjlx);
		orgnew.setZjhm(zjhm);
		orgnew.setJjhydm(jjhydm);
		orgnew.setJjhymc(jjhymc);
		orgnew.setJjhydmOld(jjhydmOld);
		orgnew.setJjhymcOld(jjhymcOld);
		orgnew.setQyjj(qyjj);
		orgnew.setJyfw(jyfw);
		orgnew.setJjlx(jjlx);
		orgnew.setJjlxdm(jjlxdm);
		orgnew.setJjlxOld(jjlxOld);
		orgnew.setJjlxdmOld(jjlxdmOld);
		orgnew.setZcrq(zcrq);
		orgnew.setZgdm(zgdm);
		orgnew.setPzjgdm(pzjgdm);
		orgnew.setXzqhCode(xzqhCode);
		orgnew.setXzqhName(xzqhName);
		orgnew.setJgdz(jgdz);
		orgnew.setYzbm(yzbm);
		orgnew.setDhhm(dhhm);
		orgnew.setScbzrq(scbzrq);
		orgnew.setBzrq(bzrq);
		orgnew.setZfrq(zfrq);
		orgnew.setBzjgdm(bzjgdm);
		orgnew.setZycp1(zycp1);
		orgnew.setZycp2(zycp2);
		orgnew.setZycp3(zycp3);
		orgnew.setZczj(zczj);
		orgnew.setWftzgb(wftzgb);
		orgnew.setWftzgbdm(wftzgbdm);
		orgnew.setHbzl(hbzl);
		orgnew.setZgrs(zgrs);
		orgnew.setFbsl(fbsl);
		orgnew.setZslsh(zslsh);
		orgnew.setBgbj(bgbj);
		orgnew.setBgrq(bgrq);
		orgnew.setLry(lry);
		orgnew.setNjrq(njrq);
		orgnew.setNjr(njr);
		orgnew.setNjqx(njqx);
		orgnew.setXgr(xgr);
		orgnew.setZbsl(zbsl);
		orgnew.setZch(zch);
		orgnew.setQzbz(qzbz);
		orgnew.setQzrq(qzrq);
		orgnew.setZgmc(zgmc);
		orgnew.setPzjgmc(pzjgmc);
		orgnew.setGslsh(gslsh);
		orgnew.setGstbr(gstbr);
		orgnew.setWjwlsh(wjwlsh);
		orgnew.setPzwh(pzwh);
		orgnew.setPwrq(pwrq);
		orgnew.setWjwtbr(wjwtbr);
		orgnew.setGk(gk);
		orgnew.setFkbz(fkbz);
		
		orgnew.setFksl(fksl);
		orgnew.setDybz(dybz);
		orgnew.setEmail(email);
		orgnew.setWeburl(weburl);
		orgnew.setMobile(mobile);
		orgnew.setDjblx(djblx);
		orgnew.setLastdate(lastdate);
		orgnew.setCzflag(czflag);
		orgnew.setYjflag(yjflag);
		orgnew.setSjzt(sjzt);
		orgnew.setJyjg(jyjg);
		orgnew.setFz(fz);
		orgnew.setTbrzjlx(tbrzjlx);
		orgnew.setMemo(memo);
		orgnew.setNjjlx(njjlx);
		orgnew.setMemo2(memo2);
		orgnew.setMemo3(memo3);
		orgnew.setMemo4(memo4);
		orgnew.setTbrxm(tbrxm);
		orgnew.setTbrsfzh(tbrsfzh);
		orgnew.setIsca(isca);
		orgnew.setIsxw(isxw);
		orgnew.setTbrlxfs(tbrlxfs);
		orgnew.setGsfzrq(gsfzrq);
		orgnew.setJydz(jydz);
		orgnew.setJyqhmc(jyqhmc);
		orgnew.setJyqhdm(jyqhdm);
		orgnew.setJyyb(jyyb);
		orgnew.setJydh(jydh);
		orgnew.setJfly(jfly);
		orgnew.setKhyh(khyh);
		orgnew.setKhzh(khzh);
		orgnew.setZsbfrq(zsbfrq);
		orgnew.setZszfrq(zszfrq);
		orgnew.setMoveoutCenter(moveoutCenter);
		orgnew.setMoveoutBzjgdm(moveoutBzjgdm);
		orgnew.setMoveoutAddrss(moveoutAddrss);
		orgnew.setMoveoutReason(moveoutReason);
		orgnew.setOffPzjgmc(offPzjgmc);
		orgnew.setOffPzwh(offPzwh);
		orgnew.setOffReason(offReason);
		orgnew.setOffNote(offNote);
		
		orgnew.setD_flag(d_flag);
		orgnew.setUp_Dflag(up_Dflag);
		orgnew.setUp_Aflag(up_Aflag);
		orgnew.setErrorFlag(errorFlag);
		
		orgnew.setHandleNote(handleNote);
		
		orgnew.setQyzclx(qyzclx);
		orgnew.setYwlx(ywlx);
		orgnew.setUserid(userid);
		orgnew.setUsername(username);
		orgnew.setState(state);
		
		
		switch(ijglxdm) {
		case 11: 
			strJglxOld="企业法人";
			strJglxdmOld="1";
			break; 
		case 13: 
			strJglxOld="企业法人";
			strJglxdmOld="1";
			break; 
		case 15: 
			strJglxOld="企业非法人";
			strJglxdmOld="2";
			break; 
		case 17: 
			strJglxOld="企业非法人";
			strJglxdmOld="2";
			break;
		case 19: 
			strJglxOld="企业非法人";
			strJglxdmOld="2";
			break;
		case 31: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 32: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 33: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 34: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 35: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 36: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 37: 
			strJglxOld="机关法人";
			strJglxdmOld="7";
			break;
		case 39: 
			strJglxOld="机关非法人";
			strJglxdmOld="8";
			break;
		case 51: 
			strJglxOld="事业法人";
			strJglxdmOld="3";
			break;
		case 53: 
			strJglxOld="事业非法人";
			strJglxdmOld="4";
			break;
		case 59: 
			strJglxOld="其他事业法人";
			strJglxdmOld="D";
			break;
		case 71: 
			strJglxOld="社团法人";
			strJglxdmOld="5";
			break;
		case 73: 
			strJglxOld="社团非法人";
			strJglxdmOld="6";
			break;
		case 91: 
			strJglxOld="民办非企业单位";
			strJglxdmOld="A";
			break;
		case 93: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 94: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 95: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 96: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 97: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		case 98: 
			strJglxOld="个体";
			strJglxdmOld="B";
			break;
		case 99: 
			strJglxOld="其他机构";
			strJglxdmOld="9";
			break;
		default:
			strJglxOld=null;
			strJglxdmOld=null;
		}
		orgnew.setJglxOld(strJglxOld);
		orgnew.setJglxdmOld(strJglxdmOld);

		if(sorgid != null && sorgid!="" && !"".equals(sorgid) ){
			//如果不是新录入的，则更新
			docid=getRequest().getParameter("docid");
			orgnew.setDocid(docid);
			//orgnewService.updateOrgnew(orgnew);
			orgnewService.updateOrgnewModify(orgnew);
			orgid=Integer.parseInt(sorgid);
		}else{
			docid=getRequest().getParameter("docid");
			orgnew.setDocid(docid);
			//否则插入一条数据，保存
			//orgid = (Integer) orgnewService.saveOrgnew(orgnew);
			orgid = (Integer) orgnewService.saveOrgnewModify(orgnew);
			
		}
		
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",docid:'"+docid+"',success:true,imageUrl:'" + orgnew.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			//return INPUT;
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	public String returnOrgnewModify() throws Exception {
		
		String strOrgid = getRequest().getParameter("orgid");
		String strJgdm = getRequest().getParameter("jgdm");
		String strState = getRequest().getParameter("state");
		String strYwlx = getRequest().getParameter("ywlx");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			orgnew.setJgdm(strJgdm);
			orgnew.setYwlx(strYwlx);
			orgnew.setState(strState);
			
			User user = (User) getSession().getAttribute("user");
			orgnew.setHandleUserid(String.valueOf(user.getUserId()));
			orgnew.setHandleUsername(user.getUserName());
			orgnew.setHandleName(user.getEmplName());
			orgnew.setHandleDate(new Date());
			
			success = orgnewService.returnOrgnewModify(orgnew);
		}
		return SUCCESS;
	}
	public String returnOrgnewGo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			
			success = orgnewService.returnOrgnewGo(orgnew);
		}
		return SUCCESS;
	}
	
	public String updateDybzByOrgid() throws Exception{
		String strOrgid = getRequest().getParameter("orgid");
		
		if (strOrgid != null && !"".equals(strOrgid)) {
			Orgnew orgnew = new Orgnew();
			orgnew.setOrgid(Integer.valueOf(strOrgid));
			orgnew.setDybz("N");
			success = orgnewService.updateDybzByOrgid(orgnew);
		}
		return SUCCESS;
	}
	
	public String validateJgmc() throws Exception{
		
		String docid=getRequest().getParameter("docid");
		Orgnew orgnew = new Orgnew();
		orgnew.setJgmc(jgmc);
		orgnew.setDocid(docid);
		success = orgnewService.validateJgmc(orgnew);
		
		return SUCCESS;
	}
	
	
	public Orgnew getOrgnew() {
		return orgnew;
	}

	public void setOrgnew(Orgnew orgnew) {
		this.orgnew = orgnew;
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

	public void setOrgnewService(IOrgnewService orgnewService) {
		this.orgnewService = orgnewService;
	}
	
	public void setTjgdmService(ITjgdmService tjgdmService) {
		this.tjgdmService = tjgdmService;
	}
	
	public void setCodeDetailService(ICodeDetailService codeDetailService) {
		this.codeDetailService = codeDetailService;
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

	public String getJglxdm() {
		return jglxdm;
	}
	
	public void setJglxdm(String jglxdm) {
		this.jglxdm = jglxdm;
	}
	
	public String getJglxOld() {
		return jglxOld;
	}
	public void setJglxOld(String jglxOld) {
		this.jglxOld = jglxOld;
	}
	
	public String getJglxdmOld() {
		return jglxdmOld;
	}
	
	public void setJglxdmOld(String jglxdmOld) {
		this.jglxdmOld = jglxdmOld;
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
	public void setLrName(String lrName) {
		this.lrName = lrName;
	}
	public String getLrName() {
		return lrName;
	}
	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}
	public Date getLrDate() {
		return lrDate;
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
	public String getNjjhy() {
		return njjhy;
	}
	public void setNjjhy(String njjhy) {
		this.njjhy = njjhy;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTbrzjlx() {
		return tbrzjlx;
	}
	public void setTbrzjlx(String tbrzjlx) {
		this.tbrzjlx = tbrzjlx;
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
	
	public void setImageFlag(String imageFlag) {
		this.imageFlag = imageFlag;
	}
	public String getImageFlag() {
		return imageFlag;
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
	public void setJjlxOld(String jjlxOld) {
		this.jjlxOld = jjlxOld;
	}
	public String getJjlxOld() {
		return jjlxOld;
	}
	public void setJjlxdmOld(String jjlxdmOld) {
		this.jjlxdmOld = jjlxdmOld;
	}
	public String getJjlxdmOld() {
		return jjlxdmOld;
	}
	public void setMoveoutCenter(String moveoutCenter) {
		this.moveoutCenter = moveoutCenter;
	}
	public String getMoveoutCenter() {
		return moveoutCenter;
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
	public void setMoveoutBzjgdm(String moveoutBzjgdm) {
		this.moveoutBzjgdm = moveoutBzjgdm;
	}
	public String getMoveoutBzjgdm() {
		return moveoutBzjgdm;
	}
	
	public List getMsgCountList() {
		return msgCountList;
	}

	public void setMsgCountList(List msgCountList) {
		this.msgCountList = msgCountList;
	}
	
	public List getFieldList() {
		return fieldList;
	}
	public void setFieldList(List fieldList) {
		this.fieldList = fieldList;
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
	public String getQyjj() {
		return qyjj;
	}
	public void setQyjj(String qyjj) {
		this.qyjj = qyjj;
	}
	/*public String getDocid() {
		return docid;
	}
	public void setDocid(String docid) {
		this.docid = docid;
	}*/
}
