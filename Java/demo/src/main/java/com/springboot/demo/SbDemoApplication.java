package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.springboot.demo.filter.LoggingFilter2;

@SpringBootApplication
@EntityScan("com.springboot.demo.*")
public class SbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbDemoApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<LoggingFilter2> loggingFilter() {
	      
		FilterRegistrationBean<LoggingFilter2> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new LoggingFilter2());
		registrationBean.addUrlPatterns("/entity1/*");
		registrationBean.setOrder(3);
		return registrationBean;
	}

}
