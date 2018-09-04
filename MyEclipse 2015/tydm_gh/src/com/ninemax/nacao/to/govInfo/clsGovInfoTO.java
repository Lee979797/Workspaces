package com.ninemax.nacao.to.govInfo;

public class clsGovInfoTO implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private String gov_id="";
	private String gov_pub_date = "";
	private String gov_title = "";
	private String gov_number = "";
	private String gov_summary = "";
	private String gov_pub_auther = "";
	private String webSite_id = "";
	private String hasPicture = "";
	private String type = "";
	private String gov_status="";
	private String userid = "";
	private String gov_picture = "";
	private String memo1 = "";
	private String memo2 = "";
	private String memo3 = "";
	private String gov_content = "";
	private String hasBrowse = "";
	private String gov_type = "";
	private int viewed = 0;
	private int downloads = 0;
	private String tags = "";
	private String sharee = "";
	private String consult = "";
	private int gov_score = 0;

	public String getGov_id(){
		return gov_id; 
	}
	public void setGov_id(String gov_id) {
		this.gov_id = gov_id;
	}
	public String getGov_pub_date() {
		return gov_pub_date;
	}
	public void setGov_pub_date(String gov_pub_date) {
		this.gov_pub_date = gov_pub_date;
	}
	public String getGov_title() {
		return gov_title;
	}
	public void setGov_title(String gov_title) {
		this.gov_title = gov_title;
	}
	public String getGov_number() {
		return gov_number;
	}
	public void setGov_number(String gov_number) {
		this.gov_number = gov_number;
	}
	public String getGov_summary() {
		return gov_summary;
	}
	public void setGov_summary(String gov_summary) {
		this.gov_summary = gov_summary;
	}
	public String getGov_pub_auther() {
		return gov_pub_auther;
	}
	public void setGov_pub_auther(String gov_pub_auther) {
		this.gov_pub_auther = gov_pub_auther;
	}
	public String getWebSite_id() {
		return webSite_id;
	}
	public void setWebSite_id(String webSite_id) {
		this.webSite_id = webSite_id;
	}
	public String getHasPicture() {
		return hasPicture;
	}
	public void setHasPicture(String hasPicture) {
		this.hasPicture = hasPicture;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGov_status() {
		return gov_status;
	}
	public void setGov_status(String gov_status) {
		this.gov_status = gov_status;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getGov_picture() {
		return gov_picture;
	}
	public void setGov_picture(String gov_picture) {
		this.gov_picture = gov_picture;
	}
	public String getMemo1() {
		return memo1;
	}
	public void setMemo1(String memo1) {
		this.memo1 = memo1;
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
	public String getGov_content() {
		return gov_content;
	}
	public void setGov_content(String gov_content) {
		this.gov_content = gov_content;
	}
	public String getHasBrowse() {
		return hasBrowse;
	}
	public void setHasBrowse(String hasBrowse) {
		this.hasBrowse = hasBrowse;
	}
	public String getGov_type() {
		return gov_type;
	}
	public void setGov_type(String gov_type) {
		this.gov_type = gov_type;
	}
	public int getViewed() {
		return viewed;    
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}

	public void setShare(String sharee) {
		this.sharee = sharee; 
	}
	public String getShare(){
		return sharee;
	}
	public String getConsult() {
		return consult;
	}
	public void setConsult(String consult) {
		this.consult = consult;
	}
	public int getGov_score() {
		return gov_score;
	}
	public void setGov_score(int gov_score) {
		this.gov_score = gov_score;
	}
	
}
