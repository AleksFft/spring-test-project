/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.importation;

import com.example.spring_test_project.model.BcRuleRecordDto;
import com.example.spring_test_project.model.RuleAuthorDto;
import com.example.spring_test_project.model.SideTypeDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@Component
public class BcRuleCsvParser {

    private static final String[] HEADERS =
            {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};

    public List<BcRuleRecordDto> parse(MultipartFile file) {
        try (Reader reader = new InputStreamReader(new ByteArrayInputStream(file.getBytes()))) {
            CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader());
            List<String> headerNames = csvParser.getHeaderNames();

            return csvParser.getRecords().stream()
                    .skip(2)
                    .map(row -> mapRow(row, headerNames))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            String msg = "Ошибка во время обработки файла";
            log.error(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    private BcRuleRecordDto mapRow(CSVRecord row, List<String> headers) {
        BcRuleRecordDto dto;
        if (headers.size() == 16) {
            dto = map16fieldsFormatF3(row, headers);
        } else if (headers.size() == 19) {
            dto = map19fieldsFormatF1(row, headers);
        } else if (headers.size() == 20) {
            dto = map20fieldsFormatF2(row, headers);
        } else {
            throw new RuntimeException("No found rule parser for file with count headers = " + headers.size());
        }

        return dto;
    }

    private BcRuleRecordDto map16fieldsFormatF3(CSVRecord row, List<String> headers) {
        short cellNum = 0;
        return new BcRuleRecordDto()
                .setBankBic(emptyStringWrap(row.get(headers.indexOf(HEADERS[cellNum]))))
                .setBankName(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setClientName(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setClientInn(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setAccountNumber(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setErpId(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setRuleNumber(longValueWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setBcCode(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setRuleName(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setBankBicContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setAccountContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setNameContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setInnContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setPaymentDetails(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setExtBudgetCode(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setOperTypeCode(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setErrorData(new ArrayList<>());
    }

    private BcRuleRecordDto map19fieldsFormatF1(CSVRecord row, List<String> headers) {
        short cellNum = 15;
        BcRuleRecordDto dto = map16fieldsFormatF3(row, headers);
        dto
                .setSide(side(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum])))))
                .setPaymentInternal(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setRuleAuthor(ruleAuthor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum])))));
        return dto;
    }

    private BcRuleRecordDto map20fieldsFormatF2(CSVRecord row, List<String> headers) {
        short cellNum = 0;
        return new BcRuleRecordDto()
                .setBankBic(emptyStringWrap(row.get(headers.indexOf(HEADERS[cellNum]))))
                .setBankName(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setClientName(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setClientInn(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setAccountNumber(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setRuleNumber(longValueWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setBcCode(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setRuleName(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setBankBicContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setAccountContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setNameContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setInnContractor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setPaymentDetails(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setExtBudgetCode(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setOperTypeCode(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setSide(side(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum])))))
                .setPaymentInternal(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum]))))
                .setRuleAuthor(ruleAuthor(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum])))))
                //SIRIUSM-1052 игнорирование приоритета правила
                .setDocumentExecutionState(emptyStringWrap(row.get(headers.indexOf(HEADERS[++cellNum + 1]))))
                .setErrorData(new ArrayList<>());
    }

    private SideTypeDto side(String side) {
        return SideTypeDto.getByFullText(side);
    }

    private RuleAuthorDto ruleAuthor(String author) {
        return RuleAuthorDto.get(author);
    }

    private Long longValueWrap(String value) {
        return StringUtils.isBlank(value)
                ? null
                : Long.valueOf(value);
    }

    private String emptyStringWrap(String value) {
        return StringUtils.isBlank(value)
                ? null
                : value;
    }

}
