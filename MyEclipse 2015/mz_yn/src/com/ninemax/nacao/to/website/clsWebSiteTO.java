package com.ninemax.nacao.to.website;

public class clsWebSiteTO
{
  private String website_id = "";
  private String website_name = "";
  private String website_memo = "";
  private String website_createDate = "";
  private String website_oper = "";
  private String website_url = "";
  private String website_owner = "";
  private String memo1 = "";
  private String memo2 = "";
  private String user_ip = "";
  private String pageModel = "";
  private String isfirst = "";
  private int newsCount;
  private int newsChecked;
  private int newsUncheck;
  private int newsDelete;
  private long accessNum;

  public long getAccessNum()
  {
    return this.accessNum; }

  public void setAccessNum(long accessNum) {
    this.accessNum = accessNum; }

  public String getIsfirst() {
    return this.isfirst; }

  public void setIsfirst(String isfirst) {
    this.isfirst = isfirst; }

  public String getPageModel() {
    return this.pageModel; }

  public void setPageModel(String pageModel) {
    this.pageModel = pageModel; }

  public String getUser_ip() {
    return this.user_ip; }

  public void setUser_ip(String user_ip) {
    this.user_ip = user_ip; }

  public String getWebsite_id() {
    return this.website_id; }

  public void setWebsite_id(String website_id) {
    this.website_id = website_id; }

  public String getWebsite_name() {
    return this.website_name; }

  public void setWebsite_name(String website_name) {
    this.website_name = website_name; }

  public String getWebsite_memo() {
    return this.website_memo; }

  public void setWebsite_memo(String website_memo) {
    this.website_memo = website_memo; }

  public String getWebsite_createDate() {
    return this.website_createDate; }

  public void setWebsite_createDate(String website_createDate) {
    this.website_createDate = website_createDate; }

  public String getWebsite_oper() {
    return this.website_oper; }

  public void setWebsite_oper(String website_oper) {
    this.website_oper = website_oper; }

  public String getWebsite_url() {
    return this.website_url; }

  public void setWebsite_url(String website_url) {
    this.website_url = website_url; }

  public String getWebsite_owner() {
    return this.website_owner; }

  public void setWebsite_owner(String website_owner) {
    this.website_owner = website_owner; }

  public String getMemo1() {
    return this.memo1; }

  public void setMemo1(String memo1) {
    this.memo1 = memo1; }

  public String getMemo2() {
    return this.memo2; }

  public void setMemo2(String memo2) {
    this.memo2 = memo2; }

  public int getNewsCount() {
    return this.newsCount; }

  public void setNewsCount(int newsCount) {
    this.newsCount = newsCount; }

  public int getNewsChecked() {
    return this.newsChecked; }

  public void setNewsChecked(int newsChecked) {
    this.newsChecked = newsChecked; }

  public int getNewsUncheck() {
    return this.newsUncheck; }

  public void setNewsUncheck(int newsUncheck) {
    this.newsUncheck = newsUncheck; }

  public int getNewsDelete() {
    return this.newsDelete; }

  public void setNewsDelete(int newsDelete) {
    this.newsDelete = newsDelete;
  }
}