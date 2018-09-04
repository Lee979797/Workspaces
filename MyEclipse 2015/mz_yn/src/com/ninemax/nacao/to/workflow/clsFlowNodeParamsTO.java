package com.ninemax.nacao.to.workflow;

/**
 * 流程各个节点可填写的字段
 */

public class clsFlowNodeParamsTO {


	
	
	private String paramId;
	private String flowId;
	private String nodeId;
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getParamId() {
		return paramId;
	}
	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	
	
}
