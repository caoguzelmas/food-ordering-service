package com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity;

import com.caoguzelmas.foodorderingservice.domain.entity.BaseEntity;
import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderApprovalStatus;
import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.RestaurantId;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.valueobject.OrderApprovalId;

public class OrderApproval extends BaseEntity<OrderApprovalId> {

    private final RestaurantId restaurantId;
    private final OrderId orderId;
    private final OrderApprovalStatus orderApprovalStatus;

    private OrderApproval(Builder builder) {
        setId(builder.orderApprovalId);
        restaurantId = builder.restaurantId;
        orderId = builder.orderId;
        orderApprovalStatus = builder.orderApprovalStatus;
    }


    public RestaurantId getRestaurantId() {
        return restaurantId;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public OrderApprovalStatus getOrderApprovalStatus() {
        return orderApprovalStatus;
    }

    public static final class Builder {
        private OrderApprovalId orderApprovalId;
        private RestaurantId restaurantId;
        private OrderId orderId;
        private OrderApprovalStatus orderApprovalStatus;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder orderApprovalId(OrderApprovalId val) {
            orderApprovalId = val;
            return this;
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder orderApprovalStatus(OrderApprovalStatus val) {
            orderApprovalStatus = val;
            return this;
        }

        public OrderApproval build() {
            return new OrderApproval(this);
        }
    }
}
