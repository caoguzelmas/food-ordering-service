package com.foodorderingservice.orderservice.domain.ports.output.repository;

import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);
}
