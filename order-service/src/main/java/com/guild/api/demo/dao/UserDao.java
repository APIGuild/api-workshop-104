package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UserDao {

    private RestTemplate restTemplate;

    @Value("${user.service.baseUrl}")
    private String baseUrl;

    public UserDao(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getUser(String userId) {
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path("/users/")
                .path(userId)
                .build();
        return restTemplate.getForEntity(builder.toString(), String.class).getBody();
    }
}
