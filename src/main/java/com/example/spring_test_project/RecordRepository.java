/*
 * VTB Group. Do not reproduce without permission in writing.
 * Copyright (c) 2024 VTB Group. All rights reserved.
 */

package com.example.spring_test_project;

import com.example.spring_test_project.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksandr_Berestov
 */
public interface RecordRepository extends JpaRepository<Record, Long> {

}
