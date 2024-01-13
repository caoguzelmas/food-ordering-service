package com.caoguzelmas.foodorderingservice.outbox;

public interface OutboxScheduler {

    void processOutboxMessage();
}
