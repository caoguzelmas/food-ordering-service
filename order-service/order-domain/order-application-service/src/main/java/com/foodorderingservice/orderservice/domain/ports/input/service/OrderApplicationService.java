package com.foodorderingservice.orderservice.domain.ports.input.service;

import com.foodorderingservice.orderservice.domain.dto.create.CreateOrderCommand;
import com.foodorderingservice.orderservice.domain.dto.create.CreateOrderResponse;
import com.foodorderingservice.orderservice.domain.dto.track.TrackOrderQuery;
import com.foodorderingservice.orderservice.domain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {

    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);

    TrackOrderResponse trackOrder(@Valid TrackOrderQuery trackOrderQuery);
}
