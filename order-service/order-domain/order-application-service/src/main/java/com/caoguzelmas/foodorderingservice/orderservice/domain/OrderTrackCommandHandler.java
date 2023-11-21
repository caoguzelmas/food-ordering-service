package com.caoguzelmas.foodorderingservice.orderservice.domain;

import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.track.TrackOrderQuery;
import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.track.TrackOrderResponse;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;
import com.caoguzelmas.foodorderingservice.orderservice.domain.exception.OrderNotFoundException;
import com.caoguzelmas.foodorderingservice.orderservice.domain.mapper.OrderDataMapper;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository.OrderRepository;
import com.caoguzelmas.foodorderingservice.orderservice.domain.valueobject.TrackingId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class OrderTrackCommandHandler {

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;

    public OrderTrackCommandHandler(OrderDataMapper orderDataMapper, OrderRepository orderRepository) {
        this.orderDataMapper = orderDataMapper;
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public TrackOrderResponse trackOrder(TrackOrderQuery trackOrderQuery) {
        Optional<Order> optionalOrder = orderRepository.findByTrackingId(new TrackingId(trackOrderQuery.getOrderTrackingId()));

        if (optionalOrder.isEmpty()) {
            log.warn("Could not find order with tracking id: {}", trackOrderQuery.getOrderTrackingId());
            throw new OrderNotFoundException("Could not find order with tracking id: "
                    + trackOrderQuery.getOrderTrackingId());
        }

        return orderDataMapper.orderToTrackOrderResponse(optionalOrder.get());
    }
}
