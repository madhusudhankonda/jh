/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.list.ann;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author mkonda
 */
@Entity(name="SHOWROOM_LIST_ANN")
@Table(name="SHOWROOM_LIST_ANN")
public class Showroom {
    @Id
    @Column(name="SHOWROOM_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id = 0;

    private String manager = null;
    private String location = null;
    @OneToMany
    @JoinColumn(name="SHOWROOM_ID")
    @Cascade(CascadeType.ALL)
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
