/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.model.Record;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author Aleksandr_Berestov
 */
@Service
public class RecordService {

    public Record createRecord() {
        return new Record()
                .setDateTime(LocalDateTime.now())
                .setId(1L);
    }

}
