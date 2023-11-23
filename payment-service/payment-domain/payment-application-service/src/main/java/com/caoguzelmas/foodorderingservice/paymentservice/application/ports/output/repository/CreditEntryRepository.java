package com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditEntry;

import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
