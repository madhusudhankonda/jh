/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import javax.persistence.Entity;

/**
 *
 * @author mkonda
 */
@Entity(name = "INHERITANCE_S3_EXECUTIVE_ANN")
public class Executive extends Person {

    private double bonus = 0.0;

    public Executive() {
    }

    public Executive(String name) {
        setName(name);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
