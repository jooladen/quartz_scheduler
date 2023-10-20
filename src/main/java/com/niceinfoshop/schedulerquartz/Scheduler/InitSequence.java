package com.niceinfoshop.schedulerquartz.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.niceinfoshop.schedulerquartz.util.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@Component
public class InitSequence {
	@Autowired
	private CommonUtils util;
	
	private boolean schedulingEnabled = true;
	
	@Scheduled(cron = "0/3 * * * * ?")
    public void initAutoIncrement() {
		if (schedulingEnabled) {
			String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
			util.logStart(new Scheduler(), methodName);
			
			log.info("initAutoIncrement");
			
			util.logEnd(new Scheduler(), methodName);
		}
	}

    public void disableScheduling() {
        schedulingEnabled = false;
    }

    public void enableScheduling() {
        schedulingEnabled = true;
    }
}
