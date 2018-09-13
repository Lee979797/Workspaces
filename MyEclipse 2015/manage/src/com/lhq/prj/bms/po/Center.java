package com.lhq.prj.bms.po;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Center implements Serializable {
	/** ��˾id */
	private Integer centerId;

	/** ��˾��� */
	private String centerName;
	
	/** ��˾��� */
	private String centerCode;

	/** ��˾��ַ */
	private String address;

	/** ��˾�绰 */
	private String tellPhone;

	/** ��˾������ */
	private String leader;

	/** ��˾�����˵绰 */
	private String mobilePhone;

	/** ��ע */
	private String remark;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

}
