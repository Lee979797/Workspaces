package com.ninemax.jpa.code.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBgjl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_bgjl")
public class TBgjl implements java.io.Serializable {

	// Fields

	private Integer lsh;
	private String id;
	private String tyshxydm;
	private String stmc;
	private String bgsxmc;
	private String bgqnr;
	private String bghnr;
	private Date bgrq;
	private String bgyy;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lsh", unique = true, nullable = false)
	public Integer getLsh() {
		return this.lsh;
	}

	public void setLsh(Integer lsh) {
		this.lsh = lsh;
	}

	@Column(name = "id", length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "tyshxydm", length = 50)
	public String getTyshxydm() {
		return this.tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	@Column(name = "stmc")
	public String getStmc() {
		return this.stmc;
	}

	public void setStmc(String stmc) {
		this.stmc = stmc;
	}

	@Column(name = "bgsxmc")
	public String getBgsxmc() {
		return this.bgsxmc;
	}

	public void setBgsxmc(String bgsxmc) {
		this.bgsxmc = bgsxmc;
	}

	@Column(name = "bgqnr")
	public String getBgqnr() {
		return this.bgqnr;
	}

	public void setBgqnr(String bgqnr) {
		this.bgqnr = bgqnr;
	}

	@Column(name = "bghnr")
	public String getBghnr() {
		return this.bghnr;
	}

	public void setBghnr(String bghnr) {
		this.bghnr = bghnr;
	}

	@Column(name = "bgrq", length = 23)
	public Date getBgrq() {
		return this.bgrq;
	}

	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}
	@Column(name = "bgyy", length = 500)
	public String getBgyy() {
		return bgyy;
	}

	public void setBgyy(String bgyy) {
		this.bgyy = bgyy;
	}

}