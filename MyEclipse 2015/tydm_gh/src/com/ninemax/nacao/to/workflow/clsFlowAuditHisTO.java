package com.ninemax.nacao.to.workflow;

/**
 * 流程审批历史记录
 */

public class clsFlowAuditHisTO {

	/**
	 * 审批时间
	 */
	
	private String auditingDate;

	/**
	 * 审批人
	 */
	
	private String auditingUser;
	
	/**
	 * 审批意见
	 */
	
	private String opinion;
	
	/**
	 * 审批时的状态
	 */
	
	private String status;
	private String flowId;
}
