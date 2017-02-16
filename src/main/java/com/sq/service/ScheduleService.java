package com.sq.service;

import java.util.List;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;

import com.sq.domain.QrtzTrigger;
import com.sq.domain.QrtzTriggerPK;
import com.sq.domain.vo.QrtzTriggerVo;

public interface ScheduleService {
	
	List<QrtzTriggerVo> queryJobList(QrtzTrigger qrtzTrigger) throws Exception;
	
	void addJob(Scheduler scheduler, String jobName, String cronExpression, String groupName, String triggerName, String des) throws Exception;
	
	void startJob(Scheduler scheduler) throws Exception;
	
	void removeJob(Scheduler scheduler,String triggerName, String triggerGroup) throws Exception;
	
	String editJob(Scheduler scheduler, QrtzTriggerVo qrtzTriggerVo) throws Exception;
	
	void stopJob(Scheduler scheduler,String jobName, String groupName) throws Exception;
	
	void shutdownSchedule(Scheduler scheduler) throws Exception;
}
