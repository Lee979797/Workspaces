package com.ninemax.nacao.to.workflow;

/**
 * 工作流程，在定义阶段使用
 */

public class clsFlowTO {

	/**
	 * 流程属性，０未审核，１审核通过，2挂起，3运行中,-1 已删除
	 */

	private String status;

	private String flowName;

	private String flowCateId;

	private String flowId;
	
	private String Originators;//流程发起人
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
