package com.caoguzelmas.foodorderingservice.paymentservice.domain.core.valueobject;

import com.caoguzelmas.foodorderingservice.domain.valueobject.BaseId;

import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
