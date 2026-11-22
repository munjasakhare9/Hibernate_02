package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.model.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			Employee e = new Employee();
			e.setName("Rahul");
			e.setDesignation("HR");
			e.setSalary(9900.60);

			session.save(e);

			tx.commit();

			System.out.println("Student added successfully!");
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
