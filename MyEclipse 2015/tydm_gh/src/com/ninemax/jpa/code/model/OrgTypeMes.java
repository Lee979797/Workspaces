package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@javax.persistence.Table(name = "orgTypeMes")
@Entity
public class OrgTypeMes {
	
    @javax.persistence.Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @javax.persistence.Column(name = "org1")
    @Basic
	private String org1;
    
    @javax.persistence.Column(name = "org2")
    @Basic
	private String org2;
    
    @javax.persistence.Column(name = "org3")
    @Basic
	private String org3;
    
    @javax.persistence.Column(name = "org4")
    @Basic
	private String org4;
    
    @javax.persistence.Column(name = "org5")
    @Basic
	private String org5;
    
    @javax.persistence.Column(name = "org6")
    @Basic
	private String org6;
    
    @javax.persistence.Column(name = "org7")
    @Basic
	private String org7;
    
    @javax.persistence.Column(name = "org8")
    @Basic
	private String org8;
    
    @javax.persistence.Column(name = "org9")
    @Basic
	private String org9;
    
    @javax.persistence.Column(name = "org10")
    @Basic
	private String org10;
    
    @javax.persistence.Column(name = "org11")
    @Basic
	private String org11;
    
    @javax.persistence.Column(name = "org12")
    @Basic
	private String org12;
    

	
    @javax.persistence.Column(name = "onOff")
    @Basic
	private String onOff;
	
    @javax.persistence.Column(name = "memo1")
    @Basic
	private String memeo1;
	
    @javax.persistence.Column(name = "memo2")
    @Basic
	private String memo2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrg1() {
		return org1;
	}

	public void setOrg1(String org1) {
		this.org1 = org1;
	}

	public String getOrg2() {
		return org2;
	}

	public void setOrg2(String org2) {
		this.org2 = org2;
	}

	public String getOrg3() {
		return org3;
	}

	public void setOrg3(String org3) {
		this.org3 = org3;
	}

	public String getOrg4() {
		return org4;
	}

	public void setOrg4(String org4) {
		this.org4 = org4;
	}

	public String getOrg5() {
		return org5;
	}

	public void setOrg5(String org5) {
		this.org5 = org5;
	}

	public String getOrg6() {
		return org6;
	}

	public void setOrg6(String org6) {
		this.org6 = org6;
	}

	public String getOrg7() {
		return org7;
	}

	public void setOrg7(String org7) {
		this.org7 = org7;
	}

	public String getOrg8() {
		return org8;
	}

	public void setOrg8(String org8) {
		this.org8 = org8;
	}

	public String getOrg9() {
		return org9;
	}

	public void setOrg9(String org9) {
		this.org9 = org9;
	}

	public String getOrg10() {
		return org10;
	}

	public void setOrg10(String org10) {
		this.org10 = org10;
	}

	public String getOrg11() {
		return org11;
	}

	public void setOrg11(String org11) {
		this.org11 = org11;
	}

	public String getOrg12() {
		return org12;
	}

	public void setOrg12(String org12) {
		this.org12 = org12;
	}



	public String getOnOff() {
		return onOff;
	}

	public void setOnOff(String onOff) {
		this.onOff = onOff;
	}

	public String getMemeo1() {
		return memeo1;
	}

	public void setMemeo1(String memeo1) {
		this.memeo1 = memeo1;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
    
    

	
	

}
