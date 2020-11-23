package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Address;
import com.demo.hibernate.Emp;

public class App3 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Emp.class);
		cfg.configure();
	
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Emp emp= new Emp(120, "Karan", "Bangalore", 65000);
			emp.getImages().add("profile1.jpg");
			emp.getImages().add("profile2.jpg");
			emp.getImages().add("profile3.jpg");
			emp.getImages().add("profile4.jpg");
			
			Address addr1=new Address("1007", "street1", "400081");
			emp.setAddress(addr1);
			
			session.save(emp);
			//session.flush();
			
			tx.commit();
		} catch (HibernateException e) {

			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sf.close();
		}

	}

}
