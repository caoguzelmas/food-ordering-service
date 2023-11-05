package com.caoguzelmas.foodorderingservice.domain.event.publisher;

import com.caoguzelmas.foodorderingservice.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
