package org.wanja.demo;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/persons")

public class PersonResource {
    
    @GET
    @Path("{id}")
    @Produces("text/plain")
    public String personName(Long id) {
        Person p = Person.findById(id);
        return p.salutation + " " + p.firstName + " " + p.lastName;
    }


    @GET
    public List<Person> allPersons() {
        return Person.listAll();
    }

    @POST
    @Transactional
    public Person createPerson(Person p) {
        p.persist();
        return p;
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Person updatePerson(Long id, Person p) {
        Person person = Person.findById(id);
        if( p.firstName != null ) {
            person.firstName = p.firstName;
        }

        if (p.lastName != null) {
            person.lastName = p.lastName;
        }
        
        if( p.salutation != null ) {
            person.salutation = p.salutation;
        }

        person.persist();
        return person;
    }
}
