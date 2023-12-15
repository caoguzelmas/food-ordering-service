package com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class RestaurantDomainException extends DomainException {
    public RestaurantDomainException(String message) {
        super(message);
    }

    public RestaurantDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
