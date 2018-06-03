package com.github.nkolytschew.example.client.one.service.impl;

import com.github.nkolytschew.example.client.one.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

public class ExchangeServiceImpl implements ExchangeService {

    @Autowired // @Inject
    private EurekaDiscoveryClient discoveryClient;
    private RestTemplate template;

    public ExchangeServiceImpl() {
        this.template = new RestTemplate();
    }

    @Override
    public String getInfoFromRemote() {
//        final String url = "http://localhost:8081/info";
//        final String url2 = "http://localhost:8083/info";
        final List<ServiceInstance> urls = discoveryClient.getInstances("example.client.two"); // .get(0).getHost();
        final String url = urls.get(new Random(2).nextInt()).getHost();
        final String response = template.getForObject(url, String.class);

        return response;
    }
}
