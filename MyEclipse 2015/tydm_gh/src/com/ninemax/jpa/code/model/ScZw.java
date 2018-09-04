package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ScZw entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sc_zw")
public class ScZw implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dm;
	private String mc;
	private String jglx;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "dm", nullable = false, length = 1)
	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	@Column(name = "mc", length = 50)
	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@Column(name = "jglx", length = 1)
	public String getJglx() {
		return this.jglx;
	}

	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

}