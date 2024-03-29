package com.caoguzelmas.foodorderingservice.orderservice.domain;

import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.create.CreateOrderCommand;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Customer;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Restaurant;
import com.caoguzelmas.foodorderingservice.orderservice.domain.event.OrderCreatedEvent;
import com.caoguzelmas.foodorderingservice.orderservice.domain.exception.OrderDomainException;
import com.caoguzelmas.foodorderingservice.orderservice.domain.mapper.OrderDataMapper;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository.CustomerRepository;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository.OrderRepository;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository.RestaurantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateHelper {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final RestaurantRepository restaurantRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateHelper(OrderDomainService orderDomainService,
                             OrderRepository orderRepository,
                             CustomerRepository customerRepository,
                             RestaurantRepository restaurantRepository,
                             OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.restaurantRepository = restaurantRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomerExists(createOrderCommand.getCustomerId());
        Restaurant restaurant = checkRestaurant(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);

        OrderCreatedEvent orderCreatedEvent = orderDomainService
                .validateAndInitiateOrder(order, restaurant);
        saveOrder(order);

        log.info("Order is created with order id: {}", order.getId().getValue());
        return orderCreatedEvent;
    }

    private void checkCustomerExists(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);

        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customer);
        }
    }

    private Restaurant checkRestaurant(CreateOrderCommand createOrderCommand) {
        Restaurant restaurant = orderDataMapper.createOrderCommandToRestaurant(createOrderCommand);
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findRestaurantInformation(restaurant);

        if (optionalRestaurant.isEmpty()) {
            log.warn("Could not find restaurant with restaurant id: {}", createOrderCommand.getRestaurantId());
            throw new OrderDomainException("Could not find restaurant with restaurant id: "
                    + createOrderCommand.getRestaurantId());
        }

        return  optionalRestaurant.get();
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);

        if (orderResult == null) {
            log.warn("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }

        log.info("Order is saved with id: {}", orderResult.getId().getValue());
        return orderResult;
    }
}
