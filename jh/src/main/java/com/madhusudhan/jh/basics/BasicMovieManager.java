package com.madhusudhan.jh.basics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.madhusudhan.jh.domain.Movie;

public class BasicMovieManager {

    private SessionFactory sessionFactory = null;

    public BasicMovieManager() {
        init4x();
//        init3x();
    }

    private void init4x() {
        Configuration config = new Configuration().configure();

        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                config.getProperties()).buildServiceRegistry();

        sessionFactory = config.buildSessionFactory(serviceRegistry);

    }

    private void init3x() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    private void persistMovie() {
        Movie movie = new Movie();

        movie.setId(2);
        movie.setDirector("Steven Speilberg");
        movie.setTitle("Jaws");
        movie.setSynopsis("A tale of a white shark!");

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(movie);

        session.getTransaction().commit();
    }

    private void findMovie(int i) {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Movie movie = (Movie) session.load(Movie.class, i);

        System.out.println("Movie:" + movie);

        session.getTransaction().commit();

    }

    private void findAll() {

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        List<Movie> movies = session.createQuery("from Movie").list();

        session.getTransaction().commit();

        System.out.println("All Movies:" + movies);

    }

    public static void main(String[] args) {
        BasicMovieManager movieManager = new BasicMovieManager();

//        movieManager.persistMovie();

        movieManager.findMovie(1);

//        movieManager.findAll();
    }
}