/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations;

import com.madhusudhan.jh.associations.many2many.Course;
import com.madhusudhan.jh.associations.many2many.Student;
import java.util.HashSet;
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
public class ManyToManyTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("associations/many2many/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Course course = createCoursesAndStudents();
        session.save(course);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    private Course createCoursesAndStudents() {
        Set<Student> students = new HashSet<Student>();
        Course course = null;
        
        Student studentA = new Student("Mike Meyer");
        
        Student studentB = new Student("M Kay");
        students.add(studentA);
        students.add(studentB);
        
        course = new Course("Art of Living");
        course.setStudents(students);
        
        return course;
    }

    public static void main(String[] args) {
        ManyToManyTest p = new ManyToManyTest();
        p.init();
        p.persist();
    }
}
