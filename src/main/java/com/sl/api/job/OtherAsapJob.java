package com.sl.api.job;

import com.sl.api.service.ApiService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 他算法调用
 * @author gaoxueyong
 */
public class OtherAsapJob implements Job{
    private final Logger log = LoggerFactory.getLogger(OtherAsapJob.class);
    @Autowired
    private ApiService apiService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String jobName = jobDataMap.get("jobName").toString();
        log.info("job " +jobName+" is start");

        try {
            System.out.println("job "+jobName+">>>>>>>>>>>"+new Date());
            //do something
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //更新最后一次运行的时间
        apiService.updateLastRunTime(jobName);
        log.info("job " +jobName+" is end");
    }
}
