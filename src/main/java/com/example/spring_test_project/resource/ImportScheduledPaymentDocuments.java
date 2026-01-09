package com.example.spring_test_project.resource;

import com.example.spring_test_project.common.ReportType;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aleksandr_Berestov
 */
public interface ImportScheduledPaymentDocuments {

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить отчет импорта")
    @GetMapping(value = "/import/report", produces = MediaType.APPLICATION_PDF_VALUE)
    ResponseEntity<byte[]> getReport(@RequestParam String sessionId, @RequestParam ReportType reportType);

}

