# Spark Java Maven Archetype

A quick start for the development of new Java applications. :ok_hand:

* Container-ready with **Docker** and Docker Compose configuration.
* Docker **builder** pattern with caching of Maven dependencies.
* SLF4J and logback setup.
* Rich **Maven** setup required by Maven Central (missing GPG jar sign).
* Prints ascii banner at application startup.

## Build archetype
```
mvn clean install
```

## Generate archetype
```
mvn archetype:generate -DarchetypeGroupId=com.juliaaano -DarchetypeArtifactId=java-archetype
```
* Full command:
```
mvn archetype:generate -DarchetypeGroupId=com.juliaaano -DarchetypeArtifactId=java-archetype -DarchetypeVersion=1.0.0-SNAPSHOT -DgroupId=my.group -DartifactId=my-artifact -Dversion=1.0.0-SNAPSHOT
```
