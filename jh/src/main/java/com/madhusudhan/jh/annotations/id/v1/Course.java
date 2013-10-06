/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.annotations.id.v1;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author mkonda
 */
@Entity (name="COURSE_ANNOTATION")
public class Course {
 
    @Id
    private CoursePK id = null;
    
    private int totalStudents = 0;
    
    private int registeredStudents = 0;

    public CoursePK getId() {
        return id;
    }

    public void setId(CoursePK id) {
        this.id = id;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
 
}
