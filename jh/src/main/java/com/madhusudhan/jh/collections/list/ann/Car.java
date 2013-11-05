/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.list.ann;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity(name="CAR_ANN")
@Table(name="CAR_LIST_ANN")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="CAR_ID")
    private int id;
    private String name = null;
    private String color = null;

    public Car(){
        
    }
    public Car(String name, String color){
        setName(name);
        setColor(color);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", color=" + color + '}';
    }
}
