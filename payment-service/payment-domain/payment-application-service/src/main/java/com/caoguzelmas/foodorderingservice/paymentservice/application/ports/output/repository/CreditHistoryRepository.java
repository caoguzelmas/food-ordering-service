package com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditHistory;

import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {

    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
