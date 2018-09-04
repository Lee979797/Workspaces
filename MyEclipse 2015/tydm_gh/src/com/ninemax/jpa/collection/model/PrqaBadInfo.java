package com.ninemax.jpa.collection.model;
// default package

import javax.persistence.*;

/**
 * PrqaBadInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DB_PRQABADINFO")
public class PrqaBadInfo implements java.io.Serializable {

	// Fields

	private Integer wfId;
	private Integer pid;
	private String uuid;
	private String wfWglx;
	private String wfNr;
	private String wfSj;
	private String wfCljg;
	private String wfCfdw;
	private String qtBlxw;
	private String qtBlxw2;
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
	public PrqaBadInfo() {
	}

	/** minimal constructor */
	public PrqaBadInfo(Integer wfId, Integer pid, String uuid) {
		this.wfId = wfId;
		this.pid = pid;
		this.uuid = uuid;
	}
	// Property accessors
	@Id
	@Column(name = "WF_ID", unique = true, nullable = false)
	@GeneratedValue
	public Integer getWfId() {
		return this.wfId;
	}

	public void setWfId(Integer wfId) {
		this.wfId = wfId;
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

	@Column(name = "WF_WGLX", length = 50)
	public String getWfWglx() {
		return this.wfWglx;
	}

	public void setWfWglx(String wfWglx) {
		this.wfWglx = wfWglx;
	}

	@Column(name = "WF_NR", length = 50)
	public String getWfNr() {
		return this.wfNr;
	}

	public void setWfNr(String wfNr) {
		this.wfNr = wfNr;
	}

	@Column(name = "WF_SJ", length = 50)
	public String getWfSj() {
		return this.wfSj;
	}

	public void setWfSj(String wfSj) {
		this.wfSj = wfSj;
	}

	@Column(name = "WF_CLJG", length = 50)
	public String getWfCljg() {
		return this.wfCljg;
	}

	public void setWfCljg(String wfCljg) {
		this.wfCljg = wfCljg;
	}

	@Column(name = "WF_CFDW", length = 200)
	public String getWfCfdw() {
		return this.wfCfdw;
	}

	public void setWfCfdw(String wfCfdw) {
		this.wfCfdw = wfCfdw;
	}

	@Column(name = "QT_BLXW", length = 200)
	public String getQtBlxw() {
		return this.qtBlxw;
	}

	public void setQtBlxw(String qtBlxw) {
		this.qtBlxw = qtBlxw;
	}

	@Column(name = "QT_BLXW2", length = 200)
	public String getQtBlxw2() {
		return this.qtBlxw2;
	}

	public void setQtBlxw2(String qtBlxw2) {
		this.qtBlxw2 = qtBlxw2;
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