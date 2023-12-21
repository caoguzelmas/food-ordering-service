package com.caoguzelmas.foodorderingservice.restaurantservice.domain.ports.input.message.listener;

import com.caoguzelmas.foodorderingservice.restaurantservice.domain.dto.RestaurantApprovalRequest;

public interface RestaurantApprovalRequestMessageListener {

    void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest);
}
