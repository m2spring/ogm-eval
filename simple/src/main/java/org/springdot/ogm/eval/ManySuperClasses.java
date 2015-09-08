package org.springdot.ogm.eval;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springdot.ogm.eval.entities.MyContainer;
import org.springdot.ogm.eval.entities.MyResource;

import java.util.Collection;

public class ManySuperClasses{

    private static SessionFactory factory;

    public static void main(String[] args){
        System.setProperty("username", "admin");
        System.setProperty("password", "admin");
        factory = new SessionFactory(MyResource.class.getPackage().getName());

        create();
        load();
    }

    private static void create(){
        Session session = factory.openSession("http://localhost:7474");

        MyContainer c = new MyContainer();
        c.getChildren().add(new MyResource().setName("child1"));
        c.getChildren().add(new MyResource().setName("child2"));

        System.out.println("\ncreated:");
        System.out.println("c="+c);
        session.save(c);
    }

    private static void load(){
        Session session = factory.openSession("http://localhost:7474");

        System.out.println("\nloaded:");
        Collection<MyContainer> containers = session.loadAll(MyContainer.class,10);
        for (MyContainer c : containers){
            System.out.println("c="+c);
        }
    }
}
