/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ValidatorService {

    @Lazy
    @Autowired
    private BcRuleExportProcessor exportProcessor;

    public void validate(String s) {
        String s1 = exportProcessor.concatStr(s);

        log.info("result str {}", s1);
    }

    public void validateStr(String s) {
        if (!s.isEmpty()) {
            log.info("ValidatorService .validateStr() ok");
        } else {
            throw new RuntimeException("short string");
        }
    }

    public String conc(String s, String s2) {
       return s + s2;
    }
}
