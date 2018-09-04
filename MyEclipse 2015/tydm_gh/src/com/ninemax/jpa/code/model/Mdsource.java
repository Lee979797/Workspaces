package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author Liuzy
 *
 */
@Entity
@Table(name = "t_mdsource")
public class Mdsource implements Serializable{

	private static final long serialVersionUID = 698447784324215650L;
	

	private Integer xh;
	private String qsmd;
	private String jzmd;
	private Integer mdsl;
	private String mdtype;
	private Boolean mdzt;
	private Date lrsj;

	@Id
	@Column(name = "xh", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getXh() {
		return this.xh;
	}

	public void setXh(Integer xh) {
		this.xh = xh;
	}

	@Column(name = "qsmd", length = 8)
	public String getQsmd() {
		return this.qsmd;
	}

	public void setQsmd(String qsmd) {
		this.qsmd = qsmd;
	}

	@Column(name = "jzmd", length = 8)
	public String getJzmd() {
		return this.jzmd;
	}

	public void setJzmd(String jzmd) {
		this.jzmd = jzmd;
	}

	@Column(name = "mdsl")
	public Integer getMdsl() {
		return this.mdsl;
	}

	public void setMdsl(Integer mdsl) {
		this.mdsl = mdsl;
	}

	@Column(name = "mdtype", length = 1)
	public String getMdtype() {
		return this.mdtype;
	}

	public void setMdtype(String mdtype) {
		this.mdtype = mdtype;
	}

	@Column(name = "mdzt")
	public Boolean getMdzt() {
		return this.mdzt;
	}

	public void setMdzt(Boolean mdzt) {
		this.mdzt = mdzt;
	}

	@Column(name="lrsj",columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLrsj() {
		return lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

}
