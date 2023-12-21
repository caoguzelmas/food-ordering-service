package com.caoguzelmas.foodorderingservice.restaurantservice.domain.ports.output.message.publisher;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.event.OrderRejectedEvent;

public interface OrderRejectedMessagePublisher extends DomainEventPublisher<OrderRejectedEvent> {
}
