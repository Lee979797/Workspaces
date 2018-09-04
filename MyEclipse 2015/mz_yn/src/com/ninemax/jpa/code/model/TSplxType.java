package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@javax.persistence.Table(name = "t_splx_type")
@Entity
public class TSplxType {
	
    private int id;
	private String splxdm;
	private String splxmc;
	
	@Column(name = "id")
    @Id
	public int getId() {
		return id;
	}
	
	@Column(name = "splxdm")
	 @Basic
	public String getSplxdm() {
		return splxdm;
	}
	
	@Column(name = "splxmc")
	 @Basic
	public String getSplxmc() {
		return splxmc;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setSplxdm(String splxdm) {
		this.splxdm = splxdm;
	}
	
	public void setSplxmc(String splxmc) {
		this.splxmc = splxmc;
	}
	
}
