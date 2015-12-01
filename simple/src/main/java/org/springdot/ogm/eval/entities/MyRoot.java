package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.Relationship;

public class MyRoot extends MyEntity{

    @Relationship(type="HAS_MEMBER", direction = Relationship.INCOMING)
    private MyContext context;

    public MyResource resource;

    public MyRoot(){
    }

    public MyRoot(MyResource resource){
        this.resource = resource;
    }

    public void setContext(MyContext context){
        this.context = context;
    }

    @Override
    public String toString(){
        return "MyRoot{"+(resource == null? "null" : resource)+'}';
    }
}
