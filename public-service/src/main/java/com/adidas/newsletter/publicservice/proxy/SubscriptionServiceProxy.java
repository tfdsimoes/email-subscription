package com.adidas.newsletter.publicservice.proxy;

import com.adidas.newsletter.publicservice.config.FeignServiceConfiguration;
import com.adidas.newsletter.publicservice.model.SubscriptionCreateAnswer;
import com.adidas.newsletter.publicservice.model.SubscriptionCreateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Class with feign client to subscription-service
 */
@FeignClient(name = "subscription-service", url = "${subscription-service.url}", configuration = FeignServiceConfiguration.class)
public interface SubscriptionServiceProxy {

    /**
     * Function that will handle the call to create a new subscription
     *
     * @param subscriptionCreateRequest object with the request
     * @return id of subscription created
     */
    @PostMapping(value = "/subscription/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    SubscriptionCreateAnswer createSubscription(SubscriptionCreateRequest subscriptionCreateRequest);
}
