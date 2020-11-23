package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Emp;

public class App2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Emp.class);
		cfg.configure();
	
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		//Transaction tx = session.beginTransaction();
		
		try {
			Emp e1=session.load(Emp.class,1077);
			
			System.out.println(e1.getClass().getName());
			
		System.out.println(e1.getEmpName()+" "+e1.getSalary());
			
			//tx.commit();
		} catch (HibernateException e) {

			//tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
