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
public enum RuleAuthorDto {
    CLIENT("Клиент"),
    BANK("Банк");

    private final String ruleAuthor;

    public static RuleAuthorDto get(String value) {
        return Arrays.stream(RuleAuthorDto.values())
                .filter(v -> v.ruleAuthor.equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }
}

