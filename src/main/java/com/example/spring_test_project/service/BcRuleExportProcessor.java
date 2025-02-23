/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.service;

import com.example.spring_test_project.export.ExportRequest;
import com.example.spring_test_project.export.ExportResponse;
import com.example.spring_test_project.model.Record;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class BcRuleExportProcessor {

    private final ValidatorService validatorService;

    public ExportResponse getExportResponse(ExportRequest request) {
        log.info(request.toString());
        return ExportResponse.of(fileName(),new byte[]{1,1}, UUID.randomUUID().toString());
    }

    public String concatStr(String s) {
        return s + " bla bla";
    }

    public Record createRecord(String s) {
        validatorService.validateStr(s);

        return new Record().setName(s);
    }

    public Record createRecord(String s, String s2) {

        fileName();
        return new Record().setName(s);
    }

    private String fileName() {
        return "file.csv";
    }

    private String fileName(String s) {
        return s + "file.csv";
    }


}
