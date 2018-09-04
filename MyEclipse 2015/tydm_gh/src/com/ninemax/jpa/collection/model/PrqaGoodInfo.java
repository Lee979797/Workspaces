package com.ninemax.jpa.collection.model;
// default package

import javax.persistence.*;

/**
 * PrqaGoodInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DB_PRQAGOODINFO")
public class PrqaGoodInfo implements java.io.Serializable {

	// Fields

	private Integer lhId;
	private Integer pid;
	private String uuid;
	private String lhZyxyzhzhpd;
	private String lhFzdw;
	private String lhZsbh;
	private String lhYxq;
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
	public PrqaGoodInfo() {
	}

	/** minimal constructor */
	public PrqaGoodInfo(Integer lhId, Integer pid, String uuid) {
		this.lhId = lhId;
		this.pid = pid;
		this.uuid = uuid;
	}

	/** full constructor */
	public PrqaGoodInfo(Integer lhId, Integer pid, String uuid,
			String lhZyxyzhzhpd, String lhFzdw, String lhZsbh, String lhYxq,
			String qt1, String qt2, String qt3, String qt4, String qt5,
			String qt6, String memo1, String memo2, String memo3, String memo4,
			String memo5, String memo6, String memo7) {
		this.lhId = lhId;
		this.pid = pid;
		this.uuid = uuid;
		this.lhZyxyzhzhpd = lhZyxyzhzhpd;
		this.lhFzdw = lhFzdw;
		this.lhZsbh = lhZsbh;
		this.lhYxq = lhYxq;
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
	@Column(name = "LH_ID", unique = true, nullable = false)
	@GeneratedValue
	public Integer getLhId() {
		return this.lhId;
	}

	public void setLhId(Integer lhId) {
		this.lhId = lhId;
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

	@Column(name = "LH_ZYXYZHZHPD", length = 50)
	public String getLhZyxyzhzhpd() {
		return this.lhZyxyzhzhpd;
	}

	public void setLhZyxyzhzhpd(String lhZyxyzhzhpd) {
		this.lhZyxyzhzhpd = lhZyxyzhzhpd;
	}

	@Column(name = "LH_FZDW", length = 200)
	public String getLhFzdw() {
		return this.lhFzdw;
	}

	public void setLhFzdw(String lhFzdw) {
		this.lhFzdw = lhFzdw;
	}

	@Column(name = "LH_ZSBH", length = 50)
	public String getLhZsbh() {
		return this.lhZsbh;
	}

	public void setLhZsbh(String lhZsbh) {
		this.lhZsbh = lhZsbh;
	}

	@Column(name = "LH_YXQ", length = 50)
	public String getLhYxq() {
		return this.lhYxq;
	}

	public void setLhYxq(String lhYxq) {
		this.lhYxq = lhYxq;
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