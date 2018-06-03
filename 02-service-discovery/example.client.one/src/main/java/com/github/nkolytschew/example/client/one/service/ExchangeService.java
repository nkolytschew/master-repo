package com.github.nkolytschew.example.client.one.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("example-client-two")
public interface ExchangeService {

    @GetMapping("info")
    String getInfoFromRemote();
}
