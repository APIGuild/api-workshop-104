package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class LogisticsDao {
    private static final String RETRIEVE_LOGISTICS_URL = "{baseUrl}/logistics/{logisticsId}";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${logistics.service.baseUrl}")
    private String baseUrl;

    public String getLogistics(String logisticsId) {
        String url = UriComponentsBuilder
                .fromPath(RETRIEVE_LOGISTICS_URL)
                .buildAndExpand(baseUrl, logisticsId)
                .toString();
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
