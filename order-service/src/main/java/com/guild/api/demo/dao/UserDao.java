package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.guild.api.demo.model.UserModel;

@Component
public class UserDao {
    private static final String RETRIEVE_USER_URL = "{baseUrl}/users/{userId}";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.service.baseUrl}")
    private String baseUrl;

    public UserModel getUser(String userId) {
        String url = UriComponentsBuilder
                .fromPath(RETRIEVE_USER_URL)
                .buildAndExpand(baseUrl, userId)
                .toString();
        String userInfo = restTemplate.getForEntity(url, String.class).getBody();
        return new UserModel(userId, userInfo);
    }
}
