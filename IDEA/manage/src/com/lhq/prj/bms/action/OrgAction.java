package com.lhq.prj.bms.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.lhq.prj.bms.core.MyUtils;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Org;
import com.lhq.prj.bms.po.User;
import com.lhq.prj.bms.po.Pzjg;
import com.lhq.prj.bms.po.Zuser;
import com.lhq.prj.bms.service.IOrgService;
import com.lhq.prj.bms.service.impl.AutoAllocateCodeClientEncrypt;


/**
 * OrgAction.java Create on 2012-5-5
 * 机构管理
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
**/

@SuppressWarnings("serial")
public class OrgAction extends BaseAction {
	private IOrgService orgService;
	private Map<String, String> dataMap;

	private Org org;
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
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String jglxdm;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jjlxdm;
	private String jjhydm;
	private String jjhymc;
	private String jyfw;
	private String jjlx;
	private Date zcrq;
	private String zgdm;
	private String pzjgdm;
	private String xzqhCode;
	private String xzqhName;
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
	private Integer zczj;
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
	private String njjhy;
	private String memo;
	private String njjlx;
	private String memo2;
	private String memo3;
	private String memo4;
	private String tbrxm;
	private String tbrsfzh;
	private String isca;
	private String tbrlxfs;
	private Date gsfzrq;
	private String jydz;
	private String jyyb;
	private String jydh;
	private String jfly;
	private String khyh;
	private String khzh;
	private Date zsbfrq;
	private Date zszfrq;
	private String qyzclx;
	private String ywlx;
	private Integer userid;
	private String pageTypeStr;
	private String imageUrl;
	private String username;
	private String state;
	
	
	public OrgAction() {
		//初始化Map对象
		dataMap = new HashMap<String, String>();
	}
	/**
	* 添加
	* @return
	*/
	public String saveOrg() {
		org = this.upload(org);
		orgid = (Integer) orgService.saveOrg(org);
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",success:true,imageUrl:'" + org.getImageUrl() + "'}";
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
	public String findAllOrg() {
		//int categoryid = Integer.valueOf(getRequest().getParameter("categoryid"));
		String username = getRequest().getParameter("username");
		//int userid = Integer.valueOf(getRequest().getParameter("userid"));
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		//System.out.println("*****************************************"+strStateCondition+"****"+username);
		
		User user = (User) getSession().getAttribute("user");
		String bzjgdm=user.getBzjgCode();
		String userName=user.getUserName();
		
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setBzjgdm(bzjgdm);
		page.setUsername(userName);
		page.setStateConditions(stateConditions);
		page.setConditions(conditions);
		page.setUsername(username);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String deleteOrg() {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			success = orgService.deleteOrg(getSession().getServletContext().getRealPath("/"), Integer.valueOf(strOrgid));
		}
		return SUCCESS;
	}
	
	/**
	 * 修改信息
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateOrg() throws Exception{
		
		String newPageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		Org org = new Org();
		org.setOrgid(orgid);
		org.setOrderid(orderid);
		org.setJgdm(jgdm);
		org.setJgmc(jgmc);
		org.setJglx(jglx);
		org.setJglxdm(jglxdm);
		
		org.setZjlx(zjlx);
		org.setZjhm(zjhm);
		org.setJjlxdm(jjlxdm);
		org.setJjhydm(jjhydm);
		org.setJjhymc(jjhymc);
		org.setJyfw(jyfw);
		org.setJjlx(jjlx);
		org.setZcrq(zcrq);
		org.setZgdm(zgdm);
		org.setPzjgdm(pzjgdm);
		org.setXzqhCode(xzqhCode);
		org.setXzqhName(xzqhName);
		org.setJgdz(jgdz);
		org.setYzbm(yzbm);
		org.setDhhm(dhhm);
		org.setScbzrq(scbzrq);
		org.setBzrq(bzrq);
		org.setZfrq(zfrq);
		org.setBzjgdm(bzjgdm);
		org.setZycp1(zycp1);
		org.setZycp2(zycp2);
		org.setZycp3(zycp3);
		org.setZczj(zczj);
		org.setWftzgb(wftzgb);
		org.setHbzl(hbzl);
		org.setZgrs(zgrs);
		org.setFbsl(fbsl);
		org.setZslsh(zslsh);
		org.setBgbj(bgbj);
		org.setBgrq(bgrq);
		org.setLry(lry);
		org.setNjrq(njrq);
		org.setNjr(njr);
		org.setNjqx(njqx);
		org.setXgr(xgr);
		org.setZbsl(zbsl);
		org.setZch(zch);
		org.setQzbz(qzbz);
		org.setQzrq(qzrq);
		org.setZgmc(zgmc);
		org.setPzjgmc(pzjgmc);
		org.setGslsh(gslsh);
		org.setGstbr(gstbr);
		org.setWjwlsh(wjwlsh);
		org.setPzwh(pzwh);
		org.setPwrq(pwrq);
		org.setWjwtbr(wjwtbr);
		org.setGk(gk);
		org.setFkbz(fkbz);
		
		org.setFksl(fksl);
		org.setDybz(dybz);
		org.setEmail(email);
		org.setWeburl(weburl);
		org.setMobile(mobile);
		org.setDjblx(djblx);
		org.setLastdate(lastdate);
		org.setCzflag(czflag);
		org.setYjflag(yjflag);
		org.setSjzt(sjzt);
		org.setJyjg(jyjg);
		org.setFz(fz);
		org.setNjjhy(njjhy);
		org.setMemo(memo);
		org.setNjjlx(njjlx);
		org.setMemo2(memo2);
		org.setMemo3(memo3);
		org.setMemo4(memo4);
		org.setTbrxm(tbrxm);
		org.setTbrsfzh(tbrsfzh);
		org.setIsca(isca);
		org.setTbrlxfs(tbrlxfs);
		org.setGsfzrq(gsfzrq);
		
		
		if(newPageTypeStr==""||"".equals(newPageTypeStr)){
			
		}else{
			newPageTypeStr=str_replace(newPageTypeStr,"|","%");  //转换“PageType”中的字符串%为“|”
			org.setPageTypeStr(newPageTypeStr);
		}
		
		org.setJydz(jydz);
		org.setJyyb(jyyb);
		org.setJydh(jydh);
		org.setJfly(jfly);
		org.setKhyh(khyh);
		org.setKhzh(khzh);
		org.setZsbfrq(zsbfrq);
		org.setZszfrq(zszfrq);
		org.setQyzclx(qyzclx);
		org.setYwlx(ywlx);
		org.setUserid(userid);
		org.setUsername(username);
		org.setState(state);
		
		org = this.upload(org);
		/*1.如果图书本来没有图片则不用删除原来图片
		 *2.如果原来有图片并且修改后的图片不一样则删除原来图片
		 */
		if(imageUrl != null && null != org.getImageUrl() && !imageUrl.equals(org.getImageUrl())){
			MyUtils.delFile(getSession().getServletContext().getRealPath("/")+ imageUrl);
		}
		if(upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) && orgService.updateOrg(org) ){
			this.jsonString = "{success:true,imageUrl:'" + org.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}else if(upload == null && orgService.updateOrg(org)){
			this.jsonString = "{success:true,imageUrl:'" + imageUrl + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	private Org upload(Org org){
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
			org.setImageUrl(_imageUrl);
		}
		return org;
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
	 * 上传扫描数据到服务器上
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveImageOrg() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");   //单个机构编码的ID
		String imageData=getRequest().getParameter("imageData"); //单个数据包内容 
		String packindex=getRequest().getParameter("packindex");  //为数据包编码
		String pageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		if(pageTypeStr!=""){
			pageTypeStr=str_replace(pageTypeStr,"|","%");  //转换“PageType”中的字符串%为“|”
		}
        System.out.println("-----------------------------"+pageTypeStr);
		String lastpack=getRequest().getParameter("lastpack");  //true为最后一个包
		if (strOrgid != null && !"".equals(strOrgid)) {
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			org.setImageData(imageData);
			org.setPageTypeStr(pageTypeStr);
			org.setPackindex(packindex);
			success = orgService.saveImageOrg(org);
		}
		return SUCCESS;
	}

	
	/**
	 * 提交申请
	 * 
	 * @return
	 * @throws Exception
	 */
	public String returnOrg() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			success = orgService.returnOrg(org);
		}
		return SUCCESS;
	}
	
	
	
	
	public String returnOrgOk() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		String strHandlenote = getRequest().getParameter("handle_note");
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Org org = new Org();
			org.setHandle_userid(String.valueOf(user.getUserId()));
			org.setHandle_username(user.getUserName());
			org.setHandle_name(user.getEmplName());
			org.setUserid(user.getUserId());
			org.setOrgid(Integer.valueOf(strOrgid));
			org.setHandle_note(strHandlenote);
			success = orgService.returnOrgOk(org);
		}
		return SUCCESS;
	}
	
	public String returnOrgNo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		String strHandlenote = getRequest().getParameter("handle_note");
		
		if (strOrgid != null && !"".equals(strOrgid)) {
			User user = (User) getSession().getAttribute("user");
			Org org = new Org();
			org.setHandle_userid(String.valueOf(user.getUserId()));
			org.setHandle_username(user.getUserName());
			org.setHandle_name(user.getEmplName());
			org.setUserid(user.getUserId());
			org.setOrgid(Integer.valueOf(strOrgid));
			org.setHandle_note(strHandlenote);
			success = orgService.returnOrgNo(org);
		}
		return SUCCESS;
	}
	
	public String returnOrgCode() throws Exception {

		//Org org = new Org();
		String strOrgid = getRequest().getParameter("orgid");
		
		String strCenterid= getRequest().getParameter("centerid");
		String strJgmc = getRequest().getParameter("jgmc");
		String strDmlx = getRequest().getParameter("dmlx");
		String strZch = getRequest().getParameter("zch");
		String flag="0";

		System.out.println("+++++++|"+strCenterid+"|+++++++|"+strOrgid+"|-------|"+strDmlx+"|-------|"+strZch+"|+++++++++++");
		//String strDmlx = "0";   //0 个体，1非个体
		//String centerid ="100000";
		//String strOrgid="北京公司";
		//String strZch="1213232";
		
		
		if (strOrgid != null && !"".equals(strOrgid)) {
			//通过接口取机构代码
			try{
				AutoAllocateCodeClientEncrypt encSig = new AutoAllocateCodeClientEncrypt();
				String resultCode = encSig.applyCode(strCenterid, strDmlx, strJgmc, strZch, flag);  //1成功，2已赋码，3确定失败，4疑似已赋码（返回多个码用冒号确认），5不给赋码，6无代码
				System.out.print("-------------------------代码库中取得代码"+resultCode+"------------------------------");
				//String  resultCode="L26136128_北京公司_1213232_1";
				if(!MyUtils.isContainsAny(resultCode, "异常")){
					
					String a[]=MyUtils.split(resultCode, ":");
					List root=new ArrayList();
					if(a.length>0 && (a[a.length-1]=="4" || "4".equals(a[a.length-1]) )){//即判断是否为4疑似已赋码 ，例L26136128_北京公司_1213232：L26136129_小北京公司_12132322：4
						for(int i=0;i<a.length-1;i++){  //刨去4
							//codeList.add(a[i]);
							String b[]=MyUtils.split(a[i], "_");
							if(b.length==3){
								Map<String,String> dataMap = new HashMap<String,String>();
								dataMap.put("jgdm",b[0]);
								dataMap.put("jgmc",b[1]);
								dataMap.put("flag","4");
								root.add(dataMap);
							}else{
								System.out.println("取码错误");
							}
						}
					}else{ //不是4疑似已赋码 ，例L26136128_北京公司_1213232_1 ,或 L26136129_北京公司_12132322_3, 或 L26136129_北京公司_12132322_2,或 L26136129_北京公司_12132322_5
						String b[]=MyUtils.split(resultCode, "_");
						if(b.length==4){
							if(b[3]=="1" || "1".equals(b[3]) || b[3]=="3" || "3".equals(b[3])){
								Map<String,String> dataMap = new HashMap<String,String>();
								dataMap.put("jgdm",b[0]);
								dataMap.put("jgmc",b[1]);
								dataMap.put("flag",b[3]);
								root.add(dataMap);
								
								//格式化json语句判断语句的格式，是否正确
								//    String str = "｛userinfo:[\"userInfo.name\":\"张三\",\"userId\":\"1\"]｝";
							    //    JSONObject jsonObject = new JSONObject();
							    //    jsonObject.put("userInfo", dataMap);
							    //    System.out.println(jsonObject);
							    //    JSONObject obj = new JSONObject(str);
							    //    System.out.println(obj);
							}else{
								System.out.println("不能赋码");
								return SUCCESS;
							}
						}else{
							System.out.println("取码错误");
							return SUCCESS;
						}
					}
					
					//AutoAllocateCodeClientEncrypt encSig = new AutoAllocateCodeClientEncrypt();
					//encSig.successConfirm(centerid, jgmc, zch,strCode);
					//System.out.print("-------------------------保存成功过后，给代码库返回成功的方法------------------------------");
					// 返回值page	
					page = new Page();
					page.setSuccess(success);
					page.setRoot(root);	
					return SUCCESS;
				}else{
					return SUCCESS;
				}				
			}catch(Exception e){
				e.printStackTrace();
				
			}
			return SUCCESS;
			//Org org = new Org();
			//org.setOrgid(Integer.valueOf(strOrgid));
			//success = orgService.returnOrgCode(org);
		}
		return SUCCESS;
	}
	
	
	//审核建档
	public String returnOrgCreate() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			success = orgService.returnOrgCreate(org);
		}
		return SUCCESS;
	}
	
	
//	page = new Page();
//	page.setStateConditions(stateConditions);
//	page.setConditions(conditions);
//	page.setUsername(username);
//	int start = Integer.valueOf(getRequest().getParameter("start"));
//	int limit = Integer.valueOf(getRequest().getParameter("limit"));
//	page.setStart(++start);
//	page.setLimit(limit = limit == 0 ? 20 : limit);
//	page = orgService.findByPage(page);
//	return SUCCESS;
	
	/**
	* 单个加载原文
	* @return
	*/
	public String orgViewImg() {
		Integer orgid =  Integer.valueOf(getRequest().getParameter("orgid"));
		
		page = new Page();
		page.setRoot(orgService.orgViewImg(orgid));
		return SUCCESS;
	}	
	
	public String returnOrgPrint() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			success = orgService.returnOrgPrint(org);
		}
		return SUCCESS;
	}
	
	public String returnOrgDo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		String strJgdm = getRequest().getParameter("jgdm");
		String strState = getRequest().getParameter("state");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			org.setJgdm(strJgdm);
			org.setState(strState);
			
			User user = (User) getSession().getAttribute("user");
			org.setHandle_userid(String.valueOf(user.getUserId()));
			org.setHandle_username(user.getUserName());
			org.setHandle_name(user.getEmplName());
			org.setHandle_date(new Date());
			
			success = orgService.returnOrgDo(org);
		}
		return SUCCESS;
	}
	
	
	public String returnOrgGo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			success = orgService.returnOrgGo(org);
		}
		return SUCCESS;
	}
	
	
	
	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
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

	public void setOrgService(IOrgService orgService) {
		this.orgService = orgService;
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
	public Integer getZczj() {
		return zczj;
	}
	public void setZczj(Integer zczj) {
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
}
