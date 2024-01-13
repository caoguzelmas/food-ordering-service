package com.caoguzelmas.foodorderingservice.orderservice.domain.ports.output.repository;

import com.caoguzelmas.foodorderingservice.orderservice.domain.outbox.model.approval.OrderApprovalOutboxMessage;
import com.caoguzelmas.foodorderingservice.orderservice.domain.outbox.model.payment.OrderPaymentOutboxMessage;
import com.caoguzelmas.foodorderingservice.outbox.OutboxStatus;
import com.caoguzelmas.foodorderingservice.saga.SagaStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApprovalOutboxRepository {
    OrderApprovalOutboxMessage save(OrderApprovalOutboxMessage orderApprovalOutboxMessage);

    Optional<List<OrderApprovalOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type,
                                                                                     OutboxStatus outboxStatus,
                                                                                     SagaStatus... sagaStatus);

    Optional<OrderApprovalOutboxMessage> findByTypeAndSagaIdAndSagaStatus(String type,
                                                                         UUID sagaId,
                                                                         SagaStatus... sagaStatus);

    void deleteByTypeAndOutboxStatusAndSagaStatus(String type,
                                                  OutboxStatus outboxStatus,
                                                  SagaStatus... sagaStatus);

}
