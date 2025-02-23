/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.mapper.BcAnalyticMapper;
import com.example.spring_test_project.model.BcAnalytic;
import com.example.spring_test_project.model.BcMarkupDto;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BcAnalyticLifecycleService {

    private final BcAnalyticMapper mapper;

    @Transactional
    public Try<BcAnalytic> update(BcAnalytic entity, BcMarkupDto markupDto) {

        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();

        log.info("BcAnalyticLifecycleService currentTransactionName = {}", currentTransactionName);

        Map<String, Object> param = new HashMap<>();
        param.put("DTO", markupDto);
        param.put("entity", entity);

        entity.setName("BcAnalyticLifecycleService " + entity.getId());

//        if (entity.getId().equals(2L)) {
//            return Try.failure(new RuntimeException());
//        }

        return Try.of(() -> new BcAnalytic().setName("BcAnalyticLifecycleService " + entity.getId()));
    }

}
