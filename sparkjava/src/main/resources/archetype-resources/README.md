#set($hash = '#')
${hash} ${artifactId}
[![Build Status](https://travis-ci.org/juliaaano/${artifactId}.svg)](https://travis-ci.org/juliaaano/${artifactId})
[![Release](https://img.shields.io/github/release/juliaaano/${artifactId}.svg)](https://github.com/juliaaano/${artifactId}/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/${groupId}/${artifactId}.svg)](https://maven-badges.herokuapp.com/maven-central/${groupId}/${artifactId})
[![Javadocs](http://www.javadoc.io/badge/${groupId}/${artifactId}.svg?color=blue)](http://www.javadoc.io/doc/${groupId}/${artifactId})

A quick start for the development of new Java applications. :ok_hand:

* Container-ready with **Docker** and Docker Compose configuration.
* Docker **builder** pattern with caching of Maven dependencies.
* Basic **Kubernetes** deployment and service definitions.
* **Istio** ingress gateway and virtual service definitions.
* **Travis** CI pipeline with automated GitHub releases and Docker build and push.
* **Spark Java's** smart and simple http endpoints.
* SLF4J and Logback setup, with per-request log level filter.
* Additional **Log4j2** YAML config with several features.
* Prints ascii banner at application startup.

${hash}${hash} Docker
```
docker-compose up
curl http://localhost:8000/status
curl -X POST http://localhost:8000/api/greeting -d '{"name": "John", "surname":"Smith"}'
curl -i -X POST http://localhost:8000/api/greeting -d '{"name": "John", "surname":"Smith"}' -H "X-Request-ID: myCorrelationID" -H "X-Log-Level: DEBUG"
```

${hash}${hash} Kubernetes and Istio
```
minikube start
eval $(minikube docker-env)
docker build -t juliaaano/${artifactId}:${version} .
kubectl apply -f manifests/
kubectl apply -f manifests/istio/
```

${hash}${hash}${hash} Test with Istio
```
export INGRESS_PORT=$(kubectl -n istio-system get service istio-ingressgateway -o jsonpath='{.spec.ports[?(@.name=="http2")].nodePort}')
curl -i http://$(minikube ip):$INGRESS_PORT/hello
```

${hash}${hash}${hash} Test with k8s only
```
kubectl proxy --port=8080
curl -i http://localhost:8080/api/v1/namespaces/juliaaano/services/${artifactId}:http/proxy/hello
```
