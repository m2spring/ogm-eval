#!/bin/bash

PRJ="$(cd `dirname $0` && pwd)"

n=100
for ((i=0; i<100; i++)); do
    $JAVA_HOME/bin/java \
        -classpath $PRJ/target/classes:`cat $PRJ/target/classpath` \
        org.springdot.ogm.eval.Main \
        $n 2>&1 | egrep -v 'INFO|WARN|^$'
done
