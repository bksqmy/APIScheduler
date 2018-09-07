package com.sl.api.scheduler;

import com.sl.api.entity.ApiScheduler;
import com.sl.api.quartz.QuartzManager;
import com.sl.api.service.ApiService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoxueyong
 */
@Component
public class APIscheduler {

    private final Logger log = LoggerFactory.getLogger(APIscheduler.class);

    @Autowired
    private ApiService apiService;

    @Autowired
    private QuartzManager quartzManage;


    private String isVaild_yes = "1";
    private String isVaild_no = "0";

    private String isRestart_yes = "1";
    private String isRestart_no = "0";



    // 1000 = 1s
    // 1000 * 60 * 5 = 5min
//    @Scheduled(cron = "0 0/2 * * * ?")
    //每2分钟的第50秒执行
//    @Scheduled(cron = "50 */2 * * * ?")
    @Scheduled(cron = "* * * * * ?")
    public void run() {
//        log.info("The time is now {}", dateFormat.format(new Date()));

//        ===================================算法调用===================================
        List<ApiScheduler> listScheduler = apiService.getSchedulerList();
        for(ApiScheduler api:listScheduler){
            try{

                String state = quartzManage.getJobState(api.getTriggerName(),api.getTriggerGroupName());
    //            log.info(" 任务 "+api.getJobName()+" 的状态为 "+state);
                // NONE(没有该job), NORMAL(正常), PAUSED(暂停), COMPLETE(完成), ERROR(错误), BLOCKED(阻塞)
                //如果任务有效
                if(StringUtils.equals(isVaild_yes,api.getIsVaild())){
                    //如果任务需要重启 修改了corn后需要重启
                    if(StringUtils.equals(api.getIsRestart(),isRestart_yes)){
                        log.info(" 任务 "+api.getJobName()+" 开始重启 ");
                        //需要重启
                        quartzManage.removeJob(api.getJobName(),api.getJobGroupName(),api.getTriggerName(),api.getTriggerGroupName());
                        doJob(api.getClassPath(),api.getJobName(),api.getJobGroupName(),api.getTriggerName(),api.getTriggerGroupName(),api.getCorn());
                        //更新状态
                        apiService.updateRestartTime(api.getJobName());
                    }else{
                        //不需要重启
                        //判断任务是否存在  如果不存在 则添加

                        if(StringUtils.equals(state,"NONE")){
                            log.info(" 任务 "+api.getJobName()+" 开始启动 ");
                            doJob(api.getClassPath(),api.getJobName(),api.getJobGroupName(),api.getTriggerName(),api.getTriggerGroupName(),api.getCorn());
                        }else if(StringUtils.equals(state,"PAUSED")||StringUtils.equals(state,"ERROR")){
                            log.info(" 任务 "+api.getJobName()+" 重新启动 ");
                            quartzManage.removeJob(api.getJobName(),api.getJobGroupName(),api.getTriggerName(),api.getTriggerGroupName());
                            doJob(api.getClassPath(),api.getJobName(),api.getJobGroupName(),api.getTriggerName(),api.getTriggerGroupName(),api.getCorn());
                        }
                    }

                }else {
                    if(!StringUtils.equals(state,"NONE")){
                        log.info(" 任务 "+api.getJobName()+" 移除 ");
                        quartzManage.removeJob(api.getJobName(),api.getJobGroupName(),api.getTriggerName(),api.getTriggerGroupName());
                    }
                }
            }catch (Exception e){
                log.error("任务"+api.getJobName()+"调度出现异常，异常信息为："+e.getMessage());
            }
        }

//        ===================================算法调用===================================
    }

    /**
     * 添加任务调度
     * @param classPath
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupNam
     * @param corn
     * @throws ClassNotFoundException
     */
    public void doJob(String classPath,String jobName,String jobGroupName,String triggerName,String triggerGroupNam,String corn) throws ClassNotFoundException {
        Class<?> jobClass = Class.forName(classPath);
        Map<String,Object> jobMap = new HashMap<>();
        quartzManage.addJob(jobName,jobGroupName,triggerName,triggerGroupNam, jobClass,corn,jobMap);
    }


}
