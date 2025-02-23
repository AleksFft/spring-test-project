/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@Accessors(chain = true)
public class ImportDetailsDto {

    private Long id;

    private String sessionId;

    private Set<BcAnalyticDto> bcAnalytics = new HashSet<>();

}
