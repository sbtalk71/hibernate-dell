package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class App2 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Dept dept=session.load(Dept.class, 20);
			
			Emp e1=new Emp(214, "Ratan", "Ranchi", 56000);
			Emp e2=new Emp(215 ,"Rajesh", "Bangalore", 66000);
			
			e1.setDept(dept);	
			e2.setDept(dept);
			session.save(e1);
			session.save(e2);
			
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();

		}

	}

}
