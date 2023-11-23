package com.caoguzelmas.foodorderingservice.paymentservice.application.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class PaymentApplicationServiceException extends DomainException {
    public PaymentApplicationServiceException(String message) {
        super(message);
    }

    public PaymentApplicationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
