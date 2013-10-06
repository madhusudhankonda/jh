/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s1.ann;

import com.madhusudhan.jh.advanced.inheritance.s1.*;
import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;
/**
 *
 * @author mkonda
 */
@Entity
@DiscriminatorValue(value="EXECUTIVE")
public class Executive extends EmployeeXX{
    private String role = null;
    
    public Executive(String name){
        super(name);
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
}
