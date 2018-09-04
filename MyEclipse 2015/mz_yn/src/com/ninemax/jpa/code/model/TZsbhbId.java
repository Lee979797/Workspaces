package com.ninemax.jpa.code.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TZsbhbId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TZsbhbId implements java.io.Serializable {

	private static final long serialVersionUID = 7308474686025167667L;
	private String zsbh;
	private String zslx;

	@Column(name = "zsbh", nullable = false, length = 11)
	public String getZsbh() {
		return this.zsbh;
	}

	public void setZsbh(String zsbh) {
		this.zsbh = zsbh;
	}

	@Column(name = "zslx", nullable = false, length = 1)
	public String getZslx() {
		return this.zslx;
	}

	public void setZslx(String zslx) {
		this.zslx = zslx;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TZsbhbId))
			return false;
		TZsbhbId castOther = (TZsbhbId) other;

		return ((this.getZsbh() == castOther.getZsbh()) || (this.getZsbh() != null
				&& castOther.getZsbh() != null && this.getZsbh().equals(
				castOther.getZsbh())))
				&& ((this.getZslx() == castOther.getZslx()) || (this.getZslx() != null
						&& castOther.getZslx() != null && this.getZslx()
						.equals(castOther.getZslx())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getZsbh() == null ? 0 : this.getZsbh().hashCode());
		result = 37 * result
				+ (getZslx() == null ? 0 : this.getZslx().hashCode());
		return result;
	}

}