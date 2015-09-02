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

Excerpt:

```
$ simple/run.sh
...
r=MyRoot{children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]}
...
16:52:16.880 [main] DEBUG org.neo4j.ogm.metadata.MetaData - More than one class subclasses org.springdot.ogm.eval.entities.MyEntity
16:52:16.881 [main] DEBUG org.neo4j.ogm.metadata.MetaData - More than one class subclasses org.springdot.ogm.eval.entities.MyEntity
...
* MyRoot{children=[]}
```

With full log:

```
$ simple/run.sh
16:52:16,436 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback.groovy]
16:52:16,437 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Could NOT find resource [logback-test.xml]
16:52:16,437 |-INFO in ch.qos.logback.classic.LoggerContext[default] - Found resource [logback.xml] at [file:/ws/osgi/ogm-eval/simple/target/classes/logback.xml]
16:52:16,438 |-WARN in ch.qos.logback.classic.LoggerContext[default] - Resource [logback.xml] occurs multiple times on the classpath.
16:52:16,438 |-WARN in ch.qos.logback.classic.LoggerContext[default] - Resource [logback.xml] occurs at [file:/ws/osgi/ogm-eval/simple/target/classes/logback.xml]
16:52:16,438 |-WARN in ch.qos.logback.classic.LoggerContext[default] - Resource [logback.xml] occurs at [jar:file:/tmp/.m2/repository/org/neo4j/app/neo4j-server/2.2.4/neo4j-server-2.2.4.jar!/logback.xml]
16:52:16,504 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - debug attribute not set
16:52:16,509 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - About to instantiate appender of type [ch.qos.logback.core.ConsoleAppender]
16:52:16,518 |-INFO in ch.qos.logback.core.joran.action.AppenderAction - Naming appender as [STDOUT]
16:52:16,537 |-INFO in ch.qos.logback.core.joran.action.NestedComplexPropertyIA - Assuming default type [ch.qos.logback.classic.encoder.PatternLayoutEncoder] for [encoder] property
16:52:16,584 |-INFO in ch.qos.logback.classic.joran.action.LoggerAction - Setting level of logger [deng] to DEBUG
16:52:16,584 |-INFO in ch.qos.logback.classic.joran.action.RootLoggerAction - Setting level of ROOT logger to DEBUG
16:52:16,584 |-INFO in ch.qos.logback.core.joran.action.AppenderRefAction - Attaching appender named [STDOUT] to Logger[ROOT]
16:52:16,585 |-INFO in ch.qos.logback.classic.joran.action.ConfigurationAction - End of configuration.
16:52:16,586 |-INFO in ch.qos.logback.classic.joran.JoranConfigurator@ff32798 - Registering current configuration as safe fallback point

16:52:16.593 [main] DEBUG o.n.ogm.metadata.ClassPathScanner - Classpath elements:
16:52:16.595 [main] DEBUG o.n.ogm.metadata.ClassPathScanner - /ws/osgi/ogm-eval/simple/target/classes/org/springdot/ogm/eval/entities
16:52:16.601 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Processing: org.springdot.ogm.eval.entities.MyResource -> org.springdot.ogm.eval.entities.MyEntity
16:52:16.601 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Processing: org.springdot.ogm.eval.entities.MyEntity -> java.lang.Object
16:52:16.602 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Processing: org.springdot.ogm.eval.entities.MyRoot -> org.springdot.ogm.eval.entities.MyEntity
16:52:16.602 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Processing: org.springdot.ogm.eval.entities.MyContainer -> org.springdot.ogm.eval.entities.MyResource
16:52:16.602 [main] INFO  o.n.o.m.info.ClassFileProcessor - Starting Post-processing phase
16:52:16.603 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building annotation class map
16:52:16.603 [main] INFO  o.n.o.m.info.ClassFileProcessor - Building interface class map for 5 classes
16:52:16.603 [main] DEBUG o.n.o.m.info.ClassFileProcessor -  - MyContainer implements 0 interfaces
16:52:16.603 [main] DEBUG o.n.o.m.info.ClassFileProcessor -  - Object implements 0 interfaces
16:52:16.603 [main] DEBUG o.n.o.m.info.ClassFileProcessor -  - MyEntity implements 0 interfaces
16:52:16.603 [main] DEBUG o.n.o.m.info.ClassFileProcessor -  - MyResource implements 0 interfaces
16:52:16.603 [main] DEBUG o.n.o.m.info.ClassFileProcessor -  - MyRoot implements 0 interfaces
16:52:16.603 [main] INFO  o.n.o.m.info.ClassFileProcessor - Registering default type converters...
16:52:16.604 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Could not load class for descriptor (Ljava/lang/String;)Lorg/springdot/ogm/eval/entities/MyResource;
16:52:16.605 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Post-processing: org.springdot.ogm.eval.entities.MyContainer
16:52:16.605 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Post-processing: org.springdot.ogm.eval.entities.MyEntity
16:52:16.605 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Post-processing: org.springdot.ogm.eval.entities.MyResource
16:52:16.605 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Post-processing: org.springdot.ogm.eval.entities.MyRoot
16:52:16.605 [main] DEBUG o.n.o.m.info.ClassFileProcessor - Checking for @Transient classes....
16:52:16.605 [main] INFO  o.n.o.m.info.ClassFileProcessor - Post-processing complete
16:52:16.606 [main] INFO  o.n.o.m.info.ClassFileProcessor - 5 classes loaded in 16 milliseconds
16:52:16.622 [main] DEBUG o.n.o.a.CredentialsService - Using credentials supplied
16:52:16.629 [main] DEBUG o.n.o.a.CredentialsService - Using credentials supplied
r=MyRoot{children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]}
16:52:16.630 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - --------- new request ----------
16:52:16.630 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - getOrCreateTransaction() being called on thread: 1
16:52:16.630 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - Session identity: org.neo4j.ogm.session.delegates.TransactionsDelegate@8a7b551
16:52:16.630 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - There is no existing transaction, creating a transient one
16:52:16.637 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context initialised with 0 relationships
16:52:16.640 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyRoot{children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]}
16:52:16.640 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyRoot{children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]} has changed
16:52:16.640 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyRoot{children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]} 
16:52:16.641 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: RESOURCE
16:52:16.641 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] in one direction
16:52:16.642 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]
16:52:16.642 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] has changed
16:52:16.643 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] 
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity MyResource{graphId=null, name='.1'} in one direction
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyResource{graphId=null, name='.1'}
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyResource{graphId=null, name='.1'} has changed
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyResource{graphId=null, name='.1'} 
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.644 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] and MyResource{graphId=null, name='.1'}
16:52:16.645 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_2)-[_3:HAS_CHILD]->(_4)
16:52:16.645 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity MyResource{graphId=null, name='.2'} in one direction
16:52:16.645 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyResource{graphId=null, name='.2'}
16:52:16.645 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyResource{graphId=null, name='.2'} has changed
16:52:16.645 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyResource{graphId=null, name='.2'} 
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] and MyResource{graphId=null, name='.2'}
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_2)-[_5:HAS_CHILD]->(_6)
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity MyResource{graphId=null, name='.3'} in one direction
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyResource{graphId=null, name='.3'}
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyResource{graphId=null, name='.3'} has changed
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyResource{graphId=null, name='.3'} 
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.646 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] and MyResource{graphId=null, name='.3'}
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_2)-[_7:HAS_CHILD]->(_8)
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}] in one direction
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}] has changed
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}] 
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.647 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity MyResource{graphId=null, name='.4.1'} in one direction
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyResource{graphId=null, name='.4.1'}
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyResource{graphId=null, name='.4.1'} has changed
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyResource{graphId=null, name='.4.1'} 
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}] and MyResource{graphId=null, name='.4.1'}
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_10)-[_11:HAS_CHILD]->(_12)
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity MyResource{graphId=null, name='.4.2'} in one direction
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyResource{graphId=null, name='.4.2'}
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyResource{graphId=null, name='.4.2'} has changed
16:52:16.648 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyResource{graphId=null, name='.4.2'} 
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}] and MyResource{graphId=null, name='.4.2'}
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_10)-[_13:HAS_CHILD]->(_14)
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - linking to entity MyResource{graphId=null, name='.4.3'} in one direction
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - visiting: MyResource{graphId=null, name='.4.3'}
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - MyResource{graphId=null, name='.4.3'} has changed
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping references declared by: MyResource{graphId=null, name='.4.3'} 
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.649 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}] and MyResource{graphId=null, name='.4.3'}
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_10)-[_15:HAS_CHILD]->(_16)
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]] and children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_2)-[_9:HAS_CHILD]->(_10)
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - mapping reference type: HAS_CHILD
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - trying to map relationship between MyRoot{children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]} and children=[MyResource{graphId=null, name='.1'}, MyResource{graphId=null, name='.2'}, MyResource{graphId=null, name='.3'}, children=[MyResource{graphId=null, name='.4.1'}, MyResource{graphId=null, name='.4.2'}, MyResource{graphId=null, name='.4.3'}]]
16:52:16.650 [main] DEBUG o.neo4j.ogm.mapper.EntityGraphMapper - context-new: (_0)-[_1:RESOURCE]->(_2)
16:52:16.697 [main] DEBUG o.n.o.s.r.SessionRequestHandler - {"statements":[{"statement":"CREATE (_0:`MyRoot`:`MyEntity`), (_10:`MyContainer`:`MyResource`:`MyEntity`{_10_props}), (_12:`MyResource`:`MyEntity`{_12_props}), (_14:`MyResource`:`MyEntity`{_14_props}), (_16:`MyResource`:`MyEntity`{_16_props}), (_2:`MyContainer`:`MyResource`:`MyEntity`{_2_props}), (_4:`MyResource`:`MyEntity`{_4_props}), (_6:`MyResource`:`MyEntity`{_6_props}), (_8:`MyResource`:`MyEntity`{_8_props}) WITH _0,_10,_12,_14,_16,_2,_4,_6,_8 MERGE (_0)-[_1:`RESOURCE`]->(_2) WITH _0,_1,_10,_12,_14,_16,_2,_4,_6,_8 MERGE (_10)-[_11:`HAS_CHILD`]->(_12) WITH _0,_1,_10,_11,_12,_14,_16,_2,_4,_6,_8 MERGE (_10)-[_13:`HAS_CHILD`]->(_14) WITH _0,_1,_10,_11,_12,_13,_14,_16,_2,_4,_6,_8 MERGE (_10)-[_15:`HAS_CHILD`]->(_16) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_4,_6,_8 MERGE (_2)-[_3:`HAS_CHILD`]->(_4) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_3,_4,_6,_8 MERGE (_2)-[_5:`HAS_CHILD`]->(_6) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_3,_4,_5,_6,_8 MERGE (_2)-[_7:`HAS_CHILD`]->(_8) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_3,_4,_5,_6,_7,_8 MERGE (_2)-[_9:`HAS_CHILD`]->(_10) RETURN id(_0) AS _0, id(_1) AS _1, id(_10) AS _10, id(_11) AS _11, id(_12) AS _12, id(_13) AS _13, id(_14) AS _14, id(_15) AS _15, id(_16) AS _16, id(_2) AS _2, id(_3) AS _3, id(_4) AS _4, id(_5) AS _5, id(_6) AS _6, id(_7) AS _7, id(_8) AS _8, id(_9) AS _9","parameters":{"_10_props":{"name":".4"},"_4_props":{"name":".1"},"_16_props":{"name":".4.3"},"_6_props":{"name":".2"},"_14_props":{"name":".4.2"},"_8_props":{"name":".3"},"_12_props":{"name":".4.1"},"_2_props":{"name":"container"}},"resultDataContents":["row"],"includeStats":false}]}
16:52:16.697 [main] DEBUG o.n.o.session.request.DefaultRequest - POST http://localhost:7474/db/data/transaction/commit, request: {"statements":[{"statement":"CREATE (_0:`MyRoot`:`MyEntity`), (_10:`MyContainer`:`MyResource`:`MyEntity`{_10_props}), (_12:`MyResource`:`MyEntity`{_12_props}), (_14:`MyResource`:`MyEntity`{_14_props}), (_16:`MyResource`:`MyEntity`{_16_props}), (_2:`MyContainer`:`MyResource`:`MyEntity`{_2_props}), (_4:`MyResource`:`MyEntity`{_4_props}), (_6:`MyResource`:`MyEntity`{_6_props}), (_8:`MyResource`:`MyEntity`{_8_props}) WITH _0,_10,_12,_14,_16,_2,_4,_6,_8 MERGE (_0)-[_1:`RESOURCE`]->(_2) WITH _0,_1,_10,_12,_14,_16,_2,_4,_6,_8 MERGE (_10)-[_11:`HAS_CHILD`]->(_12) WITH _0,_1,_10,_11,_12,_14,_16,_2,_4,_6,_8 MERGE (_10)-[_13:`HAS_CHILD`]->(_14) WITH _0,_1,_10,_11,_12,_13,_14,_16,_2,_4,_6,_8 MERGE (_10)-[_15:`HAS_CHILD`]->(_16) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_4,_6,_8 MERGE (_2)-[_3:`HAS_CHILD`]->(_4) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_3,_4,_6,_8 MERGE (_2)-[_5:`HAS_CHILD`]->(_6) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_3,_4,_5,_6,_8 MERGE (_2)-[_7:`HAS_CHILD`]->(_8) WITH _0,_1,_10,_11,_12,_13,_14,_15,_16,_2,_3,_4,_5,_6,_7,_8 MERGE (_2)-[_9:`HAS_CHILD`]->(_10) RETURN id(_0) AS _0, id(_1) AS _1, id(_10) AS _10, id(_11) AS _11, id(_12) AS _12, id(_13) AS _13, id(_14) AS _14, id(_15) AS _15, id(_16) AS _16, id(_2) AS _2, id(_3) AS _3, id(_4) AS _4, id(_5) AS _5, id(_6) AS _6, id(_7) AS _7, id(_8) AS _8, id(_9) AS _9","parameters":{"_10_props":{"name":".4"},"_4_props":{"name":".1"},"_16_props":{"name":".4.3"},"_6_props":{"name":".2"},"_14_props":{"name":".4.2"},"_8_props":{"name":".3"},"_12_props":{"name":".4.1"},"_2_props":{"name":"container"}},"resultDataContents":["row"],"includeStats":false}]}
16:52:16.810 [main] DEBUG o.n.o.session.request.DefaultRequest - Response is OK, creating response handler
16:52:16.847 [main] DEBUG o.n.o.session.response.JsonResponse - Closing HttpResponse
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - Appending transaction context org.neo4j.ogm.cypher.compiler.CypherContext@7f5a1aca
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - commit invoked
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - Synchronizing transaction context org.neo4j.ogm.cypher.compiler.CypherContext@7f5a1aca with session context
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@477dfc2e
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@5c1a5fa7
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: children=[MyResource{graphId=429, name='.1'}, MyResource{graphId=430, name='.2'}, MyResource{graphId=431, name='.3'}, children=[MyResource{graphId=425, name='.4.1'}, MyResource{graphId=426, name='.4.2'}, MyResource{graphId=427, name='.4.3'}]]
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - remembering children=[MyResource{graphId=429, name='.1'}, MyResource{graphId=430, name='.2'}, MyResource{graphId=431, name='.3'}, children=[MyResource{graphId=425, name='.4.1'}, MyResource{graphId=426, name='.4.2'}, MyResource{graphId=427, name='.4.3'}]]
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyResource{graphId=427, name='.4.3'}
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyResource{graphId=427, name='.4.3'}
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@5713e8d2
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@5925c9a4
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@4a59eead
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyResource{graphId=431, name='.3'}
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyResource{graphId=431, name='.3'}
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyResource{graphId=430, name='.2'}
16:52:16.848 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyResource{graphId=430, name='.2'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyResource{graphId=425, name='.4.1'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyResource{graphId=425, name='.4.1'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: children=[MyResource{graphId=425, name='.4.1'}, MyResource{graphId=426, name='.4.2'}, MyResource{graphId=427, name='.4.3'}]
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - remembering children=[MyResource{graphId=425, name='.4.1'}, MyResource{graphId=426, name='.4.2'}, MyResource{graphId=427, name='.4.3'}]
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyRoot{children=[MyResource{graphId=429, name='.1'}, MyResource{graphId=430, name='.2'}, MyResource{graphId=431, name='.3'}, children=[MyResource{graphId=425, name='.4.1'}, MyResource{graphId=426, name='.4.2'}, MyResource{graphId=427, name='.4.3'}]]}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyRoot{children=[MyResource{graphId=429, name='.1'}, MyResource{graphId=430, name='.2'}, MyResource{graphId=431, name='.3'}, children=[MyResource{graphId=425, name='.4.1'}, MyResource{graphId=426, name='.4.2'}, MyResource{graphId=427, name='.4.3'}]]}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyResource{graphId=429, name='.1'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyResource{graphId=429, name='.1'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@24d4fdf1
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@560286ab
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: org.neo4j.ogm.mapper.TransientRelationship@3d22914a
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - checking cypher context object: MyResource{graphId=426, name='.4.2'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - remembering MyResource{graphId=426, name='.4.2'}
16:52:16.849 [main] DEBUG o.n.o.s.transaction.Transaction - number of objects: 17
16:52:16.849 [main] DEBUG o.n.o.session.response.JsonResponse - Closing HttpResponse
16:52:16.850 [main] DEBUG o.n.o.a.CredentialsService - Using credentials supplied
16:52:16.850 [main] DEBUG o.n.o.a.CredentialsService - Using credentials supplied
16:52:16.850 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - --------- new request ----------
16:52:16.850 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - getOrCreateTransaction() being called on thread: 1
16:52:16.850 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - Session identity: org.neo4j.ogm.session.delegates.TransactionsDelegate@74950517
16:52:16.850 [main] DEBUG org.neo4j.ogm.session.Neo4jSession - There is no existing transaction, creating a transient one
16:52:16.855 [main] DEBUG o.n.o.s.r.SessionRequestHandler - {"statements":[{"statement":"MATCH (n:`MyRoot`) WITH n MATCH p=(n)-[*0..1]-(m) RETURN p","parameters":{},"resultDataContents":["graph"],"includeStats":false}]}
16:52:16.855 [main] DEBUG o.n.o.session.request.DefaultRequest - POST http://localhost:7474/db/data/transaction/commit, request: {"statements":[{"statement":"MATCH (n:`MyRoot`) WITH n MATCH p=(n)-[*0..1]-(m) RETURN p","parameters":{},"resultDataContents":["graph"],"includeStats":false}]}
16:52:16.862 [main] DEBUG o.n.o.session.request.DefaultRequest - Response is OK, creating response handler
16:52:16.880 [main] DEBUG org.neo4j.ogm.metadata.MetaData - More than one class subclasses org.springdot.ogm.eval.entities.MyEntity
16:52:16.881 [main] DEBUG org.neo4j.ogm.metadata.MetaData - More than one class subclasses org.springdot.ogm.eval.entities.MyEntity
16:52:16.884 [main] DEBUG o.n.o.session.response.JsonResponse - Closing HttpResponse
16:52:16.884 [main] DEBUG o.n.o.session.response.JsonResponse - Closing HttpResponse
* MyRoot{children=[]}
```
