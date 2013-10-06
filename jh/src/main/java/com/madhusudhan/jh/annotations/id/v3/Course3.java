/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.annotations.id.v3;

import com.madhusudhan.jh.annotations.id.v2.*;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author mkonda
 */
@IdClass(value = CoursePK3.class)
@Entity(name = "COURSE_ANNOTATION_V3")
public class Course3 {

    @Id
    private String title = null;
    @Id
    private String tutor = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public Course3() {
    }

    Course3(String title, String tutor) {
        setTitle(title);
        setTutor(tutor);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
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
