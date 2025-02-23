/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Aleksandr_Berestov
 */
@ToString
@Getter
@Setter
@Accessors(chain = true)
@Schema(description = "Модель, содержащая рассчитанный приоритет и правило с высшим и низшим приоритетом")
public class BcAnalyticImportResultDto implements Serializable {

    @Schema(description = "Количество импортируемых документов")
    private int count;

    @Schema(description = "Количество корректных импортируемых документов")
    private int correctCount;

    @Schema(description = "Количество импортируемых документов с ошибкой")
    private int errorCount;

    @Schema(description = "Идентификатор процесса импорта")
    private String sessionId;

    @Schema(description = "Дата импорта")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate importDate;

}