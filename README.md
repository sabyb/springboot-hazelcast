# SpringBoot Hazelcast
Learning app spring boot and hazelcast with simple tcp-ip cluster setup and using 
a [replicated map](https://docs.hazelcast.org/docs/4.0/manual/html-single/index.html#replicated-map).


# Getting Started
App needs a system property hazlecast.config to be passed on.
This is tested with sample hazelcast.xml present in the root of the project.
There are two application profiles in the sample.

The second profile is marked with the profile name local2, this enables the second instance 
to run with the system property -Dspring.profiles.active=local2.

The first and second applications make up the cluster.

A sample postman collection has two tests which puts one key in one cluster member and retrieves it from the
other.
