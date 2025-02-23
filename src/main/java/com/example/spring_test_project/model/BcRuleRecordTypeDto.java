/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author Aleksandr_Berestov
 */
public enum BcRuleRecordTypeDto {

    @Schema(description = "Обычное/нормальное правило")
    NORMAL,

    @Schema(description = "Неопределенное правило")
    NOT_UNDEFINED,

    @Schema(description = "Общее правило")
    COMMON
}
