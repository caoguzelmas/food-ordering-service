package com.caoguzelmas.foodorderingservice.paymentservice.application.ports.input.message.listener;

import com.caoguzelmas.foodorderingservice.paymentservice.application.dto.PaymentRequest;

public interface PaymentRequestMessageListener {

    void completePayment(PaymentRequest paymentRequest);

    void cancelPayment(PaymentRequest paymentRequest);
}
