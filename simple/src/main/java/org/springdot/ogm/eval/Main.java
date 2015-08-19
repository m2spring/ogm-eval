package org.springdot.ogm.eval;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springdot.ogm.eval.entities.Resource;

import java.util.Collection;

public class Main{
	
    public static void main(String[] args){
        System.setProperty("username", "admin");
        System.setProperty("password", "admin");

        SessionFactory sf = new SessionFactory(Resource.class.getPackage().getName());

        Session session = sf.openSession("http://localhost:7474");

        session.save(new Resource("one"));
        session.save(new Resource("two"));
        session.save(new Resource("three"));

        Collection<Resource> resources = session.loadAll(Resource.class);
        for (Resource resource : resources){
            System.out.println("* "+resource.getName());
        }
    }
}
