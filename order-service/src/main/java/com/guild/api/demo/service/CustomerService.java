package com.guild.api.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerService {

    private RestTemplate restTemplate;

    @Value("${service.customer.baseUrl}")
    private String baseUrl;
    private String suffix = "/customers";

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCustomer() {
        return restTemplate.getForEntity(baseUrl + suffix, String.class).getBody();
    }
}
