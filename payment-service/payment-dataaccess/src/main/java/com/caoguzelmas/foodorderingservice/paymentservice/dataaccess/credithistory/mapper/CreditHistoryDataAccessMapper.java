package com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.credithistory.mapper;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.Money;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.credithistory.entity.CreditHistoryEntity;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditHistory;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.valueobject.CreditHistoryId;
import org.springframework.stereotype.Component;

@Component
public class CreditHistoryDataAccessMapper {

    public CreditHistory creditHistoryEntityToCreditHistory(CreditHistoryEntity creditHistoryEntity) {
        return CreditHistory.Builder.builder()
                .creditHistoryId(new CreditHistoryId(creditHistoryEntity.getCustomerId()))
                .customerId(new CustomerId(creditHistoryEntity.getCustomerId()))
                .amount(new Money(creditHistoryEntity.getAmount()))
                .transactionType(creditHistoryEntity.getTransactionType())
                .build();
    }

    public CreditHistoryEntity creditHistoryToCreditHistoryEntity(CreditHistory creditHistory) {
        return CreditHistoryEntity.builder()
                .id(creditHistory.getId().getValue())
                .customerId(creditHistory.getCustomerId().getValue())
                .amount(creditHistory.getAmount().getAmount())
                .transactionType(creditHistory.getTransactionType())
                .build();
    }
}
