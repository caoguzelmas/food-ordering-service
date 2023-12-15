package com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class RestaurantNotFoundException extends DomainException {
    public RestaurantNotFoundException(String message) {
        super(message);
    }

    public RestaurantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
