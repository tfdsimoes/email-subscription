package com.adidas.newsletter.publicservice.controller;

import com.adidas.newsletter.publicservice.model.SubscriptionCreateAnswer;
import com.adidas.newsletter.publicservice.model.SubscriptionCreateRequest;
import com.adidas.newsletter.publicservice.proxy.SubscriptionServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Class of controller of newsletter
 */
@RestController
@RequestMapping(value = "/newsletter", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class NewsletterController {

    private final SubscriptionServiceProxy subscriptionServiceProxy;

    public NewsletterController(
            SubscriptionServiceProxy subscriptionServiceProxy
    ) {
        this.subscriptionServiceProxy = subscriptionServiceProxy;
    }

    /**
     * Controller for subscribe a newsletter
     *
     * @param subscriptionCreateRequest request body with the parameters need
     * @return id of subscription
     */
    @PostMapping(value = "/subscription", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SubscriptionCreateAnswer> subscriptionNewsletter(@Valid @RequestBody SubscriptionCreateRequest subscriptionCreateRequest) {
        log.info("Requesting newsletter subscription - {}", subscriptionCreateRequest);
        return ResponseEntity.of(Optional.of(subscriptionServiceProxy.createSubscription(subscriptionCreateRequest)));
    }
}
