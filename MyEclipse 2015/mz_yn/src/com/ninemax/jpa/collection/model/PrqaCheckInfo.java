package com.ninemax.jpa.collection.model;
// default package

import javax.persistence.*;

/**
 * PrqaCheckInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DB_PRQACHECKINFO")
public class PrqaCheckInfo implements java.io.Serializable {

	// Fields

	private Integer jdId;
	private Integer pid;
	private String uuid;
	private String jdJczl;
	private String jdCpmcgg;
	private String jdJcsj;
	private String jdJcjb;
	private String jdJclb;
	private String jdJcjl;
	private String jdFcqk;
	private String qt1;
	private String qt2;
	private String qt3;
	private String qt4;
	private String qt5;
	private String qt6;
	private String memo1;
	private String memo2;
	private String memo3;
	private String memo4;
	private String memo5;
	private String memo6;
	private String memo7;

	// Constructors

	/** default constructor */
	public PrqaCheckInfo() {
	}

	/** minimal constructor */
	public PrqaCheckInfo(Integer jdId, Integer pid, String uuid) {
		this.jdId = jdId;
		this.pid = pid;
		this.uuid = uuid;
	}

	/** full constructor */
	public PrqaCheckInfo(Integer jdId, Integer pid, String uuid, String jdJczl,
			String jdCpmcgg, String jdJcsj, String jdJcjb, String jdJclb,
			String jdJcjl, String jdFcqk, String qt1, String qt2, String qt3,
			String qt4, String qt5, String qt6, String memo1, String memo2,
			String memo3, String memo4, String memo5, String memo6, String memo7) {
		this.jdId = jdId;
		this.pid = pid;
		this.uuid = uuid;
		this.jdJczl = jdJczl;
		this.jdCpmcgg = jdCpmcgg;
		this.jdJcsj = jdJcsj;
		this.jdJcjb = jdJcjb;
		this.jdJclb = jdJclb;
		this.jdJcjl = jdJcjl;
		this.jdFcqk = jdFcqk;
		this.qt1 = qt1;
		this.qt2 = qt2;
		this.qt3 = qt3;
		this.qt4 = qt4;
		this.qt5 = qt5;
		this.qt6 = qt6;
		this.memo1 = memo1;
		this.memo2 = memo2;
		this.memo3 = memo3;
		this.memo4 = memo4;
		this.memo5 = memo5;
		this.memo6 = memo6;
		this.memo7 = memo7;
	}

	// Property accessors
	@Id
	@Column(name = "JD_ID", unique = true, nullable = false)
	@GeneratedValue
	public Integer getJdId() {
		return this.jdId;
	}

	public void setJdId(Integer jdId) {
		this.jdId = jdId;
	}

	@Column(name = "PID", nullable = false)
	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Column(name = "UUID", nullable = false, length = 50)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Column(name = "JD_JCZL", length = 50)
	public String getJdJczl() {
		return this.jdJczl;
	}

	public void setJdJczl(String jdJczl) {
		this.jdJczl = jdJczl;
	}

	@Column(name = "JD_CPMCGG", length = 50)
	public String getJdCpmcgg() {
		return this.jdCpmcgg;
	}

	public void setJdCpmcgg(String jdCpmcgg) {
		this.jdCpmcgg = jdCpmcgg;
	}

	@Column(name = "JD_JCSJ", length = 50)
	public String getJdJcsj() {
		return this.jdJcsj;
	}

	public void setJdJcsj(String jdJcsj) {
		this.jdJcsj = jdJcsj;
	}

	@Column(name = "JD_JCJB", length = 50)
	public String getJdJcjb() {
		return this.jdJcjb;
	}

	public void setJdJcjb(String jdJcjb) {
		this.jdJcjb = jdJcjb;
	}

	@Column(name = "JD_JCLB", length = 50)
	public String getJdJclb() {
		return this.jdJclb;
	}

	public void setJdJclb(String jdJclb) {
		this.jdJclb = jdJclb;
	}

	@Column(name = "JD_JCJL", length = 50)
	public String getJdJcjl() {
		return this.jdJcjl;
	}

	public void setJdJcjl(String jdJcjl) {
		this.jdJcjl = jdJcjl;
	}

	@Column(name = "JD_FCQK", length = 50)
	public String getJdFcqk() {
		return this.jdFcqk;
	}

	public void setJdFcqk(String jdFcqk) {
		this.jdFcqk = jdFcqk;
	}

	@Column(name = "QT1", length = 50)
	public String getQt1() {
		return this.qt1;
	}

	public void setQt1(String qt1) {
		this.qt1 = qt1;
	}

	@Column(name = "QT2", length = 50)
	public String getQt2() {
		return this.qt2;
	}

	public void setQt2(String qt2) {
		this.qt2 = qt2;
	}

	@Column(name = "QT3", length = 50)
	public String getQt3() {
		return this.qt3;
	}

	public void setQt3(String qt3) {
		this.qt3 = qt3;
	}

	@Column(name = "QT4", length = 50)
	public String getQt4() {
		return this.qt4;
	}

	public void setQt4(String qt4) {
		this.qt4 = qt4;
	}

	@Column(name = "QT5", length = 50)
	public String getQt5() {
		return this.qt5;
	}

	public void setQt5(String qt5) {
		this.qt5 = qt5;
	}

	@Column(name = "QT6", length = 50)
	public String getQt6() {
		return this.qt6;
	}

	public void setQt6(String qt6) {
		this.qt6 = qt6;
	}

	@Column(name = "MEMO1", length = 50)
	public String getMemo1() {
		return this.memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	@Column(name = "MEMO2", length = 50)
	public String getMemo2() {
		return this.memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	@Column(name = "MEMO3", length = 50)
	public String getMemo3() {
		return this.memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

	@Column(name = "MEMO4", length = 50)
	public String getMemo4() {
		return this.memo4;
	}

	public void setMemo4(String memo4) {
		this.memo4 = memo4;
	}

	@Column(name = "MEMO5", length = 50)
	public String getMemo5() {
		return this.memo5;
	}

	public void setMemo5(String memo5) {
		this.memo5 = memo5;
	}

	@Column(name = "MEMO6", length = 200)
	public String getMemo6() {
		return this.memo6;
	}

	public void setMemo6(String memo6) {
		this.memo6 = memo6;
	}

	@Column(name = "MEMO7", length = 200)
	public String getMemo7() {
		return this.memo7;
	}

	public void setMemo7(String memo7) {
		this.memo7 = memo7;
	}

}