package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.impl.EmpDaoMockImpl;

//@Component
@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class AppConfig {

	@Bean
	public EmpDao mock3() {
		return new EmpDaoMockImpl();
	}
	
	@Bean
	public EmpDao mock4(String s) {
		System.out.println("mock4-2");
		return new EmpDaoMockImpl();
	}
	
	//@Bean
	public EmpDao mock4() {
		System.out.println("mock4-1");
		return new EmpDaoMockImpl();
	}
	
	@Bean
	public String hi() {
		return "hi";
	}
	
}
