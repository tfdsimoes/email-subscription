package com.adidas.newsletter.publicservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Class that represent the answer when subscription is created
 */
@Data
@NoArgsConstructor
public class SubscriptionCreateAnswer {

    @NotNull
    @JsonProperty
    private String id;
}
