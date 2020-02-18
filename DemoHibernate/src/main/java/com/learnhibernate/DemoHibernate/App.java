package com.learnhibernate.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryRegistry;
import org.hibernate.service.ServiceRegistry;

public class App  {
    public static void main( String[] args ) {
    	Alien aObject = new Alien();
    	aObject.setAid(102);
    	aObject.setAname("Ashish");
    	aObject.setColor("Green");
    	
    	
    	
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
    
	    ServiceRegistry rf = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).getBootstrapServiceRegistry();
    	SessionFactory sf = con.buildSessionFactory(rf);
    	
    	Session session = sf.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	session.save(aObject);
    	
    	tx.commit();
    	
    	
    }
}
