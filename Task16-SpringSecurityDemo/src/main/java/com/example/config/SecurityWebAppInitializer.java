package com.example.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

// Registers Spring Security Filters with the server
// Works AUTOMATICALLY just by existing
// No code needed inside!

//🔹 What does this actually do?
//
//Even though it is empty, Spring uses inheritance:
//
//  👉 Just by EXISTING and extending this class, Spring automatically:
//
//Registers springSecurityFilterChain
//Hooks security into the Servlet container (Tomcat)
//Ensures every request passes through Spring Security filters
public class SecurityWebAppInitializer  extends AbstractSecurityWebApplicationInitializer {

}

