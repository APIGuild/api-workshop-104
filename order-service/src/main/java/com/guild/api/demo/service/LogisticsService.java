package com.guild.api.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class LogisticsService {
    private RestTemplate restTemplate;

    @Value("${service.logistics.baseUrl}")
    private String baseUrl;

    public LogisticsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getLogistics(String logisticsId) {
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path("/logistics/")
                .path(logisticsId)
                .build();
        return restTemplate.getForEntity(builder.toString(), String.class).getBody();
    }
}
