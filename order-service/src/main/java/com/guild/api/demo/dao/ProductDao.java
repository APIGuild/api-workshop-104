package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ProductDao {
    private RestTemplate restTemplate;

    @Value("${product.service.baseUrl}")
    private String baseUrl;

    public ProductDao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public String getProduct(String logisticsId) {
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path("/products/")
                .path(logisticsId)
                .build();
        return restTemplate.getForEntity(builder.toString(), String.class).getBody();
    }

}
