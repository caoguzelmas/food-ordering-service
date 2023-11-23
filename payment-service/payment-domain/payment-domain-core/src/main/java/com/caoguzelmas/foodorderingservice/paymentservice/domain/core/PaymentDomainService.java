package com.caoguzelmas.foodorderingservice.paymentservice.domain.core;

import com.caoguzelmas.foodorderingservice.domain.event.publisher.DomainEventPublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditEntry;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditHistory;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentCanceledEvent;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentCompletedEvent;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentEvent;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentFailedEvent;

import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages,
                                            DomainEventPublisher<PaymentCompletedEvent> paymentCompletedEventDomainEventPublisher,
                                            DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages, DomainEventPublisher<PaymentCanceledEvent> paymentCanceledEventDomainEventPublisher, DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);
}
