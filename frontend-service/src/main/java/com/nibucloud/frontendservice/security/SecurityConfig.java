package com.nibucloud.frontendservice.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.http.HttpMethod.OPTIONS;


@EnableWebSecurity
public class SecurityConfig {

    @Value( "${auth0.audience}" )
    private String audience;

    @Value( "${spring.security.oauth2.resourceserver.jwt.issuer-uri}" )
    private String issuer;

    @Bean
    JwtDecoder jwtDecoder() {
        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder)JwtDecoders.fromOidcIssuerLocation( issuer );

        OAuth2TokenValidator<Jwt> audienceValidator = new AudienceValidator( audience );
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer( issuer );
        OAuth2TokenValidator<Jwt> withAudience = new DelegatingOAuth2TokenValidator<Jwt>( withIssuer, audienceValidator );

        jwtDecoder.setJwtValidator( withAudience );
        return jwtDecoder;
    }


    @Bean
    public SecurityFilterChain filterChain( HttpSecurity httpSecurity ) throws Exception {
        //@formatter:off
        httpSecurity
                .cors().and()
                .csrf().disable()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(OPTIONS).permitAll() // allow cors preflight
                        .requestMatchers( "/v1/**" )
                        .authenticated()
                )
                .oauth2ResourceServer().jwt();
        //@formatter:on
        return httpSecurity.build();
    }

}
