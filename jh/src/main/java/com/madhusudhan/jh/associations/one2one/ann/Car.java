/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.one2one.ann;

import com.madhusudhan.jh.associations.one2one.Engine;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="CAR_ONE2ONE_ANN")
public class Car {
    @Id
    @Column(name="CAR_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name = null;
    
    private String color = null;
    
    @OneToOne (cascade= CascadeType.ALL)
    @JoinColumn(name="ENGINE_ID")
    private Engine engine = null;

    public Car(){
        
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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    
}
