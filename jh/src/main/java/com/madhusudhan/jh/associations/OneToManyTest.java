/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations;

import com.madhusudhan.jh.associations.one2many.Actor;
import com.madhusudhan.jh.associations.one2many.Movie;
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
public class OneToManyTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("associations/one2many/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Movie movie = createMovie();
        session.save(movie);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    private Movie createMovie() {
        Movie movie = null;
        Actor actor = null;

        Set<Actor> actors = new HashSet<Actor>();

        movie = new Movie("Chennai Express");

        actor = new Actor("Sharukh", "Khan", "King Khan");
        actors.add(actor);
        actor = new Actor("Deepika", "Padukone", "Miss Chennai");
        actors.add(actor);

        movie.setActors(actors);

        return movie;
    }

    public static void main(String[] args) {
        OneToManyTest p = new OneToManyTest();
        p.init();
        p.persist();
    }
}
