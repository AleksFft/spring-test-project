/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.resource;

import com.example.spring_test_project.RecordRepository;
import com.example.spring_test_project.export.ExportFullResponse;
import com.example.spring_test_project.export.ExportRequest;
import com.example.spring_test_project.importation.BcRuleImportProcessorImpl;
import com.example.spring_test_project.model.BcAnalyticImportResultDto;
import com.example.spring_test_project.model.BcRuleRecordResponse;
import com.example.spring_test_project.model.Payment;
import com.example.spring_test_project.model.Record;
import com.example.spring_test_project.service.BcRuleExportProcessor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@RestController
@RequestMapping(value = "api/post")
@Tag(name = "Экспорт правил разметки")
@RequiredArgsConstructor
public class MyResource {

    private final BcRuleExportProcessor exportProcessor;
    private final RecordRepository repository;
    private final BcRuleImportProcessorImpl importProcessor;

    @PostMapping
    @Operation(summary = "Формировать файл правил разметки")
    ResponseEntity<byte[]> exportBcRule(@RequestBody ExportRequest request) {
        return exportProcessor.getExportResponse(request).responseEntity();
    }

    @PostMapping("/full-response")
    @Operation(summary = "Формировать файл правил разметки")
    ExportFullResponse exportBcRule2(@RequestBody ExportRequest request) {
        return new ExportFullResponse()
                .setFullResponse(request.toString())
                .setResponseEntity(exportProcessor.getExportResponse(request).responseEntity());
    }

    @GetMapping("/create-record/{s}")
    @Operation(summary = "Поиск правила по имени")
    public Record create(@PathVariable(value = "s") String s) throws IOException {
        return exportProcessor.createRecord(s);
    }

    @PostMapping(value = "/read-file")
    @Operation(summary = "Чтение файла правил разметки")
    public BcRuleRecordResponse readFile(@RequestParam("file") MultipartFile file) throws IOException {
        BcRuleRecordResponse bcRuleRecordResponse = importProcessor.readFile(file);

        return bcRuleRecordResponse;
    }

    @GetMapping("/bgo/report/{taskId}")
    @Operation(summary = "Получить отчет об операции по task Id")
    public BcAnalyticImportResultDto getReport(@PathVariable("taskId") String taskId) {
        BcAnalyticImportResultDto rs = new BcAnalyticImportResultDto()
                .setCount(3)
                .setCorrectCount(1)
                .setErrorCount(2)
                .setSessionId(taskId)
                .setImportDate(LocalDate.now());


        log.info("BcAnalyticImportResource .getReport() response = {}", rs);
        return rs;
    }

    @GetMapping("/bgo/report")
    @Operation(summary = "Получить отчет об операции по task Id")
    public BcAnalyticImportResultDto getReport2() {
        BcAnalyticImportResultDto rs = new BcAnalyticImportResultDto()
                .setCount(3)
                .setCorrectCount(1)
                .setErrorCount(2)
                .setSessionId("taskId")
                .setImportDate(LocalDate.now());


        log.info("BcAnalyticImportResource .getReport() response = {}", rs);
        return rs;
    }

    @PostMapping("/save-record")
    @Operation(summary = "Сохранить запись")
    public String saveRecord(@RequestBody Record record) throws IOException {

        Payment payment1 = new Payment().setName("payment1");
        Payment payment2 = new Payment().setName("payment2");

        Record a = new Record().setName("a")
                .setPayments(List.of(payment1, payment2));

        repository.save(a);
        return a.toString();
    }

}
