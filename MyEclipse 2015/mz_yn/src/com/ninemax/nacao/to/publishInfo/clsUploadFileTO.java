package com.ninemax.nacao.to.publishInfo;

import java.io.Serializable;

public class clsUploadFileTO implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5661575989081958721L;
	private String file_id = "";
	private String new_id = "";
	private String file_name = "";
	private String file_describe = "";
	private String upload_time = "";
	private String user_id = "";
	private String status = "";
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getNew_id() {
		return new_id;
	}
	public void setNew_id(String new_id) {
		this.new_id = new_id;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getFile_describe() {
		return file_describe;
	}
	public void setFile_describe(String file_describe) {
		this.file_describe = file_describe;
	}
	public String getUpload_time() {
		return upload_time;
	}
	public void setUpload_time(String upload_time) {
		this.upload_time = upload_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
