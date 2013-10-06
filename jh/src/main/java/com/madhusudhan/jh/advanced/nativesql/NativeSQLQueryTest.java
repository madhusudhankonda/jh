/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.nativesql;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class NativeSQLQueryTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("advanced/nativesql/hibernate.cfg.xml");

        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void test() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        SQLQuery query = session.createSQLQuery("select * from NATIVESQL_EMPLOYEE");
        List employees = query.list();
        for (Object e : employees) {
            System.out.println("Employee: "+e);
        }
        
        session.getTransaction().commit();

        System.out.println("Done");

    }

    public static void main(String[] args) {
        NativeSQLQueryTest test = new NativeSQLQueryTest();
        test.init();
        test.test();
    }
}
