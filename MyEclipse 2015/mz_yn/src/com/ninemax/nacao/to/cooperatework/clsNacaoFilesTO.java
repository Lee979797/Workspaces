package com.ninemax.nacao.to.cooperatework;

public class clsNacaoFilesTO {
	
	//系统用户上传得文件
	private String id ;
	private String title;
	private String descrition;
	private String publisher;
	private String userId;
	private String addTime;
	private String fileName;
	private String status;
	private String provinceFileId;//地上上传的文件id 
	private String kind;//对发布文件的归类，01：共享文件 02：公告文件 03：共享信息
	
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProvinceFileId() {
		return provinceFileId;
	}
	public void setProvinceFileId(String provinceFileId) {
		this.provinceFileId = provinceFileId;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	
}
