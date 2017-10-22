package com.guild.api.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CustomerService {

    private RestTemplate restTemplate;

    @Value("${service.customer.baseUrl}")
    private String baseUrl;

    public CustomerService(RestTemplate restTemplate) {
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
