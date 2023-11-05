package com.foodorderingservice.orderservice.domain.ports.input.message.listener.payment;

import com.foodorderingservice.orderservice.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
