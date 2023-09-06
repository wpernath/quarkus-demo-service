package org.wanja.demo;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/reports")

public class ReportResource {
    

    @ConfigProperty(name = "quarkus.application.version")
    String appVersion;

    @ConfigProperty(name = "quarkus.application.name")
    String appName;

    @Inject
    Template persons;
    
    @Inject
    PersonResource personResource;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    public TemplateInstance allPersons() {
        TemplateInstance ti = persons.data("appVersion", appVersion);
        ti.data("appName", appName);
        ti.data("persons", personResource.allPersons());
        return ti;
    }
}
