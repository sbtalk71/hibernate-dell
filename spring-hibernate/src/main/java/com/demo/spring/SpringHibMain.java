package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.support.DaoSupport;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.dao.EmpDaoHibImpl;
import com.demo.spring.entity.Emp;

public class SpringHibMain {

	public static void main(String[] args) {
	
		ApplicationContext ctx= new AnnotationConfigApplicationContext(HibAppConfig.class);

			
		EmpDao dao=(EmpDao)ctx.getBean("empDaoHibImpl");
		
		System.out.println(dao.getClass().getName());
		dao.save(new Emp(402, "Nandi", "Bangalore", 65000));
	}

}
