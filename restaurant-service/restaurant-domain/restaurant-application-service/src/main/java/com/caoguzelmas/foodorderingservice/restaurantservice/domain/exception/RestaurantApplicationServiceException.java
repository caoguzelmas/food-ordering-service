package com.caoguzelmas.foodorderingservice.restaurantservice.domain.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class RestaurantApplicationServiceException extends DomainException {
    public RestaurantApplicationServiceException(String message) {
        super(message);
    }

    public RestaurantApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
