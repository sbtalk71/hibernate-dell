package com.demo.spring.dao.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

///@Component
@Repository
//@Primary
public class EmpDaoMockImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "Mock: Emp saved with id "+e.getEmpId();
	}

}
