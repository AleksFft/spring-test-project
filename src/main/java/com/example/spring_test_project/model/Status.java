/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2025 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@RequiredArgsConstructor
public enum Status {
    SUCCESS("Успешно"),
    DOCUMENT_NOT_FOUND("Документ не найден"),
    MORE_THAN_ONE_DOCUMENT_FOUND("Найдено больше одного документа"),
    DOCUMENT_IN_WRONG_STATUS("Документ в неверном статусе"),
    CODE_BC_NOT_FOUND_IN_DIRECTORY("Код БК не найден в справочнике"),
    ABILITY_TO_ADJUST_MARKUP_IS_DISABLED("Отключена возможность корректировки разметки"),
    DETAILS_ERROR("Ошибка реквизитов"),
    MATCHING_NEW_AND_OLD_BC_CODE("Совпадение нового и старого кода БК"),
    NO_DATA_TO_IMPORT("Отсутствуют данные для импорта"),
    MATCHING_OF_NEW_AND_OLD_VALUES("Совпадение новых и старых значений"),
    EXCEEDING_THE_OPERATION_DATE_LIMIT("Превышение ограничения по дате операции");

    private final String message;

    public static List<Status> errorStatuses() {
        return Arrays.stream(Status.values())
                .filter(s -> s != SUCCESS)
                .filter(s -> s != EXCEEDING_THE_OPERATION_DATE_LIMIT)
                .collect(Collectors.toList());
    }
}
