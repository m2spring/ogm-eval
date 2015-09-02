package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class MyEntity{

    @GraphId
    private Long graphId;

    public Long getGraphId(){
        return graphId;
    }

    public void setGraphId(Long graphId){
        this.graphId = graphId;
    }
}
