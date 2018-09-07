package com.sl.api.dao;

import com.sl.api.entity.ApiScheduler;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  任务调度Mapper
 *  @author gaoxueyong
 */
@Mapper
@Component(value = "apiSchedulerMapper")
public interface ApiSchedulerMapper {

    /**
     * 获取可用的的算法列表
     * @return
     */
    List<ApiScheduler> getSchedulerList();

    /**
     * 根据 jobName 更新是否重启标识
     * @param jobName
     */
    void updateRestartTime(@Param("jobName") String jobName);

    /**
     * 更新最后运行时间
     * @param jobName
     */
    void updateLastRunTime(@Param("jobName") String jobName);
}
