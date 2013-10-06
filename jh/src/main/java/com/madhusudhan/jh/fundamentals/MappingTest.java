/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.fundamentals;

import com.madhusudhan.jh.domain.Movie;
import com.madhusudhan.jh.domain.Trade;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class MappingTest {

    public void testCusomConfigurationWithMapping() {

        Configuration config = new Configuration().configure();
        
//        configuration.addFile("Movie.hbm.xml");
//        configuration.addClass(Movie.class);
//        configuration.addClass(Trade.class);
//        configuration.addFile("classpath:Movie.hbm.xml");
        

//        configuration.addClass(com.madhusudhan.jh.domain.Movie.class);
    }

    public static void main(String[] args) {
        MappingTest test = new MappingTest();
        test.testCusomConfigurationWithMapping();
    }
}
