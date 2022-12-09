package com.nibucloud.frontendservice.rest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employees")
public class Employee {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String email;


    public Employee() {
    }


    public Employee( String firstName, String lastName, String email ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public String getId() {
        return id;
    }


    public void setId( String id ) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail( String email ) {
        this.email = email;
    }
}