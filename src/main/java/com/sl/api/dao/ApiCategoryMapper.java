package com.sl.api.dao;

import com.sl.api.entity.ApiCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  算法类别Mapper
 *  @author gaoxueyong
 */
@Mapper
@Component(value = "apiCategoryMapper")
public interface ApiCategoryMapper {

    /**
     * 获取可用的算法种类列表
     * @param  jobName 任务名称
     * @return
     */
    List<ApiCategory> getApiCategoryList(@Param("jobName") String jobName);
}
