/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.resource;

import com.example.spring_test_project.model.BcAnalyticDto;
import com.example.spring_test_project.model.BcMarkupDto;
import com.example.spring_test_project.model.ImportDetails;
import com.example.spring_test_project.service.BcAnalyticServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@RestController
@RequestMapping(value = "api/bc-analytics")
@RequiredArgsConstructor
public class BcAnalyticResource {

    private final BcAnalyticServiceImpl service;

    @PostMapping("/save")
    Long exportBcRule1() {
        return service.save();
    }

    @PostMapping("/get-all")
    List<BcAnalyticDto> getAll() {
        return service.getAll();
    }

    @PostMapping("/execute")
    List<ImportDetails> execute(@RequestBody BcMarkupDto dto) {
        return service.executeMarkup(dto);
    }

    @PostMapping("/executeV1")
    String executev1(String dto) {
        return "you";
    }

    @PostMapping("/executeV2")
    String executev2(String dto) {
        return dto;
    }

    @PostMapping("/executeV3")
    String executev3(@RequestParam("dto") String dto) {
        return dto;
    }

}
