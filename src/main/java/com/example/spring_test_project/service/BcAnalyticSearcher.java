/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.mapper.BcAnalyticMapper;
import com.example.spring_test_project.model.BcAnalytic;
import com.example.spring_test_project.model.BcAnalyticDto;
import com.example.spring_test_project.repository.BcAnalyticRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BcAnalyticSearcher {

    private final BcAnalyticRepository repository;
    private final BatchOperationsExecutor batchOperationsExecutor;
    private final BcAnalyticLifecycleService lifecycleService;
    private final BgoService bgoService;
    private final BcAnalyticMapper mapper;

    @Autowired
    private EntityManager manager;

    public BcAnalyticDto getById(Supplier<Boolean> clearSupplier, Function<Integer, Boolean> function) {
        if (function.apply(10)) {
            manager.clear();
            System.out.println("function .apply()");
        }

        if (clearSupplier.get()) {
//            manager.clear();
            System.out.println("EntityManager .clear()");
        }

        Optional<BcAnalytic> byId = repository.findById(1L);
        return mapper.toDto(byId.get());
    }

}
