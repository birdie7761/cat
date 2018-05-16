#!/bin/sh

echo "==== starting to build client ===="

mvn clean deploy -DskipTests -pl cat-client -am

echo "==== building client finished ===="