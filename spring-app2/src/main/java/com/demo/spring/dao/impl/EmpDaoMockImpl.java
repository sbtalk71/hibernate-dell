package com.demo.spring.dao.impl;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

public class EmpDaoMockImpl implements EmpDao {

	@Override
	public String save(Emp e) {
		
		return "Mock: Emp saved with id "+e.getEmpId();
	}

}
