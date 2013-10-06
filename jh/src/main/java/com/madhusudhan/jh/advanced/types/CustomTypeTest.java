/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.types;

import com.madhusudhan.jh.hql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class CustomTypeTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure("/types/hibernate.cfg.xml");
//        config.addAnnotatedClass(TravelReview.class);
        config.registerTypeOverride(new PhoneNumberType());
        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factory = config.buildSessionFactory(registry);

    }


    public static void main(String[] args) {
        CustomTypeTest test = new CustomTypeTest();
        test.init();
    }
}
