package com.ninemax.jpa.system.model;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 11-1-7
 * Time: 下午6:48
 */
public class TaskInfo {

    private String agentName; //办证地点名称

    private String subAgentName; //机构名称

    private String codeID; //机构代码

    private String status; //数据状态

    private String taskName;//任务名称

    private String beginCodeId;

    private String endCodeId;

    private String taskCount;

    private String finishCount;

    private String finishRate;

    private String updateDate;

    private String taskID;

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public String getSubAgentName() {
        return subAgentName;
    }

    public void setSubAgentName(String subAgentName) {
        this.subAgentName = subAgentName;
    }

    public String getCodeID() {
        return codeID;
    }

    public void setCodeID(String codeID) {
        this.codeID = codeID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getBeginCodeId() {
        return beginCodeId;
    }

    public void setBeginCodeId(String beginCodeId) {
        this.beginCodeId = beginCodeId;
    }

    public String getEndCodeId() {
        return endCodeId;
    }

    public void setEndCodeId(String endCodeId) {
        this.endCodeId = endCodeId;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }

    public String getFinishCount() {
        return finishCount;
    }

    public void setFinishCount(String finishCount) {
        this.finishCount = finishCount;
    }

    public String getFinishRate() {
        return finishRate;
    }

    public void setFinishRate(String finishRate) {
        this.finishRate = finishRate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
