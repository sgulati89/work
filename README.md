Hazelcast UI APP
=============

Hazelcast UI provided in development version is restricted to two nodes.This APP provides basic capabilites of Hazelcast with no restriction on number of nodes.

Prerequisites
-------------

1. Java 7 or later
2. Apache Tomcat 7.0.40 or later
3. All Hazelcast instances should be JMX enabled(By default port used for jmx is 1010, it can be changed as per requirement)

Deployment Steps
----------------

Build WebServices

1. Checkout the code
2. cd $GIT_CLONE_DIR/HazelcastWebServices
3. update the "etl.cluster.nodes" property in src/main/resources/app-config.properties with list of hazelcast instances (you can create comma separated list of instances if there are more than one instance)
4. Build the code using command "mvn clean install"
5. Copy target/HazelcastWebServices.war in webapps dir of apache tomcat
