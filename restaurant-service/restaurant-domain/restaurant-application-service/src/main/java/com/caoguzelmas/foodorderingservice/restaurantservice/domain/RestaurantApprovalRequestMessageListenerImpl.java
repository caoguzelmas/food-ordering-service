package com.caoguzelmas.foodorderingservice.restaurantservice.domain;

import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.event.OrderApprovalEvent;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.dto.RestaurantApprovalRequest;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.ports.input.message.listener.RestaurantApprovalRequestMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RestaurantApprovalRequestMessageListenerImpl implements RestaurantApprovalRequestMessageListener {

    private final RestaurantApprovalRequestHelper restaurantApprovalRequestHelper;

    public RestaurantApprovalRequestMessageListenerImpl(RestaurantApprovalRequestHelper
                                                                restaurantApprovalRequestHelper) {
        this.restaurantApprovalRequestHelper = restaurantApprovalRequestHelper;
    }

    @Override
    public void approveOrder(RestaurantApprovalRequest restaurantApprovalRequest) {
        OrderApprovalEvent orderApprovalEvent = restaurantApprovalRequestHelper
                .persistOrderApproval(restaurantApprovalRequest);
        orderApprovalEvent.fire();
    }
}
