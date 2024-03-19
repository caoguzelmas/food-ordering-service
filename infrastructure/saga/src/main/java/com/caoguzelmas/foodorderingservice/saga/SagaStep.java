package com.caoguzelmas.foodorderingservice.saga;

import com.caoguzelmas.foodorderingservice.domain.event.DomainEvent;

public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}
