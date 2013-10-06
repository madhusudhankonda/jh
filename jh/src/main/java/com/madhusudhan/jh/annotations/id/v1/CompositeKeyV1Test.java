/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.annotations.id.v1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class CompositeKeyV1Test {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("annotations/hibernate.cfg.xml");
        config.addAnnotatedClass(Course.class);
//        config.addAnnotatedClass(CoursePK.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Course course = new Course();
        
        CoursePK coursePk = new CoursePK();
        coursePk.setTitle("Computer Science");
        coursePk.setTutor("Prof. Harry Barry");
        
        course.setId(coursePk);
        course.setTotalStudents(20);
        course.setRegisteredStudents(12);
        
        session.save(course);

        session.getTransaction().commit();
        System.out.println("Done");
    }
    
    public static void main(String[] args) {
        CompositeKeyV1Test p = new CompositeKeyV1Test();
        p.init();
        p.persist();
    }
}
