/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.set;

import java.util.Set;

/**
 *
 * @author mkonda
 */
public class Showroom {

    private int id = 0;
    private String manager = null;
    private String location = null;
    private Set<Car> cars = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Showroom{" + "id=" + id + ", manager=" + manager + ", location=" + location + ", cars=" + cars + '}';
    }
    
}
