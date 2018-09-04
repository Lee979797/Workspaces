package com.ninemax.jpa.system.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ScZrxzqh entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sc_zrxzqh")
public class ScZrxzqh implements java.io.Serializable {

	// Fields

	private Integer id;
	private String zrxzqhId;
	private String zrxzqhName;

	// Constructors

	/** default constructor */
	public ScZrxzqh() {
	}

	/** minimal constructor */
	public ScZrxzqh(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public ScZrxzqh(Integer id, String zrxzqhId, String zrxzqhName) {
		this.id = id;
		this.zrxzqhId = zrxzqhId;
		this.zrxzqhName = zrxzqhName;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "zrxzqh_id", unique = false, nullable = true, insertable = true, updatable = true, length = 10)
	public String getZrxzqhId() {
		return this.zrxzqhId;
	}

	public void setZrxzqhId(String zrxzqhId) {
		this.zrxzqhId = zrxzqhId;
	}

	@Column(name = "zrxzqh_name", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public String getZrxzqhName() {
		return this.zrxzqhName;
	}

	public void setZrxzqhName(String zrxzqhName) {
		this.zrxzqhName = zrxzqhName;
	}

}