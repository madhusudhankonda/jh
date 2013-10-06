/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.annotations.id.v2;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 *
 * @author mkonda
 */
@Entity(name = "COURSE_ANNOTATION_V2")
public class Course2 {

    @EmbeddedId
    private CoursePK2 id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public Course2() {
    }

    public Course2(String title, String tutor) {
        id = new CoursePK2();
        id.setTitle(title);
        id.setTutor(tutor);
    }

    public CoursePK2 getId() {
        return id;
    }

    public void setId(CoursePK2 id) {
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
