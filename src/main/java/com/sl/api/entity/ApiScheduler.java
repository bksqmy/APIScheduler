package com.sl.api.entity;

import java.util.Date;

/**
 * 任务调度类
 * @author gaoxueyong
 */
public class ApiScheduler {

    private String jobName;//` VARCHAR (128) NOT NULL COMMENT '调用算法地址的头部',
    private String triggerName;//` VARCHAR (128) NOT NULL COMMENT '登录名',
    private String jobGroupName;//` VARCHAR (128) NOT NULL COMMENT '用户id',
    private String triggerGroupName;//` VARCHAR (128) NOT NULL COMMENT '用户ak',
    private String corn;//NOT NULL COMMENT 'corn表达式'
    private String isVaild;//` VARCHAR (1) NOT NULL DEFAULT '1' COMMENT '是否有效 1 有效  0无效',
    private String classPath;//` VARCHAR (1) NOT NULL COMMENT '类路径',
    private String isRestart;//` VARCHAR (1) NOT NULL DEFAULT '1' COMMENT '是否重启该任务 1 重启  0不重启',
    private Date lastRunTime;//最新一次运行时间
    private Date restartRime;//重启时间

    public String getJobName() {
        return jobName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public String getIsVaild() {
        return isVaild;
    }

    public String getClassPath() {
        return classPath;
    }

    public String getIsRestart() {
        return isRestart;
    }


    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public void setIsVaild(String isVaild) {
        this.isVaild = isVaild;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    public void setIsRestart(String isRestart) {
        this.isRestart = isRestart;
    }

    public String getCorn() {
        return corn;
    }

    public void setCorn(String corn) {
        this.corn = corn;
    }

    public Date getLastRunTime() {
        return lastRunTime;
    }

    public Date getRestartRime() {
        return restartRime;
    }

    public void setLastRunTime(Date lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    public void setRestartRime(Date restartRime) {
        this.restartRime = restartRime;
    }
}
