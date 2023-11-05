package com.foodorderingservice.orderservice.domain.ports.input.message.listener.restaurantapproval;

import com.foodorderingservice.orderservice.domain.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
