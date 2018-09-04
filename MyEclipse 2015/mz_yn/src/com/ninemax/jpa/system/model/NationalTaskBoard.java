package com.ninemax.jpa.system.model;

/**
 * Created by IntelliJ IDEA.
 * User: zhaoxun
 * Date: 11-1-7
 * Time: ÏÂÎç3:32
 */
public class NationalTaskBoard {

    private String agentName;

    private String taskPatch;

    private String finishPatch;

    private String taskCount;

    private String taskFinishCount;

    private String finishRate;

    public String getFinishRate() {
        return finishRate;
    }

    public void setFinishRate(String finishRate) {
        this.finishRate = finishRate;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getTaskPatch() {
        return taskPatch;
    }

    public void setTaskPatch(String taskPatch) {
        this.taskPatch = taskPatch;
    }

    public String getFinishPatch() {
        return finishPatch;
    }

    public void setFinishPatch(String finishPatch) {
        this.finishPatch = finishPatch;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }

    public String getTaskFinishCount() {
        return taskFinishCount;
    }

    public void setTaskFinishCount(String taskFinishCount) {
        this.taskFinishCount = taskFinishCount;
    }
}
