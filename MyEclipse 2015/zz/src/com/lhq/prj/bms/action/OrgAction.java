package com.lhq.prj.bms.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.CreateKey;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Org;
import com.lhq.prj.bms.service.IOrgService;


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
	private Map<String, Object> dataMap;
	
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
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jjlxdm;
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
	private String imageUrl;
	private String username;
	private String state;
	private String newState;
	private String newYwlx;

	
	public OrgAction() {
		//初始化Map对象
		dataMap = new HashMap<String, Object>();
	}
	/**
	* 添加
	* @return
	 * @throws Exception 
	*/
	public String saveOrg() throws Exception {
		org = this.upload(org);
		orgid = (Integer) orgService.saveOrg(org);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++="+orgid);
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",success:true,imageUrl:'" + org.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	

	 // 测试通过action以Struts2默认方式返回JSON数据
	 //@return
	/* 
	public String testByAction() {
		// dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据
		dataMap.clear();
		User user = new User();
		user.setId("123");
		user.setName("JSONActionStruts2");
		user.setPassword("123");
		user.setSay("Hello world !");
		dataMap.put("user", user);
		// 放入一个是否操作成功的标识
		dataMap.put("success", true);
		// 返回结果
		return SUCCESS;
	}
*/
	
	
	/**
	* 查找新办用户所属机构
	* @return
	*/
	public String findUsernameOrg() {
		
		String username = getRequest().getParameter("username");
		String strStateCondition = getRequest().getParameter("stateConditions");
		
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setUsername(username);
		page.setStateConditions(stateConditions);
		
		//orgService.findUsernameOrg(page);
		
		
		page.setRoot(orgService.findUsernameOrg(page));
		
		return SUCCESS;
	}

	/**
	* 加载ORGID所属机构
	* @return
	*/
	public String findOrgidOrg() {
		
		Integer orgid = Integer.valueOf(getRequest().getParameter("orgid"));		
		page = new Page();
		page.setRoot(orgService.findOrgidOrg(orgid));
		return SUCCESS;
	}
	
	
	/**
	* 查找全部机构
	* @return
	*/
	public String findAllOrg() {
		//int categoryid = Integer.valueOf(getRequest().getParameter("categoryid"));
		String username = getRequest().getParameter("username");
		//int userid = Integer.valueOf(getRequest().getParameter("userid"));
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setConditions(conditions);
		page.setUsername(username);
		page.setStateConditions(stateConditions);
		//page.setState(state);
		//page.setUserid(userid);
		//yangqi
		//System.out.println(strCondition);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		page = orgService.findByPage(page);
		return SUCCESS;
	}
	

	/**
	 * 删除图书
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
		
		String newXzqhName = getRequest().getParameter("_xzqhName");
		String newXzqhCode = getRequest().getParameter("_xzqhCode");
		String newHbzl = getRequest().getParameter("_hbzl");
		String newHbzldm = getRequest().getParameter("_hbzldm");
		String newWftzgb = getRequest().getParameter("_wftzgb");
		String newWftzgbdm = getRequest().getParameter("_wftzgbdm");
		String strOrderid = getRequest().getParameter("orderid");
		String newState = String.valueOf(getRequest().getParameter("newState"));
		String newYwlx = String.valueOf(getRequest().getParameter("newYwlx"));
		
		
		Org org = new Org();
		
		org.setOrgid(orgid);
		org.setOrderid(strOrderid);
		org.setJgdm(jgdm);
		org.setJgmc(jgmc);
		org.setJglx(jglx);
		org.setZjlx(zjlx);
		org.setZjhm(zjhm);
		org.setFddbr(fddbr);
		org.setJjlxdm(jjlxdm);
		org.setJyfw(jyfw);
		org.setJjlx(jjlx);
		org.setZcrq(zcrq);
		org.setZgdm(zgdm);
		org.setPzjgdm(pzjgdm);
		if (newXzqhCode == "" || "".equals(newXzqhCode)){
			org.setXzqhCode(null);
		}else{
			org.setXzqhCode(newXzqhCode);
		}
		if (newXzqhName == "" || "".equals(newXzqhName)){
			org.setXzqhName(null);
		}else{
			org.setXzqhName(newXzqhName);
		}
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
		if (newWftzgb == "" || "".equals(newWftzgb)){
			org.setWftzgb(null);
		}else{
			org.setWftzgb(newWftzgb);
		}
		if (newWftzgbdm == "" || "".equals(newWftzgbdm)){
			org.setWftzgbdm(null);
		}else{
			org.setWftzgbdm(newWftzgbdm);
		}
		if (newHbzl == "" || "".equals(newHbzl)){
			org.setHbzl(null);
		}else{
			org.setHbzl(newHbzl);
		}
		if (newHbzldm == "" || "".equals(newHbzldm)){
			org.setHbzldm(null);
		}else{
			org.setHbzldm(newHbzldm);
		}
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
		org.setPzjgdm(pzjgdm);
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
		org.setJydz(jydz);
		org.setJyyb(jyyb);
		org.setJydh(jydh);
		org.setJfly(jfly);
		org.setKhyh(khyh);
		org.setKhzh(khzh);
		org.setZsbfrq(zsbfrq);
		org.setZszfrq(zszfrq);
		org.setQyzclx(qyzclx);
		org.setYwlx(newYwlx);
		org.setUserid(userid);
		org.setUsername(username);
		org.setState(newState);
		
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
	
	
	
	
	private Org upload(Org org){  //上传文件到指定文件夹中
		String _imageUrl = null;
		if (upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(","))) {
			String rootPath = getSession().getServletContext().getRealPath("/");
			String savePath = rootPath + getSavePath();
			MyUtils.mkDirectory(savePath); //建立文件夹
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
	 * 上传扫描数据到数据库中
	 * 
	 * @return
	 * @throws Exception
	 */
	public String saveImageOrg() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");   //单个机构编码的ID
		String imageData=getRequest().getParameter("imageData"); //单个数据包内容
		String packindex=getRequest().getParameter("packindex");  //为数据包编码
		String pageTypeStr=getRequest().getParameter("pageTypeStr");  //为图片类型标识
		System.out.println("-----------------------------------------------"+pageTypeStr);
		if(pageTypeStr!=""){
			pageTypeStr=str_replace(pageTypeStr,"|","%"); 
		}

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
			//此处处理年检时候的状态
			Org org = new Org();
			org.setOrgid(Integer.valueOf(strOrgid));
			success = orgService.returnOrg(org);
		}
		return SUCCESS;
	}
	
	/**
	* 单个加载原文
	* @return
	*/
	public String orgViewImg() {
		Integer orgid =  Integer.valueOf(getRequest().getParameter("orgid"));
		String strStateCondition = getRequest().getParameter("stateConditions");
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		
		page = new Page();
		page.setOrgid(orgid);
		page.setStateConditions(stateConditions);
		page.setRoot(orgService.orgViewImg(page));
		return SUCCESS;
	}	
	
	
	
	
	//page = new Page();
	
	
	//orgService.findUsernameOrg(page);
	
	
	//page.setRoot(orgService.findUsernameOrg(page));

	
	public void createKey(){	
		CreateKey createKey = new CreateKey();
		try {
			System.out.println(createKey.executeProcdure("z_MakePrimaryKey", "my_table"));
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
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
		this.zycp2 = zycp2;
	}
	public String getZycp3() {
		return zycp3;
	}
	public void setZycp3(String zycp3) {
		this.zycp3 = zycp3;
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
	
	public Map<String, Object> getDataMap() {
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
	public void setNewYwlx(String newYwlx) {
		this.newYwlx = newYwlx;
	}
	public String getNewYwlx() {
		return newYwlx;
	}
	public void setNewState(String newState) {
		this.newState = newState;
	}
	public String getNewState() {
		return newState;
	}
}
