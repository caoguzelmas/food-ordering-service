package com.caoguzelmas.foodorderingservice.orderservice.domain.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class OrderException extends DomainException {
    public OrderException(String message) {
        super(message);
    }

    public OrderException(String message, Throwable cause) {
        super(message, cause);
    }
}
