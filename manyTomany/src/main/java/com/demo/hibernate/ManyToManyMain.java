package com.demo.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMain {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Student s1=new Student();
			s1.setStudentName("John");
			Student s2=new Student();
			s2.setStudentName("Harry");
			Student s3=new Student();
			s3.setStudentName("James");
			
			Course c1=new Course();
			c1.setCourseName("Yoga");
			
			Course c2=new Course();
			c2.setCourseName("Meditation");
			
			Course c3=new Course();
			c3.setCourseName("Marketing");
			
			s1.getCourseList().add(c1);
			s1.getCourseList().add(c2);
			
			s2.getCourseList().add(c2);
			s2.getCourseList().add(c3);
			
			s3.getCourseList().add(c1);
			s3.getCourseList().add(c3);
			s3.getCourseList().add(c2);
			
			c1.getStudentList().add(s1);
			c1.getStudentList().add(s3);
			
			c2.getStudentList().add(s1);
			c2.getStudentList().add(s2);
			c2.getStudentList().add(s3);
			
			c3.getStudentList().add(s3);
			
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}

	}

}
