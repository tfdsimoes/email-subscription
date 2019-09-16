package com.adidas.newsletter.subscriptionservice.controller;

import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateAnswer;
import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateRequest;
import com.adidas.newsletter.subscriptionservice.service.SubscriptionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Controller to handle subscription
 */
@RestController
@RequestMapping(value = "/subscription", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(
            SubscriptionService subscriptionService
    ) {
        this.subscriptionService = subscriptionService;
    }

    /**
     * Function that handle the request of new subscription
     *
     * @param subscriptionCreateRequest object with the request
     * @return id of the new subscription
     * @throws JsonProcessingException if there is problem converting the object to json (for kafka)
     */
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<SubscriptionCreateAnswer> createSubscription(@RequestBody SubscriptionCreateRequest subscriptionCreateRequest) throws JsonProcessingException {
        log.info("Requesting create a new subscription - {}", subscriptionCreateRequest);

        return ResponseEntity.of(Optional.of(subscriptionService.createSubscription(subscriptionCreateRequest)));
    }
}
