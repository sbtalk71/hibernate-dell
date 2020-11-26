package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Person;

public class App2 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		//Transaction tx = session.beginTransaction();

		try {
			Person t1 = session.get(Person.class, 18);
			System.out.println(t1.getName()+" "+t1.getId());//+" "+t1.getPerformance()+" "+t1.getSalary());

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
