package com.nibucloud.frontendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication( scanBasePackages = { "com.nibucloud.frontendservice", "com.nibucloud.common" } )
public class FrontendServiceApplication {

    public static void main( String[] args ) {
        SpringApplication.run( FrontendServiceApplication.class, args );
    }

}
