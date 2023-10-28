package com.caoguzelmas.foodorderingservice.orderservice.domain.valueobject;

import com.caoguzelmas.foodorderingservice.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {

    protected OrderItemId(Long value) {
        super(value);
    }
}
