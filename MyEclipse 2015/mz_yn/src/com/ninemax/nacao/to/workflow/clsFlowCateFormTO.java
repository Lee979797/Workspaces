package com.ninemax.nacao.to.workflow;

public class clsFlowCateFormTO {

	private String flowRunId;
	private String paramName;
	private String paramValue;
	private String operId;//每次提交都产生一个操作编号
	private String userId;


	public String getFlowRunId() {
		return flowRunId;
	}

	public void setFlowRunId(String flowRunId) {
		this.flowRunId = flowRunId;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getOperId() {
		return operId;
	}

	public void setOperId(String operId) {
		this.operId = operId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	


	
	
}
