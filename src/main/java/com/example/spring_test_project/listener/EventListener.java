/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
public class EventListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCreateEvent(CreateEvent event) {
        log.info("transaction commited = {}", event.getData());
    }

}
