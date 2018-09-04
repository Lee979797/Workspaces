package com.ninemax.jpa.code.model;

import javax.persistence.*;

/**
 * SmUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sm_user")
public class SmUser implements java.io.Serializable {

	// Fields

	private Long id;
	private String usertype;
	private String userstatus;
	private String jgdm;
	private String jgmc;
	private String djh;
	private String fddbr;
	private String zjlx;
	private String zjhm;
	private String username;
	private String password;
	private String jbrxm;
	private String jbrzjlx;
	private String jbrzjhm;
	private String jbrmobile;
	private String jbremail;
	private String memo;
	private String memo1;
	private String memo2;
	private String memo3;
	private String memo4;
	private String memo5;
	private String regdate;


	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, precision = 10, scale = 0)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "usertype", nullable = false, length = 1)
	public String getUsertype() {
		return this.usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Column(name = "userstatus", nullable = false, length = 1)
	public String getUserstatus() {
		return this.userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	@Column(name = "jgdm", length = 9)
	public String getJgdm() {
		return this.jgdm;
	}

	public void setJgdm(String jgdm) {
		this.jgdm = jgdm;
	}

	@Column(name = "jgmc", length = 120)
	public String getJgmc() {
		return this.jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	@Column(name = "djh", length = 25)
	public String getDjh() {
		return this.djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	@Column(name = "fddbr", length = 60)
	public String getFddbr() {
		return this.fddbr;
	}

	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}

	@Column(name = "zjlx", length = 2)
	public String getZjlx() {
		return this.zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	@Column(name = "zjhm", length = 25)
	public String getZjhm() {
		return this.zjhm;
	}

	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}

	@Column(name = "username", length = 10)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 70)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "jbrxm", length = 60)
	public String getJbrxm() {
		return this.jbrxm;
	}

	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}

	@Column(name = "jbrzjlx", length = 2)
	public String getJbrzjlx() {
		return this.jbrzjlx;
	}

	public void setJbrzjlx(String jbrzjlx) {
		this.jbrzjlx = jbrzjlx;
	}

	@Column(name = "jbrzjhm", length = 25)
	public String getJbrzjhm() {
		return this.jbrzjhm;
	}

	public void setJbrzjhm(String jbrzjhm) {
		this.jbrzjhm = jbrzjhm;
	}

	@Column(name = "jbrmobile", length = 15)
	public String getJbrmobile() {
		return this.jbrmobile;
	}

	public void setJbrmobile(String jbrmobile) {
		this.jbrmobile = jbrmobile;
	}

	@Column(name = "jbremail", length = 50)
	public String getJbremail() {
		return this.jbremail;
	}

	public void setJbremail(String jbremail) {
		this.jbremail = jbremail;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "memo1", length = 200)
	public String getMemo1() {
		return this.memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	@Column(name = "memo2", length = 200)
	public String getMemo2() {
		return this.memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	@Column(name = "memo3", length = 200)
	public String getMemo3() {
		return this.memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	@Column(name = "memo4", length = 200)
	public String getMemo4() {
		return this.memo4;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	@Column(name = "memo5", length = 200)
	public String getMemo5() {
		return this.memo5;
	}

	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}

	@Column(name = "regdate", length = 20)
	public String getRegdate() {
		return this.regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}