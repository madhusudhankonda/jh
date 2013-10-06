/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s2.ann;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author mkonda
 */
@Entity(name="INHERITANCE_S2_EXECUTIVE_ANN")
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")

public class Executive extends Employee{
    private String role = null;
    
    public Executive(String name){
        super(name);
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
