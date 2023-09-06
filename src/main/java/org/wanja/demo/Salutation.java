package org.wanja.demo;

public enum Salutation {
    MR ("Mr"),
    Mrs ("Mrs"),
    Other ("Other");

    String salutation;
    Salutation(String sal) {
        this.salutation = sal;
    }
}
