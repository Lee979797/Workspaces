package com.ninemax.jpa.code.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@javax.persistence.Table(name = "t_certificate")
@Entity
public class Certificate implements Serializable{
	
	private Integer serialNumber;
	
	private String operator;
	
	private String fzTime;
	
	private String jgdm;
	
	private String consigneeLsh;
	
	private String wsbzSerial;
	
	private String jkdh;
	
	private String memo1;
	
	private String memo2;

	@javax.persistence.Column(name = "serialNumber")
    @Id

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	@javax.persistence.Column(name = "operator")
    @Basic
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@javax.persistence.Column(name = "fzTime")
    @Basic
	public String getFzTime() {
		return fzTime;
	}

	public void setFzTime(String fzTime) {
		this.fzTime = fzTime;
	}

	@javax.persistence.Column(name = "jgdm")
    @Basic
	public String getJgdm() {
		return jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	@javax.persistence.Column(name = "consigneeLsh")
    @Basic
	public String getConsigneeLsh() {
		return consigneeLsh;
	}

	public void setConsigneeLsh(String consigneeLsh) {
		this.consigneeLsh = consigneeLsh;
	}


	@javax.persistence.Column(name = "wsbzSerial")
    @Basic
	public String getWsbzSerial() {
		return wsbzSerial;
	}

	public void setWsbzSerial(String wsbzSerial) {
		this.wsbzSerial = wsbzSerial;
	}

	@javax.persistence.Column(name = "jkdh")
    @Basic
	public String getJkdh() {
		return jkdh;
	}

	public void setJkdh(String jkdh) {
		this.jkdh = jkdh;
	}

	@javax.persistence.Column(name = "memo1")
    @Basic
	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	@javax.persistence.Column(name = "memo2")
    @Basic
	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	
	
	
	
	
	
	

}
