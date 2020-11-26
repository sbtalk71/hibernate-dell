package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpDaoJdbcImpl;
import com.demo.spring.entity.Emp;

public class JdbcInsertDemo2 {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcAppConfig.class);

		EmpDao dao = ctx.getBean(EmpDaoJdbcImpl.class);

		// System.out.println(dao.save(new Emp(301, "Chatur", "Mumbai", 65000)));

		//dao.listAll().stream().forEach(e -> System.out.println(e.getEmpName() + " " + e.getSalary()));
		
		Emp e=dao.findById(1077);
		System.out.println(e.getEmpName()+" "+e.getSalary());
	}

}
