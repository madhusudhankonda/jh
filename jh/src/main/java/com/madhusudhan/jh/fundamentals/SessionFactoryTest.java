package com.madhusudhan.jh.fundamentals;

import static org.junit.Assert.assertNotNull;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SessionFactoryTest {

	private Configuration config = null;

	private SessionFactory sessionFactory = null;

	@Before
	public void setUp() throws Exception {
		config = new Configuration().configure("hibernate-javadb-config.xml");
		

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	@After
	public void tearDown() throws Exception {
		config = null;
		sessionFactory.close();
	}

	@Test
	// @Ignore
	public void test() {
		
		assertNotNull(sessionFactory);
		
		assertNotNull(sessionFactory.getCurrentSession());
		
	}

}
