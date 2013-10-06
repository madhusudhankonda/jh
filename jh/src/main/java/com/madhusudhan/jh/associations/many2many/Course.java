/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.many2many;

import java.util.Set;

/**
 *
 * @author mkonda
 */
public class Course {
    private int id = 0;
    private String title = null;
    private Set<Student> students = null;

    public Course(String title){
        setTitle(title);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
