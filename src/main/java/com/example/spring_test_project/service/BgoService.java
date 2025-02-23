/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.model.BackgroundOperation;
import com.example.spring_test_project.model.BackgroundOperationStatus;
import com.example.spring_test_project.repository.BackgroundOperationRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BgoService {

    @Autowired
    BackgroundOperationRepository repository;

    @Autowired
    private EntityManager entityManager;

    public BackgroundOperation startTask() {

        return repository.save(new BackgroundOperation()
                .setId(UUID.randomUUID())
                .setTotal(100)
                .setCompleted(0)
                .setStatus(BackgroundOperationStatus.NEW));
    }

    @Transactional
    public BackgroundOperation execute(UUID id) throws InterruptedException {
        BackgroundOperation bgo = repository.findById(id).orElseThrow(() -> new RuntimeException("BackgroundOperation not found"));
        bgo.setStatus(BackgroundOperationStatus.IN_PROGRESS);

        for (int i = 0; i < bgo.getTotal(); i++) {
            entityManager.clear();
            bgo = repository.findById(id).orElseThrow(() -> new RuntimeException("BackgroundOperation not found"));
            log.info("executeBgo() executing status = {}, completed = {}", bgo.getStatus(), bgo.getCompleted());
            if (bgo.getStatus() == BackgroundOperationStatus.IN_INTERRUPT_PROCESS) {
                break;
            }
            int completed = bgo.getCompleted();
            bgo.setCompleted(++completed);
            BackgroundOperation saved = repository.save(bgo);
            log.info("executeBgo() status = {}, completed = {}", saved.getStatus(), bgo.getCompleted());
            Thread.sleep(1000L);
        }

        return bgo;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public BackgroundOperation interrupt(UUID id) {

        BackgroundOperation bgo = repository.findById(id).orElseThrow(() -> new RuntimeException("BackgroundOperation not found"));

        log.info("interrupt() status = {}, completed = {}", bgo.getStatus(), bgo.getCompleted());

        bgo.setStatus(BackgroundOperationStatus.IN_INTERRUPT_PROCESS);
        repository.save(bgo);

        log.info("interrupt() status = {}, completed = {}", bgo.getStatus(), bgo.getCompleted());

        return bgo;
    }

}
