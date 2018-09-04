package com.ninemax.nacao.to.workflow;

public class clsFlowRunDescriptionTO {
	
	private String flowRunId;
	private String operId;
	private String Description;
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getFlowRunId() {
		return flowRunId;
	}
	public void setFlowRunId(String flowRunId) {
		this.flowRunId = flowRunId;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	
	

}
