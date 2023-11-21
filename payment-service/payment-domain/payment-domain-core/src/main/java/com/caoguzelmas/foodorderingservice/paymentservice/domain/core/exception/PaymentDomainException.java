package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.exception;

import com.caoguzelmas.foodorderingservice.domain.exception.DomainException;

public class PaymentDomainException extends DomainException {
    public PaymentDomainException(String message) {
        super(message);
    }

    public PaymentDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
