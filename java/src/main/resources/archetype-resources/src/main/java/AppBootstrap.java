package ${package};

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ${package}.AsciiBanner.asciiBanner;

public class AppBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(AppBootstrap.class);

    public static void main(String... args) {

        asciiBanner("application-ascii-banner.txt").ifPresent(AsciiBanner::print);

        logger.info("App started...");
        logger.info("...And finished");
    }
}
