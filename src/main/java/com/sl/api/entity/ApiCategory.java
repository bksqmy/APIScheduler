package com.sl.api.entity;

/**
 *  算法类别
 *  @author gaoxueyong
 */
public class ApiCategory {
    private Integer id;

    private String categoryCode;//算法code
    private String categoryName;//算法名称
    private String isVaild;// '是否有效 1 有效  0无效'
    private Long workOrder;// 执行顺序
    private String config;//配置参数 参考 api-config表 config字段
    private String jobName;//任务调度名称

    public Integer getId() {
        return id;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getIsVaild() {
        return isVaild;
    }

    public Long getWorkOrder() {
        return workOrder;
    }

    public String getConfig() {
        return config;
    }

    public String getJobName() {
        return jobName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setIsVaild(String isVaild) {
        this.isVaild = isVaild;
    }

    public void setWorkOrder(Long workOrder) {
        this.workOrder = workOrder;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
