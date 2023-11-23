package com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.creditentry.adapter;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository.CreditEntryRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.creditentry.mapper.CreditEntryDataAccessMapper;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.creditentry.repository.CreditEntryJpaRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditEntry;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreditEntryRepositoryImpl implements CreditEntryRepository {

    private final CreditEntryJpaRepository creditEntryJpaRepository;
    private final CreditEntryDataAccessMapper creditEntryDataAccessMapper;

    public CreditEntryRepositoryImpl(CreditEntryJpaRepository creditEntryJpaRepository,
                                     CreditEntryDataAccessMapper creditEntryDataAccessMapper) {
        this.creditEntryJpaRepository = creditEntryJpaRepository;
        this.creditEntryDataAccessMapper = creditEntryDataAccessMapper;
    }

    @Override
    public CreditEntry save(CreditEntry creditEntry) {
        return creditEntryDataAccessMapper.creditEntryEntityToCreditEntry(creditEntryJpaRepository
                .save(creditEntryDataAccessMapper.creditEntryToCreditEntryEntity(creditEntry)));
    }

    @Override
    public Optional<CreditEntry> findByCustomerId(CustomerId customerId) {
        return creditEntryJpaRepository.findByCustomerId(customerId.getValue())
                .map(creditEntryDataAccessMapper::creditEntryEntityToCreditEntry);
    }
}
