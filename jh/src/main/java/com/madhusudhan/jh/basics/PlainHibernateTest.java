package com.madhusudhan.jh.basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.madhusudhan.jh.domain.DomainUtil;
import com.madhusudhan.jh.domain.Movie;

public class PlainHibernateTest {

	private SessionFactory sessionFactory = null;

	private ServiceRegistry serviceRegistry = null;

	private Configuration config = null;

	private void initDefault() {

		config = new Configuration().configure();

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);

		System.out.println("Obtained: " + sessionFactory);

	}

	private void initWithResource(String hibConfig) {

		config = new Configuration().configure(hibConfig);

		sessionFactory = config.buildSessionFactory();

		System.out.println("Obtained: " + sessionFactory);

	}

	private void initWithServiceRegistry() {

		config = new Configuration().configure();

		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();

		sessionFactory = config.buildSessionFactory(serviceRegistry);

	}

	private void persist() {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
//                Movie m = DomainUtil.createNewMovie();
//		session.save(m);
                Movie m = (Movie) session.load(Movie.class, 225);
//                session.save(m);
                Movie m1 = new Movie();
                m1.setId(m.getId());
                m1.setDirector("DDD");
                m1.setTitle("DDD");
	
                session.flush();
//		session.getTransaction().commit();

		System.out.println("Movie persisted");
	}

	public static void main(String[] args) {
		PlainHibernateTest test = new PlainHibernateTest();
//		test.initWithResource("hibernate-javadb-config.xml");
                test.initDefault();
		// test.initWithServiceRegistry();
		test.persist();

	}

}
