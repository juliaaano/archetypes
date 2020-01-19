# Spark Java Maven Archetype

A quick start for the development of new Java applications. :ok_hand:

* Container-ready with **Docker** and Docker Compose configuration.
* Docker **builder** pattern with caching of Maven dependencies.
* Basic **Kubernetes** deployment and service definitions.
* **Istio** ingress gateway and virtual service definitions.
* **Travis** CI pipeline with automated GitHub releases and Docker build and push.
* **Spark Java's** smart and simple http endpoints.
* Testing with **REST-assured**.
* SLF4J and Logback setup, with per-request log level filter.
* Additional **Log4j2** YAML config with several features.
* Prints ascii banner at application startup.

## Build archetype
```
mvn clean install
```

## Generate archetype
```
mvn archetype:generate -DarchetypeGroupId=com.juliaaano -DarchetypeArtifactId=sparkjava-archetype
```
* Full command:
```
mvn archetype:generate -DarchetypeGroupId=com.juliaaano -DarchetypeArtifactId=sparkjava-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=my.group -DartifactId=my-arfifact -Dversion=1.0.0-SNAPSHOT
```
