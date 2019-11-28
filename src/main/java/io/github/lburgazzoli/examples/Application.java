package io.github.lburgazzoli.examples;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.camel.CamelContext;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.config.spi.ConfigProviderResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    
    @ConfigProperty(name = "the.message")
    String message;

    @Inject
    CamelContext context;

    void onStart(@Observes StartupEvent event) {
        LOGGER.info(
            "1. message = {}",
             message
        );
        LOGGER.info(
            "2. message = {}",
             context.resolvePropertyPlaceholders("{{the.message}}")
        );
        LOGGER.info(
            "3. message = {}",
             ConfigProvider.getConfig().getValue("the.message", String.class)
        );
        LOGGER.info(
            "4. message = {}",
             ConfigProviderResolver.instance().getConfig().getValue("the.message", String.class)
        );
    }
}