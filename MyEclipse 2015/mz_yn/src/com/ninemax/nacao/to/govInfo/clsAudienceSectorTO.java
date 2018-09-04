package com.ninemax.nacao.to.govInfo;

import java.io.Serializable;

public class clsAudienceSectorTO implements Serializable{
	
	String department_id;
	String documentation_id;
	String isnotice;
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDocumentation_id() {
		return documentation_id;
	}
	public void setDocumentation_id(String documentation_id) {
		this.documentation_id = documentation_id;
	}
	public String getIsnotice() {
		return isnotice;
	}
	public void setIsnotice(String isnotice) {
		this.isnotice = isnotice;
	}
	
	

}
