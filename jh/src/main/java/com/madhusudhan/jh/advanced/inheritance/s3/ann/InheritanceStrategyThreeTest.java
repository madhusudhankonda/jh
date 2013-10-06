/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class InheritanceStrategyThreeTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("advanced/inheritance/s3/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void test() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Employee emp = new Employee("Barry Bumbles");
        emp.setId(4);
//        session.save(emp);

        Executive ex = new Executive("Harry Dumbles");
        ex.setId(4);
        ex.setBonus(10);
        
          session.save(emp);
        session.save(ex);
        
        session.getTransaction().commit();

        System.out.println("Done");
    }


    public static void main(String[] args) {
        InheritanceStrategyThreeTest test = new InheritanceStrategyThreeTest();
        test.init();
        test.test();
    }
}
