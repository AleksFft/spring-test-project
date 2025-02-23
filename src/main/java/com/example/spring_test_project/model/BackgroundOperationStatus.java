/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.model;

import org.apache.commons.lang3.BooleanUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Aleksandr_Berestov
 */
public enum BackgroundOperationStatus {

    NEW(true),
    IN_PROGRESS(true),
    DONE(false),
    IN_INTERRUPT_PROCESS(true),
    INTERRUPTED(false),
    CANCELED(false),
    ERROR(false);

    private final boolean isActiveOperation;
    public static final List<BackgroundOperationStatus> ACTIVE_OPERATION_STATUSES = (List) Arrays.stream(values()).filter((status) -> {
        return status.isActiveOperation;
    }).collect(Collectors.toList());
    public static final List<BackgroundOperationStatus> FINISHED_OPERATION_STATUSES = (List)Arrays.stream(values()).filter((status) -> {
        return !status.isActiveOperation;
    }).collect(Collectors.toList());

    public static List<BackgroundOperationStatus> getStatusesByActiveFlag(Boolean isActiveOperation) {
        Objects.requireNonNull(isActiveOperation, "IsActiveOperation cannot be NULL");
        return BooleanUtils.isTrue(isActiveOperation) ? ACTIVE_OPERATION_STATUSES : FINISHED_OPERATION_STATUSES;
    }

    public boolean isActiveOperation() {
        return this.isActiveOperation;
    }

    private BackgroundOperationStatus(boolean isActiveOperation) {
        this.isActiveOperation = isActiveOperation;
    }
}
