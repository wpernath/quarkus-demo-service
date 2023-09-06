package org.wanja.demo;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_persons")
public class Person extends PanacheEntity {
    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;
    public String salutation;
    
    public static List<Person> findBySalutation(String sal) {
       return Person.list("salutation", sal);
    }

    public static List<Person> findByLastName(String lastName) {
        return Person.list("lastName", lastName);
    }
}
