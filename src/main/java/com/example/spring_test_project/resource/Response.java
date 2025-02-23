/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Реализация ответа.
 *
 * @param <T> Response body
 * @author Aleksandr_Berestov
 */
@Slf4j
@Getter
@Setter
public class Response<T> {

    private T data;
    private String message;
    private int status;

    public static <T> Response<T> of(T data) {

        log.info("ResponseImpl data = {}", data);
        Response<T> objectResponse = new Response<>();
        objectResponse.setData(data);
        return objectResponse;
    }

    public ResponseEntity<Response<T>> toResponseEntity() {

        HttpStatus responseStatus = HttpStatus.OK;

        return ResponseEntity.status(responseStatus).body(this);
    }

}

