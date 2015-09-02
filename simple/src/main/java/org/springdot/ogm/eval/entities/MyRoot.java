package org.springdot.ogm.eval.entities;

public class MyRoot extends MyEntity{

    public MyResource resource;

    public MyRoot(){
    }

    public MyRoot(MyResource resource){
        this.resource = resource;
    }

    @Override
    public String toString(){
        return "MyRoot{"+(resource == null? "null" : resource)+'}';
    }
}
