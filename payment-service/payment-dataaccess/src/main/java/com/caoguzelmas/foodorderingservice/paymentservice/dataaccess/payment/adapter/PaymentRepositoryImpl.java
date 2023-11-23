package com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.payment.adapter;

import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository.PaymentRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.payment.mapper.PaymentDataAccessMapper;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.payment.repository.PaymentJpaRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentDataAccessMapper paymentDataAccessMapper;

    public PaymentRepositoryImpl(PaymentJpaRepository paymentJpaRepository,
                                 PaymentDataAccessMapper paymentDataAccessMapper) {
        this.paymentJpaRepository = paymentJpaRepository;
        this.paymentDataAccessMapper = paymentDataAccessMapper;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentDataAccessMapper.paymentEntityToPayment(paymentJpaRepository
                .save(paymentDataAccessMapper.paymentToPaymentEntity(payment)));
    }

    @Override
    public Optional<Payment> findByOrderId(UUID orderId) {
        return paymentJpaRepository.findByOrderId(orderId)
                .map(paymentDataAccessMapper::paymentEntityToPayment);
    }
}
