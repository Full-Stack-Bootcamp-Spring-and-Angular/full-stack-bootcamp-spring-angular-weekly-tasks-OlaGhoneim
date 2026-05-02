package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Replaces spring-mvc.xml
// Tells Spring WHERE to find controllers
// Tells Spring WHERE to find JSP files
@Configuration
@ComponentScan(basePackages = "com.example") // scan for components (controllers, services, etc.)
@EnableWebMvc // enable Spring MVC features

public class DemoAppConfig {
    @Bean
    public ViewResolver viewResolver() {
        // Look for JSP files in /WEB-INF/view/
        // Add .jsp extension automatically
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();

        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;
    }
}
