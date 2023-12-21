package com.caoguzelmas.foodorderingservice.restaurantservice.domain.mapper;

import com.caoguzelmas.foodorderingservice.domain.valueobject.Money;
import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderStatus;
import com.caoguzelmas.foodorderingservice.domain.valueobject.RestaurantId;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.OrderDetail;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.Product;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.Restaurant;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.dto.RestaurantApprovalRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataMapper {
    public Restaurant restaurantApprovalRequestToRestaurant(RestaurantApprovalRequest
                                                                             restaurantApprovalRequest) {
        return Restaurant.Builder.builder()
                .restaurantId(new RestaurantId(UUID.fromString(restaurantApprovalRequest.getRestaurantId())))
                .orderDetail(OrderDetail.Builder.builder()
                        .orderId(new OrderId(UUID.fromString(restaurantApprovalRequest.getOrderId())))
                        .products(restaurantApprovalRequest.getProducts().stream().map(
                                product -> Product.Builder.builder()
                                        .productId(product.getId())
                                        .quantity(product.getQuantity())
                                        .build())
                                .collect(Collectors.toList()))
                        .totalAmount(new Money(restaurantApprovalRequest.getPrice()))
                        .orderStatus(OrderStatus.valueOf(restaurantApprovalRequest.getRestaurantOrderStatus().name()))
                        .build())
                .build();

    }
}
