package com.ninemax.jpa.code.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@javax.persistence.Table(name = "DB_ZDB")
@Entity
public class DBzdb {


	private int did;
	private String name;
	private String bbh;
	private String memo;
	
	
	 @Id
	 @javax.persistence.Column(name = "did")
	public int getDid() {
		return this.did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	 @javax.persistence.Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@javax.persistence.Column(name = "bbh")
	public String getBbh() {
		return this.bbh;
	}

	public void setBbh(String bbh) {
		this.bbh = bbh;
	}


	
	@javax.persistence.Column(name = "memo")
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "DBzdb [did=" + did + ", name=" + name + ", bbh=" + bbh
				+ ", memo=" + memo + "]";
	}

	

	
	
	

}