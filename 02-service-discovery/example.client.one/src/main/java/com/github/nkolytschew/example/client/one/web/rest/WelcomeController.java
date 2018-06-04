package com.github.nkolytschew.example.client.one.web.rest;


import com.github.nkolytschew.example.client.one.service.ExchangeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String serverPort;


    @Autowired
    private ExchangeService exchangeService;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/info")
    public String getInfos() {
//        return applicationName + serverPort;
        return exchangeService.getInfoFromRemote();
    }

    public String fallback() {
        return "awesome fallback";
    }
}
