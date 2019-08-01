package ${package}.route;

import com.google.gson.Gson;
import ${package}.spark.JsonResponseTransformer;
import ${package}.spark.RouteBuilder;

import spark.Service;

public class GreetingRoute implements RouteBuilder {

    private static final Gson gson = new Gson();

    @Override
    public void configure(final Service spark, final String basePath) {

        spark.post(basePath + "/greeting", "application/json", (request, response) -> {

            return new Greeting(gson.fromJson(request.body(), Person.class));

        }, new JsonResponseTransformer());
    }

    private static final class Person {

        private final String name;
        private final String surname;

        private Person(final String name, final String surname) {

            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {

            final StringBuilder builder = new StringBuilder();

            if (name != null) {
                builder.append(name);
                if (surname != null) {
                    builder.append(" ");
                    builder.append(surname);
                }
            } else if (surname != null) {
                builder.append(surname);
            }

            return builder.toString();
        }
    }

    @SuppressWarnings("unused")
    private static final class Greeting {

        private final String greeting;

        private Greeting(final Person person) {

            this.greeting = "Hello, " + person + "!";
        }
    }
}
