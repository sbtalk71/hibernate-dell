package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.support.DaoSupport;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpDaoJPAImpl;
import com.demo.spring.entity.Emp;

public class SpringJpaMain {

	public static void main(String[] args) {
	
		ApplicationContext ctx= new AnnotationConfigApplicationContext(JpaAppConfig.class);

			
		EmpDao dao=(EmpDao)ctx.getBean("empDaoJPAImpl");
		
		System.out.println(dao.getClass().getName());
		//dao.save(new Emp(401, "Achal", "Bangalore", 65000));
	}

}
