package com.ninemax.nacao.to.workflow;

/**
 * 用户待办事件
 */

public class clsUserToDoTO {

	
	private String id;
	private String userId;
	private String flowRunId;
	private String nodeId;
	private String addDate;
	private String operId;
	private String nextOperId;
	private String operType;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlowRunId() {
		return flowRunId;
	}
	public void setFlowRunId(String flowRunId) {
		this.flowRunId = flowRunId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getAddDate() {
		return addDate;
	}
	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	
	public String getNextOperId() {
		return nextOperId;
	}
	public void setNextOperId(String nextOperId) {
		this.nextOperId = nextOperId;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	
	
	
	
	
	
	
	
	
}
