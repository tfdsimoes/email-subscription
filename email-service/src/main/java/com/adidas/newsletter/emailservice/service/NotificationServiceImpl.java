package com.adidas.newsletter.emailservice.service;

import com.adidas.newsletter.emailservice.dto.SubscriptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * Function of notification service - email sender
 */
@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    /**
     * Function that will send emails (not implemented)
     *
     * @param subscription subscription to process
     */
    @Override
    public void sendNotification(SubscriptionDTO subscription) {
        log.info("Sent email to {} for campaign {}", subscription.getEmail(), subscription.getCampaignId());
        // Implement a proper email sender
    }
}
