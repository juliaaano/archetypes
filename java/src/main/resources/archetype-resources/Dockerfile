### BUILDER IMAGE ###
FROM maven:3-jdk-11-slim as builder

COPY pom.xml /build/

RUN mvn --file build/pom.xml --batch-mode dependency:go-offline

COPY src /build/src/

RUN mvn --file build/pom.xml --batch-mode --offline package -DskipTests \
	&& mkdir app \
	&& mv build/target/app-*.jar app/app.jar


### PRODUCTION IMAGE ###
FROM openjdk:11-jre-slim

COPY --from=builder app/app.jar app/app.jar

WORKDIR /app

CMD ["java", "-jar", "app.jar"]
