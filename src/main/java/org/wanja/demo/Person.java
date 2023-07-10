package org.wanja.demo;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Person extends PanacheEntity {
    public String firstName;
    public String lastName;
    public Salutation salutation;
    
    public static List<Person> findBySalutation(Salutation sal) {
       return Person.list("salutation", sal);
    }

    public static List<Person> findByLastName(String lastName) {
        return Person.list("lastName", lastName);
    }
}
