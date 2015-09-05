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
created:
c=child=MyResource{graphId=null, name='additionalChild'} children=[MyResource{graphId=null, name='child1'}, MyResource{graphId=null, name='child2'}]

loaded:
c=child=MyResource{graphId=87, name='additionalChild'} children=[MyResource{graphId=87, name='additionalChild'}, MyResource{graphId=89, name='child2'}, MyResource{graphId=88, name='child1'}]
```
