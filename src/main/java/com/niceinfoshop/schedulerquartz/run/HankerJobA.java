package com.niceinfoshop.schedulerquartz.run;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import lombok.extern.slf4j.Slf4j;


@Slf4j
//@Component

//public class HankerJobA implements Job {
//	@Override
//	public void execute(JobExecutionContext context) throws JobExecutionException {
//		log.info("## Test Job Call!!");
//		//String name = context.getJobDetail().getJobDataMap().get("jobName").toString();
//		//log.info("## Job Name : "+name);
//	}
//}

public class HankerJobA extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("매 시간 실행 될 작업 작성 공간");
    }
}