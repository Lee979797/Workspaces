package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ScXzqhdz entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sc_xzqhdz")
public class ScXzqhdz implements java.io.Serializable {


	private Integer id;
	private String dm;
	private String mc;
	private String yzbm;
	private String dhqh;
	private String memo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "dm", length = 6)
	public String getDm() {
		return this.dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	@Column(name = "mc")
	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	@Column(name = "yzbm", length = 6)
	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	@Column(name = "dhqh", length = 4)
	public String getDhqh() {
		return this.dhqh;
	}

	public void setDhqh(String dhqh) {
		this.dhqh = dhqh;
	}
	
	@Column(name = "memo")
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.dhqh = memo;
	}

}