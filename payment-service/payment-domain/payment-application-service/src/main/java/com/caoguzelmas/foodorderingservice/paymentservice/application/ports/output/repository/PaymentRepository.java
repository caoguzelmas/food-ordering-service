package com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository;

import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;

import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findByOrderId(UUID orderId);
}
