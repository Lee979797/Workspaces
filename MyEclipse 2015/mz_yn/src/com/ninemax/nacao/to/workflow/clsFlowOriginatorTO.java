package com.ninemax.nacao.to.workflow;

/**
 * 流程发起人
 */

public class clsFlowOriginatorTO {

	private String userId;
	private String flowId;
	private String flowCateId;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
