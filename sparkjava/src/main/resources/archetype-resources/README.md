#set($hash = '#')
${hash} ${artifactId}
[![Build Status](https://travis-ci.org/juliaaano/${artifactId}.svg)](https://travis-ci.org/juliaaano/${artifactId})
[![Release](https://img.shields.io/github/release/juliaaano/${artifactId}.svg)](https://github.com/juliaaano/${artifactId}/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/${groupId}/${artifactId}.svg)](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId})
[![Javadocs](http://www.javadoc.io/badge/${groupId}/${artifactId}.svg?color=blue)](http://www.javadoc.io/doc/${groupId}/${artifactId})

A quick start for the development of new Java applications. :ok_hand:

* Container-ready with **Docker** and Docker Compose configuration.
* Docker **builder** pattern with caching of Maven dependencies.
* Red Hat **OpenShift** container deployment.
* Basic **Kubernetes** deployment and service definitions.
* **Istio** ingress gateway and virtual service definitions.
* **Travis** CI pipeline with automated GitHub releases and Docker build and push.
* **Spark Java's** smart and simple http endpoints.
* Testing with **REST-assured**.
* SLF4J and Logback setup, with per-request log level filter.
* Additional **Log4j2** YAML config with several features.
* Prints ascii banner at application startup.

${hash}${hash} Docker
```
docker-compose up
curl -i http://localhost:8000/status
curl -i -X POST http://localhost:8000/api/greeting -d '{"name": "John", "surname":"Smith"}' -H "Content-Type: application/json"
curl -i -X POST http://localhost:8000/api/greeting -d '{"name": "John", "surname":"Smith"}' -H "Content-Type: application/json" -H "X-Request-ID: myCorrelationID" -H "X-Log-Level: DEBUG"
```

${hash}${hash} Kubernetes
```
minikube start
eval $(minikube docker-env)
docker build -t juliaaano/${artifactId}:${version} .
kubectl create namespace my-namespace
kubectl config set-context --current --namespace=my-namespace
kubectl apply -f manifests/
kubectl set image deployment ${artifactId} app=juliaaano/${artifactId}:${version}
kubectl scale deployment ${artifactId} --replicas 2
kubectl expose deployment ${artifactId} --name=${artifactId}-lb --type=LoadBalancer --port=8000 --target-port=4567
minikube tunnel
curl "http://localhost:8000/api/hostname"
```

${hash}${hash} OpenShift

Login to an existing cluster.

${hash}${hash}${hash} Build the app with Maven:
```
mvn clean package -DskipTests
```

${hash}${hash}${hash} Setup the project/namespace:
```
oc new-project my-project
oc create secret docker-registry my-redhat-credentials \
    --docker-server=registry.redhat.io \
    --docker-username=my-redhat-username \
    --docker-password=my-redhat-password
oc secrets link default my-redhat-credentials --for=pull
oc secrets link builder my-redhat-credentials
```

${hash}${hash}${hash} Build container image:
```
oc new-build --binary=true --docker-image=registry.redhat.io/ubi8/openjdk-11 --name=${artifactId}
oc start-build ${artifactId} --from-file ./target/app-${version}.jar --follow
```

${hash}${hash}${hash} Deployment
```
oc apply -f manifests/
oc set image deployment ${artifactId} app=$(oc get imagestream ${artifactId} -o jsonpath='{.status.dockerImageRepository}')
oc scale deployment ${artifactId} --replicas 3
oc expose service ${artifactId}
curl "http://$(oc get route ${artifactId} -o jsonpath='{.spec.host}')/api/hostname"
```
