package com.foodorderingservice.orderservice.domain.ports.output.repository;


import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
