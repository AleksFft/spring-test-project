/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project.repository;

import com.example.spring_test_project.model.BackgroundOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Aleksandr_Berestov
 */
public interface BackgroundOperationRepository extends JpaRepository<BackgroundOperation, UUID> {

}
