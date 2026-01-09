/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.mapper.BcAnalyticMapper;
import com.example.spring_test_project.model.BcAnalytic;
import com.example.spring_test_project.model.BcAnalyticDto;
import com.example.spring_test_project.model.BcMarkupDto;
import com.example.spring_test_project.model.ImportDetails;
import com.example.spring_test_project.repository.BcAnalyticRepository;
import io.vavr.control.Try;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Aleksandr_Berestov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class BcAnalyticServiceImpl {

    private final BcAnalyticRepository repository;
    private final BatchOperationsExecutor batchOperationsExecutor;
    private final BcAnalyticLifecycleService lifecycleService;
    private final BgoService bgoService;
    private final BcAnalyticMapper mapper;

    @Autowired
    private EntityManager manager;
    @Autowired
    private BcAnalyticSearcher searcher;

    @Autowired
    BcAnalyticServiceImpl proxy;

    public Long save() {
        for (int i = 0; i < 50; i++) {
            repository.save(new BcAnalytic()
                    .setName("name")
                    .setCounter(i)
            );
        }

        return 50L;
    }

    public List<BcAnalyticDto> getAll() {
        List<BcAnalyticDto> l = new ArrayList<>();
        for (int j = 0; j < 50; j++) {
            System.out.println("getAll() j = " + j);
            BcAnalyticDto dto = searcher.getById(isNeedToClear(j), func(j));
            l.add(dto);
        }

        return l;
    }

    private Supplier<Boolean> isNeedToClear(int i) {
        return () -> i % 10 == 0;
    }

    private Function<Integer, Boolean> func(Integer a) {
        return (intA) -> a % intA == 0;
    }

    @Transactional
    public List<ImportDetails> executeMarkup(BcMarkupDto dto) {
        log.info("BcAnalyticServiceImpl currentTransactionName = {}", TransactionSynchronizationManager.getCurrentTransactionName());

        List<ImportDetails> s = batchOperationsExecutor.executeByList(
                dto.getDocIds(),
                repository::findAllById,
                doc -> this.markupDoc(doc, dto)
        );

        return s;
    }


    public void markupDoc(BcAnalytic doc, BcMarkupDto dto) {
        Try<BcAnalytic> update = lifecycleService.update(doc, dto);

        update
                .map(repository::save)
                .getOrElseThrow(() -> new RuntimeException());
    }

}
