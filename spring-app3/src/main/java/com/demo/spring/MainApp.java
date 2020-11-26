package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpService service=ctx.getBean(EmpService.class);
		
		
		
		System.out.println(service.registerEmp(201, "Ankit", "Delhi", 90000));

	}

}
