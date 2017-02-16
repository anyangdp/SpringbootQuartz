package com.sq.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sq.domain.QrtzTrigger;
import com.sq.domain.UserLogin;
import com.sq.domain.vo.QrtzTriggerVo;
import com.sq.service.ScheduleService;
import com.sq.service.UserInterface;

@Controller
public class MenuController {
	
	@Resource(name = "schedulerFactoryBean")
	Scheduler scheduler; 
	
	@Resource
	ScheduleService scheduleInterface;
	
	@Resource
	UserInterface userService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/")  
    public String toLogin(){  
       return "login";
    }
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String account, String pwd) throws Exception {
		
		UserLogin user = userService.queryUser(account, pwd);
		if (null == user) {
			return "用户名或者密码错误";
		}
		session.setAttribute("isLogin", true);
		return null;
	}
	
	@RequestMapping("/logout")
	public String logout() throws Exception {
		session.invalidate();
		return "login";
	}
	
	
	@RequestMapping("/schedulerManage")
	public String toSchedulerManage(QrtzTrigger qrtzTrigger) throws Exception {
		boolean isLogin = (boolean) session.getAttribute("isLogin");
		if (isLogin) {
			List<QrtzTriggerVo> qrtzTriggers = scheduleInterface.queryJobList(null);
			session.setAttribute("qrtzTriggers", qrtzTriggers);
		}
		return "schedulerManage";
	}
	
	@RequestMapping("/testBeetl")
	public String toTestBeel(Map<String, Object> model) throws Exception {
		model.put("time", new Date());
		model.put("message", "Hello Spring Boot Beetl!");
		return "testBeetl";
	}
	
}
