package com.ninemax.nacao.to.workflow;

/**
 * �������̣��ڶ���׶�ʹ��
 */

public class clsFlowTO {

	/**
	 * �������ԣ���δ��ˣ������ͨ����2����3������,-1 ��ɾ��
	 */

	private String status;

	private String flowName;

	private String flowCateId;

	private String flowId;
	
	private String Originators;//���̷�����
	private String Originators_name;//

	public String getFlowCateId() {
		return flowCateId;
	}

	public void setFlowCateId(String flowCateId) {
		this.flowCateId = flowCateId;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getFlowName() {
		return flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOriginators() {
		return Originators;
	}

	public void setOriginators(String originators) {
		Originators = originators;
	}

	public String getOriginators_name() {
		return Originators_name;
	}

	public void setOriginators_name(String originators_name) {
		Originators_name = originators_name;
	}
	
	
	
	
}
