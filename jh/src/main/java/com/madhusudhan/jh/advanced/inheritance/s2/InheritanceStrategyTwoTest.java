/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class InheritanceStrategyTwoTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("advanced/inheritance/s2/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void test() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Employee emp = new Employee("Barry Bumbles");

        session.save(emp);

        Executive ex = new Executive("Harry Dumbles");
        ex.setRole("Director");
        
        session.save(ex);
        session.getTransaction().commit();

        System.out.println("Done");
    }


    public static void main(String[] args) {
        InheritanceStrategyTwoTest test = new InheritanceStrategyTwoTest();
        test.init();
        test.test();
    }
}
