package com.demo.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

//@Component
@Service
public class EmpService implements ApplicationContextAware {

	ApplicationContext ctx;
	
	@Autowired
	@Qualifier("empDaoMockImpl2")
	
	private EmpDao dao;

	
	public void setDao(EmpDao dao) {
		System.out.println("Setter for Dao called..");
		this.dao = dao;
	}

	public String registerEmp(int id, String name, String city, double sal) {
		System.out.println("App Context is "+ctx.getDisplayName());
		System.out.println(dao.getClass().getName());
		String response = dao.save(new Emp(id, name, city, sal));
		return response;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx=applicationContext;
		
	}
}
