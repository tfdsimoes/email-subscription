package com.adidas.newsletter.emailservice.service;

import com.adidas.newsletter.emailservice.dto.SubscriptionDTO;

/**
 * Interface of notification service - email sender
 */
public interface NotificationService {

    void sendNotification(SubscriptionDTO subscriptionz);
}
