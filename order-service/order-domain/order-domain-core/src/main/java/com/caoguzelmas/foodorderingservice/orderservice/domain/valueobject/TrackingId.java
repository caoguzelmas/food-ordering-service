package com.caoguzelmas.foodorderingservice.orderservice.domain.valueobject;

import com.caoguzelmas.foodorderingservice.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {

    protected TrackingId(UUID value) {
        super(value);
    }
}
