package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.Relationship;

public class MyResource extends MyEntity{

    @Relationship(type="HAS_CHILD", direction = Relationship.INCOMING)
    private MyContainer parent;

    private String name;

    public MyResource(){
    }

    public MyResource(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public MyResource setName(String name){
        this.name = name;
        return this;
    }

    @Override
    public String toString(){
        return "MyResource{" +
          "graphId=" + getGraphId() +
          ", name='" + name + '\'' +
          '}';
    }
}
