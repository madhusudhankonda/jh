package com.madhusudhan.jh.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * A utility class to obtain Hibernate sessionfactory
 * 
 * @author mkonda
 * 
 */
public class HibernateSupport {

	// Logger logger = Logger.getLogger(HibernateSupport.class);

	private Session session = null;

	private SessionFactory sessionFactory = null;

	private ServiceRegistry serviceRegistry = null;

	private Configuration config = null;

	public HibernateSupport() {
		info("Initialising with default config file");

		init();
	}

	public HibernateSupport(String configFile) {
		info("Initialising with default config file");

		init(configFile);
	}

	public void init(String hibConfig) {

		config = new Configuration().configure(hibConfig);

		setSessionFactory(config.buildSessionFactory());

	}

	public void init() {

		config = new Configuration().configure();

		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				config.getProperties()).buildServiceRegistry();

		setSessionFactory(config.buildSessionFactory(serviceRegistry));

	}

	public void begin() {
		getSession().beginTransaction();
	}

	public void end() {
		getSession().getTransaction().commit();
	}

	private void info(String string) {
		System.out.println(string);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

}
