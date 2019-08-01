package ${package}.spark;

import spark.Service;

@FunctionalInterface
public interface RouteBuilder {

    void configure(final Service spark, final String basePath);
}
