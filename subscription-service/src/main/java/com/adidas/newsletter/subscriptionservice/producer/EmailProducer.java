package com.adidas.newsletter.subscriptionservice.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Class that produces new elements to kafka queue
 */
@Component
@Slf4j
public class EmailProducer {

    @Value("${topic.email}")
    private  String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EmailProducer(
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Function to send mensage to queue
     * @param message message (subscription object in json)
     */
    public void sendMessage(String message) {
        log.info("Sending message - {}", message);
        this.kafkaTemplate.send(topic, message);
    }
}
