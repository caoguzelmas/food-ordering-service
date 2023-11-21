package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.input.message.listener.restaurantapproval;

import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.message.RestaurantApprovalResponse;

public interface RestaurantApprovalResponseMessageListener {

    void orderApproved(RestaurantApprovalResponse restaurantApprovalResponse);

    void orderRejected(RestaurantApprovalResponse restaurantApprovalResponse);
}
