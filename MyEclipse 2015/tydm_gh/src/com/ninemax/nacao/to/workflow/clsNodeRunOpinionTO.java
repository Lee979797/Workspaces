package com.ninemax.nacao.to.workflow;

/**
 * 流程运行时，每个步骤经办人的意见，同意或打回，还有附件
 */

public class clsNodeRunOpinionTO {

	
	private String attachmentsDes;
	private String attachments;
	private String opinion;//意见　１　同意　２　打回
	private String description;//描述
	private String userId;
	private String operId;//不适用
	private String nodeId;
	private String flowRunId;
	private String addTime;
	private String modTime;
	private String lsh;
	
	public String getLsh() {
		return lsh;
	}
	public void setLsh(String lsh) {
		this.lsh = lsh;
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

	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getModTime() {
		return modTime;
	}
	public void setModTime(String modTime) {
		this.modTime = modTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	
	
}
