package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.input.message.listener.payment;

import com.caoguzelmas.foodorderingservice.orderservice.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
