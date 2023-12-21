package com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.repository;

import com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.entity.OrderApprovalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderApprovalJpaRepository extends JpaRepository<OrderApprovalEntity, UUID> {
}
