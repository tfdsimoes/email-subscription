package com.adidas.newsletter.emailservice.dto;

import com.adidas.newsletter.emailservice.enums.SubscriberGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Object that will receive from kafka
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO {

    private String id;

    private String email;

    private String firstName;

    private SubscriberGender subscriberGender;

    private LocalDate dateOfBirth;

    private boolean consent;

    private String campaignId;

}
