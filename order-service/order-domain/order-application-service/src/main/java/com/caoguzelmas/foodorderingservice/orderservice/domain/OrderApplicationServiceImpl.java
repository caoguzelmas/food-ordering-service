package com.caoguzelmas.foodorderingservice.orderservice.domain;

import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.create.CreateOrderCommand;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.create.CreateOrderResponse;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.track.TrackOrderQuery;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.track.TrackOrderResponse;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class OrderApplicationServiceImpl implements OrderApplicationService {

    private final OrderCreateCommandHandler orderCreateCommandHandler;
    private final OrderTrackCommandHandler orderTrackCommandHandler;

    OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler, OrderTrackCommandHandler orderTrackCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
        this.orderTrackCommandHandler = orderTrackCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }

    @Override
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        return orderTrackCommandHandler.trackOrder(trackOrderQuery);
    }
}
