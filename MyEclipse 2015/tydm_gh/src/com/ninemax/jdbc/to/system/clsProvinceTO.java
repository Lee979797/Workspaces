package com.ninemax.jdbc.to.system;

public class clsProvinceTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5974460342878797081L;
	private String id ;
	private String provinceName;
	private String orderBy;
	
	private String province_islast;  //省份是否末级
	private String province_depth;  //省份的深度层次
	private String province_status;  //省份状态
	private String province_kind;  //省份类型
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getProvince_islast() {
		return province_islast;
	}
	public void setProvince_islast(String province_islast) {
		this.province_islast = province_islast;
	}
	public String getProvince_depth() {
		return province_depth;
	}
	public void setProvince_depth(String province_depth) {
		this.province_depth = province_depth;
	}
	public String getProvince_status() {
		return province_status;
	}
	public void setProvince_status(String province_status) {
		this.province_status = province_status;
	}
	public String getProvince_kind() {
		return province_kind;
	}
	public void setProvince_kind(String province_kind) {
		this.province_kind = province_kind;
	}
	
	
	
	
}
