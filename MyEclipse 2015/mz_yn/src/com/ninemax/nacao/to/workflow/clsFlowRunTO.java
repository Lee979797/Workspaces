package com.ninemax.nacao.to.workflow;

/**
 * 工作流流程实例
 */

public class clsFlowRunTO {

	
	
	private String flowCateId;//
	private String flowId;
	private String flowRunId;
	private String runningNodeId;//当前运行的步骤
	private String status;//流程实例状态，0 running,1 结束
	private String title;//标题
	private String description;//承办意见  说明
	private String readers;//暂时不用 送阅人，多人用逗号隔开
	private String attachments;//暂时不用 附件
	private String attachmentsDes;//暂时不用 附件说明
    private String originator;//发起人
    private String addTime;
    private String modTime;
	

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public String getAttachmentsDes() {
		return attachmentsDes;
	}

	public void setAttachmentsDes(String attachmentsDes) {
		this.attachmentsDes = attachmentsDes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public String getFlowRunId() {
		return flowRunId;
	}

	public void setFlowRunId(String flowRunId) {
		this.flowRunId = flowRunId;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getReaders() {
		return readers;
	}

	public void setReaders(String readers) {
		this.readers = readers;
	}

	public String getRunningNodeId() {
		return runningNodeId;
	}

	public void setRunningNodeId(String runningNodeId) {
		this.runningNodeId = runningNodeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getModTime() {
		return modTime;
	}

	public void setModTime(String modTime) {
		this.modTime = modTime;
	}
	
	
}
