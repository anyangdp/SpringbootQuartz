package com.sq;

import java.util.Arrays;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
public class Application {
	
	@Autowired
	public DataSource dataSource;
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setDataSource(dataSource);
		schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
		schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
		return schedulerFactoryBean;
	}
	
    
    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        try {
            ClasspathResourceLoader cploder = 
            		new ClasspathResourceLoader(Application.class.getClassLoader(), "templates/");

            beetlGroupUtilConfiguration.setResourceLoader(cploder);
            return beetlGroupUtilConfiguration;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 
    @Bean
    public ContentNegotiatingViewResolver contentViewResolver(
    		@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) throws Exception {
        ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
        contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);

        //bttel template
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        beetlSpringViewResolver.setSuffix(".html");

        MappingJackson2JsonView defaultView = new MappingJackson2JsonView();
        defaultView.setExtractValueFromSingleKeyModel(true);

        ContentNegotiatingViewResolver contentViewResolver = new ContentNegotiatingViewResolver();
        contentViewResolver.setContentNegotiationManager(contentNegotiationManager.getObject());
        contentViewResolver.setViewResolvers(Arrays.<ViewResolver>asList(beetlSpringViewResolver));
        contentViewResolver.setDefaultViews(Arrays.<View>asList(defaultView));
        return contentViewResolver;
    }

	
}
