#set($hash = '#')
${hash} ${artifactId}
[![Build Status](https://travis-ci.org/juliaaano/${artifactId}.svg)](https://travis-ci.org/juliaaano/${artifactId})
[![Release](https://img.shields.io/github/release/juliaaano/${artifactId}.svg)](https://github.com/juliaaano/${artifactId}/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/${groupId}/${artifactId}.svg)](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId})
[![Javadocs](http://www.javadoc.io/badge/${groupId}/${artifactId}.svg?color=blue)](http://www.javadoc.io/doc/${groupId}/${artifactId})

A quick start for the development of new Java applications. :ok_hand:

* Container-ready with **Docker** and Docker Compose configuration.
* Docker **builder** pattern with caching of Maven dependencies.
* SLF4J and logback setup.
* Rich **Maven** setup required by Maven Central (missing GPG jar sign).
* Prints ascii banner at application startup.

${hash}${hash} Maven
```
mvn package
java -jar target/app.jar
```

${hash}${hash} Docker
```
docker-compose up
```
