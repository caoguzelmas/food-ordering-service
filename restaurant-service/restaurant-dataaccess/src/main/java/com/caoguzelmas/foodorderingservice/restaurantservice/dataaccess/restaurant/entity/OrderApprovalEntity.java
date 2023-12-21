package com.caoguzelmas.foodorderingservice.restaurantservice.dataaccess.restaurant.entity;

import com.caoguzelmas.foodorderingservice.domain.valueobject.OrderApprovalStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_approval", schema = "restaurant")
@Entity
public class OrderApprovalEntity {

    @Id
    private UUID id;
    private UUID restaurantId;
    private UUID orderId;
    @Enumerated
    private OrderApprovalStatus status;
}
