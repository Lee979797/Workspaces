package com.ninemax.nacao.to.workflow;
public class clsNodesRunTO {

	
	/**
	 * ����ʱ����״̬������ʼ�������������С������������
	 */
	
	private String status;
	private String nodeId;
	private String flowId;
	private String nodeRunId;
	private String flowRunId;
	private String lsh;//��ˮ��

	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getFlowRunId() {
		return flowRunId;
	}
	public void setFlowRunId(String flowRunId) {
		this.flowRunId = flowRunId;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeRunId() {
		return nodeRunId;
	}
	public void setNodeRunId(String nodeRunId) {
		this.nodeRunId = nodeRunId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}
	
	
	
	
}
