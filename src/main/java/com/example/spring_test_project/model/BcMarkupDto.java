/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class BcMarkupDto {

    private List<Long> docIds;
    private String name;
}
