/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations;

import com.madhusudhan.jh.associations.one2one.Car;
import com.madhusudhan.jh.associations.one2one.Engine;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class OneToOneTest {

    private SessionFactory factoryV1 = null;
    private SessionFactory factoryV2 = null;

    private void initV1() {
        Configuration config = new Configuration().configure("associations/one2one/v1/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factoryV1 = config.buildSessionFactory(registry);
    }

    private void initV2() {
        Configuration config = new Configuration().configure("associations/one2one/v2/hibernate.cfg.xml");
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        factoryV2 = config.buildSessionFactory(registry);
    }

    private void persistV1() {
        Session session = factoryV1.getCurrentSession();
        session.beginTransaction();

        Engine e = new Engine();
        e.setMake("V8 Series");
        e.setModel("DTS");
        e.setSize("1.6 V8 GAS");

        Car car = new Car();
        car.setId(1);
        car.setName("Cadillac ATS Sedan");
        car.setColor("White");

        car.setEngine(e);
        e.setCar(car);

        session.save(car);
        session.save(e);
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void persistV2() {
        Session session = factoryV2.getCurrentSession();

        session.beginTransaction();
        
        List<Car> cars = createCars(10);

        for (Car car : cars) {
            session.save(car);
        }
        session.getTransaction().commit();
        System.out.println("V2 Done");
    }

    private void v1() {
        initV1();
        persistV1();
    }

    private void v2() {
        initV2();
        persistV2();
    }

    private List<Car> createCars(int numberOfCars) {
        Car car = null;
        Engine engine = null;

        List<Car> cars = new ArrayList<Car>();

        for (int i = 1; i < numberOfCars; i++) {
            engine = new Engine();
            engine.setId(100+i);
            engine.setMake("V8 Series " + i);
            engine.setModel("DTS -" + i + 5);
            engine.setSize("1.6 V8 GAS" + i + 2);

            car = new Car();
            car.setId(i);
            car.setName("Cadillac ATS Sedan " + i);
            car.setColor("White");
            car.setEngine(engine);

            cars.add(car);
        }

        return cars;
    }

    public static void main(String[] args) {
        OneToOneTest p = new OneToOneTest();
//        p.v1();
        p.v2();
    }
}
