package org.springdot.ogm.eval;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springdot.ogm.eval.entities.MyContainer;
import org.springdot.ogm.eval.entities.MyResource;
import org.springdot.ogm.eval.entities.MyRoot;

import java.util.Collection;

public class Main{

    private static SessionFactory factory;
	
    public static void main(String[] args){
        System.setProperty("username", "admin");
        System.setProperty("password", "admin");
        factory = new SessionFactory(MyResource.class.getPackage().getName());

        create();
        read();
    }

    private static void create(){
        Session session = factory.openSession("http://localhost:7474");

        MyRoot r = new MyRoot(mkTree("", 1));
        System.out.println("r="+r);
        session.save(r);
    }

    private static void read(){
        Session session = factory.openSession("http://localhost:7474");

        Collection<MyRoot> roots = session.loadAll(MyRoot.class,10);
        for (MyRoot root : roots){
            System.out.println("* "+root);
        }
    }

    private static MyResource mkTree(String prefix, int depth){
        MyContainer c = new MyContainer();
        c.child = new MyResource().setName("additionalChild");
        c.setName("container");
        c.getChildren().add(new MyResource().setName(prefix+".1"));
        c.getChildren().add(new MyResource().setName(prefix+".2"));
        c.getChildren().add(new MyResource().setName(prefix+".3"));
        if (depth > 1){
            c.getChildren().add(mkTree(prefix+".4", --depth).setName(prefix+".4"));
        }
        return c;
    }
}
