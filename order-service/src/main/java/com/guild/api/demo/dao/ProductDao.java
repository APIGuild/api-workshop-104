package com.guild.api.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.guild.api.demo.model.ProductModel;

@Component
public class ProductDao {
    private static final String RETRIEVE_PRODUCT_URL = "{baseUrl}/products/{productId}";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.service.baseUrl}")
    private String baseUrl;

    public ProductModel getProduct(String productId) {
        String url = UriComponentsBuilder
                .fromPath(RETRIEVE_PRODUCT_URL)
                .buildAndExpand(baseUrl, productId)
                .toString();
        String productInfo = restTemplate.getForEntity(url, String.class).getBody();
        return new ProductModel(productId, productInfo);
    }

}
