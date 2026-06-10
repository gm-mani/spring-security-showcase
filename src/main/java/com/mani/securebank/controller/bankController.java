package com.mani.securebank.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class bankController {

    @GetMapping("/public")
    public String publicApi() {
        return "public";
    }

    @GetMapping("/admin")
    public String adminApi() {
        return "admin";
    }

    @GetMapping("/user")
    public String userApi() {
        return "user";
    }
}
