package com.foodorderingservice.orderservice.messaging.listener.kafka;

import com.caoguzelmas.foodorderingservice.kafka.consumer.KafkaConsumer;
import com.caoguzelmas.foodorderingservice.kafka.order.avro.model.PaymentResponseAvroModel;
import com.caoguzelmas.foodorderingservice.kafka.order.avro.model.PaymentStatus;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import com.foodorderingservice.orderservice.messaging.mapper.OrderMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PaymentResponseKafkaListener implements KafkaConsumer<PaymentResponseAvroModel> {

    private final PaymentResponseMessageListener paymentResponseMessageListener;
    private final OrderMessagingDataMapper orderMessagingDataMapper;

    public PaymentResponseKafkaListener(PaymentResponseMessageListener paymentResponseMessageListener, OrderMessagingDataMapper orderMessagingDataMapper) {
        this.paymentResponseMessageListener = paymentResponseMessageListener;
        this.orderMessagingDataMapper = orderMessagingDataMapper;
    }

    @Override
    @KafkaListener(
            id = "${kafka-consumer-config.payment-consumer-group-id}",
            topics = "${order-service.payment-response-topic-name}")
    public void receive(@Payload List<PaymentResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment responses received with keys: {}, partitions: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(paymentResponseAvroModel -> {
            if (paymentResponseAvroModel.getPaymentStatus() == PaymentStatus.COMPLETED) {
                //TODO update paymentResponseAvroModel with order id
                log.info("Processing successful payment for order id : {}", "TODO");
                paymentResponseMessageListener.paymentCompleted(orderMessagingDataMapper
                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
            } else if (paymentResponseAvroModel.getPaymentStatus() == PaymentStatus.CANCELLED
                    || paymentResponseAvroModel.getPaymentStatus() == PaymentStatus.FAILED) {
                //TODO update paymentResponseAvroModel with order id
                log.info("Processing unsuccessful payment for order id : {}", "TODO");
                paymentResponseMessageListener.paymentCancelled(orderMessagingDataMapper
                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
            }
        });
    }
}
