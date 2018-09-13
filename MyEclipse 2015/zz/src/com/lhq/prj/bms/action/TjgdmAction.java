package com.lhq.prj.bms.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lhq.prj.bms.core.BaseAction;
import com.lhq.prj.bms.core.MyUtils;
import com.lhq.prj.bms.core.Page;
import com.lhq.prj.bms.po.Tjgdm;
import com.lhq.prj.bms.service.ITjgdmService;



/** 
 * TjgdmAction.java Create on 2012-5-5 
 * 机构管理
 * Copyright (c) 2012 by YQ.
 * @author
 * @version 1.0
**/

@SuppressWarnings("serial")
public class TjgdmAction extends BaseAction {
	private ITjgdmService tjgdmService;

	private Tjgdm tjgdm;
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
	
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String jjhydm;
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
	private String hbzl;
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
	
	/**
	* 添加
	* @return
	*/
	public String saveTjgdm() {
		tjgdm = this.upload(tjgdm);
		orgid = (Integer) tjgdmService.saveTjgdm(tjgdm);
		if (orgid != null) {
			this.jsonString = "{orgid:" + orgid + ",success:true,imageUrl:'" + tjgdm.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}

	/**
	* 查找历史记录
	* @return
	*/
	public String findAllTjgdm() {
		String username = getRequest().getParameter("username");
		String strCondition = getRequest().getParameter("conditions");
		String strStateCondition= getRequest().getParameter("stateConditions");
		List conditions = new ArrayList();
		List stateConditions = new ArrayList();
		MyUtils.addToCollection(conditions, MyUtils.split(strCondition, " ,"));
		MyUtils.addToCollection(stateConditions, MyUtils.split(strStateCondition, " ,"));
		page = new Page();
		page.setStateConditions(stateConditions);
		page.setConditions(conditions);
		//page.setUsername(username);
		int start = Integer.valueOf(getRequest().getParameter("start"));
		int limit = Integer.valueOf(getRequest().getParameter("limit"));
		page.setStart(++start);
		page.setLimit(limit = limit == 0 ? 20 : limit);
		System.out.println("跟踪Page：：：：：：：：：："+page);
		page = tjgdmService.findByPage(page);
		return SUCCESS;
	}

	/**
	 * 删除图书
	 * 
	 * @return
	 */
	public String deleteTjgdm() {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			success = tjgdmService.deleteTjgdm(getSession().getServletContext().getRealPath("/"), Integer.valueOf(strOrgid));
		}
		return SUCCESS;
	}
	
	/**
	 * 修改信息
	 *
	 * @return
	 * @throws Exception
	 */
	public String updateTjgdm() throws Exception{
		Tjgdm tjgdm = new Tjgdm();
		
		tjgdm.setOrgid(orgid);
		tjgdm.setJgdm(jgdm);
		tjgdm.setJgmc(jgmc);
		tjgdm.setJglx(jglx);
		tjgdm.setZjlx(zjlx);
		tjgdm.setZjhm(zjhm);
		tjgdm.setJjhydm(jjhydm);
		tjgdm.setJyfw(jyfw);
		tjgdm.setJjlx(jjlx);
		tjgdm.setZcrq(zcrq);
		tjgdm.setZgdm(zgdm);
		tjgdm.setPzjgdm(pzjgdm);
		tjgdm.setXzqhCode(xzqhCode);
		tjgdm.setXzqhName(xzqhName);
		tjgdm.setJgdz(jgdz);
		tjgdm.setYzbm(yzbm);
		tjgdm.setDhhm(dhhm);
		tjgdm.setScbzrq(scbzrq);
		tjgdm.setBzrq(bzrq);
		tjgdm.setZfrq(zfrq);
		tjgdm.setBzjgdm(bzjgdm);
		tjgdm.setZycp1(zycp1);
		tjgdm.setZycp2(zycp2);
		tjgdm.setZycp3(zycp3);
		tjgdm.setZczj(zczj);
		tjgdm.setWftzgb(wftzgb);
		tjgdm.setHbzl(hbzl);
		tjgdm.setZgrs(zgrs);
		tjgdm.setFbsl(fbsl);
		tjgdm.setZslsh(zslsh);
		tjgdm.setBgbj(bgbj);
		tjgdm.setBgrq(bgrq);
		tjgdm.setLry(lry);
		tjgdm.setNjrq(njrq);
		tjgdm.setNjr(njr);
		tjgdm.setNjqx(njqx);
		tjgdm.setXgr(xgr);
		tjgdm.setZbsl(zbsl);
		tjgdm.setZch(zch);
		tjgdm.setQzbz(qzbz);
		tjgdm.setQzrq(qzrq);
		tjgdm.setZgmc(zgmc);
		tjgdm.setPzjgmc(pzjgmc);
		tjgdm.setGslsh(gslsh);
		tjgdm.setGstbr(gstbr);
		tjgdm.setWjwlsh(wjwlsh);
		tjgdm.setPzwh(pzwh);
		tjgdm.setPwrq(pwrq);
		tjgdm.setWjwtbr(wjwtbr);
		tjgdm.setGk(gk);
		tjgdm.setFkbz(fkbz);
		
		tjgdm.setFksl(fksl);
		tjgdm.setDybz(dybz);
		tjgdm.setEmail(email);
		tjgdm.setWeburl(weburl);
		tjgdm.setMobile(mobile);
		tjgdm.setDjblx(djblx);
		tjgdm.setLastdate(lastdate);
		tjgdm.setCzflag(czflag);
		tjgdm.setYjflag(yjflag);
		tjgdm.setSjzt(sjzt);
		tjgdm.setJyjg(jyjg);
		tjgdm.setFz(fz);
		tjgdm.setNjjhy(njjhy);
		tjgdm.setMemo(memo);
		tjgdm.setNjjlx(njjlx);
		tjgdm.setMemo2(memo2);
		tjgdm.setMemo3(memo3);
		tjgdm.setMemo4(memo4);
		tjgdm.setTbrxm(tbrxm);
		tjgdm.setTbrsfzh(tbrsfzh);
		tjgdm.setIsca(isca);
		tjgdm.setTbrlxfs(tbrlxfs);
		tjgdm.setGsfzrq(gsfzrq);
		tjgdm.setJydz(jydz);
		tjgdm.setJyyb(jyyb);
		tjgdm.setJydh(jydh);
		tjgdm.setJfly(jfly);
		tjgdm.setKhyh(khyh);
		tjgdm.setKhzh(khzh);
		tjgdm.setZsbfrq(zsbfrq);
		tjgdm.setZszfrq(zszfrq);
		tjgdm.setQyzclx(qyzclx);
		tjgdm.setYwlx(ywlx);
		tjgdm.setUserid(userid);
		tjgdm.setUsername(username);
		tjgdm.setState(state);
		
		tjgdm = this.upload(tjgdm);
		/*1.如果图书本来没有图片则不用删除原来图片
		 *2.如果原来有图片并且修改后的图片不一样则删除原来图片
		 */
		if(imageUrl != null && null != tjgdm.getImageUrl() && !imageUrl.equals(tjgdm.getImageUrl())){
			MyUtils.delFile(getSession().getServletContext().getRealPath("/")+ imageUrl);
		}
		if(upload != null && MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) && tjgdmService.updateTjgdm(tjgdm) ){
			this.jsonString = "{success:true,imageUrl:'" + tjgdm.getImageUrl() + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}else if(upload == null && tjgdmService.updateTjgdm(tjgdm)){
			this.jsonString = "{success:true,imageUrl:'" + imageUrl + "'}";
			getRequest().setAttribute("jsonString", jsonString);
			return SUCCESS;
		}
		this.jsonString = "{success:false,contentTypeIsValid:" + MyUtils.isValid(getUploadContentType(), getAllowedTypes().split(",")) + "}";
		getRequest().setAttribute("jsonString", jsonString);
		return INPUT;
	}
	
	private Tjgdm upload(Tjgdm tjgdm){
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
			tjgdm.setImageUrl(_imageUrl);
		}
		return tjgdm;
	}

	/**
	 * 提交申请
	 * 
	 * @return
	 * @throws Exception
	 */
	public String returnTjgdm() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdm(tjgdm);
		}
		return SUCCESS;
	}
	
	
	public String returnTjgdmOk() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdmOk(tjgdm);
		}
		return SUCCESS;
	}
	
	public String returnTjgdmNo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdmNo(tjgdm);
		}
		return SUCCESS;
	}
	
	public String returnTjgdmCode() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		
		String dmlx = "0";
		//getRequest().getParameter("orgid");
		String centerid ="100000";
		String jgmc="北京公司";
		String zch="1213232";
		String flag="0";
		
		

		if (strOrgid != null && !"".equals(strOrgid)) {
			/*通过接口取机构代码
			AutoAllocateCodeClientEncrypt encSig = new AutoAllocateCodeClientEncrypt();
			String result = encSig.applyCode(centerid, dmlx, jgmc, zch, flag);
			System.out.print(result);
			*/
			
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdmCode(tjgdm);
		}
		return SUCCESS;
	}
	
	public String returnTjgdmCreate() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdmCreate(tjgdm);
		}
		return SUCCESS;
	}
	
	
	public String returnTjgdmPrint() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdmPrint(tjgdm);
		}
		return SUCCESS;
	}
	
	public String returnTjgdmGo() throws Exception {
		String strOrgid = getRequest().getParameter("orgid");
		if (strOrgid != null && !"".equals(strOrgid)) {
			Tjgdm tjgdm = new Tjgdm();
			tjgdm.setOrgid(Integer.valueOf(strOrgid));
			success = tjgdmService.returnTjgdmGo(tjgdm);
		}
		return SUCCESS;
	}
	
	public Tjgdm getTjgdm() {
		return tjgdm;
	}

	public void setTjgdm(Tjgdm tjgdm) {
		this.tjgdm = tjgdm;
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

	public void setTjgdmService(ITjgdmService tjgdmService) {
		this.tjgdmService = tjgdmService;
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
	public String getJjhydm() {
		return jjhydm;
	}
	public void setJjhydm(String jjhydm) {
		this.jjhydm = jjhydm;
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
}
