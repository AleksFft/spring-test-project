/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.resource;

import com.example.spring_test_project.model.BackgroundOperation;
import com.example.spring_test_project.service.BgoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Aleksandr_Berestov
 */
@Slf4j
@RestController
@RequestMapping(value = "api/bgo")
@Tag(name = "Фоновые операции")
public class BgoResource {

    @Autowired
    BgoService bgoService;

    @PostMapping("/start")
    @Operation(summary = "startTask")
    BackgroundOperation startTask() {
        return bgoService.startTask();
    }

    @PostMapping("/execute/{id}")
    @Operation(summary = "executeBgo")
    BackgroundOperation executeBgo(@PathVariable String id) throws InterruptedException {
        return bgoService.execute(UUID.fromString(id));
    }

    @PostMapping("/interrupt/{id}")
    @Operation(summary = "interrupt")
    String interrupt(@PathVariable String id) {
        return bgoService.interrupt(UUID.fromString(id)).getStatus().name();
    }

}
