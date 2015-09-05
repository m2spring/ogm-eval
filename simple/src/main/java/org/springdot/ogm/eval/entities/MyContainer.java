package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

public class MyContainer extends MyResource{

    @Relationship(type="HAS_CHILD", direction = Relationship.OUTGOING)
    private List<MyResource> children = new ArrayList<>();

    public MyResource child;

    public List<MyResource> getChildren(){
        return children;
    }

    @Override
    public String toString(){
        return "child="+child+" children="+children;
    }
}
