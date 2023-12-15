package com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.event;

import com.caoguzelmas.foodorderingservice.domain.event.DomainEvent;
import com.caoguzelmas.foodorderingservice.domain.valueobject.RestaurantId;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.OrderApproval;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class OrderApprovalEvent implements DomainEvent<OrderApproval> {

    private final OrderApproval orderApproval;
    private final RestaurantId restaurantId;
    private final List<String> failureMessages;
    private final ZonedDateTime createdAt;

    protected OrderApprovalEvent(OrderApproval orderApproval,
                                 RestaurantId restaurantId,
                                 List<String> failureMessages,
                                 ZonedDateTime createdAt) {
        this.orderApproval = orderApproval;
        this.restaurantId = restaurantId;
        this.failureMessages = failureMessages;
        this.createdAt = createdAt;
    }

    public OrderApproval getOrderApproval() {
        return orderApproval;
    }

    public RestaurantId getRestaurantId() {
        return restaurantId;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
