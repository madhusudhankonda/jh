/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.one2many.bi;

import java.util.Random;

/**
 *
 * @author mkonda
 */
public class Actor {

    private int id = 0;
    private String firstName = null;
    private String lastName = null;
    private String shortName = null;
    //We want to know the movie this actor belongs to!
    private Movie movie = null;

    public Actor(Movie movie, String firstName, String secondName, String shortName) {
        setId(new Random().nextInt(100));
        setMovie(movie);
        setFirstName(firstName);
        setLastName(secondName);
        setShortName(shortName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
