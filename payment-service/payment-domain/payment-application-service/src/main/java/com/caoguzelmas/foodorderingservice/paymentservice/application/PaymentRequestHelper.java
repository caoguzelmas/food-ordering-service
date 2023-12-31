package com.caoguzelmas.foodorderingservice.paymentservice.application;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.paymentservice.application.dto.PaymentRequest;
import com.caoguzelmas.foodorderingservice.paymentservice.application.exception.PaymentApplicationServiceException;
import com.caoguzelmas.foodorderingservice.paymentservice.application.mapper.PaymentDataMapper;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.message.publisher.PaymentFailedMessagePublisher;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository.CreditEntryRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository.CreditHistoryRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository.PaymentRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.PaymentDomainService;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditEntry;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditHistory;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.Payment;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.event.PaymentEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PaymentRequestHelper {

    private final PaymentDomainService paymentDomainService;
    private final PaymentDataMapper paymentDataMapper;
    private final PaymentRepository paymentRepository;
    private final CreditEntryRepository creditEntryRepository;
    private final CreditHistoryRepository creditHistoryRepository;
    private final PaymentCompletedMessagePublisher paymentCompletedEventDomainEventPublisher;
    private final PaymentCancelledMessagePublisher paymentCanceledEventDomainEventPublisher;
    private final PaymentFailedMessagePublisher paymentFailedEventDomainEventPublisher;

    public PaymentRequestHelper(PaymentDomainService paymentDomainService,
                                PaymentDataMapper paymentDataMapper,
                                PaymentRepository paymentRepository,
                                CreditEntryRepository creditEntryRepository,
                                CreditHistoryRepository creditHistoryRepository,
                                PaymentCompletedMessagePublisher paymentCompletedEventDomainEventPublisher,
                                PaymentCancelledMessagePublisher paymentCanceledEventDomainEventPublisher,
                                PaymentFailedMessagePublisher paymentFailedEventDomainEventPublisher) {
        this.paymentDomainService = paymentDomainService;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentRepository = paymentRepository;
        this.creditEntryRepository = creditEntryRepository;
        this.creditHistoryRepository = creditHistoryRepository;
        this.paymentCompletedEventDomainEventPublisher = paymentCompletedEventDomainEventPublisher;
        this.paymentCanceledEventDomainEventPublisher = paymentCanceledEventDomainEventPublisher;
        this.paymentFailedEventDomainEventPublisher = paymentFailedEventDomainEventPublisher;
    }

    @Transactional
    public PaymentEvent persistPayment(PaymentRequest paymentRequest) {
        log.info("Received payment complete event for order id: {}", paymentRequest.getOrderId());
        Payment payment = paymentDataMapper.paymentRequestModelToPayment(paymentRequest);
        CreditEntry creditEntry = getCreditEntry(payment.getCustomerId());
        List<CreditHistory> creditHistories = getCreditHistories(payment.getCustomerId());
        List<String> failureMessages = new ArrayList<>();

        PaymentEvent paymentEvent = paymentDomainService.validateAndInitiatePayment(payment, creditEntry,
                creditHistories, failureMessages, paymentCompletedEventDomainEventPublisher, paymentFailedEventDomainEventPublisher);
        persistDbObject(payment, creditEntry, creditHistories, failureMessages);

        return paymentEvent;
    }

    @Transactional
    public PaymentEvent persistCancelPayment(PaymentRequest paymentRequest) {
        log.info("Received payment rollback event for order id: {}", paymentRequest.getOrderId());
        Optional<Payment> paymentResponse = paymentRepository.findByOrderId(UUID.fromString(paymentRequest.getOrderId()));

        if (paymentResponse.isEmpty()) {
            log.error("Payment with order id: {} could not be found", paymentRequest.getOrderId());
            throw new PaymentApplicationServiceException("Payment with order id: " + paymentRequest.getOrderId() +
                    " could not be found");
        }
        Payment payment = paymentResponse.get();
        CreditEntry creditEntry = getCreditEntry(payment.getCustomerId());
        List<CreditHistory> creditHistories = getCreditHistories(payment.getCustomerId());
        List<String> failureMessages = new ArrayList<>();

        PaymentEvent paymentEvent = paymentDomainService.validateAndCancelPayment(payment, creditEntry, creditHistories,
                failureMessages, paymentCanceledEventDomainEventPublisher, paymentFailedEventDomainEventPublisher);
        persistDbObject(payment, creditEntry, creditHistories, failureMessages);

        return paymentEvent;
    }

    private void persistDbObject(Payment payment, CreditEntry creditEntry, List<CreditHistory> creditHistories, List<String> failureMessages) {
        paymentRepository.save(payment);

        if (failureMessages.isEmpty()) {
            creditEntryRepository.save(creditEntry);
            creditHistoryRepository.save(creditHistories.get(creditHistories.size() - 1));
        }
    }

    private CreditEntry getCreditEntry(CustomerId customerId) {
        Optional<CreditEntry> creditEntry = creditEntryRepository.findByCustomerId(customerId);

        if (creditEntry.isEmpty()) {
            log.error("Could not find credit entry for customer: {}", customerId.getValue());
            throw new PaymentApplicationServiceException("Could not find credit entry for customer: " +
                    customerId.getValue());
        }
        return creditEntry.get();
    }

    private List<CreditHistory> getCreditHistories(CustomerId customerId) {
        Optional<List<CreditHistory>> creditHistories = creditHistoryRepository.findByCustomerId(customerId);

        if (creditHistories.isEmpty()) {
            log.error("Could not find credit history for customer: {}", customerId.getValue());
            throw new PaymentApplicationServiceException("Could not find credit history for customer: " +
                    customerId.getValue());
        }
        return creditHistories.get();
    }
}
