/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.hql;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author mkonda
 */
@Entity(name = "TRAVEL_REVIEW")
@NamedQueries(
     value = {
    @NamedQuery(name = "GET_TRAVEL_REVIEWS", query = "from com.madhusudhan.jh.hql.TravelReview"),
    @NamedQuery(name = "GET_TRAVEL_REVIEWS_FOR_TITLE", query = "from com.madhusudhan.jh.hql.TravelReview where id=:title")})
public class TravelReview implements Serializable {

    @Id
    @Column(name = "REVIEW_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String review = null;
    private String title = null;

    public TravelReview() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TravelReview{" + "id=" + id + ", title=" + title + ", review=" + review + '}';
    }
}
