package org.springdot.ogm.eval.entities;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

public class MyPool extends MyEntity{

    @Relationship(type="DEFINES_POOL", direction=Relationship.INCOMING)
    private MyInstance definingInstance;

    @Relationship(type="POOLED_BY", direction=Relationship.INCOMING)
    private Set<MyInstance> memberInstances;

    public void setDefiningInstance(MyInstance definingInstance){
        this.definingInstance = definingInstance;
    }

    public void addMember(MyInstance instance){
        if (memberInstances == null) memberInstances = new HashSet<>();

        memberInstances.add(instance);
        instance.setManagingPool(this);
    }

    public boolean removeMember(MyInstance instance){
        if (memberInstances != null){
            if (memberInstances.remove(instance)){
                instance.setManagingPool(null);
                return true;
            }
        }
        return false;
    }

    public MyInstance findMember(String name){
        if (memberInstances != null){
            for (MyInstance member : memberInstances){
                if (name.equals(member.getName())) return member;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return "pool #"+getGraphId() +
          " d=" + definingInstance +
          ", members=" + memberInstances;
    }
}
