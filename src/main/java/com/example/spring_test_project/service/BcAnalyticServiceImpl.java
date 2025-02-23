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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    BcAnalyticServiceImpl proxy;

    public Long save() {
        ImportDetails id1 = new ImportDetails().setSessionId(UUID.randomUUID().toString());
        ImportDetails id2 = new ImportDetails().setSessionId(UUID.randomUUID().toString());
        BcAnalytic bcAnalytic = new BcAnalytic().setImportDetails(List.of(id1, id2));

        BcAnalytic save = repository.save(bcAnalytic);

        return save.getId();
    }

    public List<BcAnalyticDto> getAll() {
        List<BcAnalytic> all = repository.findAll();

        List<BcAnalyticDto> dto = mapper.toDto(all);

        return dto;
    }

    public String exec(String s) {
        return s;
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
