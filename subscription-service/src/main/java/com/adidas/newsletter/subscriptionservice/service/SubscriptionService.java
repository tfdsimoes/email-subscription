package com.adidas.newsletter.subscriptionservice.service;

import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateAnswer;
import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Interface of subscription service
 */
public interface SubscriptionService {

    SubscriptionCreateAnswer createSubscription(SubscriptionCreateRequest subscriptionCreateRequest) throws JsonProcessingException;
}
