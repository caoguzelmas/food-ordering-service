package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.input.service;

import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.create.CreateOrderCommand;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.create.CreateOrderResponse;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.track.TrackOrderQuery;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
