package com.example.spring_test_project.resource;

import com.example.spring_test_project.common.ReportType;
import com.example.spring_test_project.model.BcMarkupDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Aleksandr_Berestov
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class ImportScheduledPaymentDocumentsResourceImpl implements ImportScheduledPaymentDocumentsApi, ImportScheduledPaymentDocuments {

    @Override
    public ResponseEntity<byte[]> getReport(String sessionId, ReportType reportType) {
        return null;
    }

    @Override
    public ResponseEntity<String> callImport(String taskId, BcMarkupDto importRequestDto) {
        return null;
    }

}
