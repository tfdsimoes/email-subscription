package com.adidas.newsletter.publicservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class of configuration of feign client
 */
@Configuration
public class FeignServiceConfiguration {

    @Value("${subscription-service.security.username}")
    private String securityUsername;

    @Value("${subscription-service.security.password}")
    private String securityPassword;

    /**
     * Function of basic auth interceptor
     *
     * @return basic auth interceptor
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {

        return new BasicAuthRequestInterceptor(securityUsername, securityPassword);
    }
}
