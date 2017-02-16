package com.sq.operation.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpMethod;

import com.sq.operation.RequestData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonJob implements Job {

	RequestData requestData = new RequestData();
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String method = context.getJobDetail().getKey().getName();
		requestData = new RequestData();
		requestData.requestApiDataForPojo(method, HttpMethod.GET, new Object[]{},
				Object.class);
		log.info(method+"执行---------------");
	}

}
