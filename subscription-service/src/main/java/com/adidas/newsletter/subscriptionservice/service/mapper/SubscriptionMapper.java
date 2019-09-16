package com.adidas.newsletter.subscriptionservice.service.mapper;

import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateAnswer;
import com.adidas.newsletter.subscriptionservice.controller.dto.SubscriptionCreateRequest;
import com.adidas.newsletter.subscriptionservice.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;

/**
 * Mapper that handles the conversion of object from subscriptionRequest to subscription (entity)
 */
@Mapper(nullValueCheckStrategy = ALWAYS)
public interface SubscriptionMapper {

    SubscriptionMapper INSTANCE = Mappers.getMapper(SubscriptionMapper.class);

    Subscription SubscriptionCreateRequestToSubscription(SubscriptionCreateRequest subscriptionCreateRequest);

    SubscriptionCreateAnswer SubscritionToSubscriptionCreateAnswer(Subscription subscription);

}
