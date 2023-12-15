package com.caoguzelmas.foodorderingservice.restaurantservice.domain.core;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.Restaurant;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.event.OrderApprovalEvent;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.event.OrderApprovedEvent;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.event.OrderRejectedEvent;

import java.util.List;

public interface RestaurantDomainService {

    OrderApprovalEvent validateOrder(Restaurant restaurant,
                                     List<String> failureMessages,
                                     DomainEventPublisher<OrderApprovedEvent> orderApprovedEventDomainEventPublisher,
                                     DomainEventPublisher<OrderRejectedEvent> orderRejectedEventDomainEventPublisher);
}
