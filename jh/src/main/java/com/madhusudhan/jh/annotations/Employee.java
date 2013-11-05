/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

/**
 *
 * @author mkonda
 */
@Entity(name = "TBL_EMPLOYEE")
public class Employee {
    @Id
    @Column(name="ID", nullable = false, unique=true)
//    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator="empSeqGen")
//    @SequenceGenerator(name = "empSeqGen", sequenceName = "EMP_SEQ_GEN")
    @GeneratedValue (strategy= GenerationType.TABLE, generator="empTableGen")
    @TableGenerator(name = "empTableGen", table = "EMP_ID_TABLE")

    private int empoyeeId =0;

    
    public int getEmpoyeeId() {
        return empoyeeId;
    }

    public void setEmpoyeeId(int empoyeeId) {
        this.empoyeeId = empoyeeId;
    }
    private String name = null;

    public Employee() {
    }

    public Employee(String name) {
        setName(name);
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
}
