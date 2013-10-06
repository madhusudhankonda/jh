/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mkonda
 */
public class JPATest {

    private EntityManagerFactory factory = null;
    private EntityManager manager = null;
    private void init() {
        factory = Persistence.createEntityManagerFactory("instrument");
        manager = factory.createEntityManager();
        System.out.println("Manager created: "+manager);
    }
    private void test(){
        
    }

    public static void main(String[] args) {
        JPATest test = new JPATest();
        test.init();
    }
}
