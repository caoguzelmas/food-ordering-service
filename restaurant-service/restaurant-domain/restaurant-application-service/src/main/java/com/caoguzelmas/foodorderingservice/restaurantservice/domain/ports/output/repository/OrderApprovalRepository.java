package com.caoguzelmas.foodorderingservice.restaurantservice.domain.ports.output.repository;

import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);
}
