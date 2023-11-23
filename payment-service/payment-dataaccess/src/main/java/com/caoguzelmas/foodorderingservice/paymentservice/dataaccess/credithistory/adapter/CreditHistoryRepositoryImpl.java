package com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.credithistory.adapter;

import com.caoguzelmas.foodorderingservice.domain.valueobject.CustomerId;
import com.caoguzelmas.foodorderingservice.paymentservice.application.ports.output.repository.CreditHistoryRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.creditentry.mapper.CreditEntryDataAccessMapper;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.credithistory.entity.CreditHistoryEntity;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.credithistory.mapper.CreditHistoryDataAccessMapper;
import com.caoguzelmas.foodorderingservice.paymentservice.dataaccess.credithistory.repository.CreditHistoryJpaRepository;
import com.caoguzelmas.foodorderingservice.paymentservice.domain.core.entity.CreditHistory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CreditHistoryRepositoryImpl implements CreditHistoryRepository {

    private final CreditHistoryJpaRepository creditHistoryJpaRepository;
    private final CreditHistoryDataAccessMapper creditHistoryDataAccessMapper;

    public CreditHistoryRepositoryImpl(CreditHistoryJpaRepository creditHistoryJpaRepository,
                                       CreditHistoryDataAccessMapper creditHistoryDataAccessMapper) {
        this.creditHistoryJpaRepository = creditHistoryJpaRepository;
        this.creditHistoryDataAccessMapper = creditHistoryDataAccessMapper;
    }

    @Override
    public CreditHistory save(CreditHistory creditHistory) {
        return creditHistoryDataAccessMapper.creditHistoryEntityToCreditHistory(creditHistoryJpaRepository
                .save(creditHistoryDataAccessMapper.creditHistoryToCreditHistoryEntity(creditHistory)));
    }

    @Override
    public Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId) {
        Optional<List<CreditHistoryEntity>> creditHistories = creditHistoryJpaRepository.findByCustomerId(customerId.getValue());

        return creditHistories.map(creditHistoryEntities ->
                creditHistoryEntities.stream()
                        .map(creditHistoryDataAccessMapper::creditHistoryEntityToCreditHistory)
                        .collect(Collectors.toList()));
    }
}
