package com.github.nkolytschew.registrationclient.rest;


import com.github.nkolytschew.registrationclient.rest.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EndpointController {


    private ExchangeService exchangeService;

    @Autowired
    public EndpointController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }


    @GetMapping("find-regs")
    public Map<String, String> getRegistrations() {
        return this.exchangeService.getRegistrations();
    }

    // do more
}
