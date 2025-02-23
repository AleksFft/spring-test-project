/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@Accessors(chain = true)
public class ImportRecordErrorInfoDto {
    private String field;
    private String message;
    private ImportRecordErrorTypeDto errorType;
    private String hint;
}

