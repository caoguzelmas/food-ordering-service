package com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.valueobject;

import com.caoguzelmas.foodorderingservice.domain.valueobject.BaseId;

import java.util.UUID;

public class OrderApprovalId extends BaseId<UUID> {

    public OrderApprovalId(UUID value) {
        super(value);
    }
}
