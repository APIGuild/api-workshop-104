package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CustomerDao {

    private RestTemplate restTemplate;

    @Value("${service.customer.baseUrl}")
    private String baseUrl;

    public CustomerDao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCustomer(String customerId) {
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path("/customers/")
                .path(customerId)
                .build();
        return restTemplate.getForEntity(builder.toString(), String.class).getBody();
    }
}
