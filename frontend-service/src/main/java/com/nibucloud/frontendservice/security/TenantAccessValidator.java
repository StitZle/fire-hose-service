package com.nibucloud.frontendservice.security;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

//TODO get sub from Token an validate it against db
public class TenantAccessValidator implements OAuth2TokenValidator<Jwt> {


    public OAuth2TokenValidatorResult validate(Jwt token){
        String sub = token.getSubject();
        System.out.println("SUBJECT: " + sub);

        if( sub == null ){
            OAuth2Error oAuth2Error = new OAuth2Error( "invalid_token", "The required sub is null", null );
            return OAuth2TokenValidatorResult.failure( oAuth2Error );
        }

        return OAuth2TokenValidatorResult.success();

    }

}
