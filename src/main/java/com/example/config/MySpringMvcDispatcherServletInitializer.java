package com.example.config;
// Replaces web.xml
// Tells the server: "Hey! Use Spring MVC"
// Sets up the entry point for ALL web requests

//This class does:
//
//  1. Starts Spring MVC
//2. Registers DispatcherServlet
//3. Links config class (DemoAppConfig)
//  4. Maps all requests to Spring


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


//    👉 What is this?
//    Root context = global config (services, security, DB)
//    Shared across the whole app
//    👉 Why empty?
//
//    Because you don’t have advanced layers yet

    //Spring MVC creates two contexts:

    @Override
    protected Class<?>[] getRootConfigClasses() {
        //Used for:
        //
        //Security
        //Services
        //Repositories
        //Database config
        return new Class[]{DemoSecurityConfig.class};

        //It means:
        //“I am NOT registering any root (global) Spring configuration classes.”
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //Used for:
        //Controllers
        //View resolvers
        //Web-specific config
        return new Class[]{DemoAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // handle ALL requests
    }
}
