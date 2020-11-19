package org.example;

import io.sentry.Sentry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    static {
        Sentry.init(options -> {
            options.setDsn("PUT YOUR DSN HERE");
            options.setBeforeSend((sentryEvent, o) -> {
                sentryEvent.setTag("custom", "tag");
                return sentryEvent;
            });
        });
    }
    public static void main(String[] args) {
        LOGGER.error("oops");
    }
}
