package com.sl.api.service;

import com.sl.api.dao.ApiCategoryMapper;
import com.sl.api.dao.ApiSchedulerMapper;
import com.sl.api.entity.ApiCategory;
import com.sl.api.entity.ApiScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * ApiService
 * gaoxueyong
 */
@Service
public class ApiService {

    @Autowired
    private ApiCategoryMapper apiCategoryMapper;

    @Autowired
    private ApiSchedulerMapper apiSchedulerMapper;



    /**
     * 获取可用的算法种类列表
     * @param  jobName 任务名称
     * @return
     */
    public List<ApiCategory> getApiCategoryList(String jobName) {
        return  apiCategoryMapper.getApiCategoryList(jobName);
    }

    /**
     * 获取任务列表
     * @return
     */
    public List<ApiScheduler> getSchedulerList(){
        return apiSchedulerMapper.getSchedulerList();
    }

    /**
     * 更新重启标识以及重启时间
     * @param jobName
     */
    public void updateRestartTime(String jobName){
        apiSchedulerMapper.updateRestartTime(jobName);
    }


    /**
     * 更新最后运行时间
     * @param jobName
     */
    public void updateLastRunTime(String jobName){
        apiSchedulerMapper.updateLastRunTime(jobName);
    }

}
