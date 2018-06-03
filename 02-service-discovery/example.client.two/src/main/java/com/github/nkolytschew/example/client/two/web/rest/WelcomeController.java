package com.github.nkolytschew.example.client.two.web.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/info")
    public String getInfos() {
        return applicationName + serverPort;
    }

}
