/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s2.ann;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author mkonda
 */
@Entity(name="INHERITANCE_S2_EMPLOYEE_ANN")
@Inheritance(strategy= InheritanceType.JOINED)
public class Employee {
    @Id
    @Column(name="EMPLOYEE_ID")
    private int id = 0;
    private String name = null;

    public Employee(String name){
        setName(name);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
