package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class Resource{

    @GraphId
    private Long graphId;

    @Property
    private String name;

    public Resource(String name){
        this.name = name;
    }

    public Long getGraphId(){
        return graphId;
    }

    public void setGraphId(Long graphId){
        this.graphId = graphId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Resource{" +
          "graphId=" + graphId +
          ", name='" + name + '\'' +
          '}';
    }
}
