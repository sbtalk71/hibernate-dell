package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class App1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Dept dept=session.get(Dept.class,20);
			
			dept.setManager("Kiran");
			
			
			tx.commit();
			session.evict(dept);
			Dept dept1=session.get(Dept.class, 20);
				System.out.println(dept1.getManager());
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();

		}finally {
			session.close();
			sf.close();
		}

	}

}
