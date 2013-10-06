/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.hql;

/**
 *
 * @author mkonda
 */
public class City{

    private String title = null;
    private String description = null;

    public City(String title, String description){
        setTitle(title);
        setDescription(description);
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() { 
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" + "title=" + title + ", description=" + description + '}';
    }

}
