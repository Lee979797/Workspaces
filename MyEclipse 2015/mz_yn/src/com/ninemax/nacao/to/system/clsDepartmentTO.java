package com.ninemax.nacao.to.system;

import java.io.Serializable;

/**
 * ������
 */

public class clsDepartmentTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3194862227913542209L;
	private String deptId;
	private String deptName;
	private String tel;
	private String fax;
	private String layer;//���Ų��
	private String orderNO;//�ڱ���ε�����
	private String parentDept;//�ϼ�����
	private String function;//ְ��
	private String leader;//�쵼
	
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getLayer() {
		return layer;
	}
	public void setLayer(String layer) {
		this.layer = layer;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getOrderNO() {
		return orderNO;
	}
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}
	public String getParentDept() {
		return parentDept;
	}
	public void setParentDept(String parentDept) {
		this.parentDept = parentDept;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
