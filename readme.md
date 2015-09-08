# Eval of the [Neo4j OGM Library](https://github.com/neo4j/neo4j-ogm)

## build

```
$ mvn clean package
```

## execution prerequisites

* using Neo4j 2.1.7
* having Neo4j running on localhost:7474
* simple app tries to connect with admin/admin

## execution as simple Java app

```
$ simple/run.sh
...
created:
c=children=[MyResource{graphId=null, name='child1'}, MyResource{graphId=null, name='child2'}]

loaded:
c=children=[MyResource{graphId=154, name='child2'}, MyResource{graphId=153, name='child1'}]
```

Make class simple/src/main/java/org/springdot/ogm/eval/entities/MyExtendedResource.java extend from MyResource:
```
package org.springdot.ogm.eval.entities;

public class MyExtendedResource
  extends MyResource
{
}
```

Run again:

```
$ simple/run.sh
...
created:
c=children=[MyResource{graphId=null, name='child1'}, MyResource{graphId=null, name='child2'}]

loaded:
c=children=[]
```

Child are properly persisted, but no longer properly loaded.
Maybe this is a problem in OGM's metadata?
