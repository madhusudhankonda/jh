/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s1.ann;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;
import javax.persistence.InheritanceType;

/**
 *
 * @author mkonda
 */
@Entity(name="INHERITANCE_S1_EMPLOYEE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn=(name="DISCRIMINATOR" descriminatoryType=DicriminatorType.STRING)
@DiscriminatorValue(value="EMPLOYEE")

public class EmployeeXX {
    
    @Id
    @GeneratedValue
    @Column(name="EMPLOYEE_ID")
    
    private int id = 0;
    private String name = null;
    
    public EmployeeXX(){
    }
    public EmployeeXX(String name){
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
