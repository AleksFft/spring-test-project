/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.model.BcAnalytic;
import com.example.spring_test_project.model.ImportDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BatchOperationsExecutor {

    public <T extends BcAnalytic> List<ImportDetails> executeByList(
            List<Long> ids,
            Function<List<Long>, List<T>> function,
            Consumer<T> processor) {

        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();

        log.info("BatchOperationsExecutor currentTransactionName = {}", currentTransactionName);

        List<T> entities = function.apply(ids);

        for (T t : entities) {
            processor.accept(t);
        }

        List<ImportDetails> collect = entities.stream()
                .map(BcAnalytic::getImportDetails)
                .flatMap(List::stream)
                .toList();
        return collect;
    }

}
