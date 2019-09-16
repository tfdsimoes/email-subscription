package com.adidas.newsletter.subscriptionservice.repository;

import com.adidas.newsletter.subscriptionservice.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface that handles the crud request
 */
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, String> {
}
