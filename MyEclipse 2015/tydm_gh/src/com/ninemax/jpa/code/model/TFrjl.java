package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TFrjl entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_frjl")
public class TFrjl implements java.io.Serializable {

	// Fields

	private Long lsh;
	private Integer frId;
	private String rzsj1;
	private String gzdw1;
	private String zw1;
	private String rzsj2;
	private String gzdw2;
	private String zw2;
	private String rzsj3;
	private String gzdw3;
	private String zw3;
	private String rzsj4;
	private String gzdw4;
	private String zw4;
	private String rzsj5;
	private String gzdw5;
	private String zw5;
	private String rzsj6;
	private String gzdw6;
	private String zw6;
	private String rzsj7;
	private String gzdw7;
	private String zw7;
	private String rzsj8;
	private String gzdw8;
	private String zw8;
	private String wt;
	private String memo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lsh", unique = true, nullable = false)
	public Long getLsh() {
		return this.lsh;
	}

	public void setLsh(Long lsh) {
		this.lsh = lsh;
	}

	@Column(name = "fr_id")
	public Integer getFrId() {
		return this.frId;
	}

	public void setFrId(Integer frId) {
		this.frId = frId;
	}

	@Column(name = "rzsj1", length = 100)
	public String getRzsj1() {
		return this.rzsj1;
	}

	public void setRzsj1(String rzsj1) {
		this.rzsj1 = rzsj1;
	}

	@Column(name = "gzdw1", length = 240)
	public String getGzdw1() {
		return this.gzdw1;
	}

	public void setGzdw1(String gzdw1) {
		this.gzdw1 = gzdw1;
	}

	@Column(name = "zw1", length = 100)
	public String getZw1() {
		return this.zw1;
	}

	public void setZw1(String zw1) {
		this.zw1 = zw1;
	}

	@Column(name = "rzsj2", length = 100)
	public String getRzsj2() {
		return this.rzsj2;
	}

	public void setRzsj2(String rzsj2) {
		this.rzsj2 = rzsj2;
	}

	@Column(name = "gzdw2", length = 240)
	public String getGzdw2() {
		return this.gzdw2;
	}

	public void setGzdw2(String gzdw2) {
		this.gzdw2 = gzdw2;
	}

	@Column(name = "zw2", length = 100)
	public String getZw2() {
		return this.zw2;
	}

	public void setZw2(String zw2) {
		this.zw2 = zw2;
	}

	@Column(name = "rzsj3", length = 100)
	public String getRzsj3() {
		return this.rzsj3;
	}

	public void setRzsj3(String rzsj3) {
		this.rzsj3 = rzsj3;
	}

	@Column(name = "gzdw3", length = 240)
	public String getGzdw3() {
		return this.gzdw3;
	}

	public void setGzdw3(String gzdw3) {
		this.gzdw3 = gzdw3;
	}

	@Column(name = "zw3", length = 100)
	public String getZw3() {
		return this.zw3;
	}

	public void setZw3(String zw3) {
		this.zw3 = zw3;
	}

	@Column(name = "rzsj4", length = 100)
	public String getRzsj4() {
		return this.rzsj4;
	}

	public void setRzsj4(String rzsj4) {
		this.rzsj4 = rzsj4;
	}

	@Column(name = "gzdw4", length = 240)
	public String getGzdw4() {
		return this.gzdw4;
	}

	public void setGzdw4(String gzdw4) {
		this.gzdw4 = gzdw4;
	}

	@Column(name = "zw4", length = 100)
	public String getZw4() {
		return this.zw4;
	}

	public void setZw4(String zw4) {
		this.zw4 = zw4;
	}

	@Column(name = "rzsj5", length = 100)
	public String getRzsj5() {
		return this.rzsj5;
	}

	public void setRzsj5(String rzsj5) {
		this.rzsj5 = rzsj5;
	}

	@Column(name = "gzdw5", length = 240)
	public String getGzdw5() {
		return this.gzdw5;
	}

	public void setGzdw5(String gzdw5) {
		this.gzdw5 = gzdw5;
	}

	@Column(name = "zw5", length = 100)
	public String getZw5() {
		return this.zw5;
	}

	public void setZw5(String zw5) {
		this.zw5 = zw5;
	}

	@Column(name = "rzsj6", length = 100)
	public String getRzsj6() {
		return this.rzsj6;
	}

	public void setRzsj6(String rzsj6) {
		this.rzsj6 = rzsj6;
	}

	@Column(name = "gzdw6", length = 240)
	public String getGzdw6() {
		return this.gzdw6;
	}

	public void setGzdw6(String gzdw6) {
		this.gzdw6 = gzdw6;
	}

	@Column(name = "zw6", length = 100)
	public String getZw6() {
		return this.zw6;
	}

	public void setZw6(String zw6) {
		this.zw6 = zw6;
	}

	@Column(name = "rzsj7", length = 100)
	public String getRzsj7() {
		return this.rzsj7;
	}

	public void setRzsj7(String rzsj7) {
		this.rzsj7 = rzsj7;
	}

	@Column(name = "gzdw7", length = 240)
	public String getGzdw7() {
		return this.gzdw7;
	}

	public void setGzdw7(String gzdw7) {
		this.gzdw7 = gzdw7;
	}

	@Column(name = "zw7", length = 100)
	public String getZw7() {
		return this.zw7;
	}

	public void setZw7(String zw7) {
		this.zw7 = zw7;
	}

	@Column(name = "rzsj8", length = 100)
	public String getRzsj8() {
		return this.rzsj8;
	}

	public void setRzsj8(String rzsj8) {
		this.rzsj8 = rzsj8;
	}

	@Column(name = "gzdw8", length = 240)
	public String getGzdw8() {
		return this.gzdw8;
	}

	public void setGzdw8(String gzdw8) {
		this.gzdw8 = gzdw8;
	}

	@Column(name = "zw8", length = 100)
	public String getZw8() {
		return this.zw8;
	}

	public void setZw8(String zw8) {
		this.zw8 = zw8;
	}
	@Column(name = "wt", length = 500)
	public String getWt() {
		return wt;
	}

	public void setWt(String wt) {
		this.wt = wt;
	}
	@Column(name = "memo", length = 500)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}