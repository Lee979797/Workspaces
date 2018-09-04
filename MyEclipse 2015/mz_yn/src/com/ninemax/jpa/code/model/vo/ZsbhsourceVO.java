/**
 * 
 */
package com.ninemax.jpa.code.model.vo;

import java.io.Serializable;

/**
 * @author Liuzy
 *
 */
public class ZsbhsourceVO implements Serializable {

	private static final long serialVersionUID = -5960236270996440943L;
	private String qsbh;
	private String jzbh;
	private String zstype;
	private String outbzjg;
	private String inbzjg;
	public String getQsbh() {
		return qsbh;
	}
	public void setQsbh(String qsbh) {
		this.qsbh = qsbh;
	}
	public String getJzbh() {
		return jzbh;
	}
	public void setJzbh(String jzbh) {
		this.jzbh = jzbh;
	}
	public String getZstype() {
		return zstype;
	}
	public void setZstype(String zstype) {
		this.zstype = zstype;
	}
	public String getOutbzjg() {
		return outbzjg;
	}
	public void setOutbzjg(String outbzjg) {
		this.outbzjg = outbzjg;
	}
	public String getInbzjg() {
		return inbzjg;
	}
	public void setInbzjg(String inbzjg) {
		this.inbzjg = inbzjg;
	}
	
}
