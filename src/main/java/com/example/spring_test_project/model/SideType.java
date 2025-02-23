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
public enum SideType {
    DEBIT("Д"),
    CREDIT("К");

    private final String side;

    public static SideType get(String value) {
        return Arrays.stream(SideType.values())
                .filter(val -> val.side.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

}