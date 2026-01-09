/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr_Berestov
 */
@Component
@RequiredArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    /**
     * Публикует событие создания контрагента.
     *
     * @param data данные контрагента
     */
    public void publishCreateEvent(String data) {
        eventPublisher.publishEvent(new CreateEvent(data));
    }

}
