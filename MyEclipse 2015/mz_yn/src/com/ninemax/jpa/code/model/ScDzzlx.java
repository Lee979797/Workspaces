package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ScDzzlx entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sc_dzzlx")
public class ScDzzlx implements java.io.Serializable {


	private Integer dm;
	private String mc;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dm", unique = true, nullable = false)
	public Integer getDm() {
		return this.dm;
	}

	public void setDm(Integer dm) {
		this.dm = dm;
	}

	@Column(name = "mc", length = 500)
	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

}