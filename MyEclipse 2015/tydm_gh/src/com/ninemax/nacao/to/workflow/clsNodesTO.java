package com.ninemax.nacao.to.workflow;

/**
 * 工作流节点
 */

public class clsNodesTO {

	
	
	
	
	/**
	 * 驳回节点（步骤）
	 */
	
	private String rejectNode;
	
	private String parentNode;	
	/**
	 * 步骤属性；１会签，所有经办人都同意后才能到下一步骤，２混合，只要有一个经办同意就可以了
	 */
	private String nodeProperty;
	private String flowId;
	/**
	 * 步骤序号，即节点执行的顺序
	 */
	private int nodeOrder;
	private String nodeName;
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
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public int getNodeOrder() {
		return nodeOrder;
	}
	public void setNodeOrder(int nodeOrder) {
		this.nodeOrder = nodeOrder;
	}
	public String getNodeProperty() {
		return nodeProperty;
	}
	public void setNodeProperty(String nodeProperty) {
		this.nodeProperty = nodeProperty;
	}
	public String getParentNode() {
		return parentNode;
	}
	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}
	public String getRejectNode() {
		return rejectNode;
	}
	public void setRejectNode(String rejectNode) {
		this.rejectNode = rejectNode;
	}
	
	
}
