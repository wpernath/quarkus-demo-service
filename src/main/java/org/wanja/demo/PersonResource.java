package org.wanja.demo;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;

@Path("/persons")
@OpenAPIDefinition(
    info = @Info(
        title = "Person API",
        version= "0.11",
        contact = @Contact(
            name = "Person API Support",
            url = "https://github.com/wpernath/quarkus-demo-service",
            email="wanja@example.org"
        ),
        license = @License(
            name = "Apache Software License 2.0",
            url  = "https://www.apache.org/licenses/LICENSE-2.0.html"
        )
    ))
public class PersonResource {
    
    @Operation(
        summary = "Getting all persons, unsorted",
        description = "Method will return an unsorted set of persons currently in the database"
    )
    @GET
    public List<Person> allPersons() {
        return Person.listAll();
    }

    @Operation(
        summary = "Creating a new person",
        description = "Method to create a new person in the internal database"
    )
    @POST
    @Transactional
    public void create(Person p) {
        p.id = null;
        p.persist();
    }

    @Operation(
        summary = "Updating an existing person",
        description = "Method to update an existing person in the internal database"
    )
    @PUT
    @Path("{id}")
    @Transactional
    public Person update(Long id, Person per) {
        Person p = Person.findById(id);
        if( per.firstName != null ) p.firstName = per.firstName;
        if( per.lastName != null )  p.lastName  = per.lastName;
        if( per.salutation != null )p.salutation= per.salutation;
        p.persist();
        return p;
    }

    @Operation(
        summary = "Deleting a person",
        description = "Method to delete a person from the internal database"
    )
    @DELETE
    @Transactional
    @Path("{id}")
    public void delete(Long id) {
        Person p = Person.findById(id);
        if( p != null ) p.delete();
    }
}
