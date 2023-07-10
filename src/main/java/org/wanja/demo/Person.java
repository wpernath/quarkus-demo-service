package org.wanja.demo;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Person extends PanacheEntity {
    public String firstName;
    public String lastName;
    public String salutation;
    
}
