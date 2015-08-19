# Eval of the [Neo4j OGM Library](https://github.com/neo4j/neo4j-ogm)

## build

```
$ mvn clean package
```

## execution prerequisites

* having Neo4j running on localhost:7474
* simple app tries to connect with admin/admin

## execution as simple Java app

```
$ simple/run.sh
09:41:51.874 [main] INFO  o.n.o.m.info.ClassFileProcessor - Starting Post-processing phase
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building annotation class map
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building interface class map for 2 classes
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Registering default type converters...
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - Post-processing complete
09:41:51.877 [main] INFO  o.n.o.m.info.ClassFileProcessor - 2 classes loaded in 13 milliseconds
```

## execution as [OneJar](http://one-jar.sourceforge.net/) Java app

```
$ simple/run1j.sh
JarClassLoader: Warning: Null manifest from input stream associated with: lib/neo4j-2.2.4.pom
JarClassLoader: Warning: org/neo4j/kernel/impl/ComponentVersion.class in lib/neo4j-browser-2.2.4.jar is hidden by lib/neo4j-kernel-2.2.4.jar (with different bytecode)
15:15:15.928 [main] INFO  o.n.o.m.info.ClassFileProcessor - Starting Post-processing phase
15:15:15.930 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building annotation class map
15:15:15.930 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building interface class map for 0 classes
15:15:15.930 [main] INFO  o.n.o.m.info.ClassFileProcessor - Registering default type converters...
15:15:15.931 [main] INFO  o.n.o.m.info.ClassFileProcessor - Post-processing complete
15:15:15.931 [main] INFO  o.n.o.m.info.ClassFileProcessor - 0 classes loaded in 5 milliseconds
15:15:15.945 [main] INFO  org.neo4j.ogm.session.Neo4jSession - org.springdot.ogm.eval.entities.Resource is not an instance of a persistable class
15:15:15.945 [main] INFO  org.neo4j.ogm.session.Neo4jSession - org.springdot.ogm.eval.entities.Resource is not an instance of a persistable class
15:15:15.945 [main] INFO  org.neo4j.ogm.session.Neo4jSession - org.springdot.ogm.eval.entities.Resource is not an instance of a persistable class
Exception in thread "main" java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.simontuffs.onejar.Boot.run(Boot.java:340)
	at com.simontuffs.onejar.Boot.main(Boot.java:166)
Caused by: java.lang.NullPointerException
	at org.neo4j.ogm.metadata.MetaData.entityType(MetaData.java:186)
	at org.neo4j.ogm.session.Neo4jSession.entityType(Neo4jSession.java:441)
	at org.neo4j.ogm.session.delegates.LoadByTypeDelegate.loadAll(LoadByTypeDelegate.java:55)
	at org.neo4j.ogm.session.delegates.LoadByTypeDelegate.loadAll(LoadByTypeDelegate.java:94)
	at org.neo4j.ogm.session.Neo4jSession.loadAll(Neo4jSession.java:104)
	at org.springdot.ogm.eval.Main.main(Main.java:23)
	... 6 more
```

Assuming we can ignore the JarClassLoader warnings, the problem seems to be that the DomainInfo class is unable to load the entity classes in a OneJar environment.
