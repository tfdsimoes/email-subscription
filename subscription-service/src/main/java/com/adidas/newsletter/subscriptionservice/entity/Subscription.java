package com.adidas.newsletter.subscriptionservice.entity;

import com.adidas.newsletter.subscriptionservice.enums.SubscriberGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Class that represents the object saved in the dabase
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Subscription {

    @Id
    private String id;

    private String email;

    private String firstName;

    private SubscriberGender subscriberGender;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    private Boolean consent;

    private String campaignId;
}
