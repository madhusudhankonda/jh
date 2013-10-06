/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s3;

/**
 *
 * @author mkonda
 */
public class Employee extends Person{
    private String role = null;

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
