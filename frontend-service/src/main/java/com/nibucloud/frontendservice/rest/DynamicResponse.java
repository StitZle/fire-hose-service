package com.nibucloud.frontendservice.rest;

import org.springframework.data.mongodb.core.mapping.Document;


@Document("Messages")
public class DynamicResponse {

    private String message;

    public DynamicResponse( String message ) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }
}
