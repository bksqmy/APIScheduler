package com.sl.api;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * 城市大脑任务调度
 */
public class MyJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        
        try {
            System.out.println(new Date()+">>>>>>>>>");
            Thread.sleep(10*1000);
            System.out.println(new Date()+"啦啦啦啦啦啦");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
