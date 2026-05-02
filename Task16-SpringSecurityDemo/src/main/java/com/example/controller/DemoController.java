package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }
    @GetMapping("/admin")
    public String showAdmin() {
        return "Admin";
    }
    @GetMapping("/system")
    public String systemHome() {
        return "systems";
    }

}