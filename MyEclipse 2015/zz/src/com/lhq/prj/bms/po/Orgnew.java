package com.lhq.prj.bms.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Orgnew.java Create on 2012-5-14
 * 
 * 新办申请
 * 
 * Copyright (c) 2012 by YQ.
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Orgnew implements Serializable {

	private Integer orgid;
	private String docid;
	private String orderid;
	private String centerid;
	private String jgdm;
	private String jgmc;
	private String jglx;
	private String jglxdm;
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
	private String xzqhCode2;
	private String xzqhName2;
	private String jgdz;private String jgzcdz;
	private String yzbm;
	private String dhhm;
	private Date scbzrq;
	private Date bzrq;
	private Date zfrq;
	private String bzjgdm;
	private String zycp1;
	private String zycp2;
	private String zycp3;
	private BigDecimal zczj;
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
	private String isxw;////
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
	private String tbrzjlx;
	private String jjhymc;
	private String jjhydm;
	
	private String jjlxOld;
	private String jjlxdmOld;
	private String jjhymcOld;
	private String jjhydmOld;
	private String jglxOld;
	private String jglxdmOld;
	
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
	
	private String name;
	private String handleName;
	private String handleDate;
	private String handleNote;
	private String auditUserid;
	private String auditUsername;
	private String auditName;
	private Date auditDate;
	private String auditNote;	
	private String state;
	
	private String imageData;
	private String pageTypeStr;
	private String packindex;
	
	private String moveoutAddrss;
	private String moveoutReason;
	private String moveoutNote;
	private String offPzjgmc;
	private String offPzwh;
	private String offReason;
	private String offNote;
	
	
	

	
	/** 当前关联的借阅记录id */
	//private Integer logId;


	public Orgnew() {
	}
	
	public Orgnew(Integer orgid) {
		this.orgid = orgid;
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
	public BigDecimal getZczj() {
		return zczj;
	}
	public void setZczj(BigDecimal zczj) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	
	public String getPageTypeStr() {
		return pageTypeStr;
	}
	public void setPageTypeStr(String pageTypeStr) {
		this.pageTypeStr = pageTypeStr;
	}

	public String getPackindex() {
		return packindex;
	}
	public void setPackindex(String packindex) {
		this.packindex = packindex;
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

	public void setCenterid(String centerid) {
		this.centerid = centerid;
	}

	public String getCenterid() {
		return centerid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOrderid() {
		return orderid;
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

	public void setJjhymc(String jjhymc) {
		this.jjhymc = jjhymc;
	}

	public String getJjhymc() {
		return jjhymc;
	}

	public void setJjhydm(String jjhydm) {
		this.jjhydm = jjhydm;
	}

	public String getJjhydm() {
		return jjhydm;
	}

	public String getJgzcdz() {
		return jgzcdz;
	}

	public void setJgzcdz(String jgzcdz) {
		this.jgzcdz = jgzcdz;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getTbrzjlx() {
		return tbrzjlx;
	}

	public void setTbrzjlx(String tbrzjlx) {
		this.tbrzjlx = tbrzjlx;
	}

	public String getJglxdm() {
		return jglxdm;
	}

	public void setJglxdm(String jglxdm) {
		this.jglxdm = jglxdm;
	}

	public String getJjlxOld() {
		return jjlxOld;
	}

	public void setJjlxOld(String jjlxOld) {
		this.jjlxOld = jjlxOld;
	}

	public String getJjlxdmOld() {
		return jjlxdmOld;
	}

	public void setJjlxdmOld(String jjlxdmOld) {
		this.jjlxdmOld = jjlxdmOld;
	}

	public String getJjhymcOld() {
		return jjhymcOld;
	}

	public void setJjhymcOld(String jjhymcOld) {
		this.jjhymcOld = jjhymcOld;
	}

	public String getJjhydmOld() {
		return jjhydmOld;
	}

	public void setJjhydmOld(String jjhydmOld) {
		this.jjhydmOld = jjhydmOld;
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

	public String getIsxw() {
		return isxw;
	}

	public void setIsxw(String isxw) {
		this.isxw = isxw;
	}

	public String getAuditUserid() {
		return auditUserid;
	}

	public void setAuditUserid(String auditUserid) {
		this.auditUserid = auditUserid;
	}

	public String getAuditUsername() {
		return auditUsername;
	}

	public void setAuditUsername(String auditUsername) {
		this.auditUsername = auditUsername;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditNote() {
		return auditNote;
	}

	public void setAuditNote(String auditNote) {
		this.auditNote = auditNote;
	}

	@Override
	public String toString() {
		return "Orgnew [orgid=" + orgid + ", docid=" + docid + ", orderid="
				+ orderid + ", centerid=" + centerid + ", jgdm=" + jgdm
				+ ", jgmc=" + jgmc + ", jglx=" + jglx + ", jglxdm=" + jglxdm
				+ ", fddbr=" + fddbr + ", zjlx=" + zjlx + ", zjhm=" + zjhm
				+ ", jjlxdm=" + jjlxdm + ", jyfw=" + jyfw + ", jjlx=" + jjlx
				+ ", zcrq=" + zcrq + ", zgdm=" + zgdm + ", pzjgdm=" + pzjgdm
				+ ", xzqhCode=" + xzqhCode + ", xzqhName=" + xzqhName
				+ ", xzqhCode2=" + xzqhCode2 + ", xzqhName2=" + xzqhName2
				+ ", jgdz=" + jgdz + ", jgzcdz=" + jgzcdz + ", yzbm=" + yzbm
				+ ", dhhm=" + dhhm + ", scbzrq=" + scbzrq + ", bzrq=" + bzrq
				+ ", zfrq=" + zfrq + ", bzjgdm=" + bzjgdm + ", zycp1=" + zycp1
				+ ", zycp2=" + zycp2 + ", zycp3=" + zycp3 + ", zczj=" + zczj
				+ ", wftzgb=" + wftzgb + ", wftzgbdm=" + wftzgbdm + ", hbzl="
				+ hbzl + ", hbzldm=" + hbzldm + ", zgrs=" + zgrs + ", fbsl="
				+ fbsl + ", zslsh=" + zslsh + ", bgbj=" + bgbj + ", bgrq="
				+ bgrq + ", lry=" + lry + ", njrq=" + njrq + ", njr=" + njr
				+ ", njqx=" + njqx + ", xgr=" + xgr + ", zbsl=" + zbsl
				+ ", zch=" + zch + ", qzbz=" + qzbz + ", qzrq=" + qzrq
				+ ", zgmc=" + zgmc + ", pzjgmc=" + pzjgmc + ", gslsh=" + gslsh
				+ ", gstbr=" + gstbr + ", wjwlsh=" + wjwlsh + ", pzwh=" + pzwh
				+ ", pwrq=" + pwrq + ", wjwtbr=" + wjwtbr + ", gk=" + gk
				+ ", fkbz=" + fkbz + ", fksl=" + fksl + ", dybz=" + dybz
				+ ", isxw=" + isxw + ", email=" + email + ", weburl=" + weburl
				+ ", mobile=" + mobile + ", djblx=" + djblx + ", lastdate="
				+ lastdate + ", czflag=" + czflag + ", yjflag=" + yjflag
				+ ", sjzt=" + sjzt + ", jyjg=" + jyjg + ", fz=" + fz
				+ ", njjhy=" + njjhy + ", memo=" + memo + ", njjlx=" + njjlx
				+ ", memo2=" + memo2 + ", memo3=" + memo3 + ", memo4=" + memo4
				+ ", tbrxm=" + tbrxm + ", tbrzjlx=" + tbrzjlx + ", jjhymc="
				+ jjhymc + ", jjhydm=" + jjhydm + ", jjlxOld=" + jjlxOld
				+ ", jjlxdmOld=" + jjlxdmOld + ", jjhymcOld=" + jjhymcOld
				+ ", jjhydmOld=" + jjhydmOld + ", jglxOld=" + jglxOld
				+ ", jglxdmOld=" + jglxdmOld + ", tbrsfzh=" + tbrsfzh
				+ ", isca=" + isca + ", tbrlxfs=" + tbrlxfs + ", gsfzrq="
				+ gsfzrq + ", jydz=" + jydz + ", jyyb=" + jyyb + ", jydh="
				+ jydh + ", jfly=" + jfly + ", khyh=" + khyh + ", khzh=" + khzh
				+ ", zsbfrq=" + zsbfrq + ", zszfrq=" + zszfrq + ", qyzclx="
				+ qyzclx + ", ywlx=" + ywlx + ", userid=" + userid
				+ ", imageUrl=" + imageUrl + ", username=" + username
				+ ", name=" + name + ", auditUserid=" + auditUserid
				+ ", auditUsername=" + auditUsername + ", auditName="
				+ auditName + ", auditDate=" + auditDate + ", auditNote="
				+ auditNote + ", state=" + state + ", imageData=" + imageData
				+ ", pageTypeStr=" + pageTypeStr + ", packindex=" + packindex
				+ ", moveoutAddrss=" + moveoutAddrss + ", moveoutReason="
				+ moveoutReason + ", moveoutNote=" + moveoutNote
				+ ", offPzjgmc=" + offPzjgmc + ", offPzwh=" + offPzwh
				+ ", offReason=" + offReason + ", offNote=" + offNote + "]";
	}

	public String getHandleName() {
		return handleName;
	}

	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}

	public String getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(String handleDate) {
		this.handleDate = handleDate;
	}

	public String getHandleNote() {
		return handleNote;
	}

	public void setHandleNote(String handleNote) {
		this.handleNote = handleNote;
	}

	public Date getLrDate() {
		return lrDate;
	}

	public void setLrDate(Date lrDate) {
		this.lrDate = lrDate;
	}

}
