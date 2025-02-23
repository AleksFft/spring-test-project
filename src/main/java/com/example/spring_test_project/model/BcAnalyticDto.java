/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

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
@Accessors(chain = true)
public class BcAnalyticDto {

    private Long id;

    private List<ImportDetailsDto> importDetails = new ArrayList<>();

}
