/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@RequiredArgsConstructor
public enum SideTypeDto {

    DEBIT("Дебет"),
    CREDIT("Кредит");

    private final String sideFullText;

    public static SideTypeDto getByFullText(String value) {
        return Arrays.stream(SideTypeDto.values())
                .filter(v -> v.sideFullText.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
