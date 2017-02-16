package com.sq.domain.vo;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sq.domain.QrtzTrigger;
import com.sq.util.DateUtil;

import lombok.Data;

@Data
public class QrtzTriggerVo {
	private String schedName;
	
	private String triggerName;
	
	private String triggerGroup;
	
	private String jobName;
	
	private String jobGroup;
	
	private String cron;
	
	private String des;
	
	private String prevFireTime;
	
	private String nextFireTime;
	
	private String triggerState;
	
	/*用于修改*/
	private String originTriggerName;
	
	private String originTiggerGroup;
	
	public QrtzTriggerVo() {
	}
	
	public QrtzTriggerVo(QrtzTrigger qrtzTrigger) {
		this.schedName = qrtzTrigger.getId().getSchedName();
		this.triggerName = qrtzTrigger.getId().getTriggerName();
		this.triggerGroup = qrtzTrigger.getId().getTriggerGroup();
		this.jobName = qrtzTrigger.getJobName();
		this.jobGroup = qrtzTrigger.getJobGroup();
		this.des = qrtzTrigger.getDescription();
		Date pftDate = new Date(qrtzTrigger.getPrevFireTime().longValue());
		this.prevFireTime = DateUtil.date86(pftDate);
		Date nftDate = new Date(qrtzTrigger.getNextFireTime().longValue());
		this.nextFireTime = DateUtil.date86(nftDate);
		this.triggerState = qrtzTrigger.getTriggerState();
	}

}
