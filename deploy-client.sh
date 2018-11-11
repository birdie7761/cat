#!/bin/sh

echo "==== starting to build client ===="

mvn clean deploy -DskipTests -pl cat-client -am -P deploy

echo "==== building client finished ===="