package io.github.lburgazzoli.examples;

import javax.ws.rs.Path;

/**
 * The presence of this resource causes Quarkus Camel to not honor config profiles when NOT running in dev mode.
 *
 * @author peteroyle
 */
@Path("/application")
public class ApplicationResource {
}