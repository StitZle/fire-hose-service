package com.nibucloud.frontendservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController()
@RequestMapping("/v1")
public class TestController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/test")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee ){
      Employee employee1 =  employeeRepository.save( employee );
      return new ResponseEntity<>( employee1, HttpStatus.OK );
    }


    @GetMapping( value = "/auth/public" )
    public ResponseEntity<DynamicResponse> getPublicResponse(  ) {
        DynamicResponse dynamicResponse = new DynamicResponse( "public" );
        return new ResponseEntity<>( dynamicResponse, HttpStatus.OK );
    }

    @GetMapping( value = "/auth/secret" )
    public ResponseEntity<DynamicResponse> getSecretResponse(Principal principal) {
        DynamicResponse dynamicResponse = new DynamicResponse( "Secret message. Your principal is " + principal.getName() );
        return new ResponseEntity<>( dynamicResponse, HttpStatus.OK );
    }

    @GetMapping( value = "/auth/scoped" )
    public ResponseEntity<DynamicResponse> getScopedResponse(Principal principal) {
        DynamicResponse dynamicResponse = new DynamicResponse( "Scoped message. Your principal is " + principal.getName() );
        return new ResponseEntity<>( dynamicResponse, HttpStatus.OK );
    }


}
