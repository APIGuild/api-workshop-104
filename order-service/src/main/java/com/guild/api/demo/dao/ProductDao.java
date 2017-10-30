package com.guild.api.demo.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import com.guild.api.demo.dao.exception.DaoException;
import com.guild.api.demo.dao.exception.DaoExceptionBuilder;
import com.guild.api.demo.model.ProductModel;
import com.guild.api.demo.util.rest.PooledRestTemplateBuilder;
import com.guild.api.demo.util.rest.RestEndpointProperties;

@Component
public class ProductDao {
    private static final String RETRIEVE_PRODUCT_URL = "{baseUrl}/products/{productId}";

    private RestEndpointProperties properties = new RestEndpointProperties();

    public ProductModel getProduct(String productId) throws DaoException {
        String url = UriComponentsBuilder.fromPath(RETRIEVE_PRODUCT_URL)
                .buildAndExpand(properties.getBaserUrl(), productId).toString();
        try {
            String productInfo = new PooledRestTemplateBuilder(properties)
                    .build()
                    .execute("ProductService", restTemplate -> restTemplate.getForEntity(url, String.class))
                    .getBody();
            return new ProductModel(productId, productInfo);
        } catch (Exception exception) {
            throw new DaoExceptionBuilder(url).build(exception);
        }
    }

}
