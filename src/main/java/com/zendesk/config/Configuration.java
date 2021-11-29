package com.zendesk.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
@Data
public class Configuration {
    @Value("${ticketsApi}")
    private String ticketsApi;

    @Value("${emailId}")
    private String emailId;

    @Value("${token}")
    private String token;

    // Creating new object to resolve no bean exception since been not found in the @autowire container.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
