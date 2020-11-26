package com.demo.jpa.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class JPAMain1 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mydb");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			Dept dept = em.find(Dept.class, 20);
			Emp emp = new Emp(211, "Scott", "bangalore", 89000);
			emp.setDept(dept);
			em.persist(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
			emf.close();
		}

	}

}
