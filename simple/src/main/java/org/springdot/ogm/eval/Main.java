package org.springdot.ogm.eval;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springdot.ogm.eval.entities.MyInstance;
import org.springdot.ogm.eval.entities.MyPool;

import java.util.Collection;

public class Main{

    private static SessionFactory factory;
    private static int nofInstances;
	
    public static void main(String[] args){
        nofInstances = 1;
        if (args.length > 0){
            nofInstances = Integer.parseInt(args[0]);
        }

        System.setProperty("username", "admin");
        System.setProperty("password", "admin");
        factory = new SessionFactory(MyPool.class.getPackage().getName());

        MyPool pool = create();

        System.out.println("\n*** created pool");
        print();

        System.out.println("\n*** removing member");
        removeMember("two");

        System.out.println("\n*** pool after member removal");
        print();

    }

    private static MyPool create(){
        Session session = factory.openSession("http://localhost:7474");

        MyPool pool = new MyPool();
        MyInstance defInst = new MyInstance("def");

        pool.setDefiningInstance(defInst);
        defInst.setDefinedPool(pool);

        pool.addMember(new MyInstance("one"));
        pool.addMember(new MyInstance("two"));
        pool.addMember(new MyInstance("three"));

        session.save(pool);

        return pool;
    }

    private static void removeMember(String memberName){
        Session session = factory.openSession("http://localhost:7474");

        Collection<MyPool> pools = session.loadAll(MyPool.class,10);
        for (MyPool pool : pools){
            MyInstance member = pool.findMember(memberName);
            if (member != null){
                if (pool.removeMember(member)){
                    System.out.println("removed "+memberName+" from "+pool);
                    session.save(member);
                    session.save(pool);
                }
            }
        }
    }

    private static void print(){
        Session session = factory.openSession("http://localhost:7474");

        Collection<MyPool> pools = session.loadAll(MyPool.class,10);
        for (MyPool pool : pools){
            System.out.println(pool);
        }
    }
}
