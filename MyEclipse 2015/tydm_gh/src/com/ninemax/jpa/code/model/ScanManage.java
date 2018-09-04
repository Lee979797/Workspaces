package com.ninemax.jpa.code.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


/**
 * «∞÷√…®√Ëπ‹¿Ì
 * @author a
 *
 */
@Table(name = "t_scanManage")
@Entity
public class ScanManage {

	@Column(name = "xzqh")
    @Id
	private int xzqh;

	@Column(name = "status")
    @Basic
	private String status;

	@Column(name = "lx")
    @Basic
	private String lx;

	@Column(name = "memo1")
    @Basic
	private String memo1;

	@Column(name = "memo2")
    @Basic
	private String memo2;

	public int getXzqh() {
		return xzqh;
	}

	public void setXzqh(int xzqh) {
		this.xzqh = xzqh;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLx() {
		return lx;
	}

	public void setLx(String lx) {
		this.lx = lx;
	}

	public String getMemo1() {
		return memo1;
	}

	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}

	public String getMemo2() {
		return memo2;
	}

	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	
	
	

}
