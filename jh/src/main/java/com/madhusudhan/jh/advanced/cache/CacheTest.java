/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class CacheTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("advanced/cache/hibernate.cfg.xml");
//        config.addAnnotatedClass(Person.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void firstLevelCache() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        int personId = 10;

        Person person = new Person();
        person.setId(personId);
        person.setFirstName("Madhusudhan");
        person.setLastName("Konda");
        person.setNickName("MK");

        person = (Person) session.load(Person.class, personId);

        person.setNickName("MK2");

        session.save(person);

        session.getTransaction().commit();

        System.out.println("Done");
    }

    private void firstLevelCacheWithNonUniqueObject() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        int personId = 10;

        Person person = (Person) session.load(Person.class, personId);

        Person newPerson = new Person();
        
        newPerson.setId(personId);
        
        session.save(newPerson);
        session.getTransaction().commit();

        System.out.println("Done");
    }

    public static void main(String[] args) {
        CacheTest test = new CacheTest();
        test.init();
        test.firstLevelCache();
    }
}
