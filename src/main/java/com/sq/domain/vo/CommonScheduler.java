package com.sq.domain.vo;

import org.quartz.impl.triggers.CronTriggerImpl;

import lombok.Data;

@Data
public class CommonScheduler {
	
	private CronTriggerImpl triggers;
	
	private String GroupName;
	
	private String jobName;
	
	private String des;
}
