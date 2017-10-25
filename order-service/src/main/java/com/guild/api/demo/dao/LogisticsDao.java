package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LogisticsDao {
    private RestTemplate restTemplate;

    @Value("${logistics.service.baseUrl}")
    private String baseUrl;

    public LogisticsDao(RestTemplate restTemplate) {
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
