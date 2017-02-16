package com.sq.operation;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpMethod;

public class TestSchedule implements Job{
	private RequestData requestData = new RequestData();
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		Object obj = requestData.requestApiDataForPojo("", HttpMethod.GET, new Object[]{},
				Object.class);
	}

}
