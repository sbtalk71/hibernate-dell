package com.demo.hibernate.client;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class CriteriaQueryJoin {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaQuery<Dept> cq=cb.createQuery(Dept.class);
			Root<Dept> dept=cq.from(Dept.class);
			
			
			Join<Dept, Emp> joinData=dept.join("emps");
			
			session.createQuery(cq).getResultList();
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();

		}finally {
			session.close();
			sf.close();
		}

	}

}
