/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Aleksandr_Berestov
 */
@RequiredArgsConstructor
public enum Currency {
    RUB("RUB", "RUR"),
    EUR("EUR", "dummy"),
    USD("USD", "dummy");

    private final String code1;
    private final String code2;

    public static Currency get(String value) {
        return Arrays.stream(Currency.values())
                .filter(v -> v.code1.equalsIgnoreCase(value) || v.code2.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}
