package com.demo.hibernate.client;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.Emp;

public class CriteriaQuery1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			
			Metamodel m = session.getMetamodel();
			EntityType<Emp> Emp_ = m.entity(Emp.class);
			
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaQuery<Emp> cq=cb.createQuery(Emp.class);
			Root<Emp> from=cq.from(Emp.class);
			//cq.where(cb.between(Emp_.empId, 107, 112));
			
			TypedQuery<Emp> cquery=session.createQuery(cq);
			
			cquery.getResultList().forEach(e->System.out.println(e.getEmpName()));
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();

		}finally {
			session.close();
			sf.close();
		}

	}

}
