//package com.example.ems.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
////Which end point reqired the security configuration
//
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable() // Disable CSRF for simplicity
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .antMatchers("/api/employees").permitAll() // Allow unauthenticated access to /api/employees
//                    .anyRequest().authenticated() // Require authentication for all other requests
//            )
//            .sessionManagement(sessionManagement ->
//                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            );
//        return http.build();
//    }
//}
//
////
////Authentication and Authorization Rules
////Permit Specific Endpoints: The custom configuration allows you to specify that certain endpoints, such as /api/employees, can be accessed without authentication.
////Require Authentication for Others: Other endpoints will still require authentication unless explicitly permitted.
