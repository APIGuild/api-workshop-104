package com.guild.api.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LogisticsService {
    private RestTemplate restTemplate;

    @Value("${service.logistics.baseUrl}")
    private String baseUrl;
    private String suffix = "/logistics";

    public LogisticsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getLogistics() {
        return restTemplate.getForEntity(baseUrl + suffix, String.class).getBody();
    }
}
