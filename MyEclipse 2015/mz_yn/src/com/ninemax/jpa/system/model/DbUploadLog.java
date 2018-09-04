package com.ninemax.jpa.system.model;
// default package

import javax.persistence.*;
import java.util.Date;

/**
 * DbUploadLog entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DB_Upload_log")
public class DbUploadLog implements java.io.Serializable {

	// Fields

	private Integer uploadid;
	private Date uploadDate;
	private Date finishDate;
	private Integer datatotal;
	private String status;

	// Constructors

	/** default constructor */
	public DbUploadLog() {
	}

	/** minimal constructor */
	public DbUploadLog(Integer uploadid) {
		this.uploadid = uploadid;
	}

	/** full constructor */
	public DbUploadLog(Integer uploadid, Date uploadDate, Date finishDate,
			Integer datatotal, String status) {
		this.uploadid = uploadid;
		this.uploadDate = uploadDate;
		this.finishDate = finishDate;
		this.datatotal = datatotal;
		this.status = status;
	}

	// Property accessors
	@Id
	@Column(name = "uploadid", unique = true, nullable = false, insertable = true, updatable = true)
	public Integer getUploadid() {
		return this.uploadid;
	}

	public void setUploadid(Integer uploadid) {
		this.uploadid = uploadid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "upload_date", unique = false, nullable = true, insertable = true, updatable = true, length = 23)
	public Date getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "finish_date", unique = false, nullable = true, insertable = true, updatable = true, length = 23)
	public Date getFinishDate() {
		return this.finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	@Column(name = "datatotal", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getDatatotal() {
		return this.datatotal;
	}

	public void setDatatotal(Integer datatotal) {
		this.datatotal = datatotal;
	}

	@Column(name = "status", unique = false, nullable = true, insertable = true, updatable = true, length = 2)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}