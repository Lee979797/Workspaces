package com.ninemax.nacao.to.workflow;

/**
 * ����������ʵ��
 */

public class clsFlowRunTO {

	
	
	private String flowCateId;//
	private String flowId;
	private String flowRunId;
	private String runningNodeId;//��ǰ���еĲ���
	private String status;//����ʵ��״̬��0 running,1 ����
	private String title;//����
	private String description;//�а����  ˵��
	private String readers;//��ʱ���� �����ˣ������ö��Ÿ���
	private String attachments;//��ʱ���� ����
	private String attachmentsDes;//��ʱ���� ����˵��
    private String originator;//������
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
