package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.Relationship;

public class MyInstance extends MyEntity{
    private String name;

    @Relationship(type="DEFINES_POOL", direction=Relationship.OUTGOING)
    private MyPool definedPool;

    @Relationship(type="POOLED_BY", direction=Relationship.OUTGOING)
    private MyPool managingPool;

    public MyInstance(){
    }

    public MyInstance(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDefinedPool(MyPool definedPool){
        this.definedPool = definedPool;
    }

    public void setManagingPool(MyPool managingPool){
        this.managingPool = managingPool;
    }

    @Override
    public String toString(){
        return name;
    }
}
