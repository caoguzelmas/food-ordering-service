package com.caoguzelmas.foodorderingservice.orderservice.domain.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class OrderNotFoundException extends DomainException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
