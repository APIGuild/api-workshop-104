package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class UserDao {
    private static final String RETRIEVE_USER_URL = "{baseUrl}/users/{userId}";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.baseUrl}")
    private String baseUrl;

    @HystrixCommand(fallbackMethod = "reliable")
    public String getUser(String userId) {
        String url = UriComponentsBuilder
                .fromPath(RETRIEVE_USER_URL)
                .buildAndExpand(baseUrl, userId)
                .toString();
        return restTemplate.getForEntity(url, String.class).getBody();
    }

    public String reliable() {
        return "Reliable user";
    }
}
