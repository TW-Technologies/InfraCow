package com.infracow.program.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class RouterController {

    @GetMapping(value = "/index")
    public String homePage(){
        LocalDateTime dateee = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(dateee.getMonthValue());
        return "home";
    }

    @GetMapping(value = "/dashboard")
    public String dashboardPage(){
        return "dashboard";
    }
}
