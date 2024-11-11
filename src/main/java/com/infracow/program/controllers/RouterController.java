package com.infracow.program.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping(value = "/index")
    public String homePage(){
        return "home";
    }

    @GetMapping(value = "/dashboard")
    public String dashboardPage(){
        return "dashboard";
    }
}
