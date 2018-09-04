package com.ninemax.jpa.collection.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QaGlobalDiction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SC_QAGLOBAL_DICTION")
public class QaGlobalDiction implements java.io.Serializable {

	// Fields

	private Integer ids;
	private Integer idkey;
	private String idvalue;
	private String idflag;
	private String namefalg;
	private String tableflag;
	private String remark;
	private String memo;
	private String memo2;
	private String memo3;

	// Constructors

	/** default constructor */
	public QaGlobalDiction() {
	}

	/** minimal constructor */
	public QaGlobalDiction(Integer ids, Integer idkey) {
		this.ids = ids;
		this.idkey = idkey;
	}

	/** full constructor */
	public QaGlobalDiction(Integer ids, Integer idkey, String idvalue,
			String idflag, String namefalg, String tableflag, String remark,
			String memo, String memo2, String memo3) {
		this.ids = ids;
		this.idkey = idkey;
		this.idvalue = idvalue;
		this.idflag = idflag;
		this.namefalg = namefalg;
		this.tableflag = tableflag;
		this.remark = remark;
		this.memo = memo;
		this.memo2 = memo2;
		this.memo3 = memo3;
	}

	// Property accessors
	@Id
	@Column(name = "ids", unique = true, nullable = false)
	public Integer getIds() {
		return this.ids;
	}

	public void setIds(Integer ids) {
		this.ids = ids;
	}

	@Column(name = "idkey", nullable = false)
	public Integer getIdkey() {
		return this.idkey;
	}

	public void setIdkey(Integer idkey) {
		this.idkey = idkey;
	}

	@Column(name = "idvalue", length = 200)
	public String getIdvalue() {
		return this.idvalue;
	}

	public void setIdvalue(String idvalue) {
		this.idvalue = idvalue;
	}

	@Column(name = "idflag", length = 50)
	public String getIdflag() {
		return this.idflag;
	}

	public void setIdflag(String idflag) {
		this.idflag = idflag;
	}

	@Column(name = "namefalg", length = 200)
	public String getNamefalg() {
		return this.namefalg;
	}

	public void setNamefalg(String namefalg) {
		this.namefalg = namefalg;
	}

	@Column(name = "tableflag", length = 50)
	public String getTableflag() {
		return this.tableflag;
	}

	public void setTableflag(String tableflag) {
		this.tableflag = tableflag;
	}

	@Column(name = "remark", length = 50)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "memo", length = 50)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "memo2", length = 50)
	public String getMemo2() {
		return this.memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}

	@Column(name = "memo3", length = 50)
	public String getMemo3() {
		return this.memo3;
	}

	public void setMemo3(String memo3) {
		this.memo3 = memo3;
	}

}