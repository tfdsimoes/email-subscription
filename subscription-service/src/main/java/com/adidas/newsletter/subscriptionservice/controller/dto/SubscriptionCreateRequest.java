package com.adidas.newsletter.subscriptionservice.controller.dto;

import com.adidas.newsletter.subscriptionservice.enums.SubscriberGender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Class that represents the request for create a new subscription
 */
@Data
@NoArgsConstructor
public class SubscriptionCreateRequest {

    @NotNull(message = "Email is required")
    @JsonProperty
    @Email(message = "Email must be valid")
    private String email;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private SubscriberGender subscriberGender;

    @NotNull
    @JsonProperty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotNull(message = "Consent is required")
    @JsonProperty
    private Boolean consent;

    @NotNull(message = "Campaign id is required")
    @JsonProperty
    private String campaignId;
}
