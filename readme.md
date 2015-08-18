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
14:55:38.799 [main] INFO  o.n.o.m.info.ClassFileProcessor - Starting Post-processing phase
14:55:38.802 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building annotation class map
14:55:38.802 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building interface class map for 0 classes
14:55:38.802 [main] INFO  o.n.o.m.info.ClassFileProcessor - Registering default type converters...
14:55:38.802 [main] INFO  o.n.o.m.info.ClassFileProcessor - Post-processing complete
14:55:38.802 [main] INFO  o.n.o.m.info.ClassFileProcessor - 0 classes loaded in 6 milliseconds
14:55:38.827 [main] INFO  org.neo4j.ogm.session.Neo4jSession - org.springdot.ogm.eval.entities.Resource is not an instance of a persistable class
14:55:38.827 [main] INFO  org.neo4j.ogm.session.Neo4jSession - org.springdot.ogm.eval.entities.Resource is not an instance of a persistable class
14:55:38.827 [main] INFO  org.neo4j.ogm.session.Neo4jSession - org.springdot.ogm.eval.entities.Resource is not an instance of a persistable class
```
