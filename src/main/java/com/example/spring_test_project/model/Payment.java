/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author Aleksandr_Berestov
 */
@Getter
@Setter
@ToString
@Embeddable
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private String name;

}
