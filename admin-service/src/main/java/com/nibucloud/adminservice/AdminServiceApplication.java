package com.nibucloud.adminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication( scanBasePackages = { "com.nibucloud.adminservice", "com.nibucloud.common" } )
public class AdminServiceApplication {

    public static void main( String[] args ) {
        SpringApplication.run( AdminServiceApplication.class, args );
    }

}
