package com.adidas.newsletter.subscriptionservice.service;

import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateAnswer;
import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateRequest;
import com.adidas.newsletter.subscriptionservice.entity.Subscription;
import com.adidas.newsletter.subscriptionservice.producer.EmailProducer;
import com.adidas.newsletter.subscriptionservice.repository.SubscriptionRepository;
import com.adidas.newsletter.subscriptionservice.service.mapper.SubscriptionMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Class with logic of subscirption service
 */
@Slf4j
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    private final EmailProducer emailProducer;

    public SubscriptionServiceImpl(
            SubscriptionRepository subscriptionRepository,
            EmailProducer emailProducer
    ) {
        this.subscriptionRepository = subscriptionRepository;
        this.emailProducer = emailProducer;
    }

    /**
     * Function that handles the creation of a new subscription
     *
     * @param subscriptionCreateRequest object of subscription request
     * @return id of new subscription
     * @throws JsonProcessingException error of jackson mapper
     */
    @Override
    public SubscriptionCreateAnswer createSubscription(SubscriptionCreateRequest subscriptionCreateRequest) throws JsonProcessingException {
        log.info("Creating a new subscription {}", subscriptionCreateRequest);

        Subscription subscription = SubscriptionMapper.INSTANCE.SubscriptionCreateRequestToSubscription(subscriptionCreateRequest);
        subscription.setId(UUID.randomUUID().toString());

        subscriptionRepository.save(subscription);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        emailProducer.sendMessage(mapper.writeValueAsString(subscription));

        return SubscriptionMapper.INSTANCE.SubscritionToSubscriptionCreateAnswer(subscription);
    }
}
