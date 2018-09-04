package com.ninemax.nacao.to.workflow;

/**
 * 流程执行步骤经办人；定义流程、步骤阶段使用
 */

public class clsNodeOperatorTO {

	private String nodeId;
	private String userId;
	
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
