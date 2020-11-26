package com.demo.hibernate.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Employee;
import com.demo.hibernate.Person;
import com.demo.hibernate.TraineeEmp;

public class App1 {

	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Person person=new Person();
			person.setName("Arun");
			
			session.save(person);
			
			Employee emp= new Employee();
			emp.setName("Karan");
			emp.setSalary(56000);
			
			session.save(emp);
			
			TraineeEmp te=new TraineeEmp();
			te.setName("Chandra");
			te.setSalary(45000);
			te.setPerformance("good");
			
			session.save(te);

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
