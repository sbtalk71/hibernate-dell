package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Emp;

@Repository
//@Transactional
public class EmpDaoJPAImpl implements EmpDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public String save(Emp e) {
		em.persist(e);
		return "saved";
	}

	@Override
	public List<Emp> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emp findById(int id) {
		Emp e= em.find(Emp.class, id);
		return e;
	}

}
