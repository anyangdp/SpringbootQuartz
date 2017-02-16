package com.sq.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.TriggerKey;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.stereotype.Service;

import com.sq.dao.QrtzCronTriggersDao;
import com.sq.dao.QrtzTriggerDao;
import com.sq.domain.QrtzCronTrigger;
import com.sq.domain.QrtzCronTriggerPK;
import com.sq.domain.QrtzTrigger;
import com.sq.domain.vo.QrtzTriggerVo;
import com.sq.operation.job.CommonJob;
import com.sq.service.ScheduleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {
	
	@Resource
	QrtzTriggerDao qrtzTriggerDao;
	
	@Resource
	QrtzCronTriggersDao cronTriggersDao;
	
	@Override
	public void startJob(Scheduler scheduler) throws Exception {
		JobKey jobKey = new JobKey("job1", "group1");
		JobDetail detail = scheduler.getJobDetail(jobKey);
		scheduler.resumeJob(jobKey);
		/*TriggerKey triggerKey = new TriggerKey("job1Trigger", "group1");
		scheduler.resumeTrigger(triggerKey);*/
	}

	@Override
	public void removeJob(Scheduler scheduler,String triggerName, String triggerGroup) throws Exception {
		TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroup);
		scheduler.unscheduleJob(triggerKey);
	}

	@SuppressWarnings("static-access")
	@Override
	public void addJob(Scheduler scheduler, String jobName, String cronExpression, String groupName, String triggerName, String des) throws Exception {
		CronTriggerImpl trigger = new CronTriggerImpl();
		trigger.setCronExpression(cronExpression);
		trigger.setName(triggerName);
		trigger.setGroup(groupName);
		trigger.setMisfireInstruction(trigger.MISFIRE_INSTRUCTION_DO_NOTHING);
		trigger.setDescription(des);
		JobDetail job = JobBuilder.newJob(CommonJob.class).withIdentity(jobName, groupName).withDescription(des).build();
		scheduler.scheduleJob(job, trigger);
	}
	

	@Override
	public String editJob(Scheduler scheduler, QrtzTriggerVo qrtzTriggerVo) throws Exception {
		TriggerKey OldTriggerKey = new TriggerKey(qrtzTriggerVo.getOriginTriggerName(), qrtzTriggerVo.getOriginTiggerGroup());
		CronTriggerImpl newTrigger = new CronTriggerImpl();
		newTrigger.setCronExpression(qrtzTriggerVo.getCron());
		newTrigger.setJobKey(new JobKey(qrtzTriggerVo.getJobName(), qrtzTriggerVo.getJobGroup()));
		newTrigger.setName(qrtzTriggerVo.getTriggerName());
		newTrigger.setGroup(qrtzTriggerVo.getTriggerGroup());
		newTrigger.setDescription(qrtzTriggerVo.getDes());
		
		if (!scheduler.checkExists(OldTriggerKey)){
			return "任务不存在！修改失败";
		}
		
		try {
			scheduler.rescheduleJob(OldTriggerKey, newTrigger);
		} catch (Exception e) {
			return "修改失败";
		}
		return null;
	}
	
	@Override
	public List<QrtzTriggerVo> queryJobList(QrtzTrigger qrtzTrigger) throws Exception {
		List<QrtzTriggerVo> qrtzTriggerVos = new ArrayList<>();
		List<QrtzTrigger> qtList = qrtzTriggerDao.findAll();
		qtList.forEach(qt -> {
			QrtzTriggerVo qv = new QrtzTriggerVo(qt);
			QrtzCronTriggerPK qtPk = new QrtzCronTriggerPK();
			qtPk.setSchedName(qt.getId().getSchedName());
			qtPk.setTriggerGroup(qt.getId().getTriggerGroup());
			qtPk.setTriggerName(qt.getId().getTriggerName());
			QrtzCronTrigger cronTrigger = cronTriggersDao.findById(qtPk);
			qv.setCron(cronTrigger.getCronExpression());
			qrtzTriggerVos.add(qv);
		});
		return qrtzTriggerVos;
	}

	@Override
	public void shutdownSchedule(Scheduler scheduler) throws Exception {
		scheduler.shutdown();
		log.info("停止任务");
	}
	
	@Override
	public void stopJob(Scheduler scheduler,String jobName, String groupName) throws Exception {
		JobKey jobKey = new JobKey(jobName, groupName);
		scheduler.pauseJob(jobKey);
		
		//scheduler.deleteJob(jobKey);
//		TriggerKey triggerKey = new TriggerKey(jobName, groupName);
//		scheduler.unscheduleJob(triggerKey);
		 /*scheduler.pauseTrigger(triggerKey);*/
		log.info("停止任务");
	}

}
