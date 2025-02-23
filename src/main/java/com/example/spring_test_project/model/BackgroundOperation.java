/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Aleksandr_Berestov
 */
@Entity
@Table(
        name = "background_operations"
)
@Accessors(chain = true)
@Getter
@Setter
@ToString
public class BackgroundOperation {

    @Id
    @Column(
            name = "id",
            nullable = false
    )
    private UUID id = UUID.randomUUID();

    @Column(
            name = "total"
    )
    private int total;

    @Column(
            name = "completed"
    )
    private int completed;

    @Column(
            name = "status",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private BackgroundOperationStatus status;

}
