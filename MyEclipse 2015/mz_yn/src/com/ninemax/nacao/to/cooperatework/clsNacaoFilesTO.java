package com.ninemax.nacao.to.cooperatework;

public class clsNacaoFilesTO {
	
	//ϵͳ�û��ϴ����ļ�
	private String id ;
	private String title;
	private String descrition;
	private String publisher;
	private String userId;
	private String addTime;
	private String fileName;
	private String status;
	private String provinceFileId;//�����ϴ����ļ�id 
	private String kind;//�Է����ļ��Ĺ��࣬01�������ļ� 02�������ļ� 03��������Ϣ
	
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
