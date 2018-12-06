package com.security.dbapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class HelloController {
    @GetMapping("/all")
    public String helloONe(){
        return "Hello One";
    }

    @GetMapping("/security/all")
    public String helloSecure(){
        return "Hello Secure";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping ("/specialAdmin")
    public String helloByRole(){
        return "Hello Secure";
    }






}
