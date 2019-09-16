package com.adidas.newsletter.emailservice.listener;

import com.adidas.newsletter.emailservice.dto.SubscriptionDTO;
import com.adidas.newsletter.emailservice.service.NotificationService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Class that handles the listener of kafka
 */
@Service
@Slf4j
public class EmailNotificationListener {
    private final NotificationService notificationService;

    public EmailNotificationListener(
            NotificationService notificationService
    ) {
        this.notificationService = notificationService;
    }

    /**
     * Function listening the kafka queue waiting
     *
     * @param messages messages that receive
     */
    @KafkaListener(topics = "${topic.email}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(List<String> messages){
        log.info("Reading from from kafka - {}", messages.size());

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        SubscriptionDTO subscriptionDTO = convertToSubscription(mapper, messages.stream()
                .filter(value -> Optional.ofNullable(value).isPresent())
                .collect(Collectors.joining(",")));

        Optional.ofNullable(subscriptionDTO).ifPresent(notificationService::sendNotification);
    }

    /**
     * Function to convert string (json) to object subscription
     *
     * @param mapper mapper of jackson
     * @param message string of the object
     * @return subscription
     */
    private SubscriptionDTO convertToSubscription(ObjectMapper mapper, String message) {
        try {
            return mapper.readValue(message, SubscriptionDTO.class);
        } catch (IOException e) {
            log.error("Error converting message to subscriptionDTO - {}", message);
            return null;
        }
    }
}
