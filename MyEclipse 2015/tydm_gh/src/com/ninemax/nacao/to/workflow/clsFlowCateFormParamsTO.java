package com.ninemax.nacao.to.workflow;

/**
 * ������𣭣��������Թ����ࣻ���������̲������д�ֶδ�����ȡ��
 */

public class clsFlowCateFormParamsTO {

	/**
	 * �����������ƣ��������������̲������д�ֶ�ʱ��ʾ
	 */

	private String paramNameCN;

	/**
	 * ����Ӣ�����ƣ�������ҳ��ȥ�����ȳ����õ�
	 */

	private String paramNameEN;

	/**
	 * ���������
	 */

	private String flowCateId;

	private String paramId;

	public String getFlowCateId() {
		return flowCateId;
	}

	public void setFlowCateId(String flowCateId) {
		this.flowCateId = flowCateId;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getParamNameCN() {
		return paramNameCN;
	}

	public void setParamNameCN(String paramNameCN) {
		this.paramNameCN = paramNameCN;
	}

	public String getParamNameEN() {
		return paramNameEN;
	}

	public void setParamNameEN(String paramNameEN) {
		this.paramNameEN = paramNameEN;
	}
	
	
}
