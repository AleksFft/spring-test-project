/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.listener.EventPublisher;
import com.example.spring_test_project.model.Record;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Service
public class RecordService {

    @Autowired
    EventPublisher publisher;

    public Record createRecord() {
        return new Record()
                .setDateTime(LocalDateTime.now())
                .setId(1L);
    }

    @Transactional
    public void readFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        String contentType = file.getContentType();

        log.info("readFile: originalFilename = {}, contentType = {}", originalFilename, contentType);
        publisher.publishCreateEvent(originalFilename);
    }

}
