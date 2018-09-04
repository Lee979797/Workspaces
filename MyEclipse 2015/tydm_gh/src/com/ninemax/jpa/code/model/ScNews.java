package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ScNews entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SC_NEWS")
public class ScNews implements java.io.Serializable {

	// Fields

	private String id;
	private String title;
	private String addtime;
	private String modifytime;
	private String status;
	private String lastoper;
	private String userid;
	private String pictrue;
	private String oper;
	private String summary;
	private String haspictrue;
	private String kind;
	private String webId;
	private String channelId;
	private String childKind;
	private String isfirst;
	private String allowremark;
	private String uploadfiles;
	private String visitTimes;
	private String leftTemplate;
	private String tags;
	private String ly;
	private String titlecolor;
	private String news;
	private String deputyTitle;
	private String linkTitle;
	private String pubDate;
	private String pubCompany;
	private String deputyTitleDsp;
	private String operDsp;
	private String tagsDsp;
	private String pubCompanyDsp;
	private String summaryDsp;
	private String lyDsp;
	private String author;
	private String publisher;
	private String keywords;
	private String subtitle;
	private String sno;
	private String isindex;
	private String getfromid;
	private String isfocus;
	private String focusorderby;
	private String videopath;
	private String videoTitle;
	private String ishead;
	private String dspTitle;
	private String asdf;
	private String fromcjtype;
	private String content;

	// Constructors

	/** default constructor */
	public ScNews() {
	}

	/** minimal constructor */
	public ScNews(String id) {
		this.id = id;
	}

	/** full constructor */
	public ScNews(String id, String title, String addtime, String modifytime,
			String status, String lastoper, String userid, String pictrue,
			String oper, String summary, String haspictrue, String kind,
			String webId, String channelId, String childKind, String isfirst,
			String allowremark, String uploadfiles, String visitTimes,
			String leftTemplate, String tags, String ly, String titlecolor,
			String news, String deputyTitle, String linkTitle, String pubDate,
			String pubCompany, String deputyTitleDsp, String operDsp,
			String tagsDsp, String pubCompanyDsp, String summaryDsp,
			String lyDsp, String author, String publisher, String keywords,
			String subtitle, String sno, String isindex, String getfromid,
			String isfocus, String focusorderby, String videopath,
			String videoTitle, String ishead, String dspTitle, String asdf,
			String fromcjtype, String content) {
		this.id = id;
		this.title = title;
		this.addtime = addtime;
		this.modifytime = modifytime;
		this.status = status;
		this.lastoper = lastoper;
		this.userid = userid;
		this.pictrue = pictrue;
		this.oper = oper;
		this.summary = summary;
		this.haspictrue = haspictrue;
		this.kind = kind;
		this.webId = webId;
		this.channelId = channelId;
		this.childKind = childKind;
		this.isfirst = isfirst;
		this.allowremark = allowremark;
		this.uploadfiles = uploadfiles;
		this.visitTimes = visitTimes;
		this.leftTemplate = leftTemplate;
		this.tags = tags;
		this.ly = ly;
		this.titlecolor = titlecolor;
		this.news = news;
		this.deputyTitle = deputyTitle;
		this.linkTitle = linkTitle;
		this.pubDate = pubDate;
		this.pubCompany = pubCompany;
		this.deputyTitleDsp = deputyTitleDsp;
		this.operDsp = operDsp;
		this.tagsDsp = tagsDsp;
		this.pubCompanyDsp = pubCompanyDsp;
		this.summaryDsp = summaryDsp;
		this.lyDsp = lyDsp;
		this.author = author;
		this.publisher = publisher;
		this.keywords = keywords;
		this.subtitle = subtitle;
		this.sno = sno;
		this.isindex = isindex;
		this.getfromid = getfromid;
		this.isfocus = isfocus;
		this.focusorderby = focusorderby;
		this.videopath = videopath;
		this.videoTitle = videoTitle;
		this.ishead = ishead;
		this.dspTitle = dspTitle;
		this.asdf = asdf;
		this.fromcjtype = fromcjtype;
		this.content = content;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "TITLE", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "ADDTIME", length = 20)
	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	@Column(name = "MODIFYTIME", length = 20)
	public String getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	@Column(name = "STATUS", length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "LASTOPER", length = 50)
	public String getLastoper() {
		return this.lastoper;
	}

	public void setLastoper(String lastoper) {
		this.lastoper = lastoper;
	}

	@Column(name = "USERID", length = 8)
	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Column(name = "PICTRUE", length = 1000)
	public String getPictrue() {
		return this.pictrue;
	}

	public void setPictrue(String pictrue) {
		this.pictrue = pictrue;
	}

	@Column(name = "OPER", length = 30)
	public String getOper() {
		return this.oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	@Column(name = "SUMMARY", length = 500)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "HASPICTRUE", length = 10)
	public String getHaspictrue() {
		return this.haspictrue;
	}

	public void setHaspictrue(String haspictrue) {
		this.haspictrue = haspictrue;
	}

	@Column(name = "KIND", length = 50)
	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Column(name = "WEB_ID", length = 20)
	public String getWebId() {
		return this.webId;
	}

	public void setWebId(String webId) {
		this.webId = webId;
	}

	@Column(name = "CHANNEL_ID", length = 20)
	public String getChannelId() {
		return this.channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	@Column(name = "CHILD_KIND", length = 40)
	public String getChildKind() {
		return this.childKind;
	}

	public void setChildKind(String childKind) {
		this.childKind = childKind;
	}

	@Column(name = "ISFIRST", length = 20)
	public String getIsfirst() {
		return this.isfirst;
	}

	public void setIsfirst(String isfirst) {
		this.isfirst = isfirst;
	}

	@Column(name = "ALLOWREMARK", length = 10)
	public String getAllowremark() {
		return this.allowremark;
	}

	public void setAllowremark(String allowremark) {
		this.allowremark = allowremark;
	}

	@Column(name = "UPLOADFILES", length = 100)
	public String getUploadfiles() {
		return this.uploadfiles;
	}

	public void setUploadfiles(String uploadfiles) {
		this.uploadfiles = uploadfiles;
	}

	@Column(name = "VISIT_TIMES", length = 50)
	public String getVisitTimes() {
		return this.visitTimes;
	}

	public void setVisitTimes(String visitTimes) {
		this.visitTimes = visitTimes;
	}

	@Column(name = "LEFT_TEMPLATE", length = 100)
	public String getLeftTemplate() {
		return this.leftTemplate;
	}

	public void setLeftTemplate(String leftTemplate) {
		this.leftTemplate = leftTemplate;
	}

	@Column(name = "TAGS", length = 500)
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	@Column(name = "LY", length = 500)
	public String getLy() {
		return this.ly;
	}

	public void setLy(String ly) {
		this.ly = ly;
	}

	@Column(name = "TITLECOLOR", length = 10)
	public String getTitlecolor() {
		return this.titlecolor;
	}

	public void setTitlecolor(String titlecolor) {
		this.titlecolor = titlecolor;
	}

	@Column(name = "NEWS", length = 500)
	public String getNews() {
		return this.news;
	}

	public void setNews(String news) {
		this.news = news;
	}

	@Column(name = "DEPUTY_TITLE", length = 100)
	public String getDeputyTitle() {
		return this.deputyTitle;
	}

	public void setDeputyTitle(String deputyTitle) {
		this.deputyTitle = deputyTitle;
	}

	@Column(name = "LINK_TITLE", length = 100)
	public String getLinkTitle() {
		return this.linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	@Column(name = "PUB_DATE", length = 20)
	public String getPubDate() {
		return this.pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	@Column(name = "PUB_COMPANY", length = 20)
	public String getPubCompany() {
		return this.pubCompany;
	}

	public void setPubCompany(String pubCompany) {
		this.pubCompany = pubCompany;
	}

	@Column(name = "DEPUTY_TITLE_DSP", length = 10)
	public String getDeputyTitleDsp() {
		return this.deputyTitleDsp;
	}

	public void setDeputyTitleDsp(String deputyTitleDsp) {
		this.deputyTitleDsp = deputyTitleDsp;
	}

	@Column(name = "OPER_DSP", length = 10)
	public String getOperDsp() {
		return this.operDsp;
	}

	public void setOperDsp(String operDsp) {
		this.operDsp = operDsp;
	}

	@Column(name = "TAGS_DSP", length = 10)
	public String getTagsDsp() {
		return this.tagsDsp;
	}

	public void setTagsDsp(String tagsDsp) {
		this.tagsDsp = tagsDsp;
	}

	@Column(name = "PUB_COMPANY_DSP", length = 10)
	public String getPubCompanyDsp() {
		return this.pubCompanyDsp;
	}

	public void setPubCompanyDsp(String pubCompanyDsp) {
		this.pubCompanyDsp = pubCompanyDsp;
	}

	@Column(name = "SUMMARY_DSP", length = 10)
	public String getSummaryDsp() {
		return this.summaryDsp;
	}

	public void setSummaryDsp(String summaryDsp) {
		this.summaryDsp = summaryDsp;
	}

	@Column(name = "LY_DSP", length = 10)
	public String getLyDsp() {
		return this.lyDsp;
	}

	public void setLyDsp(String lyDsp) {
		this.lyDsp = lyDsp;
	}

	@Column(name = "AUTHOR", length = 500)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "PUBLISHER", length = 500)
	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Column(name = "KEYWORDS", length = 500)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "SUBTITLE", length = 500)
	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Column(name = "SNO", length = 500)
	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	@Column(name = "ISINDEX", length = 10)
	public String getIsindex() {
		return this.isindex;
	}

	public void setIsindex(String isindex) {
		this.isindex = isindex;
	}

	@Column(name = "GETFROMID", length = 50)
	public String getGetfromid() {
		return this.getfromid;
	}

	public void setGetfromid(String getfromid) {
		this.getfromid = getfromid;
	}

	@Column(name = "ISFOCUS", length = 10)
	public String getIsfocus() {
		return this.isfocus;
	}

	public void setIsfocus(String isfocus) {
		this.isfocus = isfocus;
	}

	@Column(name = "FOCUSORDERBY", length = 20)
	public String getFocusorderby() {
		return this.focusorderby;
	}

	public void setFocusorderby(String focusorderby) {
		this.focusorderby = focusorderby;
	}

	@Column(name = "VIDEOPATH", length = 1000)
	public String getVideopath() {
		return this.videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}

	@Column(name = "VIDEO_TITLE", length = 1000)
	public String getVideoTitle() {
		return this.videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	@Column(name = "ISHEAD", length = 10)
	public String getIshead() {
		return this.ishead;
	}

	public void setIshead(String ishead) {
		this.ishead = ishead;
	}

	@Column(name = "DSP_TITLE", length = 100)
	public String getDspTitle() {
		return this.dspTitle;
	}

	public void setDspTitle(String dspTitle) {
		this.dspTitle = dspTitle;
	}

	@Column(name = "ASDF", length = 500)
	public String getAsdf() {
		return this.asdf;
	}

	public void setAsdf(String asdf) {
		this.asdf = asdf;
	}

	@Column(name = "FROMCJTYPE", length = 100)
	public String getFromcjtype() {
		return this.fromcjtype;
	}

	public void setFromcjtype(String fromcjtype) {
		this.fromcjtype = fromcjtype;
	}

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}