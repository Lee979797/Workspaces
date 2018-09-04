package com.ninemax.nacao.to.govInfo;

public class clsUploadFileTO implements java.io.Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String file_id = "";
	private String gov_id = "";
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
	
	public String getGov_id() {
		return gov_id;
	}
	public void setGov_id(String gov_id) {
		this.gov_id = gov_id;
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
