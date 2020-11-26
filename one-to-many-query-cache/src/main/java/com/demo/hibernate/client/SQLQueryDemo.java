package com.demo.hibernate.client;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.hibernate.Dept;
import com.demo.hibernate.Emp;

public class SQLQueryDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			//Query<Object[]> query = session.createSQLQuery("select name,salary,address from MYEMP");
			
			Query<Object[]> query=session.createNamedQuery("query3");

			List<Object[]> data = query.getResultList();

			for (Object[] obj : data) {
				String name = (String) obj[0];
				Double salary = (Double) obj[1];
				String city = (String) obj[2];
				
				System.out.println(name + " " + salary + " " + city);
			}

		} catch (HibernateException e) {
			// tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
			sf.close();
		}

	}

}
