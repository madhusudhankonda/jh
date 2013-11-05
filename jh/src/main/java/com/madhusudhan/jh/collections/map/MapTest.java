/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class MapTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("collections/map/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void persistMaps() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Cherry Flurry");
        Map<String, Car> cars = new HashMap<String, Car>();

        cars.put("barry", new Car("Toyota", "Racing Green"));
        cars.put("larry", new Car("Nissan", "White"));
        cars.put("harry", new Car("BMW", "Black"));
        cars.put("fairy", new Car("Mercedes", "Pink"));

        showroom.setCars(cars);

        session.save(showroom);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveMaps() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        List list = session.createQuery("from com.madhusudhan.jh.collections.map.Showroom").list();

        for (Object object : list) {
            System.out.println("Map items: " + object);
        }
        session.getTransaction().commit();
        System.out.println("Done");

    }

    public static void main(String[] args) {
        MapTest test = new MapTest();
        test.init();
        test.persistMaps();
        test.retrieveMaps();
    }
}
