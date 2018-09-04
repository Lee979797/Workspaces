package com.ninemax.nacao.to.workflow;

/**
 * 工作流流程类别，数据传输、数据模型；在工作流定义阶段使用
 */

public class clsFlowCateTO {

	private String formTableName;
	private String memo;
	private String flowCateName;
	private String flowCateId;
	
	public String getFlowCateId() {
		return flowCateId;
	}
	public void setFlowCateId(String flowCateId) {
		this.flowCateId = flowCateId;
	}
	public String getFlowCateName() {
		return flowCateName;
	}
	public void setFlowCateName(String flowCateName) {
		this.flowCateName = flowCateName;
	}
	public String getFormTableName() {
		return formTableName;
	}
	public void setFormTableName(String formTableName) {
		this.formTableName = formTableName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
