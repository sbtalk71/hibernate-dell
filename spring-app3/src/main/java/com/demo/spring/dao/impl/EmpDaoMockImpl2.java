package com.demo.spring.dao.impl;

import org.springframework.stereotype.Repository;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoMockImpl2 implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "Mock2: Emp saved with id "+e.getEmpId();
	}

}
