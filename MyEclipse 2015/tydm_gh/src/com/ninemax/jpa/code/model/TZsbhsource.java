package com.ninemax.jpa.code.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Liuzy
 */
@Entity
@Table(name = "t_zsbhsource")
public class TZsbhsource implements java.io.Serializable {

	private static final long serialVersionUID = 7652522581630584706L;
	private Integer xh;
	private String qsbh;
	private String jzbh;
	private Integer zssl;
	private String zstype;
	private String fpbzjg;
	private Boolean flag;
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

	@Column(name = "qsbh", length = 11)
	public String getQsbh() {
		return this.qsbh;
	}

	public void setQsbh(String qsbh) {
		this.qsbh = qsbh;
	}

	@Column(name = "jzbh", length = 11)
	public String getJzbh() {
		return this.jzbh;
	}

	public void setJzbh(String jzbh) {
		this.jzbh = jzbh;
	}

	@Column(name = "zssl")
	public Integer getZssl() {
		return this.zssl;
	}

	public void setZssl(Integer zssl) {
		this.zssl = zssl;
	}

	@Column(name = "zstype", length = 1)
	public String getZstype() {
		return this.zstype;
	}

	public void setZstype(String zstype) {
		this.zstype = zstype;
	}

	@Column(name = "fpbzjg", length = 6)
	public String getFpbzjg() {
		return this.fpbzjg;
	}

	public void setFpbzjg(String fpbzjg) {
		this.fpbzjg = fpbzjg;
	}

	@Column(name = "flag")
	public Boolean getFlag() {
		return this.flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Column(name = "lrsj", length = 23,columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLrsj() {
		return this.lrsj;
	}

	public void setLrsj(Date lrsj) {
		this.lrsj = lrsj;
	}

}