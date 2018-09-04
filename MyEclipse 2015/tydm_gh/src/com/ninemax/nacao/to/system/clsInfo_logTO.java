package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * 用户下载、发布日志
 * @author Administrator
 *
 */
public class clsInfo_logTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1464249039105592293L;
	private String operid;
	private String operdate;
	private String user_id;
	private String user_name;
	private int downloads;
	private int publish;
	private int uploads;
	
	public String getOperid() {
		return operid;
	}
	public void setOperid(String operid) {
		this.operid = operid;
	}
	public String getOperdate() {
		return operdate;
	}
	public void setOperdate(String operdate) {
		this.operdate = operdate;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getDownloads() {
		return downloads;
	}
	public void setDownloads(int downloads) {
		this.downloads = downloads;
	}
	public int getPublish() {
		return publish;
	}
	public void setPublish(int publish) {
		this.publish = publish;
	}
	public int getUploads() {
		return uploads;
	}
	public void setUploads(int uploads) {
		this.uploads = uploads;
	}
	
}
