package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import static ${package}.AsciiBanner.asciiBanner;
import static spark.Spark.get;

public class AppBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(AppBootstrap.class);

    public static void main(String... args) {

        MDC.put("Correlation-Id", "correlation-id");
        asciiBanner("application-ascii-banner.txt").ifPresent(AsciiBanner::print);

        logger.info("App started...");

        get("/hello", (req, res) -> "Hello, World!");
    }
}
