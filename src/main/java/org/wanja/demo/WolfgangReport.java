package org.wanja.demo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.quarkus.security.Authenticated;
import io.smallrye.common.annotation.Blocking;

@Path("/wolfgang")
public class WolfgangReport {
    @Inject
    Template wolfgang;
    
    @Inject
    PersonResource personResource;

    @GET
    @Blocking
    @Authenticated
    public TemplateInstance report() {
        return wolfgang.data("persons", personResource.allPersons());
    }    
}
