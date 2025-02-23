/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.export;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.http.ResponseEntity;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ExportFullResponse {

    private String fullResponse;
    private ResponseEntity<byte[]> responseEntity;

}
