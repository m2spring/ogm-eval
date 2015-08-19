# Eval of the [Neo4j OGM Library](https://github.com/neo4j/neo4j-ogm)

## build

```
$ mvn clean package
```

## execution prerequisites

* having Neo4j running on localhost:7474
* simple app tries to connect with admin/admin

## execution

```
$ simple/run.sh
09:41:51.874 [main] INFO  o.n.o.m.info.ClassFileProcessor - Starting Post-processing phase
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building annotation class map
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building interface class map for 2 classes
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Registering default type converters...
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Post-processing complete
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - 2 classes loaded in 13 milliseconds
```
