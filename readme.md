# Eval of the [Neo4j OGM Library](https://github.com/neo4j/neo4j-ogm)

This seems to be the same problem as stackoverflow [Neo4j OGM how to delete relationship](http://stackoverflow.com/questions/35391230/neo4j-ogm-how-to-delete-relationship).

Problem is actually fixed with OGM 1.1.6.

## build

```
$ mvn clean package
```

## execution prerequisites

* using Neo4j 2.3.2
* having Neo4j running on localhost:7474
* simple app tries to connect with admin/admin

## execution as simple Java app

```
$ simple/run.sh
...
*** created pool
pool #0 members=[one, two, three]

*** removing member
removed two from pool #0 members=[one, three]

*** pool after member removal
pool #0 members=[two, three, one]
```
