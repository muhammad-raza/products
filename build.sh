#!/bin/sh
# ----------------------------------------------------------------------------
#
# Wrapper script to start the maven build for this project
#
# (c) Muhammad Raza, 2015
#
MAVEN_HOME=`pwd`/maven
exec ${MAVEN_HOME}/bin/mvn $*