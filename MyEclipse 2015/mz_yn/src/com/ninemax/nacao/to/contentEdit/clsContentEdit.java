package com.ninemax.nacao.to.contentEdit;

import java.io.Serializable;

public class clsContentEdit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5993345035338934498L;

	private String id = "";
	
	private String content = "";
	
	private String editName = "";
	
	private String editDate = "";
	
	private String bak1 = "";
	
	private String bak2 = "";
	
	private String bak3 = "";
	
	private String delFlag = "";

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEditName() {
		return editName;
	}

	public void setEditName(String editName) {
		this.editName = editName;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getBak1() {
		return bak1;
	}

	public void setBak1(String bak1) {
		this.bak1 = bak1;
	}

	public String getBak2() {
		return bak2;
	}

	public void setBak2(String bak2) {
		this.bak2 = bak2;
	}

	public String getBak3() {
		return bak3;
	}

	public void setBak3(String bak3) {
		this.bak3 = bak3;
	}
	
	

}
