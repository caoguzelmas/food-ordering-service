package com.caoguzelmas.foodorderingservice.domain.event;

public interface DomainEvent<T> {
    void fire();
}
