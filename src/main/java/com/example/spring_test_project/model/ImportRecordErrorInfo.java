/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImportRecordErrorInfo {

    @Column(name = "field")
    private String field;

    @Column(name = "message")
    private String message;

    @Column(name = "error_type")
    @Enumerated(EnumType.STRING)
    private ImportRecordErrorType errorType;

    @Column(name = "hint")
    private String hint;

}
