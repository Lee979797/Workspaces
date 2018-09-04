package com.ninemax.jpa.code.model;
// default package

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TBgjlId entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_bgjl")
public class TBgjl implements java.io.Serializable {

	// Fields

	private Integer lsh;
	private String id;
	private String tyshxydm;
	private String stmc;
	private String bgsxmc;
	private String bgqnr;
	private String bghnr;
	private Date bgrq;

	// Constructors

	/** default constructor */
	public TBgjl() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lsh", nullable = false)
	public Integer getLsh() {
		return this.lsh;
	}

	public void setLsh(Integer lsh) {
		this.lsh = lsh;
	}

	@Column(name = "id", length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "tyshxydm", length = 50)
	public String getTyshxydm() {
		return this.tyshxydm;
	}

	public void setTyshxydm(String tyshxydm) {
		this.tyshxydm = tyshxydm;
	}

	@Column(name = "stmc", length = 400)
	public String getStmc() {
		return this.stmc;
	}

	public void setStmc(String stmc) {
		this.stmc = stmc;
	}

	@Column(name = "bgsxmc", length = 2000)
	public String getBgsxmc() {
		return this.bgsxmc;
	}

	public void setBgsxmc(String bgsxmc) {
		this.bgsxmc = bgsxmc;
	}

	@Column(name = "bgqnr", length = 2000)
	public String getBgqnr() {
		return this.bgqnr;
	}

	public void setBgqnr(String bgqnr) {
		this.bgqnr = bgqnr;
	}

	@Column(name = "bghnr", length = 2000)
	public String getBghnr() {
		return this.bghnr;
	}

	public void setBghnr(String bghnr) {
		this.bghnr = bghnr;
	}

	@Column(name = "bgrq", length = 23)
	public Date getBgrq() {
		return this.bgrq;
	}

	public void setBgrq(Date bgrq) {
		this.bgrq = bgrq;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TBgjl))
			return false;
		TBgjl castOther = (TBgjl) other;

		return ((this.getLsh() == castOther.getLsh()) || (this.getLsh() != null
				&& castOther.getLsh() != null && this.getLsh().equals(
				castOther.getLsh())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getTyshxydm() == castOther.getTyshxydm()) || (this
						.getTyshxydm() != null
						&& castOther.getTyshxydm() != null && this
						.getTyshxydm().equals(castOther.getTyshxydm())))
				&& ((this.getStmc() == castOther.getStmc()) || (this.getStmc() != null
						&& castOther.getStmc() != null && this.getStmc()
						.equals(castOther.getStmc())))
				&& ((this.getBgsxmc() == castOther.getBgsxmc()) || (this
						.getBgsxmc() != null
						&& castOther.getBgsxmc() != null && this.getBgsxmc()
						.equals(castOther.getBgsxmc())))
				&& ((this.getBgqnr() == castOther.getBgqnr()) || (this
						.getBgqnr() != null
						&& castOther.getBgqnr() != null && this.getBgqnr()
						.equals(castOther.getBgqnr())))
				&& ((this.getBghnr() == castOther.getBghnr()) || (this
						.getBghnr() != null
						&& castOther.getBghnr() != null && this.getBghnr()
						.equals(castOther.getBghnr())))
				&& ((this.getBgrq() == castOther.getBgrq()) || (this.getBgrq() != null
						&& castOther.getBgrq() != null && this.getBgrq()
						.equals(castOther.getBgrq())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getLsh() == null ? 0 : this.getLsh().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getTyshxydm() == null ? 0 : this.getTyshxydm().hashCode());
		result = 37 * result
				+ (getStmc() == null ? 0 : this.getStmc().hashCode());
		result = 37 * result
				+ (getBgsxmc() == null ? 0 : this.getBgsxmc().hashCode());
		result = 37 * result
				+ (getBgqnr() == null ? 0 : this.getBgqnr().hashCode());
		result = 37 * result
				+ (getBghnr() == null ? 0 : this.getBghnr().hashCode());
		result = 37 * result
				+ (getBgrq() == null ? 0 : this.getBgrq().hashCode());
		return result;
	}

}