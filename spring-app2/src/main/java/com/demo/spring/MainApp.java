package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("context.xml");
		
		EmpService service=ctx.getBean(EmpService.class);
		
		System.out.println(service.registerEmp(201, "Ankit", "Delhi", 90000));

	}

}
