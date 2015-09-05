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
$ simple/single-child-in-children.sh
...
c=additionalChild=MyResource{graphId=null, name='anotherChild'} children=[MyResource{graphId=null, name='child1'}, MyResource{graphId=null, name='child2'}]

loaded:
c=additionalChild=MyResource{graphId=95, name='anotherChild'} children=[MyResource{graphId=95, name='anotherChild'}, MyResource{graphId=97, name='child2'}, MyResource{graphId=96, name='child1'}]
```
