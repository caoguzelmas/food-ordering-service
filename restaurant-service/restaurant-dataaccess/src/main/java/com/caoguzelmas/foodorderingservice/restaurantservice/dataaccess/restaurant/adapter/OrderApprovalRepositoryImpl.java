package com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.adapter;

import com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.mapper.RestaurantDataAccessMapper;
import com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.repository.OrderApprovalJpaRepository;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.OrderApproval;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.ports.output.repository.OrderApprovalRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderApprovalRepositoryImpl implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final RestaurantDataAccessMapper restaurantDataAccessMapper;

    public OrderApprovalRepositoryImpl(OrderApprovalJpaRepository orderApprovalJpaRepository,
                                       RestaurantDataAccessMapper restaurantDataAccessMapper) {
        this.orderApprovalJpaRepository = orderApprovalJpaRepository;
        this.restaurantDataAccessMapper = restaurantDataAccessMapper;
    }

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        return restaurantDataAccessMapper.orderApprovalEntityToOrderApproval(orderApprovalJpaRepository
                .save(restaurantDataAccessMapper.orderApprovalToOrderApprovalEntity(orderApproval)));
    }
}
