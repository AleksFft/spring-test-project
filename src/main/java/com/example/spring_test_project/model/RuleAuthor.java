/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@RequiredArgsConstructor
public enum RuleAuthor {
    CLIENT("Клиент"),
    BANK("Банк");

    private final String ruleAuthor;
}

