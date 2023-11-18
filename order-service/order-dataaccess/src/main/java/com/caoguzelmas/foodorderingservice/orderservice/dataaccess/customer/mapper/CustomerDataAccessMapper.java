package com.caoguzelmas.foodorderingservice.orderservice.dataaccess.customer.mapper;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.orderservice.dataaccess.customer.entity.CustomerEntity;
import com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}
