package com.niceinfoshop.schedulerquartz.conf;



import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

//import org.quartz.CronScheduleBuilder;
//import org.quartz.JobDataMap;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerException;
//import org.quartz.Trigger;
//import org.quartz.TriggerBuilder;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.niceinfoshop.schedulerquartz.run.HankerJobA;

@Configuration
public class JobSetting {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void start(){
        JobDetail jobDetail = buildJobDetail(HankerJobA.class, new HashMap());

        try{
            scheduler.scheduleJob(jobDetail, buildJobTrigger("0/3 * * * * ?"));
        } catch(SchedulerException e){
            e.printStackTrace();
        }
    }

    public Trigger buildJobTrigger(String scheduleExp){
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp)).build();
    }

    public JobDetail buildJobDetail(Class job, Map params){
    	
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(params);

        return JobBuilder.newJob(job).usingJobData(jobDataMap).build();
    }
}