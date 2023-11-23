package com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.creditentry.mapper;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.domain.valueobject.Money;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.creditentry.entity.CreditEntryEntity;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditEntry;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.valueobject.CreditEntryId;
import org.springframework.stereotype.Component;

@Component
public class CreditEntryDataAccessMapper {

    public CreditEntry creditEntryEntityToCreditEntry(CreditEntryEntity creditEntryEntity) {
        return CreditEntry.Builder.builder()
                .creditEntryId(new CreditEntryId(creditEntryEntity.getId()))
                .customerId(new CustomerId(creditEntryEntity.getCustomerId()))
                .totalCreditAmount(new Money(creditEntryEntity.getTotalCreditAmount()))
                .build();
    }

    public CreditEntryEntity creditEntryToCreditEntryEntity(CreditEntry creditEntry) {
        return CreditEntryEntity.builder()
                .id(creditEntry.getId().getValue())
                .customerId(creditEntry.getCustomerId().getValue())
                .totalCreditAmount(creditEntry.getTotalCreditAmount().getAmount())
                .build();
    }
}
