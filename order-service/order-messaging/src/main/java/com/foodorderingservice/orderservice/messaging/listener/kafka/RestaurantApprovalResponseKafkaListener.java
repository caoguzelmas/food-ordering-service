package com.foodorderingservice.orderservice.messaging.listener.kafka;

import com.caoguzelmas.foodorderingservice.kafka.consumer.KafkaConsumer;
import com.caoguzelmas.foodorderingservice.kafka.order.avro.model.OrderApprovalStatus;
import com.caoguzelmas.foodorderingservice.kafka.order.avro.model.RestaurantApprovalResponseAvroModel;
import com.caoguzelmas.foodorderingservice.orderservice.domain.ports.input.message.listener.restaurantapproval.RestaurantApprovalResponseMessageListener;
import com.foodorderingservice.orderservice.messaging.mapper.OrderMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.caoguzelmas.foodorderingservice.orderservice.domain.entity.Order.Builder.FAILURE_MESSAGE_DELIMITER;

@Slf4j
@Component
public class RestaurantApprovalResponseKafkaListener implements KafkaConsumer<RestaurantApprovalResponseAvroModel> {

    private final RestaurantApprovalResponseMessageListener restaurantApprovalResponseMessageListener;
    private final OrderMessagingDataMapper orderMessagingDataMapper;

    public RestaurantApprovalResponseKafkaListener(RestaurantApprovalResponseMessageListener restaurantApprovalResponseMessageListener, OrderMessagingDataMapper orderMessagingDataMapper) {
        this.restaurantApprovalResponseMessageListener = restaurantApprovalResponseMessageListener;
        this.orderMessagingDataMapper = orderMessagingDataMapper;
    }


    @Override
    @KafkaListener(
            id = "${kafka-consumer-config.restaurant-approval-consumer-group-id}",
            topics = "${order-service.restaurant-approval-response-topic-name}")
    public void receive(@Payload List<RestaurantApprovalResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of restaurant approval responses received with keys {}, partition: {} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(restaurantApprovalResponseAvroModel -> {
            if (restaurantApprovalResponseAvroModel.getOrderApprovalStatus() == OrderApprovalStatus.APPROVED) {
                log.info("Processing approved order for order id : {}", restaurantApprovalResponseAvroModel.getOrderId());

                restaurantApprovalResponseMessageListener.orderApproved(orderMessagingDataMapper
                        .approvalResponseAvroModelToApprovalResponse(restaurantApprovalResponseAvroModel));

            } else if (restaurantApprovalResponseAvroModel.getOrderApprovalStatus() == OrderApprovalStatus.REJECTED) {
                log.info("Processing rejected order for order id: {} with failure messages: {}",
                        restaurantApprovalResponseAvroModel.getOrderId(),
                        String.join(FAILURE_MESSAGE_DELIMITER, restaurantApprovalResponseAvroModel.getFailureMessages()));
                restaurantApprovalResponseMessageListener.orderRejected(orderMessagingDataMapper
                        .approvalResponseAvroModelToApprovalResponse(restaurantApprovalResponseAvroModel));
            }
        });
    }
}
