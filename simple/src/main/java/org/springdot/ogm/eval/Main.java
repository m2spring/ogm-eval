package org.springdot.ogm.eval;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springdot.ogm.eval.entities.MyContainer;
import org.springdot.ogm.eval.entities.MyContext;
import org.springdot.ogm.eval.entities.MyResource;
import org.springdot.ogm.eval.entities.MyRoot;

import java.util.Collection;

public class Main{

    private final static int NOF_CONTEXTS = 10;
    private static MyContext[] contexts = new MyContext[NOF_CONTEXTS];

    private static SessionFactory factory;
    private static int nofInstances;
	
    public static void main(String[] args){
        nofInstances = 1;
        if (args.length > 0){
            nofInstances = Integer.parseInt(args[0]);
        }

        System.setProperty("username", "admin");
        System.setProperty("password", "admin");
        factory = new SessionFactory(MyResource.class.getPackage().getName());

        create();
        read();
    }

    private static void create(){
        Session session = factory.openSession("http://localhost:7474");

        for (int i=0; i<NOF_CONTEXTS; i++){
            contexts[i] = new MyContext(i);
            session.save(contexts[i]);
        }

        long t0 = System.currentTimeMillis();
        for (int i=0; i<nofInstances; i++){
            MyContext context = contexts[i % NOF_CONTEXTS];
            MyRoot root = new MyRoot(mkTree("", 1));

            root.setContext(context);
            context.getMembers().add(root);

//            System.out.print("\r"+i); System.out.flush();
            session.save(root);
        }
        long t = System.currentTimeMillis()-t0;
        System.out.println("\rcreated "+nofInstances+" in "+t+"ms");
    }

    private static void read(){
        Session session = factory.openSession("http://localhost:7474");

        long t0 = System.currentTimeMillis();
        Collection<MyRoot> roots = session.loadAll(MyRoot.class,10);
        long t = System.currentTimeMillis()-t0;
        System.out.println("read "+roots.size()+" instances in "+t+"ms, "
          +(String.format("%.1f",((double)t)/(double)roots.size()))+"ms/instance");
    }

    private static MyResource mkTree(String prefix, int depth){
        MyContainer c = new MyContainer();
        c.additionalChild = new MyResource().setName("additionalChild");
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
