package com.caoguzelmas.foodorderingservice.restaurantservice.domain.ports.output.repository;

import com.caoguzelmas.foodorderingservice.restaurantservice.domain.core.entity.Restaurant;

import java.util.Optional;

public interface RestaurantRepository {

    Optional<Restaurant> findRestaurantInformation(Restaurant restaurant);
}
