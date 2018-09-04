package com.ninemax.nacao.to.workflow;

/**
 * 流程类别－－类别表单属性关联类；在设置流程步骤可填写字段从这里取；
 */

public class clsFlowCateFormParamsTO {

	/**
	 * 属性中文名称，可以在设置流程步骤可填写字段时显示
	 */

	private String paramNameCN;

	/**
	 * 属性英文名称，可以在页面去参数等场合用到
	 */

	private String paramNameEN;

	/**
	 * 流程类别ｉｄ
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
