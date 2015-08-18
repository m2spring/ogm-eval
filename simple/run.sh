#!/bin/bash

PRJ="$(cd `dirname $0` && pwd)"

$JAVA_HOME/bin/java \
    -classpath $PRJ/target/classes:`cat $PRJ/target/classpath` \
    org.springdot.ogm.eval.Main \
    $@
