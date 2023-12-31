package com.caoguzelmas.foodorderingservice.orderservice.domain.dto.message;

import com.caoguzelmas.foodorderingservice.domain.valueobject.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {

    private String id;
    private String sagaId;
    private String orderId;
    private String customerId;
    private String paymentId;
    private BigDecimal price;
    private Instant createdAt;
    private PaymentStatus paymentStatus;
    private List<String> failureMessages;
}
