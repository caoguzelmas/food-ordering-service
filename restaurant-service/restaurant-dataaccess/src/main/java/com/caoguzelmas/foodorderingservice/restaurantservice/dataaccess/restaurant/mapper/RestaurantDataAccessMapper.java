package com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.mapper;

import com.caoguzelmas.foodorderingservice.common.dataaccess.entity.RestaurantEntity;
import com.caoguzelmas.foodorderingservice.common.dataaccess.exception.RestaurantDataAccessException;
import com.caoguzelmas.foodorderingservice.domain.valueobject.Money;
import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.ProductId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.RestaurantId;
import com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.entity.OrderApprovalEntity;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.OrderApproval;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.OrderDetail;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.Product;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.Restaurant;
import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.valueobject.OrderApprovalId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RestaurantDataAccessMapper {

    public List<UUID> restaurantToRestaurantProducts(Restaurant restaurant) {
        return restaurant.getOrderDetail().getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Restaurant restaurantEntityToRestaurant(List<RestaurantEntity> restaurantEntities) {
        RestaurantEntity restaurantEntity = restaurantEntities.stream().findFirst().orElseThrow(() ->
                new RestaurantDataAccessException("No restaurants found!"));

        List<Product> restaurantProducts = restaurantEntities.stream().map(entity ->
                Product.Builder.builder()
                        .productId(new ProductId(entity.getProductId()))
                        .name(entity.getProductName())
                        .price(new Money(entity.getProductPrice()))
                        .available(entity.getProductAvailable())
                        .build()).toList();

        return Restaurant.Builder.builder()
                .restaurantId(new RestaurantId(restaurantEntity.getRestaurantId()))
                .orderDetail(OrderDetail.Builder.builder()
                        .products(restaurantProducts)
                        .build())
                .active(restaurantEntity.getRestaurantActive())
                .build();
    }

    public OrderApprovalEntity orderApprovalToOrderApprovalEntity(OrderApproval orderApproval) {
        return OrderApprovalEntity.builder()
                .id(orderApproval.getId().getValue())
                .restaurantId(orderApproval.getRestaurantId().getValue())
                .orderId(orderApproval.getOrderId().getValue())
                .status(orderApproval.getOrderApprovalStatus())
                .build();
    }

    public OrderApproval orderApprovalEntityToOrderApproval(OrderApprovalEntity orderApprovalEntity) {
        return OrderApproval.Builder.builder()
                .orderApprovalId(new OrderApprovalId(orderApprovalEntity.getId()))
                .restaurantId(new RestaurantId(orderApprovalEntity.getRestaurantId()))
                .orderId(new OrderId(orderApprovalEntity.getOrderId()))
                .orderApprovalStatus(orderApprovalEntity.getStatus())
                .build();
    }
}
