package com.ninemax.nacao.to.workflow;

/**
 * �������ڵ�
 */

public class clsNodesTO {

	
	
	
	
	/**
	 * ���ؽڵ㣨���裩
	 */
	
	private String rejectNode;
	
	private String parentNode;	
	/**
	 * �������ԣ�����ǩ�����о����˶�ͬ�����ܵ���һ���裬����ϣ�ֻҪ��һ������ͬ��Ϳ�����
	 */
	private String nodeProperty;
	private String flowId;
	/**
	 * ������ţ����ڵ�ִ�е�˳��
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
