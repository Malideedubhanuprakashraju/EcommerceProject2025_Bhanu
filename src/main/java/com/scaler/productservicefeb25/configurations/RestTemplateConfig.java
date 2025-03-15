package com.scaler.productservicefeb25.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig
{
    // Create a Bean of Rest Template
    // Name of the class and Method doesnt make any diference.
    // new way to create bean

    @Bean
    public RestTemplate createRestTemplate()
    {
        return new RestTemplate();
    }

}
