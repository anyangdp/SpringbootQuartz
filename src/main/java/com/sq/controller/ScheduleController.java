package com.sq.controller;

import java.util.List;

import javax.annotation.Resource;

import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sq.domain.QrtzTrigger;
import com.sq.domain.vo.QrtzTriggerVo;
import com.sq.service.ScheduleService;
import com.sq.service.UserInterface;

@RestController
public class ScheduleController {
	@Autowired
	ApplicationContext applicationContext;
	
	@Resource
	UserInterface helloInterface;
	
	@Resource
	ScheduleService scheduleInterface;
	
	@Resource(name = "schedulerFactoryBean")
	Scheduler scheduler; 
	
	@RequestMapping("/queryJob")
	@ResponseBody
	public List<QrtzTriggerVo> queryJob(QrtzTrigger qrtzTrigger) throws Exception {
		return scheduleInterface.queryJobList(qrtzTrigger);
	}
	
	/**
	 * 
	 * @Title: addJob 
	 * @Description: 添加任务 
	 * @author An 
	 * @param @param jobName
	 * @param @param cron
	 * @param @param groupName
	 * @param @param triggerName
	 * @param @param des
	 * @param @return
	 * @param @throws Exception
	 */
	@RequestMapping("/addJob")
	@ResponseBody
	public String addJob(@RequestParam String jobName, @RequestParam String cron, @RequestParam String groupName, 
			@RequestParam String triggerName, @RequestParam String des) throws Exception {
		try {
			scheduleInterface.addJob(scheduler, jobName, cron, groupName, triggerName, des);
		} catch (Exception e) {
			return "任务添加失败";
		}
		return "任务添加成功";
	}
	
	/**
	 * @Title: removeJob 
	 * @Description: 移除任务 
	 * @author An 
	 * @param @param triggerName
	 * @param @param triggerGroup
	 * @param @return
	 * @param @throws Exception
	 */
	@RequestMapping("/removeJob")
	@ResponseBody
	public String removeJob(@RequestParam String triggerName, @RequestParam String triggerGroup) throws Exception {
		try {
			scheduleInterface.removeJob(scheduler, triggerName, triggerGroup);
		} catch (Exception e) {
			return "任务移除失败";
		}
		return "任务移除成功";
	}
	
	/**
	 * @Title: editJob 
	 * @Description: 修改任务 
	 * @author An 
	 * @param @param qrtzTriggerVo
	 * @param @param qrtzTriggerPK
	 * @param @return
	 * @param @throws Exception
	 */
	@RequestMapping("/editJob")
	public String editJob(QrtzTriggerVo qrtzTriggerVo) throws Exception{
		String message = scheduleInterface.editJob(scheduler, qrtzTriggerVo);
		return message;
	}
	
	/**
	 * @Title: isValidExpression 
	 * @Description: 验证表达式 
	 * @author An 
	 * @param @param cronExpression
	 * @param @return
	 * @param @throws Exception
	 */
	@RequestMapping("/validExpression")
	public boolean isValidExpression(String cronExpression) throws Exception {
		return CronExpression.isValidExpression(cronExpression);
	}
	
	@RequestMapping("/stopJob")
	@ResponseBody
	public String stopJob(String jobName, String groupName) throws Exception {
		scheduleInterface.stopJob(scheduler, jobName, groupName);
		return "成功";
	}
	
	@RequestMapping("/reStartJob")
	@ResponseBody
	public String reStartJob() throws Exception {
		scheduleInterface.startJob(scheduler);
		return "成功";
	}
	
	@RequestMapping("/shutdownSchedule")
	@ResponseBody
	public String shutdownSchedule() throws Exception {
		scheduleInterface.shutdownSchedule(scheduler);
		return "成功";
	}
}
