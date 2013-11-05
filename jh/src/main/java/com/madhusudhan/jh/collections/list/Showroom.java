/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.list;

import java.util.List;

/**
 *
 * @author mkonda
 */
public class Showroom {

    private int id = 0;
    private String manager = null;
    private String location = null;
    private List<Car> cars = null;

    public Showroom(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Showroom{" + "id=" + id + ", manager=" + manager + ", location=" + location + ", cars=" + cars + '}';
    }
}
