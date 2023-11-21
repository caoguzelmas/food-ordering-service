package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.valueobject;

import com.caoguzelmas.foodorderingservice.domain.valueobject.BaseId;

import java.util.UUID;

public class PaymentId extends BaseId<UUID> {

    public PaymentId(UUID value) {
        super(value);
    }
}
