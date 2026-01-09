package com.example.spring_test_project.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@RequiredArgsConstructor
public enum ReportType {
    SCHEDULED_PAYMENT_DOCUMENT_VALIDATE_AND_PARSE(
            "Отчет системы ДБО о результатах проверки импортируемых плановых документов",
            "%s Отчет по результатам проверки файлов импорта из 1С в Плановый документ.pdf"),
    SCHEDULED_PAYMENT_DOCUMENT_IMPORT(
            "Отчет системы ДБО о результатах импорта плановых документов",
            "%s Отчет по результатам импорта файлов из 1С в Плановый документ.pdf");

    /**
     * Заголовок файла отчета.
     */
    private final String title;

    /**
     * Паттерн имени файла отчета.
     */
    private final String filenamePattern;
}
