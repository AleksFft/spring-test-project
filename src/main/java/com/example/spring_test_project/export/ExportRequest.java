/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.export;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Schema(description = "Запрос на экспорт")
public class ExportRequest {

    @Schema(description = "Формат экспортируемого файла")
    private RuleExportFormat exportFormat;

    @Schema(description = "Список идентификаторов правил для экспорта")
    private List<Long> ruleIds = new ArrayList<>();
}
