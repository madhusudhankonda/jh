/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class SetTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("collections/set/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void persistSets() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        Set<Car> cars = new HashSet<Car>();
        
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Mercedes", "Silver"));
        cars.add(new Car("Mercedes", "Silver"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveSets(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from com.madhusudhan .jh.collections.set.Showroom").list();
        
        for (Object object : list) {
            System.out.println("** List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    
    public static void main(String[] args) {
        SetTest test = new SetTest();
        test.init();
        test.persistSets();
        test.retrieveSets();
    }
}
