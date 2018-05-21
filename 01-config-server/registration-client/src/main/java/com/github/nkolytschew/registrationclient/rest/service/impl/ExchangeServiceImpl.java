package com.github.nkolytschew.registrationclient.rest.service.impl;

import com.github.nkolytschew.registrationclient.rest.service.ExchangeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {


    private RestTemplate template;

    private String url;

    public ExchangeServiceImpl(@Value("${application.registration-service.url}") String url) {
        this.url = url;
        this.template = new RestTemplate();
    }


    @Override
    public Map<String, String> getRegistrations() {
        Map<String, String> response =
                template.getForObject(url + "/registrations", HashMap.class);
        return response;
    }
}
