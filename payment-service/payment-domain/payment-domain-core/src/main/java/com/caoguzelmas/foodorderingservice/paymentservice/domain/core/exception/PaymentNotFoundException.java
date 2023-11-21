package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class PaymentNotFoundException extends DomainException {
    public PaymentNotFoundException(String message) {
        super(message);
    }

    public PaymentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
