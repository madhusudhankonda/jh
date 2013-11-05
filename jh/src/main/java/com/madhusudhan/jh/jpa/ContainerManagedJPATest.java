/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.jpa;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mkonda
 */
public class ContainerManagedJPATest {

    @Resource
    private EntityManager manager = null;

    public void persistNewInstrument() {
        Instrument instrument = new Instrument();
        instrument.setIssue("IBM");
        manager.persist(instrument);
    }
    
    public void findInstrument() {
        manager.getReference(Instrument.class,1);
    }

    public void removeInstrument() {
        manager.remove(1);
    }
    public static void main(String[] args) {
        ContainerManagedJPATest test = new ContainerManagedJPATest();
    }
}
