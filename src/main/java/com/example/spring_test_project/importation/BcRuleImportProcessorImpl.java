/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.importation;

import com.example.spring_test_project.model.BcRuleRecord;
import com.example.spring_test_project.model.BcRuleRecordDto;
import com.example.spring_test_project.model.BcRuleRecordMapper;
import com.example.spring_test_project.model.BcRuleRecordResponse;
import com.example.spring_test_project.repository.BcRuleRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
public class BcRuleImportProcessorImpl {

    @Autowired
    private BcRuleCsvParser csvParser;
    @Autowired
    private BcRuleRecordRepository recordRepository;
    @Autowired
    private BcRuleRecordMapper recordMapper;

    @Transactional
    public BcRuleRecordResponse readFile(MultipartFile file) {
        String sessionId = UUID.randomUUID().toString();


        long startTime = System.nanoTime();

        List<BcRuleRecordDto> records = csvParser.parse(file);

        long endTime = System.nanoTime();
        long executionTimeNano = endTime - startTime;
        double time = (double) executionTimeNano / 1_000_000_000;
        log.info("csvParser.parse {}", time);


        startTime = System.nanoTime();

        records.forEach(r -> r.setImportSessionId(sessionId));

        endTime = System.nanoTime();
        executionTimeNano = endTime - startTime;
        time = (double) executionTimeNano / 1_000_000_000;
        log.info("records.forEach {}", time);


        startTime = System.nanoTime();

        List<BcRuleRecord> domainModel = recordMapper.toDomainModel(records);

        endTime = System.nanoTime();
        executionTimeNano = endTime - startTime;
        time = (double) executionTimeNano / 1_000_000_000;
        log.info("recordMapper.toDomainModel {}", time);


        startTime = System.nanoTime();

        recordRepository.saveAll(domainModel);

        endTime = System.nanoTime();
        executionTimeNano = endTime - startTime;
        time = (double) executionTimeNano / 1_000_000_000;
        log.info("recordRepository.saveAll {}", time);

        startTime = System.nanoTime();

        recordRepository.flush();

        endTime = System.nanoTime();
        executionTimeNano = endTime - startTime;
        time = (double) executionTimeNano / 1_000_000_000;
        log.info("recordRepository.flush {}", time);

        return new BcRuleRecordResponse();
    }

}
