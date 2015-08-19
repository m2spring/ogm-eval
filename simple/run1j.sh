#!/bin/bash

PRJ="$(cd `dirname $0` && pwd)"

$JAVA_HOME/bin/java \
    -jar $PRJ/target/simple-*-SNAPSHOT.one-jar.jar \
    $args
