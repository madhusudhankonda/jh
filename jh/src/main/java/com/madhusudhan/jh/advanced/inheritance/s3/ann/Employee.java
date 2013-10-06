/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import javax.persistence.Entity;

/**
 *
 * @author mkonda
 */
@Entity(name="INHERITANCE_S3_EMPLOYEE_ANN")
public class Employee extends Person{
    private String role = null;

    public Employee() {
    }

    public Employee(String name){
        setName(name);
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
