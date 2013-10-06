package com.madhusudhan.jh.fundamentals;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Class that demonstratest the Hibernate's configuration capabilities
 *
 * @author mkonda
 *
 */
public class ConfigurationTest {

    /**
     * Tests for simple configuration which looks for either
     * hibernate.properties or hibernate.cfg.xml in classpath.
     */
    public void testVanillaConfiguration() {

        Configuration configuration = new Configuration().configure();

        configuration.configure();

        System.out.println("Configuration: "
                + configuration.configure().toString());
    }

    public void testProgrammaticConfiguration() {

        Configuration configuration = new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/JH")
                .setProperty("hibernate.connection.dialect", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.username", "mkonda")
                .setProperty("hibernate.connection.password", "password")
                .addResource("Movie.hbm.xml");
        
        
        System.out.println("Programmatic Configuration: "
                + configuration.configure().toString());
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        
       SessionFactory sf =  configuration.buildSessionFactory(reg);
       
       Session s = sf.getCurrentSession();
      
        System.out.println("Session: "+s.toString());
    }

    public void testCusomConfiguration() {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");

        System.out.println("Configuration: "
                + configuration.configure().toString());
    }

    public void testCusomConfigurationWithMapping(String configXmlNoMapping) {

        Configuration configuration = new Configuration();
//        configuration.addFile("/src/main/resources/Movie.hbm.xml");
//        configuration.addFile("classpath:Movie.hbm.xml");
        System.out.println("Configuration with Mapping: "
                + configuration.configure(configXmlNoMapping).toString());


//        configuration.addClass(com.madhusudhan.jh.domain.Movie.class);
    }

    public static void main(String[] args) {
        ConfigurationTest test = new ConfigurationTest();
//        test.testVanillaConfiguration();
//        test.testCusomConfiguration();
//        String configXmlNoMappingFile = "hibernate-nomapping-config.xml";
//        test.testCusomConfigurationWithMapping(configXmlNoMappingFile);
        
        test.testProgrammaticConfiguration();
    }
}
