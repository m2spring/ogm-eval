package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

public class MyContext extends MyEntity{
    private int id;

    @Relationship(type="HAS_MEMBER", direction = Relationship.OUTGOING)
    private Set<MyRoot> members = new HashSet<>();

    public MyContext(){
    }

    public MyContext(int id){
        this.id = id;
    }

    public Set<MyRoot> getMembers(){
        return members;
    }

    public void setMembers(Set<MyRoot> members){
        this.members = members;
    }
}
