package com.adidas.newsletter.subscriptionservice.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Class that represents the answer if subscription is created without a problem
 */
@Data
@NoArgsConstructor
public class SubscriptionCreateAnswer {

    @NotNull
    private String id;
}
