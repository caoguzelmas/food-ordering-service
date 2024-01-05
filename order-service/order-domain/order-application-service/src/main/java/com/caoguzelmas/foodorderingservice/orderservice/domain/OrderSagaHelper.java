package com.caoguzelmas.foodorderingservice.orderservice.domain;

import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderId;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;
import com.caoguzelmas.foodorderingservice.orderservice.domain.exception.OrderNotFoundException;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderSagaHelper {

    private final OrderRepository orderRepository;

    public OrderSagaHelper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrder(String orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(new OrderId(UUID.fromString(orderId)));

        if (optionalOrder.isEmpty()) {
            log.error("Order with id: {} could not ne found!", orderId);
            throw new OrderNotFoundException("Order with id " + orderId + " could not be found!");
        }

        return optionalOrder.get();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
